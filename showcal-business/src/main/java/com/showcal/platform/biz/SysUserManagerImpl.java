/**
 * @(#)SysUserManagerImpl.java
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

import com.showcal.cms.biz.ArticleManager;
import com.showcal.cms.svc.Message;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.ShowCalInfo;
import com.showcal.mobile.domain.UserInfo;
import com.showcal.mobile.request.ShowCalQueryRequest;
import com.showcal.mobile.request.ShowcalGetRequest;
import com.showcal.mobile.response.ShowCalGetResponse;
import com.showcal.mobile.response.ShowCalQueryResponse;
import com.showcal.platform.dal.SettingUserTagMapper;
import com.showcal.platform.dal.SysUserExtentMapper;
import com.showcal.platform.dal.SysUserMapper;
import com.showcal.platform.dal.SysUserTagsMapper;
import com.showcal.platform.domain.*;
import com.showcal.platform.po.SettingUserTagPO;
import com.showcal.platform.po.SysUserExtentPO;
import com.showcal.platform.po.SysUserPO;
import com.showcal.platform.po.SysUserTagsPO;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.showcal.platform.service.PlatformService;
import com.showcal.service.dal.ServiceUserMapper;
import com.showcal.service.po.ServiceUserPO;
import com.showcal.service.request.SelfIntroductionGetRequest;
import com.showcal.service.response.SelfIntroductionGetResponse;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.PinYinUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSysUserManager")
public class SysUserManagerImpl extends BaseManagerImpl implements SysUserManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserPasswordManager sysUserPasswordManager;
    @Autowired
    private SysUserExtentManager sysUserExtentManager;
    @Autowired
    private ServiceUserMapper serviceUserMapper;
    @Autowired
    private SysUserExtentMapper sysUserExtentMapper;
    @Autowired
    private SysUserTagsMapper sysUserTagsMapper;
    @Autowired
    private SettingUserTagMapper settingUserTagMapper;
    @Autowired
    private ArticleManager articleManager;
    @Autowired
    private PassportManager passportManager;
    @Autowired
    private PlatformService platformService;

    @Autowired
    private IntegralDetailManager integralDetailManager;

    /**
     * 根据Id获取用户
     *
     * @param request  获取用户请求
     * @param passport 用户护照
     * @return 获取用户应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserGetResponse get(SysUserGetRequest request, Passport passport) {
        SysUserPO entity = sysUserMapper.getById(request.getId(), passport);
        SysUserGetResponse response = new SysUserGetResponse();
        if (entity != null) {
            UserInfo userInfo = this.getMapper().map(entity, UserInfo.class);
            SysUserExtentPO sysUserExtentPO = sysUserExtentMapper.getById(request.getId(), passport);
            if (sysUserExtentPO != null) {
                userInfo.setHeight(sysUserExtentPO.getHeight());
                userInfo.setHipline(sysUserExtentPO.getHipline());
                userInfo.setBirthday(sysUserExtentPO.getBirthday());
                userInfo.setWaistLine(sysUserExtentPO.getWaistLine());
                userInfo.setWeight(sysUserExtentPO.getWeight());
                userInfo.setBmi(sysUserExtentPO.getBmi());
                userInfo.setIntegral(sysUserExtentPO.getIntegral());
                if (sysUserExtentPO.getBirthday() != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    int year = calendar.get(Calendar.YEAR);
                    calendar.setTime(sysUserExtentPO.getBirthday());
                    userInfo.setAge(year - calendar.get(Calendar.YEAR));
                }
                response.setCountService(sysUserExtentPO.getCountService());
                if (userInfo.getAvatarId() != null) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(userInfo.getAvatarId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    userInfo.setAvatarurl(filePathGetResponse.getUrl());
                }
            } else {
                response.setCountService(0);
            }
            response.setSysUser(userInfo);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询用户
     *
     * @param request  模糊查询用户请求
     * @param passport 用户护照
     * @return 模糊查询用户应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserSearchResponse search(SysUserSearchRequest request, Passport passport) {
        SysUserSearchResponse response = new SysUserSearchResponse();
        List<SysUser> modelList = new ArrayList<SysUser>();
        Long count = sysUserMapper.searchCount(request, passport);

        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }

            //通过关键字查询出用户集合
            List<SysUserPO> entityList = sysUserMapper.search(request, passport);

            for (SysUserPO entity : entityList) {
                SysUser sysUser = this.getMapper().map(entity, SysUser.class);
                modelList.add(sysUser);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询用户
     *
     * @param request  高级查询用户请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserFindResponse find(SysUserFindRequest request, Passport passport) {
        SysUserFindResponse response = new SysUserFindResponse();
        List<UserDetail> modelList = new ArrayList<UserDetail>();
        Long count = sysUserMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SysUserPO> entityList = sysUserMapper.find(request, passport);
            List<Long> ids = new ArrayList<>();
            for (SysUserPO entity : entityList) {
                ids.add(entity.getId());
            }

            SysUserExtentGetByIdsRequest sysUserExtentGetByIdsRequest = new SysUserExtentGetByIdsRequest();
            sysUserExtentGetByIdsRequest.setIds(ids);
            List<SysUserExtent> sysUserExtents = sysUserExtentManager.getUserExtentByIds(sysUserExtentGetByIdsRequest, passport).getResult();
            Map<Long, SysUserExtent> userExtentMap = new HashMap<>();
            if (sysUserExtents != null) {
                for (SysUserExtent sysUserExtent : sysUserExtents) {
                    userExtentMap.put(sysUserExtent.getId(), sysUserExtent);
                }
            }
            Date currentDate = new Date();
            int currentYear = currentDate.getYear();
            for (SysUserPO sysUserPO : entityList) {
                UserDetail userDetail = this.getMapper().map(sysUserPO, UserDetail.class);
                // 用户标签
                SysUserTagsGetAllListByUserRequest sysUserTagsGetAllListByUserRequest = new SysUserTagsGetAllListByUserRequest();
                sysUserTagsGetAllListByUserRequest.setUserId(sysUserPO.getId());
                List<SysUserTagsPO> sysUserTagsPOs = sysUserTagsMapper.getAllListByUser(sysUserTagsGetAllListByUserRequest, passport);
                if (sysUserTagsPOs != null) {
                    List<Long> sysUserTagIds = new ArrayList<>();
                    List<String> sysUserTagNames = new ArrayList<>();
                    for (SysUserTagsPO sysUserTagsPO : sysUserTagsPOs) {
                        sysUserTagIds.add(sysUserTagsPO.getUserTagId());
                        SettingUserTagPO settingUserTagPO = settingUserTagMapper.getById(sysUserTagsPO.getUserTagId(), passport);
                        if(settingUserTagPO!=null){
                            sysUserTagNames.add(settingUserTagPO.getTag());
                        }
                    }
                    userDetail.setUserTagIds(sysUserTagIds);
                    userDetail.setUserTagNames(sysUserTagNames);
                }
                if (userExtentMap.containsKey(userDetail.getId())) {
                    SysUserExtent userExtent = userExtentMap.get(userDetail.getId());
                    if (userExtent != null) {
                        userDetail.setHeight(userExtent.getHeight());
                        userDetail.setBirthday(userExtent.getBirthday());
                        if (userExtent.getBirthday() != null) {
                            userDetail.setAge(currentYear - userExtent.getBirthday().getYear());
                        }
                        userDetail.setWeight(userExtent.getWeight());
                        userDetail.setWaistLine(userExtent.getWaistLine());
                        userDetail.setHipline(userExtent.getHipline());
                        userDetail.setBmi(userExtent.getBmi());
                        userDetail.setSetting(userExtent.getSetting());
                        userDetail.setCountService(userExtent.getCountService());
                        userDetail.setResponseTime(userExtent.getResponseTime());
                        userDetail.setSuccessRate(userExtent.getSuccessRate());
                    }
                }

                if (userDetail.getAge() != null) {
                    if (request.getStartAge() != null && request.getEndAge() != null) { // 起始，截止年龄都有
                        if (userDetail.getAge().intValue() >= request.getStartAge().intValue() && userDetail.getAge().intValue() <= request.getEndAge().intValue()) {
                            modelList.add(userDetail);
                        } else {
                            count--;
                        }
                    } else if (request.getStartAge() != null && request.getEndAge() == null) { // 起始年龄有，截止年龄没有
                        if (userDetail.getAge().intValue() >= request.getStartAge().intValue()) {
                            modelList.add(userDetail);
                        } else {
                            count--;
                        }
                    } else if (request.getStartAge() == null && request.getEndAge() != null) { // 起始年龄没有，截止年龄有
                        if (userDetail.getAge().intValue() <= request.getEndAge().intValue()) {
                            modelList.add(userDetail);
                        } else {
                            count--;
                        }
                    } else { // 起始，截止年龄都没有
                        modelList.add(userDetail);
                    }
                } else {
                    if (request.getStartAge() == null && request.getEndAge() == null){
                        modelList.add(userDetail);
                    }else {
                        count--;
                    }
                }

            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有用户列表
     *
     * @param request  获取所有用户列表请求
     * @param passport 用户护照
     * @return 获取所有用户列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserGetAllListResponse getAllList(SysUserGetAllListRequest request, Passport passport) {
        SysUserGetAllListResponse response = new SysUserGetAllListResponse();


        List<SysUserPO> entityList = sysUserMapper.getAllList(request, passport);


        List<SysUser> modelList = new ArrayList<SysUser>();
        for (SysUserPO entity : entityList) {
            SysUser sysUser = this.getMapper().map(entity, SysUser.class);
            modelList.add(sysUser);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建用户
     *
     * @param request  创建用户请求
     * @param passport 用户护照
     * @return 创建用户应答
     */
    @Override
    public SysUserCreateResponse create(SysUserCreateRequest request, Passport passport) {
        if (request.getUserType() == null) {
            request.setUserType(UserTypeEnum.USER);
        }
        SysUserPO entity = this.getMapper().map(request, SysUserPO.class);
            /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        SysUserCreateResponse response = new SysUserCreateResponse();
        /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);
        if (response.hasError()) {
            return response;
        }
        long id = foundationService.getNewId();
        entity.setId(id);
        entity.setName(request.getNickName());
        if (entity.getNickName() != null && entity.getNickName() != "") {
            entity.setPinyin(PinYinUtil.getPinYin(entity.getNickName()));
            entity.setPy(PinYinUtil.getPinYinHeadChar(entity.getNickName()));
        }
        entity.setAccount(request.getMobilePhone());
        entity.setIsActive(true);
        entity.setActiveDate(new Date());
        entity.setIsBanned(false);
        if (1 == sysUserMapper.insert(entity, passport)) {
            response.setId(id);
            // 创建用户时，添加默认密码
            SysUserPasswordCreateRequest passwordCreateRequest = new SysUserPasswordCreateRequest();
            passwordCreateRequest.setId(id);
            passwordCreateRequest.setPassword(request.getPassword());
            sysUserPasswordManager.createLoginPassword(passwordCreateRequest, passport);
            // 创建用户扩展表
            SysUserExtentCreateRequest extentCreateRequest = new SysUserExtentCreateRequest();
            extentCreateRequest.setBirthday(request.getBirthday());
            extentCreateRequest.setHeight(request.getHeight());
            extentCreateRequest.setId(id);
            sysUserExtentManager.create(extentCreateRequest, passport);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新用户
     *
     * @param request  更新用户请求
     * @param passport 用户护照
     * @return 更新用户应答
     */
    @Override
    public SysUserUpdateResponse update(SysUserUpdateRequest request, Passport passport) {
        SysUserPO entity = this.getMapper().map(request, SysUserPO.class);

        SysUserUpdateResponse response = new SysUserUpdateResponse();
        Long result = sysUserMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }

    /**
     * 升级用户
     *
     * @param request  更新用户请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserUpDownResponse up(SysUserUpDownRequest request, Passport passport) {
        SysUserUpDownResponse response = new SysUserUpDownResponse();
        // 获取当前记录
        SysUserPO entity = sysUserMapper.getById(request.getId(), passport);
        entity.setUserType(UserTypeEnum.SHOWCAL.toString());
        Long result = sysUserMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, "升级用户失败！");
            return response;
        }
        response.setResult(result);
        return response;
    }

    /**
     * 降级用户
     *
     * @param request  更新用户请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserUpDownResponse down(SysUserUpDownRequest request, Passport passport) {
        SysUserUpDownResponse response = new SysUserUpDownResponse();
        // 获取当前记录
        SysUserPO entity = sysUserMapper.getById(request.getId(), passport);
        entity.setUserType(UserTypeEnum.USER.toString());
        Long result = sysUserMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, "升级用户失败！");
            return response;
        }
        response.setResult(result);
        return response;
    }

    /**
     * 禁言用户
     *
     * @param request  更新用户请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserBanResponse ban(SysUserBanRequest request, Passport passport) {
        SysUserBanResponse response = new SysUserBanResponse();
        // 获取当前记录
        SysUserPO entity = sysUserMapper.getById(request.getId(), passport);
        entity.setIsBanned(true);
        entity.setBannedReason(request.getBannedReason());
        entity.setBannedTime(new Date());
        Long result = sysUserMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, "升级用户失败！");
            return response;
        }
        response.setResult(result);
        return response;
    }

    /**
     * 取消禁言用户
     *
     * @param request  更新用户请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public SysUserInbanResponse inban(SysUserInbanRequest request, Passport passport) {
        SysUserInbanResponse response = new SysUserInbanResponse();
        // 获取当前记录
        SysUserPO entity = sysUserMapper.getById(request.getId(), passport);
        entity.setIsBanned(false);
        entity.setBannedReason(null);
        entity.setBannedTime(null);
        Long result = sysUserMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, "升级用户失败！");
            return response;
        }
        response.setResult(result);
        return response;
    }

    /**
     * 删除用户
     *
     * @param request  删除用户请求
     * @param passport 用户护照
     * @return 删除用户应答
     */
    @Override
    public SysUserDeleteResponse delete(SysUserDeleteRequest request, Passport passport) {
        SysUserDeleteResponse response = new SysUserDeleteResponse();
        Long result = sysUserMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    @Override
    public UserAvatarUpdateResponse updateAvatar(UserAvatarUpdateRequest request, Passport passport) {
        UserAvatarUpdateResponse response = new UserAvatarUpdateResponse();
        SysUserPO sysUserPO = new SysUserPO();
        sysUserPO.setId(request.getUserId());
        sysUserPO.setAvatarId(request.getAvatarId());
        Long result = sysUserMapper.update(sysUserPO,passport);
        if(request!=null&&result>0){
            response.setResult(result);
        }
        return response;
    }

    @Override
    public UserSearchBySourceTypeResponse searchBySourceType(UserSearchBySourceTypeRequest request, Passport passport) {
        return null;
    }

    @Override
    public UserInactiveResponse inActive(UserInactiveRequest request, Passport passport) {
        UserInactiveResponse response = new UserInactiveResponse();
        // 获取当前记录
        SysUserPO entity = sysUserMapper.getById(request.getId(), passport);
        entity.setIsActive(false);
        Long result = sysUserMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, "封锁失败！");
            return response;
        }
        response.setResult(result);
        return response;
    }

    @Override
    public UserActiveResponse active(UserActiveRequest request, Passport passport) {
        UserActiveResponse response = new UserActiveResponse();
        // 获取当前记录
        SysUserPO entity = sysUserMapper.getById(request.getId(), passport);
        entity.setIsActive(true);
        Long result = sysUserMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, "取消封锁失败！");
            return response;
        }
        response.setResult(result);
        return response;
    }

    @Override
    public UserExistByMobilePhoneResponse existByMobilePhone(UserExistByMobileRequest request, Passport passport) {
        UserExistByMobilePhoneResponse response = new UserExistByMobilePhoneResponse();
        Long userId = sysUserMapper.existByMobile(request.getId(), request.getMobilePhone(), passport);
        response.setUserId(userId);
        if (userId != null && userId > 0) {
            response.setIsExist(true);
        } else {
            response.setIsExist(false);
        }
        return response;
    }


    @Override
    public LoginPasswordIsResetableResponse isResetablePassword(LoginPasswordIsResetableRequest req, Passport passport) {
        return null;
    }

    @Override
    public LoginPasswordModifyResponse modifyPassword(LoginPasswordModifyRequest request, Passport passport) {
        return null;
    }

    //    @Override
    public LoginPasswordResetResponse resetPassword(LoginPasswordResetRequest req, Passport passport) {
        Random rd = new Random();
        String n = ""; // 新密码
        int getNum;
        do {
            getNum = Math.abs(rd.nextInt())%10 + 48;
            char num1 = (char)getNum;
            String dn = Character.toString(num1);
            n += dn;
        }while (n.length() < 6);
        SysUserPasswordGetRequest sysUserPasswordGetRequest = new SysUserPasswordGetRequest();
        sysUserPasswordGetRequest.setId(req.getId());
        SysUserPasswordGetResponse sysUserPasswordGetResponse = sysUserPasswordManager.get(sysUserPasswordGetRequest, passport);
        SysUserPassword sysUserPassword = sysUserPasswordGetResponse.getSysUserPassword();
        if(n != null && !"".equals(n)){
            sysUserPassword.setLoginPassword(n);
        }
        n = DigestUtils.md5Hex(n);
        LoginPasswordModifyRequest loginPasswordModifyRequest = new LoginPasswordModifyRequest();
        loginPasswordModifyRequest.setId(sysUserPassword.getId());
        loginPasswordModifyRequest.setLoginPassword(n);
        loginPasswordModifyRequest.setRowVersion(sysUserPassword.getRowVersion());
        SysUserPasswordUpdateResponse sysUserPasswordUpdateResponse = sysUserPasswordManager.update(loginPasswordModifyRequest, passport);
        LoginPasswordResetResponse loginPasswordResetResponse = new LoginPasswordResetResponse();
        if (sysUserPasswordUpdateResponse.getResult() > 0){
            loginPasswordResetResponse.setNewPassword(n);
            loginPasswordResetResponse.setResult("success");
        }

        // 获取手机号
        SysUserPO entity = sysUserMapper.getById(req.getId(), passport);
        String mobilePhone = entity.getMobilePhone();
        loginPasswordResetResponse.setMobilePhone(mobilePhone);

        return loginPasswordResetResponse;
    }

    /**
     * 获取瘦咖详细信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalGetResponse getShowCalInfo(ShowcalGetRequest request, Passport passport) {
        ShowCalGetResponse response = new ShowCalGetResponse();
        if (!PassportTypeEnum.MEMBER.equals(passport.getType())) {
            response.addError(ErrorType.BUSINESS_ERROR, "您的身份不属于瘦咖用户!");
            return response;
        }
        ServiceUserPO serviceUserPO = serviceUserMapper.getUserShowcal(passport.getUserId());
        SysUserPO sysUserPo = sysUserMapper.getById(serviceUserPO.getServiceId(), passport);
        SysUserExtentPO sysUserExtentPO = sysUserExtentMapper.getById(serviceUserPO.getServiceId(), passport);
        ShowCalInfo showCalInfo = this.getMapper().map(sysUserPo, ShowCalInfo.class);
        if (sysUserExtentPO != null) {
            showCalInfo.setCountService(sysUserExtentPO.getCountService());
            showCalInfo.setResponseTime(sysUserExtentPO.getResponseTime());
            showCalInfo.setSuccessRate(sysUserExtentPO.getSuccessRate());
        }
        response.setShowCalInfo(showCalInfo);
        return null;
    }

    /**
     * 查询所有的瘦咖信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalQueryResponse queryShowCalInfo(ShowCalQueryRequest request, Passport passport) {
        ShowCalQueryResponse response = new ShowCalQueryResponse();
        Long count = sysUserMapper.queryShowCalInfoCount(request, passport);
        List<ShowCalInfo> showCalInfos = new ArrayList<>();
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            showCalInfos = sysUserMapper.queryShowCalInfo(request, passport);
            for (ShowCalInfo showCalInfo : showCalInfos) {
                if (showCalInfo.getAvatarId() != null) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(showCalInfo.getAvatarId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    showCalInfo.setAvatarurl(filePathGetResponse.getUrl());
                }
                if (showCalInfo.getCountService() == null) {
                    showCalInfo.setCountService(0);
                }
                //TODO 需要罗海峰协助。该逻辑如何实现
                //获取此瘦咖下的评论
                CommentPostFindRequest commentPostFindRequest = new CommentPostFindRequest();
                commentPostFindRequest.setThreadId(showCalInfo.getId());
                //commentPostFindRequest.setParentId(request.getId());
                commentPostFindRequest.setPageSize(0);
                CommentPostFindResponse commentPostFindResponse = platformService.findCommentPost(commentPostFindRequest, passport);
                double sum=0.0;
                for(CommentPost commentPost :commentPostFindResponse.getResult()){
                    sum+=commentPost.getGrade();
                }
                DecimalFormat df = new DecimalFormat("#.0");
                if(commentPostFindResponse.getTotalCount()==0){
                    showCalInfo.setEvaluate(0.0);
                }else {
                    showCalInfo.setEvaluate(Double.valueOf(df.format(sum / commentPostFindResponse.getTotalCount())));
                }

                //获取当前瘦咖的
                SelfIntroductionGetRequest selfIntroductionGetRequest = new SelfIntroductionGetRequest();
                selfIntroductionGetRequest.setUserId(showCalInfo.getId());
                SelfIntroductionGetResponse selfIntroductionGetResponse = articleManager.getSelfIntroduction(selfIntroductionGetRequest, passport);
                showCalInfo.setResume(selfIntroductionGetResponse.getContent());
            }
        }
        response.setTotalCount(count);
        response.setResult(showCalInfos);
        return response;
    }

    @Override
    public UserExistByOpenIdResponse existByOpenId(UserExistByOpenIdRequest request, Passport passport) {
        Long sysuserId = sysUserMapper.existByOpenId(request, passport);
        UserExistByOpenIdResponse response = new UserExistByOpenIdResponse();
        response.setIsExist(sysuserId != null && sysuserId > 0);
        return response;
    }

    @Override
    public LoginByOpenIdResponse loginByOpenId(LoginByOpenIdRequest request, Passport passport) {
        LoginByOpenIdResponse response = new LoginByOpenIdResponse();
        // 查询OpenId对应的用户是否存在
        UserExistByOpenIdRequest openIdRequest = new UserExistByOpenIdRequest();
        openIdRequest.setOpenId(request.getOpenId());
        openIdRequest.setType(request.getType());
        Long sysuserId = sysUserMapper.existByOpenId(openIdRequest, passport);
        // 存在颁发Passport
        if (sysuserId != null && sysuserId > 0) {
            response = publishPassport(sysuserId, "openId-login", response);
            //评论增加积分
            IntegralDetailCreateRequest integralDetailCreateRequest=new IntegralDetailCreateRequest();
            integralDetailCreateRequest.setType(IntegralRuleTypeEnum.LOGIN.name());
            integralDetailManager.create(integralDetailCreateRequest, passport);
        } else {
            response.addError(ErrorType.BUSINESS_ERROR, "对应的关联用户不存在");
        }
        return response;
    }

    /**
     * 密码验证成功后颁发护照
     *
     * @param response
     * @return
     */
    private LoginByOpenIdResponse publishPassport(Long userId, String loginIp, LoginByOpenIdResponse response) {
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
        return response;
    }

    private void checkValidate(SysUserPO sysUser, Passport passport, BaseResponse response) {
        if (sysUser.getMobilePhone() != null && sysUser.getMobilePhone().length() > 0) {
            Long userId = sysUserMapper.existByMobile(sysUser.getId(), sysUser.getMobilePhone(), passport);
            if (userId != null && userId > 0) {
                response.addError(ErrorType.UNIQUENESS_ERROR, "手机号码" + sysUser.getMobilePhone() + "已被使用");
            }
        }
    }


}
