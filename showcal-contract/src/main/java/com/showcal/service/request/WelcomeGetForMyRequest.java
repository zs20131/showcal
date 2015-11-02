package com.showcal.service.request;

import com.xiniunet.framework.base.BaseRequest;

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
public class WelcomeGetForMyRequest extends BaseRequest{
    /**
     *  瘦咖Id
     */
    private Long showCalId;

    public Long getShowCalId() {
        return showCalId;
    }

    public void setShowCalId(Long showCalId) {
        this.showCalId = showCalId;
    }
}
