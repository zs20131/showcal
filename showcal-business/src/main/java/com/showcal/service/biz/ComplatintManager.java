/**
 * @(#)ComplatintManager.java
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
package com.showcal.service.biz;

import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public interface ComplatintManager {
    /**
     * 根据Id获取用户投诉
     *
     * @param request 获取用户投诉请求
     * @param passport 用户护照
     * @return 获取用户投诉应答
     */
    ComplatintGetResponse get(ComplatintGetRequest request, Passport passport);


    /**
     * 模糊查询用户投诉
     *
     * @param request 模糊查询用户投诉请求
     * @param passport 用户护照
     * @return 模糊查询用户投诉应答
     */
    ComplatintSearchResponse search(ComplatintSearchRequest request, Passport passport);

    /**
     * 高级查询用户投诉
     *
     * @param request 高级查询用户投诉请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ComplatintFindResponse find(ComplatintFindRequest request, Passport passport);

    /**
     * 获取所有用户投诉列表
     *
     * @param request 获取所有用户投诉列表请求
     * @param passport 用户护照
     * @return 获取所有用户投诉列表应答
     */
    ComplatintGetAllListResponse getAllList(ComplatintGetAllListRequest request, Passport passport);


    /**
     * 创建用户投诉
     *
     * @param request 创建用户投诉请求
     * @param passport 用户护照
     * @return 创建用户投诉应答
     */
    ComplatintCreateResponse create(ComplatintCreateRequest request, Passport passport);


    /**
     * 更新用户投诉
     *
     * @param request 更新用户投诉请求
     * @param passport 用户护照
     * @return 更新用户投诉应答
     */
    ComplatintUpdateResponse update(ComplatintUpdateRequest request, Passport passport);


    /**
     * 删除用户投诉
     *
     * @param request 删除用户投诉请求
     * @param passport 用户护照
     * @return 删除用户投诉应答
     */
    ComplatintDeleteResponse delete(ComplatintDeleteRequest request, Passport passport);

}
