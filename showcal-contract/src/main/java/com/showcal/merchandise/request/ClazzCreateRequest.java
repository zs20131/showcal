/**
 * @(#)ClazzCreateRequest.java
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
package com.showcal.merchandise.request;

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
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 * @author 顾志雄
 */
public class ClazzCreateRequest extends BaseRequest {

    /**
     * 父类ID 
     */

    private  Long   parentId;

    /**
     * 代码 
     */

    @Length(min=0, max=50, message = "代码长度不合法")
    private  String   code;

    /**
     * 名称 
     */

    @Length(min=0, max=50, message = "名称长度不合法")
    private  String   name;

    /**
     * 描述 
     */

    @Length(min=0, max=500, message = "描述长度不合法")
    private  String   description;

    /**
     * 排序索引 
     */

    private  Integer   orderIndex;



    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long  parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String  code) {
        this.code = code;
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

    public Integer getOrderIndex() {
        return this.orderIndex;
    }

    public void setOrderIndex(Integer  orderIndex) {
        this.orderIndex = orderIndex;
    }


}
