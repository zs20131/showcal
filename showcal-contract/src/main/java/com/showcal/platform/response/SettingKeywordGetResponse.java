/**
 * @(#)SettingKeywordGetResponse.java
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

import com.showcal.platform.domain.SettingKeyword;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:50.
 * @author 顾志雄
 */
public class SettingKeywordGetResponse extends BaseResponse {

    /**
     * 关键字信息
     */
    private SettingKeyword settingKeyword;

    public SettingKeyword getSettingKeyword() {
        return this.settingKeyword;
    }

    public void setSettingKeyword(SettingKeyword settingKeyword) {
        this.settingKeyword = settingKeyword;
    }
}
