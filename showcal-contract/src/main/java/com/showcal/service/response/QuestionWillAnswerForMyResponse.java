package com.showcal.service.response;

import com.showcal.service.domain.TotalKeyWordTag;
import com.showcal.service.domain.TotalQuestionTag;
import com.showcal.service.domain.UnAnswerQuestion;
import com.xiniunet.framework.base.BaseFindResponse;

import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.response
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.service.response
 * </pre>
 */
public class QuestionWillAnswerForMyResponse extends BaseFindResponse<UnAnswerQuestion> {
    //TODO 需要考虑每种标签，每种关键字的总记录数放在这边
    private List<TotalQuestionTag> questionTagList;

    private List<TotalKeyWordTag> keyWordTagList;
    //新用户总记录数
    private Integer newUserQuestionCount;
    /**
     * 其他问题总数据
     */
    private Integer otherQuestionCount;

    public Integer getOtherQuestionCount() {
        return otherQuestionCount;
    }

    public void setOtherQuestionCount(Integer otherQuestionCount) {
        this.otherQuestionCount = otherQuestionCount;
    }

    public Integer getNewUserQuestionCount() {
        return newUserQuestionCount;
    }

    public void setNewUserQuestionCount(Integer newUserQuestionCount) {
        this.newUserQuestionCount = newUserQuestionCount;
    }

    public List<TotalQuestionTag> getQuestionTagList() {
        return questionTagList;
    }

    public void setQuestionTagList(List<TotalQuestionTag> questionTagList) {
        this.questionTagList = questionTagList;
    }

    public List<TotalKeyWordTag> getKeyWordTagList() {
        return keyWordTagList;
    }

    public void setKeyWordTagList(List<TotalKeyWordTag> keyWordTagList) {
        this.keyWordTagList = keyWordTagList;
    }
}
