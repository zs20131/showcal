package net.showcal.api.internal.parser.json;

import com.alibaba.fastjson.JSON;
import net.showcal.api.ApiException;
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
public class JsonConverter implements Converter {
    @Override
    public <T extends XiniuResponse> T toResponse(String rsp, Class<T> clazz) throws ApiException {
        return (T) JSON.parseObject(rsp, clazz);
    }
}
