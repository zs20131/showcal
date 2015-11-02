/**
 * @(#)ClazzManager.java
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
package com.showcal.merchandise.biz;

import com.xiniunet.framework.security.Passport;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 * @author 顾志雄
 */
public interface ClazzManager {
    /**
     * 根据Id获取商品类别
     *
     * @param request 获取商品类别请求
     * @param passport 用户护照
     * @return 获取商品类别应答
     */
    ClazzGetResponse get(ClazzGetRequest request, Passport passport);


    /**
     * 模糊查询商品类别
     *
     * @param request 模糊查询商品类别请求
     * @param passport 用户护照
     * @return 模糊查询商品类别应答
     */
    ClazzSearchResponse search(ClazzSearchRequest request, Passport passport);

    /**
     * 高级查询商品类别
     *
     * @param request 高级查询商品类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ClazzFindResponse find(ClazzFindRequest request, Passport passport);

    /**
     * 获取所有商品类别列表
     *
     * @param request 获取所有商品类别列表请求
     * @param passport 用户护照
     * @return 获取所有商品类别列表应答
     */
    ClazzGetAllListResponse getAllList(ClazzGetAllListRequest request, Passport passport);


    /**
     * 创建商品类别
     *
     * @param request 创建商品类别请求
     * @param passport 用户护照
     * @return 创建商品类别应答
     */
    ClazzCreateResponse create(ClazzCreateRequest request, Passport passport);
    /**
     * 创建商品类别
     *
     * @param request 创建商品类别请求
     * @param passport 用户护照
     * @return 创建商品类别应答
     */
    ClazzCreateListResponse createList(ClazzCreateListRequest request, Passport passport);


    /**
     * 更新商品类别
     *
     * @param request 更新商品类别请求
     * @param passport 用户护照
     * @return 更新商品类别应答
     */
    ClazzUpdateResponse update(ClazzUpdateRequest request, Passport passport);


    /**
     * 删除商品类别
     *
     * @param request 删除商品类别请求
     * @param passport 用户护照
     * @return 删除商品类别应答
     */
    ClazzDeleteResponse delete(ClazzDeleteRequest request, Passport passport);

    


    /**
     * 导入商品类别
     *
     * @param request 导入商品类别请求
     * @param passport 用户护照
     * @return 导入商品类别应答
     */
    ClazzListImportResponse importList(ClazzListImportRequest request, Passport passport);


}
