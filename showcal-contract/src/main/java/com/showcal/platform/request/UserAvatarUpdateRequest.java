package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseRequest;

/**
 * Created on 2014/9/18.
 *
 * @author 吕浩
 * @version v1.0.0.0
 */
public class UserAvatarUpdateRequest extends BaseRequest {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户头像图片的ID
     */
    private Long avatarId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }
}
