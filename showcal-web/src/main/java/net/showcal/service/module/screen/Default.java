package net.showcal.service.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.SysUserGetResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.single.yunland.module.screen
 *  Description:
 * ***************************************************************
 *  8/4 0004  V1.0  xiniu    New Files for com.xiniunet.single.yunland.module.screen
 * </pre>
 */
public class Default {
    @Autowired
    private PlatformHelper platformHelper;
    @Autowired
    private FoundationService foundationService;
    @Autowired
    private HttpServletRequest request;
    public void execute(Context context) throws Exception{
        Passport passport = (Passport) request.getAttribute("passport");
        if(passport!=null){
            SysUserGetRequest userGetRequest = new SysUserGetRequest();
            userGetRequest.setId(passport.getUserId());
            SysUserGetResponse getResponse= platformHelper.getSysUser(userGetRequest, passport);
            if(getResponse!=null&&getResponse.getSysUser()!=null){
                SysUser user = getResponse.getSysUser();
                if (user.getAvatarId() != null) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(user.getAvatarId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    user.setAvatarurl(filePathGetResponse.getUrl());
                } else {
                        user.setAvatarurl("styles/images/avatar_default.png");
                }
                context.put("avatarurl",user.getAvatarurl());
            }
        }

        context.put("passport",passport);
    }
}
