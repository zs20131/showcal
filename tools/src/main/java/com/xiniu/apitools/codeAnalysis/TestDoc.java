package com.xiniu.apitools.codeAnalysis;


import com.xiniunet.apitools.codeAnalysis.Domain;
import com.xiniunet.apitools.codeAnalysis.Field;
import com.xiniunet.apitools.codeAnalysis.Method;
import com.xiniunet.apitools.template.FreemarkerTools;
import com.xiniunet.apitools.template.domain.AnnotationConfig;
import com.xiniunet.apitools.template.domain.ClassConfig;
import com.xiniunet.apitools.template.domain.FileConfig;
import com.xiniunet.apitools.template.domain.RequestClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edward on 11/20/14.
 */
public class TestDoc {

    /**
     * 需要处理契约工程的基础路径，将来工具可以改为选择目录
     */
    public static String basePath = "D:\\work\\logistics\\logistics-contract\\src\\main\\java\\com\\xiniunet\\warehouse\\";
    public static String basePackage = "com.xiniu.api";
    public static String baseApi = "api.warehouse";
    public static void main(String[] args) {
        //运行前请手动用IDEA格式化一下代码，方式多余的空格空行等。
        //限制：必须的规范注释/**开头
        //方法和字段申明必须在一行
        //服务契约入口
        String serviceName = "WarehouseService";
        //处理契约相关的方法、请求、响应和领域模型
        processServiceContract(serviceName);
    }

    /**
     * 处理服务契约
     *
     * @param serviceName
     */
    private static void processServiceContract(String serviceName) {
        List<Method> methodList = processContractMethodList(serviceName);
        String filepath = TestDoc.class.getResource("/").getPath()+"template";
        FileConfig fileConfig = new FileConfig();
        fileConfig.setTemplatepath(filepath);
        fileConfig.setCodePath("C:\\代码生成");
        AnnotationConfig annotationConfig = new AnnotationConfig();
        annotationConfig.setAuthorName("张明");
        annotationConfig.setCompany("苏州犀牛网络");
        annotationConfig.setDate("2015-07-21");
        annotationConfig.setVersion("1.0");
        annotationConfig.setDescription("");
        ClassConfig apiClass = new ClassConfig();
        apiClass.setName(baseApi+"Api");
        apiClass.setPackageName(basePackage+".api");
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
            annotationConfig.setDescription(m.getDescription());
            requestClass.setAnnotation(annotationConfig);
            ClassConfig response = new ClassConfig();
            response.setName(m.getResponseName());
            response.setPackageName(basePackage+".response");
            response.setAnnotation(annotationConfig);
            requestClass.setResponse(response);
            fileConfig.setTemplateName("sdkRequestTemplate.flt");
            fileConfig.setFilesuffix("java");
            FreemarkerTools.generateCode(fileConfig, requestClass);
            //2 生成SDK response
            response.setFields(m.getResponseFields());
            fileConfig.setTemplateName("sdkResponseTemplate.flt");
            fileConfig.setFilesuffix("java");
            FreemarkerTools.generateCode(fileConfig,response);

            //4 生成doc 文档

            fileConfig.setTemplateName("sdkSubDocTemplate.flt");
            fileConfig.setFilesuffix("html");
            requestClass.setName(m.getName());
            requestClass.setPackageName(basePackage+".doc");
            requestClass.setResponseFields(m.getResponseFields());
            requestClass.setNeedPassport(m.getNeedPassport());
            FreemarkerTools.generateCode(fileConfig,requestClass);
            m.setApiName(generateApiName(baseApi, m.getName()));
            apiMethods.add(m);
        }


