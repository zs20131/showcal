package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV004 on 2014/10/30.
 */
public class CommentIsLikedGetResponse extends BaseResponse {

    private boolean flag;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
