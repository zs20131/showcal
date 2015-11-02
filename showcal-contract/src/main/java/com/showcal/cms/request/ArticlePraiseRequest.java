/**
 * @(#)ArticleBodyCreateRequest.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.cms.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 * @author 顾志雄
 */
public class ArticlePraiseRequest extends BaseRequest {
    @NotNull(message = "正文Id 不能为空，请检查")
    private Long id;
    private Boolean isPraise;

    public Boolean getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(Boolean isPraise) {
        this.isPraise = isPraise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}