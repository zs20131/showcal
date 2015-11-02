package com.showcal.mobile.request;

import com.xiniunet.framework.base.BaseRequest;

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
public class PeriodGetRequest extends BaseRequest{
    /**
     * 当前月份
     */
    private String periodMonth;

    public String getPeriodMonth() {
        return periodMonth;
    }

    public void setPeriodMonth(String periodMonth) {
        this.periodMonth = periodMonth;
    }
}
