/**
 * @(#)VerificationMapper.java
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
package com.showcal.platform.dal;

import com.showcal.platform.po.SysUserPO;
import com.showcal.platform.po.VerificationPO;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 *
 * @author 沈振家
 */
@MyBatisRepository
public interface VerificationMapper extends VerificationMapperAuto {

    /**
     * 按查询对象获取实体对象集合
     *
     * @param entity 查询对象
     * @return 实体对象集合
     */
    VerificationPO check(@Param("entity") VerificationPO entity);

    /**
     * 按查询对象获取实体对象集合
     *
     * @param entity 查询对象
     * @return 实体对象集合
     */
    VerificationPO checkLogin(@Param("entity") VerificationPO entity);

}
