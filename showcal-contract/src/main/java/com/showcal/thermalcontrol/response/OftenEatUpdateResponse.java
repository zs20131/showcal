/**
 * @(#)OftenEatUpdateResponse.java
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

import com.showcal.thermalcontrol.domain.OftenEat;
import com.xiniunet.framework.base.BaseUpdateResponse;

/**
 * Created by 顾志雄 on 2015-09-23 13:32:27.
 * @author 顾志雄
 */
public class OftenEatUpdateResponse extends BaseUpdateResponse {
    private static final long serialVersionUID = 1L;
    /** 更新的常吃数据表的数目 */
    private Long result;

    public Long getResult() {
    return this.result;
    }

    public void setResult(Long result) {
    this.result = result;
    }
}
