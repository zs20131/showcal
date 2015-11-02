package net.showcal.platform.context;

import com.alibaba.citrus.service.uribroker.URIBrokerService;
import com.alibaba.citrus.service.uribroker.uri.URIBroker;
import com.alibaba.citrus.springext.support.BeanSupport;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.pipeline.valve.PageAuthorizationValve;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.platform.request.PassportGetRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.PassportGetResponse;
import com.showcal.platform.response.SysUserGetResponse;
import com.showcal.platform.service.PlatformService;
import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.security.Passport;
import net.showcal.tool.Constants;
import net.showcal.tool.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.alibaba.citrus.util.Assert.assertNotNull;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.single.base.context
 *  Description:用户登录验证
 * ***************************************************************
 *  7/30 0030  V1.0  xiniu    New Files for com.xiniunet.single.base.context
 * </pre>
 */
public class BaseUserAuth extends BeanSupport implements PageAuthorizationValve.Callback<BaseUserAuth.Status> {
    @Autowired
    private PlatformService platformService;
    @Autowired
    private FoundationService foundationService;
    @Autowired
    private URIBrokerService uriBrokerService;
    //    @Autowired
//    private Context context;
    private String brokerId;
    private String returnKey;

    @Override
    public String getUserName(Status status) {
        return status.passport != null ? status.passport.getUserName() : "anonymous";
    }

    @Override
    public String[] getRoleNames(Status status) {
        Passport passport = status.passport;
        String userType = "";
        if (passport != null) {
            if (PassportTypeEnum.SUPPLIER.equals(passport.getType())) {
                userType = UserTypeEnum.SHOWCAL.toString();
            }
            if (PassportTypeEnum.EMPLOYEE.equals(passport.getType())) {
                userType = UserTypeEnum.PLADMIN.toString();
            }
        }
        return new String[]{userType};
    }

    @Override
    public String[] getActions(Status status) {
        return null;
    }

    @Override
    public Status onStart(TurbineRunData rundata) throws Exception {
        Cookie cookie = this.getCookieByName(rundata.getRequest(), Constants.SESSION_NAME);
        Passport passport = new Passport();
        String passportId = "";
        HttpServletRequest request = rundata.getRequest();
        passportId = request.getParameter("passportid");
        if(passportId==null||"".equals(passportId)){
            if (cookie != null && !"".equals(cookie.getValue())) {
                passportId = cookie.getValue();
            }
        }
        if (passportId != null && !"".equals(passportId)) {
//            if (cookie == null) {
//                cookie = new Cookie(Constants.SESSION_NAME, passportId);
//                cookie.setPath("/");
//                cookie.setMaxAge(-1);
//                rundata.getResponse().addCookie(cookie);
//            }
            if (SessionUtil.hasCahce(passportId)) {
                passport = SessionUtil.get(passportId);
            } else {
                PassportGetRequest passportGetRequest = new PassportGetRequest();
                passportGetRequest.setId(Long.valueOf(passportId));
                PassportGetResponse passportGetResponse = platformService.getPassport(passportGetRequest);
                if (passportGetResponse != null && passportGetResponse.getPassport() != null) {
                    passport = passportGetResponse.getPassport();
                    String url = this.getUrl(passport);
                    passport.setAvatar(url);
                    SessionUtil.put(passport);
                }
            }
        }
        return new Status(rundata, passport);
    }

    /**
     * 权限验证通过
     *
     * @param status
     * @throws Exception
     */
    @Override
    public void onAllow(Status status) throws Exception {
        HttpServletRequest request = status.rundata.getRequest();
        if (!request.getRequestURI().startsWith("/mobile")
                && !request.getRequestURI().startsWith("/login")
                && !request.getRequestURI().startsWith("/home")
                && !request.getRequestURI().startsWith("/api")
                ) {
            if (status.passport == null || status.passport.getId() == null) {
                HttpServletResponse response = status.rundata.getResponse();
                response.sendRedirect("/login");
            }
        }
        request.setAttribute("passport", status.passport);
//        if(memberRoleMap!=null&&!memberRoleMap.isEmpty()&&status.passport!=null){
//            request.setAttribute("ROLE",memberRoleMap.get(status.passport.getId()));
//        }
//        if(request.getRequestURI().startsWith("/member/admin/publishresource")&&!"SENIORMEMBER".equals(memberRoleMap.get(status.passport.getId()))){
//            HttpServletResponse response = status.rundata.getResponse();
//            response.sendRedirect("../../403.html");
//        }
//        context.put("passport",status.passport);
//        System.out.println(request.getRequestURI());
    }


    @Override
    protected void init() throws Exception {
        assertNotNull(uriBrokerService, "could not get URIBrokerService");
        if (brokerId == null) {
            brokerId = Constants.BASE_LOGIN_LINK;
        }
        if (returnKey == null) {
            returnKey = Constants.LOGIN_RETURN_KEY;
        }
    }

    /**
     * 权限验证失败
     *
     * @throws Exception
     */
    @Override
    public void onDeny(Status status) throws Exception {
        //失败有两种情况1 未登陆,2 权限不够
        HttpServletResponse response = status.rundata.getResponse();
        if (status.passport == null) {
            //未登陆，跳转至登陆页面
            URIBroker redirectURI = uriBrokerService.getURIBroker(Constants.BASE_LOGIN_LINK);
            response.sendRedirect(redirectURI.render());
        }
        //其他，权限不够,需要跳转至无权限页面
        response.sendRedirect("../../403.html");
    }

    public Cookie getCookieByName(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    static class Status {
        private final TurbineRunData rundata;
        private Passport passport;

        public Status(TurbineRunData rundata, Passport passport) {
            this.rundata = rundata;
            this.passport = passport;
        }
    }

    public String getUrl(Passport passport) {
        String url = "";
        SysUserGetRequest getRequest = new SysUserGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserGetResponse userGetResponse = platformService.getSysUser(getRequest, passport);
        UserInfo user = userGetResponse.getSysUser();
        if (user.getAvatarurl() != null) {
            url = user.getAvatarurl();
        } else {
            if (user.getSex() != null) {
                if (user.getSex().equals(SexEnum.FEMALE)) {
                    url = "../images/girl.png";
                } else if (user.getSex().equals(SexEnum.MALE)) {
                    url = "../images/boy.png";
                }
            } else {
                url = "../images/girl.png";
            }
        }
        return url;
    }
}
