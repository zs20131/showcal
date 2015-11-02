/**
 * @(#)SportHeadFindRequest.java
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
import com.xiniunet.framework.base.BaseFindRequest;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class SportHeadFindRequest extends BaseFindRequest {


    /**
     * 主键
     */
    private  Long   id;

    /**
     * 运动头名称
     */
    private  String   name;

    /**
     * 运动强度,高中低
     */
    private IntensityEnum intensity;

    /**
     * 运动地点,
     */
    private SportAddressEnum address;

    /**
     * 有运动损伤是否可以参与,
     */
    private  Boolean   isInjuryJoin;
    /**
     * 当前BMI值
     */
    private Double BMI;
    /**
     * 运动时间
     */
    private Integer sportTime;
    /**
     * 是否随机获取方案（用于前台,随机，默认取3条记录）
     */
    private Boolean isRandom;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IntensityEnum getIntensity() {
        return intensity;
    }

    public void setIntensity(IntensityEnum intensity) {
        this.intensity = intensity;
    }

    public SportAddressEnum getAddress() {
        return address;
    }

    public void setAddress(SportAddressEnum address) {
        this.address = address;
    }

    public Boolean getIsInjuryJoin() {
        return isInjuryJoin;
    }

    public void setIsInjuryJoin(Boolean isInjuryJoin) {
        this.isInjuryJoin = isInjuryJoin;
    }

    public Double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public Integer getSportTime() {
        return sportTime;
    }

    public void setSportTime(Integer sportTime) {
        this.sportTime = sportTime;
    }

    public Boolean getIsRandom() {
        return isRandom;
    }

    public void setIsRandom(Boolean isRandom) {
        this.isRandom = isRandom;
    }
}
