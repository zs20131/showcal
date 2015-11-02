/**
 * @(#)SyncSportCreateRequest.java
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
package com.showcal.thermalcontrol.request;

import com.xiniunet.framework.base.BaseRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public class SyncSportCreateRequest extends BaseRequest {
    
    /**
     * 执行的运动方案ID 
     */
    
    private  Long   sportHeadId;
    
    /**
     * 本次运动总时长 
     */
    
    private  Integer   totalTime;
    
    /**
     * 运动强度 高中低
     */
    @NotBlank(message = "运动强度不能为空")
    @Length(min=0, max=50, message = "运动强度长度不合法")
    private  String   intensity;
    
    /**
     * 运动地点 
     */
    @NotBlank(message = "运动地点不能为空")
    @Length(min=0, max=50, message = "运动地点长度不合法")
    private  String   address;
    
    /**
     * 是否同步完成 
     */
    
    private  Boolean   isSynced;
    

    
    public Long getSportHeadId() {
    return this.sportHeadId;
    }

    public void setSportHeadId(Long  sportHeadId) {
    this.sportHeadId = sportHeadId;
    }
    
    public Integer getTotalTime() {
    return this.totalTime;
    }

    public void setTotalTime(Integer  totalTime) {
    this.totalTime = totalTime;
    }
    
    public String getIntensity() {
    return this.intensity;
    }

    public void setIntensity(String  intensity) {
    this.intensity = intensity;
    }
    
    public String getAddress() {
    return this.address;
    }

    public void setAddress(String  address) {
    this.address = address;
    }
    
    public Boolean getIsSynced() {
    return this.isSynced;
    }

    public void setIsSynced(Boolean  isSynced) {
    this.isSynced = isSynced;
    }
    

}
