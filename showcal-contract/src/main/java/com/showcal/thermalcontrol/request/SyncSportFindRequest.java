/**
 * @(#)SyncSportFindRequest.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public class SyncSportFindRequest extends BaseFindRequest {

    

    
    

    
    

    
    

    
    /**
     * 运动强度,高中低
     */
    private  String   intensity;
    
    

    
    /**
     * 运动地点,
     */
    private  String   address;
    
    

    
    

    
    
    
    
    
    
    
    
    public String getIntensity() {
    return this.intensity;
    }

    public void setIntensity(String intensity) {
    this.intensity = intensity;
    }
    
    
    
    public String getAddress() {
    return this.address;
    }

    public void setAddress(String address) {
    this.address = address;
    }
    
    
    
    
}
