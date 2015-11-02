/**
 * @(#)SportSettingManager.java
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

import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public interface SportSettingManager {
    /**
     * 根据Id获取运动主数据
     *
     * @param request 获取运动主数据请求
     * @param passport 用户护照
     * @return 获取运动主数据应答
     */
    SportSettingGetResponse get(SportSettingGetRequest request, Passport passport);


    /**
     * 模糊查询运动主数据
     *
     * @param request 模糊查询运动主数据请求
     * @param passport 用户护照
     * @return 模糊查询运动主数据应答
     */
    SportSettingSearchResponse search(SportSettingSearchRequest request, Passport passport);

    /**
     * 高级查询运动主数据
     *
     * @param request 高级查询运动主数据请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SportSettingFindResponse find(SportSettingFindRequest request, Passport passport);

    /**
     * 获取所有运动主数据列表
     *
     * @param request 获取所有运动主数据列表请求
     * @param passport 用户护照
     * @return 获取所有运动主数据列表应答
     */
    SportSettingGetAllListResponse getAllList(SportSettingGetAllListRequest request, Passport passport);


    /**
     * 创建运动主数据
     *
     * @param request 创建运动主数据请求
     * @param passport 用户护照
     * @return 创建运动主数据应答
     */
    SportSettingCreateResponse create(SportSettingCreateRequest request, Passport passport);


    /**
     * 更新运动主数据
     *
     * @param request 更新运动主数据请求
     * @param passport 用户护照
     * @return 更新运动主数据应答
     */
    SportSettingUpdateResponse update(SportSettingUpdateRequest request, Passport passport);


    /**
     * 删除运动主数据
     *
     * @param request 删除运动主数据请求
     * @param passport 用户护照
     * @return 删除运动主数据应答
     */
    SportSettingDeleteResponse delete(SportSettingDeleteRequest request, Passport passport);

      SportSettingListImportResponse importList(SportSettingListImportRequest request, Passport passport);
}
