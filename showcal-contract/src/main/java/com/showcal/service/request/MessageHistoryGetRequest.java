package com.showcal.service.request;

import com.showcal.service.domain.MessageTimeEnum;
import com.xiniunet.framework.base.BaseFindRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.request
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.service.request
 * </pre>
 */
public class MessageHistoryGetRequest extends BaseFindRequest {
    /**
     * 用户ID
      */
    private Long userId;
    /**
     * 服务于我的瘦咖ID
     */
    private Long showcalId;
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 消息时间
     */
    private MessageTimeEnum messageTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowcalId() {
        return showcalId;
    }

    public void setShowcalId(Long showcalId) {
        this.showcalId = showcalId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public MessageTimeEnum getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(MessageTimeEnum messageTime) {
        this.messageTime = messageTime;
    }
}
