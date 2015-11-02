package com.xiniunet.apitools.codeAnalysis;


import com.xiniunet.apitools.template.FreemarkerTools;
import com.xiniunet.apitools.template.domain.AnnotationConfig;
import com.xiniunet.apitools.template.domain.ClassConfig;
import com.xiniunet.apitools.template.domain.FileConfig;
import com.xiniunet.apitools.template.domain.RequestClass;
import org.eclipse.jdt.core.dom.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edward on 11/20/14.
 */
public class TestDoc {

    /**
     * 需要处理契约工程的基础路径，将来工具可以改为选择目录
     */
    public static String basePath = "D:\\workSpace1\\platform\\platform-contract\\src\\main\\java\\com\\xiniunet\\appservice\\";

    public static String basePackage = "com.xiniunet.api";
    public static String baseApi = "api.appservice";
    public static String docname = "doc";
    public static String dochref = "appservice";

    public static void main(String[] args) {
        //运行前请手动用IDEA格式化一下代码，方式多余的空格空行等。
        //限制：必须的规范注释/**开头
        //方法和字段申明必须在一行
        //服务契约入口
        String serviceName = "AppService";
        //处理契约相关的方法、请求、响应和领域模型
        processServiceContract(serviceName);

        //生成IOS代码
//        processServiceContractForIOS(serviceName);
    }

    private static void processServiceContractForIOS(String serviceName) {
        List<Method> methodList = processContractMethodList(serviceName);
        String filepath = TestDoc.class.getResource("/").getPath() + "template";
        FileConfig fileConfig = new FileConfig();
        fileConfig.setTemplatepath(filepath);
        fileConfig.setCodePath("C:\\HumanResourceServiceIOS");
        fileConfig.setDochref(dochref);
        AnnotationConfig annotationConfig = new AnnotationConfig();
        annotationConfig.setAuthorName("顾志雄");
        annotationConfig.setCompany("苏州犀牛网络");
        annotationConfig.setDate("2014-12-08");
        annotationConfig.setVersion("1.0");
        annotationConfig.setDescription("");
        ClassConfig apiClass = new ClassConfig();
        apiClass.setName(baseApi + "Api");
        apiClass.setServiceName(serviceName);
        apiClass.setPackageName(basePackage + ".api");
        apiClass.setAnnotation(annotationConfig);

//        List<Method> apiMethods = new ArrayList<Method>();
//
//        for (Method m : methodList) {
//            // m.print();
//            //1 生成SDK request
//
//            RequestClass requestClass = new RequestClass();
//            requestClass.setName(m.getRequestName());
//            requestClass.setApiName(generateApiName(baseApi, m.getName()));
//            requestClass.setPackageName(basePackage + ".IOS.request");
//            requestClass.setFields(m.getRequestFields());
//            annotationConfig.setDescription(m.getDescription());
//            requestClass.setAnnotation(annotationConfig);
//            ClassConfig response = new ClassConfig();
//            response.setName(m.getResponseName());
//            response.setPackageName(basePackage+".IOS.response");
//            response.setAnnotation(annotationConfig);
//            requestClass.setResponse(response);
//            fileConfig.setTemplateName("sdkRequestTemplateForIos.flt");
//            fileConfig.setFilesuffix("h");
//            FreemarkerTools.generateCode(fileConfig, requestClass);
//            fileConfig.setTemplateName("sdkRequestTemplateForIosM.flt");
//            fileConfig.setFilesuffix("m");
//            FreemarkerTools.generateCode(fileConfig, requestClass);
//
//
//            //2 生成SDK response
//            response.setFields(m.getResponseFields());
//            fileConfig.setTemplateName("sdkResponseTemplateForIos.flt");
//            fileConfig.setFilesuffix("h");
//            FreemarkerTools.generateCode(fileConfig,response);
//            fileConfig.setTemplateName("sdkResponseTemplateForIosM.flt");
//            fileConfig.setFilesuffix("m");
//            FreemarkerTools.generateCode(fileConfig,response);
//
//        }
        //7 生成SDK domain
        List<Domain> domainList = processContractDomainList(serviceName);
        for (Domain d : domainList) {
            //d.print();
            ClassConfig config = new ClassConfig();
            annotationConfig.setDescription(d.getDescription());
            config.setFields(d.getFields());
            config.setImports(d.getImports());
            config.setAnnotation(annotationConfig);
            //生成domain 文件
            fileConfig.setTemplateName("sdkDomainTemplateForIos.flt");
            config.setPackageName(basePackage + ".IOS.domain");
            config.setName(d.getName());
            fileConfig.setFilesuffix("h");
            FreemarkerTools.generateCode(fileConfig, config);
            fileConfig.setTemplateName("sdkDomainTemplateForIosM.flt");
            config.setPackageName(basePackage + ".IOS.domain");
            config.setName(d.getName());
            fileConfig.setFilesuffix("m");
            FreemarkerTools.generateCode(fileConfig, config);


        }
    }

