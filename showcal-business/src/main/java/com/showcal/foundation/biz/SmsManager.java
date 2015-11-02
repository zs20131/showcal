/**
 * @(#)SmsManager.java
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
package com.showcal.foundation.biz;


import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 沈振家 on 2015-05-19 19:38:52.
 * @author 沈振家
 */
public interface SmsManager {
    /**
     * 根据Id获取手机短信通知表
     *
     * @param request 获取手机短信通知表请求
     * @param passport 用户护照
     * @return 获取手机短信通知表应答
     */
    SmsGetResponse get(SmsGetRequest request, Passport passport);



    /**
     * 高级查询手机短信通知表
     *
     * @param request 高级查询手机短信通知表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SmsFindResponse find(SmsFindRequest request, Passport passport);



    /**
     * 创建手机短信通知表
     *
     * @param request 创建手机短信通知表请求
     * @param passport 用户护照
     * @return 创建手机短信通知表应答
     */
    SmsCreateResponse create(SmsCreateRequest request, Passport passport);


    /**
     * 删除手机短信通知表
     *
     * @param request 删除手机短信通知表请求
     * @param passport 用户护照
     * @return 删除手机短信通知表应答
     */
    SmsDeleteResponse delete(SmsDeleteRequest request, Passport passport);

    /**
     * 发送短信
     *
     * @param request 发送短信请求
     * @param passport 用户护照
     * @return 发送短信应答
     */
    SmsSendResponse send(SmsSendRequest request, Passport passport);


}
