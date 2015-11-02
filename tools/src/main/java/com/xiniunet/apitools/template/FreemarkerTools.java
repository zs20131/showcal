package com.xiniunet.apitools.template;

import com.xiniunet.apitools.template.domain.ClassConfig;
import com.xiniunet.apitools.template.domain.FileConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.apitools.template
 *  Description:
 * ***************************************************************
 *  11/26 0026  V1.0  xiniunet    New Files for com.xiniunet.apitools.template
 * </pre>
 */
public class FreemarkerTools {
    private static final Log logger = LogFactory.getLog(FreemarkerTools.class);
    public static void generateCode(FileConfig fileConfig,ClassConfig codeConfig){
        // 创建Freemarker配置实例
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new File(fileConfig.getTemplatepath()));
            // 创建数据模型
            Map<String, Object> root = new HashMap<String, Object>();
            // 获取模板
            Template template = configuration.getTemplate(fileConfig.getTemplateName());
            root.put("annotation",codeConfig.getAnnotation());
            root.put("class",codeConfig);
            root.put("fields",codeConfig.getFields());
            root.put("methods",codeConfig.getMethods());
            root.put("responseFields",codeConfig.getResponseFields());
            root.put("dochref",fileConfig.getDochref());
            root.put("serviceName",codeConfig.getServiceName());
            root.put("imports",codeConfig.getImports());
            // 生成目录文件夹
            String packagefilepath = fileConfig.getCodePath()+File.separator+codeConfig.getPackagePath();
            File filePath = new File(packagefilepath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
           File file = new File(packagefilepath+File.separator+codeConfig.getName()+"."+fileConfig.getFilesuffix());
            if (!file.exists()) {
                file.createNewFile();
            }
            // 显示生成的数据
            Writer writer = new FileWriter(file);
            template.process(root, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("");
    }

}
