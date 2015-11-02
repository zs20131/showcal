package com.showcal.foundation.request;

import com.showcal.foundation.domain.UploadTypeEnum;
import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by DEV001 on 2014/8/14.
 */
public class FileUploadRequest extends BaseRequest {

    /**
     * 图片对象
     */
    @NotNull
    private byte[] fileStream;

    /**
     * 类型
     */
    @NotNull
    private UploadTypeEnum type;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件后缀
     */
    private String fileExt;

    public byte[] getFileStream() {
        return fileStream;
    }

    public void setFileStream(byte[] fileStream) {
        this.fileStream = fileStream;
    }

    public UploadTypeEnum getType() {
        return type;
    }

    public void setType(UploadTypeEnum type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }
}
