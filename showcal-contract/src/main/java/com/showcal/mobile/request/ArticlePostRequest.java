package com.showcal.mobile.request;

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.NotBlank;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.mobile.request
 *  Description:
 * ***************************************************************
 *  9/18 0018  V1.0  xiniu    New Files for com.showcal.mobile.request
 * </pre>
 */
public class ArticlePostRequest extends BaseRequest{
    /**
     * 标题
     */
    private  String   title;

    /**
     * 封面图片ID
     */
    private  Long   coverId;

    /**
     * 摘要
     */
    private  String   summary;
    /**
     * 文章内容
     */
    @NotBlank(message = "发布的文章内容不能为空")
    private  String articlebody;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCoverId() {
        return coverId;
    }

    public void setCoverId(Long coverId) {
        this.coverId = coverId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getArticlebody() {
        return articlebody;
    }

    public void setArticlebody(String articlebody) {
        this.articlebody = articlebody;
    }
}
