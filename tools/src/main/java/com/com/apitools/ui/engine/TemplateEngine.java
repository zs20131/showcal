package com.com.apitools.ui.engine;

import com.com.apitools.ui.config.SubTemplateElement;
import com.com.apitools.ui.config.TemplateElement;

import java.util.Map;



public interface TemplateEngine {

    public String processToString(Map<String, Object> model, String stringTemplate) throws TemplateEngineException;

    public void processToFile(Map<String, Object> model, SubTemplateElement templateElement) throws TemplateEngineException;
}
