package net.showcal.api.internal.mapping;

import net.showcal.api.ApiException;

import java.util.List;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: cnet.showcal.api.nternal.mapping
 *  Description:格式转换器。
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api.internal.mapping
 * </pre>
 */
public interface Reader {
    /**
     * 判断返回结果是否包含指定的属性。
     *
     * @param name 属性名称
     * @return true/false
     */
    public boolean hasReturnField(Object name);

    /**
     * 读取单个基本对象。
     *
     * @param name 映射名称
     * @return 基本对象值
     */
    public Object getPrimitiveObject(Object name);

    /**
     * 读取单个自定义对象。
     *
     * @param name 映射名称
     * @param type 映射类型
     * @return 映射类型的实例
     */
    public Object getObject(Object name, Class<?> type) throws ApiException;

    /**
     * 读取多个对象的值。
     *
     * @param listName 列表名称
     * @param itemName 映射名称
     * @param subType  嵌套映射类型
     * @return 嵌套映射类型实例列表
     */
    public List<?> getListObjects(Object listName, Object itemName, Class<?> subType) throws ApiException;
}
