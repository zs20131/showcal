/**
 * @(#)SysMessageManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.platform.biz;

import com.showcal.cms.dal.ArticleMapper;
import com.showcal.cms.po.ArticlePO;
import com.showcal.cms.svc.Message;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.dal.SysMessageMapper;
import com.showcal.platform.domain.MessageTypeEnum;
import com.showcal.platform.domain.SysMessage;
import com.showcal.platform.po.SysMessagePO;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSysMessageManager")
public class SysMessageManagerImpl extends BaseManagerImpl implements SysMessageManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SysMessageMapper sysMessageMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private SysUserManager sysUserManager;

    /**
     * 根据Id获取系统消息表
     *
     * @param request  获取系统消息表请求
     * @param passport 用户护照
     * @return 获取系统消息表应答
     */
    @Override
    public SysMessageGetResponse get(SysMessageGetRequest request, Passport passport) {
        SysMessagePO entity = sysMessageMapper.getById(request.getId(), passport);
        SysMessageGetResponse response = new SysMessageGetResponse();
        if (entity != null) {
            SysMessage sysMessage = this.getMapper().map(entity, SysMessage.class);
            response.setSysMessage(sysMessage);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 高级查询系统消息表
     *
     * @param request  高级查询系统消息表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public SysMessageFindResponse find(SysMessageFindRequest request, Passport passport) {
        SysMessageFindResponse response = new SysMessageFindResponse();
        request.setUserId(passport.getUserId());
        List<SysMessage> modelList = new ArrayList<>();
        Long count = sysMessageMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<SysMessagePO> entityList = sysMessageMapper.find(request, passport);
            for (SysMessagePO entity : entityList) {
                SysMessage sysMessage = this.getMapper().map(entity, SysMessage.class);
                SysUserGetRequest sysUserGetRequest = new SysUserGetRequest();
                sysUserGetRequest.setId(entity.getSenderId());
                SysUserGetResponse sysUserGetResponse = sysUserManager.get(sysUserGetRequest, passport);
                if (sysUserGetResponse != null && sysUserGetResponse.getSysUser() != null) {
                    UserInfo userInfo = sysUserGetResponse.getSysUser();
                    if (userInfo.getAvatarId() != null && userInfo.getAvatarId().intValue() != 0) {
                        sysMessage.setUrl(userInfo.getAvatarurl());
                    } else {
                        if (userInfo.getSex() != null) {
                            if (userInfo.getSex().equals(SexEnum.FEMALE)) {
                                sysMessage.setUrl("../images/girl.png");
                            } else if (userInfo.getSex().equals(SexEnum.MALE)) {
                                sysMessage.setUrl("../images/boy.png");
                            }
                        } else {
                            sysMessage.setUrl("../images/girl.png");
                        }
                    }

                }
                modelList.add(sysMessage);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }


    /**
     * 创建系统消息表
     *
     * @param request  创建系统消息表请求
     * @param passport 用户护照
     * @return 创建系统消息表应答
     */
    @Override
    public SysMessageCreateResponse create(SysMessageCreateRequest request, Passport passport) {
        SysMessagePO entity = this.getMapper().map(request, SysMessagePO.class);
        long id = foundationService.getNewId();
        entity.setId(id);
        entity.setSendTime(new Date());
        entity.setSenderId(passport.getUserId());
        if (request.getBusinessId() != null) {
            if (request.getBusinessType().equals(MessageTypeEnum.ARTICLE.name())) {
                ArticlePO articlePO = articleMapper.getById(request.getBusinessId(), passport);
                if (articlePO != null) {
                    entity.setMessageTitle(passport.getNickName() + "向你推送了" + articlePO.getTitle() + "的帖子");
                    entity.setMessageContent(passport.getNickName() + "向你推送了" + articlePO.getTitle() + "的帖子");
                }
            }
        }
        SysMessageCreateResponse response = new SysMessageCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == sysMessageMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新系统消息表
     *
     * @param request  更新系统消息表请求
     * @param passport 用户护照
     * @return 更新系统消息表应答
     */
    @Override
    public SysMessageUpdateResponse update(SysMessageUpdateRequest request, Passport passport) {
        SysMessagePO entity = sysMessageMapper.getById(request.getId(), passport);
        entity.setReadTime(request.getReadTime());
        entity.setIsReaded(request.getIsReaded());
        SysMessageUpdateResponse response = new SysMessageUpdateResponse();
        Long result = sysMessageMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }

    @Override
    public SysMessageCreateListResponse createList(SysMessageCreateListRequest request, Passport passport) {
        SysMessageCreateListResponse response = new SysMessageCreateListResponse();
        List<Long> ids = new ArrayList<>();
        for (SysMessageCreateRequest sysMessageCreateRequest : request.getSysMessageCreateRequestList()) {
            SysMessageCreateResponse sysMessageCreateResponse = this.create(sysMessageCreateRequest, passport);
            ids.add(sysMessageCreateResponse.getId());
        }
        response.setId(ids);
        return response;
    }

    /**
     * 验证对象
     *
     * @param sysMessage 系统消息表
     * @param passport   用户护照
     */
    private void checkValidate(SysMessagePO sysMessage, Passport passport, BaseResponse response) {
        // TODO

    }


}
