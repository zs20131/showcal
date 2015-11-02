/**
 * @(#)SettingUserTagFindRequest.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 * @author 顾志雄
 */
public class SettingUserTagFindRequest extends BaseFindRequest {


    /**
     *  标签名
     */
    private String tag;

    
    

    
    

    
    /**
     * 是否有效,
     */
    private  Boolean   isActive;


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getIsActive() {
    return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
    }
    
    
    
    
}
