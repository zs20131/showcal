package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class MailSendRequest extends BaseRequest {

    /**
     * 邮件承租人ID
     */
    private Long tenantId;

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
    private  Long   receiptId;

    /**
     * 收件人,
     */
    @NotNull
    @NotBlank
    @Email
    @Length(min=0,max=500)
    private  String   mailReceipt;

    /**
     * 邮件标题,
     */
    @NotNull
    @NotBlank
    @Length(min=0,max=4000)
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
    @Length(min=0,max=500)
    private  String   mailSender;

    /**
     * 发送人名称,
     */
    @Length(min=0,max=500)
    private  String   senderName;

    /**
     * 邮件时间,
     */
    private Date mailTime;

    /**
     * 发送时间,
     */
    private  Date   sendTime;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

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

    public String getMailReceipt() {
        return mailReceipt;
    }

    public void setMailReceipt(String mailReceipt) {
        this.mailReceipt = mailReceipt;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getMailSender() {
        return mailSender;
    }

    public void setMailSender(String mailSender) {
        this.mailSender = mailSender;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date getMailTime() {
        return mailTime;
    }

    public void setMailTime(Date mailTime) {
        this.mailTime = mailTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
