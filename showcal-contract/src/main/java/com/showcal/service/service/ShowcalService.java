package com.showcal.service.service;

import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.service
 *  Description:
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.service.service
 * </pre>
 */
public interface ShowcalService {

    /**
     * 根据Id获取欢迎语
     *
     * @param request  获取欢迎语请求
     * @param passport 用户护照
     * @return 获取欢迎语应答
     */
    WelcomeGetResponse getWelcome(WelcomeGetRequest request, Passport passport);


    /**
     * 模糊查询欢迎语
     *
     * @param request  模糊查询欢迎语请求
     * @param passport 用户护照
     * @return 模糊查询欢迎语应答
     */
    WelcomeSearchResponse searchWelcome(WelcomeSearchRequest request, Passport passport);

    /**
     * 高级查询欢迎语
     *
     * @param request  高级查询欢迎语请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    WelcomeFindResponse findWelcome(WelcomeFindRequest request, Passport passport);

    /**
     * 获取所有欢迎语列表
     *
     * @param request  获取所有欢迎语列表请求
     * @param passport 用户护照
     * @return 获取所有欢迎语列表应答
     */
    WelcomeGetAllListResponse getWelcomeAllList(WelcomeGetAllListRequest request, Passport passport);

    /**
     * 获取我的欢迎语
     *
     * @param request  获取所有欢迎语列表请求
     * @param passport 用户护照
     * @return 获取所有欢迎语列表应答
     */
    WelComeGetForMyResponse getMyShowCalWelCome(WelcomeGetForMyRequest request, Passport passport);


    /**
     * 创建欢迎语
     *
     * @param request  创建欢迎语请求
     * @param passport 用户护照
     * @return 创建欢迎语应答
     */
    WelcomeCreateResponse createWelcome(WelcomeCreateRequest request, Passport passport);


    /**
     * 更新欢迎语
     *
     * @param request  更新欢迎语请求
     * @param passport 用户护照
     * @return 更新欢迎语应答
     */
    WelcomeUpdateResponse updateWelcome(WelcomeUpdateRequest request, Passport passport);


    /**
     * 删除欢迎语
     *
     * @param request  删除欢迎语请求
     * @param passport 用户护照
     * @return 删除欢迎语应答
     */
    WelcomeDeleteResponse deleteWelcome(WelcomeDeleteRequest request, Passport passport);


    /**
     * 作废欢迎语
     *
     * @param request  作废欢迎语请求
     * @param passport 用户护照
     * @return 作废欢迎语应答
     */
    WelcomeInactiveResponse inactiveWelcome(WelcomeInactiveRequest request, Passport passport);


    /**
     * 激活欢迎语
     *
     * @param request  激活欢迎语请求
     * @param passport 用户护照
     * @return 激活欢迎语应答
     */
    WelcomeActiveResponse activeWelcome(WelcomeActiveRequest request, Passport passport);


    /**
     * 导入欢迎语
     *
     * @param request  导入欢迎语请求
     * @param passport 用户护照
     * @return 导入欢迎语应答
     */
    WelcomeListImportResponse importWelcomeList(WelcomeListImportRequest request, Passport passport);

    /**
     * 创建用户服务表
     *
     * @param request  创建用户服务表请求
     * @param passport 用户护照
     * @return 创建用户服务表应答
     */
    ServiceUserCreateResponse createServiceUser(ServiceUserCreateRequest request, Passport passport);


    /**
     * 删除用户服务表
     *
     * @param request  删除用户服务表请求
     * @param passport 用户护照
     * @return 删除用户服务表应答
     */
    ServiceUserDeleteResponse deleteServiceUser(ServiceUserDeleteRequest request, Passport passport);

    /**
     * 获取我当前所有服务的用户信息
     *
     * @param request
     * @param passport
     * @return
     */
    ServiceUserGetListForMyResponse getMyServiceUser(ServiceUserGetListForMyRequest request, Passport passport);

    /**
     * 获取我历史上服务的所有用户
     *
     * @param request
     * @param passport
     * @return
     */
    ServiceHistoryUserGetResponse getMyHistoryServiceUser(ServiceHistoryUserGetRequest request, Passport passport);

    /**
     * 获取当前服务我的瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    ShowCalGetForMyResponse getMyShowCal(ShowCalGetForMyRequest request, Passport passport);

    /**
     * 获取所有历史服务于我的瘦咖
     *
     * @param request
     * @param passport
     * @return
     */
    ShowCalHistoryGetResponse getMyHistoryShowCal(ShowCalHistoryGetRequest request, Passport passport);


    /**
     * 高级查询知识库
     *
     * @param request  高级查询知识库请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    RepositoryFindResponse findRepository(RepositoryFindRequest request, Passport passport);

    /**
     * 创建知识库
     *
     * @param request  创建知识库请求
     * @param passport 用户护照
     * @return 创建知识库应答
     */
    RepositoryCreateResponse createRepository(RepositoryCreateRequest request, Passport passport);

