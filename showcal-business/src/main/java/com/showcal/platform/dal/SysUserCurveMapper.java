/**
 * @(#)SysUserCurveMapper.java  
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

import com.showcal.platform.domain.SysUserCurve;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;
import com.showcal.platform.po.SysUserCurvePO;
import com.showcal.platform.request.*;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
@MyBatisRepository("PlatfromSysUserCurveMapper")
public interface SysUserCurveMapper extends SysUserCurveMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") SysUserCurvePO request, @Param("passport") Passport passport);

    /**
     * 获取所有对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<SysUserCurvePO> getAllList(@Param("request") SysUserCurveGetAllListByUserRequest request, @Param("passport") Passport passport);

    /**
     *  获取用户的所有年份的曲线值
     *
     * @param request
     * @param passport
     * @return
     */
    List<SysUserCurve> getYearList(@Param("request") SysUserCurveGetYearListByUserRequest request, @Param("passport") Passport passport);

    /**
     *  获取用户的月的曲线值
     *
     * @param request
     * @param passport
     * @return
     */
    List<SysUserCurve> getMonthList(@Param("request") SysUserCurveGetMonthListByUserRequest request, @Param("passport") Passport passport);

    /**
     *  获取用户的周的曲线值
     *
     * @param request
     * @param passport
     * @return
     */
    List<SysUserCurve> getWeekList(@Param("request") SysUserCurveGetWeekListByUserRequest request, @Param("passport") Passport passport);

    /**
     * 模糊搜索对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<SysUserCurvePO> search(@Param("request") SysUserCurveSearchRequest request, @Param("passport") Passport passport);

    /**
     * 模糊搜索对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long searchCount(@Param("request") SysUserCurveSearchRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<SysUserCurvePO> find(@Param("request") SysUserCurveFindRequest request, @Param("passport") Passport passport);

    /**
     * 高级查询对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request") SysUserCurveFindRequest request, @Param("passport") Passport passport);

    /**
     * 验证记录是否存在
     *
     * @param request
     * @return
     */
    Long existRecord(@Param("request") SysUserCurvePO request);

    /**
     * 高级删除记录
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    long deleteByCondition(@Param("request") SysUserCurveDeleteByConditionRequest request, @Param("passport") Passport passport);

}
