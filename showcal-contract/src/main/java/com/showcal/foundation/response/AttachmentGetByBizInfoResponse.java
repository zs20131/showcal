package com.showcal.foundation.response;

import com.showcal.foundation.domain.Attachment;
import com.xiniunet.framework.base.BaseResponse;

import java.util.List;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class AttachmentGetByBizInfoResponse extends BaseResponse {

    /**
     * 附件列表
     */
    List<Attachment> attachmentList;

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }
}
