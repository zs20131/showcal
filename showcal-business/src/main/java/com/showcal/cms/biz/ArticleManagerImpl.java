/**
 * @(#)ArticleManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.cms.biz;

import com.github.rjeschke.txtmark.Processor;
import com.showcal.cms.dal.ArticleBodyMapper;
import com.showcal.cms.dal.ArticleMapper;
import com.showcal.cms.dal.ArticleStatisticsMapper;
import com.showcal.cms.domain.*;
import com.showcal.cms.po.ArticleBodyPO;
import com.showcal.cms.po.ArticlePO;
import com.showcal.cms.po.ArticleStatisticsPO;
import com.showcal.cms.request.*;
import com.showcal.cms.response.*;
import com.showcal.cms.svc.Message;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.biz.CommentPostManager;
import com.showcal.platform.biz.SysUserManager;
import com.showcal.platform.dal.CollectionMapper;
import com.showcal.platform.domain.CommentPost;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.po.CollectionPO;
import com.showcal.platform.request.CollectionCreateRequest;
import com.showcal.platform.request.CollectionFindRequest;
import com.showcal.platform.request.CommentPostFindRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.CommentPostFindResponse;
import com.showcal.platform.response.SysUserGetResponse;
import com.showcal.service.biz.ComplatintManager;
import com.showcal.service.domain.ComplaintEnum;
import com.showcal.service.domain.Complatint;
import com.showcal.service.domain.SexEnum;
import com.showcal.service.request.ComplatintDeleteRequest;
import com.showcal.service.request.ComplatintFindRequest;
import com.showcal.service.request.SelfIntroductionGetRequest;
import com.showcal.service.request.SelfIntroductionSaveRequest;
import com.showcal.service.response.ComplatintFindResponse;
import com.showcal.service.response.SelfIntroductionGetResponse;
import com.showcal.service.response.SelfIntroductionSaveResponse;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 *
 * @author 顾志雄
 */
