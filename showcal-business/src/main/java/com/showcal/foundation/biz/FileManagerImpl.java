/**
 * @(#)File.java
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

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.OSSObject;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.showcal.foundation.dal.FileMapper;
import com.showcal.foundation.po.FilePO;
import com.showcal.foundation.request.FileGetRequest;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.request.FilePathListGetRequest;
import com.showcal.foundation.request.FileUploadRequest;
import com.showcal.foundation.response.FileGetResponse;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.response.FilePathListGetResponse;
import com.showcal.foundation.response.FileUploadResponse;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
@Transactional
@Service
public class FileManagerImpl extends BaseManagerImpl implements FileManager {

    /**
     * 文件操作dal类
     */
    @Autowired
    private FileMapper fileMapper;

    /**
     * 获取ID服务类
     */
    @Autowired
    private SequenceManager sequenceManager;

//    /**
//     * 插入记录.
//     *
//     * @param file 实体对象
//     * @return 实体对象的ID
//     */
//    @Override
//    public long insert(File file,Passport passport) {
//
//        FilePO entity=this.getMapper().map(file, FilePO.class);
//        fileMapper.insert(entity,passport);
//        return 0;
//    }

    /**
     * 按主键ID删除记录
     *
     * @param id 主键
     * @return 受影响的记录条数
     */
    @Override
    public long delete(Long id, Passport passport) {
        return fileMapper.delete(id, passport);
    }

    /**
     * 上传文件
     *
     * @param req      上传logo文件请求
     * @param passport 用户护照
     * @return 上传文件应答
     */
    @Override
    public FileUploadResponse uploadFile(FileUploadRequest req, Passport passport) {
        String bucketName = "";
        String urlPath = "";
        String AccessKeyId = "";
        String AccessKeySecret = "";
        String imgUrl = "";

        FileUploadResponse response = new FileUploadResponse();

        Properties prop = new Properties();
        InputStream in = FileManagerImpl.class.getResourceAsStream("/config.properties");
        try {
            prop.load(in);
            bucketName = prop.getProperty("aliyun.oss.bucket.name").trim();
            urlPath = prop.getProperty("aliyun.oss.url").trim();
            AccessKeyId = prop.getProperty("aliyun.accesskey.id").trim();
            AccessKeySecret = prop.getProperty("aliyun.accesskey.secret").trim();
            imgUrl = prop.getProperty("aliyun.img.url").trim();
        } catch (IOException e) {
            e.printStackTrace();
            response.addError(ErrorType.SYSTEM_ERROR, "配置文件读取出错");
            return response;
        }

        OSSClient client;
        if (!"production".equals(prop.getProperty("deploy.mode")) && !"test".equals(prop.getProperty("deploy.mode"))) {
            // 初始化一个OSSClient(非生产环境不需要设置服务器地址)
            System.out.println("-----> 开发测试环境 上传地址为：http://oss-cn-shanghai.aliyuncs.com");
            client = new OSSClient("http://oss-cn-shanghai.aliyuncs.com",AccessKeyId, AccessKeySecret);
        } else {
            // 初始化一个OSSClient（生产环境设置阿里云的内网地址）
            //oss-cn-shanghai-internal.aliyuncs.com
            System.out.println("-----> 生产环境 上传地址为：http://oss-cn-shanghai-internal.aliyuncs.com");
            client = new OSSClient("http://oss-cn-shanghai-internal.aliyuncs.com", AccessKeyId, AccessKeySecret);
        }
        Long id = sequenceManager.getNewId();
        // 如果文件名为空，则以唯一ID作为文件名
        if (req.getFileName() == null || req.getFileName().equals("")) {
            req.setFileName(id.toString());
        }
        String outputFilePath;
        String fileUrl;

        switch (req.getType()) {
            case LOGO:
                outputFilePath = "/logo.jpg";
                req.setFileExt("jpg");
                break;
            case TITLE:
                outputFilePath = "/title.png";
                req.setFileExt("png");
                break;
            case AVATAR:
            case PHOTO:
                outputFilePath = req.getType().toString().toLowerCase()
                        + "/" + id.toString() + ".jpg";
                req.setFileExt("jpg");
                break;
            case ICON:
                outputFilePath = "icon/application/" + req.getFileName() + ".png";
                req.setFileExt("png");
                break;
            default:
                if (req.getFileExt() == null || req.getFileExt().isEmpty()) {
                    response.addError("ERR_MISSING_ARGUMENT", "文件扩展名不能为空");
                    return response;
                }
                outputFilePath = req.getType().toString().toLowerCase() + "/"
                        + id + "." + req.getFileExt();
                break;
        }
        fileUrl = urlPath + outputFilePath;

        InputStream content = new ByteArrayInputStream(req.getFileStream());

        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();

        // 必须设置ContentLength
        meta.setContentLength(req.getFileStream().length);

        // 上传Object.
        client.putObject(bucketName, outputFilePath, content, meta);

        // 将文件保存到数据库
        FilePO filePO = new FilePO();
        filePO.setId(id);
        filePO.setExtension(req.getFileExt());
        filePO.setName(req.getFileName());
        filePO.setSize((long) req.getFileStream().length);
        filePO.setStoragePath(outputFilePath);

        fileMapper.insert(filePO, passport);

        // 将文件保存路径返回给调用者
        // 如果是图片文件，那么需要通过阿里云的图片处理服务，得到另外一个URL
        if (req.getFileExt() != null && (req.getFileExt().endsWith("png") || req.getFileExt().endsWith("jpg"))) {
            fileUrl = imgUrl + outputFilePath;
        }
        response.setUrl(fileUrl);
        response.setId(id);
        response.setDisplayName(req.getFileName() + "." + req.getFileExt());
        return response;
    }

    @Override
    public FilePathGetResponse getFilePath(FilePathGetRequest req, Passport passport) {
        FilePathGetResponse response = new FilePathGetResponse();
        FilePO filePO = fileMapper.getById(req.getId(), passport);

        if (filePO != null) {

            Properties prop = new Properties();
            InputStream in = FileManagerImpl.class.getResourceAsStream("/config.properties");
            String urlPath = "";
            String imgUrl = "";
            try {
                prop.load(in);
                urlPath = prop.getProperty("aliyun.oss.url").trim();
                imgUrl = prop.getProperty("aliyun.img.url").trim();
            } catch (IOException e) {
                e.printStackTrace();
                response.addError(ErrorType.SYSTEM_ERROR, "配置文件读取出错");
            }

            String url = "";
            if (filePO.getExtension() != null
                    && (filePO.getExtension().endsWith("png") || filePO.getExtension().endsWith("jpg"))) {
                url = imgUrl + filePO.getStoragePath();
            } else {
                if (filePO.getStoragePath() != null) {
                    String filePath = filePO.getStoragePath();
                    String extension = filePath.substring(filePath.lastIndexOf('.'));
                    // 兼容老的上传图片，如果扩展名为空，且文件后缀是png,jpg的话，仍然显示img的域名
                    if (extension.endsWith("png") || extension.endsWith("jpg")) {
                        url = imgUrl + filePO.getStoragePath();
                    } else {
                        url = urlPath + filePO.getStoragePath();
                    }
                } else {
                    url = urlPath + filePO.getStoragePath();
                }
            }
            response.setUrl(url);
            response.setDisplayName(filePO.getName() + "." + filePO.getExtension());
        }
        return response;
    }

    /**
     * 获取文件路径
     *
     * @param req      获取文件路径请求
     * @param passport 用户护照
     * @return 文件路径应答
     */
    @Override
    public FilePathListGetResponse getFilePathList(FilePathListGetRequest req, Passport passport) {
        FilePathListGetResponse response = new FilePathListGetResponse();
        List<FilePO> filePOs = new ArrayList<>();
        filePOs = fileMapper.getListByIds(req.getIds(), passport);
        Map<Long, String> filePathMap = new HashMap<>();

        for (FilePO filePO : filePOs) {
            if (filePO != null) {

                Properties prop = new Properties();
                InputStream in = FileManagerImpl.class.getResourceAsStream("/config.properties");
                String urlPath = "";
                String imgUrl = "";
                try {
                    prop.load(in);
                    urlPath = prop.getProperty("aliyun.oss.url").trim();
                    imgUrl = prop.getProperty("aliyun.img.url").trim();
                } catch (IOException e) {
                    e.printStackTrace();
                    response.addError(ErrorType.SYSTEM_ERROR, "配置文件读取出错");
                }

                String url = "";
                if (filePO.getExtension() != null
                        && (filePO.getExtension().equals("png") || filePO.getExtension().equals("jpg"))) {
                    url = imgUrl + filePO.getStoragePath();
                } else {
                    if (filePO.getStoragePath() != null) {
                        String filePath = filePO.getStoragePath();
                        String extension = filePath.substring(filePath.lastIndexOf('.'));
                        // 兼容老的上传图片，如果扩展名为空，且文件后缀是png,jpg的话，仍然显示img的域名
                        if (extension.equals("png") || extension.equals("jpg")) {
                            url = imgUrl + filePO.getStoragePath();
                        } else {
                            url = urlPath + filePO.getStoragePath();
                        }
                    } else {
                        url = urlPath + filePO.getStoragePath();
                    }
                }
                filePathMap.put(filePO.getId(), url);
                //response.setUrl(url);
                //response.setDisplayName(filePO.getName() + "." + filePO.getExtension());
            }
        }
        response.setFilePathMap(filePathMap);
        return response;
    }

    @Override
    public FileGetResponse getFile(FileGetRequest request) {
        String bucketName = "";
        String urlPath = "";
        String accessKeyId = "";
        String accessKeySecret = "";

        FileGetResponse response = new FileGetResponse();

        Properties prop = new Properties();
        InputStream in = FileManagerImpl.class.getResourceAsStream("/config.properties");
        try {
            prop.load(in);
            bucketName = prop.getProperty("aliyun.oss.bucket.name").trim();
            urlPath = prop.getProperty("aliyun.oss.url").trim();
            accessKeyId = prop.getProperty("aliyun.accesskey.id").trim();
            accessKeySecret = prop.getProperty("aliyun.accesskey.secret").trim();
        } catch (IOException e) {
            e.printStackTrace();
            response.addError(ErrorType.SYSTEM_ERROR, "配置文件读取出错");
        }

        // 初始化一个OSSClient
        OSSClient client = new OSSClient(accessKeyId, accessKeySecret);


        OSSObject ossObject = client.getObject(bucketName, request.getUrl().substring(urlPath.length()));

        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[1000]; //buff用于存放循环读取的临时数据
        int rc = 0;

        try {
            while ((rc = ossObject.getObjectContent().read(buff, 0, 1000)) > 0) {
                swapStream.write(buff, 0, rc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = swapStream.toByteArray();
        response.setBytes(bytes);

        return response;

    }
}
