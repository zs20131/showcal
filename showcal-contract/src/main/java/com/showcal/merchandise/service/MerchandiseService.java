/**
 * @(#)ClazzService.java
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
package com.showcal.merchandise.service;

import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;
import com.xiniunet.framework.security.Passport;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 * @author 顾志雄
 */
public interface MerchandiseService {

    /**
     * 根据Id获取商品类别
     *
     * @param request 获取商品类别请求
     * @param passport 用户护照
     * @return 获取商品类别应答
     */
    ClazzGetResponse getClazz(ClazzGetRequest request, Passport passport);


    /**
     * 模糊查询商品类别
     *
     * @param request 模糊查询商品类别请求
     * @param passport 用户护照
     * @return 模糊查询商品类别应答
     */
    ClazzSearchResponse searchClazz(ClazzSearchRequest request, Passport passport);

    /**
     * 高级查询商品类别
     *
     * @param request 高级查询商品类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ClazzFindResponse findClazz(ClazzFindRequest request, Passport passport);

    /**
     * 获取所有商品类别列表
     *
     * @param request 获取所有商品类别列表请求
     * @param passport 用户护照
     * @return 获取所有商品类别列表应答
     */
    ClazzGetAllListResponse getClazzAllList(ClazzGetAllListRequest request, Passport passport);


    /**
     * 创建商品类别
     *
     * @param request 创建商品类别请求
     * @param passport 用户护照
     * @return 创建商品类别应答
     */
    ClazzCreateResponse createClazz(ClazzCreateRequest request, Passport passport);


    /**
     * 更新商品类别
     *
     * @param request 更新商品类别请求
     * @param passport 用户护照
     * @return 更新商品类别应答
     */
    ClazzUpdateResponse updateClazz(ClazzUpdateRequest request, Passport passport);


    /**
     * 删除商品类别
     *
     * @param request 删除商品类别请求
     * @param passport 用户护照
     * @return 删除商品类别应答
     */
    ClazzDeleteResponse deleteClazz(ClazzDeleteRequest request, Passport passport);




    /**
     * 导入商品类别
     *
     * @param request 导入商品类别请求
     * @param passport 用户护照
     * @return 导入商品类别应答
     */
    ClazzListImportResponse importClazzList(ClazzListImportRequest request, Passport passport);

    /**
     * 根据Id获取物料品牌表
     *
     * @param request 获取物料品牌表请求
     * @param passport 用户护照
     * @return 获取物料品牌表应答
     */
    BrandGetResponse getBrand(BrandGetRequest request, Passport passport);


    /**
     * 模糊查询物料品牌表
     *
     * @param request 模糊查询物料品牌表请求
     * @param passport 用户护照
     * @return 模糊查询物料品牌表应答
     */
    BrandSearchResponse searchBrand(BrandSearchRequest request, Passport passport);

    /**
     * 高级查询物料品牌表
     *
     * @param request 高级查询物料品牌表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    BrandFindResponse findBrand(BrandFindRequest request, Passport passport);

    /**
     * 获取所有物料品牌表列表
     *
     * @param request 获取所有物料品牌表列表请求
     * @param passport 用户护照
     * @return 获取所有物料品牌表列表应答
     */
    BrandGetAllListResponse getBrandAllList(BrandGetAllListRequest request, Passport passport);


    /**
     * 创建物料品牌表
     *
     * @param request 创建物料品牌表请求
     * @param passport 用户护照
     * @return 创建物料品牌表应答
     */
    BrandCreateResponse createBrand(BrandCreateRequest request, Passport passport);


    /**
     * 更新物料品牌表
     *
     * @param request 更新物料品牌表请求
     * @param passport 用户护照
     * @return 更新物料品牌表应答
     */
    BrandUpdateResponse updateBrand(BrandUpdateRequest request, Passport passport);


    /**
     * 删除物料品牌表
     *
     * @param request 删除物料品牌表请求
     * @param passport 用户护照
     * @return 删除物料品牌表应答
     */
    BrandDeleteResponse deleteBrand(BrandDeleteRequest request, Passport passport);




    /**
     * 导入物料品牌表
     *
     * @param request 导入物料品牌表请求
     * @param passport 用户护照
     * @return 导入物料品牌表应答
     */
    BrandListImportResponse importBrandList(BrandListImportRequest request, Passport passport);

    /**
     * 根据Id获取物料详情说明
     *
     * @param request 获取物料详情说明请求
     * @param passport 用户护照
     * @return 获取物料详情说明应答
     */
    ItemDetailGetResponse getItemDetail(ItemDetailGetRequest request, Passport passport);


