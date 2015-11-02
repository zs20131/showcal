package net.showcal.home.module.screen;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.platform.domain.VerificationTypeEnum;
import com.showcal.platform.request.LoginRequest;
import com.showcal.platform.request.UserExistByMobileRequest;
import com.showcal.platform.request.VerificationCheckRequest;
import com.showcal.platform.request.VerificationCodeCreateRequest;
import com.showcal.platform.response.LoginResponse;
import com.showcal.platform.response.UserExistByMobilePhoneResponse;
import com.showcal.platform.response.VerificationCheckResponse;
import com.showcal.platform.response.VerificationCodeCreateResponse;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.tool.Constants;
import net.showcal.tool.SMSTool;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.home.module.screen
 *  Description:
 * ***************************************************************
 *  9/22 0022  V1.0  xiniu    New Files for net.showcal.home.module.screen
 * </pre>
 */
public class Api {
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private BufferedRequestContext brc;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PlatformHelper platformHelper;
    public void execute(@Param("method") String method) throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        try {
            // 必须关闭buffering，未完成的页面才会被显示在浏览器上。
            brc.setBuffering(false);
            // 设置content type，但不需要设置charset，框架会设置正确的charset。
            response.setContentType("text/plain");
            method = method.toLowerCase();
            Passport passport = (Passport) request.getAttribute("passport");
            InputStreamReader isr = new InputStreamReader(request.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            String line = in.readLine();
            JSONObject jsonObject = JSON.parseObject(line);

            switch (method) {
                // 根据Id获取基础热量设置
                case "api.mobile.login":
                    baseResponse = doMobileLogin(jsonObject, passport);
                    break;
                // 模糊查询用户
                case "api.mobile.verfiycode.get":
                    baseResponse = getVerfiycode(jsonObject, passport);
                    break;
                case "api.mobile.code.velidate":
                    PrintWriter out = response.getWriter();
                    out.println(apiVelidateCode(jsonObject, passport));
                    break;
                //验证手机号码是否被占用
                case "api.mobile.mobile.velidate":
                    out = response.getWriter();
                    out.println(apiVelidateMobilePhone(jsonObject, passport));
                    break;
                //验证手机号码是否存在
                case "api.mobile.mobileexist.velidate":
                    out = response.getWriter();
                    out.println(apiVelidateMobilePhoneExist(jsonObject, passport));
                    break;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(ex));
        } finally {
            String jsonTenant = JSON.toJSONString(baseResponse);
            PrintWriter out = response.getWriter();
            out.println(jsonTenant);
        }
    }

    /**
     * 创建验证码 并发送短信
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse getVerfiycode(JSONObject jsonObject, Passport passport) {
        String mobilePhone = jsonObject.getString("mobilePhone");

        VerificationCodeCreateRequest codeCreateRequest = new VerificationCodeCreateRequest();
        codeCreateRequest.setUserId(10000000000L);
        codeCreateRequest.setVerificationType(VerificationTypeEnum.MOBILE);
        codeCreateRequest.setObject(mobilePhone);
        VerificationCodeCreateResponse codeCreateResponse = new VerificationCodeCreateResponse();
        // 判断手机号是否已被注册
        boolean isExist = apiVelidateMobilePhoneExist(jsonObject, passport);
        if(isExist){
            codeCreateResponse.addError(ErrorType.BUSINESS_ERROR,"该手机号码已被注册！");
            return codeCreateResponse;
        }

        codeCreateResponse =  platformHelper.createVerificationCode(codeCreateRequest);

        // 发送短信息
        if(codeCreateResponse!=null&&!codeCreateResponse.hasError()&&mobilePhone!=null&&!"".equals(mobilePhone)){
            String  message = "云地网提醒您：您的短信验证码为["+codeCreateResponse.getVerificationCode()+"]";
//            SMSTool.getInstance().SendMsg(message,mobilePhone);
            System.out.println(message);
        }
        return codeCreateResponse;
    }

    private boolean apiVelidateMobilePhoneExist(JSONObject jsonObject, Passport passport) {
        UserExistByMobileRequest request1 = new UserExistByMobileRequest();
        request1.setMobilePhone(jsonObject.getString("mobilePhone"));
        UserExistByMobilePhoneResponse response1 = platformHelper.userExistByMobilePhone(request1, passport);
        if(response1==null&&response1.getIsExist()==null){
            return false;
        }
        return response1.getIsExist();
    }

    private boolean apiVelidateMobilePhone(JSONObject jsonObject, Passport passport) {
        UserExistByMobileRequest request1 = new UserExistByMobileRequest();
        request1.setMobilePhone(jsonObject.getString("mobilePhone"));
        UserExistByMobilePhoneResponse response1 = platformHelper.userExistByMobilePhone(request1, passport);
        if(response1==null&&response1.getIsExist()==null){
            return false;
        }
        return !response1.getIsExist();
    }

    private Boolean apiVelidateCode(JSONObject jsonObject, Passport passport) {
        VerificationCheckRequest checkRequest = new VerificationCheckRequest();
        checkRequest.setObject(jsonObject.getString("mobilePhone"));
        checkRequest.setCode(jsonObject.getString("code"));
        checkRequest.setType(VerificationTypeEnum.MOBILE);
        VerificationCheckResponse response =  platformHelper.checkValification(checkRequest);
        boolean issuccess = false;
        if(response==null&&response.getIsVerificated()==null){
            return false;
        }
        return response.getIsVerificated();
    }


    /**
     * 手机端登录
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse doMobileLogin(JSONObject jsonObject, Passport passport) {
        LoginRequest loginRequest = JSON.toJavaObject(jsonObject,LoginRequest.class);
        loginRequest.setIp(getIpAddr(request));
        LoginResponse loginResponse = platformHelper.login(loginRequest);
        passport = loginResponse.getPassport();
        //将passport信息写入session
        if(passport!=null){
            addCookie(response, Constants.SESSION_NAME,String.valueOf(passport.getId()),-1);
        }
        return loginResponse;
    }

    public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        if(maxAge>0)  cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
