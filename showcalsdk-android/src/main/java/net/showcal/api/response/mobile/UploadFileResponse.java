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
public class UploadFileResponse extends XiniuResponse {
    private static final long serialVersionUID = 1L;
    private String displayName;
    private Long id;
    private String url;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
