/**
 * @(#)SysUserFindRequest.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.platform.request;

import com.showcal.platform.domain.SourceTypeEnum;
import com.showcal.platform.domain.UserStatusEnum;
import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.base.BaseFindRequest;

import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 *
 * @author 顾志雄
 */
public class SysUserFindRequest extends BaseFindRequest {
    /**
     * 用户ID号
     */
    private List<Long> ids;
    /**
     * 用户类型
     */
    private List<UserTypeEnum> usertypes;
    /**
     * 性别
     */
    private List<SexEnum> sexs;
    /**
     * 手机号码
     */
    private String mobilePhone;
    /**
     * 账号
     */
    private String account;
    /**
     * 用户标签
     */
    private List<Long> usertags;
    /**
     * 开始年龄
     */
    private Integer startAge;
    /**
     * 结束年龄
     */
    private Integer endAge;
    /**
     * 来源类型
     */
    private List<SourceTypeEnum> sourceTypes;
    /**
     * 用户状态
     */
    private List<UserStatusEnum> status;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * QQ号
     */
    private String qq;

    /**
     * 微信号s
     */
    private String wechat;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;
    /*
    *服务排序
     */
    private Boolean isCountService;

    /**
     * 响应时间排序
     */
    private Boolean isResponseTime;

    /**
     * 选择瘦咖去除已经选择的瘦咖
     */
private Long serviceId;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Boolean getIsCountService() {
        return isCountService;
    }

    public void setIsCountService(Boolean isCountService) {
        this.isCountService = isCountService;
    }

    public Boolean getIsResponseTime() {
        return isResponseTime;
    }

    public void setIsResponseTime(Boolean isResponseTime) {
        this.isResponseTime = isResponseTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public List<UserStatusEnum> getStatus() {
        return status;
    }

    public void setStatus(List<UserStatusEnum> status) {
        this.status = status;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getUsertags() {
        return usertags;
    }

    public void setUsertags(List<Long> usertags) {
        this.usertags = usertags;
    }

    public List<UserTypeEnum> getUsertypes() {
        return usertypes;
    }

    public void setUsertypes(List<UserTypeEnum> usertypes) {
        this.usertypes = usertypes;
    }

    public List<SexEnum> getSexs() {
        return sexs;
    }

    public void setSexs(List<SexEnum> sexs) {
        this.sexs = sexs;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }


    public List<SourceTypeEnum> getSourceTypes() {
        return sourceTypes;
    }

    public void setSourceTypes(List<SourceTypeEnum> sourceTypes) {
        this.sourceTypes = sourceTypes;
    }
}
