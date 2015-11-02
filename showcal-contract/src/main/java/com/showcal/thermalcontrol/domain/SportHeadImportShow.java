/**
 * @(#)SportHeadImport.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.thermalcontrol.domain;

import com.xiniunet.framework.base.BaseDomain;
import com.xiniunet.framework.util.excel.annotation.Name;
import com.xiniunet.framework.util.excel.annotation.Type;
import com.xiniunet.framework.util.excel.enumeration.DataType;

import javax.validation.constraints.NotNull;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class SportHeadImportShow extends BaseDomain {
    /**
     *主键
     */
    @Name("运动头主键")
    @Type(DataType.LONG)
    @NotNull
    private Long id;
    /**
     * 运动头名称
     */
    @Name("运动名称")
    @Type(DataType.STRING)
    @NotNull
    private String name;

    /**
     * 运动总时长
     */
    @Name("运动总时长")
    @Type(DataType.NUMBER)
    @NotNull
    private Integer totalTime;

    /**
     * 运动强度 高中低
     */
    @Name("运动强度")
    @Type(DataType.STRING)
    private String intensity;

    /**
     * 运动地点
     */
    @Name("运动地点")
    @Type(DataType.STRING)
    @NotNull
    private String address;

    /**
     * BMI起始值
     */
    @Name("BMI起始值")
    @Type(DataType.DECIMAL)
    @NotNull
    private Double startBmi;

    /**
     * BMI结束值
     */
    @Name("BMI结束值")
    @Type(DataType.DECIMAL)
    @NotNull
    private Double endBmi;

    /**
     * 有运动损伤是否可以参与
     */
    @Name("是否损伤")
    @Type(DataType.BOOLEAN)
    @NotNull
    private Boolean isInjuryJoin;
//    /**
//     * 运动行主键
//     */
//    @Name("运动行主键")
//    @Type(DataType.LONG)
//    @NotNull
//    private  Long   lineId;
//
//    /**
//     * 运动头ID
//     */
//    @Name("运动头ID")
//    @Type(DataType.LONG)
//    @NotNull
//    private  Long   headId;
//
//    /**
//     * 运动步骤
//     */
//    @Name("运动步骤")
//    @NotNull
//    @Type(DataType.NUMBER)
//    private  Integer   step;
//
//    /**
//     * 运动时长 单位(分钟)
//     */
//    @Name("运动时长")
//    @NotNull
//    @Type(DataType.NUMBER)
//    private  Integer   time;
//
//    /**
//     * 运动主数据ID
//     */
//    @Name("运动主数据ID")
//    @NotNull
//    @Type(DataType.LONG)
//    private  Long   sportSettingId;
//
//    public Long getSportSettingId() {
//        return sportSettingId;
//    }
//
//    public void setSportSettingId(Long sportSettingId) {
//        this.sportSettingId = sportSettingId;
//    }
//
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getHeadId() {
//        return headId;
//    }
//
//    public void setHeadId(Long headId) {
//        this.headId = headId;
//    }
//
//    public Integer getStep() {
//        return step;
//    }
//
//    public void setStep(Integer step) {
//        this.step = step;
//    }
//
//    public Integer getTime() {
//        return time;
//    }
//
//    public void setTime(Integer time) {
//        this.time = time;
//    }

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

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

//    public Long getLineId() {
//        return lineId;
//    }
//
//    public void setLineId(Long lineId) {
//        this.lineId = lineId;
//    }
}