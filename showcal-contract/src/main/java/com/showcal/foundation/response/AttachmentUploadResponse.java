package com.showcal.foundation.response;

import com.showcal.foundation.domain.Attachment;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class AttachmentUploadResponse extends BaseResponse {

    /**
     * 附件
     */
    private Attachment attachment;

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
