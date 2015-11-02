/**
 * @(#)BrandManager.java
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
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 * @author 顾志雄
 */
public interface BrandManager {
    /**
     * 根据Id获取物料品牌表
     *
     * @param request 获取物料品牌表请求
     * @param passport 用户护照
     * @return 获取物料品牌表应答
     */
    BrandGetResponse get(BrandGetRequest request, Passport passport);


    /**
     * 模糊查询物料品牌表
     *
     * @param request 模糊查询物料品牌表请求
     * @param passport 用户护照
     * @return 模糊查询物料品牌表应答
     */
    BrandSearchResponse search(BrandSearchRequest request, Passport passport);

    /**
     * 高级查询物料品牌表
     *
     * @param request 高级查询物料品牌表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    BrandFindResponse find(BrandFindRequest request, Passport passport);

    /**
     * 获取所有物料品牌表列表
     *
     * @param request 获取所有物料品牌表列表请求
     * @param passport 用户护照
     * @return 获取所有物料品牌表列表应答
     */
    BrandGetAllListResponse getAllList(BrandGetAllListRequest request, Passport passport);


    /**
     * 创建物料品牌表
     *
     * @param request 创建物料品牌表请求
     * @param passport 用户护照
     * @return 创建物料品牌表应答
     */
    BrandCreateResponse create(BrandCreateRequest request, Passport passport);


    /**
     * 更新物料品牌表
     *
     * @param request 更新物料品牌表请求
     * @param passport 用户护照
     * @return 更新物料品牌表应答
     */
    BrandUpdateResponse update(BrandUpdateRequest request, Passport passport);


    /**
     * 删除物料品牌表
     *
     * @param request 删除物料品牌表请求
     * @param passport 用户护照
     * @return 删除物料品牌表应答
     */
    BrandDeleteResponse delete(BrandDeleteRequest request, Passport passport);

    


    /**
     * 导入物料品牌表
     *
     * @param request 导入物料品牌表请求
     * @param passport 用户护照
     * @return 导入物料品牌表应答
     */
    BrandListImportResponse importList(BrandListImportRequest request, Passport passport);


}
