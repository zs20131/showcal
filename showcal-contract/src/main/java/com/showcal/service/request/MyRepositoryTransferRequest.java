package com.showcal.service.request;

import com.xiniunet.framework.base.BaseUpdateRequest;

import javax.validation.constraints.NotNull;

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
public class MyRepositoryTransferRequest extends BaseUpdateRequest{
    /**
     * 需要转让的知识条目Id
     */
    @NotNull(message = "需要转让的知识条目不能为空，请检查")
    private Long repositoryId;
    @NotNull(message = "转让目标瘦咖不能为空，请检查")
    private Long toUserId;

    public Long getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Long repositoryId) {
        this.repositoryId = repositoryId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }
}
