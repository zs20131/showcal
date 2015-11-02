package com.showcal.mobile.response;

import com.showcal.mobile.domain.Period;
import com.xiniunet.framework.base.BaseFindRequest;

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
public class PeriodGetResponse extends BaseFindRequest{
    /**
     * 生理期时间
     */
    private Period period;

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
