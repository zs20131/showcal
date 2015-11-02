package com.showcal.service.request;

import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.base.BaseFindRequest;

import java.util.Date;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.request
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.service.request
 * </pre>
 */
public class ServiceUserGetListForMyRequest extends BaseFindRequest{
    /**
     * 用户名
     */
    private String userName;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 性别
     */
    private List<SexEnum> sexs;
    /**
     * 用户标签
     */
    private List<Long> userTags;

    /**
     * 用户帐号,
     */
    private String account;

    /**
     * 用户昵称,
     */
    private String nickName;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     *  起始年龄
     */
    private Integer fromAge;

    /**
     *  截止年龄
     */
    private Integer toAge;

    public Integer getFromAge() {
        return fromAge;
    }

    public void setFromAge(Integer fromAge) {
        this.fromAge = fromAge;
    }

    public Integer getToAge() {
        return toAge;
    }

    public void setToAge(Integer toAge) {
        this.toAge = toAge;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<SexEnum> getSexs() {
        return sexs;
    }

    public void setSexs(List<SexEnum> sexs) {
        this.sexs = sexs;
    }

    public List<Long> getUserTags() {
        return userTags;
    }

    public void setUserTags(List<Long> userTags) {
        this.userTags = userTags;
    }
}
