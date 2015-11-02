/**
 * @(#)BmiFoodManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:56.
 * @author 顾志雄
 */
public interface BmiFoodManager {
    /**
     * 根据Id获取BMI食物总重量
     *
     * @param request 获取BMI食物总重量请求
     * @param passport 用户护照
     * @return 获取BMI食物总重量应答
     */
    BmiFoodGetResponse get(BmiFoodGetRequest request, Passport passport);


    /**
     * 模糊查询BMI食物总重量
     *
     * @param request 模糊查询BMI食物总重量请求
     * @param passport 用户护照
     * @return 模糊查询BMI食物总重量应答
     */
    BmiFoodSearchResponse search(BmiFoodSearchRequest request, Passport passport);

    /**
     * 高级查询BMI食物总重量
     *
     * @param request 高级查询BMI食物总重量请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    BmiFoodFindResponse find(BmiFoodFindRequest request, Passport passport);

    /**
     * 获取所有BMI食物总重量列表
     *
     * @param request 获取所有BMI食物总重量列表请求
     * @param passport 用户护照
     * @return 获取所有BMI食物总重量列表应答
     */
    BmiFoodGetAllListResponse getAllList(BmiFoodGetAllListRequest request, Passport passport);


    /**
     * 创建BMI食物总重量
     *
     * @param request 创建BMI食物总重量请求
     * @param passport 用户护照
     * @return 创建BMI食物总重量应答
     */
    BmiFoodCreateResponse create(BmiFoodCreateRequest request, Passport passport);


    /**
     * 更新BMI食物总重量
     *
     * @param request 更新BMI食物总重量请求
     * @param passport 用户护照
     * @return 更新BMI食物总重量应答
     */
    BmiFoodUpdateResponse update(BmiFoodUpdateRequest request, Passport passport);


    /**
     * 删除BMI食物总重量
     *
     * @param request 删除BMI食物总重量请求
     * @param passport 用户护照
     * @return 删除BMI食物总重量应答
     */
    BmiFoodDeleteResponse delete(BmiFoodDeleteRequest request, Passport passport);

    
    /**
     * 作废BMI食物总重量
     *
     * @param request 作废BMI食物总重量请求
     * @param passport 用户护照
     * @return 作废BMI食物总重量应答
     */
    BmiFoodInactiveResponse inactive(BmiFoodInactiveRequest request, Passport passport);


    /**
     * 激活BMI食物总重量
     *
     * @param request 激活BMI食物总重量请求
     * @param passport 用户护照
     * @return 激活BMI食物总重量应答
     */
    BmiFoodActiveResponse active(BmiFoodActiveRequest request, Passport passport);
    


    /**
     * 导入BMI食物总重量
     *
     * @param request 导入BMI食物总重量请求
     * @param passport 用户护照
     * @return 导入BMI食物总重量应答
     */
    BmiFoodListImportResponse importList(BmiFoodListImportRequest request, Passport passport);


}
