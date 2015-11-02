package net.showcal.cms.helper;

import com.showcal.cms.request.*;
import com.showcal.cms.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.cms.helper.CmsHelper
 *  Description: cms Helper 接口
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public interface CmsHelper {
    /**
     * 高级查询文章类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    CategoryFindResponse findCategory(CategoryFindRequest request, Passport passport);

    /**
     * 创建文章类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    CategoryCreateResponse createCategory(CategoryCreateRequest request, Passport passport);

    /**
     * 更新文章类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    CategoryUpdateResponse updateCategory(CategoryUpdateRequest request, Passport passport);

    /**
     * 删除文章类别(有文章不可以删除)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    CategoryDeleteResponse deleteCategory(CategoryDeleteRequest request, Passport passport);

    /**
     * 根据Id获取文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleGetResponse getArticle(ArticleGetRequest request, Passport passport);

    /**
     * 高级查询文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleFindResponse findArticle(ArticleFindRequest request, Passport passport);

    /**
     * 获取某个发表人/类别的所有文章信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleGetAllListByUserResponse getArticleAllListByUser(ArticleGetAllListByUserRequest request, Passport passport);

    /**
     * 发现，所有已发表的文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleGetAllListResponse getArticleAllList(ArticleGetAllListRequest request, Passport passport);

    /**
     * 审核文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleApproveResponse aproveArticle(ArticleApproveRequest request, Passport passport);

    /**
     * 取消文章发布
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleCancelResponse cancelArticle(ArticleCancelRequest request, Passport passport);

    /**
     * 改变文章排序
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleChangeOrderResponse changeArticleOrder(ArticleChangeOrderRequest request, Passport passport);

    /**
     * 创建文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleCreateResponse createArticle(ArticleCreateRequest request, Passport passport);

    /**
     * 更新文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleUpdateResponse updateArticle(ArticleUpdateRequest request, Passport passport);

    /**
     * 删除文章
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleDeleteResponse deleteArticle(ArticleDeleteRequest request, Passport passport);

    /**
     * 文章统计收集
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ArticleStatisticsCollectResponse collectArticleStatistics(ArticleStatisticsCollectRequest request, Passport passport);


    /**
     * 点赞
     *
     * @param request
     * @param passport
     * @return
     */
    ArticlePraiseResponse clickPraise(ArticlePraiseRequest request, Passport passport);

    /**
     * 收藏
     *
     * @param request
     * @param passport
     * @return
     */
    ArticleCollectionResponse clickCollection(ArticleCollectionRequest request, Passport passport);
    /**
     * 升级成功案列
     */
    ArticleSuccessUpdateResponse successArticle(ArticleSuccessUpdateRequest request,Passport passport);
    /**
     * 取消成功案列
     */
    ArticleUnsuccessUpdateResponse unsuccessArticle(ArticleUnsuccessUpdateRequest request,Passport passport);
    /**
     * 改变文章排序权重
     *
     * @param request
     * @param passport
     * @return
     */
    ArticleChangeOrderResponse changeOrder(ArticleChangeOrderRequest request, Passport passport);
}