package com.showcal.foundation.biz;

import com.showcal.foundation.request.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by DEV004 on 2014/10/30.
 */
public interface CommentManager {
    /**
     * 插入评论
     *
     * @param request
     * @param passport
     * @return
     */
    CommentRecordCreateResponse insert(CommentRecordCreateRequest request, Passport passport);

    /**
     * 删除评论（软删除）
     *
     * @param request
     * @param passport
     * @return
     */
    CommentRecordDeleteResponse updateDeleteStatus(CommentRecordDeleteRequest request, Passport passport);

    /**
     * 获取所有的评价
     *
     * @param request
     * @return
     */
    CommentRecordListGetResponse getByBusinessId(CommentRecordListGetRequest request);

    /**
     * 对评论点赞
     *
     * @param request
     * @param passport
     * @return
     */
    CommentRecordLikeResponse likeComment(CommentRecordLikeRequest request, Passport passport);

    /**
     * 对评论取消点赞
     *
     * @param request
     * @param passport
     * @return
     */
    CommentRecordCancleLikeResponse cancleLikeComment(CommentRecordCancleLikeRequest request, Passport passport);

    /**
     * 获取评论
     *
     * @param request
     * @param passport
     * @return
     */
    CommentRecordGetResponse getCommentRecordById(CommentRecordGetRequest request, Passport passport);
}
