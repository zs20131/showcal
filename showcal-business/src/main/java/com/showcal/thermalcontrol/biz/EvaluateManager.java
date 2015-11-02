/**
 * @(#)EvaluateManager.java
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
public interface EvaluateManager {
    /**
     * 根据Id获取评价基础
     *
     * @param request 获取评价基础请求
     * @param passport 用户护照
     * @return 获取评价基础应答
     */
    EvaluateGetResponse get(EvaluateGetRequest request, Passport passport);


    /**
     * 模糊查询评价基础
     *
     * @param request 模糊查询评价基础请求
     * @param passport 用户护照
     * @return 模糊查询评价基础应答
     */
    EvaluateSearchResponse search(EvaluateSearchRequest request, Passport passport);

    /**
     * 高级查询评价基础
     *
     * @param request 高级查询评价基础请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    EvaluateFindResponse find(EvaluateFindRequest request, Passport passport);

    /**
     * 获取所有评价基础列表
     *
     * @param request 获取所有评价基础列表请求
     * @param passport 用户护照
     * @return 获取所有评价基础列表应答
     */
    EvaluateGetAllListResponse getAllList(EvaluateGetAllListRequest request, Passport passport);


    /**
     * 创建评价基础
     *
     * @param request 创建评价基础请求
     * @param passport 用户护照
     * @return 创建评价基础应答
     */
    EvaluateCreateResponse create(EvaluateCreateRequest request, Passport passport);


    /**
     * 更新评价基础
     *
     * @param request 更新评价基础请求
     * @param passport 用户护照
     * @return 更新评价基础应答
     */
    EvaluateUpdateResponse update(EvaluateUpdateRequest request, Passport passport);


    /**
     * 删除评价基础
     *
     * @param request 删除评价基础请求
     * @param passport 用户护照
     * @return 删除评价基础应答
     */
    EvaluateDeleteResponse delete(EvaluateDeleteRequest request, Passport passport);

    


    /**
     * 导入评价基础
     *
     * @param request 导入评价基础请求
     * @param passport 用户护照
     * @return 导入评价基础应答
     */
    EvaluateListImportResponse importList(EvaluateListImportRequest request, Passport passport);


}
