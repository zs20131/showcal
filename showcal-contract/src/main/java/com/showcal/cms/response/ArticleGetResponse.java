/**
 * @(#)ArticleGetResponse.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.cms.response;

import com.showcal.cms.domain.Article;
import com.showcal.platform.domain.CommentPost;
import com.xiniunet.framework.base.BaseResponse;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 *
 * @author 顾志雄
 */
public class ArticleGetResponse extends BaseResponse {

    /**
     * 文章信息
     */
    private Article article;


    public Article getArticle() {
        return this.article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
