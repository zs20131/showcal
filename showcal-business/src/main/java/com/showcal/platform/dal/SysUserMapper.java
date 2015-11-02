/**
 * @(#)SysUserMapper.java  
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

import com.showcal.mobile.domain.ShowCalInfo;
import com.showcal.mobile.request.ShowCalQueryRequest;
import com.showcal.mobile.response.ShowCalQueryResponse;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;
import com.showcal.platform.po.SysUserPO;
import com.showcal.platform.request.*;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
@MyBatisRepository("PlatfromSysUserMapper")
public interface SysUserMapper extends SysUserMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") SysUserPO request, @Param("passport") Passport passport);

    /**
     * 获取所有对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<SysUserPO> getAllList(@Param("request") SysUserGetAllListRequest request, @Param("passport") Passport passport);



    /**
     * 模糊搜索对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<SysUserPO> search(@Param("request") SysUserSearchRequest request, @Param("passport") Passport passport);

    /**
     * 模糊搜索对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long searchCount(@Param("request") SysUserSearchRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<SysUserPO> find(@Param("request") SysUserFindRequest request, @Param("passport") Passport passport);

    /**
     * 高级查询对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request") SysUserFindRequest request, @Param("passport") Passport passport);

    /**
     * 判断手机号码是否存在
     * @param id
     * @param mobilePhone
     * @param passport
     * @return
     */
    Long existByMobile(@Param("id")Long id, @Param("mobilePhone")String mobilePhone, @Param("passport")Passport passport);

    /**
     * 根据账号，获取用户信息
     * @param account
     * @return
     */
    SysUserPO getUserByAccount(@Param("account")String account);

    /**
     * 查询瘦咖信息
     * @param request
     * @param passport
     * @return
     */
    List<ShowCalInfo> queryShowCalInfo(@Param("request") ShowCalQueryRequest request,@Param("passport")Passport passport);

    /**
     * 查询瘦咖总记录
     * @param request
     * @param passport
     * @return
     */
    Long queryShowCalInfoCount(@Param("request")ShowCalQueryRequest request, @Param("passport")Passport passport);

    /**
     * 根据OpenId 查询用户ID
     * @param request
     * @param passport
     * @return
     */
    Long existByOpenId(@Param("request") UserExistByOpenIdRequest request, @Param("passport") Passport passport);
}
