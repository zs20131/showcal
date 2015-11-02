/**
 * @(#)SysUserPasswordPO.java  
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
package com.showcal.platform.po;

import com.xiniunet.framework.base.BasePO;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 * @author 顾志雄
 */
public class SysUserPasswordPO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 登录密码,
 */
private  String   loginPassword;

/**
 * 登录加密盐,
 */
private  String   loginSalt;

/**
 * 交易密码,
 */
private  String   transactionPassword;

/**
 * 交易加密盐,
 */
private  String   transactionSalt;

/**
 * 是否需要更改密码,
 */
private  Boolean   needChangeLogin;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public String getLoginPassword() {
return this.loginPassword;
}

public void setLoginPassword(String  loginPassword) {
this.loginPassword = loginPassword;
}

public String getLoginSalt() {
return this.loginSalt;
}

public void setLoginSalt(String  loginSalt) {
this.loginSalt = loginSalt;
}

public String getTransactionPassword() {
return this.transactionPassword;
}

public void setTransactionPassword(String  transactionPassword) {
this.transactionPassword = transactionPassword;
}

public String getTransactionSalt() {
return this.transactionSalt;
}

public void setTransactionSalt(String  transactionSalt) {
this.transactionSalt = transactionSalt;
}

public Boolean getNeedChangeLogin() {
return this.needChangeLogin;
}

public void setNeedChangeLogin(Boolean  needChangeLogin) {
this.needChangeLogin = needChangeLogin;
}

}