/**
 * @(#)WelcomeDeleteResponse.java
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
package com.showcal.service.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-30 18:20:47.
 * @author 顾志雄
 */
public class WelcomeDeleteResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;
    /** 作废的欢迎语数目 */
    private Long result;

    public Long getResult() {
    return this.result;
    }

    public void setResult(Long result) {
    this.result = result;
    }
}
