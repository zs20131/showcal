/**
 * @(#)WelcomeMapper.java  
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
package com.showcal.service.dal;



import com.showcal.service.po.WelcomePO;
import com.showcal.service.request.WelcomeFindRequest;
import com.showcal.service.request.WelcomeGetAllListRequest;
import com.showcal.service.request.WelcomeGetForMyRequest;
import com.showcal.service.request.WelcomeSearchRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-30 18:20:47.
 * @author 顾志雄
 */
@MyBatisRepository("ServiceWelcomeMapper")
public interface WelcomeMapper extends WelcomeMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request")WelcomePO request , @Param("passport")Passport passport);

    /**
     * 获取所有对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<WelcomePO> getAllList(@Param("request")WelcomeGetAllListRequest request,@Param("passport")Passport passport);

    /**
     * 获取我的瘦咖的对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<WelcomePO> getMyShowCalWelcome(@Param("request")WelcomeGetForMyRequest request,@Param("passport")Passport passport);


    /**
     * 模糊搜索对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<WelcomePO> search(@Param("request")WelcomeSearchRequest request, @Param("passport")Passport passport);

    /**
     * 模糊搜索对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long searchCount(@Param("request")WelcomeSearchRequest request,@Param("passport")Passport passport);


    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<WelcomePO> find(@Param("request")WelcomeFindRequest request, @Param("passport")Passport passport);

    /**
     * 高级查询对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request")WelcomeFindRequest request, @Param("passport")Passport passport);

    
    /**
     * 按主键ID作废记录
     *
     * @param id 主键
     * @return 受影响的记录条数
     */
    long inactive(@Param("id")Long id , @Param("passport")Passport passport);

    /**
     * 按主键ID激活记录
     *
     * @param id 主键
     * @return 受影响的记录条数
     */
    long active(@Param("id")Long id , @Param("passport")Passport passport);
    



}
