/**
 * @(#)MessageImport.java
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
package com.showcal.service.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class MessageImport extends  BaseDomain {


/**
 * 消息类型 
 */
private  String   type;

/**
 * 消息内容类型 
 */
private  String   messageType;

/**
 * 消息内容 
 */
private  String   content;

/**
 * 问题/答案ＩＤ 
 */
private  String   serviceId;

/**
 * 创建人昵称 
 */
private  String   createUserName;



public String getType() {
return this.type;
}

public void setType(String  type) {
this.type = type;
}

public String getMessageType() {
return this.messageType;
}

public void setMessageType(String  messageType) {
this.messageType = messageType;
}

public String getContent() {
return this.content;
}

public void setContent(String  content) {
this.content = content;
}

public String getServiceId() {
return this.serviceId;
}

public void setServiceId(String  serviceId) {
this.serviceId = serviceId;
}

public String getCreateUserName() {
return this.createUserName;
}

public void setCreateUserName(String  createUserName) {
this.createUserName = createUserName;
}

}