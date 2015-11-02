/**
 * @(#)BrandMapperAuto.java
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
package com.showcal.merchandise.dal;

import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;
import com.showcal.merchandise.po.BrandPO;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 * @author 顾志雄
 */
public interface BrandMapperAuto {
    /**
     * 插入记录.
     *
     * @param brand  实体对象
     * @return 实体对象的ID
     */
    long insert(@Param("brand")BrandPO brand , @Param("passport")Passport passport);

    /**
     * 批量插入记录.
     *
     * @param list  实体对象集合
     * @return 受影响的记录条数
     */
    long insertBatch(@Param("list")List<BrandPO> list , @Param("passport")Passport passport);

    /**
     * 按主键ID删除记录
     *
     * @param id 主键
     * @return 受影响的记录条数
     */
    long delete(@Param("id")Long id , @Param("passport")Passport passport);

    /**
     * 按主键ID批量删除记录
     *
     * @param list ID集合
     */
    long deleteBatch(@Param("list")List<Long> list , @Param("passport")Passport passport);


    /**
     * 按主键ID获取实体对象
     *
     * @param id 主键
     * @return 实体对象
     */
    BrandPO getById(@Param("id")Long id,@Param("passport")Passport passport);

    /**
     * 按主键ID集合获取实体对象集合
     *
     * @param ids 主键ID集合
     * @return 实体对象集合
     */
    List<BrandPO> getListByIds(@Param("list")List<Long> ids, @Param("passport")Passport passport);

    /**
     * 按ID判断是否存在
     *
     * @param id 主键
     * @return 是否存在
     */
    long existById(@Param("id")Long id, @Param("passport")Passport passport);
    
    
}
