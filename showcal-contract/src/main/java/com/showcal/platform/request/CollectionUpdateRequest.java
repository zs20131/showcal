/**
 * @(#)CollectionUpdateRequest.java
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
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;


/**
 * Created by 顾志雄 on 2015-09-23 10:27:25.
 * @author 顾志雄
 */
public class CollectionUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 用户ID 
     */
    @NotNull(message = "用户ID不能为空")
    private  Long   userId;
    
    /**
     * 收藏对象类型 
     */
    
    @Length(min=0, max=50, message = "收藏对象类型长度不合法")
    private  String   objectType;
    
    /**
     * 收藏对象ID 
     */
    @NotNull(message = "收藏对象ID不能为空")
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
