/**
 * @(#)SequencePO.java  
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
package com.showcal.foundation.po;

import com.xiniunet.framework.base.BasePO;

/**
 * Created by 沈振家 on 2015-02-02 11:46:02.
 * @author 沈振家
 */
public class SequencePO extends BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 序号代码,采购订单：PUR_ORDER_NUMBER
 */
private  String   code;

/**
 * 前缀,
 */
private  String   prefix;

/**
 * 类型,
 */
private  String   type;

/**
 * 流水长度,
 */
private  Integer   length;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public String getCode() {
return this.code;
}

public void setCode(String  code) {
this.code = code;
}

public String getPrefix() {
return this.prefix;
}

public void setPrefix(String  prefix) {
this.prefix = prefix;
}

public String getType() {
return this.type;
}

public void setType(String  type) {
this.type = type;
}

public Integer getLength() {
return this.length;
}

public void setLength(Integer  length) {
this.length = length;
}

}