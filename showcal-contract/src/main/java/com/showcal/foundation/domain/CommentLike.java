package com.showcal.foundation.domain;

/**
 * Created by DEV004 on 2014/11/3.
 */
public class CommentLike {
    private Long userId;

    private Long postId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
