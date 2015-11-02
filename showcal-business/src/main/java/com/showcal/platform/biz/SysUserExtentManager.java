/**
 * @(#)SysUserExtentManager.java
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

import com.xiniunet.framework.security.Passport;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 * @author 顾志雄
 */
public interface SysUserExtentManager {
    /**
     * 根据Id获取用户扩展
     *
     * @param request 获取用户扩展请求
     * @param passport 用户护照
     * @return 获取用户扩展应答
     */
    SysUserExtentGetResponse get(SysUserExtentGetRequest request, Passport passport);


    /**
     * 模糊查询用户扩展
     *
     * @param request 模糊查询用户扩展请求
     * @param passport 用户护照
     * @return 模糊查询用户扩展应答
     */
    SysUserExtentSearchResponse search(SysUserExtentSearchRequest request, Passport passport);



    /**
     * 创建用户扩展
     *
     * @param request 创建用户扩展请求
     * @param passport 用户护照
     * @return 创建用户扩展应答
     */
    SysUserExtentCreateResponse create(SysUserExtentCreateRequest request, Passport passport);


    /**
     * 更新用户扩展
     *
     * @param request 更新用户扩展请求
     * @param passport 用户护照
     * @return 更新用户扩展应答
     */
    SysUserExtentUpdateResponse update(SysUserExtentUpdateRequest request, Passport passport);


    /**
     * 删除用户扩展
     *
     * @param request 删除用户扩展请求
     * @param passport 用户护照
     * @return 删除用户扩展应答
     */
    SysUserExtentDeleteResponse delete(SysUserExtentDeleteRequest request, Passport passport);

    /**
     * 根据IDs 获取用户扩展信息
     * @param request
     * @param passport
     * @return
     */
    SysUserExtentGetByIdsResponse  getUserExtentByIds(SysUserExtentGetByIdsRequest request,Passport passport);
}
