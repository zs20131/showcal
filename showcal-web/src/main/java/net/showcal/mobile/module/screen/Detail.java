package net.showcal.mobile.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen.showcal
 *  Description:瘦咖主页
 * ***************************************************************
 *  9/24 0024  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.showcal
 * </pre>
 */
public class Detail {
    @Autowired
    private HttpServletRequest request;

    public void execute(Context context, @Param("id") Long id) {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
    }
}
