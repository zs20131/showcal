/**
 * @(#)Verification.java
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


import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.VerificationMapper;
import com.showcal.platform.domain.VerifyCode;
import com.showcal.platform.po.VerificationPO;
import com.showcal.platform.request.VerificationCheckRequest;
import com.showcal.platform.request.VerificationCodeCreateRequest;
import com.showcal.platform.response.VerificationCheckResponse;
import com.showcal.platform.response.VerificationCodeCreateResponse;
import com.showcal.platform.utils.VerifyUtil;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 *
 * @author 沈振家
 */
@Transactional
@Service
public class VerificationManagerImpl extends BaseManagerImpl implements VerificationManager {

    @Autowired
    private VerificationMapper verificationMapper;

    @Autowired
    private FoundationService foundationService;

    /**
     * 创建验证码
     *
     * @param request 创建验证码请求
     * @return 创建验证码应答
     * @author 吕浩
     * @since 2.3.0
     */
    @Override
    public VerificationCodeCreateResponse createCode(VerificationCodeCreateRequest request) {
        // 创建应答对象
        VerificationCodeCreateResponse response = new VerificationCodeCreateResponse();

        // 将请求中的数据映射给PO
        VerificationPO entity = this.getMapper().map(request, VerificationPO.class);

        // 获取唯一ID
        Long newId = foundationService.getNewId();

        // 取得加密后的验证码
//        VerifyUtil verifyUtil = new VerifyUtil();
//        VerifyCode verifyCode = verifyUtil.getRandcode();
        String verificationCode = genVerificationCode();
        // 设定唯一ID
        entity.setId(newId);
        // 设定验证码
        entity.setCode(verificationCode);
        // 设定验证时间
        entity.setActiveDate(new Date());
        // 设定失效时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 1);
        entity.setInactiveDate(calendar.getTime());
        // 设定验证类型
        entity.setType(request.getVerificationType());
        // 执行创建操作
        verificationMapper.insert(entity);

        // 将验证码应答返回
        response.setVerificationCode(verificationCode);
        return response;
    }

    private String genVerificationCode() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += random.nextInt(10);
        }
        return result;
    }

    /**
     * 验证操作
     *
     * @param req 验证操作请求
     * @return 验证应答
     */
    @Override
    public VerificationCheckResponse check(VerificationCheckRequest req) {
        VerificationCheckResponse response = new VerificationCheckResponse();
        // 将请求中的数据映射给PO
        VerificationPO entity = this.getMapper().map(req, VerificationPO.class);
        entity.setInactiveDate(new Date());

        // 执行验证
        VerificationPO verificationPO = verificationMapper.check(entity);
        if (verificationPO == null) {
            response.setIsVerificated(false);
        } else {
            // 验证完成后，删除
            verificationMapper.delete(verificationPO.getId(), new Passport());
            response.setIsVerificated(true);
            response.setId(verificationPO.getUserId());
        }
        return response;
    }
}
