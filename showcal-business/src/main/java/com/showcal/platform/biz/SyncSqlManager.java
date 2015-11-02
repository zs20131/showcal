/**
 * @(#)SyncSqlManager.java
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

import com.showcal.platform.request.MaxSqlVersionGetRequest;
import com.showcal.platform.request.SyncSqlCreateRequest;
import com.showcal.platform.request.SyncSqlIncrementRequest;
import com.showcal.platform.response.MaxSqlVersionGetResponse;
import com.showcal.platform.response.SyncSqlCreateResponse;
import com.showcal.platform.response.SyncSqlIncrementResponse;
import com.xiniunet.framework.security.Passport;


/**
 * Created by 顾志雄 on 2015-09-17 11:08:01.
 *
 * @author 顾志雄
 */
public interface SyncSqlManager {
    /**
     * 创建数据表同步
     *
     * @param request  创建数据表同步请求
     * @param passport 用户护照
     * @return 创建数据表同步应答
     */
    SyncSqlCreateResponse create(SyncSqlCreateRequest request, Passport passport);

    /**
     * 获取增量SQL
     * @param request
     * @param passport
     * @return
     */
    SyncSqlIncrementResponse syncIncrement(SyncSqlIncrementRequest request, Passport passport);

    /**
     * 获取最大SQL版本号
     * @param request
     * @param passport
     * @return
     */
    public MaxSqlVersionGetResponse getMaxSqlVersion(MaxSqlVersionGetRequest request,Passport passport);
}
