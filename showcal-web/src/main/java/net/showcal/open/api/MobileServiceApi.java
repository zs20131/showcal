package net.showcal.open.api;

import com.showcal.foundation.domain.UploadTypeEnum;
import com.showcal.foundation.request.FileUploadRequest;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.request.*;
import com.showcal.mobile.service.MobileService;
import com.showcal.platform.domain.IntegralRuleTypeEnum;
import com.showcal.platform.domain.OpenTypeEnum;
import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.showcal.platform.service.PlatformService;
import com.showcal.service.request.QuestionCreateRequest;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.thermalcontrol.request.SyncHeatCreateRequest;
import com.showcal.thermalcontrol.service.ThermalControlService;
import com.xiniunet.apiframework.AbstractApiRequest;
import com.xiniunet.apiframework.annotation.HttpAction;
import com.xiniunet.apiframework.annotation.NeedInSessionType;
import com.xiniunet.apiframework.annotation.ServiceMethod;
import com.xiniunet.apiframework.annotation.ServiceMethodBean;
import com.xiniunet.apiframework.request.FileItem;
import com.xiniunet.apiframework.response.ErrorResponse;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.EncryptUtil;
import net.showcal.open.api.request.AttachmentUploadRequest;
import net.showcal.open.tool.RequestConverter;
import net.showcal.tool.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen.Api
 *  Description: mobile 的API信息
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
@ServiceMethodBean
public class MobileServiceApi {
    @Autowired
    private MobileService mobileService;
    @Autowired
    private FoundationService foundationService;
    @Autowired
    private RequestConverter requestConverter;
    @Autowired
    private PlatformService platformService;
    @Autowired
    private ThermalControlService thermalControlService;
    /**
     * 同步增量数据
     */
    @ServiceMethod(title = "同步增量数据", method = "mobile.incrementSql.sysnc", httpAction = HttpAction.POST, version = "1.0")
    public Object sysncIncrementSql(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        SyncSqlIncrementRequest syncSqlIncrementRequest = requestConverter.converter(SyncSqlIncrementRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, syncSqlIncrementRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.sysncIncrementSql(syncSqlIncrementRequest, passport);
        }
    }

    /**
     * 获取最大SQL版本号
     */
    @ServiceMethod(title = "获取最大版本号", method = "mobile.incrementSql.maxversion", httpAction = HttpAction.POST, version = "1.0")
    public Object sysncIncrementSqlMaxVersion(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        MaxSqlVersionGetRequest syncSqlIncrementRequest = requestConverter.converter(MaxSqlVersionGetRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, syncSqlIncrementRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.getMaxSqlVersion(syncSqlIncrementRequest, passport);
        }
    }

    /**
     * 获取当前登录人基本信息
     */
    @ServiceMethod(title = "获取当前登录人基本信息", method = "mobile.currentUserInfo.get", httpAction = HttpAction.POST, version = "1.0")
    public Object getCurrentUserInfo(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        CurrentUserInfoGetRequest currentUserInfoGetRequest = requestConverter.converter(CurrentUserInfoGetRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, currentUserInfoGetRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.getCurrentUserInfo(currentUserInfoGetRequest, passport);
        }
    }

    /**
     * 获取瘦咖信息（手机端选择瘦咖使用）
     */
    @ServiceMethod(title = "获取瘦咖信息（手机端选择瘦咖使用）", method = "mobile.showCal.get", httpAction = HttpAction.POST, version = "1.0")
    public Object getShowCal(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        ShowcalGetRequest showcalGetRequest = requestConverter.converter(ShowcalGetRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, showcalGetRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.getShowCal(showcalGetRequest, passport);
        }
    }

    /**
     * 查询瘦咖信息
     */
    @ServiceMethod(title = "查询瘦咖信息", method = "mobile.showCal.query", httpAction = HttpAction.POST, version = "1.0")
    public Object queryShowCal(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        ShowCalQueryRequest showCalQueryRequest = requestConverter.converter(ShowCalQueryRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, showCalQueryRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.queryShowCal(showCalQueryRequest, passport);
        }
    }

    /**
     * 选择瘦咖
     */
    @ServiceMethod(title = "选择瘦咖", method = "mobile.showCal.selected", httpAction = HttpAction.POST, version = "1.0")
    public Object selectedShowCal(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        ShowCalSelectedRequest showCalSelectedRequest = requestConverter.converter(ShowCalSelectedRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, showCalSelectedRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.selectedShowCal(showCalSelectedRequest, passport);
        }
    }

    /**
     * 获取我的瘦咖信息
     */
    @ServiceMethod(title = "获取我的瘦咖信息", method = "mobile.myShowCal.get", httpAction = HttpAction.POST, version = "1.0")
    public Object getMyShowCal(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        ShowCalGetForMyRequest showCalGetForMyRequest = requestConverter.converter(ShowCalGetForMyRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, showCalGetForMyRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.getMyShowCal(showCalGetForMyRequest, passport);
        }
    }

