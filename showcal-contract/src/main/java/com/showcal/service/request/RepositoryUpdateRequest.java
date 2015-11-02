/**
 * @(#)RepositoryUpdateRequest.java
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
package com.showcal.service.request;

import com.showcal.service.domain.RepositoryTypeEnum;
import com.xiniunet.framework.base.BaseUpdateRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;


/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 * @author 顾志雄
 */
public class RepositoryUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 知识库类型 
     */
    @NotBlank(message = "知识库类型不能为空")
    @Length(min=0, max=50, message = "知识库类型长度不合法")
    private  String   type;
    
    /**
     * 知识库标签 
     */
    
    @Length(min=1, max=1000, message = "知识库标签长度不合法")
    private  String   tag;

    /**
     * 知识库问题
     */

    @Length(min=0, max=1000, message = "知识库问题长度不合法")
    private  String   question;
    
    /**
     * 知识库关键字 
     */
    
    @Length(min=1, max=1000, message = "知识库关键字长度不合法")
    private  String   keyword;
    
    /**
     * 知识库内容 
     */
    @NotBlank(message = "知识库内容不能为空")
    @Length(min=1, max=2000, message = "知识库内容长度不合法")
    private  String   content;
    
    /**
     * 来源ID 来源ID(瘦咖转让)
     */
    
    private  Long   sourceId;
    
    /**
     * 来源用户ID 
     */
    
    private  Long   sourceUserId;

    private Boolean isActive;

    private Date activeDate;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(Long sourceUserId) {
        this.sourceUserId = sourceUserId;
    }
}
