/**
 * @(#)SettingQuestionTagGetResponse.java
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

import com.showcal.platform.domain.SettingQuestionTag;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 * @author 顾志雄
 */
public class SettingQuestionTagGetResponse extends BaseResponse {

    /**
     * 问题标签信息
     */
    private SettingQuestionTag settingQuestionTag;

    public SettingQuestionTag getSettingQuestionTag() {
        return this.settingQuestionTag;
    }

    public void setSettingQuestionTag(SettingQuestionTag settingQuestionTag) {
        this.settingQuestionTag = settingQuestionTag;
    }
}
