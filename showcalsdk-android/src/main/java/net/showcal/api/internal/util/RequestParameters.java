package net.showcal.api.internal.util;

import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api.utils
 *  Description:
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api.utils
 * </pre>
 */
public class RequestParameters {
    private String requestUrl;
    private String responseBody;

    private XiniuHashMap protocalMustParams;
    private XiniuHashMap protocalOptParams;
    private XiniuHashMap applicationParams;

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public XiniuHashMap getProtocalMustParams() {
        return this.protocalMustParams;
    }

    public void setProtocalMustParams(XiniuHashMap protocalMustParams) {
        this.protocalMustParams = protocalMustParams;
    }

    public XiniuHashMap getProtocalOptParams() {
        return this.protocalOptParams;
    }

    public void setProtocalOptParams(XiniuHashMap protocalOptParams) {
        this.protocalOptParams = protocalOptParams;
    }

    public XiniuHashMap getApplicationParams() {
        return this.applicationParams;
    }

    public void setApplicationParams(XiniuHashMap applicationParams) {
        this.applicationParams = applicationParams;
    }

    public Map<String, String> getAllParams() {
        Map<String, String> params = new HashMap<String, String>();
        if(protocalMustParams != null && !protocalMustParams.isEmpty()) {
            params.putAll(protocalMustParams);
        }
        if(protocalOptParams != null && !protocalOptParams.isEmpty()) {
            params.putAll(protocalOptParams);
        }
        if(applicationParams != null && !applicationParams.isEmpty()) {
            params.putAll(applicationParams);
        }
        return params;
    }
}
