package com.showcal.platform.request;

import com.showcal.platform.domain.VerificationTypeEnum;
import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * Created on 2015-05-14.
 *
 * @author 吕浩
 * @since 1.0.0
 */
public class VerificationCodeCreateRequest extends BaseRequest {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 承租人ID
     * @since 2.3.0
     */
    private Long tenantId;
    /**
     * 对象
     */
    private String object;
    /**
     * 存活时间(单位分钟)
     */
    private Integer liveTime;

    /**
     * 验证类型
     */
    @NotNull(message = "验证类型不能为空")
    private VerificationTypeEnum verificationType;


    public Integer getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(Integer liveTime) {
        this.liveTime = liveTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public VerificationTypeEnum getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(VerificationTypeEnum verificationType) {
        this.verificationType = verificationType;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
