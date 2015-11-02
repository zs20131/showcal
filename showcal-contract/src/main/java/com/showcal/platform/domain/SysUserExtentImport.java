/**
 * @(#)SysUserExtentImport.java
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
package com.showcal.platform.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
public class SysUserExtentImport extends  BaseDomain {


/**
 * 身高（厘米） 
 */
private  Integer   height;

/**
 * 出生年月 
 */
private  Date   birthday;

/**
 * 年龄 
 */
private  Integer   age;

/**
 * 体重 
 */
private  Double   weight;

/**
 * 腰围 
 */
private  Double   waistLine;

/**
 * 臀围 
 */
private  Double   hipline;

/**
 * BMI值 
 */
private  Double   bmi;

/**
 * 用户设置信息 
 */
private  String   setting;



public Integer getHeight() {
return this.height;
}

public void setHeight(Integer  height) {
this.height = height;
}

public Date getBirthday() {
return this.birthday;
}

public void setBirthday(Date  birthday) {
this.birthday = birthday;
}

public Integer getAge() {
return this.age;
}

public void setAge(Integer  age) {
this.age = age;
}

public Double getWeight() {
return this.weight;
}

public void setWeight(Double  weight) {
this.weight = weight;
}

public Double getWaistLine() {
return this.waistLine;
}

public void setWaistLine(Double  waistLine) {
this.waistLine = waistLine;
}

public Double getHipline() {
return this.hipline;
}

public void setHipline(Double  hipline) {
this.hipline = hipline;
}

public Double getBmi() {
return this.bmi;
}

public void setBmi(Double  bmi) {
this.bmi = bmi;
}

public String getSetting() {
return this.setting;
}

public void setSetting(String  setting) {
this.setting = setting;
}

}