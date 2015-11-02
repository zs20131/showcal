/**
 * @(#)CommentPostUpdateRequest.java
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
package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseUpdateRequest;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * Created by 顾志雄 on 2015-09-30 15:41:56.
 * @author 顾志雄
 */
public class CommentPostUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
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
    
    @Length(min=1, max=4000, message = "评论内容长度不合法")
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
    
    @Length(min=1, max=50, message = "业务类型长度不合法")
    private  String   businessType;
    
    /**
     * 业务ID 
     */
    
    private  Long   businessId;
    
    /**
     * 业务类别 
     */
    
    @Length(min=1, max=50, message = "业务类别长度不合法")
    private  String   businessCategory;
    
    /**
     * 评论分数 
     */
    
    private  Double   grade;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
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
    
    public Double getGrade() {
    return this.grade;
    }

    public void setGrade(Double  grade) {
    this.grade = grade;
    }
    

}
