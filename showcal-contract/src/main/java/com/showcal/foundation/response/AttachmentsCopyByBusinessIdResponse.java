package com.showcal.foundation.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created on 2015-05-06.
 *
 * @author 吕浩
 * @since 2.1.0
 */
public class AttachmentsCopyByBusinessIdResponse extends BaseResponse {
    /**
     * 复制的结果
     */
    private Long result;

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}
