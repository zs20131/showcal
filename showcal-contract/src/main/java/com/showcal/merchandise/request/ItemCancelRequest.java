package com.showcal.merchandise.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.cms.request
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.cms.request
 * </pre>
 */
public class ItemCancelRequest extends BaseRequest{
    @NotNull(message = "待取消的物料Id不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
