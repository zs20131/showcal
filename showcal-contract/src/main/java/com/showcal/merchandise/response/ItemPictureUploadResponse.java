package com.showcal.merchandise.response;

import com.showcal.merchandise.domain.ItemPicture;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class ItemPictureUploadResponse extends BaseResponse {

    /**
     * 附件
     */
    private ItemPicture itemPicture;

    public ItemPicture getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(ItemPicture itemPicture) {
        this.itemPicture = itemPicture;
    }

}
