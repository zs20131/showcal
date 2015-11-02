/**
 * @(#)SysUserImport.java
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
package com.showcal.platform.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
public class SysUserImport extends  BaseDomain {


/**
 * 用户帐号 
 */
private  String   account;

/**
 * 用户名称 
 */
private  String   name;

/**
 * 拼音 
 */
private  String   pinyin;

/**
 * 拼音缩写 
 */
private  String   py;

/**
 * 昵称/别名 
 */
private  String   nickName;

/**
 * 移动电话 
 */
private  String   mobilePhone;

/**
 * 关联的QQ号码 
 */
private  String   qq;

/**
 * 关联的微信号 
 */
private  String   wechat;

/**
 * 性别 
 */
private  String   sex;

/**
 * 用户类型 
 */
private  String   userType;

/**
 * 头像ID 
 */
private  String   avatarId;

/**
 * 是否禁言 
 */
private  String   isBanned;

/**
 * 禁言时间 
 */
private  Date   bannedTime;



public String getAccount() {
return this.account;
}

public void setAccount(String  account) {
this.account = account;
}

public String getName() {
return this.name;
}

public void setName(String  name) {
this.name = name;
}

public String getPinyin() {
return this.pinyin;
}

public void setPinyin(String  pinyin) {
this.pinyin = pinyin;
}

public String getPy() {
return this.py;
}

public void setPy(String  py) {
this.py = py;
}

public String getNickName() {
return this.nickName;
}

public void setNickName(String  nickName) {
this.nickName = nickName;
}

public String getMobilePhone() {
return this.mobilePhone;
}

public void setMobilePhone(String  mobilePhone) {
this.mobilePhone = mobilePhone;
}

public String getQq() {
return this.qq;
}

public void setQq(String  qq) {
this.qq = qq;
}

public String getWechat() {
return this.wechat;
}

public void setWechat(String  wechat) {
this.wechat = wechat;
}

public String getSex() {
return this.sex;
}

public void setSex(String  sex) {
this.sex = sex;
}

public String getUserType() {
return this.userType;
}

public void setUserType(String  userType) {
this.userType = userType;
}

public String getAvatarId() {
return this.avatarId;
}

public void setAvatarId(String  avatarId) {
this.avatarId = avatarId;
}

public String getIsBanned() {
return this.isBanned;
}

public void setIsBanned(String  isBanned) {
this.isBanned = isBanned;
}

public Date getBannedTime() {
return this.bannedTime;
}

public void setBannedTime(Date  bannedTime) {
this.bannedTime = bannedTime;
}

}