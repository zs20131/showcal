package net.showcal.platform.helper;

import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.showcal.service.request.ComplatintDeleteRequest;
import com.showcal.service.request.ComplatintFindRequest;
import com.showcal.service.request.ComplatintUpdateRequest;
import com.showcal.service.response.ComplatintDeleteResponse;
import com.showcal.service.response.ComplatintFindResponse;
import com.showcal.service.response.ComplatintUpdateResponse;
import com.xiniunet.framework.security.Passport;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.platfrom.helper.PlatfromHelper
 *  Description: platfrom Helper 接口
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public interface PlatformHelper {
    /**
     * 根据Id获取用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserGetResponse getSysUser(SysUserGetRequest request, Passport passport);

    /**
     * 模糊查询用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserSearchResponse searchSysUser(SysUserSearchRequest request, Passport passport);

    /**
     * 高级查询用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserFindResponse findSysUser(SysUserFindRequest request, Passport passport);

    /**
     * 创建用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserCreateResponse createSysUser(SysUserCreateRequest request, Passport passport);

    /**
     * 更新用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserUpdateResponse updateSysUser(SysUserUpdateRequest request, Passport passport);

    /**
     * 升级用户为瘦咖
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserUpDownResponse upSysUser(SysUserUpDownRequest request, Passport passport);

    /**
     * 降级用户为会员
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserUpDownResponse downSysUser(SysUserUpDownRequest request, Passport passport);

    /**
     * 禁言用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserBanResponse banSysUser(SysUserBanRequest request, Passport passport);

    /**
     * 取消禁言用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserInbanResponse inbanSysUser(SysUserInbanRequest request, Passport passport);

    /**
     * 删除用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserDeleteResponse deleteSysUser(SysUserDeleteRequest request, Passport passport);

    /**
     *  查询用户扩展
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserExtentGetResponse getSysUserExtent(SysUserExtentGetRequest request, Passport passport);

    /**
     *  更新用户扩展
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserExtentUpdateResponse updateSysUserExtent(SysUserExtentUpdateRequest request, Passport passport);

    /**
     * 更新用户头像。
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    UserAvatarUpdateResponse updateUserAvatar(UserAvatarUpdateRequest request, Passport passport);

    /**
     * 通过来源类型模糊查询用户列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    UserSearchBySourceTypeResponse searchBySourceType(UserSearchBySourceTypeRequest request, Passport passport);

    /**
     * 作废用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    UserInactiveResponse inactiveUser(UserInactiveRequest request, Passport passport);

    /**
     * 激活用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    UserActiveResponse activeUser(UserActiveRequest request, Passport passport);

    /**
     * 给用户贴标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserTagsCreateResponse createSysUserTag(SysUserTagsCreateRequest request, Passport passport);

    /**
     * 用户手机号码是否存在
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    UserExistByMobilePhoneResponse userExistByMobilePhone(UserExistByMobileRequest request, Passport passport);

    /**
     * 登录
     *
     * @param request
     * @return
     */
    LoginResponse login(LoginRequest request);

    /**
     * 检查密码是否需要重置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    LoginPasswordIsResetableResponse isResetableLoginPassword(LoginPasswordIsResetableRequest request, Passport passport);

    /**
     * 更新登录密码
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserPasswordUpdateResponse modifyLoginPassword(LoginPasswordModifyRequest request, Passport passport);

    /**
     * 更新登录密码-原始密码
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserPasswordUpdateResponse modifyLoginPasswordCheck(LoginPasswordModifyRequest request, Passport passport);

    /**
     * 为一个用户重置登录密码
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    LoginPasswordResetResponse resetUserLoginPassword(LoginPasswordResetRequest request, Passport passport);

    /**
     * 创建验证码
     *
     * @param request
     * @return
     */
    VerificationCodeCreateResponse createVerificationCode(VerificationCodeCreateRequest request);

    /**
     * 验证
     *
     * @param request
     * @return
     */
    VerificationCheckResponse checkValification(VerificationCheckRequest request);

    /**
     * 取得护照
     *
     * @param request
     * @return
     */
    PassportGetResponse getPassport(PassportGetRequest request);

    /**
     * 获取所有疾病特殊情况列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingDiseaseGetAllListResponse getSettingDiseaseAllList(SettingDiseaseGetAllListRequest request, Passport passport);

    /**
     * 创建疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingDiseaseCreateResponse createSettingDisease(SettingDiseaseCreateRequest request, Passport passport);

    /**
     * 更新疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingDiseaseUpdateResponse updateSettingDisease(SettingDiseaseUpdateRequest request, Passport passport);

    /**
     * 删除疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingDiseaseDeleteResponse deleteSettingDisease(SettingDiseaseDeleteRequest request, Passport passport);

    /**
     * 作废疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingDiseaseInactiveResponse inactiveSettingDisease(SettingDiseaseInactiveRequest request, Passport passport);

    /**
     * 激活疾病特殊情况
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingDiseaseActiveResponse activeSettingDisease(SettingDiseaseActiveRequest request, Passport passport);

    /**
     * 获取所有关键字列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingKeywordGetAllListResponse getSettingKeywordAllList(SettingKeywordGetAllListRequest request, Passport passport);

    /**
     * 创建关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingKeywordCreateResponse createSettingKeyword(SettingKeywordCreateRequest request, Passport passport);

    /**
     * 更新关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingKeywordUpdateResponse updateSettingKeyword(SettingKeywordUpdateRequest request, Passport passport);

    /**
     * 删除关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingKeywordDeleteResponse deleteSettingKeyword(SettingKeywordDeleteRequest request, Passport passport);

    /**
     * 作废关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingKeywordInactiveResponse inactiveSettingKeyword(SettingKeywordInactiveRequest request, Passport passport);

    /**
     * 激活关键字
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingKeywordActiveResponse activeSettingKeyword(SettingKeywordActiveRequest request, Passport passport);

    /**
     * 获取所有问题标签列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingQuestionTagGetAllListResponse getSettingQuestionTagAllList(SettingQuestionTagGetAllListRequest request, Passport passport);

    /**
     * 创建问题标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingQuestionTagCreateResponse createSettingQuestionTag(SettingQuestionTagCreateRequest request, Passport passport);

    /**
     * 更新问题标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingQuestionTagUpdateResponse updateSettingQuestionTag(SettingQuestionTagUpdateRequest request, Passport passport);

    /**
     * 删除问题标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingQuestionTagDeleteResponse deleteSettingQuestionTag(SettingQuestionTagDeleteRequest request, Passport passport);

    /**
     * 作废问题标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingQuestionTagInactiveResponse inactiveSettingQuestionTag(SettingQuestionTagInactiveRequest request, Passport passport);

    /**
     * 高级查询用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingUserTagFindResponse findSettingUserTag(SettingUserTagFindRequest request, Passport passport);

    /**
     * 获取所有用户标签列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingUserTagGetAllListResponse getSettingUserTagAllList(SettingUserTagGetAllListRequest request, Passport passport);

    /**
     * 创建用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingUserTagCreateResponse createSettingUserTag(SettingUserTagCreateRequest request, Passport passport);

    /**
     * 更新用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingUserTagUpdateResponse updateSettingUserTag(SettingUserTagUpdateRequest request, Passport passport);

    /**
     * 删除用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingUserTagDeleteResponse deleteSettingUserTag(SettingUserTagDeleteRequest request, Passport passport);

    /**
     * 作废用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingUserTagInactiveResponse inactiveSettingUserTag(SettingUserTagInactiveRequest request, Passport passport);

    /**
     * 激活用户标签
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SettingUserTagActiveResponse activeSettingUserTag(SettingUserTagActiveRequest request, Passport passport);

    /**
     * 高级查询用户身体变化曲线
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserCurveFindResponse findSysUserCurve(SysUserCurveFindRequest request, Passport passport);

    /**
     * 获取所有用户身体变化曲线列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserCurveGetAllListByUserResponse getSysUserCurveAllListbyUser(SysUserCurveGetAllListByUserRequest request, Passport passport);

    /**
     * 创建用户身体变化曲线
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserCurveCreateResponse createSysUserCurve(SysUserCurveCreateRequest request, Passport passport);

    /**
     * 删除用户身体变化曲线
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SysUserCurveDeleteResponse deleteSysUserCurve(SysUserCurveDeleteRequest request, Passport passport);

    /**
     *  根据条件删除用户身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveDeleteByConditionResponse deleteSysUserCurveByCondition(SysUserCurveDeleteByConditionRequest request, Passport passport);

    /**
     *  根据用户等条件查询该用户年度的身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetYearListByUserResponse getSysUserCurveYearListByUser(SysUserCurveGetYearListByUserRequest request, Passport passport);

    /**
     *  根据用户等条件查询该用户月的身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetMonthListByUserResponse getSysUserCurveMonthListByUser(SysUserCurveGetMonthListByUserRequest request, Passport passport);

    /**
     *  根据用户等条件查询该用户周的身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetWeekListByUserResponse getSysUserCurveWeekListByUser(SysUserCurveGetWeekListByUserRequest request, Passport passport);

    /**
     * 创建积分规则
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    IntegralRuleCreateResponse createIntegralRule(IntegralRuleCreateRequest request, Passport passport);

    /**
     * 更新积分规则
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    IntegralRuleUpdateResponse updateIntegralRule(IntegralRuleUpdateRequest request, Passport passport);

    /**
     * 获取所有积分规则列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    IntegralRuleGetAllListResponse getIntegralRuleAllList(IntegralRuleGetAllListRequest request, Passport passport);

    /**
     * 删除积分规则
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    IntegralRuleDeleteResponse deleteIntegralRule(IntegralRuleDeleteRequest request, Passport passport);

    /**
     * 创建积分明细
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    IntegralDetailCreateResponse createIntegralDetail(IntegralDetailCreateRequest request, Passport passport);

    /**
     * 高级查询积分明细(预留后台查询使用)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    IntegralDetailFindResponse findIntegralDetail(IntegralDetailFindRequest request, Passport passport);

    /**
     * 获取所有积分明细列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    IntegralDetailGetForMyResponse getMyIntegralDetail(IntegralDetailGetForMyRequest request, Passport passport);

    /**
     * 创建数据表增量SQL
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncSqlCreateResponse createSyncSql(SyncSqlCreateRequest request, Passport passport);

    /**
     * 获取增量SQL信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncSqlIncrementResponse getSyncIncrementSql(SyncSqlIncrementRequest request, Passport passport);
    /**
     * 高级查询评论表
     *
     * @param request 高级查询评论表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    CommentPostFindResponse find(CommentPostFindRequest request, Passport passport);




    /**
     * 删除评论表
     *
     * @param request 删除评论表请求
     * @param passport 用户护照
     * @return 删除评论表应答
     */
    CommentPostDeleteResponse delete(CommentPostDeleteRequest request, Passport passport);

    /**
     * 批量删除评论表
     *
     * @param request 删除评论表请求
     * @param passport 用户护照
     * @return 删除评论表应答
     */
    CommentPostDeleteBatchResponse deleteBatch(CommentPostDeleteBatchRequest request, Passport passport);

    /**
     * 创建评论
     *
     * @param request
     * @param passport
     * @return
     */
    CommentPostCreateResponse createCommentPost(CommentPostCreateRequest request, Passport passport);
    /**
     * 高级查询系统消息表
     *
     * @param request 高级查询系统消息表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SysMessageFindResponse find(SysMessageFindRequest request, Passport passport);

    /**
     * 更新系统消息表
     *
     * @param request 更新系统消息表请求
     * @param passport 用户护照
     * @return 更新系统消息表应答
     */
    SysMessageUpdateResponse update(SysMessageUpdateRequest request, Passport passport);

    /**
     * 根据Id获取系统消息表
     *
     * @param request 获取系统消息表请求
     * @param passport 用户护照
     * @return 获取系统消息表应答
     */
    SysMessageGetResponse get(SysMessageGetRequest request, Passport passport);


    /**
     * 创建系统消息表
     *
     * @param request 创建系统消息表请求
     * @param passport 用户护照
     * @return 创建系统消息表应答
     */
    SysMessageCreateListResponse createList(SysMessageCreateListRequest request, Passport passport);
    /**
     * 创建评论表
     *
     * @param request 创建评论表请求
     * @param passport 用户护照
     * @return 创建评论表应答
     */
    CommentPostCreateListResponse createList(CommentPostCreateListRequest request, Passport passport);
    /**
     * 高级查询积分规则
     *
     * @param request 高级查询积分规则请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    IntegralRuleFindResponse find(IntegralRuleFindRequest request, Passport passport);

}