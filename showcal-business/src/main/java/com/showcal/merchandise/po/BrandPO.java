/**
 * @(#)BrandPO.java  
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
package com.showcal.merchandise.po;

import com.xiniunet.framework.base.BasePO;
import java.util.Date;
/**
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 * @author 顾志雄
 */
public class BrandPO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 品牌代码,
 */
private  String   code;

/**
 * 品牌名称,
 */
private  String   name;

/**
 * 描述,
 */
private  String   description;

/**
 * 排序索引,
 */
private  Integer   orderIndex;



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

public String getName() {
return this.name;
}

public void setName(String  name) {
this.name = name;
}

public String getDescription() {
return this.description;
}

public void setDescription(String  description) {
this.description = description;
}

public Integer getOrderIndex() {
return this.orderIndex;
}

public void setOrderIndex(Integer  orderIndex) {
this.orderIndex = orderIndex;
}

}