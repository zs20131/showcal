/**
 * @(#)SysUserCurveFindRequest.java
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
package com.showcal.platform.request;

import com.showcal.platform.domain.CurveTypeEnum;
import com.xiniunet.framework.base.BaseFindRequest;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 *
 * @author 顾志雄
 */
public class SysUserCurveFindRequest extends BaseFindRequest {
    /**
     * 类型
     */
    private CurveTypeEnum type;
    /**
     * 用户ID
     */
    private Long userId;


    public CurveTypeEnum getType() {
        return type;
    }

    public void setType(CurveTypeEnum type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
