package com.xiniunet.apitools.codeAnalysis;
import org.eclipse.jdt.core.dom.*;
import org.eclipse.jface.text.projection.Fragment;
import sun.reflect.generics.tree.TypeArgument;

import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.apitools.codeAnalysis
 *  Description:
 * ***************************************************************
 *  5/8 0008  V1.0  xiniu    New Files for com.xiniunet.apitools.codeAnalysis
 * </pre>
 */
public class JavaParseUtil {

    public static void main(String[] args) throws Exception {
        String javaFilePath = "D:\\workSpace1\\distribution\\distribution-contract\\src\\main\\java\\com\\xiniunet\\purchasing\\response\\BankAccountUpdateResponse.java";
        //解析所有方法
        JdtAst jdt = new JdtAst();
        CompilationUnit result = jdt.getCompilationUnit(javaFilePath);
        List<ImportDeclaration> importList = result.imports();// 获取导入的包
        for(ImportDeclaration importDeclaration : importList){
            if(!importDeclaration.toString().contains("com.xiniunet")){
                System.out.println(importDeclaration.getName());
            }

        }
        TypeDeclaration type = (TypeDeclaration) result.types().get(0);// 获取文件中的第一个类声明(包含注释)

        type.getSuperclassType();
//        List<SimpleType> typeArguments = typeDeclaration.typeArguments();
//        if(typeArguments!=null&&!typeArguments.isEmpty()){
//            SimpleType argument = typeArguments.get(0);
//            System.out.println(argument.toString());
//        }
//        System.out.println(" 超类 "+typeDeclaration.toString());
        FieldDeclaration[] fieldList = type.getFields();// 获取类的成员变量
        for(FieldDeclaration fieldDec : fieldList){
                List<Object> modifiers = fieldDec.modifiers();
                for(Object modifier:modifiers){
                    if(modifier instanceof MarkerAnnotation){
                        MarkerAnnotation annotation  = (MarkerAnnotation) modifier;
                        System.out.println(annotation.getTypeName());
                    }else if (modifier instanceof NormalAnnotation){
                        NormalAnnotation annotation  = (NormalAnnotation) modifier;
                        System.out.println(annotation.getTypeName());
                        List<MemberValuePair> valuePairs =  annotation.values();
                        for(MemberValuePair memberValuePair:valuePairs){
                            System.out.println(memberValuePair.getName()+" == "+memberValuePair.getValue());
                        }
                    }

                }

//            fieldDec.accept(new ASTVisitor(){
//                public void endVisit(MarkerAnnotation node){
//                    System.out.println("==="+node.getTypeName().toString());
////                    if(node.getTypeName().toString().equals("NotNull")){
//////                        System.out.println("istrue");
//////                    }
//
//                }
//
//
//            });
            Javadoc javadoc = fieldDec.getJavadoc();
            String fielddoc = "";
            List<TagElement> tagElements = javadoc.tags();
            for(TagElement element:tagElements){
                if(null==element.getTagName()){
                    List<TextElement> fragments = element.fragments();
                    for(TextElement fragment:fragments){
                        fielddoc+=fragment.toString();
                    }
                }
            }
//            MarkerAnnotation


            ChildListPropertyDescriptor modifier = fieldDec.getModifiersProperty();
            List<VariableDeclarationFragment> fragments = fieldDec.fragments();

            System.out.println("参数类型 : "+fieldDec.getType().toString()+" 参数名称 :"+fragments.get(0).toString() +" 注释 ： "+fielddoc);

            fieldDec.getAST();


        }
        /*
        MethodDeclaration[] methodList = type.getMethods();// 获取方法的注释以及方法体
        for(MethodDeclaration methodDeclaration: methodList){
            Type method_type = methodDeclaration.getReturnType2();// 获取返回值类型 如 void
            SimpleName method_name = methodDeclaration.getName();// 获取方法名 main
            Javadoc javadoc = methodDeclaration.getJavadoc();// 获取方法的注释
            List<SingleVariableDeclaration> parameters = methodDeclaration.parameters();// 获取所有参数暂时不需要
            SingleVariableDeclaration parametermethod = parameters.get(0);
            boolean IsNeedSession = false;
            if(parameters.size()>1&&"Passport".equals(parameters.get(1).getType().toString())){
                IsNeedSession = true;
            }
            List<TagElement> tagElements = javadoc.tags();
            String methoddoc = "";
            for(TagElement element:tagElements){
                if(null==element.getTagName()){
                    methoddoc = element.toString();
                }
            }
            System.out.println("方法名 : "+method_name.toString()+" 注释 : "+methoddoc+
                                " 返回值 :"+method_type.toString()+"参数 : 类型 "+parametermethod.getType().toString()+"名称 : "+parametermethod.getName()+
                                "是否需要Session : "+IsNeedSession
            );
        }
*/

    }
}
