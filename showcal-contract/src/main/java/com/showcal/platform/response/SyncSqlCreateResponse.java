/**
 * @(#)SyncSqlCreateResponse.java
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
package com.showcal.platform.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-17 11:08:01.
 * @author 顾志雄
 */
public class SyncSqlCreateResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;
    /** 新创建的数据表同步ID */
    private Long id;

    public Long getId() {
    return id;
    }

    public void setId(Long id) {
    this.id = id;
    }
}
