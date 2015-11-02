/**
 * @(#)MessageMapper.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.foundation.dal;

import com.showcal.foundation.po.MessagePO;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 * @author 沈振家
 */
@MyBatisRepository
public interface MessageMapper extends MessageMapperAuto {

    /**
     * 查询所有消息列表
     *
     * @param passport 用户护照
     * @return 消息列表
     */
    List<MessagePO> getUnreadMessages(@Param("passport") Passport passport);

    /**
     * 查询所有消息列表
     *
     * @param passport 用户护照
     * @return 消息列表
     */
    List<MessagePO> getReadedMessages(@Param("passport") Passport passport);

}
