/**
 * @(#)QuestionManager.java
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

import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
public interface QuestionManager {
    /**
     * 根据Id获取问题
     *
     * @param request  获取问题请求
     * @param passport 用户护照
     * @return 获取问题应答
     */
    QuestionGetResponse get(QuestionGetRequest request, Passport passport);


    /**
     * 模糊查询问题
     *
     * @param request  模糊查询问题请求
     * @param passport 用户护照
     * @return 模糊查询问题应答
     */
    QuestionSearchResponse search(QuestionSearchRequest request, Passport passport);

    /**
     * 高级查询问题
     *
     * @param request  高级查询问题请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    QuestionFindResponse find(QuestionFindRequest request, Passport passport);

    /**
     * 获取所有问题列表
     *
     * @param request  获取所有问题列表请求
     * @param passport 用户护照
     * @return 获取所有问题列表应答
     */
    QuestionGetAllListResponse getAllList(QuestionGetAllListRequest request, Passport passport);

    /**
     * 删除问题
     *
     * @param request  删除问题请求
     * @param passport 用户护照
     * @return 删除问题应答
     */
    QuestionDeleteResponse delete(QuestionDeleteRequest request, Passport passport);

    /**
     *  发送消息
     * @param request
     * @param passport
     * @return
     */
    QuestionCreateResponse send(QuestionCreateRequest request, Passport passport);

    /**
     * 获取我提问的历史信息
     * @param request
     * @param passport
     * @return
     */
    QuestionHistoryGetForMyResponse getMyHistoryList(QuestionHistoryGetForMyResuest request, Passport passport);

    /**
     * 获取等待我回答的消息
     * @param request
     * @param passport
     * @return
     */
    QuestionWillAnswerForMyResponse getMyWillAnswerList(QuestionWillAnswerForMyRequest request, Passport passport);

    /**
     * 高级查询历史问题问题
     *
     * @param request  高级查询问题请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    QuestionFindResponse findHistoryQuestion(QuestionFindRequest request, Passport passport);

}
