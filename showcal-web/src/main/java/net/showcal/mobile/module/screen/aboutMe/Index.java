package net.showcal.mobile.module.screen.aboutMe;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.biz.SysUserExtentManager;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.domain.SysUserExtent;
import com.showcal.platform.domain.UserDetail;
import com.showcal.platform.request.SysUserExtentGetRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.SysUserExtentGetResponse;
import com.showcal.platform.response.SysUserGetResponse;
import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DEV003 on 2015/10/8.
 */
public class Index {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PlatformHelper platformHelper;
    @Autowired
    private FoundationService foundationService;
    @Autowired
    private SysUserExtentManager sysUserExtentManager;
    @Autowired
    private Mapper mapper;

    public void execute(Context context,@Param("passportid")Long passportid) throws Exception {
        // 得到当前登陆人
        System.out.println("====>当前ID"+passportid);

        Passport passport = (Passport) request.getAttribute("passport");
        SysUserGetRequest getRequest = new SysUserGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserGetResponse userGetResponse = platformHelper.getSysUser(getRequest, passport);
        UserInfo user = userGetResponse.getSysUser();
        if(user!=null){
            if (user.getAvatarId() != null&& user.getAvatarId().intValue()!=0) {
                FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                filePathGetRequest.setId(user.getAvatarId());
                FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                user.setAvatarurl(filePathGetResponse.getUrl());
            } else {
                if(user.getSex()!=null) {
                    if (user.getSex().equals(SexEnum.FEMALE)) {
                        user.setAvatarurl("../images/girl.png");
                    } else if (user.getSex().equals(SexEnum.MALE)) {
                        user.setAvatarurl("../images/boy.png");
                    }
                }
                else{
                    user.setAvatarurl("../images/girl.png");
                }
            }
        }
        context.put("user",user);
        context.put("passport", passport);
    }
}
