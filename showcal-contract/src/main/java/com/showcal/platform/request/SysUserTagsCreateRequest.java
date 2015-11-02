/**
 * @(#)SysUserTagsCreateRequest.java
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
 * Created by 顾志雄 on 2015-09-26 18:56:46.
 * @author 顾志雄
 */
public class SysUserTagsCreateRequest extends BaseRequest {
    
    /**
     * 用户ID 
     */
    
    private  Long   userId;
    
    /**
     * 用户标签ID 
     */
    
    private  Long   userTagId;
    

    
    public Long getUserId() {
    return this.userId;
    }

    public void setUserId(Long  userId) {
    this.userId = userId;
    }
    
    public Long getUserTagId() {
    return this.userTagId;
    }

    public void setUserTagId(Long  userTagId) {
    this.userTagId = userTagId;
    }
    

}
