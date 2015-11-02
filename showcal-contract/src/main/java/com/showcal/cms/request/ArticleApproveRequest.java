package com.showcal.cms.request;

import com.showcal.cms.domain.ApproveResultEnum;
import com.xiniunet.framework.base.BaseUpdateRequest;

import javax.validation.constraints.NotNull;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.cms.request
 *  Description: 文章审批
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.cms.request
 * </pre>
 */
public class ArticleApproveRequest extends BaseUpdateRequest{
    /**
     * 文章Id
     */
    @NotNull(message = "待审核文章不能为空，请检查")
    private Long id;
    /**
     * 审批结果
     */
    private ApproveResultEnum result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApproveResultEnum getResult() {
        return result;
    }

    public void setResult(ApproveResultEnum result) {
        this.result = result;
    }
}
