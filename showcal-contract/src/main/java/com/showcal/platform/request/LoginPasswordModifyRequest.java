package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseUpdateRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by DEV001 on 2014/8/14.
 */
public class LoginPasswordModifyRequest extends BaseUpdateRequest {
    /**
     * 主键,
     */
    @NotNull(message = "主键不能为空")
    private Long id;

    /**
     * 登录密码
     */
    @NotNull(message = "登录密码不能为空")
    private String loginPassword;

    /**
     * 旧密码
     */
//    @NotNull(message = "旧密码不能为空")
    private String oldLoginPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getOldLoginPassword() {
        return oldLoginPassword;
    }

    public void setOldLoginPassword(String oldLoginPassword) {
        this.oldLoginPassword = oldLoginPassword;
    }
}
