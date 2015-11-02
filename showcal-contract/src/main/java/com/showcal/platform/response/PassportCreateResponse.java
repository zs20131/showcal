package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV001 on 2014/8/13.
 */
public class PassportCreateResponse extends BaseResponse {

    /**
     * 护照ID
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
