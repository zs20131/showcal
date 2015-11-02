package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 用户登录时的请求对象
 * Created by june on 2014/8/8.
 */
public class LoginRequest extends BaseRequest {
    /**
     * 账号
     */
    @NotBlank(message = "登录账号不能为空")
    private String account;

    /**
     * 登录密码
     */
    @NotNull(message = "登录密码不能为空")
    private String password;

    @NotNull(message = "登录ip不能为空")

    private String ip;

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
