/**
 * @(#)CommentPostManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.platform.biz;

import com.showcal.cms.biz.ArticleManager;
import com.showcal.cms.dal.ArticleMapper;
import com.showcal.cms.domain.Article;
import com.showcal.cms.po.ArticlePO;
import com.showcal.cms.request.ArticleGetRequest;
import com.showcal.cms.request.ArticleUpdateRequest;
import com.showcal.cms.response.ArticleGetResponse;
import com.showcal.cms.svc.Message;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.CommentPostMapper;
import com.showcal.platform.dal.SysMessageMapper;
import com.showcal.platform.domain.*;
import com.showcal.platform.po.CommentPostPO;
import com.showcal.platform.po.SysMessagePO;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:50.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromCommentPostManager")
public class CommentPostManagerImpl extends BaseManagerImpl implements CommentPostManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private CommentPostMapper commentPostMapper;

    @Autowired
    private ArticleManager articleManager;
    @Autowired
    private SysUserManager sysUserManager;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private SysMessageMapper sysMessageMapper;
    @Autowired
    private IntegralDetailManager integralDetailManager;

    /**
     * 高级查询评论表
     *
     * @param request  高级查询评论表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public CommentPostFindResponse find(CommentPostFindRequest request, Passport passport) {
        CommentPostFindResponse response = new CommentPostFindResponse();
        List<CommentPost> modelList = new ArrayList<>();
        Long count = commentPostMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<CommentPostPO> entityList = commentPostMapper.find(request, passport);
            for (CommentPostPO entity : entityList) {
                CommentPost commentPost = this.getMapper().map(entity, CommentPost.class);
                if (commentPost.getUserId() != null) {
                    SysUserGetRequest sysUserGetRequest = new SysUserGetRequest();
                    sysUserGetRequest.setId(commentPost.getUserId());
                    SysUserGetResponse sysUserGetResponse = sysUserManager.get(sysUserGetRequest, passport);
                    SysUser userInfo = sysUserGetResponse.getSysUser();
                        if (userInfo != null) {
                            commentPost.setUserName(userInfo.getNickName());
                            if (userInfo.getAvatarId() != null&& userInfo.getAvatarId().intValue()!=0) {
                                commentPost.setAvatarurl(userInfo.getAvatarurl());
                            } else {
                                if (userInfo.getSex() != null) {
                                    if (userInfo.getSex().equals(SexEnum.FEMALE)) {
                                        commentPost.setAvatarurl("../images/girl.png");
                                    } else if (userInfo.getSex().equals(SexEnum.MALE)) {
                                        commentPost.setAvatarurl("../images/boy.png");
                                    }
                                } else {
                                    commentPost.setAvatarurl("../images/girl.png");
                                }
                            }

                        }
                    }
                    modelList.add(commentPost);
                }

            }

            response.setTotalCount(count);
            response.setResult(modelList);
            return response;
        }

/**
 * 创建评论表
 *
 * @param request 创建评论表请求
 * @param passport 用户护照
 * @return 创建评论表应答
 */
        @Override
        public CommentPostCreateResponse create (CommentPostCreateRequest request, Passport passport){
            CommentPostCreateResponse response = new CommentPostCreateResponse();
            CommentPostPO entity = this.getMapper().map(request, CommentPostPO.class);
            if (passport.getUserId().intValue() == request.getThreadId().intValue()) {
                response.addError(ErrorType.BUSINESS_ERROR, "自己不能评论");
                return response;
            }
            if(request.getBusinessType()!=null) {
                if (request.getBusinessType().equals("SERVICE")) {
                    //一周评论一次
                    CommentPostFindRequest commentPostFindRequest = new CommentPostFindRequest();
                    commentPostFindRequest.setThreadId(request.getThreadId());
                    commentPostFindRequest.setUserId(passport.getUserId());
                    CommentPostFindResponse commentPostFindResponse = this.find(commentPostFindRequest, passport);
                    if (commentPostFindResponse.getResult() != null) {
                        //获取最新评论
                        if (commentPostFindResponse.getResult().size() >= 1) {
                            CommentPost commentPost = commentPostFindResponse.getResult().get(0);
                            Date postTime = commentPost.getPostTime();
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(postTime);
                            calendar.add(Calendar.DAY_OF_MONTH, 7);
                            if (new Date().getTime() < calendar.getTime().getTime()) {
                                response.addError(ErrorType.BUSINESS_ERROR, "七天内只能评论一次");
                                return response;
                            }
                        }
                    }
                }
            }
            entity.setUserId(passport.getUserId());
            entity.setPostTime(new Date());
            long id = foundationService.getNewId();
            entity.setId(id);

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
            checkValidate(entity, passport, response);

            if (1 == commentPostMapper.insert(entity, passport)) {
                response.setId(id);
                ArticlePO article = articleMapper.getById(request.getThreadId(), passport);
                if (article != null) {
                    article.setCountComment(article.getCountComment() + 1);
                    ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(article, ArticleUpdateRequest.class);
                    articleManager.update(articleUpdateRequest, passport);
                    //创建消息
                    SysMessageCreateRequest createRequest = new SysMessageCreateRequest();
                    createRequest.setBusinessId(request.getThreadId());
                    createRequest.setSenderId(passport.getUserId());
                    createRequest.setBusinessType(MessageTypeEnum.COMMENT.name());
                    createRequest.setSendTime(new Date());
                    createRequest.setReceiptId(article.getSubmitUserId().toString());
                    createRequest.setMessageTitle(passport.getNickName() + "评论你的" + article.getTitle() + "的帖子");
                    createRequest.setMessageContent(passport.getNickName() + "评论你的" + article.getTitle() + "的帖子");
                    SysMessagePO sysMessagePO = this.getMapper().map(createRequest, SysMessagePO.class);
                    sysMessagePO.setId(id);
                    if (1 != sysMessageMapper.insert(sysMessagePO, passport)) {
                        response.addError(ErrorType.BUSINESS_ERROR, "创建消息失败");
                        return response;
                    }
                    //评论增加积分
                    IntegralDetailCreateRequest integralDetailCreateRequest = new IntegralDetailCreateRequest();
                    integralDetailCreateRequest.setType(IntegralRuleTypeEnum.REPLY.name());
                    integralDetailManager.create(integralDetailCreateRequest, passport);
                } else {
                    //创建消息
                    SysMessageCreateRequest createRequest = new SysMessageCreateRequest();
                    createRequest.setBusinessId(request.getThreadId());
                    createRequest.setSenderId(passport.getUserId());
                    createRequest.setBusinessType(MessageTypeEnum.SERVICE.name());
                    createRequest.setSendTime(new Date());
                    createRequest.setReceiptId(request.getThreadId().toString());
                    createRequest.setMessageTitle(passport.getNickName() + "对你进行了服务评价");
                    createRequest.setMessageTitle(passport.getNickName() + "对你进行了服务评价");
                    SysMessagePO sysMessagePO = this.getMapper().map(createRequest, SysMessagePO.class);
                    sysMessagePO.setId(id);
                    if (1 != sysMessageMapper.insert(sysMessagePO, passport)) {
                        response.addError(ErrorType.BUSINESS_ERROR, "创建消息失败");
                        return response;
                    }
                }

            } else {
                response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
            }
            return response;
        }

