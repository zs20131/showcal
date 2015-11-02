/**
 * @(#)ComplatintGetResponse.java
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

import com.showcal.service.domain.Complatint;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class ComplatintGetResponse extends BaseResponse {

    /**
     * 用户投诉信息
     */
    private Complatint complatint;

    public Complatint getComplatint() {
        return this.complatint;
    }

    public void setComplatint(Complatint complatint) {
        this.complatint = complatint;
    }
}
