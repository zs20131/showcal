/**
 * @(#)CategoryUpdateRequest.java
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

import com.xiniunet.framework.base.BaseUpdateRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;


/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
public class CategoryUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 文章类别名称 
     */
    @NotBlank(message = "文章类别名称不能为空")
    @Length(min=0, max=100, message = "文章类别名称长度不合法")
    private  String   name;
    
    /**
     * 文章类别描述 
     */
    
    @Length(min=0, max=500, message = "文章类别描述长度不合法")
    private  String   description;
    
    /**
     * 是否需要审核 
     */
    @NotNull(message = "是否需要审核不能为空")
    private  Boolean   isNeedApprove;
    
    /**
     * 审核人ID 
     */
    
    private  Long   approveUserId;
    
    /**
     * 审核人员姓名 
     */
    
    @Length(min=0, max=50, message = "审核人员姓名长度不合法")
    private  String   approveUserName;
    
    /**
     * 排序索引 
     */
    @NotNull(message = "排序索引不能为空")
    private  Integer   orderIndex;
    
    /**
     * 父类别ID 
     */
    
    private  Long   parentId;
    

    
    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public String getName() {
    return this.name;
    }

    public void setName(String  name) {
    this.name = name;
    }
    
    public String getDescription() {
    return this.description;
    }

    public void setDescription(String  description) {
    this.description = description;
    }
    
    public Boolean getIsNeedApprove() {
    return this.isNeedApprove;
    }

    public void setIsNeedApprove(Boolean  isNeedApprove) {
    this.isNeedApprove = isNeedApprove;
    }
    
    public Long getApproveUserId() {
    return this.approveUserId;
    }

    public void setApproveUserId(Long  approveUserId) {
    this.approveUserId = approveUserId;
    }
    
    public String getApproveUserName() {
    return this.approveUserName;
    }

    public void setApproveUserName(String  approveUserName) {
    this.approveUserName = approveUserName;
    }
    
    public Integer getOrderIndex() {
    return this.orderIndex;
    }

    public void setOrderIndex(Integer  orderIndex) {
    this.orderIndex = orderIndex;
    }
    
    public Long getParentId() {
    return this.parentId;
    }

    public void setParentId(Long  parentId) {
    this.parentId = parentId;
    }
    

}
