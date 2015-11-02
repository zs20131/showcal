/**
 * @(#)MessageManager.java
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


import com.showcal.service.domain.ServiceMessage;
import com.showcal.service.request.MessageHistoryGetRequest;
import com.showcal.service.request.ServiceMessageCreateRequest;
import com.showcal.service.request.ServiceMessageGetRequest;
import com.showcal.service.response.MessageHistoryGetResponse;
import com.showcal.service.response.ServiceMessageCreateResponse;
import com.showcal.service.response.ServiceMessageGetResponse;
import com.xiniunet.framework.security.Passport;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
public interface MessageManager {
    /**
     * 根据Id获取消息内容
     *
     * @param request  获取消息内容请求
     * @param passport 用户护照
     * @return 获取消息内容应答
     */
    ServiceMessageGetResponse get(ServiceMessageGetRequest request, Passport passport);

    /**
     * 创建消息内容
     *
     * @param request  创建消息内容请求
     * @param passport 用户护照
     * @return 创建消息内容应答
     */
    ServiceMessageCreateResponse create(ServiceMessageCreateRequest request, Passport passport);

    /**
     * 获取我的消息
     *
     * @param request
     * @param passport
     * @return
     */
    MessageHistoryGetResponse getHistoryMesage(MessageHistoryGetRequest request, Passport passport);

    /**
     * 内部调用（获取问题对应的消息），不做外部接口
     * @param id
     * @param passport
     * @return
     */
    List<ServiceMessage> getQuestionMessage(Long id, Passport passport);

}
