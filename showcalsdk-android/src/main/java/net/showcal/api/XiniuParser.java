package net.showcal.api;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api
 *  Description:响应解释器接口。响应格式可以是JSON, XML等等。
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api
 * </pre>
 */
public interface XiniuParser<T extends XiniuResponse> {
    /**
     * 把响应字符串解释成相应的领域对象。
     *
     * @param rsp 响应字符串
     * @return 领域对象
     */
    public T parse(String rsp) throws ApiException;

    /**
     * 获取响应类类型。
     */
    public Class<T> getResponseClass() throws ApiException;
}
