/**
 * @(#)ArticleManager.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.cms.biz;

import com.showcal.service.request.SelfIntroductionGetRequest;
import com.showcal.service.request.SelfIntroductionSaveRequest;
import com.showcal.service.response.SelfIntroductionGetResponse;
import com.showcal.service.response.SelfIntroductionSaveResponse;
import com.xiniunet.framework.security.Passport;
import com.showcal.cms.request.*;
import com.showcal.cms.response.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 *
 * @author 顾志雄
 */
public interface ArticleManager {
    /**
     * 根据Id获取文章
     *
     * @param request  获取文章请求
     * @param passport 用户护照
     * @return 获取文章应答
     */
    ArticleGetResponse get(ArticleGetRequest request, Passport passport);


    /**
     * 模糊查询文章
     *
     * @param request  模糊查询文章请求
     * @param passport 用户护照
     * @return 模糊查询文章应答
     */
    ArticleSearchResponse search(ArticleSearchRequest request, Passport passport);

    /**
     * 高级查询文章
     *
     * @param request  高级查询文章请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ArticleFindResponse find(ArticleFindRequest request, Passport passport);

    /**
     * 获取所有文章列表
     *
     * @param request  获取所有文章列表请求
     * @param passport 用户护照
     * @return 获取所有文章列表应答
     */
    ArticleGetAllListResponse getAllList(ArticleGetAllListRequest request, Passport passport);


    /**
     * 创建文章
     *
     * @param request  创建文章请求
     * @param passport 用户护照
     * @return 创建文章应答
     */
    ArticleCreateResponse create(ArticleCreateRequest request, Passport passport);


    /**
     * 更新文章
     *
     * @param request  更新文章请求
     * @param passport 用户护照
     * @return 更新文章应答
     */
    ArticleUpdateResponse update(ArticleUpdateRequest request, Passport passport);


    /**
     * 删除文章
     *
     * @param request  删除文章请求
     * @param passport 用户护照
     * @return 删除文章应答
     */
    ArticleDeleteResponse delete(ArticleDeleteRequest request, Passport passport);

    /**
     * 获取某人发表的所有的文章
     *
     * @param request
     * @param passport
     * @return
     */
    ArticleGetAllListByUserResponse getAllListByUser(ArticleGetAllListByUserRequest request, Passport passport);

    /**
     * 审核文章
     *
     * @param request
     * @param passport
     * @return
     */
    ArticleApproveResponse approve(ArticleApproveRequest request, Passport passport);

    /**
     * 取消文章发布
     *
     * @param request
     * @param passport
     * @return
     */
    ArticleCancelResponse cancel(ArticleCancelRequest request, Passport passport);

    /**
     * 改变文章排序权重
     *
     * @param request
     * @param passport
     * @return
     */
    ArticleChangeOrderResponse changeOrder(ArticleChangeOrderRequest request, Passport passport);

    /**
     * 收集文章统计
     *
     * @param request
     * @param passport
     * @return
     */
    ArticleStatisticsCollectResponse collectStatistics(ArticleStatisticsCollectRequest request, Passport passport);

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
     * 保存自我介绍
     * @param request
     * @param passport
     * @return
     */
    SelfIntroductionSaveResponse saveSelfIntroduction(SelfIntroductionSaveRequest request, Passport passport);

    /**
     * 获取自我介绍
     * @param request
     * @param passport
     * @return
     */
    SelfIntroductionGetResponse getSelfIntroduction(SelfIntroductionGetRequest request, Passport passport);

    /**
     *
     * @param request
     * @param passport
     * @return
     */
    ArticleCollectionGetResponse getMyCollection(ArticleCollectionGetRequest request, Passport passport);
}
