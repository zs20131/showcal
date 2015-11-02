package com.showcal.platform.svc;

import com.showcal.platform.biz.*;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.showcal.platform.service.PlatformService;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.platfrom.svc
 *  Description:
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.platfrom.svc
 * </pre>
 */
public class PlatformServiceImpl implements PlatformService {
    //系统用户
    @Autowired
    private SysUserManager sysUserManager;
    //系统用户扩展
    @Autowired
    private SysUserExtentManager sysUserExtentManager;
    @Autowired
    private CommentPostManager commentPostManager;
    //验证码
    @Autowired
    private VerificationManager verificationManager;
    //用户护照
    @Autowired
    private PassportManager passportManager;
    //疾病特殊情况设置
    @Autowired
    private SettingDiseaseManager settingDiseaseManager;
    //关键字设置
    @Autowired
    private SettingKeywordManager settingKeywordManager;
    //问题标签设置
    @Autowired
    private SettingQuestionTagManager settingQuestionTagManager;
    //用户标签设置
    @Autowired
    private SettingUserTagManager settingUserTagManager;
    //用户曲线变化设置
    @Autowired
    private SysUserCurveManager sysUserCurveManager;
    //用户积分规则
    @Autowired
    private IntegralRuleManager integralRuleManager;
    //积分明细维护
    @Autowired
    private IntegralDetailManager integralDetailManager;
    //同步SQL
    @Autowired
    private SyncSqlManager syncSqlManager;
    @Autowired
    private SysUserPasswordManager sysUserPasswordManager;

    // 用户贴标签
    @Autowired
    private SysUserTagsManager sysUserTagsManager;

    @Autowired
    private SysMessageManager sysMessageManager;

    @Override
    public SysUserGetResponse getSysUser(SysUserGetRequest request, Passport passport) {
        SysUserGetResponse response = new SysUserGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.get(request, passport);
    }

    @Override
    public SysUserSearchResponse searchSysUser(SysUserSearchRequest request, Passport passport) {
        SysUserSearchResponse response = new SysUserSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.search(request, passport);
    }

    @Override
    public SysUserFindResponse findSysUser(SysUserFindRequest request, Passport passport) {
        SysUserFindResponse response = new SysUserFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.find(request, passport);
    }

    @Override
    public SysUserCreateResponse createSysUser(SysUserCreateRequest request, Passport passport) {
        SysUserCreateResponse response = new SysUserCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.create(request, passport);
    }

    @Override
    public SysUserUpdateResponse updateSysUser(SysUserUpdateRequest request, Passport passport) {
        SysUserUpdateResponse response = new SysUserUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.update(request, passport);
    }

    @Override
    public SysUserUpDownResponse upSysUser(SysUserUpDownRequest request, Passport passport) {
        SysUserUpDownResponse response = new SysUserUpDownResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.up(request, passport);
    }

    @Override
    public SysUserUpDownResponse downSysUser(SysUserUpDownRequest request, Passport passport) {
        SysUserUpDownResponse response = new SysUserUpDownResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.down(request, passport);
    }

    @Override
    public SysUserBanResponse banSysUser(SysUserBanRequest request, Passport passport) {
        SysUserBanResponse response = new SysUserBanResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.ban(request, passport);
    }

    @Override
    public SysUserInbanResponse inbanSysUser(SysUserInbanRequest request, Passport passport) {
        SysUserInbanResponse response = new SysUserInbanResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.inban(request, passport);
    }

    @Override
    public SysUserDeleteResponse deleteSysUser(SysUserDeleteRequest request, Passport passport) {
        SysUserDeleteResponse response = new SysUserDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.delete(request, passport);
    }

    @Override
    public SysUserExtentGetResponse getSysUserExtent(SysUserExtentGetRequest request, Passport passport) {
        SysUserExtentGetResponse response = new SysUserExtentGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserExtentManager.get(request, passport);
    }

    @Override
    public SysUserExtentUpdateResponse updateSysUserExtent(SysUserExtentUpdateRequest request, Passport passport) {
        SysUserExtentUpdateResponse response = new SysUserExtentUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserExtentManager.update(request, passport);
    }

