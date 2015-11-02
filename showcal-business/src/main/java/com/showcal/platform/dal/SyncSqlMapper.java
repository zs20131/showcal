/**
 * @(#)SyncSqlMapper.java  
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
package com.showcal.platform.dal;

import com.showcal.platform.po.SyncSqlPO;
import com.showcal.platform.request.SyncSqlIncrementRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-17 11:08:01.
 *
 * @author 顾志雄
 */
@MyBatisRepository("PlatfromSyncSqlMapper")
public interface SyncSqlMapper extends SyncSqlMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") SyncSqlPO request, @Param("passport") Passport passport);

    /**
     * 获取总数
     * @param request
     * @param passport
     * @return
     */
    Long syncIncrementCount(@Param("request")SyncSqlIncrementRequest request, @Param("passport")Passport passport);

    /**
     * 获取具体数据
     * @param request
     * @param passport
     * @return
     */
    List<SyncSqlPO> syncIncrement(@Param("request")SyncSqlIncrementRequest request, @Param("passport")Passport passport);

    /**
     * 获取最大SQL
     * @return
     */
    long getMaxVersion();
}
