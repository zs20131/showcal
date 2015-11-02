package com.showcal.cms.request;

import com.showcal.cms.domain.StatisticsTypeEnum;
import com.xiniunet.framework.base.BaseFindRequest;
import com.xiniunet.framework.base.BaseUpdateRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.cms.request
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.cms.request
 * </pre>
 */
public class ArticleStatisticsCollectRequest extends BaseFindRequest {
    /**
     * 类型类型
     */
    private StatisticsTypeEnum type;
    /**
     * 待统计文章ID
     */
    private Long articleId;

    /**
     * 用户Id
     */
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public StatisticsTypeEnum getType() {
        return type;
    }

    public void setType(StatisticsTypeEnum type) {
        this.type = type;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
