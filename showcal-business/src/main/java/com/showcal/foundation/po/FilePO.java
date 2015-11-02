/**
 * @(#)FilePO.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.foundation.po;

import com.xiniunet.framework.base.BasePO;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 * @author 沈振家
 */
public class FilePO extends BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 承租人ID,
 */
private  Long   tenantId;

/**
 * 文件名称,
 */
private  String   name;

/**
 * 文件后缀,
 */
private  String   extension;

/**
 * 文件大小(字节）,
 */
private  Long   size;

/**
 * 存放路径,
 */
private  String   storagePath;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public Long getTenantId() {
return this.tenantId;
}

public void setTenantId(Long  tenantId) {
this.tenantId = tenantId;
}

public String getName() {
return this.name;
}

public void setName(String  name) {
this.name = name;
}

public String getExtension() {
return this.extension;
}

public void setExtension(String  extension) {
this.extension = extension;
}

public Long getSize() {
return this.size;
}

public void setSize(Long  size) {
this.size = size;
}

public String getStoragePath() {
return this.storagePath;
}

public void setStoragePath(String  storagePath) {
this.storagePath = storagePath;
}

}