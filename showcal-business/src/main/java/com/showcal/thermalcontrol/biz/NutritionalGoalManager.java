/**
 * @(#)NutritionalGoalManager.java
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
package com.showcal.thermalcontrol.biz;

import com.xiniunet.framework.security.Passport;
import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public interface NutritionalGoalManager {
    /**
     * 根据Id获取营养目标
     *
     * @param request 获取营养目标请求
     * @param passport 用户护照
     * @return 获取营养目标应答
     */
    NutritionalGoalGetResponse get(NutritionalGoalGetRequest request, Passport passport);


    /**
     * 模糊查询营养目标
     *
     * @param request 模糊查询营养目标请求
     * @param passport 用户护照
     * @return 模糊查询营养目标应答
     */
    NutritionalGoalSearchResponse search(NutritionalGoalSearchRequest request, Passport passport);

    /**
     * 高级查询营养目标
     *
     * @param request 高级查询营养目标请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    NutritionalGoalFindResponse find(NutritionalGoalFindRequest request, Passport passport);

    /**
     * 获取所有营养目标列表
     *
     * @param request 获取所有营养目标列表请求
     * @param passport 用户护照
     * @return 获取所有营养目标列表应答
     */
    NutritionalGoalGetAllListResponse getAllList(NutritionalGoalGetAllListRequest request, Passport passport);


    /**
     * 创建营养目标
     *
     * @param request 创建营养目标请求
     * @param passport 用户护照
     * @return 创建营养目标应答
     */
    NutritionalGoalCreateResponse create(NutritionalGoalCreateRequest request, Passport passport);


    /**
     * 更新营养目标
     *
     * @param request 更新营养目标请求
     * @param passport 用户护照
     * @return 更新营养目标应答
     */
    NutritionalGoalUpdateResponse update(NutritionalGoalUpdateRequest request, Passport passport);


    /**
     * 删除营养目标
     *
     * @param request 删除营养目标请求
     * @param passport 用户护照
     * @return 删除营养目标应答
     */
    NutritionalGoalDeleteResponse delete(NutritionalGoalDeleteRequest request, Passport passport);

    
    /**
     * 作废营养目标
     *
     * @param request 作废营养目标请求
     * @param passport 用户护照
     * @return 作废营养目标应答
     */
    NutritionalGoalInactiveResponse inactive(NutritionalGoalInactiveRequest request, Passport passport);


    /**
     * 激活营养目标
     *
     * @param request 激活营养目标请求
     * @param passport 用户护照
     * @return 激活营养目标应答
     */
    NutritionalGoalActiveResponse active(NutritionalGoalActiveRequest request, Passport passport);
    


    /**
     * 导入营养目标
     *
     * @param request 导入营养目标请求
     * @param passport 用户护照
     * @return 导入营养目标应答
     */
    NutritionalGoalListImportResponse importList(NutritionalGoalListImportRequest request, Passport passport);


}
