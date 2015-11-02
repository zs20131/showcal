package com.showcal.service.request;

import com.xiniunet.framework.base.BaseRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.request
 *  Description:用户ID
 * ***************************************************************
 *  9/25 0025  V1.0  xiniu    New Files for com.showcal.service.request
 * </pre>
 */
public class SelfIntroductionGetRequest extends BaseRequest {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
