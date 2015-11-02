package com.showcal.platform.service;

import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.platfrom.service
 *  Description:
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.platfrom.service
 * </pre>
 */
public interface PlatformService {
    /**
     * 根据Id获取用户
     *
     * @param request  获取用户请求
     * @param passport 用户护照
     * @return 获取用户应答
     */
    SysUserGetResponse getSysUser(SysUserGetRequest request, Passport passport);


    /**
     * 模糊查询用户
     *
     * @param request  模糊查询用户请求
     * @param passport 用户护照
     * @return 模糊查询用户应答
     */
    SysUserSearchResponse searchSysUser(SysUserSearchRequest request, Passport passport);

    /**
     * 高级查询用户
     *
     * @param request  高级查询用户请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SysUserFindResponse findSysUser(SysUserFindRequest request, Passport passport);


    /**
     * 创建用户
     *
     * @param request  创建用户请求
     * @param passport 用户护照
     * @return 创建用户应答
     */
    SysUserCreateResponse createSysUser(SysUserCreateRequest request, Passport passport);


    /**
     * 更新用户
     *
     * @param request  更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    SysUserUpdateResponse updateSysUser(SysUserUpdateRequest request, Passport passport);

    /**
     * 升级用户为瘦咖
     *
     * @param request  更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    SysUserUpDownResponse upSysUser(SysUserUpDownRequest request, Passport passport);

    /**
     * 降级用户为会员
     *
     * @param request  更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    SysUserUpDownResponse downSysUser(SysUserUpDownRequest request, Passport passport);

    /**
     * 禁言用户
     *
     * @param request  更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    SysUserBanResponse banSysUser(SysUserBanRequest request, Passport passport);

    /**
     * 取消禁言用户
     * @param request
     * @param passport
     * @return
     */
    SysUserInbanResponse inbanSysUser(SysUserInbanRequest request, Passport passport);

    /**
     * 删除用户
     *
     * @param request  删除用户请求
     * @param passport 用户护照
     * @return 删除用户应答
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
     * @param request  用户ID和头像文件的ID
     * @param passport 护照信息
     * @return 1L，更新成功；0L，更新失败
     */
    UserAvatarUpdateResponse updateUserAvatar(UserAvatarUpdateRequest request, Passport passport);

    /**
     * 通过来源类型模糊查询用户列表
     *
     * @param request  来源类型、搜索关键字
     * @param passport 护照信息
     * @return 满足条件的用户列表
     */
    UserSearchBySourceTypeResponse searchBySourceType(UserSearchBySourceTypeRequest request, Passport passport);


    /**
     * 作废用户
     *
     * @param request  用户ID
     * @param passport 护照信息
     * @return 1L，更新成功；0L，更新失败
     */
    UserInactiveResponse inactiveUser(UserInactiveRequest request, Passport passport);

    /**
     * 激活用户
     *
     * @param request  用户ID
     * @param passport 护照信息
     * @return 1L，更新成功；0L，更新失败
     */
    UserActiveResponse activeUser(UserActiveRequest request, Passport passport);

    /**
     * 查询OpenId是否存在
     * @param request
     * @param passport
     * @return
     */
    UserExistByOpenIdResponse userExistByOpenId(UserExistByOpenIdRequest request,Passport passport);

    /**
     * 根据OpenId登录
     * @param request
     * @param passport
     * @return
     */
    LoginByOpenIdResponse LoginByOpenId(LoginByOpenIdRequest request,Passport passport);
    /**
     *  给用户贴标签
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserTagsCreateResponse createSysUserTag(SysUserTagsCreateRequest request, Passport passport);

    /**
     * 用户手机号码是否存在
     *
     * @param request
     * @param passport
     * @return
     */
    UserExistByMobilePhoneResponse userExistByMobilePhone(UserExistByMobileRequest request, Passport passport);


    /**
     * 登录
     *
     * @param req 登录请求
     * @return 取得护照应答
     */
    LoginResponse login(LoginRequest req);

    /**
     * 检查密码是否需要重置
     *
     * @param req      检查请求
     * @param passport 当前操作用户的护照信息
     * @return 检查结果应答
     */
    LoginPasswordIsResetableResponse isResetableLoginPassword(LoginPasswordIsResetableRequest req, Passport passport);


    /**
     * 更新登录密码
     *  @param request 新的用户密码
     * @param passport          当前操作用户的护照信息
     */
    SysUserPasswordUpdateResponse modifyLoginPassword(LoginPasswordModifyRequest request, Passport passport);

