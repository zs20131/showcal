/**
 * @(#)SysUserPasswordUpdateRequest.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseUpdateRequest;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 * @author 顾志雄
 */
public class SysUserPasswordUpdateRequest extends BaseUpdateRequest {

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
    @NotNull(message = "旧密码不能为空")
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
