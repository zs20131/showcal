/**
 * @(#)RepositoryMapper.java  
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

import com.showcal.service.response.RepositoryGetForMyResponse;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;
import com.showcal.service.po.RepositoryPO;
import com.showcal.service.request.*;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 * @author 顾志雄
 */
@MyBatisRepository("ServiceRepositoryMapper")
public interface RepositoryMapper extends RepositoryMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") RepositoryPO request, @Param("passport") Passport passport);




    /**
     * 模糊搜索对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<RepositoryPO> search(@Param("request") RepositorySearchRequest request, @Param("passport") Passport passport);

    /**
     * 模糊搜索对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long searchCount(@Param("request") RepositorySearchRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<RepositoryPO> find(@Param("request") RepositoryFindRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<RepositoryPO> getMy(@Param("request") RepositoryGetForMyRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request") RepositoryFindRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询我的对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findMyCount(@Param("request") RepositoryGetForMyRequest request, @Param("passport") Passport passport);

    /**
     * 获取系统知识库总数
     * @param request
     * @param passport
     * @return
     */
    Long findSystemCount(@Param("request") RepositorySystemGetRequest request, @Param("passport") Passport passport);

    /**
     * 获取系统知识库
     * @param request
     * @param passport
     * @return
     */
    List<RepositoryPO> findSystem(@Param("request") RepositorySystemGetRequest request,@Param("passport") Passport passport);
}
