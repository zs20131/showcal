/**
 * @(#)SysMessageImport.java
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
package com.showcal.platform.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 * @author 顾志雄
 */
public class SysMessageImport extends  BaseDomain {


/**
 * 业务类型 
 */
private  String   businessType;

/**
 * 业务ID 
 */
private  Long   businessId;

/**
 * 业务类别 
 */
private  String   businessCategory;

/**
 * 收件人用户ID 
 */
private  String   receiptId;

/**
 * 消息标题 
 */
private  String   messageTitle;

/**
 * 消息连接 
 */
private  String   messageUrl;

/**
 * 消息内容 
 */
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
private  String   readTime;



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