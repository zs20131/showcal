package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class MessageReadRequest extends BaseRequest {

    /**
     * 消息ID列表
     */
    @NotNull
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
