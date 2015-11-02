/**
 * @(#)SettingKeywordManager.java
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

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 *
 * @author 顾志雄
 */
public interface SettingKeywordManager {
    /**
     * 根据Id获取关键字
     *
     * @param request  获取关键字请求
     * @param passport 用户护照
     * @return 获取关键字应答
     */
    SettingKeywordGetResponse get(SettingKeywordGetRequest request, Passport passport);


    /**
     * 高级查询关键字
     *
     * @param request  高级查询关键字请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SettingKeywordFindResponse find(SettingKeywordFindRequest request, Passport passport);

    /**
     * 获取所有关键字列表
     *
     * @param request  获取所有关键字列表请求
     * @param passport 用户护照
     * @return 获取所有关键字列表应答
     */
    SettingKeywordGetAllListResponse getAllList(SettingKeywordGetAllListRequest request, Passport passport);


    /**
     * 创建关键字
     *
     * @param request  创建关键字请求
     * @param passport 用户护照
     * @return 创建关键字应答
     */
    SettingKeywordCreateResponse create(SettingKeywordCreateRequest request, Passport passport);


    /**
     * 更新关键字
     *
     * @param request  更新关键字请求
     * @param passport 用户护照
     * @return 更新关键字应答
     */
    SettingKeywordUpdateResponse update(SettingKeywordUpdateRequest request, Passport passport);


    /**
     * 删除关键字
     *
     * @param request  删除关键字请求
     * @param passport 用户护照
     * @return 删除关键字应答
     */
    SettingKeywordDeleteResponse delete(SettingKeywordDeleteRequest request, Passport passport);


    /**
     * 作废关键字
     *
     * @param request  作废关键字请求
     * @param passport 用户护照
     * @return 作废关键字应答
     */
    SettingKeywordInactiveResponse inactive(SettingKeywordInactiveRequest request, Passport passport);


    /**
     * 激活关键字
     *
     * @param request  激活关键字请求
     * @param passport 用户护照
     * @return 激活关键字应答
     */
    SettingKeywordActiveResponse active(SettingKeywordActiveRequest request, Passport passport);

    /**
     * 获取所有关键字
     * 内部使用(不对外开放)
     * @return
     */
    List<String> getAllKeyword(Passport passport);

    /**
     * 内部使用(根据关键字，获取关键字ID)
     * @param keyword
     * @return
     */
    Long getIdByKeyword(String keyword,Passport passport);

}
