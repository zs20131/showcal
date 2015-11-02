/**
 * @(#)ComplatintCreateRequest.java
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

import com.xiniunet.framework.base.BaseRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class ComplatintCreateRequest extends BaseRequest {
    
    /**
     * 投诉来源 
     */
    @NotBlank(message = "投诉来源不能为空")
    @Length(min=0, max=50, message = "投诉来源长度不合法")
    private  String   sourceType;
    
    /**
     * 投诉来源ID 
     */
    @NotNull(message = "投诉来源ID不能为空")
    private  Long   sourceId;
    
    /**
     * 投诉内容 
     */
    @NotBlank(message = "投诉内容不能为空")
    @Length(min=0, max=50, message = "投诉内容长度不合法")
    private  String   content;
    
    /**
     * 是否已经处理 
     */
    @NotNull(message = "是否已经处理不能为空")
    private  Boolean   isProcessed;
    
    /**
     * 处理人 
     */
    
    private  Long   processUserId;
    
    /**
     * 处理人姓名 
     */
    
    @Length(min=0, max=50, message = "处理人姓名长度不合法")
    private  String   processUserName;
    
    /**
     * 处理时间 
     */
    
    private  Date   processTime;
    

    
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
