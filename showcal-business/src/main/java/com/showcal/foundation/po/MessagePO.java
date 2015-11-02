/**
 * @(#)MessagePO.java
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
package com.showcal.foundation.po;

import com.xiniunet.framework.base.BasePO;

import java.util.Date;

/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 * @author 沈振家
 */
public class MessagePO extends BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 承租人ID,
 */
private  Long   tenantId;

/**
 * 产品ID,
 */
private  Long   productId;

/**
 * 业务类型,
 */
private  String   businessType;

/**
 * 业务ID,
 */
private  Long   businessId;

/**
 * 业务类别,
 */
private  String   businessCategory;

/**
 * 收件人用户ID,
 */
private  Long   receiptId;

/**
 * 消息标题,
 */
private  String   messageTitle;

/**
 * 消息连接,
 */
private  String   messageUrl;

/**
 * 消息内容,
 */
private  String   messageContent;

/**
 * 发件人用户ID,
 */
private  Long   senderId;

/**
 * 消息时间,
 */
private  Date   messageTime;

/**
 * 发送时间,
 */
private  Date   sendTime;

/**
 * 阅读时间,
 */
private  Date   readTime;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public Long getTenantId() {
return this.tenantId;
}

public void setTenantId(Long  tenantId) {
this.tenantId = tenantId;
}

public Long getProductId() {
return this.productId;
}

public void setProductId(Long  productId) {
this.productId = productId;
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

public Long getReceiptId() {
return this.receiptId;
}

public void setReceiptId(Long  receiptId) {
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

public Date getReadTime() {
return this.readTime;
}

public void setReadTime(Date  readTime) {
this.readTime = readTime;
}

}