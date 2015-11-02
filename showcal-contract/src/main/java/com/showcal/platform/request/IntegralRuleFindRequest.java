/**
 * @(#)IntegralRuleFindRequest.java
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
 * Created by 顾志雄 on 2015-09-30 15:41:57.
 * @author 顾志雄
 */
public class IntegralRuleFindRequest extends BaseFindRequest {
    private Long id;

    /**
     * ,LOGIN(登录),
USERTC（使用热控工具）,
QUESTION(提问),REPLY(回帖)，FORWORD(转发)
     */
    private  String   type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
    return this.type;
    }

    public void setType(String type) {
    this.type = type;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