    /**
     * 处理服务契约
     *
     * @param serviceName
     */
    private static void processServiceContract(String serviceName) {
        List<Method> methodList = processContractMethodList(serviceName);
        String filepath = TestDoc.class.getResource("/").getPath() + "template";
        FileConfig fileConfig = new FileConfig();
        fileConfig.setTemplatepath(filepath);
        fileConfig.setCodePath("C:\\codegen\\" + serviceName);
        fileConfig.setDochref(dochref);
        AnnotationConfig annotationConfig = new AnnotationConfig();
        annotationConfig.setAuthorName("顾志雄");
        annotationConfig.setCompany("苏州犀牛网络");
        annotationConfig.setDate("2015-05-07");
        annotationConfig.setVersion("1.0");
        annotationConfig.setDescription("");
        ClassConfig apiClass = new ClassConfig();
        apiClass.setName(baseApi + "Api");
        apiClass.setServiceName(serviceName);
        apiClass.setPackageName(basePackage + ".api");
        apiClass.setAnnotation(annotationConfig);

        List<Method> apiMethods = new ArrayList<Method>();
        for (Method m : methodList) {
            // m.print();
            //1 生成SDK request

            RequestClass requestClass = new RequestClass();
            requestClass.setName(m.getRequestName());
            requestClass.setApiName(generateApiName(baseApi, m.getName()));
            requestClass.setPackageName(basePackage + ".request");
            requestClass.setFields(m.getRequestFields());
            requestClass.setImports(m.getRequestImports());
            annotationConfig.setDescription(m.getDescription());
            requestClass.setAnnotation(annotationConfig);
            ClassConfig response = new ClassConfig();
            response.setName(m.getResponseName());
            response.setImports(m.getResponseImports());
            response.setPackageName(basePackage + ".response");
            response.setAnnotation(annotationConfig);
            requestClass.setResponse(response);
            fileConfig.setTemplateName("sdkRequestTemplate.flt");
            fileConfig.setFilesuffix("java");
            FreemarkerTools.generateCode(fileConfig, requestClass);
            //生成C++ SDK Request
            requestClass.setPackageName(basePackage + ".C++.request");
            fileConfig.setTemplateName("sdkRequestTemplateForC.flt");
            fileConfig.setFilesuffix("h");
            FreemarkerTools.generateCode(fileConfig, requestClass);
            //2 生成SDK response
            response.setFields(m.getResponseFields());
            fileConfig.setTemplateName("sdkResponseTemplate.flt");
            fileConfig.setFilesuffix("java");
            FreemarkerTools.generateCode(fileConfig, response);

            //3 生成C++ response
            response.setPackageName(basePackage + ".C++.response");
            fileConfig.setTemplateName("sdkResponseTemplateForC.flt");
            fileConfig.setFilesuffix("h");
            FreemarkerTools.generateCode(fileConfig, response);

            //4 生成doc 文档

            fileConfig.setTemplateName("sdkSubDocTemplate.flt");
            fileConfig.setFilesuffix("vm");
            requestClass.setName(m.getName());
            requestClass.setPackageName(basePackage + "." + docname);
            requestClass.setResponseFields(m.getResponseFields());
            requestClass.setNeedPassport(m.getNeedPassport());
            FreemarkerTools.generateCode(fileConfig, requestClass);
            m.setApiName(generateApiName(baseApi, m.getName()));
            apiMethods.add(m);
        }


        //5 生成API 方法
        apiClass.setMethods(apiMethods);
        fileConfig.setFilesuffix("java");
        fileConfig.setTemplateName("APIClassTemplate.flt");
        FreemarkerTools.generateCode(fileConfig, apiClass);
        //6 生成全局doc
        fileConfig.setTemplateName("sdkGlobalDocTemplate.flt");
        apiClass.setPackageName(basePackage + "." + docname);
        apiClass.setName("index");
        fileConfig.setFilesuffix("vm");
        FreemarkerTools.generateCode(fileConfig, apiClass);
        //7 生成SDK domain
        List<Domain> domainList = processContractDomainList(serviceName);
        for (Domain d : domainList) {
            //d.print();
            ClassConfig config = new ClassConfig();
            config.setPackageName(basePackage + "." + docname + ".domain");
            config.setName(d.getName().toLowerCase()); //webx 支持，全部变小写
            config.setImports(d.getImports());
            config.setExtend(d.getExtend());
            annotationConfig.setDescription(d.getDescription());
            config.setFields(d.getFields());
            config.setAnnotation(annotationConfig);
            fileConfig.setTemplateName("sdkDomainDocTemplate.flt");
            fileConfig.setFilesuffix("vm");
            FreemarkerTools.generateCode(fileConfig, config);
            //生成domain 文件
            fileConfig.setTemplateName("sdkDomainTemplate.flt");
            config.setPackageName(basePackage + ".domain");
            config.setName(d.getName());
            fileConfig.setFilesuffix("java");
            FreemarkerTools.generateCode(fileConfig, config);
            //生成C++ domain 文件
            fileConfig.setTemplateName("sdkDomainTemplateForC.flt");
            config.setPackageName(basePackage + ".C++.domain");
            config.setName(d.getName());
            fileConfig.setFilesuffix("h");
            FreemarkerTools.generateCode(fileConfig, config);
        }
    }

