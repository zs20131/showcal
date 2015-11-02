/**
 * @(#)FoodExchangeManager.java
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
package com.showcal.thermalcontrol.biz;

import com.xiniunet.framework.security.Passport;
import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:57.
 * @author 顾志雄
 */
public interface FoodExchangeManager {
    /**
     * 根据Id获取食物交换份
     *
     * @param request 获取食物交换份请求
     * @param passport 用户护照
     * @return 获取食物交换份应答
     */
    FoodExchangeGetResponse get(FoodExchangeGetRequest request, Passport passport);


    /**
     * 模糊查询食物交换份
     *
     * @param request 模糊查询食物交换份请求
     * @param passport 用户护照
     * @return 模糊查询食物交换份应答
     */
    FoodExchangeSearchResponse search(FoodExchangeSearchRequest request, Passport passport);

    /**
     * 高级查询食物交换份
     *
     * @param request 高级查询食物交换份请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    FoodExchangeFindResponse find(FoodExchangeFindRequest request, Passport passport);

    /**
     * 获取所有食物交换份列表
     *
     * @param request 获取所有食物交换份列表请求
     * @param passport 用户护照
     * @return 获取所有食物交换份列表应答
     */
    FoodExchangeGetAllListResponse getAllList(FoodExchangeGetAllListRequest request, Passport passport);


    /**
     * 创建食物交换份
     *
     * @param request 创建食物交换份请求
     * @param passport 用户护照
     * @return 创建食物交换份应答
     */
    FoodExchangeCreateResponse create(FoodExchangeCreateRequest request, Passport passport);


    /**
     * 更新食物交换份
     *
     * @param request 更新食物交换份请求
     * @param passport 用户护照
     * @return 更新食物交换份应答
     */
    FoodExchangeUpdateResponse update(FoodExchangeUpdateRequest request, Passport passport);


    /**
     * 删除食物交换份
     *
     * @param request 删除食物交换份请求
     * @param passport 用户护照
     * @return 删除食物交换份应答
     */
    FoodExchangeDeleteResponse delete(FoodExchangeDeleteRequest request, Passport passport);

    
    /**
     * 作废食物交换份
     *
     * @param request 作废食物交换份请求
     * @param passport 用户护照
     * @return 作废食物交换份应答
     */
    FoodExchangeInactiveResponse inactive(FoodExchangeInactiveRequest request, Passport passport);


    /**
     * 激活食物交换份
     *
     * @param request 激活食物交换份请求
     * @param passport 用户护照
     * @return 激活食物交换份应答
     */
    FoodExchangeActiveResponse active(FoodExchangeActiveRequest request, Passport passport);
    


    /**
     * 导入食物交换份
     *
     * @param request 导入食物交换份请求
     * @param passport 用户护照
     * @return 导入食物交换份应答
     */
    FoodExchangeListImportResponse importList(FoodExchangeListImportRequest request, Passport passport);


}
