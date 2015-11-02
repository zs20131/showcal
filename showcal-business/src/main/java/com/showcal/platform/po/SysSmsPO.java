/**
 * @(#)SysSmsPO.java  
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
package com.showcal.platform.po;

import com.xiniunet.framework.base.BasePO;
import java.util.Date;
/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
public class SysSmsPO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

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
private  Long   receiptUserId;

/**
 * 手机号码,
 */
private  String   mobilePhone;

/**
 * 消息文本,
 */
private  String   messageText;

/**
 * 发件人用户ID,
 */
private  Long   senderUserId;

/**
 * 消息时间,
 */
private  Date   messageTime;

/**
 * 是否已发送,
 */
private  Boolean   isSend;

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

public Long getReceiptUserId() {
return this.receiptUserId;
}

public void setReceiptUserId(Long  receiptUserId) {
this.receiptUserId = receiptUserId;
}

public String getMobilePhone() {
return this.mobilePhone;
}

public void setMobilePhone(String  mobilePhone) {
this.mobilePhone = mobilePhone;
}

public String getMessageText() {
return this.messageText;
}

public void setMessageText(String  messageText) {
this.messageText = messageText;
}

public Long getSenderUserId() {
return this.senderUserId;
}

public void setSenderUserId(Long  senderUserId) {
this.senderUserId = senderUserId;
}

public Date getMessageTime() {
return this.messageTime;
}

public void setMessageTime(Date  messageTime) {
this.messageTime = messageTime;
}

public Boolean getIsSend() {
return this.isSend;
}

public void setIsSend(Boolean  isSend) {
this.isSend = isSend;
}

public Date getSendTime() {
return this.sendTime;
}

public void setSendTime(Date  sendTime) {
this.sendTime = sendTime;
}

}