@Transactional
@Service("CmsArticleManager")
public class ArticleManagerImpl extends BaseManagerImpl implements ArticleManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleBodyManager articleBodyManager;
    @Autowired
    private ArticleStatisticsMapper statisticsMapper;
    @Autowired
    private CommentPostManager commentPostManager;
    @Autowired
    private CategoryManager categoryManager;
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private ArticleBodyMapper articleBodyMapper;
    @Autowired
    private ComplatintManager complatintManager;
    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 根据Id获取文章
     *
     * @param request  获取文章请求
     * @param passport 用户护照
     * @return 获取文章应答
     */
    @Override
    public ArticleGetResponse get(ArticleGetRequest request, Passport passport) {
        ArticlePO entity = articleMapper.getById(request.getId(), passport);
        ArticleGetResponse response = new ArticleGetResponse();
        if (entity != null) {
            Article article = this.getMapper().map(entity, Article.class);
            ArticleBodyPO articleBody = articleBodyMapper.getById(article.getId(), passport);
            if (articleBody != null) {
                article.setContent(articleBody.getContent());
                article.setHtml(Processor.process(articleBody.getContent().replaceAll("\n", "\n\n")));
            }
            if(request.getIsMobile()) {
                if (article.getCoverId() != null) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(article.getCoverId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    article.setAvatarurl(filePathGetResponse.getUrl());
                }
                SysUserGetRequest sysUserGetRequest = new SysUserGetRequest();
                sysUserGetRequest.setId(article.getSubmitUserId());
                UserInfo userInfo = sysUserManager.get(sysUserGetRequest, passport).getSysUser();
                if (userInfo != null) {
                    article.setSubmitUserName(userInfo.getNickName());
                    if (userInfo.getAvatarId() != null && userInfo.getAvatarId().intValue() != 0) {
                        article.setUseravatarurl(userInfo.getAvatarurl());
                    } else {
                        if (userInfo.getSex() != null) {
                            if (userInfo.getSex().equals(SexEnum.FEMALE)) {
                                article.setUseravatarurl("../images/girl.png");
                            } else if (userInfo.getSex().equals(SexEnum.MALE)) {
                                article.setUseravatarurl("../images/boy.png");
                            }
                        } else {
                            article.setUseravatarurl("../images/girl.png");
                        }
                    }
                }
            }
            response.setArticle(article);
            if(request.getIsMobile()) {
                //获取统计表
                ArticleStatisticsCollectRequest articleStatisticsCollectRequest = new ArticleStatisticsCollectRequest();
                articleStatisticsCollectRequest.setArticleId(request.getId());
                articleStatisticsCollectRequest.setType(StatisticsTypeEnum.LINK);
                articleStatisticsCollectRequest.setUserId(passport.getUserId());
                articleStatisticsCollectRequest.setPageSize(0);
                List<ArticleStatisticsPO> articleStatisticses = statisticsMapper.find(articleStatisticsCollectRequest, passport);
                if (articleStatisticses.size() == 1) {
                    response.getArticle().setIsPraise(true);
                }
                CollectionFindRequest collectionFindRequest = new CollectionFindRequest();
                collectionFindRequest.setObjectId(request.getId());
                collectionFindRequest.setUserId(passport.getUserId());
                collectionFindRequest.setType(CollectionEnum.COLLECTION.name());
                collectionFindRequest.setPageSize(0);
                List<CollectionPO> collectionPOs = collectionMapper.find(collectionFindRequest, passport);
                if (collectionPOs.size() == 1) {
                    response.getArticle().setIsCollection(true);
                }
                //更新点击数
                ArticleStatisticsCollectRequest collectRequest = new ArticleStatisticsCollectRequest();
                collectRequest.setType(StatisticsTypeEnum.READ);
                collectRequest.setUserId(passport.getUserId());
                collectRequest.setArticleId(request.getId());
                collectRequest.setPageSize(0);
                List<ArticleStatisticsPO> statics = statisticsMapper.find(collectRequest, passport);
                if (statics.size() == 0) {
                    long id = foundationService.getNewId();
                    ArticleStatisticsCreateRequest articleStatisticsCreateRequest = new ArticleStatisticsCreateRequest();
                    articleStatisticsCreateRequest.setArticleId(request.getId());
                    articleStatisticsCreateRequest.setType(StatisticsTypeEnum.READ.name());
                    articleStatisticsCreateRequest.setUserId(passport.getUserId());
                    articleStatisticsCreateRequest.setUserName(passport.getUserName());
                    ArticleStatisticsPO articleStatisticsPO = this.getMapper().map(articleStatisticsCreateRequest, ArticleStatisticsPO.class);
                    articleStatisticsPO.setId(id);
                    if (1 == statisticsMapper.insert(articleStatisticsPO, passport)) {
                        article.setCountRead(article.getCountRead() + 1);
                        ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(article, ArticleUpdateRequest.class);
                        this.update(articleUpdateRequest, passport);
                    }
                }
                //查询该文章是否投诉过
                ComplatintFindRequest complatintFindRequest = new ComplatintFindRequest();
                complatintFindRequest.setSourceType(ComplaintEnum.ARITLCE.name());
                complatintFindRequest.setSourceId(request.getId());
                complatintFindRequest.setUserId(passport.getUserId());
                complatintFindRequest.setPageSize(0);
                ComplatintFindResponse complatintFindResponse = complatintManager.find(complatintFindRequest, passport);
                if (complatintFindResponse.getResult().size() == 0) {
                    response.getArticle().setIsComplaint(false);
                } else {
                    response.getArticle().setIsComplaint(true);
                }
                List<CommentPost> commentPostLsit = new ArrayList<>();
                //获取此文章下的评论
                CommentPostFindRequest commentPostFindRequest = new CommentPostFindRequest();
                commentPostFindRequest.setThreadId(request.getId());
                //commentPostFindRequest.setParentId(request.getId());
                commentPostFindRequest.setPageSize(0);
                CommentPostFindResponse commentPostFindResponse = commentPostManager.find(commentPostFindRequest, passport);
                if (commentPostFindResponse.getResult().size() > 0) {
                    response.getArticle().setCommentPost(commentPostFindResponse.getResult());
                    response.getArticle().setCountComment(commentPostFindResponse.getResult().size());
                }
            }
        } else

        {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }

        return response;
    }


    /**
     * 模糊查询文章
     *
     * @param request  模糊查询文章请求
     * @param passport 用户护照
     * @return 模糊查询文章应答
     */
    @Override
    public ArticleSearchResponse search(ArticleSearchRequest request, Passport passport) {
        ArticleSearchResponse response = new ArticleSearchResponse();
        List<Article> modelList = new ArrayList<>();
        Long count = articleMapper.searchCount(request, passport);

        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }

            //通过关键字查询出用户集合
            List<ArticlePO> entityList = articleMapper.search(request, passport);

            for (ArticlePO entity : entityList) {
                Article article = this.getMapper().map(entity, Article.class);
                modelList.add(article);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询文章
     *
     * @param request  高级查询文章请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public ArticleFindResponse find(ArticleFindRequest request, Passport passport) {

        ArticleFindResponse response = new ArticleFindResponse();
        List<Article> modelList = new ArrayList<>();
        Long count = articleMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<ArticlePO> entityList = articleMapper.find(request, passport);
            for (ArticlePO entity : entityList) {
                Article article = this.getMapper().map(entity, Article.class);
                if (article.getCoverId() != null) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(article.getCoverId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    article.setAvatarurl(filePathGetResponse.getUrl());
                }
                ArticleBodyPO articleBody = articleBodyMapper.getById(article.getId(), passport);
                if (articleBody != null) {
                    article.setContent(articleBody.getContent());
                }
                SysUserGetRequest sysUserGetRequest = new SysUserGetRequest();
                sysUserGetRequest.setId(article.getSubmitUserId());
                UserInfo userInfo = sysUserManager.get(sysUserGetRequest, passport).getSysUser();
                if (userInfo != null) {
                    article.setSubmitUserName(userInfo.getNickName());
                    if (userInfo.getAvatarId() != null && userInfo.getAvatarId().intValue() != 0) {
                        article.setUseravatarurl(userInfo.getAvatarurl());
                    } else {
                        if (userInfo.getSex() != null) {
                            if (userInfo.getSex().equals(SexEnum.FEMALE)) {
                                article.setUseravatarurl("../images/girl.png");
                            } else if (userInfo.getSex().equals(SexEnum.MALE)) {
                                article.setUseravatarurl("../images/boy.png");
                            }
                        } else {
                            article.setUseravatarurl("../images/girl.png");
                        }
                    }

                }
                //获取此文章下的评论
                CommentPostFindRequest commentPostFindRequest = new CommentPostFindRequest();
                commentPostFindRequest.setThreadId(article.getId());
                //commentPostFindRequest.setParentId(request.getId());
                commentPostFindRequest.setPageSize(0);
                CommentPostFindResponse commentPostFindResponse = commentPostManager.find(commentPostFindRequest, passport);

                article.setCommentPost(commentPostFindResponse.getResult());
                //获取统计表
                ArticleStatisticsCollectRequest articleStatisticsCollectRequest = new ArticleStatisticsCollectRequest();
                articleStatisticsCollectRequest.setArticleId(entity.getId());
                articleStatisticsCollectRequest.setType(StatisticsTypeEnum.LINK);
                articleStatisticsCollectRequest.setUserId(passport.getUserId());
                articleStatisticsCollectRequest.setPageSize(0);
                List<ArticleStatisticsPO> articleStatisticses = statisticsMapper.find(articleStatisticsCollectRequest, passport);
                if (articleStatisticses.size() == 1) {
                    article.setIsPraise(true);
                }
                CollectionFindRequest collectionFindRequest = new CollectionFindRequest();
                collectionFindRequest.setObjectId(entity.getId());
                collectionFindRequest.setUserId(passport.getUserId());
                collectionFindRequest.setType(CollectionEnum.COLLECTION.name());
                collectionFindRequest.setPageSize(0);
                List<CollectionPO> collectionPOs = collectionMapper.find(collectionFindRequest, passport);
                if (collectionPOs.size() == 1) {
                    article.setIsCollection(true);
                }
                //是否是成功案例
                if (article.getCategoryId() != null) {
                    if (article.getCategoryId().equals(CategoryEnum.SUCCESS_CASE.name())) {
                        article.setIsSuccess(true);

                    } else {
                        article.setIsSuccess(false);
                    }
                }
                modelList.add(article);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    @Override
    public ArticleGetAllListResponse getAllList(ArticleGetAllListRequest request, Passport passport) {
        return null;
    }


    /**
     * 创建文章
     *
     * @param request  创建文章请求
     * @param passport 用户护照
     * @return 创建文章应答
     */
    @Override
    public ArticleCreateResponse create(ArticleCreateRequest request, Passport passport) {
        ArticleCreateResponse response = new ArticleCreateResponse();
        ArticlePO entity = this.getMapper().map(request, ArticlePO.class);
        long id = foundationService.getNewId();
        entity.setCategoryId(request.getCategoryId());
        SysUserGetRequest sysUserGetRequest = new SysUserGetRequest();
        sysUserGetRequest.setId(passport.getUserId());
        SysUserGetResponse sysUserGetResponse = sysUserManager.get(sysUserGetRequest, passport);
        SysUser sysUser = sysUserGetResponse.getSysUser();
        if (sysUser != null) {
            if (sysUser.getIsBanned() != null) {
                if (!sysUser.getIsActive()) {
                    response.addError(ErrorType.EXPECTATION_NULL, "你已被封锁，禁止发帖");
                    return response;
                }
                if (sysUser.getIsBanned()) {
                    if (sysUser.getBannedTime().getTime() > new Date().getTime()) {
                        response.addError(ErrorType.EXPECTATION_NULL, "你已被禁言，禁止发帖");
                        return response;
                    }
                }
            }
        }

        entity.setId(id);
        entity.setIsSubmit(true);
        if (request.getIsMobile()) {
            entity.setIsApproved(true);
            entity.setApproveTime(new Date());
            entity.setApproveUserId(passport.getUserId());
            entity.setApproveUserName(passport.getUserName());
        } else {
            if (request.getCategoryId().equals(CategoryEnum.INTRODUCTION.name())) {
                entity.setIsApproved(null);
            } else {
                entity.setIsApproved(false);
            }
        }
        entity.setAuthorName(passport.getUserName());
        entity.setSubmitTime(new Date());
        entity.setSubmitUserName(passport.getUserName());
        entity.setSubmitUserId(passport.getUserId());
    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);
        if (1 == articleMapper.insert(entity, passport)) {
            response.setId(id);
            ArticleBodyCreateRequest articleBodyCreateRequest = new ArticleBodyCreateRequest();
            articleBodyCreateRequest.setId(id);
            articleBodyCreateRequest.setContent(request.getContent());
            articleBodyManager.create(articleBodyCreateRequest, passport);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新文章
     *
     * @param request  更新文章请求
     * @param passport 用户护照
     * @return 更新文章应答
     */
    @Override
    public ArticleUpdateResponse update(ArticleUpdateRequest request, Passport passport) {
        ArticlePO entity = this.getMapper().map(request, ArticlePO.class);

        ArticleUpdateResponse response = new ArticleUpdateResponse();
        Long result = articleMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        //更新文章内容
        if (request.getContent() != null) {
            ArticleBodyPO articleBodyPO = articleBodyMapper.getById(request.getId(), passport);
            articleBodyPO.setContent(request.getContent());
            if (1 != articleBodyMapper.update(articleBodyPO, passport)) {
                response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
                return response;
            }
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除文章
     *
     * @param request  删除文章请求
     * @param passport 用户护照
     * @return 删除文章应答
     */
    @Override
    public ArticleDeleteResponse delete(ArticleDeleteRequest request, Passport passport) {
        ArticleDeleteResponse response = new ArticleDeleteResponse();
        Long result = articleMapper.delete(request.getId(), passport);
        response.setResult(result);
        //删除举报
        ComplatintFindRequest complatintFindRequest = new ComplatintFindRequest();
        complatintFindRequest.setSourceId(request.getId());
        ComplatintFindResponse complatintFindResponse = complatintManager.find(complatintFindRequest, passport);
        for (Complatint complatint : complatintFindResponse.getResult()) {
            ComplatintDeleteRequest complatintDeleteRequest = new ComplatintDeleteRequest();
            complatintDeleteRequest.setId(complatint.getId());
            complatintManager.delete(complatintDeleteRequest, passport);
        }
        //删除点赞，点击，评论
        ArticleStatisticsCollectRequest articleStatisticsCollectRequest = new ArticleStatisticsCollectRequest();
        articleStatisticsCollectRequest.setArticleId(request.getId());
        List<ArticleStatisticsPO> articleStatisticsPOs = statisticsMapper.find(articleStatisticsCollectRequest, passport);
        for (ArticleStatisticsPO articleStatisticsPO : articleStatisticsPOs) {
            statisticsMapper.delete(articleStatisticsPO.getId(), passport);
        }
        //删除收藏
        CollectionFindRequest collectionFindRequest = new CollectionFindRequest();
        collectionFindRequest.setObjectId(request.getId());
        List<CollectionPO> collectionPOs = collectionMapper.find(collectionFindRequest, passport);
        for (CollectionPO collectionPO : collectionPOs) {
            collectionMapper.delete(collectionPO.getId(), passport);
        }
        return response;
    }

    @Override
    public ArticleGetAllListByUserResponse getAllListByUser(ArticleGetAllListByUserRequest request, Passport passport) {
        return null;
    }

    /**
     * 审核文章
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ArticleApproveResponse approve(ArticleApproveRequest request, Passport passport) {
        ArticleApproveResponse articleApproveResponse = new ArticleApproveResponse();
        ArticlePO articlePO = articleMapper.getById(request.getId(), passport);
        if (articlePO != null) {
            articlePO.setApproveResult(ApproveResultEnum.AGREE.name());
            articlePO.setApproveTime(new Date());
            articlePO.setIsApproved(true);
            articlePO.setApproveUserName(passport.getUserName());
            articlePO.setApproveUserId(passport.getUserId());
            ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(articlePO, ArticleUpdateRequest.class);
            ArticleUpdateResponse articleUpdateResponse = this.update(articleUpdateRequest, passport);
            articleApproveResponse.setResult(articleUpdateResponse.getResult());
        }
        return articleApproveResponse;
    }

    /**
     * 取消文章发布
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ArticleCancelResponse cancel(ArticleCancelRequest request, Passport passport) {
        ArticleCancelResponse articleCancelResponse = new ArticleCancelResponse();
        ArticlePO articlePO = articleMapper.getById(request.getId(), passport);
        if (articlePO != null) {
            articlePO.setApproveTime(null);
            articlePO.setIsApproved(false);
            articlePO.setApproveResult(ApproveResultEnum.DISAGREE.name());
            ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(articlePO, ArticleUpdateRequest.class);
            ArticleUpdateResponse articleUpdateResponse = this.update(articleUpdateRequest, passport);
            articleCancelResponse.setResult(articleUpdateResponse.getResult());
        }
        return articleCancelResponse;
    }

    /**
     * 改变文章排序权重
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ArticleChangeOrderResponse changeOrder(ArticleChangeOrderRequest request, Passport passport) {
        ArticleChangeOrderResponse articleChangeOrderResponse = new ArticleChangeOrderResponse();
        ArticleGetRequest articleGetRequest = new ArticleGetRequest();
        articleGetRequest.setId(request.getId());
        ArticleGetResponse articleGetResponse = this.get(articleGetRequest, passport);
        Article article = articleGetResponse.getArticle();
        if (article != null) {
            article.setWeight(request.getWeight());
            ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(articleGetResponse.getArticle(), ArticleUpdateRequest.class);
            this.update(articleUpdateRequest, passport);
        }
        return articleChangeOrderResponse;
    }

    /**
     * 收集文章统计
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ArticleStatisticsCollectResponse collectStatistics(ArticleStatisticsCollectRequest request, Passport passport) {
        return null;
    }

    @Override
    public ArticlePraiseResponse clickPraise(ArticlePraiseRequest request, Passport passport) {
        ArticlePraiseResponse response = new ArticlePraiseResponse();
        ArticleStatisticsCollectRequest articleStatisticsCollectRequest = new ArticleStatisticsCollectRequest();
        articleStatisticsCollectRequest.setArticleId(request.getId());
        articleStatisticsCollectRequest.setUserId(passport.getUserId());
        articleStatisticsCollectRequest.setType(StatisticsTypeEnum.LINK);
        articleStatisticsCollectRequest.setPageSize(0);
        List<ArticleStatisticsPO> articleStatisticses = statisticsMapper.find(articleStatisticsCollectRequest, passport);
        if (articleStatisticses.size() == 1) {
            if (1 == statisticsMapper.delete(articleStatisticses.get(0).getId(), passport)) {
                response.setSuccess(false);
                ArticlePO articlePO = articleMapper.getById(request.getId(), passport);
                if (articlePO != null) {
                    if (articlePO.getCountLink() == null) {
                        articlePO.setCountLink(0);
                    }
                    articlePO.setCountLink(articlePO.getCountLink() - 1);
                    ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(articlePO, ArticleUpdateRequest.class);
                    this.update(articleUpdateRequest, passport);
                }
            } else {
                response.addError(ErrorType.BUSINESS_ERROR, "取消赞失败！");
                return response;
            }
        } else if (articleStatisticses.size() == 0) {
            long id = foundationService.getNewId();
            ArticleStatisticsCreateRequest articleStatisticsCreateRequest = new ArticleStatisticsCreateRequest();
            articleStatisticsCreateRequest.setArticleId(request.getId());
            articleStatisticsCreateRequest.setType(StatisticsTypeEnum.LINK.name());
            articleStatisticsCreateRequest.setUserId(passport.getUserId());
            articleStatisticsCreateRequest.setUserName(passport.getUserName());
            ArticleStatisticsPO articleStatisticsPO = this.getMapper().map(articleStatisticsCreateRequest, ArticleStatisticsPO.class);
            articleStatisticsPO.setId(id);
            if (1 == statisticsMapper.insert(articleStatisticsPO, passport)) {
                response.setSuccess(true);
                ArticlePO articlePO = articleMapper.getById(request.getId(), passport);
                if (articlePO != null) {
                    if (articlePO.getCountLink() == null) {
                        articlePO.setCountLink(0);
                    }
                    articlePO.setCountLink(articlePO.getCountLink() + 1);
                    ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(articlePO, ArticleUpdateRequest.class);
                    this.update(articleUpdateRequest, passport);
                }
            } else {
                response.addError(ErrorType.BUSINESS_ERROR, "赞失败！");
                return response;
            }
        } else {
            for(ArticleStatisticsPO statisticsPO :articleStatisticses){
                statisticsMapper.delete(statisticsPO.getId(),passport);
            }
            response.addError(ErrorType.BUSINESS_ERROR, "网络错误重新点击！");
            return response;
        }

        return response;
    }

    @Override
    public ArticleCollectionResponse clickCollection(ArticleCollectionRequest request, Passport passport) {
        ArticleCollectionResponse response = new ArticleCollectionResponse();
        CollectionFindRequest collectionFindRequest = new CollectionFindRequest();
        collectionFindRequest.setObjectId(request.getId());
        collectionFindRequest.setUserId(passport.getUserId());
        collectionFindRequest.setPageSize(0);
        collectionFindRequest.setType(CollectionEnum.COLLECTION.name());
        List<CollectionPO> collectionPOs = collectionMapper.find(collectionFindRequest, passport);
        if (collectionPOs.size() == 1) {
            if (1 == collectionMapper.delete(collectionPOs.get(0).getId(), passport)) {
                response.setSuccess(false);
                ArticlePO articlePO = articleMapper.getById(request.getId(), passport);
                if (articlePO != null) {
                    articlePO.setCountConnection(articlePO.getCountConnection() - 1);
                    ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(articlePO, ArticleUpdateRequest.class);
                    this.update(articleUpdateRequest, passport);
                }
            } else {
                response.addError(ErrorType.BUSINESS_ERROR, "取消收藏失败！");
                return response;
            }
        } else if (collectionPOs.size() == 0) {
            long id = foundationService.getNewId();
            CollectionCreateRequest collectionCreateRequest = new CollectionCreateRequest();
            collectionCreateRequest.setObjectId(request.getId());
            collectionCreateRequest.setUserId(passport.getUserId());
            collectionCreateRequest.setObjectType(CollectionEnum.COLLECTION.name());
            CollectionPO collectionPO = this.getMapper().map(collectionCreateRequest, CollectionPO.class);
            collectionPO.setId(id);
            if (1 == collectionMapper.insert(collectionPO, passport)) {
                ArticlePO articlePO = articleMapper.getById(request.getId(), passport);
                if (articlePO != null) {
                    articlePO.setCountConnection(articlePO.getCountConnection() + 1);
                    ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(articlePO, ArticleUpdateRequest.class);
                    this.update(articleUpdateRequest, passport);
                }
            }
            response.setSuccess(true);
        } else {
            for(CollectionPO collectionPO :collectionPOs){
                collectionMapper.delete(collectionPO.getId(),passport);
            }
            response.addError(ErrorType.BUSINESS_ERROR, "网络错误重新点击！");
            return response;
        }
        return response;
    }

    @Override
    public ArticleSuccessUpdateResponse successArticle(ArticleSuccessUpdateRequest request, Passport passport) {
        ArticleSuccessUpdateResponse response = new ArticleSuccessUpdateResponse();
        ArticlePO article = articleMapper.getById(request.getId(), passport);
        article.setCategoryId(CategoryEnum.SUCCESS_CASE.name());
        ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(article, ArticleUpdateRequest.class);
        ArticleUpdateResponse articleUpdateResponse = this.update(articleUpdateRequest, passport);
        response.setResult(articleUpdateResponse.getResult());

        return response;
    }

    @Override
    public ArticleUnsuccessUpdateResponse unsuccessArticle(ArticleUnsuccessUpdateRequest request, Passport passport) {
        ArticleUnsuccessUpdateResponse response = new ArticleUnsuccessUpdateResponse();
        ArticlePO article = articleMapper.getById(request.getId(), passport);
        article.setCategoryId(CategoryEnum.ARTICLE.name());
        ArticleUpdateRequest articleUpdateRequest = this.getMapper().map(article, ArticleUpdateRequest.class);
        ArticleUpdateResponse articleUpdateResponse = this.update(articleUpdateRequest, passport);
        response.setResult(articleUpdateResponse.getResult());

        return response;
    }

    /**
     * 保存自我介绍
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public SelfIntroductionSaveResponse saveSelfIntroduction(SelfIntroductionSaveRequest request, Passport passport) {
        SelfIntroductionSaveResponse response = new SelfIntroductionSaveResponse();
        if (request.getId() != null) {
            ArticlePO articlePO = articleMapper.getById(request.getId(), passport);
            if (articlePO == null) {
                response.setResult(1L);
                return response;
            }
            articlePO.setCoverId(request.getCoverId());
            articleMapper.update(articlePO, passport);
            if (request.getContent() != null && !"".equals(request.getContent())) {
                ArticleBodyPO articleBodyPO = articleBodyMapper.getById(request.getId(), passport);
                if (articleBodyPO == null) {
                    articleBodyPO = new ArticleBodyPO();
                    articleBodyPO.setId(request.getId());
                    articleBodyPO.setContent(request.getContent());
                    articleBodyMapper.insert(articleBodyPO, passport);
                } else {
                    articleBodyPO.setContent(request.getContent());
                    articleBodyMapper.update(articleBodyPO, passport);
                }
            }
            response.setResult(1L);
            return response;
        } else {
            ArticlePO articlePO = new ArticlePO();
            Long id = foundationService.getNewId();
            articlePO.setId(id);
            articlePO.setCoverId(request.getCoverId());
            articlePO.setIsSubmit(true);
            articlePO.setSubmitUserId(passport.getUserId());
            articlePO.setSubmitTime(new Date());
            articlePO.setSubmitUserName(passport.getUserName());
            articlePO.setIsApproved(true);
            articlePO.setApproveUserId(passport.getUserId());
            articlePO.setApproveTime(new Date());
            articlePO.setApproveUserName(passport.getUserName());
            articlePO.setApproveResult("AGREE");
            CategoryFindRequest categoryFindRequest = new CategoryFindRequest();
            categoryFindRequest.setPageSize(0);
            categoryFindRequest.setName(CategoryEnum.INTRODUCTION.toString());
            CategoryFindResponse categoryFindResponse = categoryManager.find(categoryFindRequest, passport);
            if (categoryFindResponse.getResult().size() > 0) {
                articlePO.setCategoryId(categoryFindResponse.getResult().get(0).getId().toString());
            }
            Long result = articleMapper.insert(articlePO, passport);
            if (result > 0) {
                ArticleBodyPO articleBodyPO = new ArticleBodyPO();
                articleBodyPO.setId(request.getId());
                articleBodyPO.setContent(request.getContent());
                articleBodyMapper.insert(articleBodyPO, passport);
            }
            response.setResult(1L);
            return response;
        }
    }

    /**
     * 获取自我介绍
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public SelfIntroductionGetResponse getSelfIntroduction(SelfIntroductionGetRequest request, Passport passport) {
        ArticleFindRequest findRequest = new ArticleFindRequest();
        findRequest.setCategoryId(CategoryEnum.INTRODUCTION.name());
        if (request.getUserId() == null) {
            findRequest.setSubmitUserId(passport.getUserId());
        } else {
            findRequest.setSubmitUserId(request.getUserId());
        }
        findRequest.setPageSize(1);
        findRequest.setPageNumber(0);
        List<ArticlePO> articlePOs = articleMapper.find(findRequest, passport);
        SelfIntroductionGetResponse response = new SelfIntroductionGetResponse();
        if (articlePOs != null && !articlePOs.isEmpty()) {
            response.setId(articlePOs.get(0).getId());
            response.setCoverId(articlePOs.get(0).getCoverId());
        }
        ArticleBodyPO articleBodyPO = articleBodyMapper.getById(response.getId(), passport);
        if (articleBodyPO != null) {
            response.setContent(Processor.process(articleBodyPO.getContent().replaceAll("\n", "\n\n")));
        }
        return response;
    }

    /**
     * 获取我的收藏
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ArticleCollectionGetResponse getMyCollection(ArticleCollectionGetRequest request, Passport passport) {
        ArticleCollectionGetResponse response = new ArticleCollectionGetResponse();
        CollectionFindRequest collectionFindRequest = new CollectionFindRequest();
        collectionFindRequest.setUserId(request.getUserId());
        collectionFindRequest.setType(CollectionEnum.COLLECTION.toString());
        Long count = collectionMapper.findCount(collectionFindRequest, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<CollectionPO> collectionPOs = collectionMapper.find(collectionFindRequest, passport);
            List<Long> ids = new ArrayList<>();
            for (CollectionPO collectionPO : collectionPOs) {
                ids.add(collectionPO.getObjectId());
            }
            ArticleFindRequest findRequest = new ArticleFindRequest();
            findRequest.setIds(ids);
            findRequest.setPageNumber(request.getPageNumber());
            findRequest.setPageSize(request.getPageSize());
            ArticleFindResponse findResponse = this.find(findRequest, passport);
            List<Article> articles = findResponse.getResult();
            response.setResult(articles);
            response.setTotalCount(findResponse.getTotalCount());
        }
        return response;
    }

    /**
     * 验证对象
     *
     * @param article  文章
     * @param passport 用户护照
     */
    private void checkValidate(ArticlePO article, Passport passport, BaseResponse response) {
        // TODO

    }


}
