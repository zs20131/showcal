/**
 * @(#)SportHeadUpdateRequest.java
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

import com.xiniunet.framework.base.BaseUpdateRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;


/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class SportHeadUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 运动头名称 
     */
    @Length(min=0, max=100, message = "运动头名称长度不合法")
    private  String   name;
    
    /**
     * 运动总时长 
     */
    private  Integer   totalTime;
    
    /**
     * 运动强度 高中低
     */
    @Length(min=0, max=50, message = "运动强度长度不合法")
    private  String   intensity;
    
    /**
     * 运动地点 
     */
    @Length(min=0, max=50, message = "运动地点长度不合法")
    private  String   address;
    
    /**
     * BMI起始值 
     */
    private  Double   startBmi;
    
    /**
     * BMI结束值 
     */
    private  Double   endBmi;
    
    /**
     * 有运动损伤是否可以参与 
     */
    private  Boolean   isInjuryJoin;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getName() {
    return this.name;
    }

    public void setName(String  name) {
    this.name = name;
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
    
    public Double getStartBmi() {
    return this.startBmi;
    }

    public void setStartBmi(Double  startBmi) {
    this.startBmi = startBmi;
    }
    
    public Double getEndBmi() {
    return this.endBmi;
    }

    public void setEndBmi(Double  endBmi) {
    this.endBmi = endBmi;
    }
    
    public Boolean getIsInjuryJoin() {
    return this.isInjuryJoin;
    }

    public void setIsInjuryJoin(Boolean  isInjuryJoin) {
    this.isInjuryJoin = isInjuryJoin;
    }
    

}
