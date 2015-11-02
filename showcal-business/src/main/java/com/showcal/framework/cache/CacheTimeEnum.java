package com.showcal.framework.cache;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.framework.cache
 *  Description:
 * ***************************************************************
 *  9/23 0023  V1.0  xiniu    New Files for com.showcal.framework.cache
 * </pre>
 */
public enum CacheTimeEnum {
    /**
     * 永久
     */
    FOR_EVER(0),

    /**
     * 5分钟
     */
    FIVE_MINUTES(5),

    /**
     * 30分钟
     */
    THIRTY_MINUTES(30),

    /**
     * 1小时
     */
    ONE_HOUR(60),

    /**
     * 2小时
     */
    TWO_HOURS(120),

    /**
     * 6小时
     */
    SIX_HOURS(360),

    /**
     * 半天
     */
    HALF_DAY(720),

    /**
     * 一天
     */
    ONE_DAY(1440),
    /**
     * 一周
     */
    ONE_WEEK(7 * 1440);

    private int _value;

    private CacheTimeEnum(int value) {
        _value = value;
    }

    public int value() {
        return _value;
    }
}
