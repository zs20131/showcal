package net.showcal.api.internal.parser.json;

import net.showcal.api.ApiException;
import net.showcal.api.XiniuParser;
import net.showcal.api.XiniuResponse;
import net.showcal.api.internal.mapping.Converter;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api.internal.parser.json
 *  Description:
 * ***************************************************************
 *  11/27 0027  V1.0  xiniunet    New Files for com.xiniunet.api.internal.parser.json
 * </pre>
 */
public class ObjectJsonParser<T extends XiniuResponse> implements XiniuParser<T> {
    private Class<T> clazz;
    private boolean simplify;

    public ObjectJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public ObjectJsonParser(Class<T> clazz, boolean simplify) {
        this.clazz = clazz;
        this.simplify = simplify;
    }

    @Override
    public T parse(String rsp) throws ApiException {
        Converter converter = new JsonConverter();
        return converter.toResponse(rsp, clazz);
    }

    @Override
    public Class<T> getResponseClass() throws ApiException {
        return clazz;
    }
}
