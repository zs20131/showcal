/**
 * @(#)GradeWeightImport.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:57.
 * @author 顾志雄
 */
public class GradeWeightImport extends  BaseDomain {


/**
 * 权重类型 
 */
private  String   type;

/**
 * 权重值 
 */
private  Integer   value;



public String getType() {
return this.type;
}

public void setType(String  type) {
this.type = type;
}

public Integer getValue() {
return this.value;
}

public void setValue(Integer  value) {
this.value = value;
}

}