    private static String generateApiName(String ServiceName, String methodName) {
        char[] arr = methodName.toCharArray();
        String result = ""; //连接大写字母
        for (int i = 0; i < arr.length; i++) {
            if ((int) arr[i] >= 65 && (int) arr[i] <= 90) {
                result = String.valueOf(arr[i]);
                break;
            }
        }
        String apiName = "";
        if (!"".equals(result)) {
            String prfix = methodName.substring(0, methodName.indexOf(result));
            String sfix = methodName.substring(methodName.indexOf(result) + 1, methodName.length());
            apiName = ServiceName + "." + result.toLowerCase() + sfix + "." + prfix;
        } else {
            apiName = ServiceName + "." + methodName;
        }
        return apiName;
    }

    /**
     * 处理方法直接相关的方法名、请求和响应
     *
     * @param serviceName
     * @return
     */
    private static List<Method> processContractMethodList(String serviceName) {
        List<Method> methodList = new ArrayList<Method>();
        try {
            String javaFilePath = basePath + "service" + File.separator + serviceName + ".java";
            JdtAst jdt = new JdtAst();
            CompilationUnit result = jdt.getCompilationUnit(javaFilePath);
            TypeDeclaration type = (TypeDeclaration) result.types().get(0);// 获取文件中的第一个类声明(包含注释)
            MethodDeclaration[] methods = type.getMethods();// 获取方法的注释以及方法体
            for (MethodDeclaration methodDeclaration : methods) {
                Method method = new Method();
                Type method_type = methodDeclaration.getReturnType2();// 获取返回值类型 如 void
                SimpleName method_name = methodDeclaration.getName();// 获取方法名 main
                Javadoc javadoc = methodDeclaration.getJavadoc();// 获取方法的注释
                List<SingleVariableDeclaration> parameters = methodDeclaration.parameters();// 获取所有参数暂时不需要
                SingleVariableDeclaration requestParameter = null;
                if (parameters != null && !parameters.isEmpty()) {
                    requestParameter = parameters.get(0);
                }

                boolean IsNeedSession = false;
                if (parameters.size() > 1 && "Passport".equals(parameters.get(1).getType().toString())) {
                    IsNeedSession = true;
                }
                String methoddoc = "";
                if (javadoc != null) {
                    List<TagElement> tagElements = javadoc.tags();
                    for (TagElement element : tagElements) {
                        if (null == element.getTagName()) {
                            List<TextElement> fragments = element.fragments();
                            for (TextElement fragment : fragments) {
                                methoddoc += fragment.toString();
                            }
                        }
                    }
                }
                method.setName(method_name.toString());
                method.setNeedPassport(IsNeedSession);
                method.setDescription(methoddoc);
                method.setRequestName(requestParameter == null ? "" : requestParameter.getType().toString());
                method.setResponseName(method_type.toString());
                parseFields("response", method);
                parseFields("request", method);
                methodList.add(method);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return methodList;
        }
    }

    /**
     * 处理解析request,response 参数列表
     *
     * @param typeName
     * @param method
     * @return
     */
    private static void parseFields(String typeName, Method method) throws Exception {
        String name = "";
        if (typeName.equalsIgnoreCase("response")) {
            if ("".equals(method.getResponseName())) {
                return;
            }
            name = method.getResponseName();
        } else {
            if ("".equals(method.getRequestName())) {
                return;
            }
            name = method.getRequestName();
        }
        String javaFilePath = basePath + typeName + File.separator + name + ".java";
        List<Field> fields = new ArrayList<Field>();
        try {
            JdtAst jdt = new JdtAst();
            CompilationUnit result = jdt.getCompilationUnit(javaFilePath);
            List<ImportDeclaration> importList = result.imports();// 获取导入的包
            List<String> imports = new ArrayList<String>();
            for (ImportDeclaration importDeclaration : importList) {
                String importName = importDeclaration.getName().toString();
                if (importName.startsWith("java") && !importName.startsWith("javax")) {
                    imports.add(importName);
                }
            }
            if (typeName.equalsIgnoreCase("response")) {
                method.setResponseImports(imports);
            } else {
                method.setRequestImports(imports);
            }
            TypeDeclaration type = (TypeDeclaration) result.types().get(0);// 获取文件中的第一个类声明(包含注释)
            FieldDeclaration[] fieldDecs = type.getFields();// 获取类的成员变量
            for (FieldDeclaration fieldDec : fieldDecs) {
                List<VariableDeclarationFragment> fieldfragments = fieldDec.fragments();
                String fieldName = fieldfragments.get(0).toString();
                if (fieldName.startsWith("serialVersion")) {
                    continue;
                }
                final Field field = new Field();
                Javadoc javadoc = fieldDec.getJavadoc();
                String fielddoc = "";
                if (javadoc != null) {
                    List<TagElement> tagElements = javadoc.tags();
                    if (tagElements != null && !tagElements.isEmpty()) {
                        for (TagElement element : tagElements) {
                            if (null == element.getTagName()) {
                                List<TextElement> fragments = element.fragments();
                                for (TextElement fragment : fragments) {
                                    fielddoc += fragment.toString();
                                }
                            }
                        }
                    }
                }
                field.setDescription(fielddoc);
                field.setName(fieldName);
                field.setType(fieldDec.getType().toString());
                //获取注解
                List<Object> modifiers = fieldDec.modifiers();
                for (Object modifier : modifiers) {
                    if (modifier instanceof MarkerAnnotation) {
                        MarkerAnnotation annotation = (MarkerAnnotation) modifier;
                        if ("NotNull".equals(annotation.getTypeName())) {
                            field.setIsNotNull(true);
                        }
                    } else if (modifier instanceof NormalAnnotation) {
                        NormalAnnotation annotation = (NormalAnnotation) modifier;
                        if ("NotNull".equals(annotation.getTypeName())) {
                            field.setIsNotNull(true);
                        } else if ("Length".equals(annotation.getTypeName())) {
                            field.setIsLength(true);
                            List<MemberValuePair> valuePairs = annotation.values();
                            for (MemberValuePair memberValuePair : valuePairs) {
                                if ("max".equals(memberValuePair.getName())) {
                                    field.setMaxLength(memberValuePair.getValue().toString());
                                } else if ("min".equals(memberValuePair.getName())) {
                                    field.setMinLength(memberValuePair.getValue().toString());
                                }
                            }
                        }
                    }
                }
                fields.add(field);
            }

            // 判断对应父类
            if (type.getSuperclassType().isParameterizedType()) {
                ParameterizedType typeDeclaration = (ParameterizedType) type.getSuperclassType();
                String superClassName = typeDeclaration.getType().toString();
                if ("BaseUpdateRequest".equals(superClassName)){
                    Field field = new Field();
                    field.setName("rowVersion");
                    field.setType("long");
                    field.setDescription("版本号");
                    field.setIsNotNull(false);
                    fields.add(field);
                }
                if ("BaseFindRequest".equals(superClassName)||"BaseSearchRequest".equals(superClassName)) {
                    Field field = new Field();
                    field.setName("pageNumber");
                    field.setType("int");
                    field.setDescription("当前页数");
                    field.setIsNotNull(true);
                    fields.add(field);
                    field = new Field();
                    field.setName("pageSize");
                    field.setType("int");
                    field.setDescription("分页大小");
                    field.setIsNotNull(true);
                    fields.add(field);
                    if("BaseSearchRequest".equals(superClassName)){
                        field = new Field();
                        field.setName("keyword");
                        field.setType("String");
                        field.setDescription("查询关键字");
                        field.setIsNotNull(false);
                        fields.add(field);
                    }

                    String genericity = ""; //获取basefindrequest泛型
                    List<SimpleType> typeArguments = typeDeclaration.typeArguments();
                    if (typeArguments != null && !typeArguments.isEmpty()) {
                        SimpleType argument = typeArguments.get(0);
                        genericity = argument.toString();
                    }
                    if (!"".equals(genericity)) {
                        field = new Field();
                        field.setName("sortKey");
                        field.setType(genericity);
                        field.setDescription("排序列");
                        field.setIsNotNull(false);
                        fields.add(field);
                    }
                    //增加排序方式
                    field = new Field();
                    field.setName("sortType");
                    field.setType("SortTypeEnum");
                    field.setDescription("排序方式");
                    field.setIsNotNull(false);
                    fields.add(field);
                    method.addRequestImport("com.xiniunet.api.domain.constant.SortTypeEnum");
                }else if ("BaseFindResponse".equals(superClassName) || "BaseSearchResponse".equals(superClassName)) {
                    Field field = new Field();
                    field.setName("totalCount");
                    field.setType("long");
                    field.setDescription("当前页数");
                    field.setIsNotNull(true);
                    fields.add(field);
                    String genericity = ""; //获取basefindResponse泛型
                    List<SimpleType> typeArguments = typeDeclaration.typeArguments();
                    if (typeArguments != null && !typeArguments.isEmpty()) {
                        SimpleType argument = typeArguments.get(0);
                        genericity = argument.toString();
                    }
                    if (!"".equals(genericity)) {
                        field = new Field();
                        field.setName("result");
                        field.setType("List<" + genericity + ">");
                        field.setDescription("返回对象");
                        field.setIsNotNull(true);
                        fields.add(field);
                    }
                } else if ("BaseUpdateResponse".equals(superClassName)) {
                    //检查fields 中是否含有result
                    Boolean ishas = false;
                    for (Field field : fields) {
                        if ("result".equalsIgnoreCase(field.getName())) {
                            ishas = true;
                            break;
                        }
                    }
                    if (!ishas) {
                        Field field = new Field();
                        field.setName("result");
                        field.setType("long");
                        field.setDescription("更新记录数");
                        field.setIsNotNull(true);
                        fields.add(field);
                    }
                    Field field = new Field();
                    field.setName("rowVersion");
                    field.setType("long");
                    field.setDescription("版本号");
                    field.setIsNotNull(true);
                    fields.add(field);
                } else if ("BaseDomainResponse".equals(superClassName)) {
                    String genericity = ""; //获取basefindResponse泛型
                    List<SimpleType> typeArguments = typeDeclaration.typeArguments();
                    if (typeArguments != null && !typeArguments.isEmpty()) {
                        SimpleType argument = typeArguments.get(0);
                        genericity = argument.toString();
                    }
                    if (!"".equals(genericity)) {
                        Field field = new Field();
                        field.setName("result");
                        field.setType(genericity);
                        field.setDescription("返回对象");
                        field.setIsNotNull(true);
                        fields.add(field);
                    }
                } else if ("BaseGetAllListResponse".equals(superClassName)) {
                    Field field = new Field();
                    field.setName("totalCount");
                    field.setType("long");
                    field.setDescription("当前页数");
                    field.setIsNotNull(true);
                    fields.add(field);
                    String genericity = ""; //获取basefindResponse泛型
                    List<SimpleType> typeArguments = typeDeclaration.typeArguments();
                    if (typeArguments != null && !typeArguments.isEmpty()) {
                        SimpleType argument = typeArguments.get(0);
                        genericity = argument.toString();
                    }
                    if (!"".equals(genericity)) {
                        field = new Field();
                        field.setName("result");
                        field.setType("List<" + genericity + ">");
                        field.setDescription("返回对象");
                        field.setIsNotNull(true);
                        fields.add(field);
                    }
                }
            }
            if (type.getSuperclassType().isSimpleType()) {
                SimpleType simpleType = (SimpleType) type.getSuperclassType();
                String superClassName = simpleType.toString();
                if ("BaseUpdateRequest".equals(superClassName)){
                    Field field = new Field();
                    field.setName("rowVersion");
                    field.setType("long");
                    field.setDescription("版本号");
                    field.setIsNotNull(false);
                    fields.add(field);
                }
                if ("BaseUpdateResponse".equals(superClassName)) {
                    Boolean ishas = false;
                    for (Field field : fields) {
                        if ("result".equalsIgnoreCase(field.getName())) {
                            ishas = true;
                            break;
                        }
                    }
                    if (!ishas) {
                        Field field = new Field();
                        field.setName("result");
                        field.setType("long");
                        field.setDescription("更新记录数");
                        field.setIsNotNull(true);
                        fields.add(field);
                    }
                }
                if ("BaseFindRequest".equals(superClassName)||"BaseSearchRequest".equals(superClassName)) {
                    Field field = new Field();
                    field.setName("pageNumber");
                    field.setType("int");
                    field.setDescription("当前页数");
                    field.setIsNotNull(true);
                    fields.add(field);
                    field = new Field();
                    field.setName("pageSize");
                    field.setType("int");
                    field.setDescription("分页大小");
                    field.setIsNotNull(true);
                    fields.add(field);
                    if("BaseSearchRequest".equals(superClassName)){
                        field = new Field();
                        field.setName("keyword");
                        field.setType("String");
                        field.setDescription("查询关键字");
                        field.setIsNotNull(false);
                        fields.add(field);
                    }
                    field = new Field();
                    field.setName("sortKey");
                    field.setType("List<String>");
                    field.setDescription("排序列");
                    field.setIsNotNull(false);
                    fields.add(field);
                    //增加排序方式
                    field = new Field();
                    field.setName("sortType");
                    field.setType("SortTypeEnum");
                    field.setDescription("排序方式");
                    field.setIsNotNull(false);
                    fields.add(field);
                    method.addRequestImport("com.xiniunet.api.domain.constant.SortTypeEnum");
                    //判断是否需要import java.util.list
                    Boolean isNeedimportList = true;
                    for(String importstr:method.getRequestImports()){
                        if("java.util.List".equals(importstr)){
                            isNeedimportList = false;
                            break;
                        }
                    }
                    if(isNeedimportList){
                        method.addRequestImport("java.util.List");
                    }
                }
            }

            if (typeName.equalsIgnoreCase("response")) {
                method.setResponseFields(fields);
            } else {
                method.setRequestFields(fields);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理契约领域模型，集中处理，按目录遍历
     *
     * @param serviceName
     * @return
     */
    private static List<Domain> processContractDomainList(String serviceName) {
        List<Domain> list = new ArrayList<Domain>();
        try {
            File dir = new File(basePath + "domain/");
            File[] fs = dir.listFiles();
            JdtAst jdt = new JdtAst();
            for (File file : fs) {
                String javaFilePath = file.getPath();
                CompilationUnit result = jdt.getCompilationUnit(javaFilePath);
                if (result.types() == null || result.types().isEmpty() || javaFilePath.contains("Enum")) {
                    continue;
                }
                Domain domain = new Domain();
                List<ImportDeclaration> importList = result.imports();// 获取导入的包
                List<String> imports = new ArrayList<String>();
                for (ImportDeclaration importDeclaration : importList) {
                    String importName = importDeclaration.getName().toString();
                    if (importName.startsWith("java") && !importName.startsWith("javax")) {
                        imports.add(importName);
                    }
                }
                //获取父类

                TypeDeclaration type = (TypeDeclaration) result.types().get(0);// 获取文件中的第一个类声明(包含注释)
                //判断当前domain 类型
                domain.setName(type.getName().toString());
                domain.setImports(imports);
                //解析domain 参数
                FieldDeclaration[] fieldDecs = type.getFields();// 获取类的成员变量
                List<Field> fields = new ArrayList<Field>();
                for (FieldDeclaration fieldDec : fieldDecs) {
                    List<VariableDeclarationFragment> fieldfragments = fieldDec.fragments();
                    String fieldName = fieldfragments.get(0).toString();
                    if (fieldName.startsWith("serialVersion")) {
                        continue;
                    }
                    final Field field = new Field();
                    Javadoc javadoc = fieldDec.getJavadoc();
                    String fielddoc = "";
                    if (javadoc != null) {
                        List<TagElement> tagElements = javadoc.tags();
                        if (tagElements != null && !tagElements.isEmpty()) {
                            for (TagElement element : tagElements) {
                                if (null == element.getTagName()) {
                                    List<TextElement> textfragments = element.fragments();
                                    for (TextElement fragment : textfragments) {
                                        fielddoc += fragment.toString();
                                    }
                                }
                            }
                        }
                    }

                    field.setDescription(fielddoc);
                    field.setName(fieldName);
                    field.setType(fieldDec.getType().toString());
                    fields.add(field);
                }
                if (type.getSuperclassType() != null && type.getSuperclassType().isSimpleType()) {
                    String superClassName = type.getSuperclassType().toString();
                    if ("BaseDomain".equals(superClassName)) {
                        Field field = new Field();
                        field.setName("rowVersion");
                        field.setType("long");
                        field.setDescription("行版本号");
                        field.setIsNotNull(true);
                        fields.add(field);

                    } else if (!superClassName.startsWith("Base")) {
                        domain.setExtend(superClassName);
                    }
                }
                domain.setFields(fields);
                list.add(domain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
}