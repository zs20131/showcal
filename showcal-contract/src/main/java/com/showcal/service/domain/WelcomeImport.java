/**
 * @(#)WelcomeImport.java
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
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 * @author 顾志雄
 */
public class WelcomeImport extends  BaseDomain {


/**
 * 欢迎语内容 
 */
private  String   cometent;



public String getCometent() {
return this.cometent;
}

public void setCometent(String  cometent) {
this.cometent = cometent;
}

}