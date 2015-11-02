/**
 * @(#)FoodFindRequest.java
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

import com.xiniunet.framework.base.BaseFindRequest;

import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:56.
 * @author 顾志雄
 */
public class FoodFindRequest extends BaseFindRequest {
    /**
     * 主键
     */
    private  Long   id;

    /**
     * 食物名称
     */
    private  String   name;

    /**
     * 食物重量
     */
    private  Double   weight;

    /**
     * 食物热量
     */
    private  Double   heat;

    /**
     * 单位热量
     */
    private  Double   unitheat;

    /**
     * 蛋白质(克) 单位(克)
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
     * 条形码
     */
    private  String   barCode;

    /**
     * 品牌
     */
    private  String   brand;

    /**
     * 食物交换份克数(克)
     */
    private  Double   foodExchange;

    /**
     * 单位食用克数(克)
     */
    private  Double   edubleUnit;

    /**
     * 食物单位
     */
    private  String   unit;

    /**
     * 每单位重量
     */
    private  Double   unitWeight;

    /**
     * 食物大类
     */
    private  Long   foodLargeCategory;

    /**
     * 食物分类
     */
    private  Long   foodCategoryId;

    /**
     * 减肥是否推荐
     */
    private  Integer   isLose;

    /**
     * 增肌是否推荐
     */
    private  Integer   isAddMuscle;
    /**
     * 是否常见
     */
    private  Integer   isCommon;
    /**
     * 来源ID
     */
    private  Long   sourceId;

    /**
     * 菜谱ID
     */
    private  Long   menuId;

    /**
     * 菜谱类别
     */
    private  Integer   menuCategory;

    /**
     * 是否有效
     */
    private  Boolean   isActive;

    /**
     * 生效日期
     */
    private  Date   activeDate;

    /**
     * 生效人
     */
    private  String   activeUser;


    public Double getHeat() {
        return heat;
    }

    public void setHeat(Double heat) {
        this.heat = heat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getUnitheat() {
        return unitheat;
    }

    public void setUnitheat(Double unitheat) {
        this.unitheat = unitheat;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Double getDf() {
        return df;
    }

    public void setDf(Double df) {
        this.df = df;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getFoodExchange() {
        return foodExchange;
    }

    public void setFoodExchange(Double foodExchange) {
        this.foodExchange = foodExchange;
    }

    public Double getEdubleUnit() {
        return edubleUnit;
    }

    public void setEdubleUnit(Double edubleUnit) {
        this.edubleUnit = edubleUnit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(Double unitWeight) {
        this.unitWeight = unitWeight;
    }

    public Long getFoodLargeCategory() {
        return foodLargeCategory;
    }

    public void setFoodLargeCategory(Long foodLargeCategory) {
        this.foodLargeCategory = foodLargeCategory;
    }

    public Long getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(Long foodCategoryId) {
        this.foodCategoryId = foodCategoryId;
    }

    public Integer getIsLose() {
        return isLose;
    }

    public void setIsLose(Integer isLose) {
        this.isLose = isLose;
    }

    public Integer getIsAddMuscle() {
        return isAddMuscle;
    }

    public void setIsAddMuscle(Integer isAddMuscle) {
        this.isAddMuscle = isAddMuscle;
    }

    public Integer getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(Integer isCommon) {
        this.isCommon = isCommon;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(Integer menuCategory) {
        this.menuCategory = menuCategory;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(String activeUser) {
        this.activeUser = activeUser;
    }
}