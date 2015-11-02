/**
 * @(#)SequenceByDateMapper.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.foundation.dal;

import com.showcal.foundation.po.SequenceByDatePO;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 沈振家 on 2015-02-02 11:46:02.
 * @author 沈振家
 */
@MyBatisRepository("FoundationSequenceByDateMapper")
public interface SequenceByDateMapper extends SequenceByDateMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") SequenceByDatePO request, @Param("passport") Passport passport);


    /**
     * 按序列号ID查询
     * @param seqId
     * @param passport
     * @return
     */
    SequenceByDatePO getBySeqId(@Param("id") Long seqId, @Param("passport") Passport passport);

}
