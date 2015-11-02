/**
 * @(#)CommentPostDeleteRequest.java
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
package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-22 11:16:50.
 * @author 顾志雄
 */
public class CommentPostDeleteBatchRequest extends BaseRequest {

    /**
     * 评论表ID
     */
    @NotNull
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
