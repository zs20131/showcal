/**
 * @(#)SyncSportManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:47:00.
 * @author 顾志雄
 */
public interface SyncSportManager {
    /**
     * 根据Id获取运动同步表)
     *
     * @param request 获取运动同步表)请求
     * @param passport 用户护照
     * @return 获取运动同步表)应答
     */
    SyncSportGetResponse get(SyncSportGetRequest request, Passport passport);


    /**
     * 模糊查询运动同步表)
     *
     * @param request 模糊查询运动同步表)请求
     * @param passport 用户护照
     * @return 模糊查询运动同步表)应答
     */
    SyncSportSearchResponse search(SyncSportSearchRequest request, Passport passport);

    /**
     * 高级查询运动同步表)
     *
     * @param request 高级查询运动同步表)请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SyncSportFindResponse find(SyncSportFindRequest request, Passport passport);

    /**
     * 获取所有运动同步表)列表
     *
     * @param request 获取所有运动同步表)列表请求
     * @param passport 用户护照
     * @return 获取所有运动同步表)列表应答
     */
    SyncSportGetAllListResponse getAllList(SyncSportGetAllListRequest request, Passport passport);


    /**
     * 创建运动同步表)
     *
     * @param request 创建运动同步表)请求
     * @param passport 用户护照
     * @return 创建运动同步表)应答
     */
    SyncSportCreateResponse create(SyncSportCreateRequest request, Passport passport);


    /**
     * 更新运动同步表)
     *
     * @param request 更新运动同步表)请求
     * @param passport 用户护照
     * @return 更新运动同步表)应答
     */
    SyncSportUpdateResponse update(SyncSportUpdateRequest request, Passport passport);


    /**
     * 删除运动同步表)
     *
     * @param request 删除运动同步表)请求
     * @param passport 用户护照
     * @return 删除运动同步表)应答
     */
    SyncSportDeleteResponse delete(SyncSportDeleteRequest request, Passport passport);

    


    /**
     * 导入运动同步表)
     *
     * @param request 导入运动同步表)请求
     * @param passport 用户护照
     * @return 导入运动同步表)应答
     */
    SyncSportListImportResponse importList(SyncSportListImportRequest request, Passport passport);


}
