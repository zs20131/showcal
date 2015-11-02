package com.showcal.foundation.biz;


import com.showcal.foundation.domain.CommentInfo;
import com.showcal.foundation.request.*;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.CommentPostMapper;
import com.showcal.platform.po.CommentPostPO;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DEV004 on 2014/10/30.
 */
@Transactional
@Service
public class CommentManagerImpl extends BaseManagerImpl implements CommentManager {

//    @Autowired
//    private CommentThreadMapper commentThreadMapper;

    @Autowired
    private CommentPostMapper commentPostMapper;
//
//    @Autowired
//    private CommentLikeMapper commentLikeMapper;

    @Autowired
    private FoundationService foundationService;


    /**
     * 插入评论
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public CommentRecordCreateResponse insert(CommentRecordCreateRequest request, Passport passport) {

        CommentRecordCreateResponse response = new CommentRecordCreateResponse();
        CommentPostPO commentPostPO = new CommentPostPO();

//        CommentThreadPO commentThreadPOExist = commentThreadMapper.getByBusinessId(request.getBusinessId(), passport);
//        if (commentThreadPOExist == null) {
//            CommentThreadPO createCommentThreadPo = new CommentThreadPO();
//            createCommentThreadPo.setId(foundationService.getNewId());
//            createCommentThreadPo.setTenantId(passport.getTenantId());
//            createCommentThreadPo.setBusinessType(request.getBusinessType());
//            createCommentThreadPo.setBusinessId(request.getBusinessId());
//            commentThreadMapper.insert(createCommentThreadPo, passport);
//            commentPostPO.setThreadId(createCommentThreadPo.getId());
//
//        } else {
//            commentPostPO.setThreadId(commentThreadPOExist.getId());
            if (request.getParentId() != null) {
                commentPostPO.setParentId(request.getParentId());
                CommentPostPO commentPostParentPo = commentPostMapper.getById(request.getParentId(), passport);
                if(commentPostParentPo!=null){
                    if (commentPostParentPo.getRootId() == null) {
                        commentPostPO.setRootId(commentPostParentPo.getId());
                    } else {
                        commentPostPO.setRootId(commentPostParentPo.getRootId());
                    }
                }
            }
//        }
        Long id = foundationService.getNewId();
        commentPostPO.setId(id);
        commentPostPO.setContent(request.getContent());
        commentPostPO.setIsAnonymous(request.getAnonymous());
        commentPostPO.setUserId(request.getUserId());
        commentPostPO.setPostTime(new Date());
//        commentPostPO.setLikeCount(new Long("0"));
        commentPostMapper.insert(commentPostPO, passport);
        response.setId(id);

        return response;
    }

    /**
     * 删除评论（软删除）
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public CommentRecordDeleteResponse updateDeleteStatus(CommentRecordDeleteRequest request, Passport passport) {
        CommentRecordDeleteResponse response = new CommentRecordDeleteResponse();
        CommentPostPO commentPostPO = commentPostMapper.getById(request.getCommentId(), passport);
        if (commentPostPO == null) {
            response.addError(ErrorType.SYSTEM_ERROR, "评论不存在");
            return response;
        }
//        response.setFlag(commentPostMapper.updateIsDelete(true, commentPostPO.getId(), passport));

        if (request.getDelFollowAll()) {//true为删除所有
            List<Long> parentList = new ArrayList<>();
            parentList.add(commentPostPO.getId());
            getDelInfo(response, parentList, passport);
        }
        return response;

    }

    public CommentRecordDeleteResponse getDelInfo(CommentRecordDeleteResponse response, List<Long> parentList, Passport passport) {
//        List<CommentPostPO> commentPostPOList = commentPostMapper.getListByParentIds(parentList, passport);
//        if (CollectionUtils.isNotEmpty(commentPostPOList)) {
//            for (CommentPostPO commentDelPo : commentPostPOList) {
//                commentDelPo.setIsDeleted(true);
//                response.setFlag(commentPostMapper.updateIsDelete(true, commentDelPo.getId(), passport));
//                List<Long> childId = new ArrayList<>();
//                childId.add(commentDelPo.getId());
//                getDelInfo(response, childId, passport);
//            }
//        }
        return response;
    }

    /**
     * 获取所有的评价
     *
     * @param request
     * @return
     */
    public CommentRecordListGetResponse getByBusinessId(CommentRecordListGetRequest request) {
        CommentRecordListGetResponse response = new CommentRecordListGetResponse();
        List<Long> threadIdList = new ArrayList<>();
        List<CommentInfo> commentInfoList = new ArrayList<>();
//        List<CommentThreadPO> commentThreadPOList = commentThreadMapper.getByBusinessIdNoTenant(request);
//        if (commentThreadPOList == null||commentThreadPOList.size()==0) {
//            response.addError(ErrorType.SYSTEM_ERROR, "评论对象不存在");
//            return response;
//        }
//        for(CommentThreadPO po : commentThreadPOList) {
//            threadIdList.add(po.getId());
//        }
//        List<CommentPostPO> commentPostPOList = commentPostMapper.getListByThreadIds(threadIdList);
//        if (CollectionUtils.isNotEmpty(commentPostPOList)) {
//            for (CommentPostPO commentPostPO : commentPostPOList) {
//                CommentInfo commentInfo = this.getMapper().map(commentPostPO, CommentInfo.class);
//                commentInfo.setBusinessId(request.getBusinessId());
//                CommentLikePO commentLikePO = commentLikeMapper.getByPostIdNotenant(commentInfo.getId(), commentInfo.getUserId());
//                if (commentLikePO == null) {
//                    commentInfo.setUserIslike(false);
//                } else {
//                    commentInfo.setUserIslike(true);
//                }
//                commentInfoList.add(commentInfo);
//            }
//        }

        response.setResult(commentInfoList);
        response.setTotalCount((long) commentInfoList.size());
        return response;
    }

