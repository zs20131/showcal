/**
 * @(#)ServiceUserPO.java  
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
package com.showcal.service.po;

import com.xiniunet.framework.base.BasePO;
import java.util.Date;
/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 * @author 顾志雄
 */
public class ServiceUserPO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 用户ID,
 */
private  Long   userId;

/**
 * 服务者(瘦咖)ID,
 */
private  Long   serviceId;

/**
 * 是否有效,
 */
private  Boolean   isActive;

/**
 * 生效日期,
 */
private  Date   activeDate;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public Long getUserId() {
return this.userId;
}

public void setUserId(Long  userId) {
this.userId = userId;
}

public Long getServiceId() {
return this.serviceId;
}

public void setServiceId(Long  serviceId) {
this.serviceId = serviceId;
}

public Boolean getIsActive() {
return this.isActive;
}

public void setIsActive(Boolean  isActive) {
this.isActive = isActive;
}

public Date getActiveDate() {
return this.activeDate;
}

public void setActiveDate(Date  activeDate) {
this.activeDate = activeDate;
}

}