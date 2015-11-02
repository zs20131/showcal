/**
 * @(#)SettingQuestionTagUpdateRequest.java
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
package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseUpdateRequest;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 * @author 顾志雄
 */
public class SettingQuestionTagUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 标签名称 
     */
    @NotNull(message = "标签名称不能为空!")
    @Length(min=1, max=100, message = "标签名称长度不合法")
    private  String   tag;
    
    /**
     * 标签RGB颜色 
     */
    @NotNull(message = "标签RGB颜色不能为空!")
    @Length(min=1, max=20, message = "标签RGB颜色长度不合法")
    private  String   tagRgb;
    
    /**
     * 备注 
     */
    
    @Length(min=1, max=1000, message = "备注长度不合法")
    private  String   remark;
    
    /**
     * 是否有效 
     */
    @NotNull(message = "是否有效不能为空")
    private  Boolean   isActive;
    
    /**
     * 生效日期 
     */
    @NotNull(message = "生效日期不能为空")
    private  Date   activeDate;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getTag() {
    return this.tag;
    }

    public void setTag(String  tag) {
    this.tag = tag;
    }
    
    public String getTagRgb() {
    return this.tagRgb;
    }

    public void setTagRgb(String  tagRgb) {
    this.tagRgb = tagRgb;
    }
    
    public String getRemark() {
    return this.remark;
    }

    public void setRemark(String  remark) {
    this.remark = remark;
    }
    
    public Boolean getIsActive() {
    return this.isActive;
    }

    public void setIsActive(Boolean  isActive) {
    this.isActive = isActive;
    }
    
    public Date getActiveDate() {
    return this.activeDate;
    }

    public void setActiveDate(Date  activeDate) {
    this.activeDate = activeDate;
    }
    

}
