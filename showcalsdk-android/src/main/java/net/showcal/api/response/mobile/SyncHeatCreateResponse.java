package net.showcal.api.response.mobile;

import net.showcal.api.XiniuResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.api.response
 *  Description:
 * ***************************************************************
 *  10/19 0019  V1.0  xiniu    New Files for net.showcal.api.response
 * </pre>
 */
public class SyncHeatCreateResponse extends XiniuResponse {
    /**
     * 新创建的热量同步表ID
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
