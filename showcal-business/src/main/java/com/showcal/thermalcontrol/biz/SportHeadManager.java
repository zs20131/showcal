/**
 * @(#)SportHeadManager.java
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
public interface SportHeadManager {
    /**
     * 根据Id获取运动方案
     *
     * @param request 获取运动方案请求
     * @param passport 用户护照
     * @return 获取运动方案应答
     */
    SportHeadGetResponse get(SportHeadGetRequest request, Passport passport);


    /**
     * 模糊查询运动方案
     *
     * @param request 模糊查询运动方案请求
     * @param passport 用户护照
     * @return 模糊查询运动方案应答
     */
    SportHeadSearchResponse search(SportHeadSearchRequest request, Passport passport);

    /**
     * 高级查询运动方案
     *
     * @param request 高级查询运动方案请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SportHeadFindResponse find(SportHeadFindRequest request, Passport passport);

    /**
     * 获取所有运动方案列表
     *
     * @param request 获取所有运动方案列表请求
     * @param passport 用户护照
     * @return 获取所有运动方案列表应答
     */
    SportHeadGetAllListResponse getAllList(SportHeadGetAllListRequest request, Passport passport);


    /**
     * 创建运动方案
     *
     * @param request 创建运动方案请求
     * @param passport 用户护照
     * @return 创建运动方案应答
     */
    SportHeadCreateResponse create(SportHeadCreateRequest request, Passport passport);


    /**
     * 更新运动方案
     *
     * @param request 更新运动方案请求
     * @param passport 用户护照
     * @return 更新运动方案应答
     */
    SportHeadUpdateResponse update(SportHeadUpdateRequest request, Passport passport);

    /**
     * 更新运动方案totalTime
     *
     * @param request 更新运动方案请求
     * @param passport 用户护照
     * @return 更新运动方案应答TotalTime
     */
    SportHeadUpdateTotalTimeResponse updateTotalTime(SportHeadUpdateTotalTimeRequest request, Passport passport);


    /**
     * 删除运动方案
     *
     * @param request 删除运动方案请求
     * @param passport 用户护照
     * @return 删除运动方案应答
     */
    SportHeadDeleteResponse delete(SportHeadDeleteRequest request, Passport passport);

    


    /**
     * 导入运动方案
     *
     * @param request 导入运动方案请求
     * @param passport 用户护照
     * @return 导入运动方案应答
     */
    SportHeadListImportResponse importList(SportHeadListImportRequest request, Passport passport);


}
