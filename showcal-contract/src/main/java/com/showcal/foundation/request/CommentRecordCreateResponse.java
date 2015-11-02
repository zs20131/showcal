package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV004 on 2014/10/30.
 */
public class CommentRecordCreateResponse extends BaseResponse {

    /**
     * 返回Id
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
