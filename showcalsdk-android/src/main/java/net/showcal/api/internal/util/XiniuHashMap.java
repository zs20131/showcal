package net.showcal.api.internal.util;

import net.showcal.api.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api.utils
 *  Description:
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api.utils
 * </pre>
 */
public class XiniuHashMap extends HashMap<String, String> {
    private static final long serialVersionUID = -1277791390393392630L;

    public XiniuHashMap() {
        super();
    }

    public XiniuHashMap(Map<? extends String, ? extends String> m) {
        super(m);
    }

    public String put(String key, Object value) {
        String strValue;

        if(value == null) {
            strValue = null;
        } else if(value instanceof String) {
            strValue = (String) value;
        } else if(value instanceof Integer) {
            strValue = ((Integer) value).toString();
        } else if(value instanceof Long) {
            strValue = ((Long) value).toString();
        } else if(value instanceof Float) {
            strValue = ((Float) value).toString();
        } else if(value instanceof Double) {
            strValue = ((Double) value).toString();
        } else if(value instanceof Boolean) {
            strValue = ((Boolean) value).toString();
        } else if(value instanceof Date) {
            DateFormat format = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(Constants.DATE_TIMEZONE));
            strValue = format.format((Date) value);
        } else {
            strValue = value.toString();
        }

        return this.put(key, strValue);
    }

    public String put(String key, String value) {
        if(StringUtils.areNotEmpty(key, value)) {
            return super.put(key, value);
        } else {
            return null;
        }
    }
}
