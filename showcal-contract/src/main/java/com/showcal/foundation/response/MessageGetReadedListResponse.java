package com.showcal.foundation.response;

import com.showcal.foundation.domain.Message;
import com.xiniunet.framework.base.BaseResponse;

import java.util.List;

/**
 * Created by DEV001 on 2014/8/14.
 */
public class MessageGetReadedListResponse extends BaseResponse {

    /**
     * 消息列表
     */
    private List<Message> messageList;

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
