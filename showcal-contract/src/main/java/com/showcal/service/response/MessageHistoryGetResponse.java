package com.showcal.service.response;

import com.showcal.service.domain.ServiceMessage;
import com.showcal.service.domain.UserServiceMessage;
import com.xiniunet.framework.base.BaseFindResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.response
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.service.response
 * </pre>
 */
public class MessageHistoryGetResponse extends BaseFindResponse<ServiceMessage>{
    /**
     *  当前用户头像
     */
    private String url;

    /**
     * 当前用户姓名
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
