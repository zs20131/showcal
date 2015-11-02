/**
 * @(#)SportLineDeleteResponse.java
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
package com.showcal.thermalcontrol.response;

import com.showcal.thermalcontrol.domain.SportLine;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class SportLineDeleteResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;
    /** 作废的运动方案明细数目 */
    private Long result;

    public Long getResult() {
    return this.result;
    }

    public void setResult(Long result) {
    this.result = result;
    }
}
