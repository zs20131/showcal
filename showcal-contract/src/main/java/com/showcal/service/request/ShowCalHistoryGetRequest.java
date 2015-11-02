package com.showcal.service.request;

import com.xiniunet.framework.base.BaseFindRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.request
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.service.request
 * </pre>
 */
public class ShowCalHistoryGetRequest extends BaseFindRequest{
    /**
     * 名字
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
