package com.showcal.mobile.request;

import com.xiniunet.framework.base.BaseRequest;

import java.util.Date;

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
public class PeriodSetRequest extends BaseRequest{
    /**
     * 月经周期
     */
    private Integer cycle;
    /**
     * 行经天数
     */
    private Integer day;
    /**
     * 开始时间
     */
    private Date startDate;

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
