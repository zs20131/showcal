/**
 * @(#)SyncSqlGetAllListRequest.java
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

import com.xiniunet.framework.base.BaseFindRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by 顾志雄 on 2015-09-17 11:08:01.
 * @author 顾志雄
 */
public class SyncSqlIncrementRequest extends BaseFindRequest {
    /**
     * 当前版本号
     */
    @NotNull(message = "当前版本号不能为空")
    private Integer currentVersion;

    public Integer getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Integer currentVersion) {
        this.currentVersion = currentVersion;
    }
}
