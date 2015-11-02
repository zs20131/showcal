/**
 * @(#)BmiFoodImport.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:56.
 * @author 顾志雄
 */
public class BmiFoodImport extends  BaseDomain {


/**
 * 起始BMI 
 */
private  Double   startbmi;

/**
 * 结束BMI 
 */
private  Double   endbmi;

/**
 * 食物总重量 
 */
private  Double   totalWeight;

/**
 * 是否有效 
 */
private  Boolean   isActive;

/**
 * 生效日期 
 */
private  Date   activeDate;



public Double getStartbmi() {
return this.startbmi;
}

public void setStartbmi(Double  startbmi) {
this.startbmi = startbmi;
}

public Double getEndbmi() {
return this.endbmi;
}

public void setEndbmi(Double  endbmi) {
this.endbmi = endbmi;
}

public Double getTotalWeight() {
return this.totalWeight;
}

public void setTotalWeight(Double  totalWeight) {
this.totalWeight = totalWeight;
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