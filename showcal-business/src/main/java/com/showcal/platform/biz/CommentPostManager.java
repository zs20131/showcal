/**
 * @(#)CommentPostManager.java
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
package com.showcal.platform.biz;

import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:50.
 * @author 顾志雄
 */
public interface CommentPostManager {
    /**
     * 高级查询评论表
     *
     * @param request 高级查询评论表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    CommentPostFindResponse find(CommentPostFindRequest request, Passport passport);


    /**
     * 创建评论表
     *
     * @param request 创建评论表请求
     * @param passport 用户护照
     * @return 创建评论表应答
     */
    CommentPostCreateResponse create(CommentPostCreateRequest request, Passport passport);

    /**
     * 创建评论表
     *
     * @param request 创建评论表请求
     * @param passport 用户护照
     * @return 创建评论表应答
     */
    CommentPostCreateListResponse createList(CommentPostCreateListRequest request, Passport passport);



    /**
     * 删除评论表
     *
     * @param request 删除评论表请求
     * @param passport 用户护照
     * @return 删除评论表应答
     */
    CommentPostDeleteResponse delete(CommentPostDeleteRequest request, Passport passport);

    /**
     * 删除评论表
     *
     * @param request 删除评论表请求
     * @param passport 用户护照
     * @return 删除评论表应答
     */
    CommentPostDeleteBatchResponse deleteBatch(CommentPostDeleteBatchRequest request, Passport passport);


}
