/**
 * @(#)Message.java
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
package com.showcal.foundation.biz;

import com.showcal.foundation.dal.MessageMapper;
import com.showcal.foundation.domain.Message;
import com.showcal.foundation.po.MessagePO;
import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 *
 * @author 沈振家
 */
@Transactional
@Service
public class MessageManagerImpl extends BaseManagerImpl implements MessageManager {


    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private SequenceManager sequenceManager;

    /**
     * 插入记录.
     *
     * @param req 实体对象
     * @return 实体对象的ID
     */
    public MessageCreateResponse insert(MessageCreateRequest req, Passport passport) {
        MessageCreateResponse response = new MessageCreateResponse();
        MessagePO entity = this.getMapper().map(req, MessagePO.class);

        Long newId = sequenceManager.getNewId();

        entity.setId(newId);
        entity.setTenantId(passport.getTenantId());
        messageMapper.insert(entity, passport);
        Message message = this.getMapper().map(entity, Message.class);
        response.setMessage(message);
        return response;
    }

    /**
     * 按主键ID获取实体对象
     *
     * @param req 主键
     * @return 实体对象
     */
    @Transactional(readOnly = true)
    public MessageGetResponse get(MessageGetRequest req, Passport passport) {
        MessageGetResponse response = new MessageGetResponse();
        MessagePO entity = messageMapper.getById(req.getId(), passport);
        Message message = null;
        if (entity != null) {
            message = this.getMapper().map(entity, Message.class);
        }
        response.setMessage(message);
        return response;
    }

    @Override
    public MessageGetUnreadListResponse getUnreadList(MessageGetUnreadListRequest req, Passport passport) {
        MessageGetUnreadListResponse response = new MessageGetUnreadListResponse();
        List<MessagePO> entityList = messageMapper.getUnreadMessages(passport);
        List<Message> modelList = new ArrayList<>();
        for (MessagePO entity : entityList) {
            Message message = this.getMapper().map(entity, Message.class);
            modelList.add(message);
        }
        response.setMessageList(modelList);
        return response;
    }

    @Override
    public MessageGetReadedListResponse getReadedList(MessageGetReadedListRequest req, Passport passport) {
        MessageGetReadedListResponse response = new MessageGetReadedListResponse();
        List<MessagePO> entityList = messageMapper.getReadedMessages(passport);
        List<Message> modelList = new ArrayList<>();
        for (MessagePO entity : entityList) {
            Message message = this.getMapper().map(entity, Message.class);
            modelList.add(message);
        }
        response.setMessageList(modelList);
        return response;
    }

    @Override
    public MessageReadResponse read(MessageReadRequest req, Passport passport) {
        MessageReadResponse response = new MessageReadResponse();
        List<MessagePO> entityList = new ArrayList<>();
        for (Long id : req.getIds()) {
            MessagePO entity = new MessagePO();
            entity.setId(id);
            entity.setTenantId(passport.getTenantId());
            entity.setReadTime(new Date());
            entityList.add(entity);
        }
        messageMapper.updateBatch(entityList, passport);
        return response;
    }


}
