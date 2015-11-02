/**
 * @(#)ArticleBodyImport.java
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
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 * @author 顾志雄
 */
public class ArticleBodyImport extends  BaseDomain {


/**
 * 正文内容 
 */
private  String   content;



public String getContent() {
return this.content;
}

public void setContent(String  content) {
this.content = content;
}

}