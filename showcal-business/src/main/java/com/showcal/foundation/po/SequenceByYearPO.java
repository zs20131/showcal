/**
 * @(#)SequenceByYearPO.java  
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
 * Created by 沈振家 on 2015-02-02 11:46:03.
 * @author 沈振家
 */
public class SequenceByYearPO extends BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 承租人ID,
 */
private  Long   tenantId;

/**
 * 序号ID,
 */
private  Long   sequenceId;

/**
 * 年ID,
 */
private  Integer   yearId;

/**
 * 下一个值,
 */
private  Integer   value;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public Long getTenantId() {
return this.tenantId;
}

public void setTenantId(Long  tenantId) {
this.tenantId = tenantId;
}

public Long getSequenceId() {
return this.sequenceId;
}

public void setSequenceId(Long  sequenceId) {
this.sequenceId = sequenceId;
}

public Integer getYearId() {
return this.yearId;
}

public void setYearId(Integer  yearId) {
this.yearId = yearId;
}

public Integer getValue() {
return this.value;
}

public void setValue(Integer  value) {
this.value = value;
}

}