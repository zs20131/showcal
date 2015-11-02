/**
 * @(#)NutritionalGoalFindRequest.java
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
package com.showcal.thermalcontrol.request;

import com.xiniunet.framework.base.BaseFindRequest;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
public class NutritionalGoalFindRequest extends BaseFindRequest {
    /**
     * 餐次ID
     */
    private Long mealsId;

    /**
     * 目标类型
     */
    private String type;
    /**
     * 用户餐饮习惯
     */
    private String userHabit;

    /**
     * 用户就餐类型
     */
    private  String   repastType;

    public Long getMealsId() {
        return mealsId;
    }

    public void setMealsId(Long mealsId) {
        this.mealsId = mealsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserHabit() {
        return userHabit;
    }

    public void setUserHabit(String userHabit) {
        this.userHabit = userHabit;
    }

    public String getRepastType() {
        return repastType;
    }

    public void setRepastType(String repastType) {
        this.repastType = repastType;
    }
}
