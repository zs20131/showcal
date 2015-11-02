/**
 * @(#)SmsCreateRequest.java
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
package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by 沈振家 on 2015-05-19 19:38:52.
 * @author 沈振家
 */
public class SmsSendRequest extends BaseRequest {
    
    /**
     * 业务类型 
     */
    
    @Length(min=0, max=100, message = "业务类型长度不合法")
    private  String   businessType;
    
    /**
     * 业务ID 
     */
    
    private  Long   businessId;
    
    /**
     * 业务类别 
     */
    
    @Length(min=0, max=100, message = "业务类别长度不合法")
    private  String   businessCategory;
    
    /**
     * 收件人用户ID 
     */
    
    private  Long   receiptUserId;
    
    /**
     * 手机号码 
     */
    @NotBlank(message = "手机号码不能为空")
    @Length(min=0, max=50, message = "手机号码长度不合法")
    private  String   mobilePhone;
    
    /**
     * 消息文本 
     */
    
    @Length(min=0, max=4000, message = "消息文本长度不合法")
    private  String   messageText;
    
    /**
     * 发件人用户ID 
     */
    
    private  Long   senderUserId;
    
    /**
     * 消息时间 
     */
    
    private  Date   messageTime;
    
    /**
     * 发送时间 
     */
    
    private  Date   sendTime;
    

    
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
    
    public Date getSendTime() {
    return this.sendTime;
    }

    public void setSendTime(Date  sendTime) {
    this.sendTime = sendTime;
    }
    

}
