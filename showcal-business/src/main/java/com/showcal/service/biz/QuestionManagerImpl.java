/**
 * @(#)QuestionManagerImpl.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.service.biz;

import com.showcal.cms.svc.Message;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.framework.participle.Participle;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.biz.IntegralDetailManager;
import com.showcal.platform.biz.SettingKeywordManager;
import com.showcal.platform.biz.SysUserManager;
import com.showcal.platform.dal.SysUserMapper;
import com.showcal.platform.domain.IntegralRuleTypeEnum;
import com.showcal.platform.request.IntegralDetailCreateRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.service.dal.QuestionMapper;
import com.showcal.service.domain.*;
import com.showcal.service.po.QuestionPO;
import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ServiceQuestionManager")
public class QuestionManagerImpl extends BaseManagerImpl implements QuestionManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private SettingKeywordManager settingKeywordManager;
    @Autowired
    private MessageManager messageManager;
    @Autowired
    private SysUserManager sysUserManager;
    @Autowired
    private IntegralDetailManager integralDetailManager;


    /**
     * 根据Id获取问题
     *
     * @param request  获取问题请求
     * @param passport 用户护照
     * @return 获取问题应答
     */
    @Override
    @Transactional(readOnly = true)
    public QuestionGetResponse get(QuestionGetRequest request, Passport passport) {
        QuestionPO entity = questionMapper.getById(request.getId(), passport);
        QuestionGetResponse response = new QuestionGetResponse();
        if (entity != null) {
            Question question = this.getMapper().map(entity, Question.class);
            response.setQuestion(question);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询问题
     *
     * @param request  模糊查询问题请求
     * @param passport 用户护照
     * @return 模糊查询问题应答
     */
    @Override
    @Transactional(readOnly = true)
    public QuestionSearchResponse search(QuestionSearchRequest request, Passport passport) {
        QuestionSearchResponse response = new QuestionSearchResponse();
        List<Question> modelList = new ArrayList<>();
        Long count = questionMapper.searchCount(request, passport);

        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }

            //通过关键字查询出用户集合
            List<QuestionPO> entityList = questionMapper.search(request, passport);

            for (QuestionPO entity : entityList) {
                Question question = this.getMapper().map(entity, Question.class);
                modelList.add(question);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询问题
     *
     * @param request  高级查询问题请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public QuestionFindResponse find(QuestionFindRequest request, Passport passport) {
        QuestionFindResponse response = new QuestionFindResponse();
        List<Question> modelList = new ArrayList<>();
        Long count = questionMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<QuestionPO> entityList = questionMapper.find(request, passport);
            for (QuestionPO entity : entityList) {
                Question question = this.getMapper().map(entity, Question.class);
                modelList.add(question);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有问题列表
     *
     * @param request  获取所有问题列表请求
     * @param passport 用户护照
     * @return 获取所有问题列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public QuestionGetAllListResponse getAllList(QuestionGetAllListRequest request, Passport passport) {
        QuestionGetAllListResponse response = new QuestionGetAllListResponse();


        List<QuestionPO> entityList = questionMapper.getAllList(request, passport);


        List<Question> modelList = new ArrayList<>();
        for (QuestionPO entity : entityList) {
            Question question = this.getMapper().map(entity, Question.class);
            modelList.add(question);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 删除问题
     *
     * @param request  删除问题请求
     * @param passport 用户护照
     * @return 删除问题应答
     */
    @Override
    public QuestionDeleteResponse delete(QuestionDeleteRequest request, Passport passport) {
        QuestionDeleteResponse response = new QuestionDeleteResponse();
        Long result = questionMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    /**
     * 发送问题
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public QuestionCreateResponse send(QuestionCreateRequest request, Passport passport) {
        //1 查找目前系统中是否有未回答的问题,未回答问题的标签，关键字
        QuestionCreateResponse response = new QuestionCreateResponse();
        //2 当前的提问是否有标签，如果有标签，认为其为新问题
        if(request.getTag()!=null&&request.getTag()>0){
            // 有标签，则为新问题
            Long questionId = foundationService.getNewId();
            QuestionPO newQuestion = new QuestionPO();
            newQuestion.setId(questionId);
            response.setId(questionId);
            newQuestion.setTag(request.getTag());
            newQuestion.setAnswerUserId(request.getShowCalId());
            newQuestion.setIsAnswered(false);
            newQuestion.setResponseTime(getTomorrow());
            if(questionMapper.insert(newQuestion,passport)>0){
                //3.2 新建一个未回答问题 ,新建一个消息
                ServiceMessageCreateRequest messageCreateRequest = new ServiceMessageCreateRequest();
                messageCreateRequest.setType(MessageBusinessTypeEnum.QUESTION);
                messageCreateRequest.setServiceId(newQuestion.getId());
                messageCreateRequest.setContent(request.getContent());
                messageCreateRequest.setMessageType(request.getType());
                messageCreateRequest.setUrl(request.getUrl());
                messageCreateRequest.setFromUserId(passport.getUserId()); //从我
                messageCreateRequest.setToUserId(request.getShowCalId()); //到showcal
                messageManager.create(messageCreateRequest, passport);

                //评论增加积分
                IntegralDetailCreateRequest integralDetailCreateRequest=new IntegralDetailCreateRequest();
                integralDetailCreateRequest.setType(IntegralRuleTypeEnum.QUESTION.name());
                integralDetailManager.create(integralDetailCreateRequest, passport);
            }
            return response;
        }
        // 3 没有标签时，按照是否有未回答问题判断
        QuestionPO questionPO = questionMapper.getMyUnAnswerQuestion(request.getShowCalId(),passport);
        List<String> keywords = settingKeywordManager.getAllKeyword(passport);

        //2 如果有未回答的问题，
        if (questionPO != null) {
            response.setId(questionPO.getId());
            //当前的未回答的问题，没有标签。
            if (questionPO.getTag() == null) {
                if (request.getTag() != null && !"".equals(request.getTag())) {
                    questionPO.setTag(request.getTag());
                }else{
                    if (MessageTypeEnum.TEXT.equals(request.getType())) {
                        String keyword = Participle.doParticiple(keywords, request.getContent());
                        Long keywordId = settingKeywordManager.getIdByKeyword(keyword, passport);
                        questionPO.setKeyword(keywordId);
                    }
                }
            } else {
                if (questionPO.getKeyword() != null) {
                    //解析关键字
                    //2.1 未回答的问题，是否已经贴标签，关键字.如果没有，且问题为文字消息，则解析关键字
                    if (MessageTypeEnum.TEXT.equals(request.getType())) {
                        String keyword = Participle.doParticiple(keywords, request.getContent());
                        Long keywordId = settingKeywordManager.getIdByKeyword(keyword, passport);
                        questionPO.setKeyword(keywordId);
                    }
                }
            }
            questionMapper.update(questionPO,passport);
            ServiceMessageCreateRequest messageCreateRequest = new ServiceMessageCreateRequest();
            messageCreateRequest.setType(MessageBusinessTypeEnum.QUESTION);
            messageCreateRequest.setServiceId(questionPO.getId());
            messageCreateRequest.setFromUserId(passport.getUserId());
            messageCreateRequest.setToUserId(request.getShowCalId());
            messageCreateRequest.setContent(request.getContent());
            messageCreateRequest.setUrl(request.getUrl());
            messageCreateRequest.setMessageType(request.getType());
            messageManager.create(messageCreateRequest, passport);
        } else {
            //3 如果没有未回答问题
            // 新建问题
            Long questionId = foundationService.getNewId();
            QuestionPO newQuestion = new QuestionPO();
            newQuestion.setId(questionId);
            response.setId(questionId);
            newQuestion.setTag(request.getTag());
            newQuestion.setAnswerUserId(request.getShowCalId());
            newQuestion.setIsAnswered(false);
            newQuestion.setResponseTime(getTomorrow());
            if (newQuestion.getTag() == null && MessageTypeEnum.TEXT.equals(request.getType())&&!"".equals(request.getContent())) {
                //3.1 看是否有标签，如果有标签，则不需要解析关键字。如果没有，且问题为文字消息，则解析关键字
                String keyword = Participle.doParticiple(keywords, request.getContent());
                Long keywordId = settingKeywordManager.getIdByKeyword(keyword, passport);
                newQuestion.setKeyword(keywordId);
            }
            if(questionMapper.insert(newQuestion,passport)>0){
                //3.2 新建一个未回答问题 ,新建一个消息
                ServiceMessageCreateRequest messageCreateRequest = new ServiceMessageCreateRequest();
                messageCreateRequest.setType(MessageBusinessTypeEnum.QUESTION);
                messageCreateRequest.setServiceId(newQuestion.getId());
                messageCreateRequest.setContent(request.getContent());
                messageCreateRequest.setUrl(request.getUrl());
                messageCreateRequest.setMessageType(request.getType());
                messageCreateRequest.setFromUserId(passport.getUserId()); //从我
                messageCreateRequest.setToUserId(request.getShowCalId()); //到showcal
                messageManager.create(messageCreateRequest, passport);
            }
        }
        return response;
    }

    /**
     * 获取明天日期
     *
     * @return
     */
    private Date getTomorrow() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    /**
     * 获取我跟瘦咖的所有历史消息
     * @param request
     * @param passport
     * @return
     */
    @Override
    public QuestionHistoryGetForMyResponse getMyHistoryList(QuestionHistoryGetForMyResuest request, Passport passport) {



        return null;
    }

    /**
     * 查询待我回答的问题
     * @param request
     * @param passport
     * @return
     */
    @Override
    public QuestionWillAnswerForMyResponse getMyWillAnswerList(QuestionWillAnswerForMyRequest request, Passport passport) {
        // 1 查询所有未回答标签总数
        QuestionWillAnswerForMyResponse response = new QuestionWillAnswerForMyResponse();
        List<TotalQuestionTag> questionTagList = questionMapper.getWillAnswerByTagCount(request, passport);
        List<TotalKeyWordTag> questionKeywordList = questionMapper.getWillAnswerByKeywordCount(request,passport);
        Integer newUserQuestionCount = questionMapper.getNewUserQuestion(request, passport);
        Integer otherQuestionCount = questionMapper.getOtherQuestionCount(request,passport);
        response.setOtherQuestionCount(otherQuestionCount);
        response.setQuestionTagList(questionTagList);
        response.setKeyWordTagList(questionKeywordList);
        response.setNewUserQuestionCount(newUserQuestionCount);

        List<UnAnswerQuestion> modelList = new ArrayList<>();
        Long count = questionMapper.findUnAnswerQuestionCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
                // 2 根据条件，查询未回答的列表数据
                List<UnAnswerQuestion> questionPOs = questionMapper.findUnAnswerQuestion(request, passport);
                for (UnAnswerQuestion entity : questionPOs) {
                    List<ServiceMessage> serviceMessages = messageManager.getQuestionMessage(entity.getId(),passport);
                    entity.setServiceMessages(serviceMessages);
                    modelList.add(entity);
                }
            }
        }
        response.setResult(modelList);
        response.setTotalCount(count);
        return response;
    }
    public QuestionFindResponse findHistoryQuestion(QuestionFindRequest request, Passport passport) {
//        Calendar calendar=Calendar.getInstance();
//        calendar.setTime(new Date());
        QuestionFindResponse response = new QuestionFindResponse();
//        if(request.getDeadline()!=null&&!request.getDeadline().trim().equals("")){
//                calendar.add(Calendar.HOUR,-Integer.parseInt(request.getDeadline()));
//            request.setStartTime(calendar.getTime().getTime());
//        }
        Long count = questionMapper.findHistoryCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<Map<Long,String>> maps = questionMapper.findHistory(request,passport);
            response.setMaps(maps);
        }

        response.setTotalCount(count);
        return response;
    }
    /**
     * 验证对象
     *
     * @param question 问题
     * @param passport 用户护照
     */
    private void checkValidate(QuestionPO question, Passport passport, BaseResponse response) {
        // TODO

    }


}
