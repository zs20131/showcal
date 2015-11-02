/**
 * @(#)SequenceManager.java
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
package com.showcal.foundation.biz;

import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.foundation.request.SequenceGetNextRequest;
import com.showcal.foundation.response.IdsGetResponse;
import com.showcal.foundation.response.SequenceGetNextResponse;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
public interface SequenceManager {
    /**
     * 根据代码获取编号
     *
     * @param req      序列号代码
     * @param passport 用户护照
     * @return 下一个编号
     */
    SequenceGetNextResponse getNextSequence(SequenceGetNextRequest req, Passport passport);

    /**
     * 获取下一个唯一编号
     *
     * @return 唯一编号
     */
    Long getNewId();

    /**
     * @return
     */
    IdsGetResponse getNewIds(IdsGetRequest req);
}
