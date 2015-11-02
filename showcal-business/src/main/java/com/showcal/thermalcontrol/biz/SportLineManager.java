/**
 * @(#)SportLineManager.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
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
public interface SportLineManager {
    /**
     * 根据Id获取运动方案明细
     *
     * @param request 获取运动方案明细请求
     * @param passport 用户护照
     * @return 获取运动方案明细应答
     */
    SportLineGetResponse get(SportLineGetRequest request, Passport passport);


    /**
     * 模糊查询运动方案明细
     *
     * @param request 模糊查询运动方案明细请求
     * @param passport 用户护照
     * @return 模糊查询运动方案明细应答
     */
    SportLineSearchResponse search(SportLineSearchRequest request, Passport passport);

    /**
     * 高级查询运动方案明细
     *
     * @param request 高级查询运动方案明细请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SportLineFindResponse find(SportLineFindRequest request, Passport passport);

    /**
     * 获取所有运动方案明细列表
     *
     * @param request 获取所有运动方案明细列表请求
     * @param passport 用户护照
     * @return 获取所有运动方案明细列表应答
     */
    SportLineGetAllListResponse getAllList(SportLineGetAllListRequest request, Passport passport);


    /**
     * 创建运动方案明细
     *
     * @param request 创建运动方案明细请求
     * @param passport 用户护照
     * @return 创建运动方案明细应答
     */
    SportLineCreateResponse create(SportLineCreateRequest request, Passport passport);


    /**
     * 更新运动方案明细
     *
     * @param request 更新运动方案明细请求
     * @param passport 用户护照
     * @return 更新运动方案明细应答
     */
    SportLineUpdateResponse update(SportLineUpdateRequest request, Passport passport);


    /**
     * 删除运动方案明细
     *
     * @param request 删除运动方案明细请求
     * @param passport 用户护照
     * @return 删除运动方案明细应答
     */
    SportLineDeleteResponse delete(SportLineDeleteRequest request, Passport passport);

    SportLineListImportResponse importList(SportLineListImportRequest request, Passport passport);
}
