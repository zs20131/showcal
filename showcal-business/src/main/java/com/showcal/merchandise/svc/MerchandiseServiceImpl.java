/**
 * @(#)BrandServiceImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.merchandise.svc;

import com.showcal.merchandise.biz.*;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;
import com.showcal.merchandise.service.MerchandiseService;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 *
 * @author 顾志雄
 */
@Service
public class MerchandiseServiceImpl implements MerchandiseService {

    @Autowired
    private BrandManager brandManager;
    @Autowired
    private ClazzManager clazzManager;

    @Autowired
    private ItemDetailManager itemDetailManager;
    @Autowired
    private ItemEcommerceManager itemEcommerceManager;
    @Autowired
    private ItemPictureManager itemPictureManager;
    @Autowired
    private ItemManager itemManager;

    /**
     * 根据Id获取物料品牌表
     *
     * @param request  获取物料品牌表请求
     * @param passport 用户护照
     * @return 获取物料品牌表应答
     */
    @Override
    public BrandGetResponse getBrand(BrandGetRequest request, Passport passport) {
        BrandGetResponse response = new BrandGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = brandManager.get(request, passport);
        return response;
    }


    /**
     * 模糊查询物料品牌表
     *
     * @param request  模糊查询物料品牌表请求
     * @param passport 用户护照
     * @return 模糊查询物料品牌表应答
     */
    @Override
    public BrandSearchResponse searchBrand(BrandSearchRequest request, Passport passport) {
        BrandSearchResponse response = new BrandSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = brandManager.search(request, passport);
        return response;
    }

    /**
     * 高级查询物料品牌表
     *
     * @param request  高级查询物料品牌表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public BrandFindResponse findBrand(BrandFindRequest request, Passport passport) {
        BrandFindResponse response = new BrandFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = brandManager.find(request, passport);
        return response;
    }

    /**
     * 获取所有物料品牌表列表
     *
     * @param request  获取所有物料品牌表列表请求
     * @param passport 用户护照
     * @return 获取所有物料品牌表列表应答
     */
    @Override
    public BrandGetAllListResponse getBrandAllList(BrandGetAllListRequest request, Passport passport) {
        BrandGetAllListResponse response = new BrandGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = brandManager.getAllList(request, passport);
        return response;
    }


    /**
     * 创建物料品牌表
     *
     * @param request  创建物料品牌表请求
     * @param passport 用户护照
     * @return 创建物料品牌表应答
     */
    @Override
    public BrandCreateResponse createBrand(BrandCreateRequest request, Passport passport) {
        BrandCreateResponse response = new BrandCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = brandManager.create(request, passport);
        return response;
    }


    /**
     * 更新物料品牌表
     *
     * @param request  更新物料品牌表请求
     * @param passport 用户护照
     * @return 更新物料品牌表应答
     */
    @Override
    public BrandUpdateResponse updateBrand(BrandUpdateRequest request, Passport passport) {
        BrandUpdateResponse response = new BrandUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = brandManager.update(request, passport);
        return response;
    }


    /**
     * 删除物料品牌表
     *
     * @param request  删除物料品牌表请求
     * @param passport 用户护照
     * @return 删除物料品牌表应答
     */
    @Override
    public BrandDeleteResponse deleteBrand(BrandDeleteRequest request, Passport passport) {
        BrandDeleteResponse response = new BrandDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = brandManager.delete(request, passport);
        return response;
    }


    /**
     * 导入物料品牌表
     *
     * @param request  导入物料品牌表请求
     * @param passport 用户护照
     * @return 导入物料品牌表应答
     */
    @Override
    public BrandListImportResponse importBrandList(BrandListImportRequest request, Passport passport) {
        BrandListImportResponse response = new BrandListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = brandManager.importList(request, passport);
        return response;
    }

    /**
     * 根据Id获取商品类别
     *
     * @param request  获取商品类别请求
     * @param passport 用户护照
     * @return 获取商品类别应答
     */
    @Override
    public ClazzGetResponse getClazz(ClazzGetRequest request, Passport passport) {
        ClazzGetResponse response = new ClazzGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = clazzManager.get(request, passport);
        return response;
    }


