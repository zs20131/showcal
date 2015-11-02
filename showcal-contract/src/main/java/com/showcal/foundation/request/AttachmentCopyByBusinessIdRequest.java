package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * Created on 2015-05-06.
 *
 * @author 吕浩
 * @since 2.1.0
 */
public class AttachmentCopyByBusinessIdRequest extends BaseRequest {

    /**
     * 业务类型
     */
    @NotNull(message = "源业务类型不能为空")
    private String businessType;

    /**
     * 业务类别
     */
    @NotNull(message = "源业务类别不能为空")
    private String businessCategory;

    /**
     * 源业务ID
     */
    @NotNull(message = "源业务ID不能为空")
    private Long sourceId;

    /**
     * 目标业务ID
     */
    @NotNull(message = "目标业务ID不能为空")
    private Long targetId;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }
}
