/**
 * @(#)SysUserCurveCreateRequest.java
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
package com.showcal.platform.request;

import com.showcal.platform.domain.CurveTypeEnum;
import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
public class SysUserCurveCreateRequest extends BaseRequest {
    
    /**
     * 关联用户ID 
     */
    
    private  Long   userId;
    
    /**
     * 记录类型 
     */
    
    private CurveTypeEnum type;
    
    /**
     *  
     */
    
    private  Double   value;
    
    /**
     * 记录日期 
     */
    
    @Length(min=0, max=50, message = "记录日期长度不合法")
    private  String   recordDate;
    

    
    public Long getUserId() {
    return this.userId;
    }

    public void setUserId(Long  userId) {
    this.userId = userId;
    }

    public CurveTypeEnum getType() {
        return type;
    }

    public void setType(CurveTypeEnum type) {
        this.type = type;
    }

    public Double getValue() {
    return this.value;
    }

    public void setValue(Double  value) {
    this.value = value;
    }
    
    public String getRecordDate() {
    return this.recordDate;
    }

    public void setRecordDate(String  recordDate) {
    this.recordDate = recordDate;
    }
    

}
