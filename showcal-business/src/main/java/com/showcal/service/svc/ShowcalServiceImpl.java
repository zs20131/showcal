package com.showcal.service.svc;


import com.showcal.cms.biz.ArticleManager;
import com.showcal.service.biz.*;
import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.showcal.service.service.ShowcalService;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.svc
 *  Description:
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.service.svc
 * </pre>
 */
public class ShowcalServiceImpl implements ShowcalService {
    //欢迎语
    @Autowired
    private WelcomeManager welcomeManager;
    //问题
    @Autowired
    private QuestionManager questionManager;
    //投诉
    @Autowired
    private ComplatintManager complatintManager;
    //答案
    @Autowired
    private AnswerManager answerManager;
    //知识库
    @Autowired
    private RepositoryManager repositoryManager;
    //服务用户
    @Autowired
    private ServiceUserManager serviceUserManager;
    //消息
    @Autowired
    private MessageManager messageManager;
    @Autowired
    private ArticleManager articleManager;
    /**
     * 根据Id获取欢迎语
     *
     * @param request 获取欢迎语请求
     * @param passport 用户护照
     * @return 获取欢迎语应答
     */
    @Override
    public WelcomeGetResponse getWelcome(WelcomeGetRequest request, Passport passport)
    {
        WelcomeGetResponse response = new WelcomeGetResponse();
        ValidationUtil.validate(request, response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.get(request, passport);
        return response;
    }


    /**
     * 模糊查询欢迎语
     *
     * @param request 模糊查询欢迎语请求
     * @param passport 用户护照
     * @return 模糊查询欢迎语应答
     */
    @Override
    public WelcomeSearchResponse searchWelcome(WelcomeSearchRequest request, Passport passport)
    {
        WelcomeSearchResponse response = new WelcomeSearchResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.search(request, passport);
        return response;
    }

    /**
     * 高级查询欢迎语
     *
     * @param request 高级查询欢迎语请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public WelcomeFindResponse findWelcome(WelcomeFindRequest request, Passport passport)
    {
        WelcomeFindResponse response = new WelcomeFindResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.find(request, passport);
        return response;
    }

    /**
     * 获取所有欢迎语列表
     *
     * @param request 获取所有欢迎语列表请求
     * @param passport 用户护照
     * @return 获取所有欢迎语列表应答
     */
    @Override
    public WelcomeGetAllListResponse getWelcomeAllList(WelcomeGetAllListRequest request, Passport passport)
    {
        WelcomeGetAllListResponse response = new WelcomeGetAllListResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.getAllList(request, passport);
        return response;
    }

    @Override
    public WelComeGetForMyResponse getMyShowCalWelCome(WelcomeGetForMyRequest request, Passport passport) {
        WelComeGetForMyResponse response = new WelComeGetForMyResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.getMyShowCalWelcome(request, passport);
        return response;
    }

    /**
     * 创建欢迎语
     *
     * @param request 创建欢迎语请求
     * @param passport 用户护照
     * @return 创建欢迎语应答
     */
    @Override
    public WelcomeCreateResponse createWelcome(WelcomeCreateRequest request, Passport passport)
    {
        WelcomeCreateResponse response = new WelcomeCreateResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.create(request, passport);
        return response;
    }


    /**
     * 更新欢迎语
     *
     * @param request 更新欢迎语请求
     * @param passport 用户护照
     * @return 更新欢迎语应答
     */
    @Override
    public WelcomeUpdateResponse updateWelcome(WelcomeUpdateRequest request, Passport passport)
    {
        WelcomeUpdateResponse response = new WelcomeUpdateResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.update(request, passport);
        return response;
    }


    /**
     * 删除欢迎语
     *
     * @param request 删除欢迎语请求
     * @param passport 用户护照
     * @return 删除欢迎语应答
     */
    @Override
    public WelcomeDeleteResponse deleteWelcome(WelcomeDeleteRequest request, Passport passport)
    {
        WelcomeDeleteResponse response = new WelcomeDeleteResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.delete(request, passport);
        return response;
    }


    /**
     * 作废欢迎语
     *
     * @param request 作废欢迎语请求
     * @param passport 用户护照
     * @return 作废欢迎语应答
     */
    @Override
    public WelcomeInactiveResponse inactiveWelcome(WelcomeInactiveRequest request, Passport passport)
    {
        WelcomeInactiveResponse response = new WelcomeInactiveResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.inactive(request, passport);
        return response;
    }


    /**
     * 激活欢迎语
     *
     * @param request 激活欢迎语请求
     * @param passport 用户护照
     * @return 激活欢迎语应答
     */
    @Override
    public WelcomeActiveResponse activeWelcome(WelcomeActiveRequest request, Passport passport)
    {
        WelcomeActiveResponse response = new WelcomeActiveResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.active(request, passport);
        return response;
    }



    /**
     * 导入欢迎语
     *
     * @param request 导入欢迎语请求
     * @param passport 用户护照
     * @return 导入欢迎语应答
     */
    @Override
    public WelcomeListImportResponse importWelcomeList(WelcomeListImportRequest request, Passport passport)
    {
        WelcomeListImportResponse response = new WelcomeListImportResponse();
        ValidationUtil.validate(request,response);
        if(response.hasError()) {
            return response;
        }
        response = welcomeManager.importList(request, passport);
        return response;
    }

    @Override
    public ServiceUserCreateResponse createServiceUser(ServiceUserCreateRequest request, Passport passport) {
        ServiceUserCreateResponse response = new ServiceUserCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return serviceUserManager.create(request, passport);
    }

    @Override
    public ServiceUserDeleteResponse deleteServiceUser(ServiceUserDeleteRequest request, Passport passport) {
        ServiceUserDeleteResponse response = new ServiceUserDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return serviceUserManager.delete(request, passport);
    }

    /**
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ServiceUserGetListForMyResponse getMyServiceUser(ServiceUserGetListForMyRequest request, Passport passport) {
        ServiceUserGetListForMyResponse response = new ServiceUserGetListForMyResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return serviceUserManager.getMyList(request, passport);
    }

    @Override
    public ServiceHistoryUserGetResponse getMyHistoryServiceUser(ServiceHistoryUserGetRequest request, Passport passport) {
        ServiceHistoryUserGetResponse response = new ServiceHistoryUserGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return serviceUserManager.getMyHistoryList(request, passport);
    }

    @Override
    public ShowCalGetForMyResponse getMyShowCal(ShowCalGetForMyRequest request, Passport passport) {
        ShowCalGetForMyResponse response = new ShowCalGetForMyResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return serviceUserManager.getMyShowCal(request, passport);
    }

    @Override
    public ShowCalHistoryGetResponse getMyHistoryShowCal(ShowCalHistoryGetRequest request, Passport passport) {
        ShowCalHistoryGetResponse response = new ShowCalHistoryGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return serviceUserManager.getMyHistoryShowCal(request, passport);
    }

    @Override
    public RepositoryFindResponse findRepository(RepositoryFindRequest request, Passport passport) {
        RepositoryFindResponse response = new RepositoryFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.find(request, passport);
    }

    @Override
    public RepositoryCreateResponse createRepository(RepositoryCreateRequest request, Passport passport) {
        RepositoryCreateResponse response = new RepositoryCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.create(request, passport);
    }

    @Override
    public RepositoryUpdateResponse updateRepository(RepositoryUpdateRequest request, Passport passport) {
        RepositoryUpdateResponse response = new RepositoryUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.update(request, passport);
    }

    @Override
    public RepositoryDeleteResponse deleteRepository(RepositoryDeleteRequest request, Passport passport) {
        RepositoryDeleteResponse response = new RepositoryDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.delete(request, passport);
    }

    @Override
    public RepositoryActiveResponse activeRepository(RepositoryActiveRequest request, Passport passport) {
        RepositoryActiveResponse response = new RepositoryActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.active(request, passport);
    }

    @Override
    public RepositoryInactiveResponse inactiveRepository(RepositoryInactiveRequest request, Passport passport) {
        RepositoryInactiveResponse response = new RepositoryInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.inactive(request, passport);
    }

    @Override
    public RepositoryToPlatformResponse toPlatformRepository(RepositoryToPlatformRequest request, Passport passport) {
        RepositoryToPlatformResponse response = new RepositoryToPlatformResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.toPlatform(request, passport);
    }

    @Override
    public RepositoryToShowcalResponse toShowcalRepository(RepositoryToShowcalRequest request, Passport passport) {
        RepositoryToShowcalResponse response = new RepositoryToShowcalResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.toShowcal(request, passport);
    }

    @Override
    public RepositoryGetForMyResponse getMyRepository(RepositoryGetForMyRequest request, Passport passport) {
        RepositoryGetForMyResponse response = new RepositoryGetForMyResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.getMy(request, passport);
    }
    @Override
    public RepositorySystemGetResponse getSystemRepository(RepositorySystemGetRequest request,Passport passport){
        RepositorySystemGetResponse response = new RepositorySystemGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.getSystemRepository(request, passport);
    }

    @Override
    public MyRepositoryTransferResponse transferMyRepository(MyRepositoryTransferRequest request, Passport passport) {
        MyRepositoryTransferResponse response = new MyRepositoryTransferResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.transfer(request, passport);
    }

    @Override
    public RepositoryListImportResponse importRepositoryList(RepositoryListImportRequest request, Passport passport) {
        RepositoryListImportResponse response = new RepositoryListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.importList(request, passport);
    }

    @Override
    public MyRepositoryListImportResponse importMyRepositoryList(MyRepositoryListImportRequest request, Passport passport) {
        MyRepositoryListImportResponse response = new MyRepositoryListImportResponse();
        if (response.hasError()) {
            return response;
        }
        return repositoryManager.importMyList(request, passport);
    }

    @Override
    public QuestionCreateResponse sendQuestion(QuestionCreateRequest request, Passport passport) {
        QuestionCreateResponse response = new QuestionCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return questionManager.send(request, passport);
    }

    @Override
    public QuestionHistoryGetForMyResponse getMyAskHistoryQuestion(QuestionHistoryGetForMyResuest request, Passport passport) {
        QuestionHistoryGetForMyResponse response = new QuestionHistoryGetForMyResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return questionManager.getMyHistoryList(request, passport);
    }

    @Override
    public QuestionWillAnswerForMyResponse getMyWillAnswerQuestion(QuestionWillAnswerForMyRequest request, Passport passport) {
        QuestionWillAnswerForMyResponse response = new QuestionWillAnswerForMyResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return questionManager.getMyWillAnswerList(request, passport);
    }

    @Override
    public MessageHistoryGetResponse getMyHistoryMessage(MessageHistoryGetRequest request, Passport passport) {
        MessageHistoryGetResponse response = new MessageHistoryGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return messageManager.getHistoryMesage(request, passport);
    }

    @Override
    public AnswerSendResponse sendAnswer(AnswerSendRequest request, Passport passport) {
        AnswerSendResponse response = new AnswerSendResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return answerManager.send(request, passport);
    }

    @Override
    public QuestionCloseResponse closeQuestions(QuestionCloseRequest request, Passport passport) {
        QuestionCloseResponse response = new QuestionCloseResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return answerManager.closeQuestions(request, passport);
    }

    @Override
    public ComplatintFindResponse findComplatint(ComplatintFindRequest request, Passport passport) {
        ComplatintFindResponse response = new ComplatintFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return complatintManager.find(request, passport);
    }

    @Override
    public ComplatintCreateResponse createComplatint(ComplatintCreateRequest request, Passport passport) {
        ComplatintCreateResponse response = new ComplatintCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return complatintManager.create(request, passport);
    }

    @Override
    public ComplatintUpdateResponse updateComplatint(ComplatintUpdateRequest request, Passport passport) {
        ComplatintUpdateResponse response = new ComplatintUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return complatintManager.update(request, passport);
    }

    @Override
    public ComplatintDeleteResponse deleteComplatint(ComplatintDeleteRequest request, Passport passport) {
        ComplatintDeleteResponse response = new ComplatintDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return complatintManager.delete(request, passport);
    }

    @Override
    public ComplatintGetResponse getComplatint(ComplatintGetRequest request, Passport passport) {
        ComplatintGetResponse response = new ComplatintGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return complatintManager.get(request, passport);
    }

    /**
     * 保存我的简介
     * @param request
     * @param passport
     * @return
     */
    @Override
    public SelfIntroductionSaveResponse saveSelfIntroduction(SelfIntroductionSaveRequest request, Passport passport) {
        SelfIntroductionSaveResponse response = new SelfIntroductionSaveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.saveSelfIntroduction(request, passport);
    }

    @Override
    public SelfIntroductionGetResponse getSelfIntroduction(SelfIntroductionGetRequest request, Passport passport) {
        SelfIntroductionGetResponse response = new SelfIntroductionGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return articleManager.getSelfIntroduction(request, passport);
    }


    @Override
    public QuestionFindResponse findHistoryQuestion(QuestionFindRequest request, Passport passport) {
        QuestionFindResponse response = new QuestionFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return questionManager.findHistoryQuestion(request, passport);
    }

}
