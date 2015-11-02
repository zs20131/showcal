package net.showcal.api.internal.parser.xml;

import net.showcal.api.ApiException;
import net.showcal.api.XiniuParser;
import net.showcal.api.XiniuResponse;
import net.showcal.api.internal.mapping.Converter;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api.internal.parser.xml
 *  Description:
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api.internal.parser.xml
 * </pre>
 */
public class ObjectXmlParser<T extends XiniuResponse> implements XiniuParser<T> {
    private Class<T> clazz;

    public ObjectXmlParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T parse(String rsp) throws ApiException {
        Converter converter = new XmlConverter();
        return converter.toResponse(rsp, clazz);
    }

    public Class<T> getResponseClass() {
        return clazz;
    }
}
