/**
 * @(#)ArticleBodyManager.java
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
package com.showcal.cms.biz;

import com.showcal.cms.request.ArticleBodyCreateRequest;
import com.showcal.cms.request.ArticleBodyDeleteRequest;
import com.showcal.cms.request.ArticleBodyGetRequest;
import com.showcal.cms.request.ArticleBodyUpdateRequest;
import com.showcal.cms.response.ArticleBodyCreateResponse;
import com.showcal.cms.response.ArticleBodyDeleteResponse;
import com.showcal.cms.response.ArticleBodyUpdateResponse;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 * @author 顾志雄
 */
public interface ArticleBodyManager {



    /**
     * 创建文章内容
     *
     * @param request 创建文章内容请求
     * @param passport 用户护照
     * @return 创建文章内容应答
     */
    ArticleBodyCreateResponse create(ArticleBodyCreateRequest request, Passport passport);


    /**
     * 更新文章内容
     *
     * @param request 更新文章内容请求
     * @param passport 用户护照
     * @return 更新文章内容应答
     */
    ArticleBodyUpdateResponse update(ArticleBodyUpdateRequest request, Passport passport);


    /**
     * 删除文章内容
     *
     * @param request 删除文章内容请求
     * @param passport 用户护照
     * @return 删除文章内容应答
     */
    ArticleBodyDeleteResponse delete(ArticleBodyDeleteRequest request, Passport passport);


}