    /**
     * 获取我常吃的食物
     */
    @ServiceMethod(title = "获取我常吃的食物", method = "mobile.myOftenFood.get", httpAction = HttpAction.POST, version = "1.0")
    public Object getMyOftenFood(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        OftenFoodGetForMyRequest oftenFoodGetForMyRequest = requestConverter.converter(OftenFoodGetForMyRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, oftenFoodGetForMyRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.getMyOftenFood(oftenFoodGetForMyRequest, passport);
        }
    }

    /**
     * 记录身体变化曲线
     */
    @ServiceMethod(title = "记录身体变化曲线", method = "mobile.userCurve.record", httpAction = HttpAction.POST, version = "1.0")
    public Object recordUserCurve(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        UserCurveRecordRequest userCurveRecordRequest = requestConverter.converter(UserCurveRecordRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, userCurveRecordRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.recordUserCurve(userCurveRecordRequest, passport);
        }
    }

    /**
     * 瘦咖发表文章
     */
    @ServiceMethod(title = "瘦咖发表文章", method = "mobile.article.post", httpAction = HttpAction.POST, version = "1.0")
    public Object postArticle(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        ArticlePostRequest articlePostRequest = requestConverter.converter(ArticlePostRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, articlePostRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.postArticle(articlePostRequest, passport);
        }
    }

    /**
     * 记录生理期
     */
    @ServiceMethod(title = "记录生理期", method = "mobile.period.set", httpAction = HttpAction.POST, version = "1.0")
    public Object setPeriod(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        PeriodSetRequest periodSetRequest = requestConverter.converter(PeriodSetRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, periodSetRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.setPeriod(periodSetRequest, passport);
        }
    }

    /**
     * 获取生理期记录周期
     */
    @ServiceMethod(title = "获取生理期记录周期", method = "mobile.period.get", httpAction = HttpAction.POST, version = "1.0")
    public Object getPeriod(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        PeriodGetRequest periodGetRequest = requestConverter.converter(PeriodGetRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, periodGetRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.getPeriod(periodGetRequest, passport);
        }
    }

    /**
     * 发送问题
     */
    @ServiceMethod(title = "发送问题", method = "mobile.question.send", httpAction = HttpAction.POST, version = "1.0")
    public Object sendQuestion(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        QuestionCreateRequest questionCreateRequest = requestConverter.converter(QuestionCreateRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, questionCreateRequest);
        if (response != null) {
            return response;
        } else {
            return mobileService.sendQuestion(questionCreateRequest, passport);
        }
    }

    /**
     * 记录用户基本信息
     */
    @ServiceMethod(title = "记录用户基本信息", method = "mobile.userInfo.record", httpAction = HttpAction.POST, version = "1.0")
    public Object recordUserInfo(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        UserInfoRecordRequest userInfoRecordRequest = requestConverter.converter(UserInfoRecordRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, userInfoRecordRequest);
        if (response != null) {
            return response;
        } else {
            SessionUtil.remove(String.valueOf(passport.getId()));
            return mobileService.recordUserInfo(userInfoRecordRequest, passport);
        }
    }

    @ServiceMethod(title = "上传附件接口", method = "mobile.attachment.upload", httpAction = HttpAction.POST, version = "1.0")
    public Object uploadAttachment(AttachmentUploadRequest request) throws IOException {
        Passport passport = requestConverter.requestToPassport(request);
        FileItem fileItem = request.getFileData();
        FileUploadRequest uploadRequest = new FileUploadRequest();
        uploadRequest.setType(UploadTypeEnum.valueOf(request.getType()));
        uploadRequest.setFileName(request.getName());
        uploadRequest.setFileExt(fileItem.getMimeType());
        uploadRequest.setFileStream(fileItem.getContent());
        return foundationService.uploadFile(uploadRequest, passport);
    }

    @ServiceMethod(title = "获取Passport", method = "mobile.passport.get", httpAction = HttpAction.POST, version = "1.0", needInSession = NeedInSessionType.NO)
    public Object getPassport(AbstractApiRequest request) {
        String id = request.getApiRequestContext().getParamValue("id");
        if (id == null || "".equals(id)) {
            return null;
        }
        Long passportId = Long.valueOf(id);
        if (passportId != null) {
            PassportGetRequest passportGetRequest = new PassportGetRequest();
            passportGetRequest.setId(passportId);
            PassportGetResponse response = platformService.getPassport(passportGetRequest);
            return response;
        } else {
            return null;
        }
    }

    //登录
    @ServiceMethod(title = "登录", method = "mobile.user.login", httpAction = HttpAction.POST, version = "1.0", needInSession = NeedInSessionType.NO)
    public Object login(net.showcal.open.api.request.LoginRequest request) {
        String account = request.getAccount();
        String password = request.getPassword();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAccount(account);
        loginRequest.setPassword(password);
        loginRequest.setIp(request.getApiRequestContext().getIp());
        LoginResponse loginResponse = platformService.login(loginRequest);
        if (loginResponse.hasError()) {
            return loginResponse;
        }
        Passport passport = loginResponse.getPassport();
        //判断用户类型，是否是可登录类型
        if (PassportTypeEnum.EMPLOYEE.equals(passport.getType())) {
            loginResponse.addError(ErrorType.BUSINESS_ERROR, "您的身份不对，请检查");
            return loginResponse;
        }
        return loginResponse;
    }


