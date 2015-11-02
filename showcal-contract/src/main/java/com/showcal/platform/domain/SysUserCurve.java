/**
 * @(#)SysUserCurve.java 
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.platform.domain;

import com.xiniunet.framework.base.BaseDomain;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
public class SysUserCurve extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 关联用户ID 
     */
    private  Long   userId;
    
    /**
     * 记录类型 
     */
    private  CurveTypeEnum   type;
    
    /**
     *  
     */
    private  Double   value;
    
    /**
     * 记录日期 
     */
    private  String   recordDate;

    /**
     *  平均体重
     */
    private Double avgWeight;

    /**
     *  月份
     */
    private String month;

    /**
     *  日期，精确到天，体重曲线使用
     */
    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(Double avgWeight) {
        this.avgWeight = avgWeight;
    }

    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public Long getUserId() {
    return this.userId;
    }

    public void setUserId(Long  userId) {
    this.userId = userId;
    }

    public CurveTypeEnum getType() {
        return type;
    }

    public void setType(CurveTypeEnum type) {
        this.type = type;
    }

    public Double getValue() {
    return this.value;
    }

    public void setValue(Double  value) {
    this.value = value;
    }
    
    public String getRecordDate() {
    return this.recordDate;
    }

    public void setRecordDate(String  recordDate) {
    this.recordDate = recordDate;
    }
    
}