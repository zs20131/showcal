/**
 * @(#)CategoryImport.java
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
package com.showcal.cms.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class CategoryImport extends  BaseDomain {


/**
 * 文章类别名称 
 */
private  String   name;

/**
 * 文章类别描述 
 */
private  String   description;

/**
 * 是否需要审核 
 */
private  Boolean   isNeedApprove;

/**
 * 审核人ID 
 */
private  Long   approveUserId;

/**
 * 审核人员姓名 
 */
private  String   approveUserName;

/**
 * 排序索引 
 */
private  Integer   orderIndex;

/**
 * 父类别ID 
 */
private  Long   parentId;



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

public Boolean getIsNeedApprove() {
return this.isNeedApprove;
}

public void setIsNeedApprove(Boolean  isNeedApprove) {
this.isNeedApprove = isNeedApprove;
}

public Long getApproveUserId() {
return this.approveUserId;
}

public void setApproveUserId(Long  approveUserId) {
this.approveUserId = approveUserId;
}

public String getApproveUserName() {
return this.approveUserName;
}

public void setApproveUserName(String  approveUserName) {
this.approveUserName = approveUserName;
}

public Integer getOrderIndex() {
return this.orderIndex;
}

public void setOrderIndex(Integer  orderIndex) {
this.orderIndex = orderIndex;
}

public Long getParentId() {
return this.parentId;
}

public void setParentId(Long  parentId) {
this.parentId = parentId;
}

}