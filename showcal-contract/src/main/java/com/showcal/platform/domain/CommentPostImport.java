/**
 * @(#)CommentPostImport.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:50.
 * @author 顾志雄
 */
public class CommentPostImport extends  BaseDomain {


/**
 * 父评论发布ID 
 */
private  Long   parentId;

/**
 * 根评论发布ID 
 */
private  Long   rootId;

/**
 * 评论内容 
 */
private  String   content;

/**
 * 是否匿名 
 */
private  Boolean   isAnonymous;

/**
 * 评论用户ID 
 */
private  Long   userId;

/**
 * 评论发布时间 
 */
private  Date   postTime;

/**
 * 评论对象ID 
 */
private  Long   threadId;

/**
 * 业务类型 
 */
private  String   businessType;

/**
 * 业务ID 
 */
private  Long   businessId;

/**
 * 业务类别 
 */
private  String   businessCategory;



public Long getParentId() {
return this.parentId;
}

public void setParentId(Long  parentId) {
this.parentId = parentId;
}

public Long getRootId() {
return this.rootId;
}

public void setRootId(Long  rootId) {
this.rootId = rootId;
}

public String getContent() {
return this.content;
}

public void setContent(String  content) {
this.content = content;
}

public Boolean getIsAnonymous() {
return this.isAnonymous;
}

public void setIsAnonymous(Boolean  isAnonymous) {
this.isAnonymous = isAnonymous;
}

public Long getUserId() {
return this.userId;
}

public void setUserId(Long  userId) {
this.userId = userId;
}

public Date getPostTime() {
return this.postTime;
}

public void setPostTime(Date  postTime) {
this.postTime = postTime;
}

public Long getThreadId() {
return this.threadId;
}

public void setThreadId(Long  threadId) {
this.threadId = threadId;
}

public String getBusinessType() {
return this.businessType;
}

public void setBusinessType(String  businessType) {
this.businessType = businessType;
}

public Long getBusinessId() {
return this.businessId;
}

public void setBusinessId(Long  businessId) {
this.businessId = businessId;
}

public String getBusinessCategory() {
return this.businessCategory;
}

public void setBusinessCategory(String  businessCategory) {
this.businessCategory = businessCategory;
}

}