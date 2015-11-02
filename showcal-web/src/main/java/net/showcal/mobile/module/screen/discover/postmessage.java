package net.showcal.mobile.module.screen.discover;

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
 *  Title: net.showcal.mobile.module.screen.discover
 *  Description:
 * ***************************************************************
 *  10/12 0012  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.discover
 * </pre>
 */
public class postmessage {
    @Autowired
    private HttpServletRequest request;

    public void execute(Context context,@Param("pid") String pid,@Param("purl") String purl) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        context.put("pid",pid);
        context.put("purl",purl);
    }
}
