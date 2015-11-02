/**
 * @(#)SysUserCurveUpdateRequest.java
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

import com.xiniunet.framework.base.BaseUpdateRequest;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
public class SysUserCurveUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 关联用户ID 
     */
    
    private  Long   userId;
    
    /**
     * 记录类型 
     */
    
    @Length(min=0, max=50, message = "记录类型长度不合法")
    private  String   type;
    
    /**
     *  
     */
    
    private  Double   value;
    
    /**
     * 记录日期 
     */
    
    @Length(min=0, max=50, message = "记录日期长度不合法")
    private  String   recordDate;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public Long getUserId() {
    return this.userId;
    }

    public void setUserId(Long  userId) {
    this.userId = userId;
    }
    
    public String getType() {
    return this.type;
    }

    public void setType(String  type) {
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
