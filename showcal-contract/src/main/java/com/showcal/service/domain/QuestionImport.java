/**
 * @(#)QuestionImport.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 * @author 顾志雄
 */
public class QuestionImport extends  BaseDomain {


/**
 * 标签 问题的标签(如果问题贴标签，则不解析关键字)
 */
private  String   tag;

/**
 * 关键字 提问时从消息中解析，遇到的第一个关键字放入
 */
private  String   keyword;

/**
 * 目标响应时间 
 */
private  Date   responseTime;

/**
 * 是否已回答 
 */
private  Boolean   isAnswered;

/**
 * 回答人 初始插入（服务该用户的瘦咖ID）
 */
private  Long   answerUserId;

/**
 * 回答时间 
 */
private  Date   answerTime;

/**
 * 回答这个问题的答案ID 
 */
private  Long   answerId;



public String getTag() {
return this.tag;
}

public void setTag(String  tag) {
this.tag = tag;
}

public String getKeyword() {
return this.keyword;
}

public void setKeyword(String  keyword) {
this.keyword = keyword;
}

public Date getResponseTime() {
return this.responseTime;
}

public void setResponseTime(Date  responseTime) {
this.responseTime = responseTime;
}

public Boolean getIsAnswered() {
return this.isAnswered;
}

public void setIsAnswered(Boolean  isAnswered) {
this.isAnswered = isAnswered;
}

public Long getAnswerUserId() {
return this.answerUserId;
}

public void setAnswerUserId(Long  answerUserId) {
this.answerUserId = answerUserId;
}

public Date getAnswerTime() {
return this.answerTime;
}

public void setAnswerTime(Date  answerTime) {
this.answerTime = answerTime;
}

public Long getAnswerId() {
return this.answerId;
}

public void setAnswerId(Long  answerId) {
this.answerId = answerId;
}

}