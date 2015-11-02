package net.showcal.api.response.mobile;

import net.showcal.api.XiniuResponse;

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
public class ShowCalSelectedResponse extends XiniuResponse {
    private static final long serialVersionUID = 1L;
    /**
     * 更新记录数
     */
    private long result;

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }


}