    /**
     * 模糊查询物料详情说明
     *
     * @param request 模糊查询物料详情说明请求
     * @param passport 用户护照
     * @return 模糊查询物料详情说明应答
     */
    ItemDetailSearchResponse searchItemDetail(ItemDetailSearchRequest request, Passport passport);

    /**
     * 高级查询物料详情说明
     *
     * @param request 高级查询物料详情说明请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ItemDetailFindResponse findItemDetail(ItemDetailFindRequest request, Passport passport);

    /**
     * 获取所有物料详情说明列表
     *
     * @param request 获取所有物料详情说明列表请求
     * @param passport 用户护照
     * @return 获取所有物料详情说明列表应答
     */
    ItemDetailGetAllListResponse getItemDetailAllList(ItemDetailGetAllListRequest request, Passport passport);


    /**
     * 创建物料详情说明
     *
     * @param request 创建物料详情说明请求
     * @param passport 用户护照
     * @return 创建物料详情说明应答
     */
    ItemDetailCreateResponse createItemDetail(ItemDetailCreateRequest request, Passport passport);


    /**
     * 更新物料详情说明
     *
     * @param request 更新物料详情说明请求
     * @param passport 用户护照
     * @return 更新物料详情说明应答
     */
    ItemDetailUpdateResponse updateItemDetail(ItemDetailUpdateRequest request, Passport passport);


    /**
     * 删除物料详情说明
     *
     * @param request 删除物料详情说明请求
     * @param passport 用户护照
     * @return 删除物料详情说明应答
     */
    ItemDetailDeleteResponse deleteItemDetail(ItemDetailDeleteRequest request, Passport passport);




    /**
     * 导入物料详情说明
     *
     * @param request 导入物料详情说明请求
     * @param passport 用户护照
     * @return 导入物料详情说明应答
     */
    ItemDetailListImportResponse importItemDetailList(ItemDetailListImportRequest request, Passport passport);

    /**
     * 根据Id获取物料电商属性
     *
     * @param request 获取物料电商属性请求
     * @param passport 用户护照
     * @return 获取物料电商属性应答
     */
    ItemEcommerceGetResponse getItemEcommerce(ItemEcommerceGetRequest request, Passport passport);


    /**
     * 模糊查询物料电商属性
     *
     * @param request 模糊查询物料电商属性请求
     * @param passport 用户护照
     * @return 模糊查询物料电商属性应答
     */
    ItemEcommerceSearchResponse searchItemEcommerce(ItemEcommerceSearchRequest request, Passport passport);

    /**
     * 高级查询物料电商属性
     *
     * @param request 高级查询物料电商属性请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ItemEcommerceFindResponse findItemEcommerce(ItemEcommerceFindRequest request, Passport passport);

    /**
     * 获取所有物料电商属性列表
     *
     * @param request 获取所有物料电商属性列表请求
     * @param passport 用户护照
     * @return 获取所有物料电商属性列表应答
     */
    ItemEcommerceGetAllListResponse getItemEcommerceAllList(ItemEcommerceGetAllListRequest request, Passport passport);


    /**
     * 创建物料电商属性
     *
     * @param request 创建物料电商属性请求
     * @param passport 用户护照
     * @return 创建物料电商属性应答
     */
    ItemEcommerceCreateResponse createItemEcommerce(ItemEcommerceCreateRequest request, Passport passport);


    /**
     * 更新物料电商属性
     *
     * @param request 更新物料电商属性请求
     * @param passport 用户护照
     * @return 更新物料电商属性应答
     */
    ItemEcommerceUpdateResponse updateItemEcommerce(ItemEcommerceUpdateRequest request, Passport passport);


    /**
     * 删除物料电商属性
     *
     * @param request 删除物料电商属性请求
     * @param passport 用户护照
     * @return 删除物料电商属性应答
     */
    ItemEcommerceDeleteResponse deleteItemEcommerce(ItemEcommerceDeleteRequest request, Passport passport);




    /**
     * 导入物料电商属性
     *
     * @param request 导入物料电商属性请求
     * @param passport 用户护照
     * @return 导入物料电商属性应答
     */
    ItemEcommerceListImportResponse importItemEcommerceList(ItemEcommerceListImportRequest request, Passport passport);

    /**
     * 根据Id获取物料图片表
     *
     * @param request 获取物料图片表请求
     * @param passport 用户护照
     * @return 获取物料图片表应答
     */
    ItemPictureGetResponse getItemPicture(ItemPictureGetRequest request, Passport passport);


