/**
 * @(#)Welcome.java 
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
package com.showcal.service.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 * @author 顾志雄
 */
public class Welcome extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 欢迎语内容 
     */
    private  String   cometent;

    /**
     * 是否有效,
     */
    private  Boolean   isActive;

    /**
     * 生效日期,
     */
    private  Date   activeDate;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getCometent() {
    return this.cometent;
    }

    public void setCometent(String  cometent) {
    this.cometent = cometent;
    }
    
}