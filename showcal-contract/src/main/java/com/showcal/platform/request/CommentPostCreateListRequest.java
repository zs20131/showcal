/**
 * @(#)CommentPostCreateRequest.java
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
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-22 11:16:50.
 * @author 顾志雄
 */
public class CommentPostCreateListRequest extends BaseRequest {
    
   private List<CommentPostUpdateRequest>commentPostCreateRequestList;

    public List<CommentPostUpdateRequest> getCommentPostCreateRequestList() {
        return commentPostCreateRequestList;
    }

    public void setCommentPostCreateRequestList(List<CommentPostUpdateRequest> commentPostCreateRequestList) {
        this.commentPostCreateRequestList = commentPostCreateRequestList;
    }
}
