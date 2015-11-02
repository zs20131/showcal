/**
 * @(#)SportSetting.java 
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
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public class SportSetting extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 运动名称 
     */
    private  String   name;
    
    /**
     * 类型 
     */
    private  String   type;
    
    /**
     * 链接地址 
     */
    private  String   url;
    
    /**
     * 封面图片 
     */
    private  Long   cover;
    
    /**
     * 消耗热量 
     */
    private  Double   burnHeat;
    
    /**
     * 运动说明内容 
     */
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