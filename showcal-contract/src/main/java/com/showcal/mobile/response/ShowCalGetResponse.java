package com.showcal.mobile.response;

import com.showcal.mobile.domain.ShowCalInfo;
import com.xiniunet.framework.base.BaseResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.mobile.response
 *  Description:
 * ***************************************************************
 *  9/18 0018  V1.0  xiniu    New Files for com.showcal.mobile.response
 * </pre>
 */
public class ShowCalGetResponse extends BaseResponse {
    private ShowCalInfo showCalInfo;

    public ShowCalInfo getShowCalInfo() {
        return showCalInfo;
    }

    public void setShowCalInfo(ShowCalInfo showCalInfo) {
        this.showCalInfo = showCalInfo;
    }
}
