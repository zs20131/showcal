/**
 * @(#)SysSmsManager.java
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
package com.showcal.platform.biz;

import com.showcal.foundation.request.SmsCreateRequest;
import com.showcal.foundation.request.SmsDeleteRequest;
import com.showcal.foundation.request.SmsFindRequest;
import com.showcal.foundation.request.SmsGetRequest;
import com.showcal.foundation.response.SmsCreateResponse;
import com.showcal.foundation.response.SmsDeleteResponse;
import com.showcal.foundation.response.SmsFindResponse;
import com.showcal.foundation.response.SmsGetResponse;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 *
 * @author 顾志雄
 */
public interface SysSmsManager {
    /**
     * 根据Id获取短信通知表
     *
     * @param request  获取短信通知表请求
     * @param passport 用户护照
     * @return 获取短信通知表应答
     */
    SmsGetResponse get(SmsGetRequest request, Passport passport);

    /**
     * 高级查询短信通知表
     *
     * @param request  高级查询短信通知表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SmsFindResponse find(SmsFindRequest request, Passport passport);

    /**
     * 创建短信通知表
     *
     * @param request  创建短信通知表请求
     * @param passport 用户护照
     * @return 创建短信通知表应答
     */
    SmsCreateResponse create(SmsCreateRequest request, Passport passport);


    /**
     * 删除短信通知表
     *
     * @param request  删除短信通知表请求
     * @param passport 用户护照
     * @return 删除短信通知表应答
     */
    SmsDeleteResponse delete(SmsDeleteRequest request, Passport passport);


}
