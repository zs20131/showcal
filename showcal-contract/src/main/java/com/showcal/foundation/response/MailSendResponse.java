package com.showcal.foundation.response;

import com.showcal.foundation.domain.Mail;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class MailSendResponse extends BaseResponse {

    /**
     * 邮件信息
     */
    private Mail mail;

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }
}
