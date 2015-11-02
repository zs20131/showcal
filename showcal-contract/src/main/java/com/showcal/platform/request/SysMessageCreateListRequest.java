/**
 * @(#)SysMessageCreateRequest.java
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

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-30 15:41:58.
 * @author 顾志雄
 */
public class SysMessageCreateListRequest extends BaseRequest {
    private List<SysMessageCreateRequest> sysMessageCreateRequestList;

    public List<SysMessageCreateRequest> getSysMessageCreateRequestList() {
        return sysMessageCreateRequestList;
    }

    public void setSysMessageCreateRequestList(List<SysMessageCreateRequest> sysMessageCreateRequestList) {
        this.sysMessageCreateRequestList = sysMessageCreateRequestList;
    }
}
