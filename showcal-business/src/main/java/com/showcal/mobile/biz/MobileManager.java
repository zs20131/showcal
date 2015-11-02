package com.showcal.mobile.biz;

import com.showcal.mobile.request.OftenFoodGetForMyRequest;
import com.showcal.mobile.request.ShowCalQueryRequest;
import com.showcal.mobile.request.ShowCalSelectedRequest;
import com.showcal.mobile.request.ShowcalGetRequest;
import com.showcal.mobile.response.OftenFoodGetForMyResponse;
import com.showcal.mobile.response.ShowCalGetResponse;
import com.showcal.mobile.response.ShowCalQueryResponse;
import com.showcal.mobile.response.ShowCalSelectedResponse;
import com.showcal.platform.request.IntegralDetailCreateRequest;
import com.showcal.platform.response.IntegralDetailCreateResponse;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.service.response.ShowCalGetForMyResponse;
import com.xiniunet.framework.security.Passport;

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
public interface MobileManager {
    /**
     * 获取瘦咖详细信息
     *
     * @param request
     * @param passport
     * @return
     */
    ShowCalGetResponse getShowcal(ShowcalGetRequest request, Passport passport);

    /**
     * 选择瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    ShowCalSelectedResponse selectShowcal(ShowCalSelectedRequest request, Passport passport);

    /**
     * 获取我当前的瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    ShowCalGetForMyResponse getMyShowcal(ShowCalGetForMyRequest request, Passport passport);

    /**
     * 获取我常吃的食物
     *
     * @param request
     * @param passport
     * @return
     */
    OftenFoodGetForMyResponse getMyOftenFood(OftenFoodGetForMyRequest request, Passport passport);

    /**
     * 查询瘦咖信息
     *
     * @param request
     * @param passport
     * @return
     */
    ShowCalQueryResponse queryShowCal(ShowCalQueryRequest request, Passport passport);


    /**
     * 增加积分
     *
     * @param request
     * @param passport
     * @return
     */
    IntegralDetailCreateResponse create(IntegralDetailCreateRequest request, Passport passport);
}
