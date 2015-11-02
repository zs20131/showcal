package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created on 2015-05-14.
 *
 * @author 吕浩
 * @since 1.0.0
 */
public class VerificationCodeCreateResponse extends BaseResponse {

    /**
     * 验证码
     */
    private String verificationCode;

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