    /**
     * 更新登录密码 - 附带原始密码
     *  @param request 新的用户密码
     * @param passport          当前操作用户的护照信息
     */
    SysUserPasswordUpdateResponse modifyLoginPasswordCheck(LoginPasswordModifyRequest request, Passport passport);

    /**
     * 为一个用户重置登录密码
     *
     * @param req      需要重置密码的用户的ID
     * @param passport 当前操作用户的护照信息
     * @return 为该用户生成的新的登录密码
     */
    LoginPasswordResetResponse resetUserLoginPassword(LoginPasswordResetRequest req, Passport passport);

    /**
     * 创建验证码
     *
     * @param request 创建验证码请求
     * @return 创建验证码应答
     */
    VerificationCodeCreateResponse createVerificationCode(VerificationCodeCreateRequest request);

    /**
     * 验证
     *
     * @param req 验证请求
     * @return 验证应答
     */
    VerificationCheckResponse checkValification(VerificationCheckRequest req);

    /**
     * 取得护照
     *
     * @param req 取得护照请求
     * @return 取得护照应答
     */
    PassportGetResponse getPassport(PassportGetRequest req);


    /**
     * 获取所有疾病特殊情况列表
     *
     * @param request  获取所有疾病特殊情况列表请求
     * @param passport 用户护照
     * @return 获取所有疾病特殊情况列表应答
     */
    SettingDiseaseGetAllListResponse getSettingDiseaseAllList(SettingDiseaseGetAllListRequest request, Passport passport);


    /**
     * 创建疾病特殊情况
     *
     * @param request  创建疾病特殊情况请求
     * @param passport 用户护照
     * @return 创建疾病特殊情况应答
     */
    SettingDiseaseCreateResponse createSettingDisease(SettingDiseaseCreateRequest request, Passport passport);


    /**
     * 更新疾病特殊情况
     *
     * @param request  更新疾病特殊情况请求
     * @param passport 用户护照
     * @return 更新疾病特殊情况应答
     */
    SettingDiseaseUpdateResponse updateSettingDisease(SettingDiseaseUpdateRequest request, Passport passport);


    /**
     * 删除疾病特殊情况
     *
     * @param request  删除疾病特殊情况请求
     * @param passport 用户护照
     * @return 删除疾病特殊情况应答
     */
    SettingDiseaseDeleteResponse deleteSettingDisease(SettingDiseaseDeleteRequest request, Passport passport);


    /**
     * 作废疾病特殊情况
     *
     * @param request  作废疾病特殊情况请求
     * @param passport 用户护照
     * @return 作废疾病特殊情况应答
     */
    SettingDiseaseInactiveResponse inactiveSettingDisease(SettingDiseaseInactiveRequest request, Passport passport);


    /**
     * 激活疾病特殊情况
     *
     * @param request  激活疾病特殊情况请求
     * @param passport 用户护照
     * @return 激活疾病特殊情况应答
     */
    SettingDiseaseActiveResponse activeSettingDisease(SettingDiseaseActiveRequest request, Passport passport);


    /**
     * 获取所有关键字列表
     *
     * @param request  获取所有关键字列表请求
     * @param passport 用户护照
     * @return 获取所有关键字列表应答
     */
    SettingKeywordGetAllListResponse getSettingKeywordAllList(SettingKeywordGetAllListRequest request, Passport passport);


    /**
     * 创建关键字
     *
     * @param request  创建关键字请求
     * @param passport 用户护照
     * @return 创建关键字应答
     */
    SettingKeywordCreateResponse createSettingKeyword(SettingKeywordCreateRequest request, Passport passport);


    /**
     * 更新关键字
     *
     * @param request  更新关键字请求
     * @param passport 用户护照
     * @return 更新关键字应答
     */
    SettingKeywordUpdateResponse updateSettingKeyword(SettingKeywordUpdateRequest request, Passport passport);


    /**
     * 删除关键字
     *
     * @param request  删除关键字请求
     * @param passport 用户护照
     * @return 删除关键字应答
     */
    SettingKeywordDeleteResponse deleteSettingKeyword(SettingKeywordDeleteRequest request, Passport passport);


    /**
     * 作废关键字
     *
     * @param request  作废关键字请求
     * @param passport 用户护照
     * @return 作废关键字应答
     */
    SettingKeywordInactiveResponse inactiveSettingKeyword(SettingKeywordInactiveRequest request, Passport passport);


    /**
     * 激活关键字
     *
     * @param request  激活关键字请求
     * @param passport 用户护照
     * @return 激活关键字应答
     */
    SettingKeywordActiveResponse activeSettingKeyword(SettingKeywordActiveRequest request, Passport passport);


