/**
 * @(#)ItemPictureManager.java
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
 * Created by 顾志雄 on 2015-09-24 09:54:07.
 * @author 顾志雄
 */
public interface ItemPictureManager {
    /**
     * 根据Id获取物料图片表
     *
     * @param request 获取物料图片表请求
     * @param passport 用户护照
     * @return 获取物料图片表应答
     */
    ItemPictureGetResponse get(ItemPictureGetRequest request, Passport passport);


    /**
     * 模糊查询物料图片表
     *
     * @param request 模糊查询物料图片表请求
     * @param passport 用户护照
     * @return 模糊查询物料图片表应答
     */
    ItemPictureSearchResponse search(ItemPictureSearchRequest request, Passport passport);

    /**
     * 高级查询物料图片表
     *
     * @param request 高级查询物料图片表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ItemPictureFindResponse find(ItemPictureFindRequest request, Passport passport);

    /**
     * 获取所有物料图片表列表
     *
     * @param request 获取所有物料图片表列表请求
     * @param passport 用户护照
     * @return 获取所有物料图片表列表应答
     */
    ItemPictureGetAllListResponse getAllList(ItemPictureGetAllListRequest request, Passport passport);


    /**
     * 创建物料图片表
     *
     * @param request 创建物料图片表请求
     * @param passport 用户护照
     * @return 创建物料图片表应答
     */
    ItemPictureCreateResponse create(ItemPictureCreateRequest request, Passport passport);


    /**
     * 更新物料图片表
     *
     * @param request 更新物料图片表请求
     * @param passport 用户护照
     * @return 更新物料图片表应答
     */
    ItemPictureUpdateResponse update(ItemPictureUpdateRequest request, Passport passport);


    /**
     * 删除物料图片表
     *
     * @param request 删除物料图片表请求
     * @param passport 用户护照
     * @return 删除物料图片表应答
     */
    ItemPictureDeleteResponse delete(ItemPictureDeleteRequest request, Passport passport);

    


    /**
     * 导入物料图片表
     *
     * @param request 导入物料图片表请求
     * @param passport 用户护照
     * @return 导入物料图片表应答
     */
    ItemPictureListImportResponse importList(ItemPictureListImportRequest request, Passport passport);

    /**
     * 上传附件
     *
     * @param req      上传附件请求
     * @param passport 用户护照
     * @return 上传附件应答
     */
    ItemPictureUploadResponse uploadAttachment(ItemPictureUploadRequest req, Passport passport);


}
