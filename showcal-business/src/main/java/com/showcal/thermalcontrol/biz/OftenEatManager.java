/**
 * @(#)OftenEatManager.java
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
package com.showcal.thermalcontrol.biz;

import com.showcal.thermalcontrol.request.OftenEatCreateRequest;
import com.showcal.thermalcontrol.request.OftenEatDeleteRequest;
import com.showcal.thermalcontrol.request.OftenEatUpdateRequest;
import com.showcal.thermalcontrol.response.OftenEatCreateResponse;
import com.showcal.thermalcontrol.response.OftenEatDeleteResponse;
import com.showcal.thermalcontrol.response.OftenEatUpdateResponse;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-23 13:32:27.
 *
 * @author 顾志雄
 */
public interface OftenEatManager {


    /**
     * 创建常吃数据表
     *
     * @param request  创建常吃数据表请求
     * @param passport 用户护照
     * @return 创建常吃数据表应答
     */
    OftenEatCreateResponse create(OftenEatCreateRequest request, Passport passport);


    /**
     * 更新常吃数据表
     *
     * @param request  更新常吃数据表请求
     * @param passport 用户护照
     * @return 更新常吃数据表应答
     */
    OftenEatUpdateResponse update(OftenEatUpdateRequest request, Passport passport);


    /**
     * 删除常吃数据表
     *
     * @param request  删除常吃数据表请求
     * @param passport 用户护照
     * @return 删除常吃数据表应答
     */
    OftenEatDeleteResponse delete(OftenEatDeleteRequest request, Passport passport);
}
