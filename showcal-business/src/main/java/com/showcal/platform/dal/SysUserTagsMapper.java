/**
 * @(#)SysUserTagsMapper.java  
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

import com.showcal.platform.po.SysUserTagsPO;
import com.showcal.platform.request.SysUserTagsGetAllListByUserRequest;
import com.showcal.platform.request.SysUserTagsGetAllListRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-26 18:56:46.
 *
 * @author 顾志雄
 */
@MyBatisRepository("PlatfromSysUserTagsMapper")
public interface SysUserTagsMapper extends SysUserTagsMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") SysUserTagsPO request, @Param("passport") Passport passport);

    /**
     * 获取所有对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<SysUserTagsPO> getAllList(@Param("request") SysUserTagsGetAllListRequest request, @Param("passport") Passport passport);

    /**
     * 根据用户ID获取所有标签对象列表
     * 
     * @param request
     * @param passport
     * @return
     */
    List<SysUserTagsPO> getAllListByUser(@Param("request") SysUserTagsGetAllListByUserRequest request, @Param("passport") Passport passport);

}
