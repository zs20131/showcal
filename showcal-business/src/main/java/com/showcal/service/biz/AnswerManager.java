/**
 * @(#)AnswerManager.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public interface AnswerManager {
    /**
     * 根据Id获取答案
     *
     * @param request 获取答案请求
     * @param passport 用户护照
     * @return 获取答案应答
     */
    AnswerGetResponse get(AnswerGetRequest request, Passport passport);


    /**
     * 模糊查询答案
     *
     * @param request 模糊查询答案请求
     * @param passport 用户护照
     * @return 模糊查询答案应答
     */
    AnswerSearchResponse search(AnswerSearchRequest request, Passport passport);

    /**
     * 高级查询答案
     *
     * @param request 高级查询答案请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    AnswerFindResponse find(AnswerFindRequest request, Passport passport);

    /**
     * 获取所有答案列表
     *
     * @param request 获取所有答案列表请求
     * @param passport 用户护照
     * @return 获取所有答案列表应答
     */
    AnswerGetAllListResponse getAllList(AnswerGetAllListRequest request, Passport passport);


    /**
     * 发送答案
     * @param request
     * @param passport
     * @return
     */
    AnswerSendResponse send(AnswerSendRequest request, Passport passport);

    /**
     * 关闭问题列表
     * @param request
     * @param passport
     * @return
     */
    QuestionCloseResponse closeQuestions(QuestionCloseRequest request, Passport passport);

}
