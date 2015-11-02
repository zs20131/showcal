package net.showcal.api;

import java.util.Map;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api
 *  Description:Api 上传接口，支持同时上传多个文件。
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api
 * </pre>
 */
public interface XiniuUploadRequest<T extends XiniuResponse> extends XiniuRequest {
    /**
     * 获取所有的Key-Value形式的文件请求参数集合。其中：
     * <ul>
     * <li>Key: 请求参数名</li>
     * <li>Value: 请求参数文件元数据</li>
     * </ul>
     *
     * @return 文件请求参数集合
     */
    public Map<String, FileItem> getFileParams();
}
