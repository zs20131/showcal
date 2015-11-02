/**
 * @(#)SysUserGetResponse.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.platform.response;

import com.showcal.mobile.domain.UserInfo;
import com.showcal.platform.domain.SysUser;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
public class SysUserGetResponse extends BaseResponse {

    /**
     * 用户信息
     */
    private UserInfo sysUser;
    private Integer countService;

    public Integer getCountService() {
        return countService;
    }

    public void setCountService(Integer countService) {
        this.countService = countService;
    }

    public UserInfo getSysUser() {
        return this.sysUser;
    }

    public void setSysUser(UserInfo sysUser) {
        this.sysUser = sysUser;
    }
}
