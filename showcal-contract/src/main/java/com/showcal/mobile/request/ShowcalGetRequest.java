package com.showcal.mobile.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.mobile.request
 *  Description:
 * ***************************************************************
 *  9/18 0018  V1.0  xiniu    New Files for com.showcal.mobile.request
 * </pre>
 */
public class ShowcalGetRequest extends BaseRequest {
    @NotNull(message = "Id 不能为空")
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
