package net.showcal.service.module.screen;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.foundation.domain.UploadTypeEnum;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.request.FileUploadRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.response.FileUploadResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.domain.UserDetail;
import com.showcal.service.domain.MyRepositoryImport;
import com.showcal.service.domain.RepositoryImport;
import com.showcal.service.request.*;
import com.showcal.service.response.ServiceHistoryUserGetResponse;
import com.showcal.service.response.ServiceUserGetListForMyResponse;
import com.showcal.thermalcontrol.domain.FoodImport;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.Excel;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import net.showcal.service.helper.ServiceHelper;
import net.showcal.tool.Constants;
import net.showcal.tool.SocketSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.service.module.screen.Api
 *  Description: service 的API信息
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
    private ServiceHelper serviceHelper;

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
                // 创建欢迎语
                case "api.service.welcome.create":
                    baseResponse = createWelcome(jsonObject, passport);
                    break;
                // 获取特定欢迎语
                case "api.service.welcome.get":
                    baseResponse = getWelcome(jsonObject, passport);
                    break;
                // 更新欢迎语
                case "api.service.welcome.update":
                    baseResponse = updateWelcome(jsonObject, passport);
                    break;
                // 删除欢迎语
                case "api.service.welcome.delete":
                    baseResponse = deleteWelcome(jsonObject, passport);
                    break;
                // 作废欢迎语
                case "api.service.welcome.inactive":
                    baseResponse = inactiveWelcome(jsonObject, passport);
                    break;
                case "api.service.message.history.get":
                    baseResponse = getMessageHistory(jsonObject, passport);
                    break;
                // 激活欢迎语
                case "api.service.welcome.active":
                    baseResponse = activeWelcome(jsonObject, passport);
                    break;
                // 获取我所有的欢迎语
                case "api.service.mywelcomelist.get":
                    baseResponse = getMyWelComeList(jsonObject, passport);
                    break;
                // 获取我的瘦咖的欢迎语
                case "api.service.myshowcalwelcome.get":
                    baseResponse = getMyShowCalWelCome(jsonObject, passport);
                    break;
                // 创建用户服务表
                case "api.service.serviceuser.create":
                    baseResponse = createServiceUser(jsonObject, passport);
                    break;
                // 删除用户服务表
                case "api.service.serviceuser.delete":
                    baseResponse = deleteServiceUser(jsonObject, passport);
                    break;
                // 获取我当前所有服务的用户信息
                case "api.service.myserviceuser.get":
                    baseResponse = getMyServiceUser(jsonObject, passport);
                    break;
                // 获取我历史上服务的所有用户
                case "api.service.myhistoryserviceuser.get":
                    baseResponse = getMyHistoryServiceUser(jsonObject, passport);
                    break;
                // 获取当前服务我的瘦咖
                case "api.service.myshowcal.get":
                    baseResponse = getMyShowCal(jsonObject, passport);
                    break;
                // 获取所有历史服务于我的瘦咖
                case "api.service.myhistoryshowcal.get":
                    baseResponse = getMyHistoryShowCal(jsonObject, passport);
                    break;
                // 高级查询知识库
                case "api.service.repository.find":
                    baseResponse = findRepository(jsonObject, passport);
                    break;
                // 创建知识库
                case "api.service.repository.create":
                    baseResponse = createRepository(jsonObject, passport);
                    break;
                // 更新知识库
                case "api.service.repository.update":
                    baseResponse = updateRepository(jsonObject, passport);
                    break;
                // 删除知识库
                case "api.service.repository.delete":
                    baseResponse = deleteRepository(jsonObject, passport);
                    break;
                // 发布知识库
                case "api.service.repository.active":
                    baseResponse = activeRepository(jsonObject, passport);
                    break;
                // 取消发布知识库
                case "api.service.repository.inactive":
                    baseResponse = inactiveRepository(jsonObject, passport);
                    break;
                // 转到系统知识库
                case "api.service.repository.to.platform":
                    baseResponse = toPlatformRepository(jsonObject, passport);
                    break;
                // 转回瘦咖知识库
                case "api.service.repository.to.showcal":
                    baseResponse = toShowcalRepository(jsonObject, passport);
                    break;
                // 获取所有我的知识库
                case "api.service.myrepository.get":
                    baseResponse = getMyRepository(jsonObject, passport);
                    break;
                case "api.service.systemrepository.get":
                    baseResponse = getSystemRepository(jsonObject, passport);
                    break;
                // 转让我的知识库(预留)
                case "api.service.myrepository.transfer":
                    baseResponse = transferMyRepository(jsonObject, passport);
                    break;
                // 下载模版
                case "api.service.repository.output.template":
                    baseResponse = outputRepositoryTemplate(passport);
                    break;
                // 下载我的知识库模版
                case "api.service.my.repository.output.template":
                    baseResponse = outputMyRepositoryTemplate(passport);
                    break;
                // 创建问题
                case "api.service.question.send":
                    baseResponse = sendQuestion(jsonObject, passport);
                    break;
                // 获取我提出的历史问题
                case "api.service.myaskhistoryquestion.get":
                    baseResponse = getMyAskHistoryQuestion(jsonObject, passport);
                    break;
                case "api.service.question.history.find":
                    baseResponse = findQuestionHistory(jsonObject, passport);
                    break;
                // 获取我未回答的所有问题汇总
                case "api.service.mywillanswerquestion.get":
                    baseResponse = getMyWillAnswerQuestion(jsonObject,passport);
                    break;
                // 获取历史消息(与我对话的所有消息)
                case "api.service.myhistorymessage.get":
                    baseResponse = getMyHistoryMessage(jsonObject,passport);
                    break;
                // 发送答案信息
                case "api.service.answer.send":
                    baseResponse = sendAnswer(jsonObject,passport);
                    break;
                // 问题批量关闭
                case "api.service.questions.close":
                    baseResponse = closeQuestions(jsonObject,passport);
                    break;
                // 高级查询用户投诉
                case "api.service.complatint.find":
                    baseResponse = findComplatint(jsonObject, passport);
                    break;
                // 创建用户投诉
                case "api.service.complatint.create":
                    baseResponse = createComplatint(jsonObject, passport);
                    break;
                // 更新用户投诉
                case "api.service.complatint.update":
                    baseResponse = updateComplatint(jsonObject, passport);
                    break;
                // 删除用户投诉
                case "api.service.complatint.delete":
                    baseResponse = deleteComplatint(jsonObject, passport);
                    break;
                // 根据Id获取用户投诉
                case "api.service.complatint.get":
                    baseResponse = getComplatint(jsonObject, passport);
                    break;
                default:
                    baseResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_METHOD);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(ex));
        } finally {
            String jsonTenant = JSON.toJSONString(baseResponse);
            PrintWriter out = response.getWriter();
            out.println(jsonTenant);
        }
    }

    /**
     * 获取系统知识库
     * @param jsonObject
     * @param passport
     * @return
     */
    private BaseResponse getSystemRepository(JSONObject jsonObject, Passport passport) {
        RepositorySystemGetRequest getRequest = JSON.toJavaObject(jsonObject,RepositorySystemGetRequest.class);
        return serviceHelper.getSystemRepository(getRequest,passport);
    }

    /**
     * 创建欢迎语
     */
    private BaseResponse createWelcome(JSONObject jsonObject, Passport passport) {
        WelcomeCreateRequest request = JSON.toJavaObject(jsonObject, WelcomeCreateRequest.class);
        return serviceHelper.createWelcome(request, passport);
    }

    /**
     * 获取欢迎语
     */
    private BaseResponse getWelcome(JSONObject jsonObject, Passport passport) {
        WelcomeGetRequest request = JSON.toJavaObject(jsonObject, WelcomeGetRequest.class);
        return serviceHelper.getWelcome(request, passport);
    }

    /**
     * 更新欢迎语
     */
    private BaseResponse updateWelcome(JSONObject jsonObject, Passport passport) {
        WelcomeUpdateRequest request = JSON.toJavaObject(jsonObject, WelcomeUpdateRequest.class);
        return serviceHelper.updateWelcome(request, passport);
    }

    /**
     * 删除欢迎语
     */
    private BaseResponse deleteWelcome(JSONObject jsonObject, Passport passport) {
        WelcomeDeleteRequest request = JSON.toJavaObject(jsonObject, WelcomeDeleteRequest.class);
        return serviceHelper.deleteWelcome(request, passport);
    }

    /**
     * 作废欢迎语
     */
    private BaseResponse inactiveWelcome(JSONObject jsonObject, Passport passport) {
        WelcomeInactiveRequest request = JSON.toJavaObject(jsonObject, WelcomeInactiveRequest.class);
        return serviceHelper.inactiveWelcome(request, passport);
    }

    /**
     * 激活欢迎语
     */
    private BaseResponse activeWelcome(JSONObject jsonObject, Passport passport) {
        WelcomeActiveRequest request = JSON.toJavaObject(jsonObject, WelcomeActiveRequest.class);
        return serviceHelper.activeWelcome(request, passport);
    }

    /**
     * 获取我所有的欢迎语
     */
    private BaseResponse getMyWelComeList(JSONObject jsonObject, Passport passport) {
        WelcomeFindRequest request = JSON.toJavaObject(jsonObject, WelcomeFindRequest.class);
        //return serviceHelper.getMyWelComeList(request, passport);
        return serviceHelper.findMyWelComeList(request, passport);
    }

    /**
     * 获取我的瘦咖的欢迎语
     */
    private BaseResponse getMyShowCalWelCome(JSONObject jsonObject, Passport passport) {
        WelcomeGetForMyRequest request = JSON.toJavaObject(jsonObject, WelcomeGetForMyRequest.class);
        return serviceHelper.getMyShowCalWelCome(request, passport);
    }

    /**
     * 创建用户服务表
     */
    private BaseResponse createServiceUser(JSONObject jsonObject, Passport passport) {
        ServiceUserCreateRequest request = JSON.toJavaObject(jsonObject, ServiceUserCreateRequest.class);
        return serviceHelper.createServiceUser(request, passport);
    }

    /**
     * 删除用户服务表
     */
    private BaseResponse deleteServiceUser(JSONObject jsonObject, Passport passport) {
        ServiceUserDeleteRequest request = JSON.toJavaObject(jsonObject, ServiceUserDeleteRequest.class);
        return serviceHelper.deleteServiceUser(request, passport);
    }

    /**
     * 获取我当前所有服务的用户信息
     */
    private BaseResponse getMyServiceUser(JSONObject jsonObject, Passport passport) {
        ServiceUserGetListForMyRequest request = JSON.toJavaObject(jsonObject, ServiceUserGetListForMyRequest.class);
        ServiceUserGetListForMyResponse response = serviceHelper.getMyServiceUser(request, passport);
        List<UserDetail> users = response.getResult();
        if(users != null && !users.isEmpty()){
            for(UserDetail user : users){
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
        return response;
    }

    /**
     * 获取我历史上服务的所有用户
     */
    private BaseResponse getMyHistoryServiceUser(JSONObject jsonObject, Passport passport) {
        ServiceHistoryUserGetRequest request = JSON.toJavaObject(jsonObject, ServiceHistoryUserGetRequest.class);
        ServiceHistoryUserGetResponse response = serviceHelper.getMyHistoryServiceUser(request, passport);
        List<UserDetail> users = response.getResult();
        if(users != null && !users.isEmpty()){
            for(UserDetail user : users){
                if (user.getAvatarId() != null) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(user.getAvatarId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    user.setAvatarurl(filePathGetResponse.getUrl());
                } else {
                    user.setAvatarurl("../styles/images/avatar_default.png");
                }
            }
        }
        return response;
    }

    /**
     * 获取当前服务我的瘦咖
     */
    private BaseResponse getMyShowCal(JSONObject jsonObject, Passport passport) {
        ShowCalGetForMyRequest request = JSON.toJavaObject(jsonObject, ShowCalGetForMyRequest.class);
        return serviceHelper.getMyShowCal(request, passport);
    }

    /**
     * 获取所有历史服务于我的瘦咖
     */
    private BaseResponse getMyHistoryShowCal(JSONObject jsonObject, Passport passport) {
        ShowCalHistoryGetRequest request = JSON.toJavaObject(jsonObject, ShowCalHistoryGetRequest.class);
        return serviceHelper.getMyHistoryShowCal(request, passport);
    }

    /**
     * 高级查询知识库
     */
    private BaseResponse findRepository(JSONObject jsonObject, Passport passport) {
        RepositoryFindRequest request = JSON.toJavaObject(jsonObject, RepositoryFindRequest.class);
        return serviceHelper.findRepository(request, passport);
    }

    /**
     * 创建知识库
     */
    private BaseResponse createRepository(JSONObject jsonObject, Passport passport) {
        RepositoryCreateRequest request = JSON.toJavaObject(jsonObject, RepositoryCreateRequest.class);
        return serviceHelper.createRepository(request, passport);
    }

    /**
     * 更新知识库
     */
    private BaseResponse updateRepository(JSONObject jsonObject, Passport passport) {
        RepositoryUpdateRequest request = JSON.toJavaObject(jsonObject, RepositoryUpdateRequest.class);
        return serviceHelper.updateRepository(request, passport);
    }

    /**
     * 删除知识库
     */
    private BaseResponse deleteRepository(JSONObject jsonObject, Passport passport) {
        RepositoryDeleteRequest request = JSON.toJavaObject(jsonObject, RepositoryDeleteRequest.class);
        return serviceHelper.deleteRepository(request, passport);
    }

    /**
     * 更新知识库
     */
    private BaseResponse activeRepository(JSONObject jsonObject, Passport passport) {
        RepositoryActiveRequest request = JSON.toJavaObject(jsonObject, RepositoryActiveRequest.class);
        return serviceHelper.activeRepository(request, passport);
    }

    /**
     * 更新知识库
     */
    private BaseResponse inactiveRepository(JSONObject jsonObject, Passport passport) {
        RepositoryInactiveRequest request = JSON.toJavaObject(jsonObject, RepositoryInactiveRequest.class);
        return serviceHelper.inactiveRepository(request, passport);
    }

    /**
     * 转至系统知识库
     */
    private BaseResponse toPlatformRepository(JSONObject jsonObject, Passport passport) {
        RepositoryToPlatformRequest request = JSON.toJavaObject(jsonObject, RepositoryToPlatformRequest.class);
        return serviceHelper.toPlatformRepository(request, passport);
    }

    /**
     * 转回瘦咖知识库
     */
    private BaseResponse toShowcalRepository(JSONObject jsonObject, Passport passport) {
        RepositoryToShowcalRequest request = JSON.toJavaObject(jsonObject, RepositoryToShowcalRequest.class);
        return serviceHelper.toShowcalRepository(request, passport);
    }

    /**
     * 获取所有我的知识库(包含我自己，与平台的)
     */
    private BaseResponse getMyRepository(JSONObject jsonObject, Passport passport) {
        RepositoryGetForMyRequest request = JSON.toJavaObject(jsonObject, RepositoryGetForMyRequest.class);
        return serviceHelper.getMyRepository(request, passport);
    }

    /**
     * 转让我的知识库(预留)
     */
    private BaseResponse transferMyRepository(JSONObject jsonObject, Passport passport) {
        MyRepositoryTransferRequest request = JSON.toJavaObject(jsonObject, MyRepositoryTransferRequest.class);
        return serviceHelper.transferMyRepository(request, passport);
    }

    /**
     *  下载模版
     *
     * @param passport
     * @return
     */
    private FileUploadResponse outputRepositoryTemplate(Passport passport) throws IOException {
        FileUploadResponse uploadResponse = new FileUploadResponse();
        DataTable<RepositoryImport> table = new DataTable<>(RepositoryImport.class);
        byte[] bytes = new Excel(table).getBytes();
        FileUploadRequest uploadRequest = new FileUploadRequest();
        uploadRequest.setFileStream(bytes);
        uploadRequest.setFileExt("xlsx");
        uploadRequest.setType(UploadTypeEnum.TMP);
        uploadResponse = foundationService.uploadFile(uploadRequest, passport);
        return uploadResponse;
    }

    /**
     *  下载我的知识库模版
     *
     * @param passport
     * @return
     */
    private FileUploadResponse outputMyRepositoryTemplate(Passport passport) throws IOException {
        FileUploadResponse uploadResponse = new FileUploadResponse();
        DataTable<MyRepositoryImport> table = new DataTable<>(MyRepositoryImport.class);
        byte[] bytes = new Excel(table).getBytes();
        FileUploadRequest uploadRequest = new FileUploadRequest();
        uploadRequest.setFileStream(bytes);
        uploadRequest.setFileExt("xlsx");
        uploadRequest.setType(UploadTypeEnum.TMP);
        uploadResponse = foundationService.uploadFile(uploadRequest, passport);
        return uploadResponse;
    }

    /**
     * 创建问题
     */
    private BaseResponse sendQuestion(JSONObject jsonObject, Passport passport) {
        QuestionCreateRequest request = JSON.toJavaObject(jsonObject, QuestionCreateRequest.class);
        return serviceHelper.sendQuestion(request, passport);
    }

    /**
     * 获取我提出的历史问题
     */
    private BaseResponse getMyAskHistoryQuestion(JSONObject jsonObject, Passport passport) {
        QuestionHistoryGetForMyResuest request = JSON.toJavaObject(jsonObject, QuestionHistoryGetForMyResuest.class);
        return serviceHelper.getMyAskHistoryQuestion(request, passport);
    }

    /**
     * 获取我未回答的所有问题
     */
    private BaseResponse getMyWillAnswerQuestion(JSONObject jsonObject, Passport passport) {
        QuestionWillAnswerForMyRequest request = JSON.toJavaObject(jsonObject, QuestionWillAnswerForMyRequest.class);
        return serviceHelper.getMyWillAnswerQuestion(request, passport);
    }

    /**
     * 获取历史消息(与我对话的所有消息)
     */
    private BaseResponse getMyHistoryMessage(JSONObject jsonObject, Passport passport) {
        MessageHistoryGetRequest request = JSON.toJavaObject(jsonObject, MessageHistoryGetRequest.class);
//        request.setUserId(passport.getUserId());
        if("".equals(request.getKeyword())){
            request.setKeyword(null);
        }
        return serviceHelper.getMyHistoryMessage(request, passport);
    }

    /**
     * 发送答案信息
     */
    private BaseResponse sendAnswer(JSONObject jsonObject, Passport passport) {
        AnswerSendRequest request = JSON.toJavaObject(jsonObject, AnswerSendRequest.class);

        SocketSessionUtils.broadcast(request.getUserIds(), request.getContent());
        return serviceHelper.sendAnswer(request, passport);
    }

    /**
     * 问题批量关闭
     */
    private BaseResponse closeQuestions(JSONObject jsonObject, Passport passport) {
        QuestionCloseRequest request = JSON.toJavaObject(jsonObject, QuestionCloseRequest.class);
        return serviceHelper.closeQuestions(request, passport);
    }

    /**
     * 高级查询用户投诉
     */
    private BaseResponse findComplatint(JSONObject jsonObject, Passport passport) {
        ComplatintFindRequest request = JSON.toJavaObject(jsonObject, ComplatintFindRequest.class);
        return serviceHelper.findComplatint(request, passport);
    }

    /**
     * 创建用户投诉
     */
    private BaseResponse createComplatint(JSONObject jsonObject, Passport passport) {
        ComplatintCreateRequest request = JSON.toJavaObject(jsonObject, ComplatintCreateRequest.class);
        return serviceHelper.createComplatint(request, passport);
    }

    /**
     * 更新用户投诉
     */
    private BaseResponse updateComplatint(JSONObject jsonObject, Passport passport) {
        ComplatintUpdateRequest request = JSON.toJavaObject(jsonObject, ComplatintUpdateRequest.class);
        return serviceHelper.updateComplatint(request, passport);
    }

    /**
     * 删除用户投诉
     */
    private BaseResponse deleteComplatint(JSONObject jsonObject, Passport passport) {
        ComplatintDeleteRequest request = JSON.toJavaObject(jsonObject, ComplatintDeleteRequest.class);
        return serviceHelper.deleteComplatint(request, passport);
    }

    /**
     * 根据Id获取用户投诉
     */
    private BaseResponse getComplatint(JSONObject jsonObject, Passport passport) {
        ComplatintGetRequest request = JSON.toJavaObject(jsonObject, ComplatintGetRequest.class);
        return serviceHelper.getComplatint(request, passport);
    }
    private BaseResponse findQuestionHistory(JSONObject jsonObject, Passport passport) {
        QuestionFindRequest request = JSON.toJavaObject(jsonObject, QuestionFindRequest.class);
        return serviceHelper.findHistoryQuestion(request, passport);
    }
    private BaseResponse getMessageHistory(JSONObject jsonObject,Passport passport){
        MessageHistoryGetRequest request = JSON.toJavaObject(jsonObject, MessageHistoryGetRequest.class);
        return serviceHelper.getMyHistoryMessage(request, passport);
    }

}