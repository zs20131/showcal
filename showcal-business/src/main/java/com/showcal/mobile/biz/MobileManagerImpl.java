package com.showcal.mobile.biz;

import com.showcal.mobile.request.OftenFoodGetForMyRequest;
import com.showcal.mobile.request.ShowCalQueryRequest;
import com.showcal.mobile.request.ShowCalSelectedRequest;
import com.showcal.mobile.request.ShowcalGetRequest;
import com.showcal.mobile.response.OftenFoodGetForMyResponse;
import com.showcal.mobile.response.ShowCalGetResponse;
import com.showcal.mobile.response.ShowCalQueryResponse;
import com.showcal.mobile.response.ShowCalSelectedResponse;
import com.showcal.platform.biz.IntegralDetailManager;
import com.showcal.platform.biz.SysUserManager;
import com.showcal.platform.request.IntegralDetailCreateRequest;
import com.showcal.platform.response.IntegralDetailCreateResponse;
import com.showcal.service.biz.ServiceUserManager;
import com.showcal.service.request.ServiceUserCreateRequest;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.service.response.ServiceUserCreateResponse;
import com.showcal.service.response.ShowCalGetForMyResponse;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.mobile.biz
 *  Description:
 * ***************************************************************
 *  9/25 0025  V1.0  xiniu    New Files for com.showcal.mobile.biz
 * </pre>
 */
public class MobileManagerImpl implements MobileManager {
    @Autowired
    private SysUserManager userManager;
    @Autowired
    private ServiceUserManager serviceUserManager;
    @Autowired
    private IntegralDetailManager integralDetailManager;


    /**
     * 获取瘦咖详细信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalGetResponse getShowcal(ShowcalGetRequest request, Passport passport) {
        return userManager.getShowCalInfo(request,passport);
    }

    /**
     * 选择某一个瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalSelectedResponse selectShowcal(ShowCalSelectedRequest request, Passport passport) {
        ServiceUserCreateRequest createRequest = new ServiceUserCreateRequest();
        createRequest.setUserId(passport.getUserId());
        createRequest.setServiceId(request.getShowCalId());
        ServiceUserCreateResponse createResponse =  serviceUserManager.create(createRequest,passport);
        ShowCalSelectedResponse response = new ShowCalSelectedResponse();
        response.setResult(createResponse.getId());
        response.addErrors(createResponse.getErrors());
        return response;
    }

    /**
     * 获取当前服务我的瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalGetForMyResponse getMyShowcal(ShowCalGetForMyRequest request, Passport passport) {
        return serviceUserManager.getMyShowCal(request,passport);
    }

    /**
     * 获取我常吃的食物
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public OftenFoodGetForMyResponse getMyOftenFood(OftenFoodGetForMyRequest request, Passport passport) {
        return null;
    }

    /**
     * 查询所有瘦咖信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalQueryResponse queryShowCal(ShowCalQueryRequest request, Passport passport) {
        return userManager.queryShowCalInfo(request,passport);
    }

    /**
     * 增加积分
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public IntegralDetailCreateResponse create(IntegralDetailCreateRequest request, Passport passport) {
        return integralDetailManager.create(request,passport);
    }
}
