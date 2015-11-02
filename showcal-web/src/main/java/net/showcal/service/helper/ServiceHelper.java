package net.showcal.service.helper;

import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.showcal.thermalcontrol.request.FoodListImportRequest;
import com.showcal.thermalcontrol.response.FoodListImportResponse;
import com.xiniunet.framework.security.Passport;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.service.helper.ServiceHelper
 *  Description: service Helper 接口
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public interface ServiceHelper {
    /**
     * 创建欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    WelcomeCreateResponse createWelcome(WelcomeCreateRequest request, Passport passport);

    /**
     * 获取特定欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    WelcomeGetResponse getWelcome(WelcomeGetRequest request, Passport passport);

    /**
     * 更新欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    WelcomeUpdateResponse updateWelcome(WelcomeUpdateRequest request, Passport passport);

    /**
     * 删除欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    WelcomeDeleteResponse deleteWelcome(WelcomeDeleteRequest request, Passport passport);

    /**
     * 作废欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    WelcomeInactiveResponse inactiveWelcome(WelcomeInactiveRequest request, Passport passport);

    /**
     * 激活欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    WelcomeActiveResponse activeWelcome(WelcomeActiveRequest request, Passport passport);

    /**
     * 获取我所有的欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    WelComeGetListForMyResponse getMyWelComeList(WelcomeGetListForMyRequest request, Passport passport);

    WelcomeFindResponse findMyWelComeList(WelcomeFindRequest request, Passport passport);

    /**
     * 获取我的瘦咖的欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    WelComeGetForMyResponse getMyShowCalWelCome(WelcomeGetForMyRequest request, Passport passport);

    /**
     * 创建用户服务表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ServiceUserCreateResponse createServiceUser(ServiceUserCreateRequest request, Passport passport);

    /**
     * 删除用户服务表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ServiceUserDeleteResponse deleteServiceUser(ServiceUserDeleteRequest request, Passport passport);

    /**
     * 获取我当前所有服务的用户信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ServiceUserGetListForMyResponse getMyServiceUser(ServiceUserGetListForMyRequest request, Passport passport);

    /**
     * 获取我历史上服务的所有用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ServiceHistoryUserGetResponse getMyHistoryServiceUser(ServiceHistoryUserGetRequest request, Passport passport);

    /**
     * 获取当前服务我的瘦咖
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ShowCalGetForMyResponse getMyShowCal(ShowCalGetForMyRequest request, Passport passport);

    /**
     * 获取所有历史服务于我的瘦咖
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ShowCalHistoryGetResponse getMyHistoryShowCal(ShowCalHistoryGetRequest request, Passport passport);

    /**
     * 高级查询知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryFindResponse findRepository(RepositoryFindRequest request, Passport passport);

    /**
     * 创建知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryCreateResponse createRepository(RepositoryCreateRequest request, Passport passport);

    /**
     * 更新知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryUpdateResponse updateRepository(RepositoryUpdateRequest request, Passport passport);

    /**
     * 删除知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryDeleteResponse deleteRepository(RepositoryDeleteRequest request, Passport passport);

    /**
     * 发布知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryActiveResponse activeRepository(RepositoryActiveRequest request, Passport passport);

    /**
     * 取消发布知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryInactiveResponse inactiveRepository(RepositoryInactiveRequest request, Passport passport);

    /**
     * 转至系统知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryToPlatformResponse toPlatformRepository(RepositoryToPlatformRequest request, Passport passport);

    /**
     * 转回瘦咖知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryToShowcalResponse toShowcalRepository(RepositoryToShowcalRequest request, Passport passport);

    /**
     * 获取所有我的知识库(包含我自己，与平台的)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryGetForMyResponse getMyRepository(RepositoryGetForMyRequest request, Passport passport);

    /**
     * 获取系统知识库
     *
     * @param request
     * @param passport
     * @return
     */
    RepositorySystemGetResponse getSystemRepository(RepositorySystemGetRequest request, Passport passport);

    /**
     * 转让我的知识库(预留)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MyRepositoryTransferResponse transferMyRepository(MyRepositoryTransferRequest request, Passport passport);

    /**
     *  上传知识库列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    RepositoryListImportResponse importRepositoryList(RepositoryListImportRequest request, Passport passport);

    /**
     *  上传我的知识库列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MyRepositoryListImportResponse importMyRepositoryList(MyRepositoryListImportRequest request, Passport passport);

    /**
     * 创建问题
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    QuestionCreateResponse sendQuestion(QuestionCreateRequest request, Passport passport);

    /**
     * 获取我提出的历史问题
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    QuestionHistoryGetForMyResponse getMyAskHistoryQuestion(QuestionHistoryGetForMyResuest request, Passport passport);

    /**
     * 获取我未回答的所有问题
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    QuestionWillAnswerForMyResponse getMyWillAnswerQuestion(QuestionWillAnswerForMyRequest request, Passport passport);

    /**
     * 获取历史消息(与我对话的所有消息)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MessageHistoryGetResponse getMyHistoryMessage(MessageHistoryGetRequest request, Passport passport);

    /**
     * 发送答案信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    AnswerSendResponse sendAnswer(AnswerSendRequest request, Passport passport);

    /**
     * 问题批量关闭
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    QuestionCloseResponse closeQuestions(QuestionCloseRequest request, Passport passport);

    /**
     * 高级查询用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ComplatintFindResponse findComplatint(ComplatintFindRequest request, Passport passport);

    /**
     * 创建用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ComplatintCreateResponse createComplatint(ComplatintCreateRequest request, Passport passport);

    /**
     * 更新用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ComplatintUpdateResponse updateComplatint(ComplatintUpdateRequest request, Passport passport);

    /**
     * 删除用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ComplatintDeleteResponse deleteComplatint(ComplatintDeleteRequest request, Passport passport);

    /**
     * 根据Id获取用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    ComplatintGetResponse getComplatint(ComplatintGetRequest request, Passport passport);
    /**
     * 保存自我介绍
     * @param request
     * @param passport 用户护照
     * @return
     */
    SelfIntroductionSaveResponse saveSelfIntroduction(SelfIntroductionSaveRequest request, Passport passport);
    /**
     * 获取自我介绍
     * @param request
     * @param passport 用户护照
     * @return
     */
    SelfIntroductionGetResponse getSelfIntroduction(SelfIntroductionGetRequest request, Passport passport);

    QuestionFindResponse findHistoryQuestion(QuestionFindRequest request, Passport passport);

}