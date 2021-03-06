/**
 * @(#)FoodCategoryFindRequest.java
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
package com.showcal.thermalcontrol.request;

import com.xiniunet.framework.base.BaseFindRequest;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:57.
 * @author 顾志雄
 */
public class FoodCategoryFindRequest extends BaseFindRequest {

    

    
    

    
    /**
     * 食物类别名称,
     */
    private  String   name;
    
    

    
    
    
    
    public String getName() {
    return this.name;
    }

    public void setName(String name) {
    this.name = name;
    }
    
    
}
