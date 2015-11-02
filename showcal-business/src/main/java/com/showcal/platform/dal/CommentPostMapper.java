/**
 * @(#)CommentPostMapper.java  
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

import com.showcal.platform.request.CommentPostFindRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;
import com.showcal.platform.po.CommentPostPO;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:50.
 * @author 顾志雄
 */
@MyBatisRepository("PlatfromCommentPostMapper")
public interface CommentPostMapper extends CommentPostMapperAuto {


    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<CommentPostPO> find(@Param("request")CommentPostFindRequest request, @Param("passport")Passport passport);

    /**
     * 高级查询对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request")CommentPostFindRequest request,@Param("passport")Passport passport);

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request")CommentPostPO request , @Param("passport")Passport passport);



}
