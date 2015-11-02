package com.showcal.platform.request;

import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.platform.request
 *  Description: 记录用户信息
 * ***************************************************************
 *  9/23 0023  V1.0  xiniu    New Files for com.showcal.platform.request
 * </pre>
 */
public class UserInfoRecordRequest extends BaseRequest{
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    /**
     * 性别
     */
    private SexEnum sex;
    /**
     * 身高（厘米）
     */

    private Integer height;

    /**
     * 出生年月
     */

    private Date birthday;


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


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
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
}
