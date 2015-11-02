/**
 * @(#)SysUserCurveGetAllListRequest.java
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

import com.showcal.platform.domain.CurveTypeEnum;
import com.xiniunet.framework.base.BaseFindRequest;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
public class SysUserCurveGetMonthListByUserRequest extends BaseFindRequest {
    /**
     * 用户Id
     */
    @NotNull(message = "用户Id不能为空，请检查")
    private Long userId;
    /**
     * 身体变化类型
     */
    @NotNull(message = "曲线变化类型不能为空")
    private CurveTypeEnum type;

    /**
     * 发布开始日期
     */
    private Date startDate;

    /**
     * 发布截止日期
     */
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CurveTypeEnum getType() {
        return type;
    }

    public void setType(CurveTypeEnum type) {
        this.type = type;
    }
}
