/**
 * @(#)ItemDetailManager.java
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
package com.showcal.merchandise.biz;

import com.xiniunet.framework.security.Passport;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:06.
 * @author 顾志雄
 */
public interface ItemDetailManager {
    /**
     * 根据Id获取物料详情说明
     *
     * @param request 获取物料详情说明请求
     * @param passport 用户护照
     * @return 获取物料详情说明应答
     */
    ItemDetailGetResponse get(ItemDetailGetRequest request, Passport passport);


    /**
     * 模糊查询物料详情说明
     *
     * @param request 模糊查询物料详情说明请求
     * @param passport 用户护照
     * @return 模糊查询物料详情说明应答
     */
    ItemDetailSearchResponse search(ItemDetailSearchRequest request, Passport passport);

    /**
     * 高级查询物料详情说明
     *
     * @param request 高级查询物料详情说明请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ItemDetailFindResponse find(ItemDetailFindRequest request, Passport passport);

    /**
     * 获取所有物料详情说明列表
     *
     * @param request 获取所有物料详情说明列表请求
     * @param passport 用户护照
     * @return 获取所有物料详情说明列表应答
     */
    ItemDetailGetAllListResponse getAllList(ItemDetailGetAllListRequest request, Passport passport);


    /**
     * 创建物料详情说明
     *
     * @param request 创建物料详情说明请求
     * @param passport 用户护照
     * @return 创建物料详情说明应答
     */
    ItemDetailCreateResponse create(ItemDetailCreateRequest request, Passport passport);


    /**
     * 更新物料详情说明
     *
     * @param request 更新物料详情说明请求
     * @param passport 用户护照
     * @return 更新物料详情说明应答
     */
    ItemDetailUpdateResponse update(ItemDetailUpdateRequest request, Passport passport);


    /**
     * 删除物料详情说明
     *
     * @param request 删除物料详情说明请求
     * @param passport 用户护照
     * @return 删除物料详情说明应答
     */
    ItemDetailDeleteResponse delete(ItemDetailDeleteRequest request, Passport passport);

    


    /**
     * 导入物料详情说明
     *
     * @param request 导入物料详情说明请求
     * @param passport 用户护照
     * @return 导入物料详情说明应答
     */
    ItemDetailListImportResponse importList(ItemDetailListImportRequest request, Passport passport);


}
