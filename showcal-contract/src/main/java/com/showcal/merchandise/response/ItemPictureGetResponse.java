/**
 * @(#)ItemPictureGetResponse.java
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
package com.showcal.merchandise.response;

import com.showcal.merchandise.domain.ItemPicture;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:07.
 * @author 顾志雄
 */
public class ItemPictureGetResponse extends BaseResponse {

    /**
     * 物料图片表信息
     */
    private ItemPicture itemPicture;

    public ItemPicture getItemPicture() {
        return this.itemPicture;
    }

    public void setItemPicture(ItemPicture itemPicture) {
        this.itemPicture = itemPicture;
    }
}