        //5 生成API 方法
        apiClass.setMethods(apiMethods);
        fileConfig.setFilesuffix("java");
        fileConfig.setTemplateName("APIClassTemplate.flt");
        FreemarkerTools.generateCode(fileConfig,apiClass);
        //6 生成全局doc
        fileConfig.setTemplateName("sdkGlobalDocTemplate.flt");
        apiClass.setPackageName(basePackage+".doc");
        fileConfig.setFilesuffix("html");
        FreemarkerTools.generateCode(fileConfig,apiClass);
        //7 生成SDK domain
        List<Domain> domainList = processContractDomainList(serviceName);
        for (Domain d : domainList) {
            //d.print();
            ClassConfig config = new ClassConfig();
            config.setPackageName(basePackage+".doc.domain");
            config.setName(d.getName());
            annotationConfig.setDescription(d.getDescription());
            config.setFields(d.getFields());
            config.setAnnotation(annotationConfig);
            fileConfig.setTemplateName("sdkDomainDocTemplate.flt");
            fileConfig.setFilesuffix("html");
            FreemarkerTools.generateCode(fileConfig,config);
            //生成domain 文件
            fileConfig.setTemplateName("sdkDomainTemplate.flt");
            config.setPackageName(basePackage+".domain");
            fileConfig.setFilesuffix("java");
            FreemarkerTools.generateCode(fileConfig,config);
        }
    }

    private static String generateApiName(String ServiceName,String methodName){
        char[] arr = methodName.toCharArray();
        String result = ""; //连接大写字母
        for(int i = 0; i < arr.length; i++){
            if((int)arr[i] >= 65 && (int)arr[i] <= 90){
                result = String.valueOf(arr[i]);
                break;
            }
        }
        String prfix = methodName.substring(0,methodName.indexOf(result));
        String sfix = methodName.substring(methodName.indexOf(result)+1, methodName.length());
        String apiName = ServiceName+"."+result.toLowerCase()+sfix+"."+prfix;
        //System.out.println("字母转换：" + apiName);
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

            BufferedReader br = new BufferedReader(new FileReader(basePath + "service"+ File.separator + serviceName + ".java"));

            String temp = br.readLine();
            //System.out.println(temp);
            while (temp != null) {
                temp = temp.trim();
                //主要判断要点，以标准注释为切入点
                if (temp.indexOf("/**") != -1 && temp.indexOf("*/") == -1) {

                    StringBuffer comment = new StringBuffer();
                    getComment(br, comment);
                    //排除文件注释
                    if (comment.toString().indexOf("Copyright (c)") == -1
                            && comment.toString().indexOf("@author") == -1
                            && comment.toString().indexOf("Created by") == -1) {
                        //多行注释结束,读取具体方法定义
                        Method method = new Method();

                        StringBuffer declare = new StringBuffer();
                        getMethodDecleare(br, method);

                        String methodDeclare = method.getDeclare().toString();

                        int firstBlank = methodDeclare.indexOf(" ");
                        int leftBlace = methodDeclare.indexOf("(");
                        int rightBlace = methodDeclare.indexOf(")");
                        if (firstBlank > 0 && leftBlace > 0 && rightBlace > 0) {

                            method.setResponseName(methodDeclare.substring(0, firstBlank).trim());
                            method.setName(methodDeclare.substring(firstBlank, leftBlace).trim());

                            String parameters[] = methodDeclare.substring(leftBlace + 1, rightBlace).trim().split(",");

                            for (String stemp : parameters) {
                                String parameter[] = stemp.trim().split(" ");
                                if (parameter[0].equalsIgnoreCase("Passport") == true) {
                                    method.setNeedPassport(true);
                                } else {
                                    method.setRequestName(parameter[0]);
                                }
                            }

                            String methodDescription = comment.toString();
                            if (methodDescription.indexOf("@param") != -1) {
                                method.setDescription(methodDescription.substring(0, methodDescription.indexOf("@param")));
                            } else if (methodDescription.indexOf("@return") != -1) {
                                method.setDescription(methodDescription.substring(0, methodDescription.indexOf("@return")));
                            } else {
                                method.setDescription(methodDescription);
                            }
                            processMethodFields("request", method);
                            processMethodFields("response", method);

                            methodList.add(method);


                        }
                    }


                }
                temp = br.readLine();
            }
            br.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return methodList;
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
            for (int i = 0; i < fs.length; i++) {

                Domain domain = new Domain();
                domain.setUrl(fs[i].getAbsolutePath());
                domain.setName(fs[i].getName().substring(0, fs[i].getName().lastIndexOf(".")));
                processDomainField(domain);
                list.add(domain);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    /**
     * 处理方法请求和响应文件
     *
     * @param type
     * @param method
     */
    public static void processMethodFields(String type, Method method) {
        try {
            String name = "";
            if (type.equalsIgnoreCase("response")) {
                name = method.getResponseName();
            } else {
                name = method.getRequestName();
            }
            BufferedReader br = new BufferedReader(new FileReader(basePath + type + File.separator + name + ".java"));

            // TODO  判断如果是基类还需要将基类中的固定字段加入


            String temp = br.readLine();
            while (temp != null) {
                temp = temp.trim();

                if (temp.indexOf("/**") != -1 && temp.indexOf("*/") == -1) {

                    StringBuffer comment = new StringBuffer();
                    getComment(br, comment);
                    if (comment.toString().indexOf("Copyright (c)") == -1
                            && comment.toString().indexOf("@author") == -1
                            && comment.toString().indexOf("Created by") == -1) {
                        //多行注释结束,读取具体方法定义
                        Field field = new Field();
                        field.setComment(comment.toString());


                        getFieldDecleare(br, field);

                        String fieldDeclare[] = field.getDeclare().toString().trim().split(" ");

                        if (fieldDeclare.length == 3) {

                            field.setName(fieldDeclare[2]);
                            field.setType(fieldDeclare[1]);
                            field.setDescription(comment.toString());
                            if (type.equalsIgnoreCase("response")) {
                                method.getResponseFields().add(field);
                            } else {
                                method.getRequestFields().add(field);
                            }
                        }
                    }


                }


                temp = br.readLine();

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理领域对象字段
     *
     * @param domain
     */
    public static void processDomainField(Domain domain) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(domain.getUrl()));


            // TODO  判断如果是基类还需要将基类中的固定字段加入
            String temp = br.readLine();
            //System.out.println(temp);
            while (temp != null) {
                temp = temp.trim();

                if (temp.indexOf("/**") != -1 && temp.indexOf("*/") == -1) {

                    StringBuffer comment = new StringBuffer();
                    getComment(br, comment);
                    if (comment.toString().indexOf("Copyright (c)") == -1
                            && comment.toString().indexOf("@author") == -1
                            && comment.toString().indexOf("Created by") == -1) {
                        //多行注释结束,读取具体方法定义

                        Field field = new Field();
                        StringBuffer declare = new StringBuffer();
                        declare.append("");
                        getFieldDecleare(br, field);

                        String fieldDeclare[] = field.getDeclare().toString().trim().split(" ");

                        if (fieldDeclare.length == 3) {

                            field.setName(fieldDeclare[2]);
                            field.setType(fieldDeclare[1]);
                            field.setDescription(comment.toString());
                            domain.getFields().add(field);
                        }
                    }


                }


                temp = br.readLine();

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取注释信息
     *
     * @param br
     * @param comment
     */
    public static void getComment(BufferedReader br, StringBuffer comment) {

        try {

            String temp = br.readLine().trim();

            if (temp.indexOf("*/") == -1) {
                comment.append(temp.substring(1));
                getComment(br, comment);
            }


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /**
     * 获取字段申明
     *
     * @param br
     * @param field
     */
    public static void getFieldDecleare(BufferedReader br, Field field) {

        try {

            String temp = br.readLine().trim();

            if (temp.length() > 2 && temp.substring(temp.length() - 1).equalsIgnoreCase(";")) {
                field.setDeclare(temp.substring(0, temp.length() - 1));
            } else if (temp.length() >= 8 && temp.indexOf("@NotNull") != -1) {
                field.setIsNotNull(true);
                getFieldDecleare(br, field);
            } else if (temp.length() >= 7 && temp.indexOf("@Length") != -1) {
                //@Length(min=0, max=50, message = "名称长度不合法")
                field.setIsLength(true);
                String[] lengthLimit = temp.substring(temp.indexOf("(") + 1, temp.lastIndexOf(")")).trim().split(",");
                for (String s : lengthLimit) {
                    String[] keys = s.split("=");
                    if (keys.length == 2) {
                        if (keys[0].trim().equalsIgnoreCase("min")) {
                            field.setMinLength(keys[1]);
                        } else if (keys[0].trim().equalsIgnoreCase("max")) {
                            field.setMaxLength(keys[1]);
                        }
                    }
                }
                getFieldDecleare(br, field);
            } else {
                getFieldDecleare(br, field);
            }


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /**
     * 获取方法申明
     *
     * @param br
     * @param method
     */
    public static void getMethodDecleare(BufferedReader br, Method method) {

        try {

            String temp = br.readLine().trim();

            if (temp.length() > 2 && temp.substring(temp.length() - 1).equalsIgnoreCase(";")) {
                method.setDeclare(temp.substring(0, temp.length() - 1));
            } else {
                getMethodDecleare(br, method);
            }


        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /**
     * 取得当前类所在的ClassPath目录，比如tomcat下的classes路径
     *
     * @param clazz
     * @return
     */
    public static File getClassPathFile(Class clazz) {
        File file = getClassFile(clazz);
        for (int i = 0, count = clazz.getName().split("[.]").length; i < count; i++)
            file = file.getParentFile();
        if (file.getName().toUpperCase().endsWith(".JAR!")) {
            file = file.getParentFile();
        }
        return file;
    }

    /**
     * 取得当前类所在的ClassPath路径
     *
     * @param clazz
     * @return
     */
    public static String getClassPath(Class clazz) {
        try {
            return java.net.URLDecoder.decode(getClassPathFile(clazz).getAbsolutePath(), "UTF-8");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 取得当前类所在的文件
     *
     * @param clazz
     * @return
     */
    public static File getClassFile(Class clazz) {
        URL path = clazz.getResource(clazz.getName().substring(
                clazz.getName().lastIndexOf(".") + 1) + ".classs");
        if (path == null) {
            String name = clazz.getName().replaceAll("[.]", "/");
            path = clazz.getResource("/" + name + ".class");
        }
        return new File(path.getFile());
    }

    /**
     * 得到当前类的路径
     *
     * @param clazz
     * @return
     */
    public static String getClassFilePath(Class clazz) {
        try {
            return java.net.URLDecoder.decode(getClassFile(clazz).getAbsolutePath(), "UTF-8");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "";
        }
    }

}
