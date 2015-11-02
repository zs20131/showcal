package net.showcal.api.response.mobile;

import net.showcal.api.XiniuResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.api.response.mobile
 *  Description:
 * ***************************************************************
 *  10/13 0013  V1.0  xiniu    New Files for net.showcal.api.response.mobile
 * </pre>
 */
public class MaxSqlVersionGetResponse extends XiniuResponse {
    private Long maxVersion;

    public Long getMaxVersion() {
        return maxVersion;
    }

    public void setMaxVersion(Long maxVersion) {
        this.maxVersion = maxVersion;
    }
}
