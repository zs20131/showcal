package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.security.Passport;

/**
 * Created by DEV001 on 2014/8/13.
 */
public class PassportGetResponse extends BaseResponse {

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
}
