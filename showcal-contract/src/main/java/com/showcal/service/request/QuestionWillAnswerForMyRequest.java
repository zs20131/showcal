package com.showcal.service.request;

import com.xiniunet.framework.base.BaseFindRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.request
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.service.request
 * </pre>
 */
public class QuestionWillAnswerForMyRequest extends BaseFindRequest {
    /**
     * 问题标签ID
     */
    private Long questionTagId;
    /**
     * 关键字ID
     */
    private Long keywordId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户标签
     */
    private Long userTag;

    /**
     * 过期时间
     */
    private Integer deadline;
    /**
     * 其他关键字
     */
    private Boolean isOther;
    /**
     * 新用户
     */
    private Boolean isNewUser;

    public Boolean getIsOther() {
        return isOther;
    }

    public void setIsOther(Boolean isOther) {
        this.isOther = isOther;
    }

    public Boolean getIsNewUser() {
        return isNewUser;
    }

    public void setIsNewUser(Boolean isNewUser) {
        this.isNewUser = isNewUser;
    }

    public Long getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(Long questionTagId) {
        this.questionTagId = questionTagId;
    }

    public Long getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Long keywordId) {
        this.keywordId = keywordId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserTag() {
        return userTag;
    }

    public void setUserTag(Long userTag) {
        this.userTag = userTag;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }
}
