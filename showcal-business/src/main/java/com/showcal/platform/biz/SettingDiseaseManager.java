/**
 * @(#)SettingDiseaseManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:50.
 * @author 顾志雄
 */
public interface SettingDiseaseManager {
    /**
     * 根据Id获取疾病特殊情况
     *
     * @param request 获取疾病特殊情况请求
     * @param passport 用户护照
     * @return 获取疾病特殊情况应答
     */
    SettingDiseaseGetResponse get(SettingDiseaseGetRequest request, Passport passport);



    /**
     * 高级查询疾病特殊情况
     *
     * @param request 高级查询疾病特殊情况请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SettingDiseaseFindResponse find(SettingDiseaseFindRequest request, Passport passport);

    /**
     * 获取所有疾病特殊情况列表
     *
     * @param request 获取所有疾病特殊情况列表请求
     * @param passport 用户护照
     * @return 获取所有疾病特殊情况列表应答
     */
    SettingDiseaseGetAllListResponse getAllList(SettingDiseaseGetAllListRequest request, Passport passport);

    /**
     *  获取App端的所有疾病特殊情况列表
     *
     * @param request
     * @param passport
     * @return
     */
    SettingDiseaseAppGetAllListResponse getAppAllList(SettingDiseaseAppGetAllListRequest request, Passport passport);

    /**
     * 创建疾病特殊情况
     *
     * @param request 创建疾病特殊情况请求
     * @param passport 用户护照
     * @return 创建疾病特殊情况应答
     */
    SettingDiseaseCreateResponse create(SettingDiseaseCreateRequest request, Passport passport);


    /**
     * 更新疾病特殊情况
     *
     * @param request 更新疾病特殊情况请求
     * @param passport 用户护照
     * @return 更新疾病特殊情况应答
     */
    SettingDiseaseUpdateResponse update(SettingDiseaseUpdateRequest request, Passport passport);


    /**
     * 删除疾病特殊情况
     *
     * @param request 删除疾病特殊情况请求
     * @param passport 用户护照
     * @return 删除疾病特殊情况应答
     */
    SettingDiseaseDeleteResponse delete(SettingDiseaseDeleteRequest request, Passport passport);

    
    /**
     * 作废疾病特殊情况
     *
     * @param request 作废疾病特殊情况请求
     * @param passport 用户护照
     * @return 作废疾病特殊情况应答
     */
    SettingDiseaseInactiveResponse inactive(SettingDiseaseInactiveRequest request, Passport passport);


    /**
     * 激活疾病特殊情况
     *
     * @param request 激活疾病特殊情况请求
     * @param passport 用户护照
     * @return 激活疾病特殊情况应答
     */
    SettingDiseaseActiveResponse active(SettingDiseaseActiveRequest request, Passport passport);

}
