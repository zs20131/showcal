/**
 * @(#)MailPO.java
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
public class MailPO extends BasePO {


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
 * 收件人,
 */
private  String   mailReceipt;

/**
 * 邮件标题,
 */
private  String   mailTitle;

/**
 * 邮件内容,
 */
private  String   mailBody;

/**
 * 发件人用户ID,
 */
private  Long   senderId;

/**
 * 发送人地址,
 */
private  String   mailSender;

/**
 * 发送人名称,
 */
private  String   senderName;

/**
 * 邮件时间,
 */
private  Date   mailTime;

/**
 * 发送时间,
 */
private  Date   sendTime;



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

public String getMailReceipt() {
return this.mailReceipt;
}

public void setMailReceipt(String  mailReceipt) {
this.mailReceipt = mailReceipt;
}

public String getMailTitle() {
return this.mailTitle;
}

public void setMailTitle(String  mailTitle) {
this.mailTitle = mailTitle;
}

public String getMailBody() {
return this.mailBody;
}

public void setMailBody(String  mailBody) {
this.mailBody = mailBody;
}

public Long getSenderId() {
return this.senderId;
}

public void setSenderId(Long  senderId) {
this.senderId = senderId;
}

public String getMailSender() {
return this.mailSender;
}

public void setMailSender(String  mailSender) {
this.mailSender = mailSender;
}

public String getSenderName() {
return this.senderName;
}

public void setSenderName(String  senderName) {
this.senderName = senderName;
}

public Date getMailTime() {
return this.mailTime;
}

public void setMailTime(Date  mailTime) {
this.mailTime = mailTime;
}

public Date getSendTime() {
return this.sendTime;
}

public void setSendTime(Date  sendTime) {
this.sendTime = sendTime;
}

}