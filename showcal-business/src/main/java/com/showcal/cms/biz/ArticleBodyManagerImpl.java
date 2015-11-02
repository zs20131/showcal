/**
 * @(#)ArticleBodyManagerImpl.java
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

import com.showcal.cms.dal.ArticleBodyMapper;
import com.showcal.cms.po.ArticleBodyPO;
import com.showcal.cms.request.ArticleBodyCreateRequest;
import com.showcal.cms.request.ArticleBodyDeleteRequest;
import com.showcal.cms.request.ArticleBodyUpdateRequest;
import com.showcal.cms.response.ArticleBodyCreateResponse;
import com.showcal.cms.response.ArticleBodyDeleteResponse;
import com.showcal.cms.response.ArticleBodyUpdateResponse;
import com.showcal.cms.svc.Message;
import com.showcal.foundation.service.FoundationService;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 *
 * @author 顾志雄
 */
@Transactional
@Service("CmsArticleBodyManager")
public class ArticleBodyManagerImpl extends BaseManagerImpl implements ArticleBodyManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private ArticleBodyMapper articleBodyMapper;

    /**
     * 创建文章内容
     *
     * @param request  创建文章内容请求
     * @param passport 用户护照
     * @return 创建文章内容应答
     */
    @Override
    public ArticleBodyCreateResponse create(ArticleBodyCreateRequest request, Passport passport) {
        ArticleBodyPO entity = this.getMapper().map(request, ArticleBodyPO.class);
        ArticleBodyCreateResponse response = new ArticleBodyCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == articleBodyMapper.insert(entity, passport)) {
            response.setId(request.getId());
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新文章内容
     *
     * @param request  更新文章内容请求
     * @param passport 用户护照
     * @return 更新文章内容应答
     */
    @Override
    public ArticleBodyUpdateResponse update(ArticleBodyUpdateRequest request, Passport passport) {
        ArticleBodyPO entity = this.getMapper().map(request, ArticleBodyPO.class);

        ArticleBodyUpdateResponse response = new ArticleBodyUpdateResponse();
        Long result = articleBodyMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除文章内容
     *
     * @param request  删除文章内容请求
     * @param passport 用户护照
     * @return 删除文章内容应答
     */
    @Override
    public ArticleBodyDeleteResponse delete(ArticleBodyDeleteRequest request, Passport passport) {
        ArticleBodyDeleteResponse response = new ArticleBodyDeleteResponse();
        Long result = articleBodyMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 验证对象
     *
     * @param articleBody 文章内容
     * @param passport    用户护照
     */
    private void checkValidate(ArticleBodyPO articleBody, Passport passport, BaseResponse response) {
        // TODO

    }


}
