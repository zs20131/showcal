package net.showcal.mobile.module.screen.chat;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.showcal.mobile.domain.ShowCalInfo;
import com.showcal.platform.request.SettingQuestionTagGetAllListRequest;
import com.showcal.platform.response.SettingQuestionTagGetAllListResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
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
 *  10/8 0008  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.chat
 * </pre>
 */
public class ask {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private PlatformHelper platformHelper;
    public void execute(Context context,@Param("sId")String sid) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
        context.put("sId",sid);
        //获取所有问题标签
        SettingQuestionTagGetAllListRequest getAllListRequest = new SettingQuestionTagGetAllListRequest();
        SettingQuestionTagGetAllListResponse getAllListResponse = platformHelper.getSettingQuestionTagAllList(getAllListRequest, passport);
        if(getAllListResponse!=null){
            context.put("tags",getAllListResponse.getResult());
        }
    }
}
