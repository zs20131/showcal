package com.showcal.foundation.domain;

import com.xiniunet.framework.base.BaseBO;

import java.util.Date;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class Mail extends BaseBO {

    /**
     * 邮件ID
     */
    private Long id;

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
    private Date mailTime;

    /**
     * 发送时间,
     */
    private  Date   sendTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
