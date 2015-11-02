package com.showcal.foundation.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV001 on 2014/8/14.
 */
public class FileUploadResponse extends BaseResponse {

    private Long id;

    private String url;

    private String displayName;

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
