/**
 * @(#)AttachmentMapper.java
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
package com.showcal.foundation.dal;

import com.showcal.foundation.po.AttachmentSO;
import com.showcal.foundation.po.AttachmentWithFilePO;
import com.showcal.foundation.request.AttachmentUpdateBusinessRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 * @author 沈振家
 */
@MyBatisRepository
public interface AttachmentMapper extends AttachmentMapperAuto {

    /**
     * 查询附件列表
     *
     * @param attachmentSO 附件表的查询条件
     * @param passport 用户护照
     * @return 附件列表
     */
    List<AttachmentWithFilePO> getAttachmentListWithFile(@Param("attachment") AttachmentSO attachmentSO, @Param("passport") Passport passport);

	/**
	 * 更新一批附件的Business编号
	 * @param request       BusinessID & 附件编号列表
	 * @param passport      护照信息
	 * @return              更新的条数
	 */
	Long updateBusiness(@Param("request") AttachmentUpdateBusinessRequest request, @Param("passport") Passport passport);

}
