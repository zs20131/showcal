/**
 * @(#)SysUserTagsManager.java
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

import com.showcal.platform.request.SysUserTagsCreateRequest;
import com.showcal.platform.request.SysUserTagsDeleteRequest;
import com.showcal.platform.request.SysUserTagsGetAllListRequest;
import com.showcal.platform.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-26 18:56:46.
 * @author 顾志雄
 */
public interface SysUserTagsManager {


    /**
     * 获取所有用户标签(贴标签)列表
     *
     * @param request 获取所有用户标签(贴标签)列表请求
     * @param passport 用户护照
     * @return 获取所有用户标签(贴标签)列表应答
     */
    SysUserTagsGetAllListResponse getAllList(SysUserTagsGetAllListRequest request, Passport passport);


    /**
     * 创建用户标签(贴标签)
     *
     * @param request 创建用户标签(贴标签)请求
     * @param passport 用户护照
     * @return 创建用户标签(贴标签)应答
     */
    SysUserTagsCreateResponse create(SysUserTagsCreateRequest request, Passport passport);





    /**
     * 删除用户标签(贴标签)
     *
     * @param request 删除用户标签(贴标签)请求
     * @param passport 用户护照
     * @return 删除用户标签(贴标签)应答
     */
    SysUserTagsDeleteResponse delete(SysUserTagsDeleteRequest request, Passport passport);
    

}
