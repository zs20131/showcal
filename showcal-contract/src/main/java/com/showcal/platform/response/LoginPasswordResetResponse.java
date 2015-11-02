package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * 用户登录密码
 * Created by june on 2014/8/8.
 */
public class LoginPasswordResetResponse extends BaseResponse {

    /**
     * 重置的结果
     */
    private String result;
    /**
     *  返回的新密码
     */
    private String newPassword;

    /**
     *  手机号码
     */
    private String mobilePhone;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
