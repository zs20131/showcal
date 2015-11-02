/**
 * @(#)SysMessageFindRequest.java
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

import com.xiniunet.framework.base.BaseFindRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-30 15:41:58.
 * @author 顾志雄
 */
public class SysMessageFindRequest extends BaseFindRequest {
    /**
     * 当前登陆用户id
     */
    private Long userId;

    /**
     * 是否已读过
     */
    private Boolean isRead;

    /**
     * 类别
     */
    private List<String> type=new ArrayList<>(0);

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