    /**
     * 获取所有问题标签列表
     *
     * @param request  获取所有问题标签列表请求
     * @param passport 用户护照
     * @return 获取所有问题标签列表应答
     */
    SettingQuestionTagGetAllListResponse getSettingQuestionTagAllList(SettingQuestionTagGetAllListRequest request, Passport passport);


    /**
     * 创建问题标签
     *
     * @param request  创建问题标签请求
     * @param passport 用户护照
     * @return 创建问题标签应答
     */
    SettingQuestionTagCreateResponse createSettingQuestionTag(SettingQuestionTagCreateRequest request, Passport passport);


    /**
     * 更新问题标签
     *
     * @param request  更新问题标签请求
     * @param passport 用户护照
     * @return 更新问题标签应答
     */
    SettingQuestionTagUpdateResponse updateSettingQuestionTag(SettingQuestionTagUpdateRequest request, Passport passport);


    /**
     * 删除问题标签
     *
     * @param request  删除问题标签请求
     * @param passport 用户护照
     * @return 删除问题标签应答
     */
    SettingQuestionTagDeleteResponse deleteSettingQuestionTag(SettingQuestionTagDeleteRequest request, Passport passport);


    /**
     * 作废问题标签
     *
     * @param request  作废问题标签请求
     * @param passport 用户护照
     * @return 作废问题标签应答
     */
    SettingQuestionTagInactiveResponse inactiveSettingQuestionTag(SettingQuestionTagInactiveRequest request, Passport passport);

    /**
     * 高级查询用户标签
     *
     * @param request  高级查询用户标签请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SettingUserTagFindResponse findSettingUserTag(SettingUserTagFindRequest request, Passport passport);

    /**
     * 获取所有用户标签列表
     *
     * @param request  获取所有用户标签列表请求
     * @param passport 用户护照
     * @return 获取所有用户标签列表应答
     */
    SettingUserTagGetAllListResponse getSettingUserTagAllList(SettingUserTagGetAllListRequest request, Passport passport);


    /**
     * 创建用户标签
     *
     * @param request  创建用户标签请求
     * @param passport 用户护照
     * @return 创建用户标签应答
     */
    SettingUserTagCreateResponse createSettingUserTag(SettingUserTagCreateRequest request, Passport passport);


    /**
     * 更新用户标签
     *
     * @param request  更新用户标签请求
     * @param passport 用户护照
     * @return 更新用户标签应答
     */
    SettingUserTagUpdateResponse updateSettingUserTag(SettingUserTagUpdateRequest request, Passport passport);


    /**
     * 删除用户标签
     *
     * @param request  删除用户标签请求
     * @param passport 用户护照
     * @return 删除用户标签应答
     */
    SettingUserTagDeleteResponse deleteSettingUserTag(SettingUserTagDeleteRequest request, Passport passport);


    /**
     * 作废用户标签
     *
     * @param request  作废用户标签请求
     * @param passport 用户护照
     * @return 作废用户标签应答
     */
    SettingUserTagInactiveResponse inactiveSettingUserTag(SettingUserTagInactiveRequest request, Passport passport);


    /**
     * 激活用户标签
     *
     * @param request  激活用户标签请求
     * @param passport 用户护照
     * @return 激活用户标签应答
     */
    SettingUserTagActiveResponse activeSettingUserTag(SettingUserTagActiveRequest request, Passport passport);

    /**
     * 高级查询用户身体变化曲线
     *
     * @param request  高级查询用户身体变化曲线请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SysUserCurveFindResponse findSysUserCurve(SysUserCurveFindRequest request, Passport passport);

    /**
     * 获取所有用户身体变化曲线列表
     *
     * @param request  获取所有用户身体变化曲线列表请求
     * @param passport 用户护照
     * @return 获取所有用户身体变化曲线列表应答
     */
    SysUserCurveGetAllListByUserResponse getSysUserCurveAllListbyUser(SysUserCurveGetAllListByUserRequest request, Passport passport);


    /**
     * 创建用户身体变化曲线
     *
     * @param request  创建用户身体变化曲线请求
     * @param passport 用户护照
     * @return 创建用户身体变化曲线应答
     */
    SysUserCurveCreateResponse createSysUserCurve(SysUserCurveCreateRequest request, Passport passport);

    /**
     * 删除用户身体变化曲线
     *
     * @param request  删除用户身体变化曲线请求
     * @param passport 用户护照
     * @return 删除用户身体变化曲线应答
     */
    SysUserCurveDeleteResponse deleteSysUserCurve(SysUserCurveDeleteRequest request, Passport passport);

