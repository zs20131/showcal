/**
 * @(#)MessageManager.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.foundation.biz;

import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.xiniunet.framework.security.Passport;


/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 *
 * @author 沈振家
 */
public interface MessageManager {

    /**
     * 创建消息
     *
     * @param req      创建消息请求
     * @param passport 用户护照
     * @return 创建消息应答
     */
    MessageCreateResponse insert(MessageCreateRequest req, Passport passport);

    /**
     * 获取消息列表(未读)
     *
     * @param req      获取消息列表请求
     * @param passport 用户护照
     * @return 消息列表应答
     */
    MessageGetUnreadListResponse getUnreadList(MessageGetUnreadListRequest req, Passport passport);

    /**
     * 获取消息列表(已读)
     *
     * @param req      获取消息列表请求
     * @param passport 用户护照
     * @return 消息列表应答
     */
    MessageGetReadedListResponse getReadedList(MessageGetReadedListRequest req, Passport passport);

    /**
     * 获取消息信息
     *
     * @param req      获取消息内容请求
     * @param passport 用户护照
     * @return 消息信息应答
     */
    MessageGetResponse get(MessageGetRequest req, Passport passport);

    /**
     * 设置消息为已读
     *
     * @param req      设置消息已读请求
     * @param passport 用户护照
     */
    MessageReadResponse read(MessageReadRequest req, Passport passport);

}
