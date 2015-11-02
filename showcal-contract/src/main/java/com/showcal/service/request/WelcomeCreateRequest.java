/**
 * @(#)WelcomeCreateRequest.java
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
package com.showcal.service.request;

import com.xiniunet.framework.base.BaseRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-30 18:20:47.
 * @author 顾志雄
 */
public class WelcomeCreateRequest extends BaseRequest {
    
    /**
     * 欢迎语内容 
     */
    
    @Length(min=1, max=2000, message = "欢迎语内容长度不合法")
    private  String   cometent;
    
    /**
     * 是否有效 
     */
    private  Boolean   isActive;
    
    /**
     * 生效日期 
     */
    private  Date   activeDate;
    

    
    public String getCometent() {
    return this.cometent;
    }

    public void setCometent(String  cometent) {
    this.cometent = cometent;
    }
    
    public Boolean getIsActive() {
    return this.isActive;
    }

    public void setIsActive(Boolean  isActive) {
    this.isActive = isActive;
    }
    
    public Date getActiveDate() {
    return this.activeDate;
    }

    public void setActiveDate(Date  activeDate) {
    this.activeDate = activeDate;
    }
    

}
