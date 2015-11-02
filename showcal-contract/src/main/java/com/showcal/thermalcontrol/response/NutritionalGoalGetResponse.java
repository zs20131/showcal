/**
 * @(#)NutritionalGoalGetResponse.java
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
package com.showcal.thermalcontrol.response;

import com.showcal.thermalcontrol.domain.NutritionalGoal;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class NutritionalGoalGetResponse extends BaseResponse {

    /**
     * 营养目标信息
     */
    private NutritionalGoal nutritionalGoal;

    public NutritionalGoal getNutritionalGoal() {
        return this.nutritionalGoal;
    }

    public void setNutritionalGoal(NutritionalGoal nutritionalGoal) {
        this.nutritionalGoal = nutritionalGoal;
    }
}
