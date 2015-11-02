package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class MessageCreateRequest extends BaseRequest {

    /**
     * 产品ID,
     */
    private  Long   productId;

    /**
     * 业务类型,
     */
    @Length(min=0,max=100)
    private  String   businessType;

    /**
     * 业务ID,
     */
    private  Long   businessId;

    /**
     * 业务类别,
     */
    @Length(min=0,max=100)
    private  String   businessCategory;

    /**
     * 收件人用户ID,
     */
    @NotNull
    @Min(1)
    private  Long   receiptId;

    /**
     * 消息标题,
     */
    @NotNull
    @NotBlank
    @Length(min=0,max=4000)
    private  String   messageTitle;

    /**
     * 消息连接,
     */
    @Length(min=0,max=500)
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
    @NotNull
    private Date messageTime;

    /**
     * 发送时间,
     */
    private  Date   sendTime;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
