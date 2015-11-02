package com.xiniunet.apitools.template.domain;

import com.xiniunet.apitools.codeAnalysis.Field;
import com.xiniunet.apitools.codeAnalysis.Method;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
public class ClassConfig {
    // 类名称
    private String name;
    // 类首字母小写名称
    private String lowerName;
    // 包名
    private String packageName;
    // 注释
    private AnnotationConfig annotation;
    // 服务名称
    private String serviceName;
    // 参数
    private List<Field> fields = new ArrayList<Field>();
    // 方法
    private List<Method> methods;
    private Boolean needPassport;
    private List<Field> responseFields = new ArrayList<Field>();
    private List<String> imports = new ArrayList<String>();
    private String extend ;//继承对象
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLowerName() {
        return lowerName;
    }

    public void setLowerName(String lowerName) {
        this.lowerName = lowerName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public AnnotationConfig getAnnotation() {
        return annotation;
    }

    public void setAnnotation(AnnotationConfig annotation) {
        this.annotation = annotation;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void addFields(Field field){
        this.fields.add(field);
    }
    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public String getPackagePath(){
        if(this.getPackageName()!=null){
            return this.getPackageName().replace(".", File.separator);
        }
        return "";
    }

    public Boolean getNeedPassport() {
        return needPassport;
    }

    public void setNeedPassport(Boolean needPassport) {
        this.needPassport = needPassport;
    }

    public List<Field> getResponseFields() {
        return responseFields;
    }

    public void setResponseFields(List<Field> responseFields) {
        this.responseFields = responseFields;
    }


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}
