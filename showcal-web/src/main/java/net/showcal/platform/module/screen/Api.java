package net.showcal.platform.module.screen;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.request.MessageCreateRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.domain.CommentPost;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.domain.UserDetail;
import com.showcal.platform.request.*;
import com.showcal.platform.response.LoginPasswordResetResponse;
import com.showcal.platform.response.SysUserFindResponse;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.DateUtil;
import com.xiniunet.framework.util.EncryptUtil;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.tool.Constants;
import net.showcal.tool.SMSTool;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.platform.module.screen.Api
 *  Description: platform 的API信息
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public class Api {
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private BufferedRequestContext brc;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private PlatformHelper platformHelper;

    public void execute(@Param("method") String method) throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        try {
            // 必须关闭buffering，未完成的页面才会被显示在浏览器上。
            brc.setBuffering(false);
            // 设置content type，但不需要设置charset，框架会设置正确的charset。
            response.setContentType("text/plain");
            method = method.toLowerCase();
            Passport passport = (Passport) request.getAttribute("passport");
            InputStreamReader isr = new InputStreamReader(request.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            String line = in.readLine();
            JSONObject jsonObject = JSON.parseObject(line);

            switch (method) {
                // 根据Id获取用户
                case "api.platform.sysuser.get":
                    baseResponse = getSysUser(jsonObject, passport);
                    break;
                // 模糊查询用户
                case "api.platform.sysuser.search":
                    baseResponse = searchSysUser(jsonObject, passport);
                    break;
                // 高级查询用户
                case "api.platform.sysuser.find":
                    baseResponse = findSysUser(jsonObject, passport);
                    break;
                // 创建用户
                case "api.platform.sysuser.create":
                    baseResponse = createSysUser(jsonObject, passport);
                    break;
                // 更新用户
                case "api.platform.sysuser.update":
                    baseResponse = updateSysUser(jsonObject, passport);
                    break;
                // 删除用户
                case "api.platform.sysuser.delete":
                    baseResponse = deleteSysUser(jsonObject, passport);
                    break;
                // 升级用户为瘦咖
                case "api.platform.sysuser.up":
                    baseResponse = upSysUser(jsonObject, passport);
                    break;
                // 降级用户为会员
                case "api.platform.sysuser.down":
                    baseResponse = downSysUser(jsonObject, passport);
                    break;
                // 禁言用户
                case "api.platform.sysuser.ban":
                    baseResponse = banSysUser(jsonObject, passport);
                    break;
                // 禁言用户
                case "api.platform.sysuser.inban":
                    baseResponse = inbanSysUser(jsonObject, passport);
                    break;
                // 更新用户头像。
                case "api.platform.useravatar.update":
                    baseResponse = updateUserAvatar(jsonObject, passport);
                    break;
                // 通过来源类型模糊查询用户列表
                case "api.platform.bysourcetype.search":
                    baseResponse = searchBySourceType(jsonObject, passport);
                    break;
                // 作废用户
                case "api.platform.user.inactive":
                    baseResponse = inactiveUser(jsonObject, passport);
                    break;
                // 激活用户
                case "api.platform.user.active":
                    baseResponse = activeUser(jsonObject, passport);
                    break;
                // 给用户贴标签
                case "api.platform.sys.user.tag.create":
                    baseResponse = createSysUserTag(jsonObject, passport);
                    break;
                // 用户手机号码是否存在
                case "api.platform.existbymobilephone.user":
                    baseResponse = userExistByMobilePhone(jsonObject, passport);
                    break;
                // 登录
                case "api.platform.login":
                    baseResponse = login(jsonObject);
                    break;
                // 检查密码是否需要重置
                case "api.platform.resetableloginpassword.is":
                    baseResponse = isResetableLoginPassword(jsonObject, passport);
                    break;
                // 更新登录密码
                case "api.platform.loginpassword.modify":
                    baseResponse = modifyLoginPassword(jsonObject, passport);
                    break;
                // 更新登录密码
                case "api.platform.loginpassword.modify.check":
                    baseResponse = modifyLoginPasswordCheck(jsonObject, passport);
                    break;
                // 为一个用户重置登录密码
                case "api.platform.userloginpassword.reset":
                    baseResponse = resetUserLoginPassword(jsonObject, passport);
                    break;
                // 创建验证码
                case "api.platform.verificationcode.create":
                    baseResponse = createVerificationCode(jsonObject);
                    break;
                // 验证
                case "api.platform.valification.check":
                    baseResponse = checkValification(jsonObject);
                    break;
                // 取得护照
                case "api.platform.passport.get":
                    baseResponse = getPassport(jsonObject);
                    break;
                // 获取所有疾病特殊情况列表
                case "api.platform.settingdiseasealllist.get":
                    baseResponse = getSettingDiseaseAllList(jsonObject, passport);
                    break;
                // 创建疾病特殊情况
                case "api.platform.settingdisease.create":
                    baseResponse = createSettingDisease(jsonObject, passport);
                    break;
                // 更新疾病特殊情况
                case "api.platform.settingdisease.update":
                    baseResponse = updateSettingDisease(jsonObject, passport);
                    break;
                // 删除疾病特殊情况
                case "api.platform.settingdisease.delete":
                    baseResponse = deleteSettingDisease(jsonObject, passport);
                    break;
                // 作废疾病特殊情况
                case "api.platform.settingdisease.inactive":
                    baseResponse = inactiveSettingDisease(jsonObject, passport);
                    break;
                // 激活疾病特殊情况
                case "api.platform.settingdisease.active":
                    baseResponse = activeSettingDisease(jsonObject, passport);
                    break;
                // 获取所有关键字列表
                case "api.platform.settingkeywordalllist.get":
                    baseResponse = getSettingKeywordAllList(jsonObject, passport);
                    break;
                // 创建关键字
                case "api.platform.settingkeyword.create":
                    baseResponse = createSettingKeyword(jsonObject, passport);
                    break;
                // 更新关键字
                case "api.platform.settingkeyword.update":
                    baseResponse = updateSettingKeyword(jsonObject, passport);
                    break;
                // 删除关键字
                case "api.platform.settingkeyword.delete":
                    baseResponse = deleteSettingKeyword(jsonObject, passport);
                    break;
                // 作废关键字
                case "api.platform.settingkeyword.inactive":
                    baseResponse = inactiveSettingKeyword(jsonObject, passport);
                    break;
                // 激活关键字
                case "api.platform.settingkeyword.active":
                    baseResponse = activeSettingKeyword(jsonObject, passport);
                    break;
                // 获取所有问题标签列表
                case "api.platform.settingquestiontagalllist.get":
                    baseResponse = getSettingQuestionTagAllList(jsonObject, passport);
                    break;
                // 创建问题标签
                case "api.platform.settingquestiontag.create":
                    baseResponse = createSettingQuestionTag(jsonObject, passport);
                    break;
                // 更新问题标签
                case "api.platform.settingquestiontag.update":
                    baseResponse = updateSettingQuestionTag(jsonObject, passport);
                    break;
                // 删除问题标签
                case "api.platform.settingquestiontag.delete":
                    baseResponse = deleteSettingQuestionTag(jsonObject, passport);
                    break;
                // 作废问题标签
                case "api.platform.settingquestiontag.inactive":
                    baseResponse = inactiveSettingQuestionTag(jsonObject, passport);
                    break;
                // 高级查询用户标签
                case "api.platform.settingusertag.find":
                    baseResponse = findSettingUserTag(jsonObject, passport);
                    break;
                // 获取所有用户标签列表
                case "api.platform.settingusertagalllist.get":
                    baseResponse = getSettingUserTagAllList(jsonObject, passport);
                    break;
                // 创建用户标签
                case "api.platform.settingusertag.create":
                    baseResponse = createSettingUserTag(jsonObject, passport);
                    break;
                // 更新用户标签
                case "api.platform.settingusertag.update":
                    baseResponse = updateSettingUserTag(jsonObject, passport);
                    break;
                // 删除用户标签
                case "api.platform.settingusertag.delete":
                    baseResponse = deleteSettingUserTag(jsonObject, passport);
                    break;
                // 作废用户标签
                case "api.platform.settingusertag.inactive":
                    baseResponse = inactiveSettingUserTag(jsonObject, passport);
                    break;
                // 激活用户标签
                case "api.platform.settingusertag.active":
                    baseResponse = activeSettingUserTag(jsonObject, passport);
                    break;
                // 高级查询用户身体变化曲线
                case "api.platform.sysusercurve.find":
                    baseResponse = findSysUserCurve(jsonObject, passport);
                    break;
                // 获取所有用户身体变化曲线列表
                case "api.platform.sysusercurvealllistbyuser.get":
                    baseResponse = getSysUserCurveAllListbyUser(jsonObject, passport);
                    break;
                // 创建用户身体变化曲线
                case "api.platform.sysusercurve.create":
                    baseResponse = createSysUserCurve(jsonObject, passport);
                    break;
                // 删除用户身体变化曲线
                case "api.platform.sysusercurve.delete":
                    baseResponse = deleteSysUserCurve(jsonObject, passport);
                    break;
                // 创建积分规则
                case "api.platform.integralrule.create":
                    baseResponse = createIntegralRule(jsonObject, passport);
                    break;
                // 更新积分规则
                case "api.platform.integralrule.update":
                    baseResponse = updateIntegralRule(jsonObject, passport);
                    break;
                // 获取所有积分规则列表
                case "api.platform.integralrulealllist.get":
                    baseResponse = getIntegralRuleAllList(jsonObject, passport);
                    break;
                // 获取所有积分规则列表
                case "api.platform.integralrule.find":
                    baseResponse = findIntegralrule(jsonObject, passport);
                    break;
                // 删除积分规则
                case "api.platform.integralrule.delete":
                    baseResponse = deleteIntegralRule(jsonObject, passport);
                    break;
                // 创建积分明细
                case "api.platform.integraldetail.create":
                    baseResponse = createIntegralDetail(jsonObject, passport);
                    break;
                // 高级查询积分明细(预留后台查询使用)
                case "api.platform.integraldetail.find":
                    baseResponse = findIntegralDetail(jsonObject, passport);
                    break;
                // 获取所有积分明细列表
                case "api.platform.myintegraldetail.get":
                    baseResponse = getMyIntegralDetail(jsonObject, passport);
                    break;
                // 创建数据表增量SQL
                case "api.platform.syncsql.create":
                    baseResponse = createSyncSql(jsonObject, passport);
                    break;
                // 获取增量SQL信息
                case "api.platform.syncincrementsql.get":
                    baseResponse = getSyncIncrementSql(jsonObject, passport);
                    break;
                case "api.platform.comment.post.find":
                    baseResponse = findCommentPost(jsonObject, passport);
                    break;
                case "api.platform.comment.post.delete":
                    baseResponse = deleteCommentPost(jsonObject, passport);
                    break;
                case "api.platform.comment.post.delete.batch":
                    baseResponse = deleteBatchCommentPost(jsonObject, passport);
                    break;
                case "api.platform.message.create":
                    baseResponse = createMessage(jsonObject, passport);
                    break;
                case "api.platform.comment.post.create.list":
                    baseResponse = createCommentPostList(jsonObject, passport);
                    break;
                default:
                    baseResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_METHOD);
                    break;
            }
        } catch (Exception ex) {
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(ex));
            LogUtil.errorLog(ex);
        } finally {
            String jsonTenant = JSON.toJSONString(baseResponse);
            PrintWriter out = response.getWriter();
            out.println(jsonTenant);
        }
    }

    /**
     * 根据Id获取用户
     */
    private BaseResponse getSysUser(JSONObject jsonObject, Passport passport) {
        SysUserGetRequest request = JSON.toJavaObject(jsonObject, SysUserGetRequest.class);
        return platformHelper.getSysUser(request, passport);
    }

    /**
     * 模糊查询用户
     */
    private BaseResponse searchSysUser(JSONObject jsonObject, Passport passport) {
        SysUserSearchRequest request = JSON.toJavaObject(jsonObject, SysUserSearchRequest.class);
        return platformHelper.searchSysUser(request, passport);
    }

    /**
     * 高级查询用户
     */
    private BaseResponse findSysUser(JSONObject jsonObject, Passport passport) {
        SysUserFindRequest request = JSON.toJavaObject(jsonObject, SysUserFindRequest.class);
        if (request.getStartDate() != null) {
            request.setStartDate(DateUtil.getBeginOfDay(request.getStartDate()));
        }
        if (request.getEndDate() != null) {
            request.setEndDate(DateUtil.getEndOfDay(request.getEndDate()));
        }
        SysUserFindResponse findResponse = platformHelper.findSysUser(request, passport);

        List<UserDetail> users = findResponse.getResult();
        if (users != null && !users.isEmpty()) {
            for (UserDetail user : users) {
                if (user.getAvatarId() != null) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(user.getAvatarId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    if (filePathGetResponse != null){
                        user.setAvatarurl(filePathGetResponse.getUrl());
                    }
                } else {
                    user.setAvatarurl("../styles/images/avatar_default.png");
                }
            }
        }
        return findResponse;
    }

    /**
     * 创建用户
     */
    private BaseResponse createSysUser(JSONObject jsonObject, Passport passport) {
        SysUserCreateRequest request = JSON.toJavaObject(jsonObject, SysUserCreateRequest.class);
        return platformHelper.createSysUser(request, passport);
    }

    /**
     * 更新用户
     */
    private BaseResponse updateSysUser(JSONObject jsonObject, Passport passport) {
        SysUserUpdateRequest request = JSON.toJavaObject(jsonObject, SysUserUpdateRequest.class);
        return platformHelper.updateSysUser(request, passport);
    }

    /**
     * 升级用户为瘦咖
     */
    private BaseResponse upSysUser(JSONObject jsonObject, Passport passport) {
        SysUserUpDownRequest request = JSON.toJavaObject(jsonObject, SysUserUpDownRequest.class);
        return platformHelper.upSysUser(request, passport);
    }

    /**
     * 降级用户为会员
     */
    private BaseResponse downSysUser(JSONObject jsonObject, Passport passport) {
        SysUserUpDownRequest request = JSON.toJavaObject(jsonObject, SysUserUpDownRequest.class);
        return platformHelper.downSysUser(request, passport);
    }

    /**
     * 禁言用户
     */
    private BaseResponse banSysUser(JSONObject jsonObject, Passport passport) {
        SysUserBanRequest request = JSON.toJavaObject(jsonObject, SysUserBanRequest.class);
        return platformHelper.banSysUser(request, passport);
    }

    /**
     * 取消禁言用户
     */
    private BaseResponse inbanSysUser(JSONObject jsonObject, Passport passport) {
        SysUserInbanRequest request = JSON.toJavaObject(jsonObject, SysUserInbanRequest.class);
        return platformHelper.inbanSysUser(request, passport);
    }

    /**
     * 删除用户
     */
    private BaseResponse deleteSysUser(JSONObject jsonObject, Passport passport) {
        SysUserDeleteRequest request = JSON.toJavaObject(jsonObject, SysUserDeleteRequest.class);
        return platformHelper.deleteSysUser(request, passport);
    }

    /**
     * 更新用户头像。
     */
    private BaseResponse updateUserAvatar(JSONObject jsonObject, Passport passport) {
        UserAvatarUpdateRequest request = JSON.toJavaObject(jsonObject, UserAvatarUpdateRequest.class);
        return platformHelper.updateUserAvatar(request, passport);
    }

    /**
     * 通过来源类型模糊查询用户列表
     */
    private BaseResponse searchBySourceType(JSONObject jsonObject, Passport passport) {
        UserSearchBySourceTypeRequest request = JSON.toJavaObject(jsonObject, UserSearchBySourceTypeRequest.class);
        return platformHelper.searchBySourceType(request, passport);
    }

    /**
     * 作废用户
     */
    private BaseResponse inactiveUser(JSONObject jsonObject, Passport passport) {
        UserInactiveRequest request = JSON.toJavaObject(jsonObject, UserInactiveRequest.class);
        return platformHelper.inactiveUser(request, passport);
    }

    /**
     * 激活用户
     */
    private BaseResponse activeUser(JSONObject jsonObject, Passport passport) {
        UserActiveRequest request = JSON.toJavaObject(jsonObject, UserActiveRequest.class);
        return platformHelper.activeUser(request, passport);
    }

    /**
     * 给用户贴标签
     */
    private BaseResponse createSysUserTag(JSONObject jsonObject, Passport passport) {
        SysUserTagsCreateRequest request = JSON.toJavaObject(jsonObject, SysUserTagsCreateRequest.class);
        return platformHelper.createSysUserTag(request, passport);
    }

    /**
     * 用户手机号码是否存在
     */
    private BaseResponse userExistByMobilePhone(JSONObject jsonObject, Passport passport) {
        UserExistByMobileRequest request = JSON.toJavaObject(jsonObject, UserExistByMobileRequest.class);
        return platformHelper.userExistByMobilePhone(request, passport);
    }

    /**
     * 登录
     */
    private BaseResponse login(JSONObject jsonObject) {
        LoginRequest request = JSON.toJavaObject(jsonObject, LoginRequest.class);
        return platformHelper.login(request);
    }

    /**
     * 检查密码是否需要重置
     */
    private BaseResponse isResetableLoginPassword(JSONObject jsonObject, Passport passport) {
        LoginPasswordIsResetableRequest request = JSON.toJavaObject(jsonObject, LoginPasswordIsResetableRequest.class);
        return platformHelper.isResetableLoginPassword(request, passport);
    }

    /**
     * 更新登录密码
     */
    private BaseResponse modifyLoginPassword(JSONObject jsonObject, Passport passport) {
        LoginPasswordModifyRequest request = JSON.toJavaObject(jsonObject, LoginPasswordModifyRequest.class);
        return platformHelper.modifyLoginPassword(request, passport);
    }

    /**
     * 更新登录密码
     */
    private BaseResponse modifyLoginPasswordCheck(JSONObject jsonObject, Passport passport) {
        LoginPasswordModifyRequest request = JSON.toJavaObject(jsonObject, LoginPasswordModifyRequest.class);
        request.setId(passport.getUserId());
        request.setLoginPassword(EncryptUtil.MD5(request.getLoginPassword()));
        request.setOldLoginPassword(EncryptUtil.MD5(request.getOldLoginPassword()));
        return platformHelper.modifyLoginPasswordCheck(request, passport);
    }

    /**
     * 为一个用户重置登录密码
     */
    private BaseResponse resetUserLoginPassword(JSONObject jsonObject, Passport passport) {
        LoginPasswordResetRequest request = JSON.toJavaObject(jsonObject, LoginPasswordResetRequest.class);
        LoginPasswordResetResponse loginPasswordResetResponse = platformHelper.resetUserLoginPassword(request, passport);
        if ("success".equals(loginPasswordResetResponse.getResult())){
            SMSTool.getInstance().SendMsg(loginPasswordResetResponse.getMobilePhone(),loginPasswordResetResponse.getMobilePhone());
        }
        return loginPasswordResetResponse;
    }

    /**
     * 创建验证码
     */
    private BaseResponse createVerificationCode(JSONObject jsonObject) {
        VerificationCodeCreateRequest request = JSON.toJavaObject(jsonObject, VerificationCodeCreateRequest.class);
        return platformHelper.createVerificationCode(request);
    }

    /**
     * 验证
     */
    private BaseResponse checkValification(JSONObject jsonObject) {
        VerificationCheckRequest request = JSON.toJavaObject(jsonObject, VerificationCheckRequest.class);
        return platformHelper.checkValification(request);
    }

    /**
     * 取得护照
     */
    private BaseResponse getPassport(JSONObject jsonObject) {
        PassportGetRequest request = JSON.toJavaObject(jsonObject, PassportGetRequest.class);
        return platformHelper.getPassport(request);
    }

    /**
     * 获取所有疾病特殊情况列表
     */
    private BaseResponse getSettingDiseaseAllList(JSONObject jsonObject, Passport passport) {
        SettingDiseaseGetAllListRequest request = JSON.toJavaObject(jsonObject, SettingDiseaseGetAllListRequest.class);
        return platformHelper.getSettingDiseaseAllList(request, passport);
    }

    /**
     * 创建疾病特殊情况
     */
    private BaseResponse createSettingDisease(JSONObject jsonObject, Passport passport) {
        SettingDiseaseCreateRequest request = JSON.toJavaObject(jsonObject, SettingDiseaseCreateRequest.class);
        request.setIsActive(true);
        request.setActiveDate(new Date());
        return platformHelper.createSettingDisease(request, passport);
    }

    /**
     * 更新疾病特殊情况
     */
    private BaseResponse updateSettingDisease(JSONObject jsonObject, Passport passport) {
        SettingDiseaseUpdateRequest request = JSON.toJavaObject(jsonObject, SettingDiseaseUpdateRequest.class);
        return platformHelper.updateSettingDisease(request, passport);
    }

    /**
     * 删除疾病特殊情况
     */
    private BaseResponse deleteSettingDisease(JSONObject jsonObject, Passport passport) {
        SettingDiseaseDeleteRequest request = JSON.toJavaObject(jsonObject, SettingDiseaseDeleteRequest.class);
        return platformHelper.deleteSettingDisease(request, passport);
    }

    /**
     * 作废疾病特殊情况
     */
    private BaseResponse inactiveSettingDisease(JSONObject jsonObject, Passport passport) {
        SettingDiseaseInactiveRequest request = JSON.toJavaObject(jsonObject, SettingDiseaseInactiveRequest.class);
        return platformHelper.inactiveSettingDisease(request, passport);
    }

    /**
     * 激活疾病特殊情况
     */
    private BaseResponse activeSettingDisease(JSONObject jsonObject, Passport passport) {
        SettingDiseaseActiveRequest request = JSON.toJavaObject(jsonObject, SettingDiseaseActiveRequest.class);
        return platformHelper.activeSettingDisease(request, passport);
    }

    /**
     * 获取所有关键字列表
     */
    private BaseResponse getSettingKeywordAllList(JSONObject jsonObject, Passport passport) {
        SettingKeywordGetAllListRequest request = JSON.toJavaObject(jsonObject, SettingKeywordGetAllListRequest.class);
        return platformHelper.getSettingKeywordAllList(request, passport);
    }

    /**
     * 创建关键字
     */
    private BaseResponse createSettingKeyword(JSONObject jsonObject, Passport passport) {
        SettingKeywordCreateRequest request = JSON.toJavaObject(jsonObject, SettingKeywordCreateRequest.class);
        request.setIsActive(true);
        request.setActiveDate(new Date());
        return platformHelper.createSettingKeyword(request, passport);
    }

    /**
     * 更新关键字
     */
    private BaseResponse updateSettingKeyword(JSONObject jsonObject, Passport passport) {
        SettingKeywordUpdateRequest request = JSON.toJavaObject(jsonObject, SettingKeywordUpdateRequest.class);
        return platformHelper.updateSettingKeyword(request, passport);
    }

    /**
     * 删除关键字
     */
    private BaseResponse deleteSettingKeyword(JSONObject jsonObject, Passport passport) {
        SettingKeywordDeleteRequest request = JSON.toJavaObject(jsonObject, SettingKeywordDeleteRequest.class);
        return platformHelper.deleteSettingKeyword(request, passport);
    }

    /**
     * 作废关键字
     */
    private BaseResponse inactiveSettingKeyword(JSONObject jsonObject, Passport passport) {
        SettingKeywordInactiveRequest request = JSON.toJavaObject(jsonObject, SettingKeywordInactiveRequest.class);
        return platformHelper.inactiveSettingKeyword(request, passport);
    }

    /**
     * 激活关键字
     */
    private BaseResponse activeSettingKeyword(JSONObject jsonObject, Passport passport) {
        SettingKeywordActiveRequest request = JSON.toJavaObject(jsonObject, SettingKeywordActiveRequest.class);
        return platformHelper.activeSettingKeyword(request, passport);
    }

    /**
     * 获取所有问题标签列表
     */
    private BaseResponse getSettingQuestionTagAllList(JSONObject jsonObject, Passport passport) {
        SettingQuestionTagGetAllListRequest request = JSON.toJavaObject(jsonObject, SettingQuestionTagGetAllListRequest.class);
        return platformHelper.getSettingQuestionTagAllList(request, passport);
    }

    /**
     * 创建问题标签
     */
    private BaseResponse createSettingQuestionTag(JSONObject jsonObject, Passport passport) {
        SettingQuestionTagCreateRequest request = JSON.toJavaObject(jsonObject, SettingQuestionTagCreateRequest.class);
        request.setIsActive(true);
        request.setActiveDate(new Date());
        return platformHelper.createSettingQuestionTag(request, passport);
    }

    /**
     * 更新问题标签
     */
    private BaseResponse updateSettingQuestionTag(JSONObject jsonObject, Passport passport) {
        SettingQuestionTagUpdateRequest request = JSON.toJavaObject(jsonObject, SettingQuestionTagUpdateRequest.class);
        return platformHelper.updateSettingQuestionTag(request, passport);
    }

    /**
     * 删除问题标签
     */
    private BaseResponse deleteSettingQuestionTag(JSONObject jsonObject, Passport passport) {
        SettingQuestionTagDeleteRequest request = JSON.toJavaObject(jsonObject, SettingQuestionTagDeleteRequest.class);
        return platformHelper.deleteSettingQuestionTag(request, passport);
    }

    /**
     * 作废问题标签
     */
    private BaseResponse inactiveSettingQuestionTag(JSONObject jsonObject, Passport passport) {
        SettingQuestionTagInactiveRequest request = JSON.toJavaObject(jsonObject, SettingQuestionTagInactiveRequest.class);
        return platformHelper.inactiveSettingQuestionTag(request, passport);
    }

    /**
     * 高级查询用户标签
     */
    private BaseResponse findSettingUserTag(JSONObject jsonObject, Passport passport) {
        SettingUserTagFindRequest request = JSON.toJavaObject(jsonObject, SettingUserTagFindRequest.class);
        return platformHelper.findSettingUserTag(request, passport);
    }

    /**
     * 获取所有用户标签列表
     */
    private BaseResponse getSettingUserTagAllList(JSONObject jsonObject, Passport passport) {
        SettingUserTagGetAllListRequest request = JSON.toJavaObject(jsonObject, SettingUserTagGetAllListRequest.class);
        return platformHelper.getSettingUserTagAllList(request, passport);
    }

    /**
     * 创建用户标签
     */
    private BaseResponse createSettingUserTag(JSONObject jsonObject, Passport passport) {
        SettingUserTagCreateRequest request = JSON.toJavaObject(jsonObject, SettingUserTagCreateRequest.class);
        request.setIsActive(true);
        request.setActiveDate(new Date());
        return platformHelper.createSettingUserTag(request, passport);
    }

    /**
     * 更新用户标签
     */
    private BaseResponse updateSettingUserTag(JSONObject jsonObject, Passport passport) {
        SettingUserTagUpdateRequest request = JSON.toJavaObject(jsonObject, SettingUserTagUpdateRequest.class);
        return platformHelper.updateSettingUserTag(request, passport);
    }

    /**
     * 删除用户标签
     */
    private BaseResponse deleteSettingUserTag(JSONObject jsonObject, Passport passport) {
        SettingUserTagDeleteRequest request = JSON.toJavaObject(jsonObject, SettingUserTagDeleteRequest.class);
        return platformHelper.deleteSettingUserTag(request, passport);
    }

    /**
     * 作废用户标签
     */
    private BaseResponse inactiveSettingUserTag(JSONObject jsonObject, Passport passport) {
        SettingUserTagInactiveRequest request = JSON.toJavaObject(jsonObject, SettingUserTagInactiveRequest.class);
        return platformHelper.inactiveSettingUserTag(request, passport);
    }

    /**
     * 激活用户标签
     */
    private BaseResponse activeSettingUserTag(JSONObject jsonObject, Passport passport) {
        SettingUserTagActiveRequest request = JSON.toJavaObject(jsonObject, SettingUserTagActiveRequest.class);
        return platformHelper.activeSettingUserTag(request, passport);
    }

    /**
     * 高级查询用户身体变化曲线
     */
    private BaseResponse findSysUserCurve(JSONObject jsonObject, Passport passport) {
        SysUserCurveFindRequest request = JSON.toJavaObject(jsonObject, SysUserCurveFindRequest.class);
        return platformHelper.findSysUserCurve(request, passport);
    }

    /**
     * 获取所有用户身体变化曲线列表
     */
    private BaseResponse getSysUserCurveAllListbyUser(JSONObject jsonObject, Passport passport) {
        SysUserCurveGetAllListByUserRequest request = JSON.toJavaObject(jsonObject, SysUserCurveGetAllListByUserRequest.class);
        return platformHelper.getSysUserCurveAllListbyUser(request, passport);
    }

    /**
     * 创建用户身体变化曲线
     */
    private BaseResponse createSysUserCurve(JSONObject jsonObject, Passport passport) {
        SysUserCurveCreateRequest request = JSON.toJavaObject(jsonObject, SysUserCurveCreateRequest.class);
        return platformHelper.createSysUserCurve(request, passport);
    }

    /**
     * 删除用户身体变化曲线
     */
    private BaseResponse deleteSysUserCurve(JSONObject jsonObject, Passport passport) {
        SysUserCurveDeleteRequest request = JSON.toJavaObject(jsonObject, SysUserCurveDeleteRequest.class);
        return platformHelper.deleteSysUserCurve(request, passport);
    }

    /**
     * 创建积分规则
     */
    private BaseResponse createIntegralRule(JSONObject jsonObject, Passport passport) {
        IntegralRuleCreateRequest request = JSON.toJavaObject(jsonObject, IntegralRuleCreateRequest.class);
        return platformHelper.createIntegralRule(request, passport);
    }

    /**
     * 更新积分规则
     */
    private BaseResponse updateIntegralRule(JSONObject jsonObject, Passport passport) {
        IntegralRuleUpdateRequest request = JSON.toJavaObject(jsonObject, IntegralRuleUpdateRequest.class);
        return platformHelper.updateIntegralRule(request, passport);
    }

    /**
     * 获取所有积分规则列表
     */
    private BaseResponse getIntegralRuleAllList(JSONObject jsonObject, Passport passport) {
        IntegralRuleGetAllListRequest request = JSON.toJavaObject(jsonObject, IntegralRuleGetAllListRequest.class);
        return platformHelper.getIntegralRuleAllList(request, passport);
    }

    /**
     * 删除积分规则
     */
    private BaseResponse deleteIntegralRule(JSONObject jsonObject, Passport passport) {
        IntegralRuleDeleteRequest request = JSON.toJavaObject(jsonObject, IntegralRuleDeleteRequest.class);
        return platformHelper.deleteIntegralRule(request, passport);
    }

    /**
     * 创建积分明细
     */
    private BaseResponse createIntegralDetail(JSONObject jsonObject, Passport passport) {
        IntegralDetailCreateRequest request = JSON.toJavaObject(jsonObject, IntegralDetailCreateRequest.class);
        return platformHelper.createIntegralDetail(request, passport);
    }

    /**
     * 高级查询积分明细(预留后台查询使用)
     */
    private BaseResponse findIntegralDetail(JSONObject jsonObject, Passport passport) {
        IntegralDetailFindRequest request = JSON.toJavaObject(jsonObject, IntegralDetailFindRequest.class);
        return platformHelper.findIntegralDetail(request, passport);
    }

    /**
     * 获取所有积分明细列表
     */
    private BaseResponse getMyIntegralDetail(JSONObject jsonObject, Passport passport) {
        IntegralDetailGetForMyRequest request = JSON.toJavaObject(jsonObject, IntegralDetailGetForMyRequest.class);
        return platformHelper.getMyIntegralDetail(request, passport);
    }

    /**
     * 创建数据表增量SQL
     */
    private BaseResponse createSyncSql(JSONObject jsonObject, Passport passport) {
        SyncSqlCreateRequest request = JSON.toJavaObject(jsonObject, SyncSqlCreateRequest.class);
        return platformHelper.createSyncSql(request, passport);
    }

    /**
     * 获取增量SQL信息
     */
    private BaseResponse getSyncIncrementSql(JSONObject jsonObject, Passport passport) {
        SyncSqlIncrementRequest request = JSON.toJavaObject(jsonObject, SyncSqlIncrementRequest.class);
        return platformHelper.getSyncIncrementSql(request, passport);
    }

    private BaseResponse findCommentPost(JSONObject jsonObject, Passport passport) {
        CommentPostFindRequest request = JSON.toJavaObject(jsonObject, CommentPostFindRequest.class);
        return platformHelper.find(request, passport);
    }

    private BaseResponse deleteCommentPost(JSONObject jsonObject, Passport passport) {
        CommentPostDeleteRequest request = JSON.toJavaObject(jsonObject, CommentPostDeleteRequest.class);
        return platformHelper.delete(request, passport);
    }

    private BaseResponse deleteBatchCommentPost(JSONObject jsonObject, Passport passport) {
        CommentPostDeleteBatchRequest request = JSON.toJavaObject(jsonObject, CommentPostDeleteBatchRequest.class);
        return platformHelper.deleteBatch(request, passport);
    }

    private BaseResponse createMessage(JSONObject jsonObject, Passport passport) {
        SysMessageCreateListRequest request = JSON.toJavaObject(jsonObject, SysMessageCreateListRequest.class);
        return platformHelper.createList(request, passport);
    }

    private BaseResponse createCommentPostList(JSONObject jsonObject, Passport passport) {
        CommentPostCreateListRequest request = JSON.toJavaObject(jsonObject, CommentPostCreateListRequest.class);
        return platformHelper.createList(request, passport);
    }
    private BaseResponse findIntegralrule(JSONObject jsonObject, Passport passport) {
        IntegralRuleFindRequest request = JSON.toJavaObject(jsonObject, IntegralRuleFindRequest.class);
        return platformHelper.find(request, passport);
    }

}