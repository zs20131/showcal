package com.com.apitools.ui.config;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.com.apitools.ui.config
 *  Description: 子模板
 * ***************************************************************
 *  9/2 0002  V1.0  xiniu    New Files for com.com.apitools.ui.config
 * </pre>
 */
public class SubTemplateElement {
    private String templateFile;
    private String targetPath;
    private String targetFileName;
    private String encoding;

    private Boolean isDomain;
    private boolean single;

    public SubTemplateElement(String templateFile, String targetPath, String targetFileName, String encoding, Boolean isDomain, boolean single) {
        this.templateFile = templateFile;
        this.targetPath = targetPath;
        this.targetFileName = targetFileName;
        this.encoding = encoding;
        this.isDomain = isDomain;
        this.single = single;
    }

    @Override
    public String toString() {
        return "templateFile :"+templateFile+" targetPath :"+targetPath+" targetFileName:"+targetFileName+" encoding:"+encoding;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    public String getTargetFileName() {
        return targetFileName;
    }

    public void setTargetFileName(String targetFileName) {
        this.targetFileName = targetFileName;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public Boolean getIsDomain() {
        return isDomain;
    }

    public void setIsDomain(Boolean isDomain) {
        this.isDomain = isDomain;
    }
}
