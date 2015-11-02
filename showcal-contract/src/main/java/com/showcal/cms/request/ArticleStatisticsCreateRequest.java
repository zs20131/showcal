/**
 * @(#)ArticleStatisticsCreateRequest.java
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
package com.showcal.cms.request;

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
 * Created by 顾志雄 on 2015-09-22 11:16:59.
 * @author 顾志雄
 */
public class ArticleStatisticsCreateRequest extends BaseRequest {
    
    /**
     * 类型 
     */
    
    @Length(min=0, max=50, message = "类型长度不合法")
    private  String   type;
    
    /**
     * 文章ID 
     */
    
    private  Long   articleId;
    
    /**
     * 用户ID 
     */
    
    private  Long   userId;
    
    /**
     * 用户姓名 
     */
    
    @Length(min=0, max=50, message = "用户姓名长度不合法")
    private  String   userName;
    
    /**
     * 设备ID 
     */
    
    @Length(min=0, max=50, message = "设备ID长度不合法")
    private  String   deviceId;
    

    
    public String getType() {
    return this.type;
    }

    public void setType(String  type) {
    this.type = type;
    }
    
    public Long getArticleId() {
    return this.articleId;
    }

    public void setArticleId(Long  articleId) {
    this.articleId = articleId;
    }
    
    public Long getUserId() {
    return this.userId;
    }

    public void setUserId(Long  userId) {
    this.userId = userId;
    }
    
    public String getUserName() {
    return this.userName;
    }

    public void setUserName(String  userName) {
    this.userName = userName;
    }
    
    public String getDeviceId() {
    return this.deviceId;
    }

    public void setDeviceId(String  deviceId) {
    this.deviceId = deviceId;
    }
    

}
