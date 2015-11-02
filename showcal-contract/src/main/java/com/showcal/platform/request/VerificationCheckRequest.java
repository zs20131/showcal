package com.showcal.platform.request;

import com.showcal.platform.domain.VerificationTypeEnum;
import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by DEV001 on 2014/8/14.
 */
public class VerificationCheckRequest extends BaseRequest {

    /**
     * 验证码
     */
    @NotNull(message = "验证码不能为空")
    private String code;

    /**
     * 验证类型
     */
    @NotNull(message = "验证类型不能为空")
    private VerificationTypeEnum type;
    /**
     * 验证类型(手机号.邮件)
     */
    private String object;
    /**
     * 承租人ID
     */
    private Long tenantId;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VerificationTypeEnum getType() {
        return type;
    }

    public void setType(VerificationTypeEnum type) {
        this.type = type;
    }
}
