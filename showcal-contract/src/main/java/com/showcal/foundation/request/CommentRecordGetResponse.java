package com.showcal.foundation.request;

import com.showcal.foundation.domain.CommentInfo;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV004 on 2014/11/6.
 */
public class CommentRecordGetResponse extends BaseResponse {

    CommentInfo commentInfo;

    public CommentInfo getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(CommentInfo commentInfo) {
        this.commentInfo = commentInfo;
    }
}
