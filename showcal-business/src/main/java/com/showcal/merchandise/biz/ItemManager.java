/**
 * @(#)ItemManager.java
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
public interface ItemManager {
    /**
     * 根据Id获取物料表
     *
     * @param request 获取物料表请求
     * @param passport 用户护照
     * @return 获取物料表应答
     */
    ItemGetResponse get(ItemGetRequest request, Passport passport);


    /**
     * 模糊查询物料表
     *
     * @param request 模糊查询物料表请求
     * @param passport 用户护照
     * @return 模糊查询物料表应答
     */
    ItemSearchResponse search(ItemSearchRequest request, Passport passport);

    /**
     * 高级查询物料表
     *
     * @param request 高级查询物料表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ItemFindResponse find(ItemFindRequest request, Passport passport);

    /**
     * 获取所有物料表列表
     *
     * @param request 获取所有物料表列表请求
     * @param passport 用户护照
     * @return 获取所有物料表列表应答
     */
    ItemGetAllListResponse getAllList(ItemGetAllListRequest request, Passport passport);


    /**
     * 创建物料表
     *
     * @param request 创建物料表请求
     * @param passport 用户护照
     * @return 创建物料表应答
     */
    ItemCreateResponse create(ItemCreateRequest request, Passport passport);


    /**
     * 更新物料表
     *
     * @param request 更新物料表请求
     * @param passport 用户护照
     * @return 更新物料表应答
     */
    ItemUpdateResponse update(ItemUpdateRequest request, Passport passport);


    /**
     * 删除物料表
     *
     * @param request 删除物料表请求
     * @param passport 用户护照
     * @return 删除物料表应答
     */
    ItemDeleteResponse delete(ItemDeleteRequest request, Passport passport);

    
    /**
     * 作废物料表
     *
     * @param request 作废物料表请求
     * @param passport 用户护照
     * @return 作废物料表应答
     */
    ItemInactiveResponse inactive(ItemInactiveRequest request, Passport passport);


    /**
     * 激活物料表
     *
     * @param request 激活物料表请求
     * @param passport 用户护照
     * @return 激活物料表应答
     */
    ItemActiveResponse active(ItemActiveRequest request, Passport passport);
    


    /**
     * 导入物料表
     *
     * @param request 导入物料表请求
     * @param passport 用户护照
     * @return 导入物料表应答
     */
    ItemListImportResponse importList(ItemListImportRequest request, Passport passport);


    /**
     * 审批物料
     *
     * @param request 审批物料请求
     * @param passport 用户护照
     * @return 审批物料应答
     */
    ItemApproveResponse approve(ItemApproveRequest request, Passport passport);
    /**
     *取消发布
     *
     * @param request 取消发布请求
     * @param passport 用户护照
     * @return 取消发布应答
     */
    ItemCancelResponse cancel(ItemCancelRequest request, Passport passport);

    ItemCollectionResponse clickCollection(ItemCollectionRequest request, Passport passport);

    ItemChangeOrderResponse changeOrder(ItemChangeOrderRequest request, Passport passport);
}
