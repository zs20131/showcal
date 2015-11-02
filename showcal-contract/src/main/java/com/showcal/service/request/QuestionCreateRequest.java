/**
 * @(#)QuestionCreateRequest.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.service.request;

import com.showcal.service.domain.MessageTypeEnum;
import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
public class QuestionCreateRequest extends BaseRequest {
    /**
     * 标签 问题的标签(如果问题贴标签，则不解析关键字)
     */
    private Long tag;
    /**
     * 问题消息类型
     */
    @NotNull(message = "消息内容不能为空")
    private MessageTypeEnum type;
    /**
     * 消息内容
     */
    private String Content;

    /**
     * 链接地址
     */
    private String url;
    /**
     * 服务该用户的瘦咖Id
     */
    @NotNull(message = "未找到对应的瘦咖信息")
    private Long showCalId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getShowCalId() {
        return showCalId;
    }

    public void setShowCalId(Long showCalId) {
        this.showCalId = showCalId;
    }

    public Long getTag() {
        return tag;
    }

    public void setTag(Long tag) {
        this.tag = tag;
    }

    public MessageTypeEnum getType() {
        return type;
    }

    public void setType(MessageTypeEnum type) {
        this.type = type;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
