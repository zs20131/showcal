package net.showcal.mobile.module.screen.login.findpassword;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.showcal.platform.request.UserExistByMobileRequest;
import com.showcal.platform.response.UserExistByMobilePhoneResponse;
import com.showcal.platform.service.PlatformService;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen.findpassword
 *  Description:
 * ***************************************************************
 *  9/29 0029  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.findpassword
 * </pre>
 */
public class Step2 {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PlatformService platformService;

    public void execute(Context context, @Param("mobilePhone") String mobilePhone) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        if (mobilePhone != null && !"".equals(mobilePhone)) {
            UserExistByMobileRequest existByMobileRequest = new UserExistByMobileRequest();
            existByMobileRequest.setMobilePhone(mobilePhone);
            UserExistByMobilePhoneResponse response = platformService.userExistByMobilePhone(existByMobileRequest, passport);
            if (response != null && response.getIsExist()) {
                context.put("userId",response.getUserId());
            }

        }
        context.put("mobilePhone", mobilePhone);
    }
}
