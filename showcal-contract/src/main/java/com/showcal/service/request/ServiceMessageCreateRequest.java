/**
 * @(#)MessageCreateRequest.java
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
package com.showcal.service.request;

import com.showcal.service.domain.MessageBusinessTypeEnum;
import com.showcal.service.domain.MessageTypeEnum;
import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;

/**
 * Created by 顾志雄 on 2015-09-23 10:27:34.
 *
 * @author 顾志雄
 */
public class ServiceMessageCreateRequest extends BaseRequest {

    /**
     * 消息类型
     */

    private MessageBusinessTypeEnum type;

    /**
     * 消息内容类型
     */
    private MessageTypeEnum messageType;

    /**
     * 消息内容
     */

    @Length(min = 1, max = 1000, message = "消息内容长度不合法")
    private String content;
    /**
     * 链接地址
     */
    private String url;
    /**
     * 问题/答案ＩＤ
     */
    private Long serviceId;


    /**
     * 原用户ID 原用户ID
     */
    private Long fromUserId;

    /**
     * 发送的目标用户ID
     */
    private Long toUserId;

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MessageBusinessTypeEnum getType() {
        return type;
    }

    public void setType(MessageBusinessTypeEnum type) {
        this.type = type;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
