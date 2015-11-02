package com.xiniunet.apitools.template.domain;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.apitools.template.domain
 *  Description:注释配置
 * ***************************************************************
 *  11/26 0026  V1.0  xiniunet    New Files for com.xiniunet.apitools.template.domain
 * </pre>
 */
public class AnnotationConfig {
    //作者
    private String authorName;
    //公司
    private String company;
    //日期
    private String date;
    //版本
    private String version;
    //注释
    private String Description;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
