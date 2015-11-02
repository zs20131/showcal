package com.xiniunet.apitools.codeAnalysis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edward on 11/25/14.
 */
public class Method {

    private String name = "";
    private String description = "";
    private String requestName = "";
    private String responseName = "";
    private Boolean needPassport = false;
    private String contractName = "";
    private String declare = "";
    private String apiName = "";
    public String getDeclare() {
        return declare;
    }

    public void setDeclare(String declare) {
        this.declare = declare;
    }
    private List<String> requestImports = new ArrayList<String>();
    private List<String> responseImports = new ArrayList<String>();
    private List<Field> requestFields = new ArrayList<Field>();
    private List<Field> responseFields = new ArrayList<Field>();

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

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getResponseName() {
        return responseName;
    }

    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

    public Boolean getNeedPassport() {
        return needPassport;
    }

    public void setNeedPassport(Boolean needPassport) {
        this.needPassport = needPassport;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public List<Field> getRequestFields() {
        return requestFields;
    }

    public void setRequestFields(List<Field> requestFields) {
        this.requestFields = requestFields;
    }

    public List<Field> getResponseFields() {
        return responseFields;
    }

    public void setResponseFields(List<Field> responseFields) {
        this.responseFields = responseFields;
    }

    public String getApiName(){
        return this.apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }


    public List<String> getRequestImports() {
        return requestImports;
    }

    public void setRequestImports(List<String> requestImports) {
        this.requestImports = requestImports;
    }

    public List<String> getResponseImports() {
        return responseImports;
    }

    public void setResponseImports(List<String> responseImports) {
        this.responseImports = responseImports;
    }

    public void addRequestImport(String requestImport) {
        this.requestImports.add(requestImport);
    }

    public void addResponseImport(String responseImport) {
        this.responseImports.add(responseImport);
    }
    public void print() {

        if (this.getNeedPassport()) {
            System.out.println("方法名称:" + this.getName() + "             *需要sessionID");
        } else {
            System.out.println("方法名称:" + this.getName());
        }


        System.out.println("方法说明:" + this.getDescription());

        System.out.println("方法请求对象:" + this.getRequestName());
        System.out.println("具体字段列表:");
        for (Field f : this.getRequestFields()) {
            f.print();
        }

        System.out.println("方法响应对象:" + this.getResponseName());
        System.out.println("具体字段列表:");
        for (Field f : this.getResponseFields()) {
            f.print();
        }
        System.out.println("=============================================================");
    }
}
