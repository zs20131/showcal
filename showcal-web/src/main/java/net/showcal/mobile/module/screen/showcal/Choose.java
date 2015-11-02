package net.showcal.mobile.module.screen.showcal;

import com.alibaba.citrus.turbine.Context;
import com.github.rjeschke.txtmark.Processor;
import com.showcal.cms.domain.Article;
import com.showcal.cms.domain.CategoryEnum;
import com.showcal.cms.request.ArticleFindRequest;
import com.showcal.cms.response.ArticleFindResponse;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.domain.UserDetail;
import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.platform.request.SysUserFindRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.SysUserFindResponse;
import com.showcal.platform.response.SysUserGetResponse;
import com.showcal.service.domain.SexEnum;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.service.response.ShowCalGetForMyResponse;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.service.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
public class Choose {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private PlatformHelper platformHelper;

    @Autowired
    private FoundationService foundationService;
    @Autowired
    private CmsHelper cmsHelper;
    @Autowired
    private ServiceHelper serviceHelper;

    public void execute(Context context) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        
    }
}
