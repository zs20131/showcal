/**
 * @(#)CategoryFindRequest.java
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

import com.xiniunet.framework.base.BaseFindRequest;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class CategoryFindRequest extends BaseFindRequest {

    /**
     * 文章类别名称,
     */
    private  String   name;

    /**
     * 文章类别描述,
     */
    private  String   description;

    /**
     * 是否需要审核,
     */
    private  Boolean   isNeedApprove;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
    return this.name;
    }

    public void setName(String name) {
    this.name = name;
    }
    
    
    
    public String getDescription() {
    return this.description;
    }

    public void setDescription(String description) {
    this.description = description;
    }
    
    
    
    public Boolean getIsNeedApprove() {
    return this.isNeedApprove;
    }

    public void setIsNeedApprove(Boolean isNeedApprove) {
    this.isNeedApprove = isNeedApprove;
    }
    
    
    
    
    
    
    
    
    
    
}