    @Override
    public UserAvatarUpdateResponse updateUserAvatar(UserAvatarUpdateRequest request, Passport passport) {
        UserAvatarUpdateResponse response = new UserAvatarUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.updateAvatar(request, passport);
    }

    @Override
    public UserSearchBySourceTypeResponse searchBySourceType(UserSearchBySourceTypeRequest request, Passport passport) {
        UserSearchBySourceTypeResponse response = new UserSearchBySourceTypeResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.searchBySourceType(request, passport);
    }

    @Override
    public UserInactiveResponse inactiveUser(UserInactiveRequest request, Passport passport) {
        UserInactiveResponse response = new UserInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.inActive(request, passport);
    }

    @Override
    public UserActiveResponse activeUser(UserActiveRequest request, Passport passport) {
        UserActiveResponse response = new UserActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.active(request, passport);
    }

    @Override
    public UserExistByOpenIdResponse userExistByOpenId(UserExistByOpenIdRequest request, Passport passport) {
        UserExistByOpenIdResponse response = new UserExistByOpenIdResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.existByOpenId(request,passport);
    }

    @Override
    public LoginByOpenIdResponse LoginByOpenId(LoginByOpenIdRequest request, Passport passport) {
        LoginByOpenIdResponse response = new LoginByOpenIdResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.loginByOpenId(request,passport);
    }

    @Override
    public SysUserTagsCreateResponse createSysUserTag(SysUserTagsCreateRequest request, Passport passport) {
        SysUserTagsCreateResponse response = new SysUserTagsCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserTagsManager.create(request, passport);
    }

    @Override
    public UserExistByMobilePhoneResponse userExistByMobilePhone(UserExistByMobileRequest request, Passport passport) {
        UserExistByMobilePhoneResponse response = new UserExistByMobilePhoneResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.existByMobilePhone(request, passport);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserPasswordManager.login(request);
    }

    @Override
    public LoginPasswordIsResetableResponse isResetableLoginPassword(LoginPasswordIsResetableRequest request, Passport passport) {
        LoginPasswordIsResetableResponse response = new LoginPasswordIsResetableResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.isResetablePassword(request, passport);
    }

    @Override
    public SysUserPasswordUpdateResponse modifyLoginPassword(LoginPasswordModifyRequest request, Passport passport) {
        SysUserPasswordUpdateResponse response = new SysUserPasswordUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserPasswordManager.update(request, passport);
    }

    @Override
    public SysUserPasswordUpdateResponse modifyLoginPasswordCheck(LoginPasswordModifyRequest request, Passport passport) {
        SysUserPasswordUpdateResponse response = new SysUserPasswordUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserPasswordManager.updateCheck(request, passport);
    }

    @Override
    public LoginPasswordResetResponse resetUserLoginPassword(LoginPasswordResetRequest request, Passport passport) {
        LoginPasswordResetResponse response = new LoginPasswordResetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserManager.resetPassword(request, passport);
    }

    @Override
    public VerificationCodeCreateResponse createVerificationCode(VerificationCodeCreateRequest request) {
        VerificationCodeCreateResponse response = new VerificationCodeCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return verificationManager.createCode(request);
    }

    @Override
    public VerificationCheckResponse checkValification(VerificationCheckRequest request) {
        VerificationCheckResponse response = new VerificationCheckResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return verificationManager.check(request);
    }

    @Override
    public PassportGetResponse getPassport(PassportGetRequest request) {
        PassportGetResponse response = new PassportGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return passportManager.get(request);
    }

    @Override
    public SettingDiseaseGetAllListResponse getSettingDiseaseAllList(SettingDiseaseGetAllListRequest request, Passport passport) {
        SettingDiseaseGetAllListResponse response = new SettingDiseaseGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingDiseaseManager.getAllList(request, passport);
    }

    @Override
    public SettingDiseaseCreateResponse createSettingDisease(SettingDiseaseCreateRequest request, Passport passport) {
        SettingDiseaseCreateResponse response = new SettingDiseaseCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingDiseaseManager.create(request, passport);
    }

    @Override
    public SettingDiseaseUpdateResponse updateSettingDisease(SettingDiseaseUpdateRequest request, Passport passport) {
        SettingDiseaseUpdateResponse response = new SettingDiseaseUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingDiseaseManager.update(request, passport);
    }

