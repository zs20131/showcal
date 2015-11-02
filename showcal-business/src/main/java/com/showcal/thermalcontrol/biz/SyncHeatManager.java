/**
 * @(#)SyncHeatManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public interface SyncHeatManager {
    /**
     * 根据Id获取热量同步表
     *
     * @param request 获取热量同步表请求
     * @param passport 用户护照
     * @return 获取热量同步表应答
     */
    SyncHeatGetResponse get(SyncHeatGetRequest request, Passport passport);


    /**
     * 模糊查询热量同步表
     *
     * @param request 模糊查询热量同步表请求
     * @param passport 用户护照
     * @return 模糊查询热量同步表应答
     */
    SyncHeatSearchResponse search(SyncHeatSearchRequest request, Passport passport);

    /**
     * 高级查询热量同步表
     *
     * @param request 高级查询热量同步表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SyncHeatFindResponse find(SyncHeatFindRequest request, Passport passport);

    /**
     * 获取所有热量同步表列表
     *
     * @param request 获取所有热量同步表列表请求
     * @param passport 用户护照
     * @return 获取所有热量同步表列表应答
     */
    SyncHeatGetAllListResponse getAllList(SyncHeatGetAllListRequest request, Passport passport);


    /**
     * 创建热量同步表
     *
     * @param request 创建热量同步表请求
     * @param passport 用户护照
     * @return 创建热量同步表应答
     */
    SyncHeatCreateResponse create(SyncHeatCreateRequest request, Passport passport);


    /**
     * 更新热量同步表
     *
     * @param request 更新热量同步表请求
     * @param passport 用户护照
     * @return 更新热量同步表应答
     */
    SyncHeatUpdateResponse update(SyncHeatUpdateRequest request, Passport passport);


    /**
     * 删除热量同步表
     *
     * @param request 删除热量同步表请求
     * @param passport 用户护照
     * @return 删除热量同步表应答
     */
    SyncHeatDeleteResponse delete(SyncHeatDeleteRequest request, Passport passport);

    


    /**
     * 导入热量同步表
     *
     * @param request 导入热量同步表请求
     * @param passport 用户护照
     * @return 导入热量同步表应答
     */
    SyncHeatListImportResponse importList(SyncHeatListImportRequest request, Passport passport);


}
