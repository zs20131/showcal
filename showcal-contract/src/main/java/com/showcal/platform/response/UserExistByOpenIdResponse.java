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
 *  10/17 0017  V1.0  xiniu    New Files for com.showcal.platform.response
 * </pre>
 */
public class UserExistByOpenIdResponse extends BaseResponse {
    /**
     * 是否包含
     */
    private Boolean isExist;

    public Boolean getIsExist() {
        return isExist;
    }

    public void setIsExist(Boolean isExist) {
        this.isExist = isExist;
    }
}
