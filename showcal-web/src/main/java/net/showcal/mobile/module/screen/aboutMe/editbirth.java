package net.showcal.mobile.module.screen.aboutMe;

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
 *  Title: net.showcal.mobile.module.screen.aboutMe
 *  Description:
 * ***************************************************************
 *  10/24 0024  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.aboutMe
 * </pre>
 */
public class editbirth {
    @Autowired
    private HttpServletRequest request;

    public void execute(Context context,@Param("birthday") String birthday) throws Exception {
        // 得到当前登陆人
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
        context.put("birthday",birthday);
    }
}
