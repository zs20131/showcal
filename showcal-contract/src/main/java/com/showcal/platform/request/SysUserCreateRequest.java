/**
 * @(#)SysUserCreateRequest.java
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
package com.showcal.platform.request;

import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 *
 * @author 顾志雄
 */
public class SysUserCreateRequest extends BaseRequest {

    /**
     * 用户帐号
     */

    @Length(min = 0, max = 50, message = "用户帐号长度不合法")
    private String account;

    /**
     * 用户名称
     */

    @Length(min = 0, max = 50, message = "用户名称长度不合法")
    private String name;

    /**
     * 拼音
     */

    @Length(min = 0, max = 50, message = "拼音长度不合法")
    private String pinyin;

    /**
     * 拼音缩写
     */

    @Length(min = 0, max = 50, message = "拼音缩写长度不合法")
    private String py;

    /**
     * 昵称/别名
     */

    @Length(min = 0, max = 50, message = "昵称/别名长度不合法")
    private String nickName;

    /**
     * 移动电话
     */

    @Length(min = 0, max = 50, message = "移动电话长度不合法")
    private String mobilePhone;

    /**
     * 关联的QQ号码
     */

    @Length(min = 0, max = 100, message = "关联的QQ号码长度不合法")
    private String qq;

    /**
     * 关联的微信号
     */

    @Length(min = 0, max = 100, message = "关联的微信号长度不合法")
    private String wechat;

    /**
     * 性别
     */

    private SexEnum sex;

    /**
     * 用户类型
     */
    @NotNull(message = "用户类型不能为空，请检查!")
    private UserTypeEnum userType;

    /**
     * 头像ID
     */

    @Length(min = 0, max = 50, message = "头像ID长度不合法")
    private String avatarId;

    /**
     * 是否禁言
     */

    @Length(min = 0, max = 50, message = "是否禁言长度不合法")
    private String isBanned;

    /**
     * 禁言时间
     */

    private Date bannedTime;

    /**
     * 用户密码
     */
    @NotBlank(message = "密码不能为空,请输入")
    private String password;

    /**
     * 身高（厘米）
     */

    private Integer height;

    /**
     * 出生年月
     */

    private Date birthday;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPy() {
        return this.py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getQq() {
        return this.qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return this.wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public UserTypeEnum getUserType() {
        return this.userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public String getAvatarId() {
        return this.avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public String getIsBanned() {
        return this.isBanned;
    }

    public void setIsBanned(String isBanned) {
        this.isBanned = isBanned;
    }

    public Date getBannedTime() {
        return this.bannedTime;
    }

    public void setBannedTime(Date bannedTime) {
        this.bannedTime = bannedTime;
    }


}
