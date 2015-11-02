package com.showcal.mobile.domain;


import com.showcal.platform.domain.SysUser;

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
public class ShowCalInfo extends SysUser {
    /**
     * 个人简介
     */
    private String resume;
    /**
     * 服务人数
     */
    private Integer countService;
    /**
     * 响应时间
     */
    private Double responseTime;
    /**
     * 服务成功率
     */
    private Double successRate;

    /**
     * 服务评价分数
     */
    private Double evaluate;

    public Double getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Double evaluate) {
        this.evaluate = evaluate;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
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
}
