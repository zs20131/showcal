/**
 * @(#)ItemPictureImport.java
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
package com.showcal.merchandise.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:07.
 * @author 顾志雄
 */
public class ItemPictureImport extends  BaseDomain {


/**
 * 商品ID 
 */
private  Long   itemId;

/**
 * 图片ID 
 */
private  Long   pictureId;



public Long getItemId() {
return this.itemId;
}

public void setItemId(Long  itemId) {
this.itemId = itemId;
}

public Long getPictureId() {
return this.pictureId;
}

public void setPictureId(Long  pictureId) {
this.pictureId = pictureId;
}

}