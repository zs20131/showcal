/**
 * @(#)CategoryManager.java
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
package com.showcal.cms.biz;

import com.xiniunet.framework.security.Passport;
import com.showcal.cms.request.*;
import com.showcal.cms.response.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public interface CategoryManager {
    /**
     * 根据Id获取文章类别
     *
     * @param request 获取文章类别请求
     * @param passport 用户护照
     * @return 获取文章类别应答
     */
    CategoryGetResponse get(CategoryGetRequest request, Passport passport);


    /**
     * 模糊查询文章类别
     *
     * @param request 模糊查询文章类别请求
     * @param passport 用户护照
     * @return 模糊查询文章类别应答
     */
    CategorySearchResponse search(CategorySearchRequest request, Passport passport);

    /**
     * 高级查询文章类别
     *
     * @param request 高级查询文章类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    CategoryFindResponse find(CategoryFindRequest request, Passport passport);

    /**
     * 获取所有文章类别列表
     *
     * @param request 获取所有文章类别列表请求
     * @param passport 用户护照
     * @return 获取所有文章类别列表应答
     */
    CategoryGetAllListResponse getAllList(CategoryGetAllListRequest request, Passport passport);


    /**
     * 创建文章类别
     *
     * @param request 创建文章类别请求
     * @param passport 用户护照
     * @return 创建文章类别应答
     */
    CategoryCreateResponse create(CategoryCreateRequest request, Passport passport);


    /**
     * 更新文章类别
     *
     * @param request 更新文章类别请求
     * @param passport 用户护照
     * @return 更新文章类别应答
     */
    CategoryUpdateResponse update(CategoryUpdateRequest request, Passport passport);


    /**
     * 删除文章类别
     *
     * @param request 删除文章类别请求
     * @param passport 用户护照
     * @return 删除文章类别应答
     */
    CategoryDeleteResponse delete(CategoryDeleteRequest request, Passport passport);
}
