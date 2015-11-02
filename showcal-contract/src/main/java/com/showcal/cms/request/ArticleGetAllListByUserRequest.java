/**
 * @(#)ArticleGetAllListRequest.java
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
package com.showcal.cms.request;

import com.xiniunet.framework.base.BaseRequest;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 * @author 顾志雄
 */
public class ArticleGetAllListByUserRequest extends BaseRequest {
    private Long submitUser;

    private List<Long> categoryId;

    public Long getSubmitUser() {
        return submitUser;
    }

    public void setSubmitUser(Long submitUser) {
        this.submitUser = submitUser;
    }

    public List<Long> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(List<Long> categoryId) {
        this.categoryId = categoryId;
    }
}
