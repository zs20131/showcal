/**
 * @(#)FoodExchangePO.java  
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
package com.showcal.thermalcontrol.po;

import com.xiniunet.framework.base.BasePO;
import java.util.Date;
/**
 * Created by 顾志雄 on 2015-09-15 13:46:57.
 * @author 顾志雄
 */
public class FoodExchangePO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 餐次ID,
 */
private  Long   mealsId;

/**
 * 基础热量值,
 */
private  Double   baseHeat;

/**
 * 总交换份,
 */
private  Double   totalExchange;

/**
 * 蔬果类,
 */
private  Double   vegetable;

/**
 * 肉蛋奶类,
 */
private  Double   meatEgg;

/**
 * 主食类,
 */
private  Double   stapleFood;

/**
 * 油脂类,
 */
private  Double   grease;

/**
 * 是否有效,
 */
private  Boolean   isActive;

/**
 * 生效日期,
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

public Double getBaseHeat() {
return this.baseHeat;
}

public void setBaseHeat(Double  baseHeat) {
this.baseHeat = baseHeat;
}

public Double getTotalExchange() {
return this.totalExchange;
}

public void setTotalExchange(Double  totalExchange) {
this.totalExchange = totalExchange;
}

public Double getVegetable() {
return this.vegetable;
}

public void setVegetable(Double  vegetable) {
this.vegetable = vegetable;
}

public Double getMeatEgg() {
return this.meatEgg;
}

public void setMeatEgg(Double  meatEgg) {
this.meatEgg = meatEgg;
}

public Double getStapleFood() {
return this.stapleFood;
}

public void setStapleFood(Double  stapleFood) {
this.stapleFood = stapleFood;
}

public Double getGrease() {
return this.grease;
}

public void setGrease(Double  grease) {
this.grease = grease;
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