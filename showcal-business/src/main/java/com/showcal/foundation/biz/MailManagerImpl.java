/**
 * @(#)Mail.java
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
package com.showcal.foundation.biz;

import com.showcal.foundation.dal.MailMapper;
import com.showcal.foundation.domain.Mail;
import com.showcal.foundation.po.MailPO;
import com.showcal.foundation.request.MailSendRequest;
import com.showcal.foundation.response.MailSendResponse;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 *
 * @author 沈振家
 */
@Transactional
@Service
public class MailManagerImpl extends BaseManagerImpl implements MailManager {
    @Autowired
    private MailMapper mailMapper;
    @Autowired
    private SequenceManager sequenceManager;


    /**
     * 发送邮件
     *
     * @param request  发送邮件请求
     * @param passport 用户护照
     * @return 发送邮件应答
     */
    public MailSendResponse sendMail(MailSendRequest request, Passport passport) {
        MailSendResponse response = new MailSendResponse();
        MailPO entity = getMapper().map(request, MailPO.class);
        Long newId = sequenceManager.getNewId();
        entity.setId(newId);
        mailMapper.insert(entity);
        try {
            Mail mail = this.getMapper().map(entity, Mail.class);
            mail.setId(newId);
            response.setMail(mail);
        } catch (Exception e) {
            e.printStackTrace();
            response.addError(ErrorType.OTHER, e.getLocalizedMessage());
        }
        return response;
    }
}
