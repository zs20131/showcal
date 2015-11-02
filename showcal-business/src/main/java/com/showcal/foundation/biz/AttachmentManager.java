/**
 * @(#)AttachmentManager.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.foundation.biz;

import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
public interface AttachmentManager {

    /**
     * 上传附件
     *
     * @param req      上传附件请求
     * @param passport 用户护照
     * @return 上传附件应答
     */
    AttachmentUploadResponse uploadAttachment(AttachmentUploadRequest req, Passport passport);

    /**
     * 根据已经存在的文件Id上传附件
     *
     * @param req      上传附件请求
     * @param passport 用户护照
     * @return 上传附件应答
     */
    AttachmentUploadByFileIdResponse uploadAttachmentByFileId(AttachmentUploadByFileIdRequest req, Passport passport);


    /**
     * 删除附件
     *
     * @param req      删除附件请求
     * @param passport 用户护照
     * @return 删除附件应答
     */
    AttachmentDeleteResponse deleteAttachment(AttachmentDeleteRequest req, Passport passport);

    /**
     * 获取附件列表
     *
     * @param req      获取附件列表请求
     * @param passport 用户护照
     * @return 附件列表应答
     */
    AttachmentGetByBizInfoResponse getAttachmentsByBizInfo(AttachmentGetByBizInfoRequest req, Passport passport);

    /**
     * 更新一批附件的Business编号
     *
     * @param request
     * @param passport
     * @return
     */
    AttachmentUpdateBusinessResponse updateBusiness(AttachmentUpdateBusinessRequest request, Passport passport);

    /**
     * 通过Business编号复制复件
     *
     * @param request  复制请求
     * @param passport 护照信息
     * @return 复制结果
     * @since 2.1.0
     */
    AttachmentsCopyByBusinessIdResponse copyByBusinessId(AttachmentCopyByBusinessIdRequest request, Passport passport);
}