    /**
     * 模糊查询商品类别
     *
     * @param request  模糊查询商品类别请求
     * @param passport 用户护照
     * @return 模糊查询商品类别应答
     */
    @Override
    public ClazzSearchResponse searchClazz(ClazzSearchRequest request, Passport passport) {
        ClazzSearchResponse response = new ClazzSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = clazzManager.search(request, passport);
        return response;
    }

    /**
     * 高级查询商品类别
     *
     * @param request  高级查询商品类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public ClazzFindResponse findClazz(ClazzFindRequest request, Passport passport) {
        ClazzFindResponse response = new ClazzFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = clazzManager.find(request, passport);
        return response;
    }

    /**
     * 获取所有商品类别列表
     *
     * @param request  获取所有商品类别列表请求
     * @param passport 用户护照
     * @return 获取所有商品类别列表应答
     */
    @Override
    public ClazzGetAllListResponse getClazzAllList(ClazzGetAllListRequest request, Passport passport) {
        ClazzGetAllListResponse response = new ClazzGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = clazzManager.getAllList(request, passport);
        return response;
    }


    /**
     * 创建商品类别
     *
     * @param request  创建商品类别请求
     * @param passport 用户护照
     * @return 创建商品类别应答
     */
    @Override
    public ClazzCreateResponse createClazz(ClazzCreateRequest request, Passport passport) {
        ClazzCreateResponse response = new ClazzCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = clazzManager.create(request, passport);
        return response;
    }


    /**
     * 更新商品类别
     *
     * @param request  更新商品类别请求
     * @param passport 用户护照
     * @return 更新商品类别应答
     */
    @Override
    public ClazzUpdateResponse updateClazz(ClazzUpdateRequest request, Passport passport) {
        ClazzUpdateResponse response = new ClazzUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = clazzManager.update(request, passport);
        return response;
    }


    /**
     * 删除商品类别
     *
     * @param request  删除商品类别请求
     * @param passport 用户护照
     * @return 删除商品类别应答
     */
    @Override
    public ClazzDeleteResponse deleteClazz(ClazzDeleteRequest request, Passport passport) {
        ClazzDeleteResponse response = new ClazzDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = clazzManager.delete(request, passport);
        return response;
    }


    /**
     * 导入商品类别
     *
     * @param request  导入商品类别请求
     * @param passport 用户护照
     * @return 导入商品类别应答
     */
    @Override
    public ClazzListImportResponse importClazzList(ClazzListImportRequest request, Passport passport) {
        ClazzListImportResponse response = new ClazzListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = clazzManager.importList(request, passport);
        return response;
    }

    /**
     * 根据Id获取物料详情说明
     *
     * @param request  获取物料详情说明请求
     * @param passport 用户护照
     * @return 获取物料详情说明应答
     */
    @Override
    public ItemDetailGetResponse getItemDetail(ItemDetailGetRequest request, Passport passport) {
        ItemDetailGetResponse response = new ItemDetailGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemDetailManager.get(request, passport);
        return response;
    }


    /**
     * 模糊查询物料详情说明
     *
     * @param request  模糊查询物料详情说明请求
     * @param passport 用户护照
     * @return 模糊查询物料详情说明应答
     */
    @Override
    public ItemDetailSearchResponse searchItemDetail(ItemDetailSearchRequest request, Passport passport) {
        ItemDetailSearchResponse response = new ItemDetailSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemDetailManager.search(request, passport);
        return response;
    }

    /**
     * 高级查询物料详情说明
     *
     * @param request  高级查询物料详情说明请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public ItemDetailFindResponse findItemDetail(ItemDetailFindRequest request, Passport passport) {
        ItemDetailFindResponse response = new ItemDetailFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemDetailManager.find(request, passport);
        return response;
    }

    /**
     * 获取所有物料详情说明列表
     *
     * @param request  获取所有物料详情说明列表请求
     * @param passport 用户护照
     * @return 获取所有物料详情说明列表应答
     */
    @Override
    public ItemDetailGetAllListResponse getItemDetailAllList(ItemDetailGetAllListRequest request, Passport passport) {
        ItemDetailGetAllListResponse response = new ItemDetailGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemDetailManager.getAllList(request, passport);
        return response;
    }


