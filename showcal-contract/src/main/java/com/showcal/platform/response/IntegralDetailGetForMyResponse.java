/**
 * @(#)IntegralDetailGetAllListResponse.java
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
package com.showcal.platform.response;

import com.showcal.platform.domain.IntegralDetail;
import com.xiniunet.framework.base.BaseGetAllListResponse;


/**
 * Created by 顾志雄 on 2015-09-17 11:07:59.
 *
 * @author 顾志雄
 */
public class IntegralDetailGetForMyResponse extends BaseGetAllListResponse<IntegralDetail> {
    /**
     * 总积分(预留明细接口,本期只显示总积分)
     */
    private Integer totoalIntegral;

    public Integer getTotoalIntegral() {
        return totoalIntegral;
    }

    public void setTotoalIntegral(Integer totoalIntegral) {
        this.totoalIntegral = totoalIntegral;
    }
}
