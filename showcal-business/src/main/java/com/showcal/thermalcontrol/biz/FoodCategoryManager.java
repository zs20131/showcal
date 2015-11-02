/**
 * @(#)FoodCategoryManager.java
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
public interface FoodCategoryManager {
    /**
     * 根据Id获取食物类别
     *
     * @param request 获取食物类别请求
     * @param passport 用户护照
     * @return 获取食物类别应答
     */
    FoodCategoryGetResponse get(FoodCategoryGetRequest request, Passport passport);


    /**
     * 模糊查询食物类别
     *
     * @param request 模糊查询食物类别请求
     * @param passport 用户护照
     * @return 模糊查询食物类别应答
     */
    FoodCategorySearchResponse search(FoodCategorySearchRequest request, Passport passport);

    /**
     * 高级查询食物类别
     *
     * @param request 高级查询食物类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    FoodCategoryFindResponse find(FoodCategoryFindRequest request, Passport passport);

    /**
     * 获取所有食物类别列表
     *
     * @param request 获取所有食物类别列表请求
     * @param passport 用户护照
     * @return 获取所有食物类别列表应答
     */
    FoodCategoryGetAllListResponse getAllList(FoodCategoryGetAllListRequest request, Passport passport);


    /**
     * 创建食物类别
     *
     * @param request 创建食物类别请求
     * @param passport 用户护照
     * @return 创建食物类别应答
     */
    FoodCategoryCreateResponse create(FoodCategoryCreateRequest request, Passport passport);


    /**
     * 更新食物类别
     *
     * @param request 更新食物类别请求
     * @param passport 用户护照
     * @return 更新食物类别应答
     */
    FoodCategoryUpdateResponse update(FoodCategoryUpdateRequest request, Passport passport);


    /**
     * 删除食物类别
     *
     * @param request 删除食物类别请求
     * @param passport 用户护照
     * @return 删除食物类别应答
     */
    FoodCategoryDeleteResponse delete(FoodCategoryDeleteRequest request, Passport passport);

    


    /**
     * 导入食物类别
     *
     * @param request 导入食物类别请求
     * @param passport 用户护照
     * @return 导入食物类别应答
     */
    FoodCategoryListImportResponse importList(FoodCategoryListImportRequest request, Passport passport);


}