    /**
     * 创建物料详情说明
     *
     * @param request  创建物料详情说明请求
     * @param passport 用户护照
     * @return 创建物料详情说明应答
     */
    @Override
    public ItemDetailCreateResponse createItemDetail(ItemDetailCreateRequest request, Passport passport) {
        ItemDetailCreateResponse response = new ItemDetailCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemDetailManager.create(request, passport);
        return response;
    }


    /**
     * 更新物料详情说明
     *
     * @param request  更新物料详情说明请求
     * @param passport 用户护照
     * @return 更新物料详情说明应答
     */
    @Override
    public ItemDetailUpdateResponse updateItemDetail(ItemDetailUpdateRequest request, Passport passport) {
        ItemDetailUpdateResponse response = new ItemDetailUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemDetailManager.update(request, passport);
        return response;
    }


    /**
     * 删除物料详情说明
     *
     * @param request  删除物料详情说明请求
     * @param passport 用户护照
     * @return 删除物料详情说明应答
     */
    @Override
    public ItemDetailDeleteResponse deleteItemDetail(ItemDetailDeleteRequest request, Passport passport) {
        ItemDetailDeleteResponse response = new ItemDetailDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemDetailManager.delete(request, passport);
        return response;
    }


    /**
     * 导入物料详情说明
     *
     * @param request  导入物料详情说明请求
     * @param passport 用户护照
     * @return 导入物料详情说明应答
     */
    @Override
    public ItemDetailListImportResponse importItemDetailList(ItemDetailListImportRequest request, Passport passport) {
        ItemDetailListImportResponse response = new ItemDetailListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemDetailManager.importList(request, passport);
        return response;
    }

    /**
     * 根据Id获取物料电商属性
     *
     * @param request  获取物料电商属性请求
     * @param passport 用户护照
     * @return 获取物料电商属性应答
     */
    @Override
    public ItemEcommerceGetResponse getItemEcommerce(ItemEcommerceGetRequest request, Passport passport) {
        ItemEcommerceGetResponse response = new ItemEcommerceGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemEcommerceManager.get(request, passport);
        return response;
    }


    /**
     * 模糊查询物料电商属性
     *
     * @param request  模糊查询物料电商属性请求
     * @param passport 用户护照
     * @return 模糊查询物料电商属性应答
     */
    @Override
    public ItemEcommerceSearchResponse searchItemEcommerce(ItemEcommerceSearchRequest request, Passport passport) {
        ItemEcommerceSearchResponse response = new ItemEcommerceSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemEcommerceManager.search(request, passport);
        return response;
    }

    /**
     * 高级查询物料电商属性
     *
     * @param request  高级查询物料电商属性请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public ItemEcommerceFindResponse findItemEcommerce(ItemEcommerceFindRequest request, Passport passport) {
        ItemEcommerceFindResponse response = new ItemEcommerceFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemEcommerceManager.find(request, passport);
        return response;
    }

    /**
     * 获取所有物料电商属性列表
     *
     * @param request  获取所有物料电商属性列表请求
     * @param passport 用户护照
     * @return 获取所有物料电商属性列表应答
     */
    @Override
    public ItemEcommerceGetAllListResponse getItemEcommerceAllList(ItemEcommerceGetAllListRequest request, Passport passport) {
        ItemEcommerceGetAllListResponse response = new ItemEcommerceGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemEcommerceManager.getAllList(request, passport);
        return response;
    }


    /**
     * 创建物料电商属性
     *
     * @param request  创建物料电商属性请求
     * @param passport 用户护照
     * @return 创建物料电商属性应答
     */
    @Override
    public ItemEcommerceCreateResponse createItemEcommerce(ItemEcommerceCreateRequest request, Passport passport) {
        ItemEcommerceCreateResponse response = new ItemEcommerceCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemEcommerceManager.create(request, passport);
        return response;
    }


    /**
     * 更新物料电商属性
     *
     * @param request  更新物料电商属性请求
     * @param passport 用户护照
     * @return 更新物料电商属性应答
     */
    @Override
    public ItemEcommerceUpdateResponse updateItemEcommerce(ItemEcommerceUpdateRequest request, Passport passport) {
        ItemEcommerceUpdateResponse response = new ItemEcommerceUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemEcommerceManager.update(request, passport);
        return response;
    }


