package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class AttachmentDeleteRequest extends BaseRequest {

    /**
     * 附件ID
     */
    @NotNull
    @Min(1)
    private Long attachmentId;

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }
}
