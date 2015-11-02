/**
 * @(#)VerificationPO.java  
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

import com.showcal.platform.domain.VerificationTypeEnum;
import com.xiniunet.framework.base.BasePO;

import java.util.Date;

/**
 * Created by 沈振家 on 2014-07-30 16:10:31.
 *
 * @author 沈振家
 */
public class VerificationPO extends BasePO {


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
     * 验证类型,
     */
    private VerificationTypeEnum type;

    /**
     * 验证对象,
     */
    private String object;

    /**
     * 验证码,
     */
    private String code;

    /**
     * 生效日期,
     */
    private Date activeDate;

    /**
     * 失效日期,
     */
    private Date inactiveDate;


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

    public VerificationTypeEnum getType() {
        return type;
    }

    public void setType(VerificationTypeEnum type) {
        this.type = type;
    }

    public String getObject() {
        return this.object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getActiveDate() {
        return this.activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Date getInactiveDate() {
        return this.inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

}