package net.showcal.mobile.module.screen.aboutMe;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.biz.SysUserExtentManager;
import com.showcal.platform.domain.*;
import com.showcal.platform.request.SettingDiseaseGetAllListRequest;
import com.showcal.platform.request.SysUserExtentGetRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.SettingDiseaseGetAllListResponse;
import com.showcal.platform.response.SysUserExtentGetResponse;
import com.showcal.platform.response.SysUserGetResponse;
import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DEV003 on 2015/10/8.
 */
public class physiologySet {
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
    public void execute(Context context) throws Exception {
        // 得到当前登陆人
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        SysUserGetRequest getRequest = new SysUserGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserGetResponse userGetResponse = platformHelper.getSysUser(getRequest, passport);
        UserInfo user = userGetResponse.getSysUser();
        if (user.getAvatarId() != null&&user.getAvatarId().intValue()!=0) {
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

        // 查询用户详情（扩展表）
        UserDetail userDetail = mapper.map(user,UserDetail.class);
        SysUserExtentGetRequest sysUserExtentGetRequest = new SysUserExtentGetRequest();
        sysUserExtentGetRequest.setId(userDetail.getId());
        SysUserExtentGetResponse sysUserExtentGetResponse = sysUserExtentManager.get(sysUserExtentGetRequest, passport);
        SysUserExtent sysUserExtent = sysUserExtentGetResponse.getSysUserExtent();
        if(sysUserExtent != null){
            userDetail.setHeight(sysUserExtent.getHeight());
            userDetail.setBirthday(sysUserExtent.getBirthday());
            userDetail.setWeight(sysUserExtent.getWeight());
            userDetail.setWaistLine(sysUserExtent.getWaistLine());
            userDetail.setHipline(sysUserExtent.getHipline());
            userDetail.setBmi(sysUserExtent.getBmi());
            userDetail.setSetting(sysUserExtent.getSetting());
            // 转换开始： settingStr转换json,转javaObj
            String settingStr = sysUserExtent.getSetting();
            JSONObject settingObj = JSON.parseObject(settingStr);
            UserSetting userSetting = JSONObject.toJavaObject(settingObj, UserSetting.class);
            userDetail.setUserSetting(userSetting);
            // 转换结束
            userDetail.setCountService(sysUserExtent.getCountService());
            userDetail.setResponseTime(sysUserExtent.getResponseTime());
            userDetail.setSuccessRate(sysUserExtent.getSuccessRate());
            userDetail.setIntegral(sysUserExtent.getIntegral());
        }
        context.put("userDetail",userDetail);


    }
}
