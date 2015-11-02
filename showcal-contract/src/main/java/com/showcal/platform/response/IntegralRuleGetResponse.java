/**
 * @(#)IntegralRuleGetResponse.java
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

import com.showcal.platform.domain.IntegralRule;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-17 11:07:59.
 * @author 顾志雄
 */
public class IntegralRuleGetResponse extends BaseResponse {

    /**
     * 积分规则信息
     */
    private IntegralRule integralRule;

    public IntegralRule getIntegralRule() {
        return this.integralRule;
    }

    public void setIntegralRule(IntegralRule integralRule) {
        this.integralRule = integralRule;
    }
}
