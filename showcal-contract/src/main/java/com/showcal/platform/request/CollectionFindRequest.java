/**
 * @(#)CollectionFindRequest.java
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

import com.xiniunet.framework.base.BaseFindRequest;

/**
 * Created by 顾志雄 on 2015-09-23 10:27:25.
 * @author 顾志雄
 */
public class CollectionFindRequest extends BaseFindRequest {

    /**
     * 用户ID,
     */
    private  Long   userId;

    /**
     * 对象id
     */
    private Long objectId;


    /**
     * 类型
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Long getUserId() {
    return this.userId;
    }

    public void setUserId(Long userId) {
    this.userId = userId;
    }
    
    
    
    
    
    
}