/**
 * 删除评论表
 *
 * @param request 删除评论表请求
 * @param passport 用户护照
 * @return 删除评论表应答
 */
        @Override
        public CommentPostDeleteResponse delete (CommentPostDeleteRequest request, Passport passport){
            CommentPostDeleteResponse response = new CommentPostDeleteResponse();
            CommentPostPO commentPostPo=commentPostMapper.getById(request.getId(),passport);
            Long result = commentPostMapper.delete(request.getId(), passport);
            //更新评论数
            ArticlePO article = articleMapper.getById(commentPostPo.getThreadId(), passport);
            if (article != null) {
                article.setCountComment(article.getCountComment() - 1);
                ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(article, ArticleUpdateRequest.class);
                articleManager.update(articleUpdateRequest, passport);
            }
            response.setResult(result);
            return response;
        }

        @Override
        public CommentPostDeleteBatchResponse deleteBatch (CommentPostDeleteBatchRequest request, Passport passport){
            CommentPostDeleteBatchResponse response = new CommentPostDeleteBatchResponse();
            long count = commentPostMapper.deleteBatch(request.getIds(), passport);
            response.setResult(count);
            return response;
        }

        @Override
        public CommentPostCreateListResponse createList (CommentPostCreateListRequest request, Passport passport){
            CommentPostCreateListResponse response = new CommentPostCreateListResponse();
            List<Long> ids = new ArrayList<>();
            CommentPostFindRequest findRequest = new CommentPostFindRequest();
            findRequest.setPageSize(0);
            findRequest.setThreadId(request.getCommentPostCreateRequestList().get(0).getThreadId());
            CommentPostFindResponse findResponse = this.find(findRequest, passport);
            List<CommentPost> newList = findResponse.getResult();
            List<Long> existIdList = new ArrayList<>();
            for (CommentPost phase : newList) {
                existIdList.add(phase.getId());
            }
            if (request.getCommentPostCreateRequestList() != null && request.getCommentPostCreateRequestList().size() > 0) {
                // 更新
                List<Long> updateIdList = new ArrayList<>();
                // 新添加的数据
                List<CommentPostPO> createList = new ArrayList<>();
                // 要删除的数据
                List<Long> deleteIdList = new ArrayList<>();

                for (CommentPostUpdateRequest commentPostUpdateRequest : request.getCommentPostCreateRequestList()) {
                    if (commentPostUpdateRequest.getId() != null) {
                        updateIdList.add(commentPostUpdateRequest.getId());
                        commentPostMapper.update(this.getMapper().map(commentPostUpdateRequest, CommentPostPO.class), passport);
                    } else {
                        CommentPostPO commentPostPO = this.getMapper().map(commentPostUpdateRequest, CommentPostPO.class);
                        commentPostPO.setId(foundationService.getNewId());
                        commentPostPO.setPostTime(new Date());
                        createList.add(commentPostPO);
                        ids.add(foundationService.getNewId());
                    }
                }

                for (Long id : existIdList) {
                    if (!updateIdList.contains(id)) {
                        deleteIdList.add(id);
                    }
                }

                if (createList.size() > 0) {
                    commentPostMapper.insertBatch(createList, passport);
                }
                if (deleteIdList.size() > 0) {
                    commentPostMapper.deleteBatch(deleteIdList, passport);
                }
            } else {
                commentPostMapper.deleteBatch(existIdList, passport);
            }
            response.setIds(ids);
            return response;
        }

/**
 * 验证对象
 *
 * @param commentPost 评论表
 * @param passport    用户护照
 */

    private void checkValidate(CommentPostPO commentPost, Passport passport, BaseResponse response) {
        // TODO

    }


}
