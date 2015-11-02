/**
 * @(#)AnswerManagerImpl.java
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
import com.showcal.foundation.service.FoundationService;
import com.showcal.service.dal.AnswerMapper;
import com.showcal.service.dal.MessageMapper;
import com.showcal.service.dal.QuestionMapper;
import com.showcal.service.domain.Answer;
import com.showcal.service.domain.MessageBusinessTypeEnum;
import com.showcal.service.domain.MessageTypeEnum;
import com.showcal.service.po.AnswerPO;
import com.showcal.service.po.QuestionPO;
import com.showcal.service.po.ServiceMessagePO;
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
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ServiceAnswerManager")
public class AnswerManagerImpl extends BaseManagerImpl implements AnswerManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 根据Id获取答案
     *
     * @param request  获取答案请求
     * @param passport 用户护照
     * @return 获取答案应答
     */
    @Override
    @Transactional(readOnly = true)
    public AnswerGetResponse get(AnswerGetRequest request, Passport passport) {
        AnswerPO entity = answerMapper.getById(request.getId(), passport);
        AnswerGetResponse response = new AnswerGetResponse();
        if (entity != null) {
            Answer answer = this.getMapper().map(entity, Answer.class);
            response.setAnswer(answer);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询答案
     *
     * @param request  模糊查询答案请求
     * @param passport 用户护照
     * @return 模糊查询答案应答
     */
    @Override
    @Transactional(readOnly = true)
    public AnswerSearchResponse search(AnswerSearchRequest request, Passport passport) {
        AnswerSearchResponse response = new AnswerSearchResponse();
        List<Answer> modelList = new ArrayList<>();
        Long count = answerMapper.searchCount(request, passport);

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
            List<AnswerPO> entityList = answerMapper.search(request, passport);

            for (AnswerPO entity : entityList) {
                Answer answer = this.getMapper().map(entity, Answer.class);
                modelList.add(answer);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询答案
     *
     * @param request  高级查询答案请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public AnswerFindResponse find(AnswerFindRequest request, Passport passport) {
        AnswerFindResponse response = new AnswerFindResponse();
        List<Answer> modelList = new ArrayList<>();
        Long count = answerMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<AnswerPO> entityList = answerMapper.find(request, passport);
            for (AnswerPO entity : entityList) {
                Answer answer = this.getMapper().map(entity, Answer.class);
                modelList.add(answer);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有答案列表
     *
     * @param request  获取所有答案列表请求
     * @param passport 用户护照
     * @return 获取所有答案列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public AnswerGetAllListResponse getAllList(AnswerGetAllListRequest request, Passport passport) {
        AnswerGetAllListResponse response = new AnswerGetAllListResponse();


        List<AnswerPO> entityList = answerMapper.getAllList(request, passport);


        List<Answer> modelList = new ArrayList<>();
        for (AnswerPO entity : entityList) {
            Answer answer = this.getMapper().map(entity, Answer.class);
            modelList.add(answer);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }

    /**
     * 发送答案
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public AnswerSendResponse send(AnswerSendRequest request, Passport passport) {
        AnswerSendResponse response = new AnswerSendResponse();
        List<AnswerPO> answerQuestions = answerMapper.getAnswersByQuestionIds(request.getQuestionIds(), passport);
        List<QuestionPO> questionPOs = questionMapper.getListByIds(request.getQuestionIds(), passport);
        if (questionPOs == null || questionPOs.isEmpty()) {
            response.addError(ErrorType.BUSINESS_ERROR, "未找到答案对应的问题信息，请检查");
            return response;
        }
        Map<Long, AnswerPO> answerPOMap = new HashMap<>();
        Map<Long, QuestionPO> questionPOMap = new HashMap<>();
        List<AnswerPO> insertAnswerPOs = new ArrayList<>();
        List<ServiceMessagePO> messagePOs = new ArrayList<>();
        if (answerQuestions != null && !answerQuestions.isEmpty()) {
            for (AnswerPO answerPO : answerQuestions) {
                answerPOMap.put(answerPO.getQuestionId(), answerPO);
            }
        }
        for (QuestionPO questionPO : questionPOs) {
            questionPOMap.put(questionPO.getId(), questionPO);
        }
        List<Long> closeAnswerIds = new ArrayList<>();
        //1 判断当前答案是否是关闭答案
        if (request.getIsAnswered()) {
            // 1.1 如果关闭问题，则找到最近一条未回答的问题，关闭
            // 查找所有问题对应的答案信息

            for (Long questionId : request.getQuestionIds()) {
                QuestionPO questionPO = questionPOMap.get(questionId);
                if (questionPO == null) {
                    continue;
                }
                Long serviceId = null;
                if (answerPOMap.containsKey(questionId)) {
                    AnswerPO answerPO = answerPOMap.get(questionId);
                    closeAnswerIds.add(answerPO.getId());
                    serviceId = answerPO.getId();
                } else {
                    serviceId = foundationService.getNewId();
                    AnswerPO answerPO = new AnswerPO();
                    answerPO.setId(serviceId);
                    answerPO.setQuestionId(questionId);
                    answerPO.setIsAnswered(true);
                    answerPO.setAnsweredTime(new Date());
                    insertAnswerPOs.add(answerPO);
                }
                ServiceMessagePO messagePO = new ServiceMessagePO();
                messagePO.setId(foundationService.getNewId());
                messagePO.setMessageType(MessageTypeEnum.TEXT);
                messagePO.setType(MessageBusinessTypeEnum.ANSWER);
                messagePO.setFromUserId(passport.getUserId());
                messagePO.setToUserId(questionPO.getCreatedBy());
                messagePO.setContent(request.getContent());
                messagePO.setServiceId(serviceId);
                messagePOs.add(messagePO);
            }
        } else {
            // 1.2 找到最近一条未回答问题，增加消息记录
            for (Long questionId : request.getQuestionIds()) {
                QuestionPO questionPO = questionPOMap.get(questionId);
                if (questionPO == null) {
                    continue;
                }
                Long serviceId = null;
                if (!answerPOMap.containsKey(questionId)) {
                    serviceId = foundationService.getNewId();
                    AnswerPO answerPO = new AnswerPO();
                    answerPO.setId(serviceId);
                    answerPO.setQuestionId(questionId);
                    answerPO.setIsAnswered(true);
                    answerPO.setAnsweredTime(new Date());
                    insertAnswerPOs.add(answerPO);
                } else {
                    AnswerPO answerPO = answerPOMap.get(questionId);
                    serviceId = answerPO.getId();
                }
                ServiceMessagePO messagePO = new ServiceMessagePO();
                messagePO.setId(foundationService.getNewId());
                messagePO.setMessageType(MessageTypeEnum.TEXT);
                messagePO.setType(MessageBusinessTypeEnum.ANSWER);
                messagePO.setFromUserId(passport.getUserId());
                messagePO.setToUserId(questionPO.getCreatedBy());
                messagePO.setContent(request.getContent());
                messagePO.setServiceId(serviceId);
                messagePOs.add(messagePO);
            }
        }
        // 批量插入消息
        messageMapper.insertBatch(messagePOs, passport);
        // 批量插入需要插入的answer信息
        if(!insertAnswerPOs.isEmpty()){
            answerMapper.insertBatch(insertAnswerPOs, passport);
        }
        if (request.getIsAnswered()) {
            // 如果需要关闭，则批量关闭问题信息
            questionMapper.closeBatch(request.getQuestionIds(), passport);
            // 批量关闭问题对应的答案信息
            answerMapper.closeBatch(closeAnswerIds, passport);
        }
        response.setId(1L);
        return response;
    }

    /**
     * 关闭答案
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public QuestionCloseResponse closeQuestions(QuestionCloseRequest request, Passport passport) {
        // 关闭所有问题
        // 1 校验所有的问题，是否都含有答案
        QuestionCloseResponse response = new QuestionCloseResponse();
        List<AnswerPO> answerQuestions = answerMapper.getAnswersByQuestionIds(request.getQuestionIds(), passport);
        if (answerQuestions.size() != request.getQuestionIds().size()) {
            response.addError(ErrorType.BUSINESS_ERROR, "关闭的问题中，含有未回答的问题，请回答后，再关闭!");
            return response;
        }
        List<Long> answerIds = new ArrayList<>();
        for (AnswerPO answerPO : answerQuestions) {
            answerIds.add(answerPO.getId());
        }
        // 如果需要关闭，则批量关闭问题信息
        questionMapper.closeBatch(request.getQuestionIds(), passport);
        // 批量关闭问题对应的答案信息
        answerMapper.closeBatch(answerIds, passport);
        response.setResult(1L);
        return response;
    }

    /**
     * 验证对象
     *
     * @param answer   答案
     * @param passport 用户护照
     */
    private void checkValidate(AnswerPO answer, Passport passport, BaseResponse response) {
        // TODO

    }


}
