/**
 * @(#)SysUserPasswordManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 *
 * @author 顾志雄
 */
public interface SysUserPasswordManager {
    /**
     * 根据Id获取用户密码表,考虑安全，纯扩展表
     *
     * @param request  获取用户密码表,考虑安全，纯扩展表请求
     * @param passport 用户护照
     * @return 获取用户密码表, 考虑安全，纯扩展表应答
     */
    SysUserPasswordGetResponse get(SysUserPasswordGetRequest request, Passport passport);

    /**
     * 更新用户密码表,考虑安全，纯扩展表
     *
     * @param request  更新用户密码表,考虑安全，纯扩展表请求
     * @param passport 用户护照
     * @return 更新用户密码表, 考虑安全，纯扩展表应答
     */
    SysUserPasswordUpdateResponse update(LoginPasswordModifyRequest request, Passport passport);

    /**
     * 更新用户密码表,考虑安全，纯扩展表-更新操作附加检验原始密码正确性
     *
     * @param request  更新用户密码表,考虑安全，纯扩展表请求
     * @param passport 用户护照
     * @return 更新用户密码表, 考虑安全，纯扩展表应答
     */
    SysUserPasswordUpdateResponse updateCheck(LoginPasswordModifyRequest request, Passport passport);


    /**
     * 删除用户密码表,考虑安全，纯扩展表
     *
     * @param request  删除用户密码表,考虑安全，纯扩展表请求
     * @param passport 用户护照
     * @return 删除用户密码表, 考虑安全，纯扩展表应答
     */
    SysUserPasswordDeleteResponse delete(SysUserPasswordDeleteRequest request, Passport passport);

    /**
     * 创建用户密码表,考虑安全，纯扩展表
     *
     * @param request  创建用户密码表,考虑安全，纯扩展表请求
     * @param passport 用户护照
     * @return 创建用户密码表, 考虑安全，纯扩展表应答
     */
    SysUserPasswordCreateResponse createLoginPassword(SysUserPasswordCreateRequest request, Passport passport);

    /**
     * 登录
     * @param request
     * @return
     */
    public LoginResponse login(LoginRequest request);
}
