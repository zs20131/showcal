/**
 * @(#)Attachment.java
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

import com.showcal.foundation.dal.AttachmentMapper;
import com.showcal.foundation.domain.Attachment;
import com.showcal.foundation.domain.UploadTypeEnum;
import com.showcal.foundation.po.AttachmentPO;
import com.showcal.foundation.po.AttachmentSO;
import com.showcal.foundation.po.AttachmentWithFilePO;
import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
@Transactional
@Service
public class AttachmentManagerImpl extends BaseManagerImpl implements AttachmentManager {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private FileManager fileManager;

    @Autowired
    private SequenceManager sequenceManager;

    /**
     * 上传附件
     *
     * @param req      上传附件请求
     * @param passport 用户护照
     * @return 上传附件应答
     */
    public AttachmentUploadResponse uploadAttachment(AttachmentUploadRequest req, Passport passport) {
        AttachmentPO attachmentPO = new AttachmentPO();
        AttachmentUploadResponse response = new AttachmentUploadResponse();
        Attachment attachment = new Attachment();
        // 获取附件表主键编号
        Long attachmentId = sequenceManager.getNewId();

        // 获取并设定主键
        attachmentPO.setId(attachmentId);
        // 设定业务类型
        attachmentPO.setBusinessType(req.getBusinessType());
        // 设定业务主键
        attachmentPO.setBusinessId(req.getBusinessId());
        // 设定业务类别
        attachmentPO.setBusinessCategory(req.getBusinessCategory());
        // 设定承租人ID
//        attachmentPO.setTenantId(passport.getTenantId());

        if (req.getFileStream() != null) {
            FileUploadRequest fileUploadRequest = new FileUploadRequest();
            fileUploadRequest.setFileStream(req.getFileStream());
            fileUploadRequest.setFileExt(req.getFileExt());
            fileUploadRequest.setFileName(req.getFileName());
            fileUploadRequest.setType(UploadTypeEnum.ATTACHMENT);

            FileUploadResponse fileUploadResponse = fileManager.uploadFile(fileUploadRequest, passport);

            if (fileUploadResponse.hasError()) {
                response.addErrors(fileUploadResponse.getErrors());
                return response;
            }

            attachmentPO.setFileId(fileUploadResponse.getId());

            // 插入附件表
            attachmentMapper.insert(attachmentPO, passport);
            attachment.setFilePath(fileUploadResponse.getUrl());
        } else {
            // 插入附件表
            attachmentMapper.insert(attachmentPO, passport);
        }
        attachment.setId(attachmentId);
        attachment.setDisplayName(req.getFileName()+"."+req.getFileExt());
        response.setAttachment(attachment);
        return response;
    }

    @Override
    public AttachmentUploadByFileIdResponse uploadAttachmentByFileId(AttachmentUploadByFileIdRequest req, Passport passport) {

        AttachmentPO attachmentPO = new AttachmentPO();
        AttachmentUploadByFileIdResponse response = new AttachmentUploadByFileIdResponse();
        Attachment attachment = new Attachment();
        // 获取附件表主键编号
        Long attachmentId = sequenceManager.getNewId();

        // 获取并设定主键
        attachmentPO.setId(attachmentId);
        // 设定业务类型
        attachmentPO.setBusinessType(req.getBusinessType());
        // 设定业务主键
        attachmentPO.setBusinessId(req.getBusinessId());
        // 设定业务类别
        attachmentPO.setBusinessCategory(req.getBusinessCategory());
        // 设定承租人ID
        attachmentPO.setTenantId(passport.getTenantId());

        attachmentPO.setFileId(req.getFileId());

        attachmentMapper.insert(attachmentPO, passport);

        attachment.setId(attachmentId);

        FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
        filePathGetRequest.setId(req.getFileId());
        FilePathGetResponse filePathGetResponse = fileManager.getFilePath(filePathGetRequest, passport);

        attachment.setDisplayName(filePathGetResponse.getDisplayName());
        attachment.setFilePath(filePathGetResponse.getUrl());

        response.setAttachment(attachment);

        return response;
    }

    /**
     * 删除附件
     *
     * @param req      删除附件请求
     * @param passport 用户护照
     * @return 删除附件应答
     */
    public AttachmentDeleteResponse deleteAttachment(AttachmentDeleteRequest req, Passport passport) {

        AttachmentDeleteResponse response = new AttachmentDeleteResponse();
        // 查询获取文件表关联的主键
        AttachmentPO attachmentPO = attachmentMapper.getById(req.getAttachmentId(), passport);

        // 如果未查询到记录，则不作删除处理
        if (attachmentPO == null) {
            return response;
        }
        // 获得文件ID
        Long fileId = attachmentPO.getFileId();

        // 执行删除附件操作
        attachmentMapper.delete(req.getAttachmentId(), passport);

        // 文件表主键不为空时，执行删除文件操作
        if (fileId != null) {
            fileManager.delete(fileId, passport);
        }
        return response;
    }

    /**
     * 获取附件列表
     *
     * @param req      获取附件列表请求
     * @param passport 用户护照
     * @return 附件列表应答
     */
    public AttachmentGetByBizInfoResponse getAttachmentsByBizInfo(AttachmentGetByBizInfoRequest req, Passport passport) {
        AttachmentGetByBizInfoResponse response = new AttachmentGetByBizInfoResponse();
        AttachmentSO attachmentSO = new AttachmentSO();

        // 设定业务主键
        attachmentSO.setBusinessId(req.getBusinessId());
        // 设定业务类型
        attachmentSO.setBusinessType(req.getBusinessType());
        // 设定业务类别
        attachmentSO.setBusinessCategory(req.getBusinessCategory());

        // 取得附件列表（包含文件信息）
        List<AttachmentWithFilePO> entityList = attachmentMapper.getAttachmentListWithFile(attachmentSO, passport);

        // 将文件信息整理后返回
        List<Attachment> modelList = new ArrayList<>();
        Properties prop = new Properties();
        InputStream in = AttachmentManagerImpl.class.getResourceAsStream("/config.properties");
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

        for (AttachmentWithFilePO entity : entityList) {
            // 通过反射获取附件信息对象
            Attachment attachmentWithFile = this.getMapper().map(entity, Attachment.class);
            // 组装文件的存储路径

            String url;
            if(entity.getExtension()!=null&&(entity.getExtension().equals("png")||entity.getExtension().equals("jpg"))){
                url = imgUrl + entity.getStoragePath();
            }else{
                url = urlPath + entity.getStoragePath();
            }
            attachmentWithFile.setFilePath(url);
            attachmentWithFile.setDisplayName(entity.getName() + "." + entity.getExtension());
            modelList.add(attachmentWithFile);
        }
        response.setAttachmentList(modelList);
        return response;
    }

    /**
     * 更新一批附件的Business编号
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public AttachmentUpdateBusinessResponse updateBusiness(AttachmentUpdateBusinessRequest request, Passport passport) {
        AttachmentUpdateBusinessResponse response = new AttachmentUpdateBusinessResponse();
        Long result = attachmentMapper.updateBusiness(request, passport);
        response.setResult(result);
        return response;
    }

    /**
     * 通过Business编号复制复件
     *
     * @param request  复制请求
     * @param passport 护照信息
     * @return 复制结果
     * @since 2.1.0
     */
    @Override
    public AttachmentsCopyByBusinessIdResponse copyByBusinessId(AttachmentCopyByBusinessIdRequest request, Passport passport) {
        AttachmentsCopyByBusinessIdResponse response = new AttachmentsCopyByBusinessIdResponse();
        AttachmentSO attachmentSO = new AttachmentSO();

        // 设定业务主键
        attachmentSO.setBusinessId(request.getSourceId());
        // 设定业务类型
        attachmentSO.setBusinessType(request.getBusinessType());
        // 设定业务类别
        attachmentSO.setBusinessCategory(request.getBusinessCategory());

        List<AttachmentWithFilePO> entityList = attachmentMapper.getAttachmentListWithFile(attachmentSO, passport);
        if( ! entityList.isEmpty()) {
            List<AttachmentPO> attachmentPOList = new ArrayList<>();

            IdsGetResponse idsGetResponse = sequenceManager.getNewIds(new IdsGetRequest(entityList.size()));
            List<Long> ids = idsGetResponse.getIds();
            int index = 0;
            for(AttachmentWithFilePO po : entityList) {
                AttachmentPO attachmentPO = new AttachmentPO();
                attachmentPO.setId(ids.get(index++));
                attachmentPO.setBusinessId(request.getTargetId());
                attachmentPO.setBusinessCategory(po.getBusinessCategory());
                attachmentPO.setBusinessType(po.getBusinessType());
                attachmentPO.setFileId(po.getFileId());
                attachmentPO.setTenantId(po.getTenantId());

                attachmentPOList.add(attachmentPO);
            }
            Long result = attachmentMapper.insertBatch(attachmentPOList, passport);
            response.setResult(result);
        }
        return response;
    }
}
