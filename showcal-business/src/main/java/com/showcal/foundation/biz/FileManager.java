/**
 * @(#)FileManager.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * XINIU. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  XINIU.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with XINIU.
 */
package com.showcal.foundation.biz;

import com.showcal.foundation.request.FileGetRequest;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.request.FilePathListGetRequest;
import com.showcal.foundation.request.FileUploadRequest;
import com.showcal.foundation.response.FileGetResponse;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.response.FilePathListGetResponse;
import com.showcal.foundation.response.FileUploadResponse;
import com.xiniunet.framework.security.Passport;


/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
public interface FileManager {

    /**
     * 按主键ID删除记录
     *
     * @param id 主键
     * @return 受影响的记录条数
     */
    long delete(Long id, Passport passport);

    /**
     * 上传logo文件
     *
     * @param req      上传logo文件请求
     * @param passport 用户护照
     * @return 上传文件应答
     */
    FileUploadResponse uploadFile(FileUploadRequest req, Passport passport);


    /**
     * 获取文件路径
     *
     * @param req      获取文件路径请求
     * @param passport 用户护照
     * @return 文件路径应答
     */
    FilePathGetResponse getFilePath(FilePathGetRequest req, Passport passport);

    /**
     * 获取文件路径
     *
     * @param req      获取文件路径请求
     * @param passport 用户护照
     * @return 文件路径应答
     */
    FilePathListGetResponse getFilePathList(FilePathListGetRequest req, Passport passport);

    /**
     * 获取阿里云上面的文件
     * @param request 获取阿里云上面的文件请求
     * @return 文件流应答
     */
    FileGetResponse getFile(FileGetRequest request);
}
