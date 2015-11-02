package com.showcal.foundation.po;

import com.xiniunet.framework.base.BaseBO;

/**
 * Created by 范智凝 on 2014-08-1 16:10:30.
 * @author 范智凝
 */
public class AttachmentWithFilePO extends BaseBO {

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
     * 文件名,
     */
    private  String   name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    /**
     * 文件扩展名,
     */
    private  String   extension;

    /**
     * 文件保存路径,
     */
    private  String   storagePath;

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

}
