package net.showcal.open.api.request;

import com.xiniunet.apiframework.AbstractApiRequest;
import com.xiniunet.apiframework.request.FileItem;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.open.api.request
 *  Description: 附件上传接口
 * ***************************************************************
 *  10/11 0011  V1.0  xiniu    New Files for net.showcal.open.api.request
 * </pre>
 */
public class AttachmentUploadRequest extends AbstractApiRequest {
    private FileItem fileData;
    private String name;
    private String type;

    public FileItem getFileData() {
        return fileData;
    }

    public void setFileData(FileItem fileData) {
        this.fileData = fileData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
