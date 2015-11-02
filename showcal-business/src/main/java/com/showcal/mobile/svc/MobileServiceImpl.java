package com.showcal.mobile.svc;

import com.showcal.mobile.biz.MobileManager;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.mobile.request.*;
import com.showcal.mobile.response.*;
import com.showcal.mobile.service.MobileService;
import com.showcal.platform.biz.SyncSqlManager;
import com.showcal.platform.domain.CurveTypeEnum;
import com.showcal.platform.request.*;
import com.showcal.platform.response.MaxSqlVersionGetResponse;
import com.showcal.platform.response.SyncSqlIncrementResponse;
import com.showcal.platform.response.SysUserGetResponse;
import com.showcal.platform.response.UserInfoRecordResponse;
import com.showcal.platform.service.PlatformService;
import com.showcal.service.biz.QuestionManager;
import com.showcal.service.biz.ServiceUserManager;
import com.showcal.service.request.QuestionCreateRequest;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.service.response.QuestionCreateResponse;
import com.showcal.service.response.ShowCalGetForMyResponse;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.mobile.svc
 *  Description:
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.mobile.svc
 * </pre>
 */
public class MobileServiceImpl implements MobileService {
    @Autowired
    private PlatformService platformService;
    @Autowired
    private MobileManager mobileManager;
    @Autowired
    private QuestionManager questionManager;
    @Autowired
    private SyncSqlManager syncSqlManager;
    @Autowired
    private ServiceUserManager serviceUserManager;

    /**
     * 获取增量SQL语句
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public SyncSqlIncrementResponse sysncIncrementSql(SyncSqlIncrementRequest request, Passport passport) {
        SyncSqlIncrementResponse response = new SyncSqlIncrementResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSqlManager.syncIncrement(request, passport);
    }

    /**
     * 获取最大SQL版本号
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public MaxSqlVersionGetResponse getMaxSqlVersion(MaxSqlVersionGetRequest request, Passport passport) {
        return syncSqlManager.getMaxSqlVersion(request, passport);
    }

    /**
     * 获取用户当前的信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public CurrentUserInfoGetResponse getCurrentUserInfo(CurrentUserInfoGetRequest request, Passport passport) {
        CurrentUserInfoGetResponse response = new CurrentUserInfoGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }

        SysUserGetRequest getRequest = new SysUserGetRequest();
        getRequest.setId(passport.getUserId());
        SysUserGetResponse getResponse = platformService.getSysUser(getRequest, passport);
        UserInfo userInfo = getResponse.getSysUser();
        // 查询对应的瘦咖ID
        Long showCalId = serviceUserManager.getMyShowCalId(passport.getUserId());
        userInfo.setShowCalId(showCalId);
        response.setUserInfo(userInfo);
        return response;
    }

    /**
     * 获取瘦咖详细信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalGetResponse getShowCal(ShowcalGetRequest request, Passport passport) {
        ShowCalGetResponse response = new ShowCalGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return mobileManager.getShowcal(request, passport);
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
        return mobileManager.queryShowCal(request, passport);
    }

    /**
     * 选择瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalSelectedResponse selectedShowCal(ShowCalSelectedRequest request, Passport passport) {
        ShowCalSelectedResponse response = new ShowCalSelectedResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return mobileManager.selectShowcal(request, passport);
    }

    /**
     * 获取我的瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalGetForMyResponse getMyShowCal(ShowCalGetForMyRequest request, Passport passport) {
        ShowCalGetForMyResponse response = new ShowCalGetForMyResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return mobileManager.getMyShowcal(request, passport);
    }

    /**
     * 获取我经常吃的食物
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public OftenFoodGetForMyResponse getMyOftenFood(OftenFoodGetForMyRequest request, Passport passport) {
        OftenFoodGetForMyResponse response = new OftenFoodGetForMyResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return mobileManager.getMyOftenFood(request, passport);
    }

    /**
     * 记录用户身体变化记录
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public UserCurveRecordResponse recordUserCurve(UserCurveRecordRequest request, Passport passport) {
        return null;
    }

    /**
     * 发表文章
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ArticlePostResponse postArticle(ArticlePostRequest request, Passport passport) {
        return null;
    }

    /**
     * 设置用户生理期信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public PeriodSetResponse setPeriod(PeriodSetRequest request, Passport passport) {
        return null;
    }

    /**
     * 用户用户生理期信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public PeriodGetResponse getPeriod(PeriodGetRequest request, Passport passport) {
        return null;
    }

    /**
     * 发送消息
     *
     * @param request  创建问题请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public QuestionCreateResponse sendQuestion(QuestionCreateRequest request, Passport passport) {
        QuestionCreateResponse response = new QuestionCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return questionManager.send(request, passport);
    }

    /**
     * 记录用户基本信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public UserInfoRecordResponse recordUserInfo(UserInfoRecordRequest request, Passport passport) {
        UserInfoRecordResponse response = new UserInfoRecordResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        SysUserCurveCreateRequest curveCreateRequest = new SysUserCurveCreateRequest();
        curveCreateRequest.setUserId(request.getUserId());
        SysUserExtentUpdateRequest extentUpdateRequest = new SysUserExtentUpdateRequest();
        extentUpdateRequest.setId(request.getUserId());
        // 身高不为空
        if (request.getHeight() != null && request.getHeight() > 0) {
            curveCreateRequest.setType(CurveTypeEnum.HEIGHT);
            curveCreateRequest.setValue(Double.valueOf(request.getHeight()));
            platformService.createSysUserCurve(curveCreateRequest, passport);
            extentUpdateRequest.setHeight(request.getHeight());
        }
        // 腰围
        if (request.getWaistLine() != null && request.getWaistLine() > 0) {
            curveCreateRequest.setType(CurveTypeEnum.WAISTLINE);
            curveCreateRequest.setValue(Double.valueOf(request.getWaistLine()));
            platformService.createSysUserCurve(curveCreateRequest, passport);
            extentUpdateRequest.setWaistLine(request.getWaistLine());
        }
        //臀围
        if (request.getHipline() != null && request.getHipline() > 0) {
            curveCreateRequest.setType(CurveTypeEnum.HIPLINE);
            curveCreateRequest.setValue(Double.valueOf(request.getHipline()));
            extentUpdateRequest.setHipline(request.getHipline());
            platformService.createSysUserCurve(curveCreateRequest, passport);
        }
        //体重
        if (request.getWeight() != null && request.getWeight() > 0) {
            curveCreateRequest.setType(CurveTypeEnum.WEIGHT);
            curveCreateRequest.setValue(Double.valueOf(request.getWeight()));
            platformService.createSysUserCurve(curveCreateRequest, passport);
            extentUpdateRequest.setWeight(request.getWeight());
        }

        extentUpdateRequest.setBirthday(request.getBirthday());
        platformService.updateSysUserExtent(extentUpdateRequest, passport);
        // 更新性别
        if (request.getSex() != null) {
            SysUserUpdateRequest userUpdateRequest = new SysUserUpdateRequest();
            userUpdateRequest.setId(request.getUserId());
            userUpdateRequest.setSex(request.getSex());
            platformService.updateSysUser(userUpdateRequest, passport);
        }
        response.setResult(1L);
        return response;
    }
}