    /**
     * 删除物料电商属性
     *
     * @param request  删除物料电商属性请求
     * @param passport 用户护照
     * @return 删除物料电商属性应答
     */
    @Override
    public ItemEcommerceDeleteResponse deleteItemEcommerce(ItemEcommerceDeleteRequest request, Passport passport) {
        ItemEcommerceDeleteResponse response = new ItemEcommerceDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemEcommerceManager.delete(request, passport);
        return response;
    }


    /**
     * 导入物料电商属性
     *
     * @param request  导入物料电商属性请求
     * @param passport 用户护照
     * @return 导入物料电商属性应答
     */
    @Override
    public ItemEcommerceListImportResponse importItemEcommerceList(ItemEcommerceListImportRequest request, Passport passport) {
        ItemEcommerceListImportResponse response = new ItemEcommerceListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemEcommerceManager.importList(request, passport);
        return response;
    }

    /**
     * 根据Id获取物料图片表
     *
     * @param request  获取物料图片表请求
     * @param passport 用户护照
     * @return 获取物料图片表应答
     */
    @Override
    public ItemPictureGetResponse getItemPicture(ItemPictureGetRequest request, Passport passport) {
        ItemPictureGetResponse response = new ItemPictureGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemPictureManager.get(request, passport);
        return response;
    }


    /**
     * 模糊查询物料图片表
     *
     * @param request  模糊查询物料图片表请求
     * @param passport 用户护照
     * @return 模糊查询物料图片表应答
     */
    @Override
    public ItemPictureSearchResponse searchItemPicture(ItemPictureSearchRequest request, Passport passport) {
        ItemPictureSearchResponse response = new ItemPictureSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemPictureManager.search(request, passport);
        return response;
    }

    /**
     * 高级查询物料图片表
     *
     * @param request  高级查询物料图片表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public ItemPictureFindResponse findItemPicture(ItemPictureFindRequest request, Passport passport) {
        ItemPictureFindResponse response = new ItemPictureFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemPictureManager.find(request, passport);
        return response;
    }

    /**
     * 获取所有物料图片表列表
     *
     * @param request  获取所有物料图片表列表请求
     * @param passport 用户护照
     * @return 获取所有物料图片表列表应答
     */
    @Override
    public ItemPictureGetAllListResponse getItemPictureAllList(ItemPictureGetAllListRequest request, Passport passport) {
        ItemPictureGetAllListResponse response = new ItemPictureGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemPictureManager.getAllList(request, passport);
        return response;
    }


    /**
     * 创建物料图片表
     *
     * @param request  创建物料图片表请求
     * @param passport 用户护照
     * @return 创建物料图片表应答
     */
    @Override
    public ItemPictureCreateResponse createItemPicture(ItemPictureCreateRequest request, Passport passport) {
        ItemPictureCreateResponse response = new ItemPictureCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemPictureManager.create(request, passport);
        return response;
    }


    /**
     * 更新物料图片表
     *
     * @param request  更新物料图片表请求
     * @param passport 用户护照
     * @return 更新物料图片表应答
     */
    @Override
    public ItemPictureUpdateResponse updateItemPicture(ItemPictureUpdateRequest request, Passport passport) {
        ItemPictureUpdateResponse response = new ItemPictureUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemPictureManager.update(request, passport);
        return response;
    }


    /**
     * 删除物料图片表
     *
     * @param request  删除物料图片表请求
     * @param passport 用户护照
     * @return 删除物料图片表应答
     */
    @Override
    public ItemPictureDeleteResponse deleteItemPicture(ItemPictureDeleteRequest request, Passport passport) {
        ItemPictureDeleteResponse response = new ItemPictureDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemPictureManager.delete(request, passport);
        return response;
    }


    /**
     * 导入物料图片表
     *
     * @param request  导入物料图片表请求
     * @param passport 用户护照
     * @return 导入物料图片表应答
     */
    @Override
    public ItemPictureListImportResponse importItemPictureList(ItemPictureListImportRequest request, Passport passport) {
        ItemPictureListImportResponse response = new ItemPictureListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemPictureManager.importList(request, passport);
        return response;
    }

    /**
     * 根据Id获取物料表
     *
     * @param request  获取物料表请求
     * @param passport 用户护照
     * @return 获取物料表应答
     */
    @Override
    public ItemGetResponse getItem(ItemGetRequest request, Passport passport) {
        ItemGetResponse response = new ItemGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.get(request, passport);
        return response;
    }


