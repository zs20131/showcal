/**
 * @(#)AnswerCreateRequest.java
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

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 *
 * @author 顾志雄
 */
public class AnswerSendRequest extends BaseRequest {
    /**
     * 用户编号列表
     */
    private List<Long> userIds;
    /**
     * 问题ID
     */
    private List<Long> questionIds;

    /**
     * 是否已回答
     */

    private Boolean isAnswered;
    /**
     * 回答内容
     */
    private String content;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public List<Long> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Long> questionIds) {
        this.questionIds = questionIds;
    }

    public Boolean getIsAnswered() {
        return isAnswered;
    }

    public void setIsAnswered(Boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
