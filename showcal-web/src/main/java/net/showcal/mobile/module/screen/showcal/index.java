package net.showcal.mobile.module.screen.showcal;

import com.alibaba.citrus.service.requestcontext.rundata.User;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.github.rjeschke.txtmark.Processor;
import com.showcal.cms.domain.Article;
import com.showcal.cms.domain.CategoryEnum;
import com.showcal.cms.request.ArticleFindRequest;
import com.showcal.cms.response.ArticleFindResponse;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.domain.CommentPost;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.request.CommentPostFindRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.CommentPostFindResponse;
import com.showcal.platform.response.SysUserGetResponse;
import com.showcal.service.domain.SexEnum;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.service.response.ServiceUserGetResponse;
import com.showcal.service.response.ShowCalGetForMyResponse;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.service.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
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
public class index {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private PlatformHelper platformHelper;
    @Autowired
    private ServiceHelper serviceHelper;
    @Autowired
    private FoundationService foundationService;
    @Autowired
    private CmsHelper cmsHelper;

    public void execute(Context context) throws Exception {
        //得到当前登陆人瘦咖
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
//        passport.setType(PassportTypeEnum.MEMBER);
        ShowCalGetForMyRequest showCalGetForMyRequest = new ShowCalGetForMyRequest();
        ShowCalGetForMyResponse showCalGetForMyResponse = serviceHelper.getMyShowCal(showCalGetForMyRequest, passport);
        if (showCalGetForMyResponse.getShowCalInfo() != null) {
            context.put("showCalInfo", showCalGetForMyResponse.getShowCalInfo());
            SysUserGetRequest sysUserGetRequest = new SysUserGetRequest();
            sysUserGetRequest.setId(showCalGetForMyResponse.getShowCalInfo().getId());
            SysUserGetResponse userGetResponse = platformHelper.getSysUser(sysUserGetRequest, passport);
            SysUser user = userGetResponse.getSysUser();
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
            context.put("user", user);
            //所有发布
            ArticleFindRequest request = new ArticleFindRequest();
            List<Long> alreadySubmit = new ArrayList<Long>();
            alreadySubmit.add(1L);
            request.setAlreadySubmit(alreadySubmit);
            request.setSubmitUserId(showCalGetForMyResponse.getShowCalInfo().getId());
            ArticleFindResponse response = cmsHelper.findArticle(request, passport);
            List<Article> newArticles = response.getResult();
            context.put("newArticles",newArticles );
            context.put("allNum",response.getTotalCount());
            //瘦咖简介
            ArticleFindRequest request1 = new ArticleFindRequest();
            request1.setCategoryId(CategoryEnum.INTRODUCTION.name());
            request1.setSubmitUserId(showCalGetForMyResponse.getShowCalInfo().getId());
            request1.setPageSize(0);
            ArticleFindResponse response1 = cmsHelper.findArticle(request1, passport);
            if (response1.getResult().size() == 1) {
                Article article = response1.getResult().get(0);
                //markdown 显示转换
                article.setContent(Processor.process(article.getContent().replaceAll("\n", "\n\n")));
                context.put("article", article);
                context.put("introduce", true);
            }
            else{
                context.put("introduce", false);
            }
            //成功案例
            request1.setCategoryId(CategoryEnum.SUCCESS_CASE.name());
            request1.setPageSize(10);
            ArticleFindResponse response2 = cmsHelper.findArticle(request1, passport);
            context.put("articleList", response2.getResult());
            context.put("successNum",response2.getTotalCount());
            List<CommentPost> commentPostLsit = new ArrayList<>();
            //获取此瘦咖下的评论
            CommentPostFindRequest commentPostFindRequest = new CommentPostFindRequest();
            commentPostFindRequest.setThreadId(showCalGetForMyResponse.getShowCalInfo().getId());
            //commentPostFindRequest.setParentId(request.getId());
            commentPostFindRequest.setPageSize(0);
            CommentPostFindResponse commentPostFindResponse = platformHelper.find(commentPostFindRequest, passport);
            double sum=0.0;
            for(CommentPost commentPost :commentPostFindResponse.getResult()){
                sum+=commentPost.getGrade();
            }
            DecimalFormat df = new DecimalFormat("#.0");
            if(commentPostFindResponse.getTotalCount()==0){
                context.put("avgGrade", 0.0);
            }else {
                context.put("avgGrade", df.format(sum / commentPostFindResponse.getTotalCount()));
            }
            context.put("commentPosts", commentPostFindResponse.getResult());
        }

    }
}
