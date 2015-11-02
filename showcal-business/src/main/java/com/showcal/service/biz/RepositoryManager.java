/**
 * @(#)RepositoryManager.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.service.biz;

import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
public interface RepositoryManager {

    /**
     * 高级查询知识库
     *
     * @param request  高级查询知识库请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    RepositoryFindResponse find(RepositoryFindRequest request, Passport passport);


    /**
     * 创建知识库
     *
     * @param request  创建知识库请求
     * @param passport 用户护照
     * @return 创建知识库应答
     */
    RepositoryCreateResponse create(RepositoryCreateRequest request, Passport passport);


    /**
     * 更新知识库
     *
     * @param request  更新知识库请求
     * @param passport 用户护照
     * @return 更新知识库应答
     */
    RepositoryUpdateResponse update(RepositoryUpdateRequest request, Passport passport);


    /**
     * 删除知识库
     *
     * @param request  删除知识库请求
     * @param passport 用户护照
     * @return 删除知识库应答
     */
    RepositoryDeleteResponse delete(RepositoryDeleteRequest request, Passport passport);

    /**
     * 发布知识库
     *
     * @param request  删除知识库请求
     * @param passport 用户护照
     * @return 删除知识库应答
     */
    RepositoryActiveResponse active(RepositoryActiveRequest request, Passport passport);

    /**
     * 取消发布知识库
     *
     * @param request  删除知识库请求
     * @param passport 用户护照
     * @return 删除知识库应答
     */
    RepositoryInactiveResponse inactive(RepositoryInactiveRequest request, Passport passport);

    /**
     *  转至系统知识库
     *
     * @param request
     * @param passport
     * @return
     */
    RepositoryToPlatformResponse toPlatform(RepositoryToPlatformRequest request, Passport passport);

    /**
     *  转回瘦咖知识库
     *
     * @param request
     * @param passport
     * @return
     */
    RepositoryToShowcalResponse toShowcal(RepositoryToShowcalRequest request, Passport passport);

    /**
     * 获取我的知识库
     * @param request
     * @param passport
     * @return
     */
    RepositoryGetForMyResponse getMy(RepositoryGetForMyRequest request, Passport passport);

    /**
     * 获取系统知识库
     * @param request
     * @param passport
     * @return
     */
    RepositorySystemGetResponse  getSystemRepository(RepositorySystemGetRequest request,Passport passport);

    /**
     * 转让我的知识库
     * @param request
     * @param passport
     * @return
     */
    MyRepositoryTransferResponse transfer(MyRepositoryTransferRequest request, Passport passport);

    /**
     *  导入系统知识库
     *
     * @param request
     * @param passport
     * @return
     */
    RepositoryListImportResponse importList(RepositoryListImportRequest request, Passport passport);

    /**
     *  导入我的知识库
     *
     * @param request
     * @param passport
     * @return
     */
    MyRepositoryListImportResponse importMyList(MyRepositoryListImportRequest request, Passport passport);
}
