package com.showcal.service.domain;

import com.xiniunet.framework.base.BaseDomain;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.domain
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.service.domain
 * </pre>
 */
public class TotalKeyWordTag extends BaseDomain {
    /**
     * 关键字ID
     */
    private Long keywordId;
    /**
     * 关键字名字
     */
    private String keywordName;

    /**
     * 总记录数
     */
    private Integer count;

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public Long getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Long keywordId) {
        this.keywordId = keywordId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
