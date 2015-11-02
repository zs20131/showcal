package net.showcal.mobile.module.screen.aboutMe;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.service.PlatformService;
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
public class myAccount {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PlatformService platformService;
    public void execute(Context context) {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        if(passport!=null&&passport.getUserId()!=null){
            SysUserGetRequest userGetRequest = new SysUserGetRequest();
            userGetRequest.setId(passport.getUserId());
            UserInfo userInfo = platformService.getSysUser(userGetRequest,passport).getSysUser();
            context.put("userInfo",userInfo);
        }




//        context.put("passport", passport);
    }
}
