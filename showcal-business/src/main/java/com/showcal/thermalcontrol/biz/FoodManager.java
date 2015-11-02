/**
 * @(#)FoodManager.java
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
public interface FoodManager {
    /**
     * 根据Id获取食物
     *
     * @param request 获取食物请求
     * @param passport 用户护照
     * @return 获取食物应答
     */
    FoodGetResponse get(FoodGetRequest request, Passport passport);


    /**
     * 模糊查询食物
     *
     * @param request 模糊查询食物请求
     * @param passport 用户护照
     * @return 模糊查询食物应答
     */
    FoodSearchResponse search(FoodSearchRequest request, Passport passport);

    /**
     * 高级查询食物
     *
     * @param request 高级查询食物请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    FoodFindResponse find(FoodFindRequest request, Passport passport);

    /**
     * 获取所有食物列表
     *
     * @param request 获取所有食物列表请求
     * @param passport 用户护照
     * @return 获取所有食物列表应答
     */
    FoodGetAllListResponse getAllList(FoodGetAllListRequest request, Passport passport);


    /**
     * 创建食物
     *
     * @param request 创建食物请求
     * @param passport 用户护照
     * @return 创建食物应答
     */
    FoodCreateResponse create(FoodCreateRequest request, Passport passport);


    /**
     * 更新食物
     *
     * @param request 更新食物请求
     * @param passport 用户护照
     * @return 更新食物应答
     */
    FoodUpdateResponse update(FoodUpdateRequest request, Passport passport);


    /**
     * 删除食物
     *
     * @param request 删除食物请求
     * @param passport 用户护照
     * @return 删除食物应答
     */
    FoodDeleteResponse delete(FoodDeleteRequest request, Passport passport);

    
    /**
     * 作废食物
     *
     * @param request 作废食物请求
     * @param passport 用户护照
     * @return 作废食物应答
     */
    FoodInactiveResponse inactive(FoodInactiveRequest request, Passport passport);


    /**
     * 激活食物
     *
     * @param request 激活食物请求
     * @param passport 用户护照
     * @return 激活食物应答
     */
    FoodActiveResponse active(FoodActiveRequest request, Passport passport);
    


    /**
     * 导入食物
     *
     * @param request 导入食物请求
     * @param passport 用户护照
     * @return 导入食物应答
     */
    FoodListImportResponse importList(FoodListImportRequest request, Passport passport);


}
