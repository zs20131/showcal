/**
 * @(#)MessageMapper.java  
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
package com.showcal.service.dal;

import com.showcal.service.domain.ServiceMessage;
import com.showcal.service.po.ServiceMessagePO;
import com.showcal.service.request.MessageHistoryGetRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
@MyBatisRepository("ServiceMessageMapper")
public interface MessageMapper extends MessageMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") ServiceMessagePO request, @Param("passport") Passport passport);

    /**
     * 获取历史消息(总数)
     *
     * @param request
     * @param passport
     * @return
     */
    Long getHistoryCount(@Param("request") MessageHistoryGetRequest request, @Param("passport") Passport passport);

    /**
     * 获取历史消息
     *
     * @param request
     * @param passport
     * @return
     */
    List<ServiceMessagePO> getHistory(@Param("request") MessageHistoryGetRequest request, @Param("passport") Passport passport);

    /**
     * 获取问题对应的消息
     *
     * @param id
     * @param passport
     * @return
     */
    List<ServiceMessagePO> getQuestionMessage(@Param("id") Long id, @Param("passport") Passport passport);
}
