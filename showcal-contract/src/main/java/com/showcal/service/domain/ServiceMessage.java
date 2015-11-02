/**
 * @(#)Message.java 
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
package com.showcal.service.domain;

import com.xiniunet.framework.base.BaseDomain;

import java.sql.Timestamp;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 *
 * @author 顾志雄
 */
public class ServiceMessage extends BaseDomain {


    /**
     * 主键
     */
    private Long id;

    /**
     * 消息类型,
     */
    private MessageBusinessTypeEnum type;

    /**
     * 消息内容类型,
     */
    private MessageTypeEnum messageType;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 问题/答案ＩＤ
     */
    private String serviceId;

    /**
     * 原用户ID 原用户ID
     */
    private Long fromUserId;

    /**
     * 发送的目标用户ID
     */
    private Long toUserId;

    /**
     *  用户头像
     */
    private String avatarurl;

    /**
     *  创建时间
     */
    private Timestamp creationTime;

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

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
}