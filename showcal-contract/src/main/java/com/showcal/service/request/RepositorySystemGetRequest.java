package com.showcal.service.request;

import com.xiniunet.framework.base.BaseSearchRequest;

import java.util.Date;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.request
 *  Description:查询系统知识库
 * ***************************************************************
 *  10/17 0017  V1.0  xiniu    New Files for com.showcal.service.request
 * </pre>
 */
public class RepositorySystemGetRequest extends BaseSearchRequest {
    /**
     * 关键字IDS
     */
    private List<Long> keywords;

    /**
     * 标签IDS
     */
    private List<Long> tageIds;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Long> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Long> keywords) {
        this.keywords = keywords;
    }

    public List<Long> getTageIds() {
        return tageIds;
    }

    public void setTageIds(List<Long> tageIds) {
        this.tageIds = tageIds;
    }
}
