package com.showcal.platform.request;

import com.showcal.platform.domain.OpenTypeEnum;
import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.platform.request
 *  Description:
 * ***************************************************************
 *  10/17 0017  V1.0  xiniu    New Files for com.showcal.platform.request
 * </pre>
 */
public class LoginByOpenIdRequest extends BaseRequest {
    @NotNull(message = "登录类型不能为空")
    private OpenTypeEnum type;
    @NotBlank(message = "OpenId 不能为空")
    private String openId;

    public OpenTypeEnum getType() {
        return type;
    }

    public void setType(OpenTypeEnum type) {
        this.type = type;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
