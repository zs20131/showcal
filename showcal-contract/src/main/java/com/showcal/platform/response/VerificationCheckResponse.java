package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV001 on 2014/8/14.
 */
public class VerificationCheckResponse extends BaseResponse {

    /**
     * 验证是否成功标识
     */
    private Boolean isVerificated;

    /**
     * 用户ID
     */
    private Long id;

    public Boolean getIsVerificated() {
        return isVerificated;
    }

    public void setIsVerificated(Boolean isVerificated) {
        this.isVerificated = isVerificated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
