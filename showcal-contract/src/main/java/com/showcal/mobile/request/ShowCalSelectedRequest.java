package com.showcal.mobile.request;

import com.xiniunet.framework.base.BaseUpdateRequest;

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
public class ShowCalSelectedRequest extends BaseUpdateRequest{
    /**
     * 瘦咖Id
     */
    @NotNull(message = "请选择瘦咖信息")
    private Long showCalId;

    public Long getShowCalId() {
        return showCalId;
    }

    public void setShowCalId(Long showCalId) {
        this.showCalId = showCalId;
    }
}
