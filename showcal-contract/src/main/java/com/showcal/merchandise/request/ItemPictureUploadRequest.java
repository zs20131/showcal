package com.showcal.merchandise.request;

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class ItemPictureUploadRequest extends BaseRequest {

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
     * 图片对象
     */
    @NotNull
    private byte[] fileStream;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件后缀
     */
    private String fileExt;

    public byte[] getFileStream() {
        return fileStream;
    }

    public void setFileStream(byte[] fileStream) {
        this.fileStream = fileStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

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
}