    @Override
    public SettingDiseaseDeleteResponse deleteSettingDisease(SettingDiseaseDeleteRequest request, Passport passport) {
        SettingDiseaseDeleteResponse response = new SettingDiseaseDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingDiseaseManager.delete(request, passport);
    }

    @Override
    public SettingDiseaseInactiveResponse inactiveSettingDisease(SettingDiseaseInactiveRequest request, Passport passport) {
        SettingDiseaseInactiveResponse response = new SettingDiseaseInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingDiseaseManager.inactive(request, passport);
    }

    @Override
    public SettingDiseaseActiveResponse activeSettingDisease(SettingDiseaseActiveRequest request, Passport passport) {
        SettingDiseaseActiveResponse response = new SettingDiseaseActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingDiseaseManager.active(request, passport);
    }

    @Override
    public SettingKeywordGetAllListResponse getSettingKeywordAllList(SettingKeywordGetAllListRequest request, Passport passport) {
        SettingKeywordGetAllListResponse response = new SettingKeywordGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingKeywordManager.getAllList(request, passport);
    }

    @Override
    public SettingKeywordCreateResponse createSettingKeyword(SettingKeywordCreateRequest request, Passport passport) {
        SettingKeywordCreateResponse response = new SettingKeywordCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingKeywordManager.create(request, passport);
    }

    @Override
    public SettingKeywordUpdateResponse updateSettingKeyword(SettingKeywordUpdateRequest request, Passport passport) {
        SettingKeywordUpdateResponse response = new SettingKeywordUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingKeywordManager.update(request, passport);
    }

    @Override
    public SettingKeywordDeleteResponse deleteSettingKeyword(SettingKeywordDeleteRequest request, Passport passport) {
        SettingKeywordDeleteResponse response = new SettingKeywordDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingKeywordManager.delete(request, passport);
    }

    @Override
    public SettingKeywordInactiveResponse inactiveSettingKeyword(SettingKeywordInactiveRequest request, Passport passport) {
        SettingKeywordInactiveResponse response = new SettingKeywordInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingKeywordManager.inactive(request, passport);
    }

    @Override
    public SettingKeywordActiveResponse activeSettingKeyword(SettingKeywordActiveRequest request, Passport passport) {
        SettingKeywordActiveResponse response = new SettingKeywordActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingKeywordManager.active(request, passport);
    }

    @Override
    public SettingQuestionTagGetAllListResponse getSettingQuestionTagAllList(SettingQuestionTagGetAllListRequest request, Passport passport) {
        SettingQuestionTagGetAllListResponse response = new SettingQuestionTagGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingQuestionTagManager.getAllList(request, passport);
    }

    @Override
    public SettingQuestionTagCreateResponse createSettingQuestionTag(SettingQuestionTagCreateRequest request, Passport passport) {
        SettingQuestionTagCreateResponse response = new SettingQuestionTagCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingQuestionTagManager.create(request, passport);
    }

    @Override
    public SettingQuestionTagUpdateResponse updateSettingQuestionTag(SettingQuestionTagUpdateRequest request, Passport passport) {
        SettingQuestionTagUpdateResponse response = new SettingQuestionTagUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingQuestionTagManager.update(request, passport);
    }

    @Override
    public SettingQuestionTagDeleteResponse deleteSettingQuestionTag(SettingQuestionTagDeleteRequest request, Passport passport) {
        SettingQuestionTagDeleteResponse response = new SettingQuestionTagDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingQuestionTagManager.delete(request, passport);
    }

    @Override
    public SettingQuestionTagInactiveResponse inactiveSettingQuestionTag(SettingQuestionTagInactiveRequest request, Passport passport) {
        SettingQuestionTagInactiveResponse response = new SettingQuestionTagInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingQuestionTagManager.inactive(request, passport);
    }

    @Override
    public SettingUserTagFindResponse findSettingUserTag(SettingUserTagFindRequest request, Passport passport) {
        SettingUserTagFindResponse response = new SettingUserTagFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingUserTagManager.find(request, passport);
    }

