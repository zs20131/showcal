package com.showcal.mobile.domain;

import com.xiniunet.framework.base.BaseDomain;

import java.util.Date;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.mobile.domain
 *  Description:
 * ***************************************************************
 *  9/18 0018  V1.0  xiniu    New Files for com.showcal.mobile.domain
 * </pre>
 */
public class Period extends BaseDomain{
    /**
     * 生理期开始时间
     */
    private Date startPeriodDate;
    /**
     * 生理期结束时间
     */
    private Date endPeriodDate;
    /**
     * 预测生理期开始时间
     */
    private Date startForecast;
    /**
     * 预测生理期结束时间
     */
    private Date endForecast;


    public Date getStartPeriodDate() {
        return startPeriodDate;
    }

    public void setStartPeriodDate(Date startPeriodDate) {
        this.startPeriodDate = startPeriodDate;
    }

    public Date getEndPeriodDate() {
        return endPeriodDate;
    }

    public void setEndPeriodDate(Date endPeriodDate) {
        this.endPeriodDate = endPeriodDate;
    }

    public Date getStartForecast() {
        return startForecast;
    }

    public void setStartForecast(Date startForecast) {
        this.startForecast = startForecast;
    }

    public Date getEndForecast() {
        return endForecast;
    }

    public void setEndForecast(Date endForecast) {
        this.endForecast = endForecast;
    }
}
