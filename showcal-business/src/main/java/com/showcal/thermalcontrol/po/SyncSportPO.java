/**
 * @(#)SyncSportPO.java  
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
package com.showcal.thermalcontrol.po;

import com.xiniunet.framework.base.BasePO;
import java.util.Date;
/**
 * Created by 顾志雄 on 2015-09-15 13:47:00.
 * @author 顾志雄
 */
public class SyncSportPO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 执行的运动方案ID,
 */
private  Long   sportHeadId;

/**
 * 本次运动总时长,
 */
private  Integer   totalTime;

/**
 * 运动强度,高中低
 */
private  String   intensity;

/**
 * 运动地点,
 */
private  String   address;

/**
 * 是否同步完成,
 */
private  Boolean   isSynced;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public Long getSportHeadId() {
return this.sportHeadId;
}

public void setSportHeadId(Long  sportHeadId) {
this.sportHeadId = sportHeadId;
}

public Integer getTotalTime() {
return this.totalTime;
}

public void setTotalTime(Integer  totalTime) {
this.totalTime = totalTime;
}

public String getIntensity() {
return this.intensity;
}

public void setIntensity(String  intensity) {
this.intensity = intensity;
}

public String getAddress() {
return this.address;
}

public void setAddress(String  address) {
this.address = address;
}

public Boolean getIsSynced() {
return this.isSynced;
}

public void setIsSynced(Boolean  isSynced) {
this.isSynced = isSynced;
}

}