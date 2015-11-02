/**
 * @(#)ArticleBodyCreateRequest.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 * @author 顾志雄
 */
public class ArticleBodyCreateRequest extends BaseRequest {
    @NotNull(message = "正文Id 不能为空，请检查")
    private Long id;
    /**
     * 正文内容 
     */
    @NotNull(message = "正文内容不能为空")
    private  String   content;
    

    
    public String getContent() {
    return this.content;
    }

    public void setContent(String  content) {
    this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