    /**
     * 模糊查询物料表
     *
     * @param request  模糊查询物料表请求
     * @param passport 用户护照
     * @return 模糊查询物料表应答
     */
    @Override
    public ItemSearchResponse searchItem(ItemSearchRequest request, Passport passport) {
        ItemSearchResponse response = new ItemSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.search(request, passport);
        return response;
    }

    /**
     * 高级查询物料表
     *
     * @param request  高级查询物料表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public ItemFindResponse findItem(ItemFindRequest request, Passport passport) {
        ItemFindResponse response = new ItemFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.find(request, passport);
        return response;
    }

    /**
     * 获取所有物料表列表
     *
     * @param request  获取所有物料表列表请求
     * @param passport 用户护照
     * @return 获取所有物料表列表应答
     */
    @Override
    public ItemGetAllListResponse getItemAllList(ItemGetAllListRequest request, Passport passport) {
        ItemGetAllListResponse response = new ItemGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.getAllList(request, passport);
        return response;
    }


    /**
     * 创建物料表
     *
     * @param request  创建物料表请求
     * @param passport 用户护照
     * @return 创建物料表应答
     */
    @Override
    public ItemCreateResponse createItem(ItemCreateRequest request, Passport passport) {
        ItemCreateResponse response = new ItemCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.create(request, passport);
        return response;
    }


    /**
     * 更新物料表
     *
     * @param request  更新物料表请求
     * @param passport 用户护照
     * @return 更新物料表应答
     */
    @Override
    public ItemUpdateResponse updateItem(ItemUpdateRequest request, Passport passport) {
        ItemUpdateResponse response = new ItemUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.update(request, passport);
        return response;
    }


    /**
     * 删除物料表
     *
     * @param request  删除物料表请求
     * @param passport 用户护照
     * @return 删除物料表应答
     */
    @Override
    public ItemDeleteResponse deleteItem(ItemDeleteRequest request, Passport passport) {
        ItemDeleteResponse response = new ItemDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.delete(request, passport);
        return response;
    }


    /**
     * 作废物料表
     *
     * @param request  作废物料表请求
     * @param passport 用户护照
     * @return 作废物料表应答
     */
    @Override
    public ItemInactiveResponse inactiveItem(ItemInactiveRequest request, Passport passport) {
        ItemInactiveResponse response = new ItemInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.inactive(request, passport);
        return response;
    }


    /**
     * 激活物料表
     *
     * @param request  激活物料表请求
     * @param passport 用户护照
     * @return 激活物料表应答
     */
    @Override
    public ItemActiveResponse activeItem(ItemActiveRequest request, Passport passport) {
        ItemActiveResponse response = new ItemActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.active(request, passport);
        return response;
    }


    /**
     * 导入物料表
     *
     * @param request  导入物料表请求
     * @param passport 用户护照
     * @return 导入物料表应答
     */
    @Override
    public ItemListImportResponse importItemList(ItemListImportRequest request, Passport passport) {
        ItemListImportResponse response = new ItemListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.importList(request, passport);
        return response;
    }

    @Override
    public ItemApproveResponse approve(ItemApproveRequest request, Passport passport) {
        ItemApproveResponse response = new ItemApproveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.approve(request, passport);
        return response;
    }

    @Override
    public ItemCancelResponse cancel(ItemCancelRequest request, Passport passport) {
        ItemCancelResponse response = new ItemCancelResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.cancel(request, passport);
        return response;
    }

    @Override
    public ItemCollectionResponse clickCollection(ItemCollectionRequest request, Passport passport) {
        ItemCollectionResponse response = new ItemCollectionResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = itemManager.clickCollection(request, passport);
        return response;
    }

    @Override
    public ClazzCreateListResponse createList(ClazzCreateListRequest request, Passport passport) {
        ClazzCreateListResponse response = new ClazzCreateListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = clazzManager.createList(request, passport);
        return response;
    }

    @Override
    public ItemPictureUploadResponse uploadAttachment(ItemPictureUploadRequest req, Passport passport) {
        return itemPictureManager.uploadAttachment(req,passport);
    }

    @Override
    public ItemChangeOrderResponse changeOrder(ItemChangeOrderRequest request, Passport passport) {
        return itemManager.changeOrder(request,passport);
    }
}