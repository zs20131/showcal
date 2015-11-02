package com.showcal.mobile.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.showcal.platform.domain.SysUser;

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
public class UserInfo extends SysUser {
    /**
     * 身高（厘米）
     */
    private Integer height;

    /**
     * 出生年月
     */
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 体重
     */
    private Double weight;

    /**
     * 腰围
     */
    private Double waistLine;

    /**
     * 臀围
     */
    private Double hipline;

    /**
     * BMI值
     */
    private Double bmi;

    /**
     * 积分
     */
    private Integer integral;

    /**
     * 所选择的瘦咖ID
     */
    private Long showCalId;


    public Long getShowCalId() {
        return showCalId;
    }

    public void setShowCalId(Long showCalId) {
        this.showCalId = showCalId;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWaistLine() {
        return waistLine;
    }

    public void setWaistLine(Double waistLine) {
        this.waistLine = waistLine;
    }

    public Double getHipline() {
        return hipline;
    }

    public void setHipline(Double hipline) {
        this.hipline = hipline;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }
}
