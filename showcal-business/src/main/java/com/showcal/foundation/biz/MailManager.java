/**
 * @(#)MailManager.java
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

import com.showcal.foundation.request.MailSendRequest;
import com.showcal.foundation.response.MailSendResponse;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 *
 * @author 沈振家
 */
public interface MailManager {

    /**
     * 发送邮件
     *
     * @param req      发送邮件请求
     * @param passport 用户护照
     * @return 发送邮件应答
     */
    MailSendResponse sendMail(MailSendRequest req, Passport passport);


}
