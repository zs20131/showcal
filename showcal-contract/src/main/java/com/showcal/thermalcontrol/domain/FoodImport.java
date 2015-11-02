/**
 * @(#)FoodImport.java
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
import com.xiniunet.framework.util.excel.annotation.Description;
import com.xiniunet.framework.util.excel.annotation.Name;
import com.xiniunet.framework.util.excel.annotation.Type;
import com.xiniunet.framework.util.excel.enumeration.DataType;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:56.
 *
 * @author 顾志雄
 */
public class FoodImport extends BaseDomain {


    /**
     * 食物名称
     */
    @Name("食物名称")
    @Type(DataType.STRING)
    @NotNull
    private String name;

    /**
     * 食物重量
     */
    @Name("食物重量")
    @Type(DataType.DECIMAL)
    @NotNull
    private Double weight;

    /**
     * 食物热量
     */
    @Name("食物热量")
    @Type(DataType.DECIMAL)
    private Double heat;

    /**
     * 单位热量
     */
    @Name("单位热量")
    @Type(DataType.DECIMAL)
    private Double unitheat;

    /**
     * 蛋白质(克) 单位(克)
     */
    @Name("蛋白质(克)")
    @Type(DataType.DECIMAL)
    private Double protein;

    /**
     * 脂肪（克）
     */
    @Name("脂肪(克)")
    @Type(DataType.DECIMAL)
    private Double fat;

    /**
     * 碳水化合物（克）
     */
    @Name("碳水化合物(克)")
    @Type(DataType.DECIMAL)
    private Double carbohydrate;

    /**
     * 膳食纤维（克）
     */
    @Name("膳食纤维(克)")
    @Type(DataType.DECIMAL)
    private Double df;

    /**
     * 条形码
     */
    @Name("条形码")
    @Type(DataType.STRING)
    private String barCode;

    /**
     * 品牌
     */
    @Name("品牌")
    @Type(DataType.STRING)
    private String brand;

    /**
     * 食物交换份克数(克)
     */
    @Name("食物交换份克数(克)")
    @Type(DataType.DECIMAL)
    private Double foodExchange;

    /**
     * 单位食用克数(克)
     */
    @Name("单位食用克数(克)")
    @Type(DataType.DECIMAL)
    private Double edubleUnit;

    /**
     * 食物单位
     */
    @Name("食物单位")
    @Type(DataType.STRING)
    private String unit;

    /**
     * 每单位重量
     */
    @Name("每单位重量")
    @Type(DataType.DECIMAL)
    private Double unitWeight;

    /**
     * 食物大类
     */
    @Name("食物大类")
    @Type(DataType.LONG)
    private Long foodLargeCategory;

    /**
     * 食物分类
     */
    @Name("食物分类")
    @Type(DataType.LONG)
    private Long foodCategoryId;

    /**
     * 减肥是否推荐
     */
    @Name("减肥是否推荐")
    @Type(DataType.NUMBER)
    @Description("1 早餐推荐,2午餐推荐,3晚餐推荐,空为不推荐")
    private Integer isLose;

    /**
     * 增肌是否推荐
     */
    @Name("增肌是否推荐")
    @Type(DataType.NUMBER)
    @Description("1 早餐推荐,2午餐推荐,3晚餐推荐,空为不推荐")
    private Integer isAddMuscle;

    /**
     * 是否常见
     */
    @Name("是否常见")
    @Type(DataType.NUMBER)
    @Description("1 早餐推荐,2午餐推荐,3晚餐推荐,空为不推荐")
    private Integer isCommon;

    /**
     * 来源ID
     */
    @Name("来源ID")
    @Type(DataType.LONG)
    @Description("食品的来源ID")
    private Long sourceId;

    /**
     * 菜谱ID
     */
    private Long menuId;

    /**
     * 菜谱类别
     */
    private Integer menuCategory;

    /**
     * 是否有效
     */
    private Boolean isActive;

    /**
     * 生效日期
     */
    private Date activeDate;

    /**
     * 生效人
     */
    private String activeUser;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeat() {
        return this.heat;
    }

    public void setHeat(Double heat) {
        this.heat = heat;
    }

    public Double getUnitheat() {
        return this.unitheat;
    }

    public void setUnitheat(Double unitheat) {
        this.unitheat = unitheat;
    }

    public Double getProtein() {
        return this.protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return this.fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrate() {
        return this.carbohydrate;
    }

    public void setCarbohydrate(Double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Double getDf() {
        return this.df;
    }

    public void setDf(Double df) {
        this.df = df;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getFoodExchange() {
        return this.foodExchange;
    }

    public void setFoodExchange(Double foodExchange) {
        this.foodExchange = foodExchange;
    }

    public Double getEdubleUnit() {
        return this.edubleUnit;
    }

    public void setEdubleUnit(Double edubleUnit) {
        this.edubleUnit = edubleUnit;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnitWeight() {
        return this.unitWeight;
    }

    public void setUnitWeight(Double unitWeight) {
        this.unitWeight = unitWeight;
    }

    public Long getFoodLargeCategory() {
        return this.foodLargeCategory;
    }

    public void setFoodLargeCategory(Long foodLargeCategory) {
        this.foodLargeCategory = foodLargeCategory;
    }

    public Long getFoodCategoryId() {
        return this.foodCategoryId;
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

    public void setIsCommon(Integer isCommon) {
        this.isCommon = isCommon;
    }

    public Long getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuCategory() {
        return this.menuCategory;
    }

    public void setMenuCategory(Integer menuCategory) {
        this.menuCategory = menuCategory;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getActiveDate() {
        return this.activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getActiveUser() {
        return this.activeUser;
    }

    public void setActiveUser(String activeUser) {
        this.activeUser = activeUser;
    }

    public Integer getIsCommon() {
        return isCommon;
    }
}