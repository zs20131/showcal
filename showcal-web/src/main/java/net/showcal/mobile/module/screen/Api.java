package net.showcal.mobile.module.screen;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.platform.domain.VerificationTypeEnum;
import com.showcal.platform.request.*;
import com.showcal.platform.response.UserExistByMobilePhoneResponse;
import com.showcal.platform.response.VerificationCheckResponse;
import com.showcal.platform.response.VerificationCodeCreateResponse;
import com.showcal.service.domain.MessageTypeEnum;
import com.showcal.service.request.QuestionCreateRequest;
import com.showcal.service.service.ShowcalService;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.tool.Constants;
import net.showcal.tool.ONSMessageSend;
import net.showcal.tool.SMSTool;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen
 *  Description:
 * ***************************************************************
 *  9/21 0021  V1.0  xiniu    New Files for net.showcal.mobile.module.screen
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
    @Autowired
    private ShowcalService showcalService;

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
                case "api.mobile.user.register":
                    baseResponse = apiRegisterUser(jsonObject, passport);
                    break;
                case "api.mobile.question.send":
                    baseResponse = apiSendQuestion(jsonObject, passport);
                    break;
                //更新手机号码
                case "api.mobile.mobilephone.change":
                    baseResponse = apiChangeMobilePhone(jsonObject, passport);
                    break;
                case "api.mobile.password.change":
                    baseResponse = apiChangePassword(jsonObject, passport);
                    break;

                default:
                    baseResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_METHOD);
                    break;
            }
        } catch (Exception ex) {
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(ex));
            ex.printStackTrace();
        } finally {
            if (!"api.mobile.mobile.velidate".equals(method) && !"api.mobile.mobileexist.velidate".equals(method) && !"api.mobile.code.velidate".equals(method)) {
                String jsonTenant = JSON.toJSONString(baseResponse);
                PrintWriter out = response.getWriter();
                out.println(jsonTenant);
            }
        }
    }


    /**
     * 修改密码，手机端
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiChangePassword(JSONObject jsonObject, Passport passport) {
        LoginPasswordModifyRequest modifyRequest = new LoginPasswordModifyRequest();
        modifyRequest.setId(jsonObject.getLong("userId"));
        modifyRequest.setLoginPassword(jsonObject.getString("password"));
        return platformHelper.modifyLoginPassword(modifyRequest, passport);
    }

    /**
     * 更新手机号码
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiChangeMobilePhone(JSONObject jsonObject, Passport passport) {
        SysUserUpdateRequest userUpdateRequest = new SysUserUpdateRequest();
        String mobilePhone = jsonObject.getString("mobilePhone");
        userUpdateRequest.setAccount(mobilePhone);
        userUpdateRequest.setMobilePhone(mobilePhone);
        userUpdateRequest.setId(passport.getUserId());
        return platformHelper.updateSysUser(userUpdateRequest, passport);
    }

    /**
     * 发送问题
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiSendQuestion(JSONObject jsonObject, Passport passport) {
        QuestionCreateRequest createRequest = JSON.toJavaObject(jsonObject, QuestionCreateRequest.class);
        BaseResponse baseResponse = new BaseResponse();
        createRequest.setContent(jsonObject.getString("Content"));
        // 有问题，发送文字
        if (createRequest.getContent() != null && !"".equals(createRequest.getContent())) {
            createRequest.setType(MessageTypeEnum.TEXT);
            baseResponse = showcalService.sendQuestion(createRequest, passport);
        }
        // 如果有图片功能，发送图片
        if (jsonObject.getString("url") != null && !"".equals(jsonObject.getString("url"))) {
            createRequest.setTag(null);
            createRequest.setUrl(jsonObject.getString("url"));
            createRequest.setType(MessageTypeEnum.PICTURE);
            baseResponse = showcalService.sendQuestion(createRequest, passport);
        }
        return baseResponse;
    }

    /**
     * 注册用户
     *
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse apiRegisterUser(JSONObject jsonObject, Passport passport) {
        SysUserCreateRequest createrequest = JSON.toJavaObject(jsonObject, SysUserCreateRequest.class);
        createrequest.setUserType(UserTypeEnum.USER);
        createrequest.setNickName(createrequest.getAccount());
        passport.setUserId(000001L);
        passport.setUserName("系统注册");
        return platformHelper.createSysUser(createrequest, passport);
    }


    /**
     * 创建验证码 并发送短信
     *
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
        if (isExist) {
            codeCreateResponse.addError(ErrorType.BUSINESS_ERROR, "该手机号码已被注册！");
            return codeCreateResponse;
        }

        codeCreateResponse = platformHelper.createVerificationCode(codeCreateRequest);

        // 发送短信息
        if (codeCreateResponse != null && !codeCreateResponse.hasError() && mobilePhone != null && !"".equals(mobilePhone)) {
            String message = "【瘦咖健康】提醒您：您的短信验证码为 " + codeCreateResponse.getVerificationCode() + "";
//            SMSTool.getInstance().SendMsg(message,mobilePhone);
            ONSMessageSend.sendSms(mobilePhone, message);
            System.out.println(message);
        }
        return codeCreateResponse;
    }

    private boolean apiVelidateMobilePhoneExist(JSONObject jsonObject, Passport passport) {
        UserExistByMobileRequest request1 = new UserExistByMobileRequest();
        request1.setMobilePhone(request.getParameter("mobilePhone"));
        UserExistByMobilePhoneResponse response1 = platformHelper.userExistByMobilePhone(request1, passport);
        if (response1 == null && response1.getIsExist() == null) {
            return false;
        }
        return response1.getIsExist();
    }

    private boolean apiVelidateMobilePhone(JSONObject jsonObject, Passport passport) {
        UserExistByMobileRequest existByMobileRequest = new UserExistByMobileRequest();
        existByMobileRequest.setMobilePhone(request.getParameter("mobilePhone"));
        UserExistByMobilePhoneResponse existByMobilePhoneResponse = platformHelper.userExistByMobilePhone(existByMobileRequest, passport);
        if (existByMobilePhoneResponse == null && existByMobilePhoneResponse.getIsExist() == null) {
            return false;
        }
        return !existByMobilePhoneResponse.getIsExist();
    }

    private Boolean apiVelidateCode(JSONObject jsonObject, Passport passport) {
        VerificationCheckRequest checkRequest = new VerificationCheckRequest();
        checkRequest.setObject(request.getParameter("mobilePhone"));
        checkRequest.setCode(request.getParameter("validatecode"));
        checkRequest.setType(VerificationTypeEnum.MOBILE);
        VerificationCheckResponse response = platformHelper.checkValification(checkRequest);
        boolean issuccess = false;
        if (response == null && response.getIsVerificated() == null) {
            return false;
        }
        return response.getIsVerificated();
    }
}

