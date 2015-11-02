package net.showcal.mobile.domain;

import com.showcal.platform.domain.UserTypeEnum;

import java.io.Serializable;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.domain
 *  Description:
 * ***************************************************************
 *  9/29 0029  V1.0  xiniu    New Files for net.showcal.mobile.domain
 * </pre>
 */
public class RegisterBean implements Serializable{
    /**
     * 会员类型
     */
    private UserTypeEnum type;

    /**
     * 公司／个人名称
     */
    private  String   name;

    /**
     * 用户帐号
     * 默认为注册的手机号
     */
    private  String   account;

    /**
     * 联系人
     */
    private  String   contactName;

    /**
     * 联系电话
     */
    private  String   contactPhone;

    /**
     * 手机
     */
    private  String   mobilePhone;

    /**
     * 地址
     */
    private  String   address;

    /**
     * 密码
     */
    private String password;

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
