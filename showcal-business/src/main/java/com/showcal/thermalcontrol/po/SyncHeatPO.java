/**
 * @(#)SyncHeatPO.java  
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
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public class SyncHeatPO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 餐次,
 */
private  Long   mealsId;

/**
 * 食物热量,
 */
private  Double   totalHeat;

/**
 * 蛋白质(克),
 */
private  Double   totalProtein;

/**
 * 脂肪（克）,
 */
private  Double   totalFat;

/**
 * 碳水化合物（克）,
 */
private  Double   totalCarbohydrate;

/**
 * 膳食纤维（克）,
 */
private  Double   totalDf;

/**
 * 实际评分值,
 */
private  Double   grade;

/**
 * 是否同步完成,
 */
private  Boolean   isSynced;



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

public Double getTotalHeat() {
return this.totalHeat;
}

public void setTotalHeat(Double  totalHeat) {
this.totalHeat = totalHeat;
}

public Double getTotalProtein() {
return this.totalProtein;
}

public void setTotalProtein(Double  totalProtein) {
this.totalProtein = totalProtein;
}

public Double getTotalFat() {
return this.totalFat;
}

public void setTotalFat(Double  totalFat) {
this.totalFat = totalFat;
}

public Double getTotalCarbohydrate() {
return this.totalCarbohydrate;
}

public void setTotalCarbohydrate(Double  totalCarbohydrate) {
this.totalCarbohydrate = totalCarbohydrate;
}

public Double getTotalDf() {
return this.totalDf;
}

public void setTotalDf(Double  totalDf) {
this.totalDf = totalDf;
}

public Double getGrade() {
return this.grade;
}

public void setGrade(Double  grade) {
this.grade = grade;
}

public Boolean getIsSynced() {
return this.isSynced;
}

public void setIsSynced(Boolean  isSynced) {
this.isSynced = isSynced;
}

}