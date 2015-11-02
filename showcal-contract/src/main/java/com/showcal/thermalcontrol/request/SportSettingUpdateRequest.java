/**
 * @(#)SportSettingUpdateRequest.java
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

import com.xiniunet.framework.base.BaseUpdateRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;


/**
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public class SportSettingUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 运动名称 
     */
    @NotBlank(message = "运动名称不能为空")
    @Length(min=1, max=500, message = "运动名称长度不合法")
    private  String   name;
    
    /**
     * 类型 
     */
    @NotBlank(message = "类型不能为空")
    @Length(min=1, max=100, message = "类型长度不合法")
    private  String   type;
    
    /**
     * 链接地址 
     */
    @Length(min=0, max=500, message = "链接地址长度不合法")
    private  String   url;
    
    /**
     * 封面图片 
     */
    private  Long   cover;
    
    /**
     * 消耗热量 
     */
    @NotNull(message = "消耗热量不能为空")
    private  Double   burnHeat;
    
    /**
     * 运动说明内容 
     */
    @NotBlank(message = "运动说明内容不能为空")
    @Length(min=0, max=1000, message = "运动说明内容长度不合法")
    private  String   content;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getName() {
    return this.name;
    }

    public void setName(String  name) {
    this.name = name;
    }
    
    public String getType() {
    return this.type;
    }

    public void setType(String  type) {
    this.type = type;
    }
    
    public String getUrl() {
    return this.url;
    }

    public void setUrl(String  url) {
    this.url = url;
    }
    
    public Long getCover() {
    return this.cover;
    }

    public void setCover(Long  cover) {
    this.cover = cover;
    }
    
    public Double getBurnHeat() {
    return this.burnHeat;
    }

    public void setBurnHeat(Double  burnHeat) {
    this.burnHeat = burnHeat;
    }
    
    public String getContent() {
    return this.content;
    }

    public void setContent(String  content) {
    this.content = content;
    }
    

}
