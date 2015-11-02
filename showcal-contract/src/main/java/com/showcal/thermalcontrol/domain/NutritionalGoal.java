/**
 * @(#)NutritionalGoal.java 
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
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class NutritionalGoal extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 餐次ID 
     */
    private  Long   mealsId;
    
    /**
     * 目标类型 
     */
    private  String   type;
    
    /**
     * 用户餐饮习惯 
     */
    private  String   userHabit;
    
    /**
     * 用户就餐类型 
     */
    private  String   repastType;
    
    /**
     * 热量 
     */
    private  Double   heat;
    
    /**
     * 蛋白质(克) 
     */
    private  Double   protein;
    
    /**
     * 脂肪（克） 
     */
    private  Double   fat;
    
    /**
     * 碳水化合物（克） 
     */
    private  Double   carbohydrate;
    
    /**
     * 膳食纤维（克） 
     */
    private  Double   df;
    
    /**
     * 是否有效 
     */
    private  Boolean   isActive;
    
    /**
     * 生效日期 
     */
    private  Date   activeDate;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public Long getMealsId() {
    return this.mealsId;
    }

    public void setMealsId(Long  mealsId) {
    this.mealsId = mealsId;
    }
    
    public String getType() {
    return this.type;
    }

    public void setType(String  type) {
    this.type = type;
    }
    
    public String getUserHabit() {
    return this.userHabit;
    }

    public void setUserHabit(String  userHabit) {
    this.userHabit = userHabit;
    }
    
    public String getRepastType() {
    return this.repastType;
    }

    public void setRepastType(String  repastType) {
    this.repastType = repastType;
    }
    
    public Double getHeat() {
    return this.heat;
    }

    public void setHeat(Double  heat) {
    this.heat = heat;
    }
    
    public Double getProtein() {
    return this.protein;
    }

    public void setProtein(Double  protein) {
    this.protein = protein;
    }
    
    public Double getFat() {
    return this.fat;
    }

    public void setFat(Double  fat) {
    this.fat = fat;
    }
    
    public Double getCarbohydrate() {
    return this.carbohydrate;
    }

    public void setCarbohydrate(Double  carbohydrate) {
    this.carbohydrate = carbohydrate;
    }
    
    public Double getDf() {
    return this.df;
    }

    public void setDf(Double  df) {
    this.df = df;
    }
    
    public Boolean getIsActive() {
    return this.isActive;
    }

    public void setIsActive(Boolean  isActive) {
    this.isActive = isActive;
    }
    
    public Date getActiveDate() {
    return this.activeDate;
    }

    public void setActiveDate(Date  activeDate) {
    this.activeDate = activeDate;
    }
    
}