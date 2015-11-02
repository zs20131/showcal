/**
 * @(#)Complatint.java 
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
package com.showcal.service.domain;

import com.xiniunet.framework.base.BaseDomain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class Complatint extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 投诉来源 
     */
    private  String   sourceType;
    
    /**
     * 投诉来源ID 
     */
    private  Long   sourceId;
    
    /**
     * 投诉内容 
     */
    private  String   content;
    
    /**
     * 是否已经处理 
     */
    private  Boolean   isProcessed;
    
    /**
     * 处理人 
     */
    private  Long   processUserId;
    
    /**
     * 处理人姓名 
     */
    private  String   processUserName;
    
    /**
     * 处理时间 
     */
    private  Date   processTime;

    /**
     *发帖人
     */
    private String sendArticleName;

    /**
     * 帖子名称
     */
    private String title;
    /**
     *
     */
    private Long createdBy;
    /**
     *创建人
     */
    private String createdByName;

    private Timestamp creationTime;

    /**
     * 是否禁言
     */
    private Boolean isProhibit=false;

    /**
     *
     * 是否封锁
     */
    private Boolean isSocked=false;

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public Boolean getIsSocked() {
        return isSocked;
    }

    public void setIsSocked(Boolean isSocked) {
        this.isSocked = isSocked;
    }

    public Boolean getIsProhibit() {
        return isProhibit;
    }

    public void setIsProhibit(Boolean isProhibit) {
        this.isProhibit = isProhibit;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public String getSendArticleName() {
        return sendArticleName;
    }

    public void setSendArticleName(String sendArticleName) {
        this.sendArticleName = sendArticleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getSourceType() {
    return this.sourceType;
    }

    public void setSourceType(String  sourceType) {
    this.sourceType = sourceType;
    }
    
    public Long getSourceId() {
    return this.sourceId;
    }

    public void setSourceId(Long  sourceId) {
    this.sourceId = sourceId;
    }
    
    public String getContent() {
    return this.content;
    }

    public void setContent(String  content) {
    this.content = content;
    }
    
    public Boolean getIsProcessed() {
    return this.isProcessed;
    }

    public void setIsProcessed(Boolean  isProcessed) {
    this.isProcessed = isProcessed;
    }
    
    public Long getProcessUserId() {
    return this.processUserId;
    }

    public void setProcessUserId(Long  processUserId) {
    this.processUserId = processUserId;
    }
    
    public String getProcessUserName() {
    return this.processUserName;
    }

    public void setProcessUserName(String  processUserName) {
    this.processUserName = processUserName;
    }
    
    public Date getProcessTime() {
    return this.processTime;
    }

    public void setProcessTime(Date  processTime) {
    this.processTime = processTime;
    }
    
}