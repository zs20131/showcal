package net.showcal.md.helper;

import com.showcal.cms.request.*;
import com.showcal.cms.response.*;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.cms.helper.CmsHelper
 *  Description: cms Helper 接口
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public interface MdHelper {

    /**
     * 创建物料表
     *
     * @param request 创建物料表请求
     * @param passport 用户护照
     * @return 创建物料表应答
     */
    ItemCreateResponse createItem(ItemCreateRequest request, Passport passport);

    /**
     * 高级查询物料表
     *
     * @param request 高级查询物料表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ItemFindResponse findItem(ItemFindRequest request, Passport passport);

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
    /**
     * 更新物料表
     *
     * @param request 更新物料表请求
     * @param passport 用户护照
     * @return 更新物料表应答
     */
    ItemUpdateResponse updateItem(ItemUpdateRequest request, Passport passport);

    /**
     * 根据Id获取物料表
     *
     * @param request 获取物料表请求
     * @param passport 用户护照
     * @return 获取物料表应答
     */
    ItemGetResponse getItem(ItemGetRequest request, Passport passport);

    /**
     * 删除物料表
     *
     * @param request 删除物料表请求
     * @param passport 用户护照
     * @return 删除物料表应答
     */
    ItemDeleteResponse deleteItem(ItemDeleteRequest request, Passport passport);

    /**
     * 创建商品类别
     *
     * @param request 创建商品类别请求
     * @param passport 用户护照
     * @return 创建商品类别应答
     */
    ClazzCreateResponse createClazz(ClazzCreateRequest request, Passport passport);
    /**
     * 高级查询商品类别
     *
     * @param request 高级查询商品类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ClazzFindResponse findClazz(ClazzFindRequest request, Passport passport);

    ItemCollectionResponse clickCollection(ItemCollectionRequest request, Passport passport);
    /**
     * 创建商品类别
     *
     * @param request 创建商品类别请求
     * @param passport 用户护照
     * @return 创建商品类别应答
     */
    ClazzCreateListResponse createList(ClazzCreateListRequest request, Passport passport);
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

    ItemChangeOrderResponse changeOrder(ItemChangeOrderRequest request, Passport passport);
}