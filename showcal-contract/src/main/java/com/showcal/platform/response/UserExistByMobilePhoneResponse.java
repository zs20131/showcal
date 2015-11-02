package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.base.response
 *  Description:
 * ***************************************************************
 *  8/12 0012  V1.0  xiniu    New Files for com.xiniunet.base.response
 * </pre>
 */
public class UserExistByMobilePhoneResponse extends BaseResponse {
    private Boolean isExist;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsExist() {
        return isExist;
    }

    public void setIsExist(Boolean isExist) {
        this.isExist = isExist;
    }
}
