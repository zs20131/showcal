/**
 * @(#)ItemEcommerceGetResponse.java
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

import com.showcal.merchandise.domain.ItemEcommerce;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:06.
 * @author 顾志雄
 */
public class ItemEcommerceGetResponse extends BaseResponse {

    /**
     * 物料电商属性信息
     */
    private ItemEcommerce itemEcommerce;

    public ItemEcommerce getItemEcommerce() {
        return this.itemEcommerce;
    }

    public void setItemEcommerce(ItemEcommerce itemEcommerce) {
        this.itemEcommerce = itemEcommerce;
    }
}
