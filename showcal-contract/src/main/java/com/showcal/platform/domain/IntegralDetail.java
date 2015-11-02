/**
 * @(#)IntegralDetail.java 
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
package com.showcal.platform.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-17 11:07:59.
 * @author 顾志雄
 */
public class IntegralDetail extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 用户ID 
     */
    private  Long   userId;
    
    /**
     * 积分状态(增加或者消费积分) 1，增加积分,0消费积分
     */
    private  Integer   status;
    
    /**
     * 积分时间 
     */
    private  Date   integralTime;
    
    /**
     * 积分内容 
     */
    private  String   content;
    
    /**
     * 积分规则ID 
     */
    private  Long   ruleId;
    
    /**
     * 当次积分值 
     */
    private  Integer   value;
    
    /**
     * 备注 
     */
    private  String   remark;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public Long getUserId() {
    return this.userId;
    }

    public void setUserId(Long  userId) {
    this.userId = userId;
    }
    
    public Integer getStatus() {
    return this.status;
    }

    public void setStatus(Integer  status) {
    this.status = status;
    }
    
    public Date getIntegralTime() {
    return this.integralTime;
    }

    public void setIntegralTime(Date  integralTime) {
    this.integralTime = integralTime;
    }
    
    public String getContent() {
    return this.content;
    }

    public void setContent(String  content) {
    this.content = content;
    }
    
    public Long getRuleId() {
    return this.ruleId;
    }

    public void setRuleId(Long  ruleId) {
    this.ruleId = ruleId;
    }
    
    public Integer getValue() {
    return this.value;
    }

    public void setValue(Integer  value) {
    this.value = value;
    }
    
    public String getRemark() {
    return this.remark;
    }

    public void setRemark(String  remark) {
    this.remark = remark;
    }
    
}