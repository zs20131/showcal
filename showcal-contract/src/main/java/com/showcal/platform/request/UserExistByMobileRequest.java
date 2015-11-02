package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.base.request
 *  Description:
 * ***************************************************************
 *  8/12 0012  V1.0  xiniu    New Files for com.xiniunet.base.request
 * </pre>
 */
public class UserExistByMobileRequest extends BaseRequest{
    private Long id;
    private String mobilePhone;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
