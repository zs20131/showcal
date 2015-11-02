package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.platform.response
 *  Description:
 * ***************************************************************
 *  10/13 0013  V1.0  xiniu    New Files for com.showcal.platform.response
 * </pre>
 */
public class MaxSqlVersionGetResponse extends BaseResponse {
    /**
     * 最大SQL版本号
     */
    private Long maxVersion;

    public Long getMaxVersion() {
        return maxVersion;
    }

    public void setMaxVersion(Long maxVersion) {
        this.maxVersion = maxVersion;
    }
}
