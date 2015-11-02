/**
 * @(#)VerificationManager.java
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
package com.showcal.platform.biz;

import com.showcal.platform.request.VerificationCheckRequest;
import com.showcal.platform.request.VerificationCodeCreateRequest;
import com.showcal.platform.response.VerificationCheckResponse;
import com.showcal.platform.response.VerificationCodeCreateResponse;

/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 *
 * @author 沈振家
 */
public interface    VerificationManager {
    /**
     * 创建验证码
     *
     * @param request 创建验证码请求
     * @return 创建验证码应答
     * @author 吕浩
     * @since 2.3.0
     */
    VerificationCodeCreateResponse createCode(VerificationCodeCreateRequest request);

    /**
     * 验证操作
     *
     * @param req 验证操作请求
     * @return 验证应答
     */
    VerificationCheckResponse check(VerificationCheckRequest req);

}
