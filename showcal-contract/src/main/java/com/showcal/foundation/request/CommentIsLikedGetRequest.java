package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by DEV004 on 2014/10/30.
 */
public class CommentIsLikedGetRequest extends BaseRequest {

    @NotNull
    private Long commentId;

    @NotNull
    private Long userId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
