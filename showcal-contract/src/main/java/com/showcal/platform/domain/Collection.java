/**
 * @(#)Collection.java 
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
 * Created by 顾志雄 on 2015-09-23 10:27:25.
 * @author 顾志雄
 */
public class Collection extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 用户ID 
     */
    private  Long   userId;
    
    /**
     * 收藏对象类型 
     */
    private  String   objectType;
    
    /**
     * 收藏对象ID 
     */
    private  Long   objectId;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public Long getUserId() {
    return this.userId;
    }

    public void setUserId(Long  userId) {
    this.userId = userId;
    }
    
    public String getObjectType() {
    return this.objectType;
    }

    public void setObjectType(String  objectType) {
    this.objectType = objectType;
    }
    
    public Long getObjectId() {
    return this.objectId;
    }

    public void setObjectId(Long  objectId) {
    this.objectId = objectId;
    }
    
}