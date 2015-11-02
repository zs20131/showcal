/**
 * @(#)SportHeadCreateRequest.java
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
package com.showcal.thermalcontrol.request;

import com.showcal.thermalcontrol.domain.IntensityEnum;
import com.showcal.thermalcontrol.domain.SportAddressEnum;
import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 *
 * @author 顾志雄
 */
public class SportHeadCreateRequest extends BaseRequest {
    /**
     * 主键
     */

    private Long id;

    /**
     * 运动头名称
     */
    @NotBlank(message = "运动头名称不能为空")
    @Length(min = 0, max = 100, message = "运动头名称长度不合法")
    private String name;

    /**
     * 运动总时长
     */
    private Integer totalTime;

    /**
     * 运动强度 高中低
     */
    @NotNull(message = "运动强度不能为空")
    private IntensityEnum intensity;

    /**
     * 运动地点
     */
    @NotNull(message = "运动地点不能为空")
    private SportAddressEnum address;

    /**
     * BMI起始值
     */
    @NotNull(message = "BMI起始值不能为空")
    private Double startBmi;

    /**
     * BMI结束值
     */
    @NotNull(message = "BMI结束值不能为空")
    private Double endBmi;

    /**
     * 有运动损伤是否可以参与
     */
    @NotNull(message = "有运动损伤是否可以参与不能为空")
    private Boolean isInjuryJoin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public SportAddressEnum getAddress() {
        return address;
    }

    public void setAddress(SportAddressEnum address) {
        this.address = address;
    }

    public IntensityEnum getIntensity() {
        return intensity;
    }

    public void setIntensity(IntensityEnum intensity) {
        this.intensity = intensity;
    }

    public Double getStartBmi() {
        return this.startBmi;
    }

    public void setStartBmi(Double startBmi) {
        this.startBmi = startBmi;
    }

    public Double getEndBmi() {
        return this.endBmi;
    }

    public void setEndBmi(Double endBmi) {
        this.endBmi = endBmi;
    }

    public Boolean getIsInjuryJoin() {
        return this.isInjuryJoin;
    }

    public void setIsInjuryJoin(Boolean isInjuryJoin) {
        this.isInjuryJoin = isInjuryJoin;
    }


}
