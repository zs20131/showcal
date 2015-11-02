package com.showcal.service.request;

import com.xiniunet.framework.base.BaseUpdateRequest;

import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.request
 *  Description:
 * ***************************************************************
 *  9/17 0017  V1.0  xiniu    New Files for com.showcal.service.request
 * </pre>
 */
public class QuestionCloseRequest extends BaseUpdateRequest{
    /**
     * 待关闭的问题列表
     */
    private List<Long> questionIds;

    public List<Long> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Long> questionIds) {
        this.questionIds = questionIds;
    }
}
