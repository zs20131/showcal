/**
 * @(#)SmsGetResponse.java
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
package com.showcal.foundation.response;

import com.showcal.platform.domain.SysSms;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 沈振家 on 2015-05-19 19:38:52.
 * @author 沈振家
 */
public class SmsGetResponse extends BaseResponse {

    /**
     * 手机短信通知表信息
     */
    private SysSms sysSms;

    public SysSms getSysSms() {
        return sysSms;
    }

    public void setSysSms(SysSms sysSms) {
        this.sysSms = sysSms;
    }
}
