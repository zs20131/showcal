/**
 * @(#)SyncHeatDetailManager.java
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
public interface SyncHeatDetailManager {
    /**
     * 根据Id获取热量同步明细表
     *
     * @param request 获取热量同步明细表请求
     * @param passport 用户护照
     * @return 获取热量同步明细表应答
     */
    SyncHeatDetailGetResponse get(SyncHeatDetailGetRequest request, Passport passport);


    /**
     * 模糊查询热量同步明细表
     *
     * @param request 模糊查询热量同步明细表请求
     * @param passport 用户护照
     * @return 模糊查询热量同步明细表应答
     */
    SyncHeatDetailSearchResponse search(SyncHeatDetailSearchRequest request, Passport passport);

    /**
     * 高级查询热量同步明细表
     *
     * @param request 高级查询热量同步明细表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SyncHeatDetailFindResponse find(SyncHeatDetailFindRequest request, Passport passport);

    /**
     * 获取所有热量同步明细表列表
     *
     * @param request 获取所有热量同步明细表列表请求
     * @param passport 用户护照
     * @return 获取所有热量同步明细表列表应答
     */
    SyncHeatDetailGetAllListResponse getAllList(SyncHeatDetailGetAllListRequest request, Passport passport);


    /**
     * 创建热量同步明细表
     *
     * @param request 创建热量同步明细表请求
     * @param passport 用户护照
     * @return 创建热量同步明细表应答
     */
    SyncHeatDetailCreateResponse create(SyncHeatDetailCreateRequest request, Passport passport);


    /**
     * 更新热量同步明细表
     *
     * @param request 更新热量同步明细表请求
     * @param passport 用户护照
     * @return 更新热量同步明细表应答
     */
    SyncHeatDetailUpdateResponse update(SyncHeatDetailUpdateRequest request, Passport passport);


    /**
     * 删除热量同步明细表
     *
     * @param request 删除热量同步明细表请求
     * @param passport 用户护照
     * @return 删除热量同步明细表应答
     */
    SyncHeatDetailDeleteResponse delete(SyncHeatDetailDeleteRequest request, Passport passport);

    


    /**
     * 导入热量同步明细表
     *
     * @param request 导入热量同步明细表请求
     * @param passport 用户护照
     * @return 导入热量同步明细表应答
     */
    SyncHeatDetailListImportResponse importList(SyncHeatDetailListImportRequest request, Passport passport);


}
