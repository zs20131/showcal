package net.showcal.api.response.mobile;

import net.showcal.api.XiniuResponse;
import net.showcal.api.contract.Passport;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.api.response
 *  Description:
 * ***************************************************************
 *  10/17 0017  V1.0  xiniu    New Files for net.showcal.api.response
 * </pre>
 */
public class AuthLoginResponse extends XiniuResponse {
    private Passport passport;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
