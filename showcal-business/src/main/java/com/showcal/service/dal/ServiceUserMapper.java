/**
 * @(#)ServiceUserMapper.java  
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

import com.showcal.mobile.domain.ShowCalInfo;
import com.showcal.platform.domain.UserDetail;
import com.showcal.service.po.ServiceUserPO;
import com.showcal.service.request.ServiceHistoryUserGetRequest;
import com.showcal.service.request.ServiceUserGetListForMyRequest;
import com.showcal.service.request.ShowCalHistoryGetRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
@MyBatisRepository("ServiceServiceUserMapper")
public interface ServiceUserMapper extends ServiceUserMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") ServiceUserPO request, @Param("passport") Passport passport);

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
     * 获取当前服务的瘦咖
     *
     * @param userId
     * @return
     */
    ServiceUserPO getUserShowcal(@Param("userId") Long userId);


    /**
     * 获取历史服务的瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    List<ServiceUserPO> getHistoryShowcal(@Param("request") ShowCalHistoryGetRequest request, @Param("passport") Passport passport);

    /**
     * 获取当前瘦咖服务的用户
     *
     * @param request
     * @param passport
     * @return
     */
    List<ServiceUserPO> getShowcalServiceUsers(@Param("request") ServiceUserGetListForMyRequest request, @Param("passport") Passport passport);

    /**
     * 总记录数
     *
     * @param request
     * @param passport
     * @return
     */
    long getShowcalServiceUsersCount(@Param("request") ServiceUserGetListForMyRequest request, @Param("passport") Passport passport);

    /**
     * 获取瘦咖历史服务的用户
     *
     * @param request
     * @param passport
     * @return
     */
    List<ServiceUserPO> getshowcalHistoryService(@Param("request") ServiceHistoryUserGetRequest request, @Param("passport") Passport passport);

    /**
     * 总记录数
     *
     * @param request
     * @param passport
     * @return
     */
    long getshowcalHistoryServiceCount(@Param("request") ServiceHistoryUserGetRequest request, @Param("passport") Passport passport);

    /**
     * 查询是否有服务于我的历史瘦咖信息
     * @param userId
     * @param serviceId
     * @return
     */
    ServiceUserPO existMySelectShowCal(@Param("userId") Long userId,@Param("serviceId") Long serviceId);
    /**
     * 查询是否有服务于我的历史瘦咖信息
     * @param userId
     * @return
     */
    List<ServiceUserPO> findMyShowCal(@Param("userId") Long userId);

}
