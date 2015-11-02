/**
 * @(#)SysUserPasswordManagerImpl.java
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
package com.showcal.platform.biz;

import com.showcal.cms.svc.Message;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.SysUserMapper;
import com.showcal.platform.dal.SysUserPasswordMapper;
import com.showcal.platform.domain.IntegralRuleTypeEnum;
import com.showcal.platform.domain.SysUserPassword;
import com.showcal.platform.po.SysUserPO;
import com.showcal.platform.po.SysUserPasswordPO;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSysUserPasswordManager")
public class SysUserPasswordManagerImpl extends BaseManagerImpl implements SysUserPasswordManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SysUserPasswordMapper sysUserPasswordMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private PassportManager passportManager;

    @Autowired
    private IntegralDetailManager integralDetailManager;

    /**
     * 根据Id获取用户密码表,考虑安全，纯扩展表
     *
     * @param request  获取用户密码表,考虑安全，纯扩展表请求
     * @param passport 用户护照
     * @return 获取用户密码表, 考虑安全，纯扩展表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserPasswordGetResponse get(SysUserPasswordGetRequest request, Passport passport) {
        SysUserPasswordPO entity = sysUserPasswordMapper.getById(request.getId(), passport);
        SysUserPasswordGetResponse response = new SysUserPasswordGetResponse();
        if (entity != null) {
            SysUserPassword sysUserPassword = this.getMapper().map(entity, SysUserPassword.class);
            response.setSysUserPassword(sysUserPassword);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 创建用户密码表,考虑安全，纯扩展表
     *
     * @param request  创建用户密码表,考虑安全，纯扩展表请求
     * @param passport 用户护照
     * @return 创建用户密码表, 考虑安全，纯扩展表应答
     */
    @Override
    public SysUserPasswordCreateResponse createLoginPassword(SysUserPasswordCreateRequest request, Passport passport) {
        SysUserPasswordPO userPassword = this.getMapper().map(request, SysUserPasswordPO.class);
        SysUserPasswordCreateResponse response = new SysUserPasswordCreateResponse();
        //1.判断用户ID是否存在,已经存在则不创建
        if (sysUserPasswordMapper.existById(request.getId(), passport) > 0) {
            return response;
        }
        //2.生成新的盐
        String salt = UUID.randomUUID().toString();
        userPassword.setLoginSalt(salt);

        //3.获得默认密码,加密保存
        userPassword.setLoginPassword(EncryptUtil.SHA1(EncryptUtil.MD5(request.getPassword()) + salt));

        //4.设置用户信息
        userPassword.setId(request.getId());
        userPassword.setNeedChangeLogin(true);

        //5.更新密码为新生成的密码
        long result = sysUserPasswordMapper.insert(userPassword, passport);
        response.setId(result);
        return response;
    }


    /**
     * 更新用户密码表,考虑安全，纯扩展表
     *
     * @param request  更新用户密码表,考虑安全，纯扩展表请求
     * @param passport 用户护照
     * @return 更新用户密码表, 考虑安全，纯扩展表应答
     */
    @Override
    public SysUserPasswordUpdateResponse update(LoginPasswordModifyRequest request, Passport passport) {
        SysUserPasswordUpdateResponse response = new SysUserPasswordUpdateResponse();
        //1.通过传入的ID查询在数据库中的密码
        SysUserPasswordPO databasePassword = sysUserPasswordMapper.getById(request.getId(), passport);
        //2.如果未查到,说明ID不存在,抛出异常
        if (null == databasePassword) {
            response.addError("", "用户不存在");
            return response;
        }

        //3.通过传入的密码与数据库中的盐,计算数据库中的密码
//        String password = EncryptUtil.SHA1(request.getOldLoginPassword() + databasePassword.getLoginSalt());
        //4.对比计算的密码与保存的密码是否一致,如果一致,说明密码正确.
        if (true) { // 修改，目前修改密码，暂时没有验证原密码功能
            //5.更新时要更新盐,获得新的盐
            String salt = UUID.randomUUID().toString();
            SysUserPasswordPO userLoginPassword = new SysUserPasswordPO();
            userLoginPassword.setLoginSalt(salt);
            userLoginPassword.setId(request.getId());
            userLoginPassword.setRowVersion(databasePassword.getRowVersion());

            //6.将密码与盐混合,以SHA1加密方式生成新的密码
            userLoginPassword.setLoginPassword(EncryptUtil.SHA1(request.getLoginPassword() + salt));
            userLoginPassword.setNeedChangeLogin(false);

            //7.保存新的密码
            long result = sysUserPasswordMapper.update(userLoginPassword, passport);
            response.setResult(result);
            System.out.println(result);

        } else {
            response.addError("", "密码不正确");
        }
        return response;
    }


    @Override
    public SysUserPasswordUpdateResponse updateCheck(LoginPasswordModifyRequest request, Passport passport) {
        SysUserPasswordUpdateResponse response = new SysUserPasswordUpdateResponse();
        //1.通过传入的ID查询在数据库中的密码
        SysUserPasswordPO databasePassword = sysUserPasswordMapper.getById(request.getId(), passport);
        //2.如果未查到,说明ID不存在,抛出异常
        if (null == databasePassword) {
            response.addError("", "用户不存在");
            return response;
        }

        if (request.getOldLoginPassword() == null){
            response.addError("","请输入原始密码");
            return response;
        }

        //3.通过传入的密码与数据库中的盐,计算数据库中的密码
        String password = EncryptUtil.SHA1(request.getOldLoginPassword() + databasePassword.getLoginSalt());
        //4.对比计算的密码与保存的密码是否一致,如果一致,说明密码正确.
        if (password.equals(databasePassword.getLoginPassword())) {
            //5.更新时要更新盐,获得新的盐
            String salt = UUID.randomUUID().toString();
            SysUserPasswordPO userLoginPassword = new SysUserPasswordPO();
            userLoginPassword.setLoginSalt(salt);
            userLoginPassword.setId(request.getId());
            userLoginPassword.setRowVersion(databasePassword.getRowVersion());

            //6.将密码与盐混合,以SHA1加密方式生成新的密码
            userLoginPassword.setLoginPassword(EncryptUtil.SHA1(request.getLoginPassword() + salt));
            userLoginPassword.setNeedChangeLogin(false);

            //7.保存新的密码
            long result = sysUserPasswordMapper.update(userLoginPassword, passport);
            response.setResult(result);
            System.out.println(result);

        } else {
            response.addError("", "原始密码不正确");
        }
        return response;
    }

    /**
     * 删除用户密码表,考虑安全，纯扩展表
     *
     * @param request  删除用户密码表,考虑安全，纯扩展表请求
     * @param passport 用户护照
     * @return 删除用户密码表, 考虑安全，纯扩展表应答
     */
    @Override
    public SysUserPasswordDeleteResponse delete(SysUserPasswordDeleteRequest request, Passport passport) {
        SysUserPasswordDeleteResponse response = new SysUserPasswordDeleteResponse();
        Long result = sysUserPasswordMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest req) {
        LoginResponse response = new LoginResponse();
        //1.通过传入的ID查询在数据库中的密码
        Passport passport = new Passport();
        SysUserPO sysUserPO = sysUserMapper.getUserByAccount(req.getAccount());
        if(sysUserPO==null){
            response.addError(ErrorType.BUSINESS_ERROR,"账号不存在，请检查");
            return  response;
        }
        if (sysUserPO.getIsActive()==null||!sysUserPO.getIsActive()) {
            response.addError(ErrorType.BUSINESS_ERROR, "用户已失效，不能登录");
            return response;
        }
        SysUserPasswordPO databasePassword = sysUserPasswordMapper.getById(sysUserPO.getId(), passport);
        //2.如果未查到,说明ID不存在,抛出异常
        if (null == databasePassword) {
            response.addError(ErrorType.BUSINESS_ERROR, "您从未登录过系统，请通过找回密码功能来创建初始密码");
            return response;
        } else {
            response.setNeedUpdateLogin(databasePassword.getNeedChangeLogin());
        }
        //3.通过传入的密码与数据库中的盐,计算数据库中的密码
        String password = EncryptUtil.SHA1(req.getPassword() + databasePassword.getLoginSalt());
        //4.对比计算的密码与保存的密码是否一致,如果一致,说明密码正确.
        if (password.equals(databasePassword.getLoginPassword())) {
            //生成passport
            return publishPassport(sysUserPO.getId(),req.getIp(), response);
        } else {
            response.addError(ErrorType.INVALID_PARAMETER, "密码不正确");
            return response;
        }
    }

    /**
     * 密码验证成功后颁发护照
     * @param response
     * @return
     */
    private LoginResponse publishPassport(Long userId,String loginIp, LoginResponse response) {
        PassportCreateRequest passportCreateRequest = new PassportCreateRequest();
        passportCreateRequest.setUserId(userId);
        passportCreateRequest.setIssueTime(new Date());
        passportCreateRequest.setExpireTime(new Date(new Date().getTime() + 24 * 60 * 60 * 1000));
        passportCreateRequest.setIssueIP(loginIp);
        PassportCreateResponse passportCreateResponse = passportManager.create(passportCreateRequest);
        PassportGetRequest reqGet = new PassportGetRequest();
        reqGet.setId(passportCreateResponse.getId());
        PassportGetResponse responseGet = passportManager.get(reqGet);
        Passport passportAfterCreate = responseGet.getPassport();
        response.setPassport(passportAfterCreate);
        //登录积分
        IntegralDetailCreateRequest integralDetailCreateRequest=new IntegralDetailCreateRequest();
        integralDetailCreateRequest.setType(IntegralRuleTypeEnum.LOGIN.name());
        integralDetailManager.create(integralDetailCreateRequest, passportAfterCreate);
        return response;
    }

    /**
     * 验证对象
     *
     * @param sysUserPassword 用户密码表,考虑安全，纯扩展表
     * @param passport        用户护照
     */
    private void checkValidate(SysUserPasswordPO sysUserPassword, Passport passport, BaseResponse response) {
        // TODO

    }


}
