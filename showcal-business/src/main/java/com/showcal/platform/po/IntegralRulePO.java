/**
 * @(#)IntegralRulePO.java  
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
package com.showcal.platform.po;

import com.xiniunet.framework.base.BasePO;
import java.util.Date;
/**
 * Created by 顾志雄 on 2015-09-17 11:08:00.
 * @author 顾志雄
 */
public class IntegralRulePO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * ,LOGIN(登录),
USERTC（使用热控工具）,
QUESTION(提问),REPLY(回帖)，FORWORD(转发)
 */
private  String   type;

/**
 * 积分内容,
 */
private  String   content;

/**
 * 规则对应的积分状态(增加/消费),
 */
private  Integer   status;

/**
 * 积分值,
 */
private  Integer   value;

/**
 * 是否设置每天上限,
 */
private  Boolean   isSetup;

/**
 * 开始时间,
 */
private  Date   startTime;

/**
 * 结束时间,
 */
private  Date   endTime;

/**
 * 备注,
 */
private  String   remark;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public String getType() {
return this.type;
}

public void setType(String  type) {
this.type = type;
}

public String getContent() {
return this.content;
}

public void setContent(String  content) {
this.content = content;
}

public Integer getStatus() {
return this.status;
}

public void setStatus(Integer  status) {
this.status = status;
}

public Integer getValue() {
return this.value;
}

public void setValue(Integer  value) {
this.value = value;
}

public Boolean getIsSetup() {
return this.isSetup;
}

public void setIsSetup(Boolean  isSetup) {
this.isSetup = isSetup;
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

public String getRemark() {
return this.remark;
}

public void setRemark(String  remark) {
this.remark = remark;
}

}