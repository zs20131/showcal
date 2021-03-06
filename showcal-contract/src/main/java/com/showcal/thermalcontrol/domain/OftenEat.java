/**
 * @(#)OftenEat.java 
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
 * Created by 顾志雄 on 2015-09-23 13:32:27.
 * @author 顾志雄
 */
public class OftenEat extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 用户ID 
     */
    private  Long   userId;
    
    /**
     * 食物ID 
     */
    private  Long   foodId;
    
    /**
     * 食物名称 
     */
    private  String   foodName;
    
    /**
     * 单位热量 
     */
    private  Double   unitheat;
    
    /**
     * 食物单位 份，个，碗，盘。。。
     */
    private  String   unit;
    
    /**
     * 每单位重量 
     */
    private  Double   unitWeight;
    
    /**
     * 图片链接地址 
     */
    private  String   pictureUrl;
    

    
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
    
    public Double getUnitheat() {
    return this.unitheat;
    }

    public void setUnitheat(Double  unitheat) {
    this.unitheat = unitheat;
    }
    
    public String getUnit() {
    return this.unit;
    }

    public void setUnit(String  unit) {
    this.unit = unit;
    }
    
    public Double getUnitWeight() {
    return this.unitWeight;
    }

    public void setUnitWeight(Double  unitWeight) {
    this.unitWeight = unitWeight;
    }
    
    public String getPictureUrl() {
    return this.pictureUrl;
    }

    public void setPictureUrl(String  pictureUrl) {
    this.pictureUrl = pictureUrl;
    }
    
}