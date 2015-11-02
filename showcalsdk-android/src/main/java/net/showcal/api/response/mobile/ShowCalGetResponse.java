package net.showcal.api.response.mobile;

import net.showcal.api.XiniuResponse;
import net.showcal.api.domain.mobile.ShowCalInfo;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.helper.MobileHelperImpl
 *  Description: mobile Response
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public class ShowCalGetResponse extends XiniuResponse {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private ShowCalInfo showCalInfo;

    public ShowCalInfo getShowCalInfo() {
        return showCalInfo;
    }

    public void setShowCalInfo(ShowCalInfo showCalInfo) {
        this.showCalInfo = showCalInfo;
    }


}
