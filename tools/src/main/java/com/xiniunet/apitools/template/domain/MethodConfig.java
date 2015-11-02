package com.xiniunet.apitools.template.domain;

import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.apitools.template.domain
 *  Description:方法配置
 * ***************************************************************
 *  11/26 0026  V1.0  xiniunet    New Files for com.xiniunet.apitools.template.domain
 * </pre>
 */
public class MethodConfig {
    //方法名称
    private String name = "";
    //方式注释
    private String description = "";
    //参数名称
    private List<ClassConfig> parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ClassConfig> getParameters() {
        return parameters;
    }

    public void setParameters(List<ClassConfig> parameters) {
        this.parameters = parameters;
    }
}
