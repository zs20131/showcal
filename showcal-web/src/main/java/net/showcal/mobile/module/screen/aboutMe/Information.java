package net.showcal.mobile.module.screen.aboutMe;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.biz.SysUserExtentManager;
import com.showcal.platform.domain.SettingDisease;
import com.showcal.platform.domain.SysUserExtent;
import com.showcal.platform.domain.UserDetail;
import com.showcal.platform.domain.UserSetting;
import com.showcal.platform.request.SettingDiseaseAppGetAllListRequest;
import com.showcal.platform.request.SysUserExtentGetRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.SettingDiseaseAppGetAllListResponse;
import com.showcal.platform.response.SysUserExtentGetResponse;
import com.showcal.platform.response.SysUserGetResponse;
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
public class Information {
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
        context.put("user", user);

        // 查询特殊情况
        SettingDiseaseAppGetAllListRequest settingDiseaseAppGetAllListRequest = new SettingDiseaseAppGetAllListRequest();
        SettingDiseaseAppGetAllListResponse settingDiseaseAppGetAllListResponse = foundationService.getAppSettingDiseaseList(settingDiseaseAppGetAllListRequest, passport);
        List<SettingDisease> settingDiseaseList = settingDiseaseAppGetAllListResponse.getResult();
        context.put("settingDiseaseList", settingDiseaseList);

        Map<Long, SettingDisease> settingDiseaseMap = new HashMap<>();
        for (SettingDisease settingDisease : settingDiseaseList) {
            settingDiseaseMap.put(settingDisease.getId(), settingDisease);
        }

        // 查询用户详情（扩展表）
        if (user != null) {
            UserDetail userDetail = mapper.map(user, UserDetail.class);
            SysUserExtentGetRequest sysUserExtentGetRequest = new SysUserExtentGetRequest();
            sysUserExtentGetRequest.setId(userDetail.getId());
            SysUserExtentGetResponse sysUserExtentGetResponse = sysUserExtentManager.get(sysUserExtentGetRequest, passport);
            SysUserExtent sysUserExtent = sysUserExtentGetResponse.getSysUserExtent();
            if (sysUserExtent != null) {
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
                if (userSetting != null) {
                    userDetail.setUserSetting(userSetting);
                    // 特殊情况
                    if (settingDiseaseMap.containsKey(userSetting.getDiseaseId())) {
                        userDetail.setSettingDisease(settingDiseaseMap.get(userSetting.getDiseaseId()).getName());
                    }
                }

                // 转换结束
                userDetail.setCountService(sysUserExtent.getCountService());
                userDetail.setResponseTime(sysUserExtent.getResponseTime());
                userDetail.setSuccessRate(sysUserExtent.getSuccessRate());
                userDetail.setIntegral(sysUserExtent.getIntegral());
            }
            context.put("userDetail", userDetail);
        }
    }
}
