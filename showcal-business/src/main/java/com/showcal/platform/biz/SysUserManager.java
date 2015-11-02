/**
 * @(#)SysUserManager.java
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

import com.showcal.mobile.request.ShowCalQueryRequest;
import com.showcal.mobile.request.ShowcalGetRequest;
import com.showcal.mobile.response.ShowCalGetResponse;
import com.showcal.mobile.response.ShowCalQueryResponse;
import com.xiniunet.framework.security.Passport;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
public interface SysUserManager {
    /**
     * 根据Id获取用户
     *
     * @param request 获取用户请求
     * @param passport 用户护照
     * @return 获取用户应答
     */
    SysUserGetResponse get(SysUserGetRequest request, Passport passport);


    /**
     * 模糊查询用户
     *
     * @param request 模糊查询用户请求
     * @param passport 用户护照
     * @return 模糊查询用户应答
     */
    SysUserSearchResponse search(SysUserSearchRequest request, Passport passport);

    /**
     * 高级查询用户
     *
     * @param request 高级查询用户请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SysUserFindResponse find(SysUserFindRequest request, Passport passport);

    /**
     * 获取所有用户列表
     *
     * @param request 获取所有用户列表请求
     * @param passport 用户护照
     * @return 获取所有用户列表应答
     */
    SysUserGetAllListResponse getAllList(SysUserGetAllListRequest request, Passport passport);


    /**
     * 创建用户
     *
     * @param request 创建用户请求
     * @param passport 用户护照
     * @return 创建用户应答
     */
    SysUserCreateResponse create(SysUserCreateRequest request, Passport passport);


    /**
     * 更新用户
     *
     * @param request 更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    SysUserUpdateResponse update(SysUserUpdateRequest request, Passport passport);

    /**
     * 升级用户
     *
     * @param request 更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    SysUserUpDownResponse up(SysUserUpDownRequest request, Passport passport);

    /**
     * 降级用户
     *
     * @param request 更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    SysUserUpDownResponse down(SysUserUpDownRequest request, Passport passport);

    /**
     * 禁言用户
     *
     * @param request 更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    SysUserBanResponse ban(SysUserBanRequest request, Passport passport);

    /**
     * 取消禁言用户
     *
     * @param request 更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    SysUserInbanResponse inban(SysUserInbanRequest request, Passport passport);

    /**
     * 删除用户
     *
     * @param request 删除用户请求
     * @param passport 用户护照
     * @return 删除用户应答
     */
    SysUserDeleteResponse delete(SysUserDeleteRequest request, Passport passport);

    /**
     * 上传用户头像
     * @param request
     * @param passport
     * @return
     */
    UserAvatarUpdateResponse updateAvatar(UserAvatarUpdateRequest request, Passport passport);

    /**
     * 按照用户类型搜索
     * @param request
     * @param passport
     * @return
     */
    UserSearchBySourceTypeResponse searchBySourceType(UserSearchBySourceTypeRequest request, Passport passport);

    /**
     * 暂停用户
     * @param request
     * @param passport
     * @return
     */
    UserInactiveResponse inActive(UserInactiveRequest request, Passport passport);

    /**
     * 激活用户
     * @param request
     * @param passport
     * @return
     */
    UserActiveResponse active(UserActiveRequest request, Passport passport);

    /**
     * 查询手机号码是否存在
     * @param request
     * @param passport
     * @return
     */
    UserExistByMobilePhoneResponse existByMobilePhone(UserExistByMobileRequest request, Passport passport);

    /**
     * 是否需要修改密码
     * @param req
     * @param passport
     * @return
     */
    LoginPasswordIsResetableResponse isResetablePassword(LoginPasswordIsResetableRequest req, Passport passport);

    /**
     * 修改密码
     * @param request
     * @param passport
     * @return
     */
    LoginPasswordModifyResponse modifyPassword(LoginPasswordModifyRequest request, Passport passport);

    /**
     * 重置密码
     * @param req
     * @param passport
     * @return
     */
    LoginPasswordResetResponse resetPassword(LoginPasswordResetRequest req, Passport passport);

    /**
     * 获取瘦咖详细信息
     * @param request
     * @param passport
     * @return
     */
    ShowCalGetResponse getShowCalInfo(ShowcalGetRequest request, Passport passport);

    /**
     * 查询所有瘦咖信息
     * @param request
     * @param passport
     * @return
     */
    ShowCalQueryResponse queryShowCalInfo(ShowCalQueryRequest request, Passport passport);

    /**
     * OpenId 是否存在
     * @param request
     * @param passport
     * @return
     */
    UserExistByOpenIdResponse existByOpenId(UserExistByOpenIdRequest request, Passport passport);

    /**
     * 根据OpenId 颁发Passport
     * @param request
     * @param passport
     * @return
     */
    LoginByOpenIdResponse loginByOpenId(LoginByOpenIdRequest request, Passport passport);
}
