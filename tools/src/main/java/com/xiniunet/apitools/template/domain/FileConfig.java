package com.xiniunet.apitools.template.domain;

import java.io.File;

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
public class FileConfig {
    //模板路径
    private String templatepath;
    //模板名称
    private String templateName;

    //代码生成根目录
    private String codePath;
    //文档后缀名(默认Java)
    private String filesuffix = "java";

    private  String dochref = "";
    public String getTemplatepath() {
        return templatepath;
    }

    public void setTemplatepath(String templatepath) {
        this.templatepath = templatepath;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }


    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public String getFilesuffix() {
        return filesuffix;
    }

    public void setFilesuffix(String filesuffix) {
        this.filesuffix = filesuffix;
    }

    public String getDochref() {
        return dochref;
    }

    public void setDochref(String dochref) {
        this.dochref = dochref;
    }
}
