package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.security.Passport;

/**
 * Created by june on 2014/8/13.
 */
public class LoginResponse extends BaseResponse {
    /**
     * 是否需要修改密码
     */
    private Boolean needUpdateLogin;
    /**
     * 用户护照
     */
    private Passport passport;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Boolean getNeedUpdateLogin() {
        return needUpdateLogin;
    }

    public void setNeedUpdateLogin(Boolean needUpdateLogin) {
        this.needUpdateLogin = needUpdateLogin;
    }
}
