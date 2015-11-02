package com.showcal.foundation.response;

import com.xiniunet.framework.base.BaseResponse;

import java.util.Map;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
public class FilePathListGetResponse extends BaseResponse {

    Map<Long,String> filePathMap;

    public Map<Long, String> getFilePathMap() {
        return filePathMap;
    }

    public void setFilePathMap(Map<Long, String> filePathMap) {
        this.filePathMap = filePathMap;
    }
}
