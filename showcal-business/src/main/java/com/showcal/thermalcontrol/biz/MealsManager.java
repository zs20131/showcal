/**
 * @(#)MealsManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public interface MealsManager {
    /**
     * 根据Id获取餐次
     *
     * @param request 获取餐次请求
     * @param passport 用户护照
     * @return 获取餐次应答
     */
    MealsGetResponse get(MealsGetRequest request, Passport passport);


    /**
     * 模糊查询餐次
     *
     * @param request 模糊查询餐次请求
     * @param passport 用户护照
     * @return 模糊查询餐次应答
     */
    MealsSearchResponse search(MealsSearchRequest request, Passport passport);

    /**
     * 高级查询餐次
     *
     * @param request 高级查询餐次请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    MealsFindResponse find(MealsFindRequest request, Passport passport);

    /**
     * 获取所有餐次列表
     *
     * @param request 获取所有餐次列表请求
     * @param passport 用户护照
     * @return 获取所有餐次列表应答
     */
    MealsGetAllListResponse getAllList(MealsGetAllListRequest request, Passport passport);


    /**
     * 创建餐次
     *
     * @param request 创建餐次请求
     * @param passport 用户护照
     * @return 创建餐次应答
     */
    MealsCreateResponse create(MealsCreateRequest request, Passport passport);


    /**
     * 更新餐次
     *
     * @param request 更新餐次请求
     * @param passport 用户护照
     * @return 更新餐次应答
     */
    MealsUpdateResponse update(MealsUpdateRequest request, Passport passport);


    /**
     * 删除餐次
     *
     * @param request 删除餐次请求
     * @param passport 用户护照
     * @return 删除餐次应答
     */
    MealsDeleteResponse delete(MealsDeleteRequest request, Passport passport);

    


    /**
     * 导入餐次
     *
     * @param request 导入餐次请求
     * @param passport 用户护照
     * @return 导入餐次应答
     */
    MealsListImportResponse importList(MealsListImportRequest request, Passport passport);


}
