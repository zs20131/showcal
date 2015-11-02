package net.showcal.home.domain;

import java.io.Serializable;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.single.base.domain
 *  Description:
 * ***************************************************************
 *  7/25 0025  V1.0  xiniu    New Files for com.xiniunet.single.base.domain
 * </pre>
 */
public class LoginDomain implements Serializable {
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
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

