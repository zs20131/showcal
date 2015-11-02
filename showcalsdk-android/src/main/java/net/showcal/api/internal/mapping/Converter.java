package net.showcal.api.internal.mapping;

import net.showcal.api.ApiException;
import net.showcal.api.XiniuResponse;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: conet.showcal.api.ternal.mapping
 *  Description:动态格式转换器。
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api.internal.mapping
 * </pre>
 */
public interface Converter {
    /**
     * 把字符串转换为响应对象。
     *
     * @param <T>   领域泛型
     * @param rsp   响应字符串
     * @param clazz 领域类型
     * @return 响应对象
     */
    public <T extends XiniuResponse> T toResponse(String rsp, Class<T> clazz) throws ApiException;
}
