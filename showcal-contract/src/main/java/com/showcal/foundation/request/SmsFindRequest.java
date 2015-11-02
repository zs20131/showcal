/**
 * @(#)SmsFindRequest.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseFindRequest;

/**
 * Created by 沈振家 on 2015-05-19 19:38:52.
 * @author 沈振家
 */
public class SmsFindRequest extends BaseFindRequest {

    

    
    

    
    

    
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
     * 收件人用户ID,
     */
    private  Long   receiptUserId;
    
    

    
    /**
     * 手机号码,
     */
    private  String   mobilePhone;
    
    

    
    

    
    

    
    

    
    

    
    
    
    
    
    
    public String getBusinessType() {
    return this.businessType;
    }

    public void setBusinessType(String businessType) {
    this.businessType = businessType;
    }
    
    
    
    public Long getBusinessId() {
    return this.businessId;
    }

    public void setBusinessId(Long businessId) {
    this.businessId = businessId;
    }
    
    
    
    public String getBusinessCategory() {
    return this.businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
    this.businessCategory = businessCategory;
    }
    
    
    
    public Long getReceiptUserId() {
    return this.receiptUserId;
    }

    public void setReceiptUserId(Long receiptUserId) {
    this.receiptUserId = receiptUserId;
    }
    
    
    
    public String getMobilePhone() {
    return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    }
    
    
    
    
    
    
    
    
    
    
}
