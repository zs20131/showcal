package com.showcal.cms.service;

import com.showcal.cms.request.*;
import com.showcal.cms.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.cms.service
 *  Description: CMS 接口类别
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.cms.service
 * </pre>
 */
public interface CMSService {
    /**
     * 高级查询文章类别
     *
     * @param request 高级查询文章类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    CategoryFindResponse findCategory(CategoryFindRequest request, Passport passport);

    /**
     * 创建文章类别
     *
     * @param request 创建文章类别请求
     * @param passport 用户护照
     * @return 创建文章类别应答
     */
    CategoryCreateResponse createCategory(CategoryCreateRequest request, Passport passport);


    /**
     * 更新文章类别
     *
     * @param request 更新文章类别请求
     * @param passport 用户护照
     * @return 更新文章类别应答
     */
    CategoryUpdateResponse updateCategory(CategoryUpdateRequest request, Passport passport);


    /**
     * 删除文章类别(有文章不可以删除)
     *
     * @param request 删除文章类别请求
     * @param passport 用户护照
     * @return 删除文章类别应答
     */
    CategoryDeleteResponse deleteCategory(CategoryDeleteRequest request, Passport passport);


    /**
     * 根据Id获取文章
     *
     * @param request 获取文章请求
     * @param passport 用户护照
     * @return 获取文章应答
     */
    ArticleGetResponse getArticle(ArticleGetRequest request, Passport passport);

    /**
     * 高级查询文章
     *
     * @param request 高级查询文章请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ArticleFindResponse findArticle(ArticleFindRequest request, Passport passport);



    /**
     * 获取某个发表人/类别的所有文章信息
     * @param request 获取所有文章列表请求
     * @param passport 用户护照
     * @return 获取所有文章列表应答
     */
    ArticleGetAllListByUserResponse getArticleAllListByUser(ArticleGetAllListByUserRequest request, Passport passport);

    /**
     * 发现，所有已发表的文章
     * @param request 获取所有文章列表请求
     * @param passport 用户护照
     * @return 获取所有文章列表应答
     */
    ArticleGetAllListResponse getArticleAllList(ArticleGetAllListRequest request, Passport passport);

    /**
     * 审核文章
     * @param request
     * @param passport
     * @return
     */
    ArticleApproveResponse aproveArticle(ArticleApproveRequest request,Passport passport);

    /**
     * 取消文章发布
     * @param request
     * @param passport
     * @return
     */
    ArticleCancelResponse cancelArticle(ArticleCancelRequest request,Passport passport);

    /**
     * 改变文章排序
     * @param request
     * @param passport
     * @return
     */
    ArticleChangeOrderResponse changeArticleOrder(ArticleChangeOrderRequest request,Passport passport);

    /**
     * 创建文章
     *
     * @param request 创建文章请求
     * @param passport 用户护照
     * @return 创建文章应答
     */
    ArticleCreateResponse createArticle(ArticleCreateRequest request, Passport passport);


    /**
     * 更新文章
     *
     * @param request 更新文章请求
     * @param passport 用户护照
     * @return 更新文章应答
     */
    ArticleUpdateResponse updateArticle(ArticleUpdateRequest request, Passport passport);


    /**
     * 删除文章
     *
     * @param request 删除文章请求
     * @param passport 用户护照
     * @return 删除文章应答
     */
    ArticleDeleteResponse deleteArticle(ArticleDeleteRequest request, Passport passport);

    /**
     * 文章统计收集
     * @param request
     * @param passport
     * @return
     */
    ArticleStatisticsCollectResponse collectArticleStatistics(ArticleStatisticsCollectRequest request,Passport passport);


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
     * 获取文章收藏详情
      * @param request
     * @param passport
     * @return
     */
    ArticleCollectionGetResponse getMyCollectionArticle(ArticleCollectionGetRequest request,Passport passport);

    /**
     * 升级成功案列
     */
    ArticleSuccessUpdateResponse successArticle(ArticleSuccessUpdateRequest request,Passport passport);
    /**
     * 取消成功案列
     */
    ArticleUnsuccessUpdateResponse unsuccessArticle(ArticleUnsuccessUpdateRequest request,Passport passport);
}
