package net.showcal.mobile.module.screen.chat;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen.chat
 *  Description:
 * ***************************************************************
 *  10/11 0011  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.chat
 * </pre>
 */
public class history {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    public void execute(Context context, @Param("sId") String sid,@Param("avatar") String avatar) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
        context.put("sId", sid);
        context.put("showcalavatar",avatar);
    }
}
