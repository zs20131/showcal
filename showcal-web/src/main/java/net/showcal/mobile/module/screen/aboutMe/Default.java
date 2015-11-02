package net.showcal.mobile.module.screen.aboutMe;

import com.alibaba.citrus.turbine.Context;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen.aboutMe
 *  Description:
 * ***************************************************************
 *  10/23 0023  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.aboutMe
 * </pre>
 */
public class Default {
    @Autowired
    private HttpServletRequest request;

    public void execute(Context context) throws Exception {
        // 得到当前登陆人
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
}
}
