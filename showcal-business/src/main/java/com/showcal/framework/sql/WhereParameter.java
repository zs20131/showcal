package com.showcal.framework.sql;

import java.util.HashMap;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.framework.sql
 *  Description: where 参数
 * ***************************************************************
 *  9/24 0024  V1.0  xiniu    New Files for com.showcal.framework.sql
 * </pre>
 */
public class WhereParameter extends HashMap<String, Object> {
    /**
     * 设置参数
     *
     * @param key
     * @param value
     * @return
     */
    public WhereParameter setParameter(String key, Object value) {
        this.put(key, value);
        return this;
    }

    public Object getParameter(String key) {
        return this.get(key);
    }
}
