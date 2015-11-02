package com.showcal.foundation.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created on 2015-05-21.
 *
 * @author 吕浩
 * @since 2.1.0
 */
public class IdGetResponse extends BaseResponse {
    /**
     * 生成的ID
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
