package com.showcal.cms.request;

import com.xiniunet.framework.base.BaseFindRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.cms.request
 *  Description:
 * ***************************************************************
 *  10/19 0019  V1.0  xiniu    New Files for com.showcal.cms.request
 * </pre>
 */
public class ArticleCollectionGetRequest extends BaseFindRequest {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
