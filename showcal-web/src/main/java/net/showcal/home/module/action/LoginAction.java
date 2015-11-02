package net.showcal.home.module.action;

import com.alibaba.citrus.service.requestcontext.parser.ParameterParser;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.StringUtil;
import com.showcal.platform.request.LoginRequest;
import com.showcal.platform.response.LoginResponse;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.security.Passport;
import net.showcal.home.domain.LoginDomain;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.tool.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.platform.module.action
 *  Description: 系统登录
 * ***************************************************************
 *  7/25 0025  V1.0  xiniu    New Files for net.showcal.platform.module.action
 * </pre>
 */
public class LoginAction {
    @Autowired
    private PlatformHelper platformHelper;

    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpServletRequest request;

    private Passport passport = new Passport();

    public void doLogin(@FormGroup("login") LoginDomain loginDomain, Navigator nav, Context context, ParameterParser params) {
        try {
            String account = loginDomain.getAccount();
            String password = loginDomain.getPassword();
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setAccount(account);
            loginRequest.setPassword(password);
            loginRequest.setIp(getIpAddr(request));
            LoginResponse loginResponse = platformHelper.login(loginRequest);
            if (loginResponse==null||loginResponse.hasError()) {
                context.put("errorMsg", "登陆失败," + loginResponse.getErrors().get(0).getMessage() + "!");
                return;
            }
            passport = loginResponse.getPassport();
            //判断用户类型，是否是可登录类型
            if(PassportTypeEnum.MEMBER.equals(passport.getType())){
                context.put("errorMsg", "您不是瘦咖或者平台管理员，不可以登录");
                return ;
            }
            //将passport信息写入session
            addCookie(response, Constants.SESSION_NAME, String.valueOf(passport.getId()), -1);
            redirectToReturnPage(nav, params);
        } catch (Exception e) {
            e.printStackTrace();
            context.put("errorMsg", "登陆失败，系统异常!");
        }
    }

    private void redirectToReturnPage(Navigator nav, ParameterParser params) {
        String returnURL = params.getString("return");
        if (StringUtil.isEmpty(returnURL)) {
            if (PassportTypeEnum.SUPPLIER.equals(passport.getType())) {
                //会员跳转至瘦咖页面
                nav.redirectToLocation("/showcal/dashboard/index");
            } else {
                nav.redirectToLocation("/platform/index");
            }
        } else {
            nav.redirectToLocation(returnURL);
        }
    }

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }


    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
