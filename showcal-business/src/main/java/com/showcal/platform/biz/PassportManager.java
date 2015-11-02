/**
 * @(#)PassportManager.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.platform.biz;


import com.showcal.platform.request.*;
import com.showcal.platform.response.*;

/**
 * Created by 沈振家 on 2014-07-30 16:47:07.
 *
 * @author 沈振家
 */
public interface PassportManager {

    /**
     * 创建护照
     *
     * @param req 创建护照请求
     * @return 创建护照应答
     */
    PassportCreateResponse create(PassportCreateRequest req);

    /**
     * 取得护照
     *
     * @param req 取得护照请求
     * @return 取得护照应答
     */
    PassportGetResponse get(PassportGetRequest req);

    /**
     * 注销护照
     *
     * @param req 注销护照请求
     * @return 注销护照应答
     */
    PassportRevokeResponse revoke(PassportRevokeRequest req);

}
