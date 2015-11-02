package com.showcal.platform.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.platfrom.domain
 *  Description:用户详细信息
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.platfrom.domain
 * </pre>
 */
public class UserDetail extends SysUser{
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
     * 用户设置信息
     */
    private String setting;

    /**
     * 累计服务人数 当用户为瘦咖类型时使用
     */
    private Integer countService;

    /**
     * 平均响应时间 当用户为瘦咖类型时使用
     */
    private Double responseTime;

    /**
     * 服务成功率 当用户为瘦咖类型时启用
     */
    private Double successRate;

    /**
     *  积分
     */
    private Integer integral;

    /**
     * 服务状态,
     */
    private  Boolean   serviceState;

    /**
     * 选我时间
     */
    private  Date   serviceDate;

    /**
     * 用户标签列表
     */
    private List<Long> userTagIds;

    private List<String> userTagNames;

    private List<String> userTagRgbs;

    private List<SettingUserTag> settingUserTagList;

    /**
     * setting
     */
    private UserSetting userSetting;

    /**
     *  特殊情况
     */
    private String settingDisease;

    public String getSettingDisease() {
        return settingDisease;
    }

    public void setSettingDisease(String settingDisease) {
        this.settingDisease = settingDisease;
    }

    public UserSetting getUserSetting() {
        return userSetting;
    }

    public void setUserSetting(UserSetting userSetting) {
        this.userSetting = userSetting;
    }

    public List<String> getUserTagNames() {
        return userTagNames;
    }

    public void setUserTagNames(List<String> userTagNames) {
        this.userTagNames = userTagNames;
    }

    public List<Long> getUserTagIds() {
        return userTagIds;
    }

    public void setUserTagIds(List<Long> userTagIds) {
        this.userTagIds = userTagIds;
    }

    public Boolean getServiceState() {
        return serviceState;
    }

    public void setServiceState(Boolean serviceState) {
        this.serviceState = serviceState;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
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

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public Integer getCountService() {
        return countService;
    }

    public void setCountService(Integer countService) {
        this.countService = countService;
    }

    public Double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Double responseTime) {
        this.responseTime = responseTime;
    }

    public Double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Double successRate) {
        this.successRate = successRate;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public List<String> getUserTagRgbs() {
        return userTagRgbs;
    }

    public void setUserTagRgbs(List<String> userTagRgbs) {
        this.userTagRgbs = userTagRgbs;
    }

    public List<SettingUserTag> getSettingUserTagList() {
        return settingUserTagList;
    }

    public void setSettingUserTagList(List<SettingUserTag> settingUserTagList) {
        this.settingUserTagList = settingUserTagList;
    }
}
