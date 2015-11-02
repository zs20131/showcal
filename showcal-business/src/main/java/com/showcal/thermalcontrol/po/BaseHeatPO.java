/**
 * @(#)BaseHeatPO.java  
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
 * Created by 顾志雄 on 2015-09-15 13:46:56.
 * @author 顾志雄
 */
public class BaseHeatPO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 性别,
 */
private  String   sex;

/**
 * 起始年龄,
 */
private  Integer   startAge;

/**
 * 结束年龄,
 */
private  Integer   endAge;

/**
 * 起始身高,
 */
private  Integer   startHeight;

/**
 * 结束身高,
 */
private  Integer   endHeight;

/**
 * 疾病情况,
 */
private  Long   diseaseId;

/**
 * 基础热量值,
 */
private  String   baseHeat;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public String getSex() {
return this.sex;
}

public void setSex(String  sex) {
this.sex = sex;
}

public Integer getStartAge() {
return this.startAge;
}

public void setStartAge(Integer  startAge) {
this.startAge = startAge;
}

public Integer getEndAge() {
return this.endAge;
}

public void setEndAge(Integer  endAge) {
this.endAge = endAge;
}

public Integer getStartHeight() {
return this.startHeight;
}

public void setStartHeight(Integer  startHeight) {
this.startHeight = startHeight;
}

public Integer getEndHeight() {
return this.endHeight;
}

public void setEndHeight(Integer  endHeight) {
this.endHeight = endHeight;
}

public Long getDiseaseId() {
return this.diseaseId;
}

public void setDiseaseId(Long  diseaseId) {
this.diseaseId = diseaseId;
}

public String getBaseHeat() {
return this.baseHeat;
}

public void setBaseHeat(String  baseHeat) {
this.baseHeat = baseHeat;
}

}