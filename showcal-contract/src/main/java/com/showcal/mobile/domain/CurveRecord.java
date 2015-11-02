package com.showcal.mobile.domain;

import com.showcal.platform.domain.CurveTypeEnum;
import com.xiniunet.framework.base.BaseDomain;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.mobile.domain
 *  Description:身体曲线变化记录值
 * ***************************************************************
 *  9/18 0018  V1.0  xiniu    New Files for com.showcal.mobile.domain
 * </pre>
 */
public class CurveRecord extends BaseDomain{
    /**
     * 记录类型
     */
    private CurveTypeEnum type;

    /**
     *
     */
    private  Double   value;

    public CurveTypeEnum getType() {
        return type;
    }

    public void setType(CurveTypeEnum type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
