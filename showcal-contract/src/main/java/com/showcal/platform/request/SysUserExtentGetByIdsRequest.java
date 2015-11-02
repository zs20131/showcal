package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseRequest;

import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.platform.request
 *  Description:
 * ***************************************************************
 *  9/28 0028  V1.0  xiniu    New Files for com.showcal.platform.request
 * </pre>
 */
public class SysUserExtentGetByIdsRequest extends BaseRequest {
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
