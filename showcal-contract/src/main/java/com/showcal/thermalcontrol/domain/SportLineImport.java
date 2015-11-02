/**
 * @(#)SportLineImport.java
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
import com.xiniunet.framework.util.excel.annotation.Name;
import com.xiniunet.framework.util.excel.annotation.Type;
import com.xiniunet.framework.util.excel.enumeration.DataType;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class SportLineImport extends  BaseDomain {

    /**
     * 运动行主键
     */
    @Name("运动行主键")
    @Type(DataType.LONG)
    @NotNull
    private  Long   lineId;

    /**
     * 运动头ID
     */
    @Name("运动头ID")
    @Type(DataType.LONG)
    @NotNull
    private  Long   headId;

    /**
     * 运动步骤
     */
    @Name("运动步骤")
    @NotNull
    @Type(DataType.NUMBER)
    private  Integer   step;

    /**
     * 运动时长 单位(分钟)
     */
    @Name("运动时长")
    @NotNull
    @Type(DataType.NUMBER)
    private  Integer   time;

    /**
     * 运动主数据ID
     */
    @Name("运动主数据ID")
    @NotNull
    @Type(DataType.LONG)
    private  Long   sportSettingId;


    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
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
return this.sportSettingId;
}

public void setSportSettingId(Long  sportSettingId) {
this.sportSettingId = sportSettingId;
}

}