    /**
     * 删除用户身体变化曲线
     *
     * @param request  删除用户身体变化曲线请求
     * @param passport 用户护照
     * @return 删除用户身体变化曲线应答
     */
    SysUserCurveDeleteByConditionResponse deleteSysUserCurveByCondition(SysUserCurveDeleteByConditionRequest request, Passport passport);

    /**
     *  根据用户查询各年度的身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetYearListByUserResponse getSysUserCurveYearListByUser(SysUserCurveGetYearListByUserRequest request, Passport passport);

    /**
     *  根据用户查询月的身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetMonthListByUserResponse getSysUserCurveMonthListByUser(SysUserCurveGetMonthListByUserRequest request, Passport passport);

    /**
     *  根据用户查询各周的身体变化曲线
     *
     * @param request
     * @param passport
     * @return
     */
    SysUserCurveGetWeekListByUserResponse getSysUserCurveWeekListByUser(SysUserCurveGetWeekListByUserRequest request, Passport passport);

    /**
     * 创建积分规则
     *
     * @param request  创建积分规则请求
     * @param passport 用户护照
     * @return 创建积分规则应答
     */
    IntegralRuleCreateResponse createIntegralRule(IntegralRuleCreateRequest request, Passport passport);


    /**
     * 更新积分规则
     *
     * @param request  更新积分规则请求
     * @param passport 用户护照
     * @return 更新积分规则应答
     */
    IntegralRuleUpdateResponse updateIntegralRule(IntegralRuleUpdateRequest request, Passport passport);

    /**
     * 获取所有积分规则列表
     *
     * @param request  获取所有积分规则列表请求
     * @param passport 用户护照
     * @return 获取所有积分规则列表应答
     */
    IntegralRuleGetAllListResponse getIntegralRuleAllList(IntegralRuleGetAllListRequest request, Passport passport);

    /**
     * 删除积分规则
     *
     * @param request  删除积分规则请求
     * @param passport 用户护照
     * @return 删除积分规则应答
     */
    IntegralRuleDeleteResponse deleteIntegralRule(IntegralRuleDeleteRequest request, Passport passport);

    /**
     * 创建积分明细
     *
     * @param request  创建积分明细请求
     * @param passport 用户护照
     * @return 创建积分明细应答
     */
    IntegralDetailCreateResponse createIntegralDetail(IntegralDetailCreateRequest request, Passport passport);

    /**
     * 高级查询积分明细(预留后台查询使用)
     *
     * @param request  高级查询积分明细请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    IntegralDetailFindResponse findIntegralDetail(IntegralDetailFindRequest request, Passport passport);

    /**
     * 获取所有积分明细列表
     *
     * @param request  获取所有积分明细列表请求
     * @param passport 用户护照
     * @return 获取所有积分明细列表应答
     */
    IntegralDetailGetForMyResponse getMyIntegralDetail(IntegralDetailGetForMyRequest request, Passport passport);

    /**
     * 创建数据表增量SQL
     *
     * @param request  创建数据表同步请求
     * @param passport 用户护照
     * @return 创建数据表同步应答
     */
    SyncSqlCreateResponse createSyncSql(SyncSqlCreateRequest request, Passport passport);

    /**
     * 获取增量SQL信息
     *
     * @param request  获取所有数据表同步列表请求
     * @param passport 用户护照
     * @return 获取所有数据表同步列表应答
     */
    SyncSqlIncrementResponse getSyncIncrementSql(SyncSqlIncrementRequest request, Passport passport);

    /**
     * 创建评论
     *
     * @param request
     * @param passport
     * @return
     */
    CommentPostCreateResponse createCommentPost(CommentPostCreateRequest request, Passport passport);

    /**
     * 删除评论
     *
     * @param request
     * @param passport
     * @return
     */
    CommentPostDeleteResponse deleteCommentPost(CommentPostDeleteRequest request, Passport passport);

    /**
     * 批量删除评论
     *
     * @param request
     * @param passport
     * @return
     */
    CommentPostDeleteBatchResponse deleteBatchCommentPost(CommentPostDeleteBatchRequest request, Passport passport);

    /**
     * 查询评论
     *
     * @param request
     * @param passport
     * @return
     */
    CommentPostFindResponse findCommentPost(CommentPostFindRequest request, Passport passport);
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
    SysMessageCreateListResponse create(SysMessageCreateListRequest request, Passport passport);
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
