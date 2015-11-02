package net.showcal.mobile.module.screen.aboutMe;

import com.alibaba.citrus.turbine.Context;
import com.showcal.cms.domain.Article;
import com.showcal.cms.request.ArticleCollectionGetRequest;
import com.showcal.cms.response.ArticleCollectionGetResponse;
import com.showcal.cms.service.CMSService;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen.aboutMe
 *  Description: 我的收藏
 * ***************************************************************
 *  10/18 0018  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.aboutMe
 * </pre>
 */
public class myMark {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CMSService cmsService;

    public void execute(Context context) {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        // 查询我收藏的帖子
        if (passport != null) {
            ArticleCollectionGetRequest collectionGetRequest = new ArticleCollectionGetRequest();
            collectionGetRequest.setUserId(passport.getUserId());
            ArticleCollectionGetResponse collectionGetResponse = cmsService.getMyCollectionArticle(collectionGetRequest, passport);
            List<Article> articleList = collectionGetResponse.getResult();
            context.put("articles", articleList);
        }
    }

}