    /**
     * 高级查询历史问题问题
     *
     * @param request  高级查询问题请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    QuestionFindResponse findHistoryQuestion(QuestionFindRequest request, Passport passport);


    /**
     * 更新知识库
     *
     * @param request  更新知识库请求
     * @param passport 用户护照
     * @return 更新知识库应答
     */
    RepositoryUpdateResponse updateRepository(RepositoryUpdateRequest request, Passport passport);


    /**
     * 删除知识库
     *
     * @param request  删除知识库请求
     * @param passport 用户护照
     * @return 删除知识库应答
     */
    RepositoryDeleteResponse deleteRepository(RepositoryDeleteRequest request, Passport passport);

    /**
     * 发布知识库
     *
     * @param request  删除知识库请求
     * @param passport 用户护照
     * @return 删除知识库应答
     */
    RepositoryActiveResponse activeRepository(RepositoryActiveRequest request, Passport passport);

    /**
     * 取消发布知识库
     *
     * @param request  删除知识库请求
     * @param passport 用户护照
     * @return 删除知识库应答
     */
    RepositoryInactiveResponse inactiveRepository(RepositoryInactiveRequest request, Passport passport);

    /**
     *  转至系统知识库
     *
     * @param request
     * @param passport
     * @return
     */
    RepositoryToPlatformResponse toPlatformRepository(RepositoryToPlatformRequest request, Passport passport);

    /**
     *  转回瘦咖知识库
     *
     * @param request
     * @param passport
     * @return
     */
    RepositoryToShowcalResponse toShowcalRepository(RepositoryToShowcalRequest request, Passport passport);

    /**
     * 获取所有我的知识库(包含我自己，与平台的)
     *
     * @param request
     * @param passport
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
     * @param passport
     * @return
     */
    MyRepositoryTransferResponse transferMyRepository(MyRepositoryTransferRequest request, Passport passport);

    /**
     *  导入知识库列表
     *
     * @param request
     * @param passport
     * @return
     */
    RepositoryListImportResponse importRepositoryList(RepositoryListImportRequest request, Passport passport);

    /**
     *  导入我的知识库列表
     *
     * @param request
     * @param passport
     * @return
     */
    MyRepositoryListImportResponse importMyRepositoryList(MyRepositoryListImportRequest request, Passport passport);

    /**
     * 创建问题
     *
     * @param request  创建问题请求
     * @param passport 用户护照
     * @return 创建问题应答
     */
    QuestionCreateResponse sendQuestion(QuestionCreateRequest request, Passport passport);

    /**
     * 获取我提出的历史问题
     *
     * @param resuest
     * @param passport
     * @return
     */
    QuestionHistoryGetForMyResponse getMyAskHistoryQuestion(QuestionHistoryGetForMyResuest resuest, Passport passport);

    /**
     * 获取我未回答的所有问题汇总
     *
     * @param request
     * @param passport
     * @return
     */
    QuestionWillAnswerForMyResponse getMyWillAnswerQuestion(QuestionWillAnswerForMyRequest request, Passport passport);

    /**
     * 获取历史消息(与我对话的所有消息)
     *
     * @param request
     * @param passport
     * @return
     */
    MessageHistoryGetResponse getMyHistoryMessage(MessageHistoryGetRequest request, Passport passport);

    /**
     * 发送答案信息
     *
     * @param request
     * @param passport
     * @return
     */
    AnswerSendResponse sendAnswer(AnswerSendRequest request, Passport passport);

    /**
     * 问题批量关闭
     *
     * @param request
     * @param passport
     * @return
     */
    QuestionCloseResponse closeQuestions(QuestionCloseRequest request, Passport passport);

    /**
     * 高级查询用户投诉
     *
     * @param request  高级查询用户投诉请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    ComplatintFindResponse findComplatint(ComplatintFindRequest request, Passport passport);


    /**
     * 创建用户投诉
     *
     * @param request  创建用户投诉请求
     * @param passport 用户护照
     * @return 创建用户投诉应答
     */
    ComplatintCreateResponse createComplatint(ComplatintCreateRequest request, Passport passport);


    /**
     * 更新用户投诉
     *
     * @param request  更新用户投诉请求
     * @param passport 用户护照
     * @return 更新用户投诉应答
     */
    ComplatintUpdateResponse updateComplatint(ComplatintUpdateRequest request, Passport passport);


    /**
     * 删除用户投诉
     *
     * @param request  删除用户投诉请求
     * @param passport 用户护照
     * @return 删除用户投诉应答
     */
    ComplatintDeleteResponse deleteComplatint(ComplatintDeleteRequest request, Passport passport);

    /**
     * 根据Id获取用户投诉
     *
     * @param request  获取用户投诉请求
     * @param passport 用户护照
     * @return 获取用户投诉应答
     */
    ComplatintGetResponse getComplatint(ComplatintGetRequest request, Passport passport);

    /**
     * 保存自我介绍
     *
     * @param request
     * @param passport
     * @return
     */
    SelfIntroductionSaveResponse saveSelfIntroduction(SelfIntroductionSaveRequest request, Passport passport);

    /**
     * 获取自我介绍
     *
     * @param request
     * @param passport
     * @return
     */
    SelfIntroductionGetResponse getSelfIntroduction(SelfIntroductionGetRequest request, Passport passport);
}
