package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class AttachmentUploadByFileIdRequest extends BaseRequest {

    /**
     * 业务类型
     */
    @NotNull
    @Length(min=1,max=100)
    @NotBlank
    private String businessType;

    /**
     * 业务ID
     */
    @NotNull
    @Min(1)
    private Long businessId;

    /**
     * 业务类别
     */
    @Length(min=0,max=100)
    private String businessCategory;

    /**
     * 文件ID
     */
    @NotNull(message = "文件ID不能为空")
    private Long fileId;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
