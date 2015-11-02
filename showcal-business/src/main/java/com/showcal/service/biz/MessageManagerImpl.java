/**
 * @(#)MessageManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.service.biz;

import com.github.rjeschke.txtmark.Processor;
import com.showcal.cms.svc.Message;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.biz.SysUserManager;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.service.dal.MessageMapper;
import com.showcal.service.domain.ServiceMessage;
import com.showcal.service.domain.SexEnum;
import com.showcal.service.po.ServiceMessagePO;
import com.showcal.service.request.MessageHistoryGetRequest;
import com.showcal.service.request.ServiceMessageCreateRequest;
import com.showcal.service.request.ServiceMessageGetRequest;
import com.showcal.service.response.MessageHistoryGetResponse;
import com.showcal.service.response.ServiceMessageCreateResponse;
import com.showcal.service.response.ServiceMessageGetResponse;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ServiceMessageManager")
public class MessageManagerImpl extends BaseManagerImpl implements MessageManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private SysUserManager sysUserManager;


    /**
     * 根据Id获取消息内容
     *
     * @param request  获取消息内容请求
     * @param passport 用户护照
     * @return 获取消息内容应答
     */
    @Override
    @Transactional(readOnly = true)
    public ServiceMessageGetResponse get(ServiceMessageGetRequest request, Passport passport) {
        ServiceMessagePO entity = messageMapper.getById(request.getId(), passport);
        ServiceMessageGetResponse response = new ServiceMessageGetResponse();
        if (entity != null) {
            ServiceMessage message = this.getMapper().map(entity, ServiceMessage.class);
            response.setMessage(message);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 创建消息内容
     *
     * @param request  创建消息内容请求
     * @param passport 用户护照
     * @return 创建消息内容应答
     */
    @Override
    public ServiceMessageCreateResponse create(ServiceMessageCreateRequest request, Passport passport) {
        ServiceMessagePO entity = this.getMapper().map(request, ServiceMessagePO.class);
        long id = foundationService.getNewId();
        entity.setId(id);
        ServiceMessageCreateResponse response = new ServiceMessageCreateResponse();
        checkValidate(entity, passport, response);
        if (1 == messageMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }

    /**
     * 获取历史聊天的消息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public MessageHistoryGetResponse getHistoryMesage(MessageHistoryGetRequest request, Passport passport) {
        if (request.getUserId() == null || request.getUserId() <= 0) {
            request.setUserId(passport.getUserId());
        }
        List<ServiceMessage> modelList = new ArrayList<>();
        Long count = messageMapper.getHistoryCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            // 2 根据条件，查询未回答的列表数据
            List<ServiceMessagePO> serviceMessagePOs = messageMapper.getHistory(request, passport);
            for (ServiceMessagePO entity : serviceMessagePOs) {
                ServiceMessage serviceMessage = this.getMapper().map(entity, ServiceMessage.class);
                if (serviceMessage.getFromUserId() != null) {
                    SysUserGetRequest sysUserGetRequest = new SysUserGetRequest();
                    sysUserGetRequest.setId(serviceMessage.getFromUserId());
                    UserInfo userInfo = sysUserManager.get(sysUserGetRequest, passport).getSysUser();
                    if (userInfo != null) {
                        if (userInfo.getAvatarId() != null && userInfo.getAvatarId().intValue() != 0) {
                            FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                            filePathGetRequest.setId(userInfo.getAvatarId());
                            FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                            serviceMessage.setAvatarurl(filePathGetResponse.getUrl());
                        } else {
                            if (userInfo.getSex() != null) {
                                if (userInfo.getSex().equals(SexEnum.FEMALE)) {
                                    serviceMessage.setAvatarurl("../images/girl.png");
                                } else if (userInfo.getSex().equals(SexEnum.MALE)) {
                                    serviceMessage.setAvatarurl("../images/boy.png");
                                }
                            } else {
                                serviceMessage.setAvatarurl("../images/girl.png");
                            }
                        }
                    }
                }
                modelList.add(serviceMessage);
            }
        }
        MessageHistoryGetResponse response = new MessageHistoryGetResponse();
        if (passport.getUserId() != null) {
            SysUserGetRequest sysUserGetRequest = new SysUserGetRequest();
            sysUserGetRequest.setId(passport.getUserId());
            UserInfo userInfo = sysUserManager.get(sysUserGetRequest, passport).getSysUser();
            if (userInfo.getAvatarId() != null&&userInfo.getAvatarId().intValue()!=0) {
                FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                filePathGetRequest.setId(userInfo.getAvatarId());
                FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                response.setUrl(filePathGetResponse.getUrl());
            } else {
                if (userInfo.getSex() != null) {
                    if (userInfo.getSex().equals(SexEnum.FEMALE)) {
                        response.setUrl("../images/girl.png");
                    } else if (userInfo.getSex().equals(SexEnum.MALE)) {
                        response.setUrl("../images/boy.png");
                    }
                } else {
                    response.setUrl("../images/girl.png");
                }
            }
        }
        response.setName(passport.getNickName());
        response.setResult(modelList);
        response.setTotalCount(count);
        return response;
    }

    @Override
    public List<ServiceMessage> getQuestionMessage(Long id, Passport passport) {
        List<ServiceMessagePO> messages = messageMapper.getQuestionMessage(id, passport);
        List<ServiceMessage> messageList = new ArrayList<>();
        for (ServiceMessagePO serviceMessage : messages) {
            ServiceMessage message = this.getMapper().map(serviceMessage, ServiceMessage.class);
            if (message.getContent() != null && !"".equals(message.getContent())) {
                message.setContent(Processor.process(serviceMessage.getContent().replaceAll("\n", "\n\n")));
            }
            messageList.add(message);
        }
        return messageList;
    }

    /**
     * 验证对象
     *
     * @param message  消息内容
     * @param passport 用户护照
     */
    private void checkValidate(ServiceMessagePO message, Passport passport, BaseResponse response) {
        // TODO

    }


}
