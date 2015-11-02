/**
 * @(#)BaseHeatUpdateRequest.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:56.
 * @author 顾志雄
 */
public class BaseHeatUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 性别 
     */
    @NotBlank(message = "性别不能为空")
    @Length(min=0, max=50, message = "性别长度不合法")
    private  String   sex;
    
    /**
     * 起始年龄 
     */
    @NotNull(message = "起始年龄不能为空")
    private  Integer   startAge;
    
    /**
     * 结束年龄 
     */
    @NotNull(message = "结束年龄不能为空")
    private  Integer   endAge;
    
    /**
     * 起始身高 
     */
    @NotNull(message = "起始身高不能为空")
    private  Integer   startHeight;
    
    /**
     * 结束身高 
     */
    @NotNull(message = "结束身高不能为空")
    private  Integer   endHeight;
    
    /**
     * 疾病情况 
     */
    
    private  Long   diseaseId;
    
    /**
     * 基础热量值 
     */
    @NotBlank(message = "基础热量值不能为空")
    @Length(min=0, max=50, message = "基础热量值长度不合法")
    private  String   baseHeat;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getSex() {
    return this.sex;
    }

    public void setSex(String  sex) {
    this.sex = sex;
    }
    
    public Integer getStartAge() {
    return this.startAge;
    }

    public void setStartAge(Integer  startAge) {
    this.startAge = startAge;
    }
    
    public Integer getEndAge() {
    return this.endAge;
    }

    public void setEndAge(Integer  endAge) {
    this.endAge = endAge;
    }
    
    public Integer getStartHeight() {
    return this.startHeight;
    }

    public void setStartHeight(Integer  startHeight) {
    this.startHeight = startHeight;
    }
    
    public Integer getEndHeight() {
    return this.endHeight;
    }

    public void setEndHeight(Integer  endHeight) {
    this.endHeight = endHeight;
    }
    
    public Long getDiseaseId() {
    return this.diseaseId;
    }

    public void setDiseaseId(Long  diseaseId) {
    this.diseaseId = diseaseId;
    }
    
    public String getBaseHeat() {
    return this.baseHeat;
    }

    public void setBaseHeat(String  baseHeat) {
    this.baseHeat = baseHeat;
    }
    

}
