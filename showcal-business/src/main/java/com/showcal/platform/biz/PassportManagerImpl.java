/**
 * @(#)Passport.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.platform.biz;


import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.PassportMapper;
import com.showcal.platform.domain.RevokeEnum;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.platform.po.PassportPO;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.showcal.platform.service.PlatformService;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 沈振家 on 2014-07-30 16:47:07.
 *
 * @author 沈振家
 */
@Transactional
@Service
public class PassportManagerImpl extends BaseManagerImpl implements PassportManager {


    @Autowired
    private PassportMapper passportMapper;

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SysUserManager sysUserManager;
    @Autowired
    private PlatformService platformService;


    /**
     * 插入记录.
     *
     * @param req 实体对象
     * @return 实体对象的ID
     */
    public PassportCreateResponse create(PassportCreateRequest req) {
        PassportCreateResponse response = new PassportCreateResponse();
        PassportPO entity = this.getMapper().map(req, PassportPO.class);
        Long newId = foundationService.getNewId();
        entity.setId(newId);
        passportMapper.insert(entity);
        response.setId(newId);
        return response;
    }

    /**
     * 按主键ID获取实体对象
     *
     * @param req 主键
     * @return 实体对象
     */
    @Transactional(readOnly = true)
    public PassportGetResponse get(PassportGetRequest req) {
        PassportGetResponse response = new PassportGetResponse();
        Passport passport = null;

        PassportPO entity = passportMapper.getById(req.getId());
        if (entity != null) {
            passport = this.getMapper().map(entity, Passport.class);
            // 查询是否有消息
            SysMessageFindRequest request = new SysMessageFindRequest();
            request.setUserId(passport.getUserId());
            request.setPageSize(0);
            request.setIsRead(false);
            SysMessageFindResponse sysMessageFindResponse = platformService.find(request, passport);
            passport.setTenantId(sysMessageFindResponse.getTotalCount());
            /* 获取用户信息 */
            SysUserGetRequest userGetRequest = new SysUserGetRequest();
            userGetRequest.setId(passport.getUserId());
            SysUserGetResponse userGetResponse = sysUserManager.get(userGetRequest, passport);
            SysUser user = userGetResponse.getSysUser();
            /* 查询用户头像路径 */
            FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
            if (user != null) {
                passport.setUserName(user.getName());
                passport.setNickName(user.getNickName());
                //
                if (user.getUserType() != null) {

                    switch (user.getUserType().toString()) {
                        case "USER":
                            passport.setType(PassportTypeEnum.MEMBER);
                            break;
                        case "PLADMIN":
                            passport.setType(PassportTypeEnum.EMPLOYEE);
                            break;
                        case "SHOWCAL":
                            passport.setType(PassportTypeEnum.SUPPLIER);
                            break;
                    }
                }
                if (user.getAvatarId() != null) {
                    filePathGetRequest.setId(user.getAvatarId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    passport.setAvatar(filePathGetResponse.getUrl());
                }
            } else {
                passport = null;
                response.addError(ErrorType.BUSINESS_ERROR, "用户已被删除，或不存在!");
            }
        }
        response.setPassport(passport);
        return response;
    }

    /**
     * 注销护照
     *
     * @param req 主键
     */
    public PassportRevokeResponse revoke(PassportRevokeRequest req) {
        PassportRevokeResponse response = new PassportRevokeResponse();
        PassportPO passportPO = new PassportPO();
        passportPO.setId(req.getId());
        passportPO.setRevokeTime(new Date());
        passportPO.setRevokeType(RevokeEnum.LOGOUT.toString());
        passportMapper.update(passportPO);
        return response;
    }

}
