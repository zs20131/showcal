package com.com.apitools.ui.config;

import java.util.List;

/**
 * 模板数据
 */
public class TemplateElement {
    private String templateName;
    private String engine;
    private boolean selected;

    private List<SubTemplateElement> group;

    public TemplateElement(String templateName, String engine, boolean selected) {
        this.templateName = templateName;
        this.engine = engine;
        this.selected = selected;
    }

    public List<SubTemplateElement> getGroup() {
        return group;
    }

    public void setGroup(List<SubTemplateElement> group) {
        this.group = group;
    }

    public String getTemplateName() {
        return templateName;
    }


    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public String toString() {
        return templateName + " <" + engine + ">";
    }


    public boolean isSelected() {
        return selected;
    }


    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    public String getEngine() {
        return engine;
    }


    public void setEngine(String engine) {
        this.engine = engine;
    }


}
