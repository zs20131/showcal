/**
 * @(#)ArticleStatistics.java 
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
package com.showcal.cms.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class ArticleStatistics extends  BaseDomain {

    
    /**
     * 主键 
     */
    private  Long   id;
    
    /**
     * 类型 
     */
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
    private  String   userName;
    
    /**
     * 设备ID 
     */
    private  String   deviceId;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
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