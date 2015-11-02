/**
 * @(#)SportLineCreateRequest.java
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

import com.xiniunet.framework.base.BaseRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class SportLineCreateRequest extends BaseRequest {
    
    /**
     * 运动头ID 
     */
    private  Long   headId;
    
    /**
     * 运动步骤 
     */
    @NotNull(message = "运动步骤不能为空")
    private  Integer   step;
    
    /**
     * 运动时长 单位(分钟)
     */
    @NotNull(message = "运动时长不能为空")
    private  Integer   time;
    
    /**
     * 运动主数据ID 
     */
    
    private  Long   sportSettingId;
    

    
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
