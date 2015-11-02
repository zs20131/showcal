package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.security.Passport;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.platform.response
 *  Description:
 * ***************************************************************
 *  10/17 0017  V1.0  xiniu    New Files for com.showcal.platform.response
 * </pre>
 */
public class LoginByOpenIdResponse extends BaseResponse{
    private Passport passport;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
