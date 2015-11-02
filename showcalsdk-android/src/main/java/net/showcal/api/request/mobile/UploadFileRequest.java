package net.showcal.api.request.mobile;


import net.showcal.api.ApiRuleException;
import net.showcal.api.FileItem;
import net.showcal.api.XiniuUploadRequest;
import net.showcal.api.domain.mobile.UploadTypeEnum;
import net.showcal.api.internal.util.RequestCheckUtils;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.UploadFileResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api.request.file
 *  Description:
 * ***************************************************************
 *  5/13 0013  V1.0  xiniu    New Files for com.xiniunet.api.request.file
 * </pre>
 */
public class UploadFileRequest implements XiniuUploadRequest<UploadFileResponse> {
    private XiniuHashMap udfParams;
    private Long timestamp;

    @Override
    public String getApiMethodName() {
        return "mobile.attachment.upload";
    }

    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("name", this.name);
        txtParams.put("type", this.type.toString());
        if (this.udfParams != null) {
            txtParams.putAll(this.udfParams);
        }
        return txtParams;
    }

    @Override
    public Long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public Class getResponseClass() {

        return UploadFileResponse.class;
    }

    @Override
    public void check() throws ApiRuleException {
        RequestCheckUtils.checkNotEmpty(this.fileData, "fileData");
        RequestCheckUtils.checkNotEmpty(this.name, "name");
        RequestCheckUtils.checkMaxLength(this.name, 50, "name");
    }

    @Override
    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    @Override
    public void putOtherTextParam(String key, String value) {
        if (this.udfParams == null) {
            this.udfParams = new XiniuHashMap();
        }
        this.udfParams.put(key, value);
    }


    private FileItem fileData;
    private String name;
    private UploadTypeEnum type;

    private Map<String, String> headerMap = new XiniuHashMap();

    @Override
    public Map<String, FileItem> getFileParams() {
        Map params = new HashMap();
        params.put("fileData", this.fileData);
        return params;
    }

    public UploadTypeEnum getType() {
        return type;
    }

    public void setType(UploadTypeEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileItem getFileData() {
        return fileData;
    }

    public void setFileData(FileItem fileData) {
        this.fileData = fileData;
    }
}
