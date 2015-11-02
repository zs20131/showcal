/**
 * @(#)SettingUserTagManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 *
 * @author 顾志雄
 */
public interface SettingUserTagManager {
    /**
     * 根据Id获取用户标签
     *
     * @param request  获取用户标签请求
     * @param passport 用户护照
     * @return 获取用户标签应答
     */
    SettingUserTagGetResponse get(SettingUserTagGetRequest request, Passport passport);


    /**
     * 高级查询用户标签
     *
     * @param request  高级查询用户标签请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SettingUserTagFindResponse find(SettingUserTagFindRequest request, Passport passport);

    /**
     * 获取所有用户标签列表
     *
     * @param request  获取所有用户标签列表请求
     * @param passport 用户护照
     * @return 获取所有用户标签列表应答
     */
    SettingUserTagGetAllListResponse getAllList(SettingUserTagGetAllListRequest request, Passport passport);


    /**
     * 创建用户标签
     *
     * @param request  创建用户标签请求
     * @param passport 用户护照
     * @return 创建用户标签应答
     */
    SettingUserTagCreateResponse create(SettingUserTagCreateRequest request, Passport passport);


    /**
     * 更新用户标签
     *
     * @param request  更新用户标签请求
     * @param passport 用户护照
     * @return 更新用户标签应答
     */
    SettingUserTagUpdateResponse update(SettingUserTagUpdateRequest request, Passport passport);


    /**
     * 删除用户标签
     *
     * @param request  删除用户标签请求
     * @param passport 用户护照
     * @return 删除用户标签应答
     */
    SettingUserTagDeleteResponse delete(SettingUserTagDeleteRequest request, Passport passport);


    /**
     * 作废用户标签
     *
     * @param request  作废用户标签请求
     * @param passport 用户护照
     * @return 作废用户标签应答
     */
    SettingUserTagInactiveResponse inactive(SettingUserTagInactiveRequest request, Passport passport);


    /**
     * 激活用户标签
     *
     * @param request  激活用户标签请求
     * @param passport 用户护照
     * @return 激活用户标签应答
     */
    SettingUserTagActiveResponse active(SettingUserTagActiveRequest request, Passport passport);

}
