/**
 * @(#)AnswerImport.java
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
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class AnswerImport extends  BaseDomain {


/**
 * 问题ID 
 */
private  String   questionId;

/**
 * 是否已回答 
 */
private  Boolean   isAnswered;

/**
 * 回答完成时间 
 */
private  Date   answeredTime;



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