/**
 * @(#)SportHeadImport.java
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
public class SportHeadImport extends  BaseDomain {


/**
 * 运动头名称 
 */
private  String   name;

/**
 * 运动总时长 
 */
private  Integer   totalTime;

/**
 * 运动强度 高中低
 */
private  String   intensity;

/**
 * 运动地点 
 */
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