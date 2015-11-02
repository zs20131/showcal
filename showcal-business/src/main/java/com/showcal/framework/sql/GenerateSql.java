package com.showcal.framework.sql;

import com.xiniunet.framework.base.BaseRequest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.framework.sql
 *  Description: 生成SQL
 * ***************************************************************
 *  9/24 0024  V1.0  xiniu    New Files for com.showcal.framework.sql
 * </pre>
 */
public class GenerateSql {
    /**
     * 生成新建SQL语句
     *
     * @param tableName
     * @param obj
     * @return
     */
    public static String generateInsertSql(String tableName, Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuffer insertSql = new StringBuffer();
        StringBuffer keysql = new StringBuffer();
        StringBuffer valuesql = new StringBuffer();
        try {
            int index = 0;
            Field.setAccessible(fields, true);
            for (Field field : fields) {
                ColumnIgnore columnIgnore = field.getAnnotation(ColumnIgnore.class);
                if(columnIgnore!=null){
                    continue;
                }
                String fieldName = "";
                ColumnAlias columnAlias = field.getAnnotation(ColumnAlias.class);
                if(columnAlias!=null){
                    fieldName = columnAlias.value();
                }else {
                    fieldName = field.getName();
                }
                if (field.get(obj) != null) {
                    String value = field.get(obj).toString();
                    if (index == 0) {
                        keysql.append(fieldName);
                        valuesql.append("'").append(value).append("'");
                    } else {
                        keysql.append(",").append(fieldName);
                        valuesql.append(",").append("'").append(value).append("'");
                    }
                    index++;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        insertSql.append("INSERT INTO ").append(tableName).append(" (").append(keysql).append(") ");
        insertSql.append(" VALUES (").append(valuesql).append(") ");
        return insertSql.toString();
    }

    /**
     * 生成更新SQL语句
     *
     * @param tableName
     * @param request
     * @param parameter
     * @return
     */
    public static String generateUpdateSql(String tableName, Object request, WhereParameter parameter) {
        Field[] fields = request.getClass().getDeclaredFields();
        StringBuffer setsql = new StringBuffer();
        StringBuffer wheresql = new StringBuffer();
        StringBuffer updatesql = new StringBuffer();
        try {
            int index = 0;
            Field.setAccessible(fields, true);
            for (Field field : fields) {
                ColumnIgnore columnIgnore = field.getAnnotation(ColumnIgnore.class);
                if(columnIgnore!=null){
                    continue;
                }
                String fieldName = "";
                ColumnAlias columnAlias = field.getAnnotation(ColumnAlias.class);
                if(columnAlias!=null){
                    fieldName = columnAlias.value();
                }else {
                    fieldName = field.getName();
                }
                if (field.get(request) != null && !parameter.containsKey(fieldName)) {
                    String value = field.get(request).toString();
                    if (index == 0) {
                        setsql.append(" ").append(fieldName).append(" = '").append(value).append("' ");
                    } else {
                        setsql.append(" , ").append(fieldName).append(" = '").append(value).append("' ");
                    }
                    index++;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Set<String> keys = parameter.keySet();
        int index = 0;
        for (String key : keys) {
            if (index == 0) {
                wheresql.append(" ").append(key).append(" = '").append(parameter.get(key)).append("' ");
            } else {
                wheresql.append(" and ").append(key).append(" = '").append(parameter.get(key)).append("'");
            }
            index++;
        }

        updatesql.append("update ").append(tableName).append(" set ").append(setsql).append(" where ").append(wheresql);
        return updatesql.toString();
    }

    /**
     * 生成删除SQL语句
     *
     * @param tableName
     * @param request
     * @return
     */
    public static String generateDeleteSql(String tableName, BaseRequest request) {
        Field[] fields = request.getClass().getDeclaredFields();
        StringBuffer sqlsb = new StringBuffer();
        StringBuffer wheresql = new StringBuffer();
        try {
            int index = 0;
            Field.setAccessible(fields, true);
            for (Field field : fields) {
                if (field.get(request) != null) {
                    String fieldName = "";
                    ColumnAlias columnAlias = field.getAnnotation(ColumnAlias.class);
                    if(columnAlias!=null){
                        fieldName = columnAlias.value();
                    }else {
                        fieldName = field.getName();
                    }
                    String value = field.get(request).toString();
                    if (index == 0) {
                        wheresql.append(" ").append(fieldName).append(" = '").append(value).append("' ");
                    } else {
                        wheresql.append(" and ").append(fieldName).append(" = '").append(value).append("'");
                    }
                    index++;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (!"".equals(wheresql.toString().replace(" ", ""))) {
            sqlsb.append("delete from ").append(tableName).append(" where ").append(wheresql);
        }
        return sqlsb.toString();
    }
}
