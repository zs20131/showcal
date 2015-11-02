package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created on 2014/9/18.
 *
 * @author 吕浩
 * @version v1.0.0.0
 */
public class UserAvatarUpdateResponse extends BaseResponse {
    /**
     * 更新的结果
     */
    private Long result;

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}
