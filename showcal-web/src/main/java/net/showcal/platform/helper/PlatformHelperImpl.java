package net.showcal.platform.helper;

import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.showcal.platform.service.PlatformService;
import com.xiniunet.framework.security.Passport;
import net.showcal.tool.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.platfrom.helper.PlatfromHelperImpl
 *  Description: platfrom Helper 实现类
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
@Component
public class PlatformHelperImpl implements PlatformHelper {
    @Autowired
    private PlatformService platformService;

    /**
     * 根据Id获取用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserGetResponse getSysUser(SysUserGetRequest request, Passport passport) {
        return platformService.getSysUser(request, passport);
    }

    /**
     * 模糊查询用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserSearchResponse searchSysUser(SysUserSearchRequest request, Passport passport) {
        return platformService.searchSysUser(request, passport);
    }

    /**
     * 高级查询用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserFindResponse findSysUser(SysUserFindRequest request, Passport passport) {
        return platformService.findSysUser(request, passport);
    }

    /**
     * 创建用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserCreateResponse createSysUser(SysUserCreateRequest request, Passport passport) {
        return platformService.createSysUser(request, passport);
    }

    /**
     * 更新用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserUpdateResponse updateSysUser(SysUserUpdateRequest request, Passport passport) {
        return platformService.updateSysUser(request, passport);
    }

    /**
     * 升级用户为瘦咖
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserUpDownResponse upSysUser(SysUserUpDownRequest request, Passport passport) {
        return platformService.upSysUser(request, passport);
    }

    /**
     * 降级用户为会员
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserUpDownResponse downSysUser(SysUserUpDownRequest request, Passport passport) {
        return platformService.downSysUser(request, passport);
    }

    /**
     *  禁言用户
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserBanResponse banSysUser(SysUserBanRequest request, Passport passport) {
        return platformService.banSysUser(request, passport);
    }

    /**
     * 取消禁言用户
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserInbanResponse inbanSysUser(SysUserInbanRequest request, Passport passport) {
        return platformService.inbanSysUser(request, passport);
    }

    /**
     * 删除用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserDeleteResponse deleteSysUser(SysUserDeleteRequest request, Passport passport) {
        return platformService.deleteSysUser(request, passport);
    }

    /**
     *  查询用户扩展
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public SysUserExtentGetResponse getSysUserExtent(SysUserExtentGetRequest request, Passport passport) {
        return platformService.getSysUserExtent(request, passport);
    }

    /**
     *  更新用户扩展
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public SysUserExtentUpdateResponse updateSysUserExtent(SysUserExtentUpdateRequest request, Passport passport) {
        return platformService.updateSysUserExtent(request, passport);
    }

    /**
     * 更新用户头像。
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public UserAvatarUpdateResponse updateUserAvatar(UserAvatarUpdateRequest request, Passport passport) {
        return platformService.updateUserAvatar(request, passport);
    }

    /**
     * 通过来源类型模糊查询用户列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public UserSearchBySourceTypeResponse searchBySourceType(UserSearchBySourceTypeRequest request, Passport passport) {
        return platformService.searchBySourceType(request, passport);
    }

    /**
     * 作废用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public UserInactiveResponse inactiveUser(UserInactiveRequest request, Passport passport) {
        return platformService.inactiveUser(request, passport);
    }

    /**
     * 激活用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public UserActiveResponse activeUser(UserActiveRequest request, Passport passport) {
        return platformService.activeUser(request, passport);
    }

    /**
     *  给用户贴标签
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserTagsCreateResponse createSysUserTag(SysUserTagsCreateRequest request, Passport passport) {
        return platformService.createSysUserTag(request, passport);
    }

    /**
     * 用户手机号码是否存在
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public UserExistByMobilePhoneResponse userExistByMobilePhone(UserExistByMobileRequest request, Passport passport) {
        return platformService.userExistByMobilePhone(request, passport);
    }

    /**
     * 登录
     *
     * @param request
     * @return
     */
    @Override
    public LoginResponse login(LoginRequest request) {
        return platformService.login(request);
    }

