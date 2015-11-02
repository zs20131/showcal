package net.showcal.open.api.request;

import com.xiniunet.apiframework.AbstractApiRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.open.api.request
 *  Description:
 * ***************************************************************
 *  10/15 0015  V1.0  xiniu    New Files for net.showcal.open.api.request
 * </pre>
 */
public class LoginRequest extends AbstractApiRequest {
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
