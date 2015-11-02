/**
 * @(#)WelcomeManager.java
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
package com.showcal.service.biz;

import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.xiniunet.framework.security.Passport;


/**
 * Created by 顾志雄 on 2015-09-30 18:20:47.
 * @author 顾志雄
 */
public interface WelcomeManager {
    /**
     * 根据Id获取欢迎语
     *
     * @param request 获取欢迎语请求
     * @param passport 用户护照
     * @return 获取欢迎语应答
     */
    WelcomeGetResponse get(WelcomeGetRequest request, Passport passport);


    /**
     * 模糊查询欢迎语
     *
     * @param request 模糊查询欢迎语请求
     * @param passport 用户护照
     * @return 模糊查询欢迎语应答
     */
    WelcomeSearchResponse search(WelcomeSearchRequest request, Passport passport);

    /**
     * 高级查询欢迎语
     *
     * @param request 高级查询欢迎语请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    WelcomeFindResponse find(WelcomeFindRequest request, Passport passport);

    /**
     * 获取所有欢迎语列表
     *
     * @param request 获取所有欢迎语列表请求
     * @param passport 用户护照
     * @return 获取所有欢迎语列表应答
     */
    WelcomeGetAllListResponse getAllList(WelcomeGetAllListRequest request, Passport passport);

    /**
     * 获取我的瘦咖欢迎语
     *
     * @param request 获取所有欢迎语列表请求
     * @param passport 用户护照
     * @return 获取所有欢迎语列表应答
     */
    WelComeGetForMyResponse getMyShowCalWelcome(WelcomeGetForMyRequest request, Passport passport);

    /**
     * 创建欢迎语
     *
     * @param request 创建欢迎语请求
     * @param passport 用户护照
     * @return 创建欢迎语应答
     */
    WelcomeCreateResponse create(WelcomeCreateRequest request, Passport passport);


    /**
     * 更新欢迎语
     *
     * @param request 更新欢迎语请求
     * @param passport 用户护照
     * @return 更新欢迎语应答
     */
    WelcomeUpdateResponse update(WelcomeUpdateRequest request, Passport passport);


    /**
     * 删除欢迎语
     *
     * @param request 删除欢迎语请求
     * @param passport 用户护照
     * @return 删除欢迎语应答
     */
    WelcomeDeleteResponse delete(WelcomeDeleteRequest request, Passport passport);

    
    /**
     * 作废欢迎语
     *
     * @param request 作废欢迎语请求
     * @param passport 用户护照
     * @return 作废欢迎语应答
     */
    WelcomeInactiveResponse inactive(WelcomeInactiveRequest request, Passport passport);


    /**
     * 激活欢迎语
     *
     * @param request 激活欢迎语请求
     * @param passport 用户护照
     * @return 激活欢迎语应答
     */
    WelcomeActiveResponse active(WelcomeActiveRequest request, Passport passport);
    


    /**
     * 导入欢迎语
     *
     * @param request 导入欢迎语请求
     * @param passport 用户护照
     * @return 导入欢迎语应答
     */
    WelcomeListImportResponse importList(WelcomeListImportRequest request, Passport passport);


}
