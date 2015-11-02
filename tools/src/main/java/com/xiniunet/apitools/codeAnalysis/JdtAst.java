package com.xiniunet.apitools.codeAnalysis;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

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
public class JdtAst {
    private ASTParser astParser = ASTParser.newParser(AST.JLS3); // 非常慢

    /**
     * 获得java源文件的结构CompilationUnit
     */
    public CompilationUnit getCompilationUnit(String javaFilePath)
            throws Exception {

        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(javaFilePath));
        byte[] input = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(input);
        bufferedInputStream.close();
        this.astParser.setSource(new String(input,"UTF-8").toCharArray());
        this.astParser.setResolveBindings(true);
        /**/
        CompilationUnit result = (CompilationUnit) (this.astParser
                .createAST(null)); // 很慢

        return result;

    }

}
