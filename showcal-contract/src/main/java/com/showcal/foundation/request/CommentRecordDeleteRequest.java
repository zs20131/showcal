package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by DEV004 on 2014/10/30.
 */
public class CommentRecordDeleteRequest extends BaseRequest {

    @NotNull
    private Long commentId;

    @NotNull
    private boolean delFollowAll;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public boolean getDelFollowAll() {
        return delFollowAll;
    }

    public void setDelFollowAll(boolean delFollowAll) {
        this.delFollowAll = delFollowAll;
    }
}
