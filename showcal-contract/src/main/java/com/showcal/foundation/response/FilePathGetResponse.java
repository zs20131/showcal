package com.showcal.foundation.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
public class FilePathGetResponse extends BaseResponse {

    private String url;

    private String displayName;

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
