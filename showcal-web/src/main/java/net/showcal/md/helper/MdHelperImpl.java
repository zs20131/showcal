package net.showcal.md.helper;

import com.showcal.cms.request.*;
import com.showcal.cms.response.*;
import com.showcal.cms.service.CMSService;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;
import com.showcal.merchandise.service.MerchandiseService;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.cms.helper.CmsHelperImpl
 *  Description: cms Helper 实现类
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
@Component
public class MdHelperImpl implements MdHelper {
    @Autowired
    private MerchandiseService merchandiseService;

    @Override
    public ItemCreateResponse createItem(ItemCreateRequest request, Passport passport) {
        return merchandiseService.createItem(request,passport);
    }

    @Override
    public ItemFindResponse findItem(ItemFindRequest request, Passport passport) {
        return merchandiseService.findItem(request,passport);
    }

    @Override
    public ItemApproveResponse approve(ItemApproveRequest request, Passport passport) {
        return merchandiseService.approve(request,passport);
    }

    @Override
    public ItemCancelResponse cancel(ItemCancelRequest request, Passport passport) {
        return merchandiseService.cancel(request,passport);
    }

    @Override
    public ItemUpdateResponse updateItem(ItemUpdateRequest request, Passport passport) {
        return merchandiseService.updateItem(request,passport);
    }

    @Override
    public ItemGetResponse getItem(ItemGetRequest request, Passport passport) {
        return merchandiseService.getItem(request,passport);
    }

    @Override
    public ItemDeleteResponse deleteItem(ItemDeleteRequest request, Passport passport) {
        return merchandiseService.deleteItem(request,passport);
    }

    @Override
    public ClazzCreateResponse createClazz(ClazzCreateRequest request, Passport passport) {
        return merchandiseService.createClazz(request,passport);
    }

    @Override
    public ClazzFindResponse findClazz(ClazzFindRequest request, Passport passport) {
        return merchandiseService.findClazz(request,passport);
    }

    @Override
    public ItemCollectionResponse clickCollection(ItemCollectionRequest request, Passport passport) {
        return merchandiseService.clickCollection(request,passport);
    }

    @Override
    public ClazzCreateListResponse createList(ClazzCreateListRequest request, Passport passport) {
        return merchandiseService.createList(request,passport);
    }

    @Override
    public ClazzUpdateResponse updateClazz(ClazzUpdateRequest request, Passport passport) {
        return merchandiseService.updateClazz(request,passport);
    }

    @Override
    public ClazzDeleteResponse deleteClazz(ClazzDeleteRequest request, Passport passport) {
        return merchandiseService.deleteClazz(request,passport);
    }

    @Override
    public ItemChangeOrderResponse changeOrder(ItemChangeOrderRequest request, Passport passport) {
        return merchandiseService.changeOrder(request,passport);
    }
}