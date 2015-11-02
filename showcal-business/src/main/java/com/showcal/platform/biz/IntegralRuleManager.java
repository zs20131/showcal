/**
 * @(#)IntegralRuleManager.java
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
 * Created by 顾志雄 on 2015-09-17 11:08:00.
 * @author 顾志雄
 */
public interface IntegralRuleManager {
    /**
     * 根据Id获取积分规则
     *
     * @param request 获取积分规则请求
     * @param passport 用户护照
     * @return 获取积分规则应答
     */
    IntegralRuleGetResponse get(IntegralRuleGetRequest request, Passport passport);




    /**
     * 获取所有积分规则列表
     *
     * @param request 获取所有积分规则列表请求
     * @param passport 用户护照
     * @return 获取所有积分规则列表应答
     */
    IntegralRuleGetAllListResponse getAllList(IntegralRuleGetAllListRequest request, Passport passport);


    /**
     * 创建积分规则
     *
     * @param request 创建积分规则请求
     * @param passport 用户护照
     * @return 创建积分规则应答
     */
    IntegralRuleCreateResponse create(IntegralRuleCreateRequest request, Passport passport);


    /**
     * 更新积分规则
     *
     * @param request 更新积分规则请求
     * @param passport 用户护照
     * @return 更新积分规则应答
     */
    IntegralRuleUpdateResponse update(IntegralRuleUpdateRequest request, Passport passport);


    /**
     * 删除积分规则
     *
     * @param request 删除积分规则请求
     * @param passport 用户护照
     * @return 删除积分规则应答
     */
    IntegralRuleDeleteResponse delete(IntegralRuleDeleteRequest request, Passport passport);

    /**
     * 高级查询积分规则
     *
     * @param request 高级查询积分规则请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    IntegralRuleFindResponse find(IntegralRuleFindRequest request, Passport passport);

}
