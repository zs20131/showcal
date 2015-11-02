/**
 * @(#)AttachmentSO.java
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
import com.xiniunet.framework.base.BaseSO;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 * @author 沈振家
 */
public class AttachmentSO extends BaseSO {

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 业务主键
     */
    private Long businessId;

    /**
     * 业务类别
     */
    private String businessCategory;

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