    @Override
    public SettingUserTagGetAllListResponse getSettingUserTagAllList(SettingUserTagGetAllListRequest request, Passport passport) {
        SettingUserTagGetAllListResponse response = new SettingUserTagGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingUserTagManager.getAllList(request, passport);
    }

    @Override
    public SettingUserTagCreateResponse createSettingUserTag(SettingUserTagCreateRequest request, Passport passport) {
        SettingUserTagCreateResponse response = new SettingUserTagCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingUserTagManager.create(request, passport);
    }

    @Override
    public SettingUserTagUpdateResponse updateSettingUserTag(SettingUserTagUpdateRequest request, Passport passport) {
        SettingUserTagUpdateResponse response = new SettingUserTagUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingUserTagManager.update(request, passport);
    }

    @Override
    public SettingUserTagDeleteResponse deleteSettingUserTag(SettingUserTagDeleteRequest request, Passport passport) {
        SettingUserTagDeleteResponse response = new SettingUserTagDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingUserTagManager.delete(request, passport);
    }

    @Override
    public SettingUserTagInactiveResponse inactiveSettingUserTag(SettingUserTagInactiveRequest request, Passport passport) {
        SettingUserTagInactiveResponse response = new SettingUserTagInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingUserTagManager.inactive(request, passport);
    }

    @Override
    public SettingUserTagActiveResponse activeSettingUserTag(SettingUserTagActiveRequest request, Passport passport) {
        SettingUserTagActiveResponse response = new SettingUserTagActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingUserTagManager.active(request, passport);
    }

    @Override
    public SysUserCurveFindResponse findSysUserCurve(SysUserCurveFindRequest request, Passport passport) {
        SysUserCurveFindResponse response = new SysUserCurveFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserCurveManager.find(request, passport);
    }

    @Override
    public SysUserCurveGetAllListByUserResponse getSysUserCurveAllListbyUser(SysUserCurveGetAllListByUserRequest request, Passport passport) {
        SysUserCurveGetAllListByUserResponse response = new SysUserCurveGetAllListByUserResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserCurveManager.getAllListByUser(request, passport);
    }

    @Override
    public SysUserCurveCreateResponse createSysUserCurve(SysUserCurveCreateRequest request, Passport passport) {
        SysUserCurveCreateResponse response = new SysUserCurveCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserCurveManager.create(request, passport);
    }

    @Override
    public SysUserCurveDeleteResponse deleteSysUserCurve(SysUserCurveDeleteRequest request, Passport passport) {
        SysUserCurveDeleteResponse response = new SysUserCurveDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserCurveManager.delete(request, passport);
    }

    @Override
    public SysUserCurveDeleteByConditionResponse deleteSysUserCurveByCondition(SysUserCurveDeleteByConditionRequest request, Passport passport) {
        SysUserCurveDeleteByConditionResponse response = new SysUserCurveDeleteByConditionResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserCurveManager.deleteByCondition(request, passport);
    }

