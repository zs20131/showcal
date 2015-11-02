package net.showcal.cms.helper;

import com.showcal.cms.request.*;
import com.showcal.cms.response.*;
import com.showcal.cms.service.CMSService;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.cms.helper.CmsHelperImpl
 *  Description: cms Helper 实现类
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
@Component
public class CmsHelperImpl implements CmsHelper {
    @Autowired
    private CMSService cmsService;

    /**
     * 高级查询文章类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CategoryFindResponse findCategory(CategoryFindRequest request, Passport passport) {
        return cmsService.findCategory(request, passport);
    }

    /**
     * 创建文章类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CategoryCreateResponse createCategory(CategoryCreateRequest request, Passport passport) {
        return cmsService.createCategory(request, passport);
    }

    /**
     * 更新文章类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CategoryUpdateResponse updateCategory(CategoryUpdateRequest request, Passport passport) {
        return cmsService.updateCategory(request, passport);
    }

    /**
     * 删除文章类别(有文章不可以删除)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CategoryDeleteResponse deleteCategory(CategoryDeleteRequest request, Passport passport) {
        return cmsService.deleteCategory(request, passport);
    }

    /**
     * 根据Id获取文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleGetResponse getArticle(ArticleGetRequest request, Passport passport) {
        return cmsService.getArticle(request, passport);
    }

    /**
     * 高级查询文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleFindResponse findArticle(ArticleFindRequest request, Passport passport) {
        return cmsService.findArticle(request, passport);
    }

    /**
     * 获取某个发表人/类别的所有文章信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleGetAllListByUserResponse getArticleAllListByUser(ArticleGetAllListByUserRequest request, Passport passport) {
        return cmsService.getArticleAllListByUser(request, passport);
    }

    /**
     * 发现，所有已发表的文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleGetAllListResponse getArticleAllList(ArticleGetAllListRequest request, Passport passport) {
        return cmsService.getArticleAllList(request, passport);
    }

    /**
     * 审核文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleApproveResponse aproveArticle(ArticleApproveRequest request, Passport passport) {
        return cmsService.aproveArticle(request, passport);
    }

    /**
     * 取消文章发布
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleCancelResponse cancelArticle(ArticleCancelRequest request, Passport passport) {
        return cmsService.cancelArticle(request, passport);
    }

    /**
     * 改变文章排序
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleChangeOrderResponse changeArticleOrder(ArticleChangeOrderRequest request, Passport passport) {
        return cmsService.changeArticleOrder(request, passport);
    }

    /**
     * 创建文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleCreateResponse createArticle(ArticleCreateRequest request, Passport passport) {
        return cmsService.createArticle(request, passport);
    }

    /**
     * 更新文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleUpdateResponse updateArticle(ArticleUpdateRequest request, Passport passport) {
        return cmsService.updateArticle(request, passport);
    }

    /**
     * 删除文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleDeleteResponse deleteArticle(ArticleDeleteRequest request, Passport passport) {
        return cmsService.deleteArticle(request, passport);
    }

    /**
     * 文章统计收集
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ArticleStatisticsCollectResponse collectArticleStatistics(ArticleStatisticsCollectRequest request, Passport passport) {
        return cmsService.collectArticleStatistics(request, passport);
    }

    @Override
    public ArticlePraiseResponse clickPraise(ArticlePraiseRequest request, Passport passport) {
        return cmsService.clickPraise(request,passport);
    }

    @Override
    public ArticleCollectionResponse clickCollection(ArticleCollectionRequest request, Passport passport) {
        return cmsService.clickCollection(request,passport);
    }

    @Override
    public ArticleSuccessUpdateResponse successArticle(ArticleSuccessUpdateRequest request, Passport passport) {
        return cmsService.successArticle(request,passport);
    }

    @Override
    public ArticleUnsuccessUpdateResponse unsuccessArticle(ArticleUnsuccessUpdateRequest request, Passport passport) {
        return cmsService.unsuccessArticle(request,passport);
    }

    @Override
    public ArticleChangeOrderResponse changeOrder(ArticleChangeOrderRequest request, Passport passport) {
        return cmsService.changeArticleOrder(request,passport);
    }
}