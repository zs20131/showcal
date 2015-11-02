package com.showcal.service.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.response
 *  Description:
 * ***************************************************************
 *  9/25 0025  V1.0  xiniu    New Files for com.showcal.service.response
 * </pre>
 */
public class SelfIntroductionGetResponse extends BaseResponse {
    /**
     * Id
     */
    private Long id;
    /**
     * 封面ID
     */
    private Long coverId;
    /**
     * 文章内容
     */
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoverId() {
        return coverId;
    }

    public void setCoverId(Long coverId) {
        this.coverId = coverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
