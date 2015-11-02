/**
 * @(#)AnswerUpdateRequest.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class AnswerUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 问题ID 
     */
    
    @Length(min=0, max=50, message = "问题ID长度不合法")
    private  String   questionId;
    
    /**
     * 是否已回答 
     */
    
    private  Boolean   isAnswered;
    
    /**
     * 回答完成时间 
     */
    
    private  Date   answeredTime;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getQuestionId() {
    return this.questionId;
    }

    public void setQuestionId(String  questionId) {
    this.questionId = questionId;
    }
    
    public Boolean getIsAnswered() {
    return this.isAnswered;
    }

    public void setIsAnswered(Boolean  isAnswered) {
    this.isAnswered = isAnswered;
    }
    
    public Date getAnsweredTime() {
    return this.answeredTime;
    }

    public void setAnsweredTime(Date  answeredTime) {
    this.answeredTime = answeredTime;
    }
    

}
