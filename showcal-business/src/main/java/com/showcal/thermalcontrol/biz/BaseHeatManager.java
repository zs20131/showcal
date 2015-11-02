/**
 * @(#)BaseHeatManager.java
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
public interface BaseHeatManager {
    /**
     * 根据Id获取基础热量设置
     *
     * @param request 获取基础热量设置请求
     * @param passport 用户护照
     * @return 获取基础热量设置应答
     */
    BaseHeatGetResponse get(BaseHeatGetRequest request, Passport passport);


    /**
     * 模糊查询基础热量设置
     *
     * @param request 模糊查询基础热量设置请求
     * @param passport 用户护照
     * @return 模糊查询基础热量设置应答
     */
    BaseHeatSearchResponse search(BaseHeatSearchRequest request, Passport passport);

    /**
     * 高级查询基础热量设置
     *
     * @param request 高级查询基础热量设置请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    BaseHeatFindResponse find(BaseHeatFindRequest request, Passport passport);

    /**
     * 获取所有基础热量设置列表
     *
     * @param request 获取所有基础热量设置列表请求
     * @param passport 用户护照
     * @return 获取所有基础热量设置列表应答
     */
    BaseHeatGetAllListResponse getAllList(BaseHeatGetAllListRequest request, Passport passport);


    /**
     * 创建基础热量设置
     *
     * @param request 创建基础热量设置请求
     * @param passport 用户护照
     * @return 创建基础热量设置应答
     */
    BaseHeatCreateResponse create(BaseHeatCreateRequest request, Passport passport);


    /**
     * 更新基础热量设置
     *
     * @param request 更新基础热量设置请求
     * @param passport 用户护照
     * @return 更新基础热量设置应答
     */
    BaseHeatUpdateResponse update(BaseHeatUpdateRequest request, Passport passport);


    /**
     * 删除基础热量设置
     *
     * @param request 删除基础热量设置请求
     * @param passport 用户护照
     * @return 删除基础热量设置应答
     */
    BaseHeatDeleteResponse delete(BaseHeatDeleteRequest request, Passport passport);

    


    /**
     * 导入基础热量设置
     *
     * @param request 导入基础热量设置请求
     * @param passport 用户护照
     * @return 导入基础热量设置应答
     */
    BaseHeatListImportResponse importList(BaseHeatListImportRequest request, Passport passport);


}
