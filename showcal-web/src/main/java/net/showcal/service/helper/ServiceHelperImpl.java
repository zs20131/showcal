package net.showcal.service.helper;

import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.showcal.service.service.ShowcalService;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.service.helper.ServiceHelperImpl
 *  Description: service Helper 实现类
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
@Component
public class ServiceHelperImpl implements ServiceHelper {
    @Autowired
    private ShowcalService showcalService;

    /**
     * 创建欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public WelcomeCreateResponse createWelcome(WelcomeCreateRequest request, Passport passport) {
        return showcalService.createWelcome(request, passport);
    }

    @Override
    public WelcomeGetResponse getWelcome(WelcomeGetRequest request, Passport passport) {
        return showcalService.getWelcome(request, passport);
    }

    /**
     * 更新欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public WelcomeUpdateResponse updateWelcome(WelcomeUpdateRequest request, Passport passport) {
        return showcalService.updateWelcome(request, passport);
    }

    @Override
    public QuestionFindResponse findHistoryQuestion(QuestionFindRequest request, Passport passport) {
        return showcalService.findHistoryQuestion(request, passport);
    }

    /**
     * 删除欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public WelcomeDeleteResponse deleteWelcome(WelcomeDeleteRequest request, Passport passport) {
        return showcalService.deleteWelcome(request, passport);
    }

    /**
     * 作废欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public WelcomeInactiveResponse inactiveWelcome(WelcomeInactiveRequest request, Passport passport) {
        return showcalService.inactiveWelcome(request, passport);
    }

    /**
     * 激活欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public WelcomeActiveResponse activeWelcome(WelcomeActiveRequest request, Passport passport) {
        return showcalService.activeWelcome(request, passport);
    }

    /**
     * 获取我所有的欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public WelComeGetListForMyResponse getMyWelComeList(WelcomeGetListForMyRequest request, Passport passport) {
        //return showcalService.getMyWelComeList(request, passport);
        return null;
    }

    @Override
    public WelcomeFindResponse findMyWelComeList(WelcomeFindRequest request, Passport passport) {
        return showcalService.findWelcome(request, passport);
    }

    /**
     * 获取我的瘦咖的欢迎语
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public WelComeGetForMyResponse getMyShowCalWelCome(WelcomeGetForMyRequest request, Passport passport) {
        return showcalService.getMyShowCalWelCome(request, passport);
    }

    /**
     * 创建用户服务表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ServiceUserCreateResponse createServiceUser(ServiceUserCreateRequest request, Passport passport) {
        return showcalService.createServiceUser(request, passport);
    }

    /**
     * 删除用户服务表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ServiceUserDeleteResponse deleteServiceUser(ServiceUserDeleteRequest request, Passport passport) {
        return showcalService.deleteServiceUser(request, passport);
    }

    /**
     * 获取我当前所有服务的用户信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ServiceUserGetListForMyResponse getMyServiceUser(ServiceUserGetListForMyRequest request, Passport passport) {
        return showcalService.getMyServiceUser(request, passport);
    }

    /**
     * 获取我历史上服务的所有用户
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ServiceHistoryUserGetResponse getMyHistoryServiceUser(ServiceHistoryUserGetRequest request, Passport passport) {
        return showcalService.getMyHistoryServiceUser(request, passport);
    }

    /**
     * 获取当前服务我的瘦咖
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ShowCalGetForMyResponse getMyShowCal(ShowCalGetForMyRequest request, Passport passport) {
        return showcalService.getMyShowCal(request, passport);
    }

    /**
     * 获取所有历史服务于我的瘦咖
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ShowCalHistoryGetResponse getMyHistoryShowCal(ShowCalHistoryGetRequest request, Passport passport) {
        return showcalService.getMyHistoryShowCal(request, passport);
    }

    /**
     * 高级查询知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public RepositoryFindResponse findRepository(RepositoryFindRequest request, Passport passport) {
        return showcalService.findRepository(request, passport);
    }

    /**
     * 创建知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public RepositoryCreateResponse createRepository(RepositoryCreateRequest request, Passport passport) {
        return showcalService.createRepository(request, passport);
    }

    /**
     * 更新知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public RepositoryUpdateResponse updateRepository(RepositoryUpdateRequest request, Passport passport) {
        return showcalService.updateRepository(request, passport);
    }

    /**
     * 删除知识库
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public RepositoryDeleteResponse deleteRepository(RepositoryDeleteRequest request, Passport passport) {
        return showcalService.deleteRepository(request, passport);
    }

    @Override
    public RepositoryActiveResponse activeRepository(RepositoryActiveRequest request, Passport passport) {
        return showcalService.activeRepository(request, passport);
    }

    @Override
    public RepositoryInactiveResponse inactiveRepository(RepositoryInactiveRequest request, Passport passport) {
        return showcalService.inactiveRepository(request, passport);
    }

    @Override
    public RepositoryToPlatformResponse toPlatformRepository(RepositoryToPlatformRequest request, Passport passport) {
        return showcalService.toPlatformRepository(request, passport);
    }

    @Override
    public RepositoryToShowcalResponse toShowcalRepository(RepositoryToShowcalRequest request, Passport passport) {
        return showcalService.toShowcalRepository(request, passport);
    }

    /**
     * 获取所有我的知识库(包含我自己，与平台的)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public RepositoryGetForMyResponse getMyRepository(RepositoryGetForMyRequest request, Passport passport) {
        return showcalService.getMyRepository(request, passport);
    }

    @Override
    public RepositorySystemGetResponse getSystemRepository(RepositorySystemGetRequest request, Passport passport) {
        return showcalService.getSystemRepository(request,passport);
    }

    /**
     * 转让我的知识库(预留)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MyRepositoryTransferResponse transferMyRepository(MyRepositoryTransferRequest request, Passport passport) {
        return showcalService.transferMyRepository(request, passport);
    }

    @Override
    public RepositoryListImportResponse importRepositoryList(RepositoryListImportRequest request, Passport passport) {
        return showcalService.importRepositoryList(request, passport);
    }

    @Override
    public MyRepositoryListImportResponse importMyRepositoryList(MyRepositoryListImportRequest request, Passport passport) {
        return showcalService.importMyRepositoryList(request, passport);
    }

    /**
     * 创建问题
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public QuestionCreateResponse sendQuestion(QuestionCreateRequest request, Passport passport) {
        return showcalService.sendQuestion(request, passport);
    }

    /**
     * 获取我提出的历史问题
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public QuestionHistoryGetForMyResponse getMyAskHistoryQuestion(QuestionHistoryGetForMyResuest request, Passport passport) {
        return showcalService.getMyAskHistoryQuestion(request, passport);
    }

    /**
     * 获取我未回答的所有问题
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public QuestionWillAnswerForMyResponse getMyWillAnswerQuestion(QuestionWillAnswerForMyRequest request, Passport passport) {
        return showcalService.getMyWillAnswerQuestion(request, passport);
    }

    /**
     * 获取历史消息(与我对话的所有消息)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MessageHistoryGetResponse getMyHistoryMessage(MessageHistoryGetRequest request, Passport passport) {
        return showcalService.getMyHistoryMessage(request, passport);
    }

    /**
     * 发送答案信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public AnswerSendResponse sendAnswer(AnswerSendRequest request, Passport passport) {
        return showcalService.sendAnswer(request, passport);
    }

    /**
     * 问题批量关闭
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public QuestionCloseResponse closeQuestions(QuestionCloseRequest request, Passport passport) {
        return showcalService.closeQuestions(request, passport);
    }

    /**
     * 高级查询用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ComplatintFindResponse findComplatint(ComplatintFindRequest request, Passport passport) {
        return showcalService.findComplatint(request, passport);
    }

    /**
     * 创建用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ComplatintCreateResponse createComplatint(ComplatintCreateRequest request, Passport passport) {
        return showcalService.createComplatint(request, passport);
    }

    /**
     * 更新用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ComplatintUpdateResponse updateComplatint(ComplatintUpdateRequest request, Passport passport) {
        return showcalService.updateComplatint(request, passport);
    }

    /**
     * 删除用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ComplatintDeleteResponse deleteComplatint(ComplatintDeleteRequest request, Passport passport) {
        return showcalService.deleteComplatint(request, passport);
    }

    /**
     * 根据Id获取用户投诉
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public ComplatintGetResponse getComplatint(ComplatintGetRequest request, Passport passport) {
        return showcalService.getComplatint(request, passport);
    }
    /**
     * 保存自我介绍
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SelfIntroductionSaveResponse saveSelfIntroduction(SelfIntroductionSaveRequest request, Passport passport) {
        return showcalService.saveSelfIntroduction(request, passport);
    }
    /**
     * 获取自我介绍
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SelfIntroductionGetResponse getSelfIntroduction(SelfIntroductionGetRequest request, Passport passport) {
        return showcalService.getSelfIntroduction(request, passport);
    }


}