/**
 * @(#)SysUserCurveManager.java
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
package com.showcal.platform.biz;

import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 *
 * @author 顾志雄
 */
public interface SysUserCurveManager {
    /**
     * 根据Id获取用户身体变化曲线
     *
     * @param request  获取用户身体变化曲线请求
     * @param passport 用户护照
     * @return 获取用户身体变化曲线应答
     */
    SysUserCurveGetResponse get(SysUserCurveGetRequest request, Passport passport);


    /**
     * 模糊查询用户身体变化曲线
     *
     * @param request  模糊查询用户身体变化曲线请求
     * @param passport 用户护照
     * @return 模糊查询用户身体变化曲线应答
     */
    SysUserCurveSearchResponse search(SysUserCurveSearchRequest request, Passport passport);

    /**
     * 高级查询用户身体变化曲线
     *
     * @param request  高级查询用户身体变化曲线请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SysUserCurveFindResponse find(SysUserCurveFindRequest request, Passport passport);

    /**
     * 获取所有用户身体变化曲线列表
     *
     * @param request  获取所有用户身体变化曲线列表请求
     * @param passport 用户护照
     * @return 获取所有用户身体变化曲线列表应答
     */
    SysUserCurveGetAllListByUserResponse getAllList(SysUserCurveGetAllListByUserRequest request, Passport passport);


    /**
     * 创建用户身体变化曲线
     *
     * @param request  创建用户身体变化曲线请求
     * @param passport 用户护照
     * @return 创建用户身体变化曲线应答
     */
    SysUserCurveCreateResponse create(SysUserCurveCreateRequest request, Passport passport);


    /**
     * 更新用户身体变化曲线
     *
     * @param request  更新用户身体变化曲线请求
     * @param passport 用户护照
     * @return 更新用户身体变化曲线应答
     */
    SysUserCurveUpdateResponse update(SysUserCurveUpdateRequest request, Passport passport);


    /**
     * 删除用户身体变化曲线
     *
     * @param request  删除用户身体变化曲线请求
     * @param passport 用户护照
     * @return 删除用户身体变化曲线应答
     */
    SysUserCurveDeleteResponse delete(SysUserCurveDeleteRequest request, Passport passport);

    /**
     *  根据条件删除用户身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveDeleteByConditionResponse deleteByCondition(SysUserCurveDeleteByConditionRequest request, Passport passport);

    /**
     * 获取我个人所有的身体变化曲线
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetAllListByUserResponse getAllListByUser(SysUserCurveGetAllListByUserRequest request, Passport passport);

    /**
     *  获取我的年身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetYearListByUserResponse getYearListByUser(SysUserCurveGetYearListByUserRequest request, Passport passport);

    /**
     *  获取我的月身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetMonthListByUserResponse getMonthListByUser(SysUserCurveGetMonthListByUserRequest request, Passport passport);

    /**
     *  获取我的周身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetWeekListByUserResponse getWeekListByUser(SysUserCurveGetWeekListByUserRequest request, Passport passport);
}
