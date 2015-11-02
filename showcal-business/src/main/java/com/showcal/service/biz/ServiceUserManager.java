/**
 * @(#)ServiceUserManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
public interface ServiceUserManager {

    /**
     * 创建用户服务表
     *
     * @param request  创建用户服务表请求
     * @param passport 用户护照
     * @return 创建用户服务表应答
     */
    ServiceUserCreateResponse create(ServiceUserCreateRequest request, Passport passport);


    /**
     * 删除用户服务表
     *
     * @param request  删除用户服务表请求
     * @param passport 用户护照
     * @return 删除用户服务表应答
     */
    ServiceUserDeleteResponse delete(ServiceUserDeleteRequest request, Passport passport);


    /**
     * 作废用户服务表
     *
     * @param request  作废用户服务表请求
     * @param passport 用户护照
     * @return 作废用户服务表应答
     */
    ServiceUserInactiveResponse inactive(ServiceUserInactiveRequest request, Passport passport);


    /**
     * 激活用户服务表
     *
     * @param request  激活用户服务表请求
     * @param passport 用户护照
     * @return 激活用户服务表应答
     */
    ServiceUserActiveResponse active(ServiceUserActiveRequest request, Passport passport);

    /**
     * 获取我当前所有服务的客户(瘦咖角度)
     * @param request
     * @param passport
     * @return
     */
    ServiceUserGetListForMyResponse getMyList(ServiceUserGetListForMyRequest request, Passport passport);

    /**
     * 获取我历史上服务的客户
     * @param request
     * @param passport
     * @return
     */
    ServiceHistoryUserGetResponse getMyHistoryList(ServiceHistoryUserGetRequest request, Passport passport);

    /**
     * 获取我的瘦咖
     * @param request
     * @param passport
     * @return
     */
    ShowCalGetForMyResponse getMyShowCal(ShowCalGetForMyRequest request, Passport passport);

    /**
     * 获取瘦咖ID 内部方法，不对外开放
     * @param userId
     * @return
     */
    Long getMyShowCalId(Long userId);
    /**
     * 获取服务我的历史瘦咖
     * @param request
     * @param passport
     * @return
     */
    ShowCalHistoryGetResponse getMyHistoryShowCal(ShowCalHistoryGetRequest request, Passport passport);
}
