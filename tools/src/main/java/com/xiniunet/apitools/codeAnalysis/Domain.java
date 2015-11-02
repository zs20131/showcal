package com.xiniunet.apitools.codeAnalysis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edward on 11/25/14.
 */
public class Domain {
    private String name;
    private String description;
    private String contractName;
    private String extend;
    private List<String> imports = new ArrayList<String>();
    private List<Field> fields = new ArrayList<Field>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description==null?"暂无":description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void print() {
        System.out.println("领域模型名称:" + this.getName());
        System.out.println("领域模型说明:" + this.getDescription());
        System.out.println("具体字段列表:");
        for (Field f : this.getFields()) {
            f.print();
        }
        System.out.println("=============================================================");
    }
}
