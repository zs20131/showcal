package com.showcal.foundation.domain;

import com.xiniunet.framework.base.BaseBO;

/**
 * Created by 范智凝 on 2014-08-1 16:10:30.
 * @author 范智凝
 */
public class Attachment extends BaseBO {

    /**
     * 主键,
     */
    private  Long   id;

    /**
     * 承租人ID,
     */
    private  Long   tenantId;

    /**
     * 业务类型,
     */
    private  String   businessType;

    /**
     * 业务ID,
     */
    private  Long   businessId;

    /**
     * 业务类别,
     */
    private  String   businessCategory;

    /**
     * 文件ID,
     */
    private  Long   fileId;

    /**
     * 文件路径,
     */
    private  String   filePath;

    /**
     * 文件显示名
     */
    private String displayName;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long  id) {
        this.id = id;
    }

    public Long getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(Long  tenantId) {
        this.tenantId = tenantId;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public void setBusinessType(String  businessType) {
        this.businessType = businessType;
    }

    public Long getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(Long  businessId) {
        this.businessId = businessId;
    }

    public String getBusinessCategory() {
        return this.businessCategory;
    }

    public void setBusinessCategory(String  businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Long getFileId() {
        return this.fileId;
    }

    public void setFileId(Long  fileId) {
        this.fileId = fileId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
