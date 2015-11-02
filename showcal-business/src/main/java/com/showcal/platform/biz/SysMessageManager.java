/**
 * @(#)SysMessageManager.java
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
package com.showcal.platform.biz;

import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 * @author 顾志雄
 */
public interface SysMessageManager {
    /**
     * 根据Id获取系统消息表
     *
     * @param request 获取系统消息表请求
     * @param passport 用户护照
     * @return 获取系统消息表应答
     */
    SysMessageGetResponse get(SysMessageGetRequest request, Passport passport);


    /**
     * 高级查询系统消息表
     *
     * @param request 高级查询系统消息表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SysMessageFindResponse find(SysMessageFindRequest request, Passport passport);


    /**
     * 创建系统消息表
     *
     * @param request 创建系统消息表请求
     * @param passport 用户护照
     * @return 创建系统消息表应答
     */
    SysMessageCreateResponse create(SysMessageCreateRequest request, Passport passport);


    /**
     * 更新系统消息表
     *
     * @param request 更新系统消息表请求
     * @param passport 用户护照
     * @return 更新系统消息表应答
     */
    SysMessageUpdateResponse update(SysMessageUpdateRequest request, Passport passport);
    /**
     * 创建系统消息表
     *
     * @param request 创建系统消息表请求
     * @param passport 用户护照
     * @return 创建系统消息表应答
     */
    SysMessageCreateListResponse createList(SysMessageCreateListRequest request, Passport passport);



}
