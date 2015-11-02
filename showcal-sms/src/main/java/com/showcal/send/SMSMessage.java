package com.showcal.send;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.send
 *  Description:
 * ***************************************************************
 *  10/23 0023  V1.0  xiniu    New Files for com.showcal.send
 * </pre>
 */
public class SMSMessage {
    /**
     * 手机号码
     */
    private String mobilePhone;
    /**
     * 消息内容
     */
    private String message;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
