/**
 * @(#)AttachmentPO.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.foundation.po;

import com.xiniunet.framework.base.BasePO;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 * @author 沈振家
 */
public class AttachmentPO extends BasePO {


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