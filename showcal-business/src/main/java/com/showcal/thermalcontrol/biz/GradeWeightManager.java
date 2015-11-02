/**
 * @(#)GradeWeightManager.java
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
public interface GradeWeightManager {
    /**
     * 根据Id获取打分权重表
     *
     * @param request 获取打分权重表请求
     * @param passport 用户护照
     * @return 获取打分权重表应答
     */
    GradeWeightGetResponse get(GradeWeightGetRequest request, Passport passport);


    /**
     * 模糊查询打分权重表
     *
     * @param request 模糊查询打分权重表请求
     * @param passport 用户护照
     * @return 模糊查询打分权重表应答
     */
    GradeWeightSearchResponse search(GradeWeightSearchRequest request, Passport passport);

    /**
     * 高级查询打分权重表
     *
     * @param request 高级查询打分权重表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    GradeWeightFindResponse find(GradeWeightFindRequest request, Passport passport);

    /**
     * 获取所有打分权重表列表
     *
     * @param request 获取所有打分权重表列表请求
     * @param passport 用户护照
     * @return 获取所有打分权重表列表应答
     */
    GradeWeightGetAllListResponse getAllList(GradeWeightGetAllListRequest request, Passport passport);


    /**
     * 创建打分权重表
     *
     * @param request 创建打分权重表请求
     * @param passport 用户护照
     * @return 创建打分权重表应答
     */
    GradeWeightCreateResponse create(GradeWeightCreateRequest request, Passport passport);


    /**
     * 更新打分权重表
     *
     * @param request 更新打分权重表请求
     * @param passport 用户护照
     * @return 更新打分权重表应答
     */
    GradeWeightUpdateResponse update(GradeWeightUpdateRequest request, Passport passport);


    /**
     * 删除打分权重表
     *
     * @param request 删除打分权重表请求
     * @param passport 用户护照
     * @return 删除打分权重表应答
     */
    GradeWeightDeleteResponse delete(GradeWeightDeleteRequest request, Passport passport);

    


    /**
     * 导入打分权重表
     *
     * @param request 导入打分权重表请求
     * @param passport 用户护照
     * @return 导入打分权重表应答
     */
    GradeWeightListImportResponse importList(GradeWeightListImportRequest request, Passport passport);


}
