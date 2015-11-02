/**
 * @(#)SettingQuestionTagPO.java  
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
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 * @author 顾志雄
 */
public class SettingQuestionTagPO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 标签名称,
 */
private  String   tag;

/**
 * 标签RGB颜色,
 */
private  String   tagRgb;

/**
 * 备注,
 */
private  String   remark;

/**
 * 是否有效,
 */
private  Boolean   isActive;

/**
 * 生效日期,
 */
private  Date   activeDate;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public String getTag() {
return this.tag;
}

public void setTag(String  tag) {
this.tag = tag;
}

public String getTagRgb() {
return this.tagRgb;
}

public void setTagRgb(String  tagRgb) {
this.tagRgb = tagRgb;
}

public String getRemark() {
return this.remark;
}

public void setRemark(String  remark) {
this.remark = remark;
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