/**
 * @(#)ServiceUserManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
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

import com.showcal.cms.svc.Message;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.ShowCalInfo;
import com.showcal.platform.dal.SettingUserTagMapper;
import com.showcal.platform.dal.SysUserExtentMapper;
import com.showcal.platform.dal.SysUserMapper;
import com.showcal.platform.dal.SysUserTagsMapper;
import com.showcal.platform.domain.SettingUserTag;
import com.showcal.platform.domain.UserDetail;
import com.showcal.platform.po.SettingUserTagPO;
import com.showcal.platform.po.SysUserExtentPO;
import com.showcal.platform.po.SysUserPO;
import com.showcal.platform.po.SysUserTagsPO;
import com.showcal.platform.request.SysUserTagsGetAllListByUserRequest;
import com.showcal.service.dal.ServiceUserMapper;
import com.showcal.service.po.ServiceUserPO;
import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ServiceServiceUserManager")
public class ServiceUserManagerImpl extends BaseManagerImpl implements ServiceUserManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private ServiceUserMapper serviceUserMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserExtentMapper sysUserExtentMapper;
    @Autowired
    private SysUserTagsMapper sysUserTagsMapper;
    @Autowired
    private SettingUserTagMapper settingUserTagMapper;

    /**
     * 创建用户服务表
     *
     * @param request  创建用户服务表请求
     * @param passport 用户护照
     * @return 创建用户服务表应答
     */
    @Override
    public ServiceUserCreateResponse create(ServiceUserCreateRequest request, Passport passport) {
        ServiceUserCreateResponse response = new ServiceUserCreateResponse();
        if (passport.getUserId().intValue() == request.getServiceId().intValue()) {
            response.addError(ErrorType.BUSINESS_ERROR, "不能选择自己为瘦咖");
            return response;
        }
        // 1 查询系统中是否存在我选择的瘦咖信息
        ServiceUserPO serviceUserPO = serviceUserMapper.existMySelectShowCal(request.getUserId(), request.getServiceId());
        if (serviceUserPO != null) {
            // 启用该服务用户表
            List<ServiceUserPO> serviceUserPOs = serviceUserMapper.findMyShowCal(request.getUserId());
            for (ServiceUserPO userPO : serviceUserPOs) {
                userPO.setIsActive(false);
                serviceUserMapper.update(userPO, passport);
            }
            serviceUserMapper.active(serviceUserPO.getId(), passport);
            return response;
        }
        List<ServiceUserPO> serviceUserPOs = serviceUserMapper.findMyShowCal(request.getUserId());
        for (ServiceUserPO userPO : serviceUserPOs) {
            userPO.setIsActive(false);
            serviceUserMapper.update(userPO, passport);
        }
        // 2 验证所选择的瘦咖是否存在
        SysUserPO sysUser = sysUserMapper.getById(request.getServiceId(), passport);
        if (sysUser == null) {
            response.addError(ErrorType.BUSINESS_ERROR, "所选择的瘦咖系统未找到");
            return response;
        }
        Long id = foundationService.getNewId();
        ServiceUserPO entity = this.getMapper().map(request, ServiceUserPO.class);
        entity.setId(id);
        entity.setIsActive(true);
        entity.setActiveDate(new Date());
    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);
        if (1 == serviceUserMapper.insert(entity, passport)) {
            response.setId(id);
            // 更新瘦咖历史服务人数
            sysUserExtentMapper.updateServiceCount(request.getServiceId(), passport);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 删除用户服务表
     *
     * @param request  删除用户服务表请求
     * @param passport 用户护照
     * @return 删除用户服务表应答
     */
    @Override
    public ServiceUserDeleteResponse delete(ServiceUserDeleteRequest request, Passport passport) {
        ServiceUserDeleteResponse response = new ServiceUserDeleteResponse();
        Long result = serviceUserMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 作废用户服务表
     *
     * @param request  作废用户服务表请求
     * @param passport 用户护照
     * @return 作废用户服务表应答
     */
    @Override
    public ServiceUserInactiveResponse inactive(ServiceUserInactiveRequest request, Passport passport) {
        ServiceUserInactiveResponse response = new ServiceUserInactiveResponse();
        Long result = serviceUserMapper.inactive(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 激活用户服务表
     *
     * @param request  激活用户服务表请求
     * @param passport 用户护照
     * @return 激活用户服务表应答
     */
    @Override
    public ServiceUserActiveResponse active(ServiceUserActiveRequest request, Passport passport) {
        ServiceUserActiveResponse response = new ServiceUserActiveResponse();
        Long result = serviceUserMapper.active(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    /**
     * 获取我当前服务的用户信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ServiceUserGetListForMyResponse getMyList(ServiceUserGetListForMyRequest request, Passport passport) {
        ServiceUserGetListForMyResponse response = new ServiceUserGetListForMyResponse();
        if (!PassportTypeEnum.SUPPLIER.equals(passport.getType())) {
            response.addError(ErrorType.BUSINESS_ERROR, "您的身份不是平台瘦咖!");
            return response;
        }
        Long count = serviceUserMapper.getShowcalServiceUsersCount(request, passport);
        List<UserDetail> userDetails = new ArrayList<>();
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<ServiceUserPO> serviceUserPOs = serviceUserMapper.getShowcalServiceUsers(request, passport);
            // 保存选我时间，服务状态
            Map<Long, ServiceUserPO> serviceUserPOMap = new HashMap<>();
            if (serviceUserPOs != null) {
                for (ServiceUserPO serviceUserPO : serviceUserPOs) {
                    serviceUserPOMap.put(serviceUserPO.getUserId(), serviceUserPO);
                }
            }
            if (serviceUserPOs != null && !serviceUserPOs.isEmpty()) {
                List<Long> userIds = new ArrayList<>();
                for (ServiceUserPO serviceUserPO : serviceUserPOs) {
                    userIds.add(serviceUserPO.getUserId());
                }
                List<SysUserPO> users = sysUserMapper.getListByIds(userIds, passport);
                List<SysUserExtentPO> userExtents = sysUserExtentMapper.getListByIds(userIds, passport);
                Map<Long, SysUserExtentPO> userExtentPOMap = new HashMap<>();
                if (userExtents != null) {
                    for (SysUserExtentPO sysUserExtent : userExtents) {
                        userExtentPOMap.put(sysUserExtent.getId(), sysUserExtent);
                    }
                }

                Date currentDate = new Date();
                int currentYear = currentDate.getYear();
                for (SysUserPO sysUserPO : users) {
                    UserDetail userDetail = this.getMapper().map(sysUserPO, UserDetail.class);
                    SysUserExtentPO sysUserExtentPO = userExtentPOMap.get(sysUserPO.getId());
                    ServiceUserPO serviceUserPO = serviceUserPOMap.get(sysUserPO.getId());
                    // 用户标签
                    SysUserTagsGetAllListByUserRequest sysUserTagsGetAllListByUserRequest = new SysUserTagsGetAllListByUserRequest();
                    sysUserTagsGetAllListByUserRequest.setUserId(sysUserPO.getId());
                    List<SysUserTagsPO> sysUserTagsPOs = sysUserTagsMapper.getAllListByUser(sysUserTagsGetAllListByUserRequest, passport);
                    if (sysUserTagsPOs != null) {
                        List<Long> sysUserTagIds = new ArrayList<>();
                        List<String> sysUserTagNames = new ArrayList<>();
                        List<String> sysUserTagRgbs = new ArrayList<>();
                        List<SettingUserTag> settingUserTagList = new ArrayList<>();
                        for (SysUserTagsPO sysUserTagsPO : sysUserTagsPOs) {
                            sysUserTagIds.add(sysUserTagsPO.getUserTagId());
                            SettingUserTagPO settingUserTagPO = settingUserTagMapper.getById(sysUserTagsPO.getUserTagId(), passport);
                            if (settingUserTagPO != null){
                                sysUserTagNames.add(settingUserTagPO.getTag());
                                sysUserTagRgbs.add(settingUserTagPO.getTagRgb());
                                settingUserTagList.add(this.getMapper().map(settingUserTagPO, SettingUserTag.class));
                            }
                        }
                        userDetail.setUserTagIds(sysUserTagIds);
                        userDetail.setUserTagNames(sysUserTagNames);
                        userDetail.setUserTagRgbs(sysUserTagRgbs);
                        userDetail.setSettingUserTagList(settingUserTagList);
                    }
                    if (sysUserExtentPO != null) {
                        userDetail.setHeight(sysUserExtentPO.getHeight());
                        userDetail.setBirthday(sysUserExtentPO.getBirthday());
                        if (sysUserExtentPO.getBirthday() != null) {
                            userDetail.setAge(currentYear - sysUserExtentPO.getBirthday().getYear());
                        }
                        userDetail.setWeight(sysUserExtentPO.getWeight());
                        userDetail.setWaistLine(sysUserExtentPO.getWaistLine());
                        userDetail.setHipline(sysUserExtentPO.getHipline());
                        userDetail.setBmi(sysUserExtentPO.getBmi());
                        if (serviceUserPO != null) {
                            userDetail.setServiceDate(serviceUserPO.getActiveDate());// 选我时间
                            userDetail.setServiceState(serviceUserPO.getIsActive());// 服务状态
                        }
                    }
                    if (userDetail.getAge() != null) {
                        if (request.getFromAge() != null && request.getToAge() != null) { // 起始，截止年龄都有
                            if (userDetail.getAge().intValue() >= request.getFromAge().intValue() && userDetail.getAge().intValue() <= request.getToAge().intValue()) {
                                userDetails.add(userDetail);
                            } else {
                                count--;
                            }
                        } else if (request.getFromAge() != null && request.getToAge() == null) { // 起始年龄有，截止年龄没有
                            if (userDetail.getAge().intValue() >= request.getFromAge().intValue()) {
                                userDetails.add(userDetail);
                            } else {
                                count--;
                            }
                        } else if (request.getFromAge() == null && request.getToAge() != null) { // 起始年龄没有，截止年龄有
                            if (userDetail.getAge().intValue() <= request.getToAge().intValue()) {
                                userDetails.add(userDetail);
                            } else {
                                count--;
                            }
                        } else { // 起始，截止年龄都没有
                            userDetails.add(userDetail);
                        }
                    } else {
                        if (request.getFromAge() == null && request.getToAge() == null){
                            userDetails.add(userDetail);
                        }else{
                            count--;
                        }
                    }

                }
            }
        }
        response.setResult(userDetails);
        response.setTotalCount(count);
        return response;
    }

    /**
     * 获取我历史服务的用户信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ServiceHistoryUserGetResponse getMyHistoryList(ServiceHistoryUserGetRequest request, Passport passport) {
        ServiceHistoryUserGetResponse response = new ServiceHistoryUserGetResponse();
        if (!PassportTypeEnum.SUPPLIER.equals(passport.getType())) {
            response.addError(ErrorType.BUSINESS_ERROR, "您的身份不属于瘦咖用户!");
            return response;
        }
        Long count = serviceUserMapper.getshowcalHistoryServiceCount(request, passport);
        List<UserDetail> userDetails = new ArrayList<>();
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<ServiceUserPO> serviceUserPOs = serviceUserMapper.getshowcalHistoryService(request, passport);
            // 保存选我时间，服务状态
            Map<Long, ServiceUserPO> serviceUserPOMap = new HashMap<>();
            if (serviceUserPOs != null) {
                for (ServiceUserPO serviceUserPO : serviceUserPOs) {
                    serviceUserPOMap.put(serviceUserPO.getUserId(), serviceUserPO);
                }
            }
            if (serviceUserPOs != null && !serviceUserPOs.isEmpty()) {
                List<Long> userIds = new ArrayList<>();
                for (ServiceUserPO serviceUserPO : serviceUserPOs) {
                    userIds.add(serviceUserPO.getUserId());
                }
                List<SysUserPO> users = sysUserMapper.getListByIds(userIds, passport);
                List<SysUserExtentPO> userExtents = sysUserExtentMapper.getListByIds(userIds, passport);
                Map<Long, SysUserExtentPO> userExtentPOMap = new HashMap<>();
                if (userExtents != null) {
                    for (SysUserExtentPO sysUserExtent : userExtents) {
                        userExtentPOMap.put(sysUserExtent.getId(), sysUserExtent);
                    }
                }
                Date currentDate = new Date();
                int currentYear = currentDate.getYear();
                for (SysUserPO sysUserPO : users) {
                    UserDetail userDetail = this.getMapper().map(sysUserPO, UserDetail.class);
                    SysUserExtentPO sysUserExtentPO = userExtentPOMap.get(sysUserPO.getId());
                    ServiceUserPO serviceUserPO = serviceUserPOMap.get(sysUserPO.getId());
                    // 用户标签
                    SysUserTagsGetAllListByUserRequest sysUserTagsGetAllListByUserRequest = new SysUserTagsGetAllListByUserRequest();
                    sysUserTagsGetAllListByUserRequest.setUserId(sysUserPO.getId());
                    List<SysUserTagsPO> sysUserTagsPOs = sysUserTagsMapper.getAllListByUser(sysUserTagsGetAllListByUserRequest, passport);
                    if (sysUserTagsPOs != null) {
                        List<Long> sysUserTagIds = new ArrayList<>();
                        List<String> sysUserTagNames = new ArrayList<>();
                        List<SettingUserTag> settingUserTagList = new ArrayList<>();
                        for (SysUserTagsPO sysUserTagsPO : sysUserTagsPOs) {
                            sysUserTagIds.add(sysUserTagsPO.getUserTagId());
                            SettingUserTagPO settingUserTagPO = settingUserTagMapper.getById(sysUserTagsPO.getUserTagId(), passport);
                            if (settingUserTagPO != null){
                                sysUserTagNames.add(settingUserTagPO.getTag());
                                settingUserTagList.add(this.getMapper().map(settingUserTagPO, SettingUserTag.class));
                            }
                        }
                        userDetail.setUserTagIds(sysUserTagIds);
                        userDetail.setUserTagNames(sysUserTagNames);
                        userDetail.setSettingUserTagList(settingUserTagList);
                    }
                    if (sysUserExtentPO != null) {
                        userDetail.setHeight(sysUserExtentPO.getHeight());
                        userDetail.setBirthday(sysUserExtentPO.getBirthday());
                        if (sysUserExtentPO.getBirthday() != null) {
                            userDetail.setAge(currentYear - sysUserExtentPO.getBirthday().getYear());
                        }
                        userDetail.setWeight(sysUserExtentPO.getWeight());
                        userDetail.setWaistLine(sysUserExtentPO.getWaistLine());
                        userDetail.setHipline(sysUserExtentPO.getHipline());
                        userDetail.setBmi(sysUserExtentPO.getBmi());
                        if (serviceUserPO != null) {
                            userDetail.setServiceDate(serviceUserPO.getActiveDate());// 选我时间
                            userDetail.setServiceState(serviceUserPO.getIsActive());// 服务状态
                        }
                    }
                    if (userDetail.getAge() != null) {
                        if (request.getFromAge() != null && request.getToAge() != null) { // 起始，截止年龄都有
                            if (userDetail.getAge().intValue() >= request.getFromAge().intValue() && userDetail.getAge().intValue() <= request.getToAge().intValue()) {
                                userDetails.add(userDetail);
                            } else {
                                count--;
                            }
                        } else if (request.getFromAge() != null && request.getToAge() == null) { // 起始年龄有，截止年龄没有
                            if (userDetail.getAge().intValue() >= request.getFromAge().intValue()) {
                                userDetails.add(userDetail);
                            } else {
                                count--;
                            }
                        } else if (request.getFromAge() == null && request.getToAge() != null) { // 起始年龄没有，截止年龄有
                            if (userDetail.getAge().intValue() <= request.getToAge().intValue()) {
                                userDetails.add(userDetail);
                            } else {
                                count--;
                            }
                        } else { // 起始，截止年龄都没有
                            userDetails.add(userDetail);
                        }
                    } else {
                        if (request.getFromAge() == null && request.getToAge() == null){
                            userDetails.add(userDetail);
                        }else{
                            count--;
                        }
                    }

                }
            }
        }
        response.setResult(userDetails);
        response.setTotalCount(count);
        return response;
    }

    /**
     * 获取当前服务我的瘦咖信息
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ShowCalGetForMyResponse getMyShowCal(ShowCalGetForMyRequest request, Passport passport) {
        ShowCalGetForMyResponse response = new ShowCalGetForMyResponse();
//        if (!PassportTypeEnum.MEMBER.equals(passport.getType())) {
//            response.addError(ErrorType.BUSINESS_ERROR, "您的身份不属于普通用户!");
//            return response;
//        }
        ServiceUserPO serviceUserPO = serviceUserMapper.getUserShowcal(passport.getUserId());
        if (serviceUserPO != null) {
            SysUserPO sysUserPo = sysUserMapper.getById(serviceUserPO.getServiceId(), passport);
            ShowCalInfo showCalInfo = new ShowCalInfo();
            if(sysUserPo!=null){
                SysUserExtentPO sysUserExtentPO = sysUserExtentMapper.getById(serviceUserPO.getServiceId(), passport);
                showCalInfo = this.getMapper().map(sysUserPo, ShowCalInfo.class);
                if (sysUserExtentPO != null) {
                    showCalInfo.setCountService(sysUserExtentPO.getCountService());
                    showCalInfo.setResponseTime(sysUserExtentPO.getResponseTime());
                    showCalInfo.setSuccessRate(sysUserExtentPO.getSuccessRate());
                }
            }
            response.setShowCalInfo(showCalInfo);
        }
        return response;
    }

    /**
     * 获取瘦咖ID 内部方法
     *
     * @param userId
     * @return
     */
    public Long getMyShowCalId(Long userId) {
        ServiceUserPO serviceUserPO = serviceUserMapper.getUserShowcal(userId);
        if(serviceUserPO!=null){
            return serviceUserPO.getServiceId();
        }else{
            return 0L;
        }

    }

    @Override
    public ShowCalHistoryGetResponse getMyHistoryShowCal(ShowCalHistoryGetRequest request, Passport passport) {
        ShowCalHistoryGetResponse response = new ShowCalHistoryGetResponse();
        if (!PassportTypeEnum.MEMBER.equals(passport.getType())) {
            response.addError(ErrorType.BUSINESS_ERROR, "您的身份不属于瘦咖用户!");
            return response;
        }
        List<ServiceUserPO> serviceUserPOs = serviceUserMapper.getHistoryShowcal(request, passport);
        List<ShowCalInfo> showCalInfos = new ArrayList<>();
        if (serviceUserPOs != null && !serviceUserPOs.isEmpty()) {
            List<Long> userIds = new ArrayList<>();
            for (ServiceUserPO serviceUserPO : serviceUserPOs) {
                userIds.add(serviceUserPO.getUserId());
            }
            List<SysUserPO> users = sysUserMapper.getListByIds(userIds, passport);
            List<SysUserExtentPO> userExtents = sysUserExtentMapper.getListByIds(userIds, passport);
            Map<Long, SysUserExtentPO> userExtentPOMap = new HashMap<>();
            Date currentDate = new Date();
            int currentYear = currentDate.getYear();
            for (SysUserPO sysUserPO : users) {
                ShowCalInfo showCalInfo = this.getMapper().map(sysUserPO, ShowCalInfo.class);
                SysUserExtentPO sysUserExtentPO = userExtentPOMap.get(sysUserPO.getId());
                if (sysUserExtentPO != null) {
                    showCalInfo.setCountService(sysUserExtentPO.getCountService());
                    showCalInfo.setResponseTime(sysUserExtentPO.getResponseTime());
                    showCalInfo.setSuccessRate(sysUserExtentPO.getSuccessRate());
                }
                showCalInfos.add(showCalInfo);
            }
        }
        response.setResult(showCalInfos);
        response.setTotalCount(showCalInfos.size());
        return response;
    }

    /**
     * 验证对象
     *
     * @param serviceUser 用户服务表
     * @param passport    用户护照
     */
    private void checkValidate(ServiceUserPO serviceUser, Passport passport, BaseResponse response) {
        // TODO

    }


}
