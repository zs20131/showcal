/**
 * @(#)MealsPO.java  
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
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class MealsPO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 时区,
 */
private  String   timeZone;

/**
 * 起始时间,
 */
private  Date   startTime;

/**
 * 结束时间,
 */
private  Date   endTime;

/**
 * 餐次,
 */
private  Integer   mealsNumber;

/**
 * 餐次名称,
 */
private  String   mealsName;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public String getTimeZone() {
return this.timeZone;
}

public void setTimeZone(String  timeZone) {
this.timeZone = timeZone;
}

public Date getStartTime() {
return this.startTime;
}

public void setStartTime(Date  startTime) {
this.startTime = startTime;
}

public Date getEndTime() {
return this.endTime;
}

public void setEndTime(Date  endTime) {
this.endTime = endTime;
}

public Integer getMealsNumber() {
return this.mealsNumber;
}

public void setMealsNumber(Integer  mealsNumber) {
this.mealsNumber = mealsNumber;
}

public String getMealsName() {
return this.mealsName;
}

public void setMealsName(String  mealsName) {
this.mealsName = mealsName;
}

}