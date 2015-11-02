package net.showcal.mobile.module.screen.showcal;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.rjeschke.txtmark.Processor;
import com.showcal.cms.domain.CategoryEnum;
import com.showcal.cms.request.ArticleFindRequest;
import com.showcal.cms.response.ArticleFindResponse;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.merchandise.request.ItemFindRequest;
import com.showcal.merchandise.response.ItemFindResponse;
import com.showcal.platform.domain.UserDetail;
import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.platform.request.SysUserFindRequest;
import com.showcal.platform.response.SysUserFindResponse;
import com.showcal.service.domain.SexEnum;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.service.response.ShowCalGetForMyResponse;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.md.helper.MdHelper;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.service.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Search {
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


    public void execute(Context context, @Param("nickName") String nickName, @Param("pageNum") Integer pageNum, @Param("countService") Boolean countService, @Param("responseTime") Boolean responseTime) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
        SysUserFindResponse userFindResponse = new SysUserFindResponse();
//        passport.setType(PassportTypeEnum.MEMBER);
        ShowCalGetForMyRequest showCalGetForMyRequest = new ShowCalGetForMyRequest();
        ShowCalGetForMyResponse showCalGetForMyResponse = serviceHelper.getMyShowCal(showCalGetForMyRequest, passport);
        List<UserTypeEnum> userTypeEnums = new ArrayList<>();
        userTypeEnums.add(UserTypeEnum.SHOWCAL);
        SysUserFindRequest sysUserFindRequest = new SysUserFindRequest();
        if (nickName != null) {
            sysUserFindRequest.setNickName(nickName);
        }
        if (countService != null) {
            sysUserFindRequest.setIsCountService(countService);
        }
        if (responseTime != null) {
            sysUserFindRequest.setIsResponseTime(responseTime);
        }
        if (pageNum != null) {
            sysUserFindRequest.setPageNumber(pageNum);
        }
        if(showCalGetForMyResponse.getShowCalInfo()!=null){
            sysUserFindRequest.setServiceId(showCalGetForMyResponse.getShowCalInfo().getId());
        }
        sysUserFindRequest.setUsertypes(userTypeEnums);
        sysUserFindRequest.setPageSize(5);
        userFindResponse = platformHelper.findSysUser(sysUserFindRequest, passport);
        List<UserDetail> users = new ArrayList<>();
        for (UserDetail user : userFindResponse.getResult()) {
            if (user.getAvatarId() != null && user.getAvatarId().intValue() != 0) {
                FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                filePathGetRequest.setId(user.getAvatarId());
                FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                user.setAvatarurl(filePathGetResponse.getUrl());
            } else {
                if (user.getSex() != null) {
                    if (user.getSex().equals(SexEnum.FEMALE)) {
                        user.setAvatarurl("../images/girl.png");
                    } else if (user.getSex().equals(SexEnum.MALE)) {
                        user.setAvatarurl("../images/boy.png");
                    }
                } else {
                    user.setAvatarurl("../images/girl.png");
                }
            }
            ArticleFindRequest request = new ArticleFindRequest();
            request.setSubmitUserId(user.getId());
            request.setCategoryId(CategoryEnum.INTRODUCTION.name());
            request.setPageSize(0);
            ArticleFindResponse response = cmsHelper.findArticle(request, passport);
            if (response.getResult().size() != 0) {
                user.setContent(response.getResult().get(0).getContent());
            }
            users.add(user);
        }
        userFindResponse.setResult(users);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(userFindResponse, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
