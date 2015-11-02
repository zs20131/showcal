package net.showcal.service.module.screen.dashboard;

import com.alibaba.citrus.turbine.Context;
import com.showcal.foundation.service.FoundationService;
import com.showcal.service.domain.RepositoryTypeEnum;
import com.showcal.service.request.RepositoryGetForMyRequest;
import com.showcal.service.response.RepositoryGetForMyResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.service.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.service.module.screen.dashboard
 *  Description: 工作台首页
 * ***************************************************************
 *  10/7 0007  V1.0  xiniu    New Files for net.showcal.service.module.screen.dashboard
 * </pre>
 */
public class index {
    @Autowired
    private ServiceHelper serviceHelper;
    @Autowired
    private FoundationService foundationService;
    @Autowired
    private HttpServletRequest request;

    public void execute(Context context) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
//        // 获取系统的知识库
//        RepositoryGetForMyRequest getForMyRequest = new RepositoryGetForMyRequest();
//        getForMyRequest.setType(RepositoryTypeEnum.PLATFORM);
//        RepositoryGetForMyResponse response = serviceHelper.getMyRepository(getForMyRequest, passport);
//        context.put("sysRepository", response.getResult());
//        // 获取个人知识库
//        getForMyRequest = new RepositoryGetForMyRequest();
//        getForMyRequest.setType(RepositoryTypeEnum.SHOWCAL);
//        response = serviceHelper.getMyRepository(getForMyRequest, passport);
//        context.put("myRepository", response.getResult());
    }

}
