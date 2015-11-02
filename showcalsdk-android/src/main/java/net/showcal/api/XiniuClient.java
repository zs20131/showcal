package net.showcal.api;


/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api
 *  Description:
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api
 * </pre>
 */
public interface XiniuClient {
    /**
     * 执行API公开的请求
     *
     * @param request
     * @param <T>
     * @return
     * @throws net.showcal.api.ApiException
     */
    public <T extends XiniuResponse> T execute(XiniuRequest<T> request) throws ApiException;

    /**
     * 执行API隐私的请求
     *
     * @param request
     * @param session
     * @param <T>
     * @return
     * @throws net.showcal.api.ApiException
     */
    public <T extends XiniuResponse> T execute(XiniuRequest<T> request, String session) throws ApiException;
}
