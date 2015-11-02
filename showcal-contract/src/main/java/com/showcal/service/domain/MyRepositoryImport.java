/**
 * @(#)RepositoryImport.java
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
package com.showcal.service.domain;

import com.xiniunet.framework.base.BaseDomain;
import com.xiniunet.framework.util.excel.annotation.Name;
import com.xiniunet.framework.util.excel.annotation.Type;
import com.xiniunet.framework.util.excel.enumeration.DataType;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 * @author 顾志雄
 */
public class MyRepositoryImport extends  BaseDomain {

/**
 * 知识库标签 
 */
@Name("知识库标签")
@Type(DataType.STRING)
private  String   tag;

/**
 * 知识库关键字 
 */
@Name("知识库关键字")
@Type(DataType.STRING)
private  String   keyword;

    /**
     * 知识库问题,知识库的建议问题，显示用
     */
    @Name("知识库问题")
    @Type(DataType.STRING)
    private String question;

/**
 * 知识库内容 
 */
@Name("知识库内容")
@Type(DataType.STRING)
private  String   content;

public String getTag() {
return this.tag;
}

public void setTag(String  tag) {
this.tag = tag;
}

public String getKeyword() {
return this.keyword;
}

public void setKeyword(String  keyword) {
this.keyword = keyword;
}

public String getContent() {
return this.content;
}

public void setContent(String  content) {
this.content = content;
}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}