    /**
     * 检查密码是否需要重置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public LoginPasswordIsResetableResponse isResetableLoginPassword(LoginPasswordIsResetableRequest request, Passport passport) {
        return platformService.isResetableLoginPassword(request, passport);
    }

    /**
     * 更新登录密码
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserPasswordUpdateResponse modifyLoginPassword(LoginPasswordModifyRequest request, Passport passport) {
        return platformService.modifyLoginPassword(request, passport);
    }

    /**
     * 更新登录密码-附加原始密码
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserPasswordUpdateResponse modifyLoginPasswordCheck(LoginPasswordModifyRequest request, Passport passport) {
        return platformService.modifyLoginPasswordCheck(request, passport);
    }

    /**
     * 为一个用户重置登录密码
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public LoginPasswordResetResponse resetUserLoginPassword(LoginPasswordResetRequest request, Passport passport) {
        return platformService.resetUserLoginPassword(request, passport);
    }

    /**
     * 创建验证码
     *
     * @param request
     * @return
     */
    @Override
    public VerificationCodeCreateResponse createVerificationCode(VerificationCodeCreateRequest request) {
        return platformService.createVerificationCode(request);
    }

    /**
     * 验证
     *
     * @param request
     * @return
     */
    @Override
    public VerificationCheckResponse checkValification(VerificationCheckRequest request) {
        return platformService.checkValification(request);
    }

    /**
     * 取得护照
     *
     * @param request
     * @return
     */
    @Override
    public PassportGetResponse getPassport(PassportGetRequest request) {
        return platformService.getPassport(request);
    }

