package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseRequest;

/**
 * Created by DEV001 on 2014/8/13.
 */
public class PassportRevokeRequest extends BaseRequest {

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
