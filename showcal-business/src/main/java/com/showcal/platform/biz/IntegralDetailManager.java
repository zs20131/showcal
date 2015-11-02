/**
 * @(#)IntegralDetailManager.java
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

import com.showcal.platform.request.IntegralDetailCreateRequest;
import com.showcal.platform.request.IntegralDetailFindRequest;
import com.showcal.platform.request.IntegralDetailGetForMyRequest;
import com.showcal.platform.response.IntegralDetailCreateResponse;
import com.showcal.platform.response.IntegralDetailFindResponse;
import com.showcal.platform.response.IntegralDetailGetForMyResponse;
import com.xiniunet.framework.security.Passport;


/**
 * Created by 顾志雄 on 2015-09-17 11:07:59.
 *
 * @author 顾志雄
 */
public interface IntegralDetailManager {

    /**
     * 高级查询积分明细
     *
     * @param request  高级查询积分明细请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    IntegralDetailFindResponse find(IntegralDetailFindRequest request, Passport passport);

    /**
     * 创建积分明细
     *
     * @param request  创建积分明细请求
     * @param passport 用户护照
     * @return 创建积分明细应答
     */
    IntegralDetailCreateResponse create(IntegralDetailCreateRequest request, Passport passport);

    /**
     * 获取我个人的积分情况
     * @param request
     * @param passport
     * @return
     */
    IntegralDetailGetForMyResponse getMyDetail(IntegralDetailGetForMyRequest request, Passport passport);
}
