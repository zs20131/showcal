package com.showcal.foundation.response;

import com.showcal.foundation.domain.Message;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class MessageGetResponse extends BaseResponse {

    /**
     * 消息信息
     */
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
