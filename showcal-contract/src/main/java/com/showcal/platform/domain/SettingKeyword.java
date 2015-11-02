/**
 * @(#)SettingKeyword.java 
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
package com.showcal.platform.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:50.
 * @author 顾志雄
 */
public class SettingKeyword extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 关键字 
     */
    private  String   keyword;
    
    /**
     * 父关键字 
     */
    private  String   parentKeyword;
    
    /**
     * 父关键字 
     */
    private  Long   parentId;
    
    /**
     * 备注 
     */
    private  String   remark;
    
    /**
     * 是否有效 
     */
    private  Boolean   isActive;
    
    /**
     * 生效日期 
     */
    private  Date   activeDate;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getKeyword() {
    return this.keyword;
    }

    public void setKeyword(String  keyword) {
    this.keyword = keyword;
    }
    
    public String getParentKeyword() {
    return this.parentKeyword;
    }

    public void setParentKeyword(String  parentKeyword) {
    this.parentKeyword = parentKeyword;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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