    /**
     * 对评论点赞
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public CommentRecordLikeResponse likeComment(CommentRecordLikeRequest request, Passport passport) {
        CommentRecordLikeResponse response = new CommentRecordLikeResponse();

        CommentPostPO commentPostPO = commentPostMapper.getById(request.getCommentId(), passport);
        if (commentPostPO == null) {
            response.addError(ErrorType.SYSTEM_ERROR, "评论不存在");
            return response;
        }
//        CommentLikePO commentLikePO = new CommentLikePO();
//        commentLikePO.setId(foundationService.getNewId());
//        commentLikePO.setTenantId(passport.getTenantId());
//        commentLikePO.setPostId(request.getCommentId());
//        commentLikePO.setUserId(passport.getUserId());
//        commentLikePO.setLikeTime(new Date());
//        commentLikePO.setThreadId(commentPostPO.getThreadId());
//        commentLikeMapper.insert(commentLikePO, passport);
//
//        Long likeCount = commentPostPO.getLikeCount() + 1;
//        response.setFlag(commentPostMapper.updateLikeCount(likeCount, commentLikePO.getPostId(), passport));

        return response;
    }


    /**
     * 对评论取消点赞
     *
     * @param request
     * @param passport
     * @return
     */
    public CommentRecordCancleLikeResponse cancleLikeComment(CommentRecordCancleLikeRequest request, Passport passport) {
        CommentRecordCancleLikeResponse response = new CommentRecordCancleLikeResponse();
//        CommentLikePO commentLikePO = commentLikeMapper.getByPostIdAndUserId(request.getCommentId(), passport);
//        if (commentLikePO == null) {
//            response.addError(ErrorType.SYSTEM_ERROR, "此用户没有对该评论点赞");
//            return response;
//        }
//
//        commentLikePO.setIsDeleted(false);
//        commentLikeMapper.updateIsDelete(true, commentLikePO.getId(), passport);
//
//        CommentPostPO commentPostPO = commentPostMapper.getById(commentLikePO.getPostId(), passport);
//        Long likeCount = commentPostPO.getLikeCount() - 1;
//        response.setFlag(commentPostMapper.updateLikeCount(likeCount, commentLikePO.getPostId(), passport));
        return response;

    }

    /**
     * 获取评论
     *
     * @param request
     * @param passport
     * @return
     */
    public CommentRecordGetResponse getCommentRecordById(CommentRecordGetRequest request, Passport passport) {
        CommentRecordGetResponse response = new CommentRecordGetResponse();
        CommentPostPO commentPostPO = commentPostMapper.getById(request.getPostId(), passport);
        if (commentPostPO == null) {
            response.addError(ErrorType.SYSTEM_ERROR, "评论不存在");
            return response;
        }
        CommentInfo commentInfo = this.getMapper().map(commentPostPO, CommentInfo.class);
//        CommentLikePO commentLikePO = commentLikeMapper.getByPostIdAndUserId(commentInfo.getId(), passport);
//        if (commentLikePO == null) {
//            commentInfo.setUserIslike(false);
//        } else {
//            commentInfo.setUserIslike(true);
//        }
        response.setCommentInfo(commentInfo);
        return response;
    }


}
