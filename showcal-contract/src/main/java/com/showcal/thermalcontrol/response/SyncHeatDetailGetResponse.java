/**
 * @(#)SyncHeatDetailGetResponse.java
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

import com.showcal.thermalcontrol.domain.SyncHeatDetail;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public class SyncHeatDetailGetResponse extends BaseResponse {

    /**
     * 热量同步明细表信息
     */
    private SyncHeatDetail syncHeatDetail;

    public SyncHeatDetail getSyncHeatDetail() {
        return this.syncHeatDetail;
    }

    public void setSyncHeatDetail(SyncHeatDetail syncHeatDetail) {
        this.syncHeatDetail = syncHeatDetail;
    }
}
