package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class MessageGetRequest extends BaseRequest {

    /**
     * 消息ID
     */
    @NotNull
    @Min(1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
