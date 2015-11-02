/**
 * @(#)SettingUserTagMapper.java  
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

import com.showcal.platform.po.SettingUserTagPO;
import com.showcal.platform.request.SettingUserTagFindRequest;
import com.showcal.platform.request.SettingUserTagGetAllListRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 *
 * @author 顾志雄
 */
@MyBatisRepository("PlatfromSettingUserTagMapper")
public interface SettingUserTagMapper extends SettingUserTagMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") SettingUserTagPO request, @Param("passport") Passport passport);

    /**
     * 获取所有对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<SettingUserTagPO> getAllList(@Param("request") SettingUserTagGetAllListRequest request, @Param("passport") Passport passport);

    /**
     * 高级查询对象列表
     *
     * @param request  请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<SettingUserTagPO> find(@Param("request") SettingUserTagFindRequest request, @Param("passport") Passport passport);

    /**
     * 高级查询对象列表总数
     *
     * @param request  请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request") SettingUserTagFindRequest request, @Param("passport") Passport passport);


    /**
     * 按主键ID作废记录
     *
     * @param id 主键
     * @return 受影响的记录条数
     */
    long inactive(@Param("id") Long id, @Param("passport") Passport passport);

    /**
     * 按主键ID激活记录
     *
     * @param id 主键
     * @return 受影响的记录条数
     */
    long active(@Param("id") Long id, @Param("passport") Passport passport);

    /**
     * 高级查询对象列表
     *
     * @param request  请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<SettingUserTagPO> findByName(@Param("request") SettingUserTagFindRequest request, @Param("passport") Passport passport);
}
