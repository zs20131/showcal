/**
 * @(#)PassportPO.java  
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.platform.po;

import com.xiniunet.framework.base.BasePO;

import java.util.Date;

/**
 * Created by 沈振家 on 2014-07-30 16:47:07.
 *
 * @author 沈振家
 */
public class PassportPO extends BasePO {


    /**
     * 主键,
     */
    private Long id;

    /**
     * 承租人ID,
     */
    private Long tenantId;

    /**
     * 用户ID,
     */
    private Long userId;

    /**
     * 领用日期,
     */
    private Date issueTime;

    /**
     * 过期时间,
     */
    private Date expireTime;

    /**
     * 注销时间,
     */
    private Date revokeTime;

    /**
     * 注销类型,
     */
    private String revokeType;

    /**
     * 领用IP,
     */
    private String issueIp;

    /**
     * 领用设备,
     */
    private Long issueClient;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getIssueTime() {
        return this.issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getRevokeTime() {
        return this.revokeTime;
    }

    public void setRevokeTime(Date revokeTime) {
        this.revokeTime = revokeTime;
    }

    public String getRevokeType() {
        return this.revokeType;
    }

    public void setRevokeType(String revokeType) {
        this.revokeType = revokeType;
    }

    public String getIssueIp() {
        return this.issueIp;
    }

    public void setIssueIp(String issueIp) {
        this.issueIp = issueIp;
    }

    public Long getIssueClient() {
        return this.issueClient;
    }

    public void setIssueClient(Long issueClient) {
        this.issueClient = issueClient;
    }

}