package com.showcal.mobile.service;

import com.showcal.mobile.request.*;
import com.showcal.mobile.response.*;
import com.showcal.platform.request.MaxSqlVersionGetRequest;
import com.showcal.platform.request.SyncSqlIncrementRequest;
import com.showcal.platform.request.UserInfoRecordRequest;
import com.showcal.platform.response.MaxSqlVersionGetResponse;
import com.showcal.platform.response.SyncSqlIncrementResponse;
import com.showcal.platform.response.UserInfoRecordResponse;
import com.showcal.service.request.QuestionCreateRequest;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.service.response.QuestionCreateResponse;
import com.showcal.service.response.ShowCalGetForMyResponse;
import com.xiniunet.framework.security.Passport;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.Mobile
 *  Description:与手机端交互数据
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.Mobile
 * </pre>
 */
public interface MobileService {
    /**
     * 同步增量数据
     *
     * @param syncSqlIncrementRequest
     * @param passport
     * @return
     */
    SyncSqlIncrementResponse sysncIncrementSql(SyncSqlIncrementRequest syncSqlIncrementRequest, Passport passport);

    /**
     * 获取最大版本号
     * @param request
     * @param passport
     * @return
     */
    MaxSqlVersionGetResponse getMaxSqlVersion(MaxSqlVersionGetRequest request,Passport passport);
    /**
     * 获取当前登录人基本信息
     *
     * @param request
     * @param passport
     * @return
     */
    CurrentUserInfoGetResponse getCurrentUserInfo(CurrentUserInfoGetRequest request, Passport passport);

    /**
     * 获取瘦咖信息（手机端选择瘦咖使用）
     *
     * @param request
     * @param passport
     * @return
     */
    ShowCalGetResponse getShowCal(ShowcalGetRequest request, Passport passport);

    /**
     * 查询瘦咖信息
     * @param request
     * @param passport
     * @return
     */
    ShowCalQueryResponse queryShowCal(ShowCalQueryRequest request,Passport passport);

    /**
     * 选择瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    ShowCalSelectedResponse selectedShowCal(ShowCalSelectedRequest request, Passport passport);

    /**
     * 获取我的瘦咖信息
     *
     * @param request
     * @param passport
     * @return
     */
    ShowCalGetForMyResponse getMyShowCal(ShowCalGetForMyRequest request, Passport passport);

    /**
     * 获取我常吃的食物
     *
     * @param request
     * @param passport
     * @return
     */
    OftenFoodGetForMyResponse getMyOftenFood(OftenFoodGetForMyRequest request, Passport passport);

    /**
     * 记录身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    UserCurveRecordResponse recordUserCurve(UserCurveRecordRequest request, Passport passport);

    /**
     * 瘦咖发表文章
     *
     * @param request
     * @param passport
     * @return
     */
    ArticlePostResponse postArticle(ArticlePostRequest request, Passport passport);

    /**
     * 记录生理期
     *
     * @param request
     * @param passport
     * @return
     */
    PeriodSetResponse setPeriod(PeriodSetRequest request, Passport passport);

    /**
     * 获取生理期记录周期
     *
     * @param request
     * @param passport
     * @return
     */
    PeriodGetResponse getPeriod(PeriodGetRequest request, Passport passport);

    /**
     * 发送问题
     *
     * @param request  创建问题请求
     * @param passport 用户护照
     * @return 创建问题应答
     */
    QuestionCreateResponse sendQuestion(QuestionCreateRequest request, Passport passport);

    /**
     * 记录用户基本信息
     *
     * @param request
     * @param passport
     * @return
     */
    public UserInfoRecordResponse recordUserInfo(UserInfoRecordRequest request, Passport passport);
}
