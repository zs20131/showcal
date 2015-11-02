/**
 * @(#)CollectionManager.java
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
 * Created by 顾志雄 on 2015-09-23 10:27:25.
 * @author 顾志雄
 */
public interface CollectionManager {
    /**
     * 根据Id获取
     *
     * @param request 获取请求
     * @param passport 用户护照
     * @return 获取应答
     */
    CollectionGetResponse get(CollectionGetRequest request, Passport passport);


    /**
     * 模糊查询
     *
     * @param request 模糊查询请求
     * @param passport 用户护照
     * @return 模糊查询应答
     */
    CollectionSearchResponse search(CollectionSearchRequest request, Passport passport);

    /**
     * 高级查询
     *
     * @param request 高级查询请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    CollectionFindResponse find(CollectionFindRequest request, Passport passport);


    /**
     * 创建
     *
     * @param request 创建请求
     * @param passport 用户护照
     * @return 创建应答
     */
    CollectionCreateResponse create(CollectionCreateRequest request, Passport passport);


    /**
     * 更新
     *
     * @param request 更新请求
     * @param passport 用户护照
     * @return 更新应答
     */
    CollectionUpdateResponse update(CollectionUpdateRequest request, Passport passport);


    /**
     * 删除
     *
     * @param request 删除请求
     * @param passport 用户护照
     * @return 删除应答
     */

  CollectionDeleteResponse delete(CollectionDeleteRequest request, Passport passport);


}
