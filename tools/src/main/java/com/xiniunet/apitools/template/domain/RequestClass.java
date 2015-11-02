package com.xiniunet.apitools.template.domain;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.apitools.template.domain
 *  Description:
 * ***************************************************************
 *  11/26 0026  V1.0  xiniunet    New Files for com.xiniunet.apitools.template.domain
 * </pre>
 */
public class RequestClass extends ClassConfig{
    private String apiName;
    private ClassConfig response;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public ClassConfig getResponse() {
        return response;
    }

    public void setResponse(ClassConfig response) {
        this.response = response;
    }
}