    //同步瘦咖热控信息

    @ServiceMethod(title = "同步瘦咖热控信息", method = "mobile.heat.sync", httpAction = HttpAction.POST, version = "1.0")
    public Object syncHeat(AbstractApiRequest apirequest) {
        Passport passport = requestConverter.requestToPassport(apirequest);
        SyncHeatCreateRequest syncHeatCreateRequest = requestConverter.converter(SyncHeatCreateRequest.class, apirequest);
        HttpServletRequest request = (HttpServletRequest) apirequest.getApiRequestContext().getRawRequestObject();
        ErrorResponse response = requestConverter.doValidate(request, syncHeatCreateRequest);
        if (response != null) {
            return response;
        } else {
            return thermalControlService.createSyncHeat(syncHeatCreateRequest,passport);
        }
    }
    /**
     *  分享
     */
    @ServiceMethod(title = "分享", method = "mobile.myShowCal.forward", httpAction = HttpAction.POST, version = "1.0")
    public Object forward(AbstractApiRequest apirequest) {
        //评论增加积分
        Passport passport = requestConverter.requestToPassport(apirequest);
        IntegralDetailCreateRequest integralDetailCreateRequest=new IntegralDetailCreateRequest();
        integralDetailCreateRequest.setType(IntegralRuleTypeEnum.FORWORD.name());
        platformService.createIntegralDetail(integralDetailCreateRequest, passport);
        return null;
    }

    //第三方登录
    @ServiceMethod(title = "登录", method = "mobile.user.authlogin", httpAction = HttpAction.POST, version = "1.0", needInSession = NeedInSessionType.NO)
    public Object authLogin(AbstractApiRequest request) {
        String type = request.getApiRequestContext().getParamValue("openType");
        String openId = request.getApiRequestContext().getParamValue("openId");
        String userName = request.getApiRequestContext().getParamValue("userName");
        LoginResponse loginResponse = new LoginResponse();
        if("QQ".equals(type)||"WECHAT".equals(type)){
            // 判断openId 是否存在
            Passport passport = new Passport();
            passport.setUserId(20001L);
            passport.setUserName("第三方登录");
            UserExistByOpenIdRequest existByOpenIdRequest = new UserExistByOpenIdRequest();
            existByOpenIdRequest.setType(OpenTypeEnum.valueOf(type));
            existByOpenIdRequest.setOpenId(openId);
            UserExistByOpenIdResponse existByOpenIdResponse = platformService.userExistByOpenId(existByOpenIdRequest, passport);
            if(existByOpenIdResponse!=null&&!existByOpenIdResponse.hasError()){
                if(existByOpenIdResponse.getIsExist()){
                    // 模拟登录，颁发Passport
                    LoginByOpenIdRequest loginByOpenIdRequest = new LoginByOpenIdRequest();
                    loginByOpenIdRequest.setOpenId(openId);
                    loginByOpenIdRequest.setType(OpenTypeEnum.valueOf(type));
                    LoginByOpenIdResponse openIdResponse = platformService.LoginByOpenId(loginByOpenIdRequest, passport);
                    loginResponse.setPassport(openIdResponse.getPassport());
                    return loginResponse;
                }else{
                    SysUserCreateRequest sysUserCreateRequest = new SysUserCreateRequest();
                    sysUserCreateRequest.setNickName(userName);
                    sysUserCreateRequest.setUserType(UserTypeEnum.USER);
                    sysUserCreateRequest.setName(userName);
                    sysUserCreateRequest.setAccount(userName);
                    sysUserCreateRequest.setPassword("");
                    if("QQ".equals(type)){
                        sysUserCreateRequest.setQq(openId);
                    }
                    if("WECHAT".equals(type)){
                        sysUserCreateRequest.setWechat(openId);
                    }
                    // 不存在，创建用户
                    SysUserCreateResponse createResponse =  platformService.createSysUser(sysUserCreateRequest, passport);
                    if(createResponse!=null&&!createResponse.hasError()){
                        // 模拟登录，颁发Passport
                        LoginByOpenIdRequest loginByOpenIdRequest = new LoginByOpenIdRequest();
                        loginByOpenIdRequest.setOpenId(openId);
                        loginByOpenIdRequest.setType(OpenTypeEnum.valueOf(type));
                        LoginByOpenIdResponse openIdResponse = platformService.LoginByOpenId(loginByOpenIdRequest, passport);
                        loginResponse.setPassport(openIdResponse.getPassport());
                        return loginResponse;
                    }
                }
            }
        }
        return loginResponse;
    }
}
