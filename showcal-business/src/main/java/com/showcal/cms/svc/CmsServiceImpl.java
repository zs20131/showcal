package com.showcal.cms.svc;

import com.showcal.cms.biz.ArticleManager;
import com.showcal.cms.biz.CategoryManager;
import com.showcal.cms.request.*;
import com.showcal.cms.response.*;
import com.showcal.cms.service.CMSService;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.cms.sv
 *  Description: 文章管理系统
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.cms.svc
 * </pre>
 */
@Service(value = "cmsService")
public class CmsServiceImpl implements CMSService {
    @Autowired
    private CategoryManager categoryManager;
    @Autowired
    private ArticleManager articleManager;

    /**
     * 高级查询文章类别
     *
     * @param request  高级查询文章类别请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public CategoryFindResponse findCategory(CategoryFindRequest request, Passport passport) {
        CategoryFindResponse response = new CategoryFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return categoryManager.find(request, passport);
    }

    /**
     * 创建文章类别
     *
     * @param request  创建文章类别请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public CategoryCreateResponse createCategory(CategoryCreateRequest request, Passport passport) {
        CategoryCreateResponse response = new CategoryCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return categoryManager.create(request, passport);
    }

    @Override
    public CategoryUpdateResponse updateCategory(CategoryUpdateRequest request, Passport passport) {
        CategoryUpdateResponse response = new CategoryUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return categoryManager.update(request, passport);
    }

    @Override
    public CategoryDeleteResponse deleteCategory(CategoryDeleteRequest request, Passport passport) {
        CategoryDeleteResponse response = new CategoryDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return categoryManager.delete(request, passport);
    }

    @Override
    public ArticleGetResponse getArticle(ArticleGetRequest request, Passport passport) {
        ArticleGetResponse response = new ArticleGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.get(request, passport);
    }

    @Override
    public ArticleFindResponse findArticle(ArticleFindRequest request, Passport passport) {
        ArticleFindResponse response = new ArticleFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.find(request, passport);
    }

    @Override
    public ArticleGetAllListByUserResponse getArticleAllListByUser(ArticleGetAllListByUserRequest request, Passport passport) {
        ArticleGetAllListByUserResponse response = new ArticleGetAllListByUserResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.getAllListByUser(request, passport);
    }

    @Override
    public ArticleGetAllListResponse getArticleAllList(ArticleGetAllListRequest request, Passport passport) {
        ArticleGetAllListResponse response = new ArticleGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.getAllList(request, passport);
    }

    @Override
    public ArticleApproveResponse aproveArticle(ArticleApproveRequest request, Passport passport) {
        ArticleApproveResponse response = new ArticleApproveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.approve(request, passport);
    }

    @Override
    public ArticleCancelResponse cancelArticle(ArticleCancelRequest request, Passport passport) {
        ArticleCancelResponse response = new ArticleCancelResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.cancel(request, passport);
    }

    @Override
    public ArticleChangeOrderResponse changeArticleOrder(ArticleChangeOrderRequest request, Passport passport) {
        ArticleChangeOrderResponse response = new ArticleChangeOrderResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.changeOrder(request, passport);
    }

    @Override
    public ArticleCreateResponse createArticle(ArticleCreateRequest request, Passport passport) {
        ArticleCreateResponse response = new ArticleCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.create(request, passport);
    }

    @Override
    public ArticleUpdateResponse updateArticle(ArticleUpdateRequest request, Passport passport) {
        ArticleUpdateResponse response = new ArticleUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.update(request, passport);
    }

    @Override
    public ArticleDeleteResponse deleteArticle(ArticleDeleteRequest request, Passport passport) {
        ArticleDeleteResponse response = new ArticleDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.delete(request, passport);
    }

    @Override
    public ArticleStatisticsCollectResponse collectArticleStatistics(ArticleStatisticsCollectRequest request, Passport passport) {
        ArticleStatisticsCollectResponse response = new ArticleStatisticsCollectResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.collectStatistics(request, passport);
    }

    @Override
    public ArticlePraiseResponse clickPraise(ArticlePraiseRequest request, Passport passport) {
        ArticlePraiseResponse response = new ArticlePraiseResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.clickPraise(request, passport);
    }

    @Override
    public ArticleCollectionResponse clickCollection(ArticleCollectionRequest request, Passport passport) {
        ArticleCollectionResponse response = new ArticleCollectionResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.clickCollection(request, passport);
    }

    /**
     * 获取我收藏的文章
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ArticleCollectionGetResponse getMyCollectionArticle(ArticleCollectionGetRequest request, Passport passport) {
        ArticleCollectionGetResponse response = new ArticleCollectionGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.getMyCollection(request, passport);
    }

    @Override
    public ArticleSuccessUpdateResponse successArticle(ArticleSuccessUpdateRequest request, Passport passport) {
        ArticleSuccessUpdateResponse response = new ArticleSuccessUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.successArticle(request, passport);
    }

    @Override
    public ArticleUnsuccessUpdateResponse unsuccessArticle(ArticleUnsuccessUpdateRequest request, Passport passport) {
        ArticleUnsuccessUpdateResponse response = new ArticleUnsuccessUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.unsuccessArticle(request, passport);
    }
}