    /**
     * 模糊查询物料图片表
     *
     * @param request 模糊查询物料图片表请求
     * @param passport 用户护照
     * @return 模糊查询物料图片表应答
     */
    ItemPictureSearchResponse searchItemPicture(ItemPictureSearchRequest request, Passport passport);

    /**
     * 高级查询物料图片表
     *
     * @param request 高级查询物料图片表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ItemPictureFindResponse findItemPicture(ItemPictureFindRequest request, Passport passport);

    /**
     * 获取所有物料图片表列表
     *
     * @param request 获取所有物料图片表列表请求
     * @param passport 用户护照
     * @return 获取所有物料图片表列表应答
     */
    ItemPictureGetAllListResponse getItemPictureAllList(ItemPictureGetAllListRequest request, Passport passport);


    /**
     * 创建物料图片表
     *
     * @param request 创建物料图片表请求
     * @param passport 用户护照
     * @return 创建物料图片表应答
     */
    ItemPictureCreateResponse createItemPicture(ItemPictureCreateRequest request, Passport passport);


    /**
     * 更新物料图片表
     *
     * @param request 更新物料图片表请求
     * @param passport 用户护照
     * @return 更新物料图片表应答
     */
    ItemPictureUpdateResponse updateItemPicture(ItemPictureUpdateRequest request, Passport passport);


    /**
     * 删除物料图片表
     *
     * @param request 删除物料图片表请求
     * @param passport 用户护照
     * @return 删除物料图片表应答
     */
    ItemPictureDeleteResponse deleteItemPicture(ItemPictureDeleteRequest request, Passport passport);




    /**
     * 导入物料图片表
     *
     * @param request 导入物料图片表请求
     * @param passport 用户护照
     * @return 导入物料图片表应答
     */
    ItemPictureListImportResponse importItemPictureList(ItemPictureListImportRequest request, Passport passport);


    /**
     * 根据Id获取物料表
     *
     * @param request 获取物料表请求
     * @param passport 用户护照
     * @return 获取物料表应答
     */
    ItemGetResponse getItem(ItemGetRequest request, Passport passport);


    /**
     * 模糊查询物料表
     *
     * @param request 模糊查询物料表请求
     * @param passport 用户护照
     * @return 模糊查询物料表应答
     */
    ItemSearchResponse searchItem(ItemSearchRequest request, Passport passport);

    /**
     * 高级查询物料表
     *
     * @param request 高级查询物料表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ItemFindResponse findItem(ItemFindRequest request, Passport passport);

    /**
     * 获取所有物料表列表
     *
     * @param request 获取所有物料表列表请求
     * @param passport 用户护照
     * @return 获取所有物料表列表应答
     */
    ItemGetAllListResponse getItemAllList(ItemGetAllListRequest request, Passport passport);


    /**
     * 创建物料表
     *
     * @param request 创建物料表请求
     * @param passport 用户护照
     * @return 创建物料表应答
     */
    ItemCreateResponse createItem(ItemCreateRequest request, Passport passport);


    /**
     * 更新物料表
     *
     * @param request 更新物料表请求
     * @param passport 用户护照
     * @return 更新物料表应答
     */
    ItemUpdateResponse updateItem(ItemUpdateRequest request, Passport passport);


    /**
     * 删除物料表
     *
     * @param request 删除物料表请求
     * @param passport 用户护照
     * @return 删除物料表应答
     */
    ItemDeleteResponse deleteItem(ItemDeleteRequest request, Passport passport);


    /**
     * 作废物料表
     *
     * @param request 作废物料表请求
     * @param passport 用户护照
     * @return 作废物料表应答
     */
    ItemInactiveResponse inactiveItem(ItemInactiveRequest request, Passport passport);


    /**
     * 激活物料表
     *
     * @param request 激活物料表请求
     * @param passport 用户护照
     * @return 激活物料表应答
     */
    ItemActiveResponse activeItem(ItemActiveRequest request, Passport passport);



    /**
     * 导入物料表
     *
     * @param request 导入物料表请求
     * @param passport 用户护照
     * @return 导入物料表应答
     */
    ItemListImportResponse importItemList(ItemListImportRequest request, Passport passport);



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

    ClazzCreateListResponse createList(ClazzCreateListRequest request, Passport passport);

    /**
     * 上传附件
     *
     * @param req      上传附件请求
     * @param passport 用户护照
     * @return 上传附件应答
     */
    ItemPictureUploadResponse uploadAttachment(ItemPictureUploadRequest req, Passport passport);

    ItemChangeOrderResponse changeOrder(ItemChangeOrderRequest request, Passport passport);



}