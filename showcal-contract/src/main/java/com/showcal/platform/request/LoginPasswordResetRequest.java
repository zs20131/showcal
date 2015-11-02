package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by june on 2014/8/12.
 */
public class LoginPasswordResetRequest extends BaseRequest {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
