/**
 * @(#)MessageGetResponse.java
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
package com.showcal.service.response;

import com.showcal.service.domain.ServiceMessage;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-23 10:27:34.
 *
 * @author 顾志雄
 */
public class ServiceMessageGetResponse extends BaseResponse {

    /**
     * 消息内容信息
     */
    private ServiceMessage message;

    public ServiceMessage getMessage() {
        return message;
    }

    public void setMessage(ServiceMessage message) {
        this.message = message;
    }
}