    /**
     *  根据用户等条件查询该用户年度的身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public SysUserCurveGetYearListByUserResponse getSysUserCurveYearListByUser(SysUserCurveGetYearListByUserRequest request, Passport passport) {
        SysUserCurveGetYearListByUserResponse response = new SysUserCurveGetYearListByUserResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserCurveManager.getYearListByUser(request, passport);
    }

    @Override
    public SysUserCurveGetMonthListByUserResponse getSysUserCurveMonthListByUser(SysUserCurveGetMonthListByUserRequest request, Passport passport) {
        SysUserCurveGetMonthListByUserResponse response = new SysUserCurveGetMonthListByUserResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserCurveManager.getMonthListByUser(request, passport);
    }

    @Override
    public SysUserCurveGetWeekListByUserResponse getSysUserCurveWeekListByUser(SysUserCurveGetWeekListByUserRequest request, Passport passport) {
        SysUserCurveGetWeekListByUserResponse response = new SysUserCurveGetWeekListByUserResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sysUserCurveManager.getWeekListByUser(request, passport);
    }

    @Override
    public IntegralRuleCreateResponse createIntegralRule(IntegralRuleCreateRequest request, Passport passport) {
        IntegralRuleCreateResponse response = new IntegralRuleCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return integralRuleManager.create(request, passport);
    }

    @Override
    public IntegralRuleUpdateResponse updateIntegralRule(IntegralRuleUpdateRequest request, Passport passport) {
        IntegralRuleUpdateResponse response = new IntegralRuleUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return integralRuleManager.update(request, passport);
    }

    @Override
    public IntegralRuleGetAllListResponse getIntegralRuleAllList(IntegralRuleGetAllListRequest request, Passport passport) {
        IntegralRuleGetAllListResponse response = new IntegralRuleGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return integralRuleManager.getAllList(request, passport);
    }

    @Override
    public IntegralRuleDeleteResponse deleteIntegralRule(IntegralRuleDeleteRequest request, Passport passport) {
        IntegralRuleDeleteResponse response = new IntegralRuleDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return integralRuleManager.delete(request, passport);
    }

    @Override
    public IntegralDetailCreateResponse createIntegralDetail(IntegralDetailCreateRequest request, Passport passport) {
        IntegralDetailCreateResponse response = new IntegralDetailCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return integralDetailManager.create(request, passport);
    }

    @Override
    public IntegralDetailFindResponse findIntegralDetail(IntegralDetailFindRequest request, Passport passport) {
        IntegralDetailFindResponse response = new IntegralDetailFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return integralDetailManager.find(request, passport);
    }

    @Override
    public IntegralDetailGetForMyResponse getMyIntegralDetail(IntegralDetailGetForMyRequest request, Passport passport) {
        IntegralDetailGetForMyResponse response = new IntegralDetailGetForMyResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return integralDetailManager.getMyDetail(request, passport);
    }

    @Override
    public SyncSqlCreateResponse createSyncSql(SyncSqlCreateRequest request, Passport passport) {
        SyncSqlCreateResponse response = new SyncSqlCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSqlManager.create(request, passport);
    }

    @Override
    public SyncSqlIncrementResponse getSyncIncrementSql(SyncSqlIncrementRequest request, Passport passport) {
        SyncSqlIncrementResponse response = new SyncSqlIncrementResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSqlManager.syncIncrement(request, passport);
    }

    @Override
    public CommentPostCreateResponse createCommentPost(CommentPostCreateRequest request, Passport passport) {
        return commentPostManager.create(request, passport);
    }

    @Override
    public CommentPostDeleteResponse deleteCommentPost(CommentPostDeleteRequest request, Passport passport) {
        return commentPostManager.delete(request, passport);
    }

    @Override
    public CommentPostDeleteBatchResponse deleteBatchCommentPost(CommentPostDeleteBatchRequest request, Passport passport) {
        return commentPostManager.deleteBatch(request, passport);
    }

    @Override
    public CommentPostFindResponse findCommentPost(CommentPostFindRequest request, Passport passport) {
        return commentPostManager.find(request, passport);
    }

    @Override
    public SysMessageFindResponse find(SysMessageFindRequest request, Passport passport) {
        SysMessageFindResponse response = new SysMessageFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }

        return sysMessageManager.find(request,passport);
    }

    @Override
    public SysMessageUpdateResponse update(SysMessageUpdateRequest request, Passport passport) {
        SysMessageUpdateResponse response = new SysMessageUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }

        return sysMessageManager.update(request, passport);
    }

    @Override
    public SysMessageGetResponse get(SysMessageGetRequest request, Passport passport) {
        SysMessageGetResponse response = new SysMessageGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }

        return sysMessageManager.get(request, passport);
    }

    @Override
    public SysMessageCreateListResponse create(SysMessageCreateListRequest request, Passport passport) {
        SysMessageCreateListResponse response = new SysMessageCreateListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }

        return sysMessageManager.createList(request, passport);
    }
    /**
     * 创建评论表
     *
     * @param request 创建评论表请求
     * @param passport 用户护照
     * @return 创建评论表应答
     */
    public  CommentPostCreateListResponse createList(CommentPostCreateListRequest request, Passport passport){
        CommentPostCreateListResponse response = new CommentPostCreateListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }

        return commentPostManager.createList(request, passport);
    }

    @Override
    public IntegralRuleFindResponse find(IntegralRuleFindRequest request, Passport passport) {
        IntegralRuleFindResponse response = new IntegralRuleFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }

        return integralRuleManager.find(request, passport);
    }
}