    /**
     * 获取所有疾病特殊情况列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingDiseaseGetAllListResponse getSettingDiseaseAllList(SettingDiseaseGetAllListRequest request, Passport passport) {
        return platformService.getSettingDiseaseAllList(request, passport);
    }

    /**
     * 创建疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingDiseaseCreateResponse createSettingDisease(SettingDiseaseCreateRequest request, Passport passport) {
        return platformService.createSettingDisease(request, passport);
    }

    /**
     * 更新疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingDiseaseUpdateResponse updateSettingDisease(SettingDiseaseUpdateRequest request, Passport passport) {
        return platformService.updateSettingDisease(request, passport);
    }

    /**
     * 删除疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingDiseaseDeleteResponse deleteSettingDisease(SettingDiseaseDeleteRequest request, Passport passport) {
        return platformService.deleteSettingDisease(request, passport);
    }

    /**
     * 作废疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingDiseaseInactiveResponse inactiveSettingDisease(SettingDiseaseInactiveRequest request, Passport passport) {
        return platformService.inactiveSettingDisease(request, passport);
    }

    /**
     * 激活疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingDiseaseActiveResponse activeSettingDisease(SettingDiseaseActiveRequest request, Passport passport) {
        return platformService.activeSettingDisease(request, passport);
    }

    /**
     * 获取所有关键字列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingKeywordGetAllListResponse getSettingKeywordAllList(SettingKeywordGetAllListRequest request, Passport passport) {
        return platformService.getSettingKeywordAllList(request, passport);
    }

    /**
     * 创建关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingKeywordCreateResponse createSettingKeyword(SettingKeywordCreateRequest request, Passport passport) {
        return platformService.createSettingKeyword(request, passport);
    }

    /**
     * 更新关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingKeywordUpdateResponse updateSettingKeyword(SettingKeywordUpdateRequest request, Passport passport) {
        return platformService.updateSettingKeyword(request, passport);
    }

    /**
     * 删除关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingKeywordDeleteResponse deleteSettingKeyword(SettingKeywordDeleteRequest request, Passport passport) {
        return platformService.deleteSettingKeyword(request, passport);
    }

    /**
     * 作废关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingKeywordInactiveResponse inactiveSettingKeyword(SettingKeywordInactiveRequest request, Passport passport) {
        return platformService.inactiveSettingKeyword(request, passport);
    }

    /**
     * 激活关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingKeywordActiveResponse activeSettingKeyword(SettingKeywordActiveRequest request, Passport passport) {
        return platformService.activeSettingKeyword(request, passport);
    }

    /**
     * 获取所有问题标签列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingQuestionTagGetAllListResponse getSettingQuestionTagAllList(SettingQuestionTagGetAllListRequest request, Passport passport) {
        return platformService.getSettingQuestionTagAllList(request, passport);
    }

    /**
     * 创建问题标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingQuestionTagCreateResponse createSettingQuestionTag(SettingQuestionTagCreateRequest request, Passport passport) {
        return platformService.createSettingQuestionTag(request, passport);
    }

    /**
     * 更新问题标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingQuestionTagUpdateResponse updateSettingQuestionTag(SettingQuestionTagUpdateRequest request, Passport passport) {
        return platformService.updateSettingQuestionTag(request, passport);
    }

    /**
     * 删除问题标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingQuestionTagDeleteResponse deleteSettingQuestionTag(SettingQuestionTagDeleteRequest request, Passport passport) {
        return platformService.deleteSettingQuestionTag(request, passport);
    }

    /**
     * 作废问题标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingQuestionTagInactiveResponse inactiveSettingQuestionTag(SettingQuestionTagInactiveRequest request, Passport passport) {
        return platformService.inactiveSettingQuestionTag(request, passport);
    }

    /**
     * 高级查询用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingUserTagFindResponse findSettingUserTag(SettingUserTagFindRequest request, Passport passport) {
        return platformService.findSettingUserTag(request, passport);
    }

    /**
     * 获取所有用户标签列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingUserTagGetAllListResponse getSettingUserTagAllList(SettingUserTagGetAllListRequest request, Passport passport) {
        return platformService.getSettingUserTagAllList(request, passport);
    }

    /**
     * 创建用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingUserTagCreateResponse createSettingUserTag(SettingUserTagCreateRequest request, Passport passport) {
        return platformService.createSettingUserTag(request, passport);
    }

    /**
     * 更新用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingUserTagUpdateResponse updateSettingUserTag(SettingUserTagUpdateRequest request, Passport passport) {
        return platformService.updateSettingUserTag(request, passport);
    }

    /**
     * 删除用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingUserTagDeleteResponse deleteSettingUserTag(SettingUserTagDeleteRequest request, Passport passport) {
        return platformService.deleteSettingUserTag(request, passport);
    }

    /**
     * 作废用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingUserTagInactiveResponse inactiveSettingUserTag(SettingUserTagInactiveRequest request, Passport passport) {
        return platformService.inactiveSettingUserTag(request, passport);
    }

    /**
     * 激活用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SettingUserTagActiveResponse activeSettingUserTag(SettingUserTagActiveRequest request, Passport passport) {
        return platformService.activeSettingUserTag(request, passport);
    }

    /**
     * 高级查询用户身体变化曲线
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserCurveFindResponse findSysUserCurve(SysUserCurveFindRequest request, Passport passport) {
        return platformService.findSysUserCurve(request, passport);
    }

    /**
     * 获取所有用户身体变化曲线列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserCurveGetAllListByUserResponse getSysUserCurveAllListbyUser(SysUserCurveGetAllListByUserRequest request, Passport passport) {
        return platformService.getSysUserCurveAllListbyUser(request, passport);
    }

    /**
     * 创建用户身体变化曲线
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserCurveCreateResponse createSysUserCurve(SysUserCurveCreateRequest request, Passport passport) {
        return platformService.createSysUserCurve(request, passport);
    }

    /**
     * 删除用户身体变化曲线
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserCurveDeleteResponse deleteSysUserCurve(SysUserCurveDeleteRequest request, Passport passport) {
        return platformService.deleteSysUserCurve(request, passport);
    }

    @Override
    public SysUserCurveDeleteByConditionResponse deleteSysUserCurveByCondition(SysUserCurveDeleteByConditionRequest request, Passport passport) {
        return platformService.deleteSysUserCurveByCondition(request, passport);
    }

    @Override
    public SysUserCurveGetYearListByUserResponse getSysUserCurveYearListByUser(SysUserCurveGetYearListByUserRequest request, Passport passport) {
        return platformService.getSysUserCurveYearListByUser(request, passport);
    }

    @Override
    public SysUserCurveGetMonthListByUserResponse getSysUserCurveMonthListByUser(SysUserCurveGetMonthListByUserRequest request, Passport passport) {
        return platformService.getSysUserCurveMonthListByUser(request, passport);
    }

    @Override
    public SysUserCurveGetWeekListByUserResponse getSysUserCurveWeekListByUser(SysUserCurveGetWeekListByUserRequest request, Passport passport) {
        return platformService.getSysUserCurveWeekListByUser(request, passport);
    }

    /**
     * 创建积分规则
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public IntegralRuleCreateResponse createIntegralRule(IntegralRuleCreateRequest request, Passport passport) {
        return platformService.createIntegralRule(request, passport);
    }

    /**
     * 更新积分规则
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public IntegralRuleUpdateResponse updateIntegralRule(IntegralRuleUpdateRequest request, Passport passport) {
        return platformService.updateIntegralRule(request, passport);
    }

    /**
     * 获取所有积分规则列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public IntegralRuleGetAllListResponse getIntegralRuleAllList(IntegralRuleGetAllListRequest request, Passport passport) {
        return platformService.getIntegralRuleAllList(request, passport);
    }

    /**
     * 删除积分规则
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public IntegralRuleDeleteResponse deleteIntegralRule(IntegralRuleDeleteRequest request, Passport passport) {
        return platformService.deleteIntegralRule(request, passport);
    }

    /**
     * 创建积分明细
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public IntegralDetailCreateResponse createIntegralDetail(IntegralDetailCreateRequest request, Passport passport) {
        return platformService.createIntegralDetail(request, passport);
    }

    /**
     * 高级查询积分明细(预留后台查询使用)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public IntegralDetailFindResponse findIntegralDetail(IntegralDetailFindRequest request, Passport passport) {
        return platformService.findIntegralDetail(request, passport);
    }

    /**
     * 获取所有积分明细列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public IntegralDetailGetForMyResponse getMyIntegralDetail(IntegralDetailGetForMyRequest request, Passport passport) {
        return platformService.getMyIntegralDetail(request, passport);
    }

    /**
     * 创建数据表增量SQL
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncSqlCreateResponse createSyncSql(SyncSqlCreateRequest request, Passport passport) {
        return platformService.createSyncSql(request, passport);
    }

    /**
     * 获取增量SQL信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncSqlIncrementResponse getSyncIncrementSql(SyncSqlIncrementRequest request, Passport passport) {
        return platformService.getSyncIncrementSql(request, passport);
    }

    @Override
    public CommentPostFindResponse find(CommentPostFindRequest request, Passport passport) {
        return platformService.findCommentPost(request,passport);
    }

    @Override
    public CommentPostDeleteResponse delete(CommentPostDeleteRequest request, Passport passport) {
        return platformService.deleteCommentPost(request,passport);
    }

    @Override
    public CommentPostDeleteBatchResponse deleteBatch(CommentPostDeleteBatchRequest request, Passport passport) {
        return platformService.deleteBatchCommentPost(request, passport);
    }

    @Override
    public CommentPostCreateResponse createCommentPost(CommentPostCreateRequest request, Passport passport) {
        return platformService.createCommentPost(request,passport);
    }

    @Override
    public SysMessageFindResponse find(SysMessageFindRequest request, Passport passport) {
        SessionUtil.remove(String.valueOf(passport.getId()));
        return platformService.find(request,passport);
    }

    @Override
    public SysMessageUpdateResponse update(SysMessageUpdateRequest request, Passport passport) {
        return platformService.update(request,passport);
    }

    @Override
    public SysMessageGetResponse get(SysMessageGetRequest request, Passport passport) {
        return platformService.get(request,passport);
    }

    @Override
    public SysMessageCreateListResponse createList(SysMessageCreateListRequest request, Passport passport) {
        return platformService.create(request, passport);
    }

    @Override
    public CommentPostCreateListResponse createList(CommentPostCreateListRequest request, Passport passport) {
        return platformService.createList(request, passport);
    }

    @Override
    public IntegralRuleFindResponse find(IntegralRuleFindRequest request, Passport passport) {
        return platformService.find(request,passport);
    }
}