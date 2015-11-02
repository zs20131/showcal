/**
 * @(#)SysMessageUpdateRequest.java
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
package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseUpdateRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * Created by 顾志雄 on 2015-09-30 15:41:58.
 * @author 顾志雄
 */
public class SysMessageUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 业务类型 
     */
    @Length(min=1, max=100, message = "业务类型长度不合法")
    private  String   businessType;
    
    /**
     * 业务ID 
     */
    private  Long   businessId;
    
    /**
     * 业务类别 
     */
    
    @Length(min=0, max=50, message = "业务类别长度不合法")
    private  String   businessCategory;
    
    /**
     * 收件人用户ID 
     */
    
    @Length(min=0, max=50, message = "收件人用户ID长度不合法")
    private  String   receiptId;
    
    /**
     * 消息标题 
     */
    
    @Length(min=0, max=50, message = "消息标题长度不合法")
    private  String   messageTitle;
    
    /**
     * 消息连接 
     */
    
    @Length(min=0, max=50, message = "消息连接长度不合法")
    private  String   messageUrl;
    
    /**
     * 消息内容 
     */
    
    @Length(min=0, max=50, message = "消息内容长度不合法")
    private  String   messageContent;
    
    /**
     * 发件人用户ID 
     */
    
    private  Long   senderId;
    
    /**
     * 消息时间 
     */
    
    private  Date   messageTime;
    
    /**
     * 发送时间 
     */
    
    private  Date   sendTime;
    
    /**
     * 是否已读 
     */
    
    private  Boolean   isReaded;
    
    /**
     * 阅读时间 
     */
    
    @Length(min=0, max=50, message = "阅读时间长度不合法")
    private  String   readTime;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getBusinessType() {
    return this.businessType;
    }

    public void setBusinessType(String  businessType) {
    this.businessType = businessType;
    }
    
    public Long getBusinessId() {
    return this.businessId;
    }

    public void setBusinessId(Long  businessId) {
    this.businessId = businessId;
    }
    
    public String getBusinessCategory() {
    return this.businessCategory;
    }

    public void setBusinessCategory(String  businessCategory) {
    this.businessCategory = businessCategory;
    }
    
    public String getReceiptId() {
    return this.receiptId;
    }

    public void setReceiptId(String  receiptId) {
    this.receiptId = receiptId;
    }
    
    public String getMessageTitle() {
    return this.messageTitle;
    }

    public void setMessageTitle(String  messageTitle) {
    this.messageTitle = messageTitle;
    }
    
    public String getMessageUrl() {
    return this.messageUrl;
    }

    public void setMessageUrl(String  messageUrl) {
    this.messageUrl = messageUrl;
    }
    
    public String getMessageContent() {
    return this.messageContent;
    }

    public void setMessageContent(String  messageContent) {
    this.messageContent = messageContent;
    }
    
    public Long getSenderId() {
    return this.senderId;
    }

    public void setSenderId(Long  senderId) {
    this.senderId = senderId;
    }
    
    public Date getMessageTime() {
    return this.messageTime;
    }

    public void setMessageTime(Date  messageTime) {
    this.messageTime = messageTime;
    }
    
    public Date getSendTime() {
    return this.sendTime;
    }

    public void setSendTime(Date  sendTime) {
    this.sendTime = sendTime;
    }
    
    public Boolean getIsReaded() {
    return this.isReaded;
    }

    public void setIsReaded(Boolean  isReaded) {
    this.isReaded = isReaded;
    }
    
    public String getReadTime() {
    return this.readTime;
    }

    public void setReadTime(String  readTime) {
    this.readTime = readTime;
    }
    

}
