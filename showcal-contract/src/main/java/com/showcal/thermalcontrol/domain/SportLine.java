/**
 * @(#)SportLine.java 
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
package com.showcal.thermalcontrol.domain;

import com.xiniunet.framework.base.BaseDomain;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class SportLine extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 运动头ID 
     */
    private  Long   headId;
    
    /**
     * 运动步骤 
     */
    private  Integer   step;
    
    /**
     * 运动时长 单位(分钟)
     */
    private  Integer   time;
    
    /**
     * 运动主数据ID 
     */
    private  Long   sportSettingId;

    /**
     * 运动主数据
     */
    private SportSetting sportSetting;


    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public Long getHeadId() {
    return this.headId;
    }

    public void setHeadId(Long  headId) {
    this.headId = headId;
    }
    
    public Integer getStep() {
    return this.step;
    }

    public void setStep(Integer  step) {
    this.step = step;
    }
    
    public Integer getTime() {
    return this.time;
    }

    public void setTime(Integer  time) {
    this.time = time;
    }

    public Long getSportSettingId() {
        return sportSettingId;
    }

    public void setSportSettingId(Long sportSettingId) {
        this.sportSettingId = sportSettingId;
    }

    public SportSetting getSportSetting() {
        return sportSetting;
    }

    public void setSportSetting(SportSetting sportSetting) {
        this.sportSetting = sportSetting;
    }
}