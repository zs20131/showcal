/**
 * @(#)SyncHeatDetail.java 
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
package com.showcal.thermalcontrol.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public class SyncHeatDetail extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 同步表头ID 
     */
    private  Long   syncHeatId;
    
    /**
     * 食物ID 
     */
    private  Long   foodId;
    
    /**
     * 食物名称 
     */
    private  String   foodName;
    
    /**
     * 食物单位 
     */
    private  String   unit;
    
    /**
     * 推荐值 
     */
    private  Double   recommendValue;
    
    /**
     * 实际值 
     */
    private  Double   actualValue;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public Long getSyncHeatId() {
    return this.syncHeatId;
    }

    public void setSyncHeatId(Long  syncHeatId) {
    this.syncHeatId = syncHeatId;
    }
    
    public Long getFoodId() {
    return this.foodId;
    }

    public void setFoodId(Long  foodId) {
    this.foodId = foodId;
    }
    
    public String getFoodName() {
    return this.foodName;
    }

    public void setFoodName(String  foodName) {
    this.foodName = foodName;
    }
    
    public String getUnit() {
    return this.unit;
    }

    public void setUnit(String  unit) {
    this.unit = unit;
    }
    
    public Double getRecommendValue() {
    return this.recommendValue;
    }

    public void setRecommendValue(Double  recommendValue) {
    this.recommendValue = recommendValue;
    }
    
    public Double getActualValue() {
    return this.actualValue;
    }

    public void setActualValue(Double  actualValue) {
    this.actualValue = actualValue;
    }
    
}