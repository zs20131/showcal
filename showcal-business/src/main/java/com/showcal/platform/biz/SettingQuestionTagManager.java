/**
 * @(#)SettingQuestionTagManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 * @author 顾志雄
 */
public interface SettingQuestionTagManager {
    /**
     * 根据Id获取问题标签
     *
     * @param request 获取问题标签请求
     * @param passport 用户护照
     * @return 获取问题标签应答
     */
    SettingQuestionTagGetResponse get(SettingQuestionTagGetRequest request, Passport passport);




    /**
     * 高级查询问题标签
     *
     * @param request 高级查询问题标签请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SettingQuestionTagFindResponse find(SettingQuestionTagFindRequest request, Passport passport);

    /**
     * 获取所有问题标签列表
     *
     * @param request 获取所有问题标签列表请求
     * @param passport 用户护照
     * @return 获取所有问题标签列表应答
     */
    SettingQuestionTagGetAllListResponse getAllList(SettingQuestionTagGetAllListRequest request, Passport passport);


    /**
     * 创建问题标签
     *
     * @param request 创建问题标签请求
     * @param passport 用户护照
     * @return 创建问题标签应答
     */
    SettingQuestionTagCreateResponse create(SettingQuestionTagCreateRequest request, Passport passport);


    /**
     * 更新问题标签
     *
     * @param request 更新问题标签请求
     * @param passport 用户护照
     * @return 更新问题标签应答
     */
    SettingQuestionTagUpdateResponse update(SettingQuestionTagUpdateRequest request, Passport passport);


    /**
     * 删除问题标签
     *
     * @param request 删除问题标签请求
     * @param passport 用户护照
     * @return 删除问题标签应答
     */
    SettingQuestionTagDeleteResponse delete(SettingQuestionTagDeleteRequest request, Passport passport);

    
    /**
     * 作废问题标签
     *
     * @param request 作废问题标签请求
     * @param passport 用户护照
     * @return 作废问题标签应答
     */
    SettingQuestionTagInactiveResponse inactive(SettingQuestionTagInactiveRequest request, Passport passport);


    /**
     * 激活问题标签
     *
     * @param request 激活问题标签请求
     * @param passport 用户护照
     * @return 激活问题标签应答
     */
    SettingQuestionTagActiveResponse active(SettingQuestionTagActiveRequest request, Passport passport);
    
}
