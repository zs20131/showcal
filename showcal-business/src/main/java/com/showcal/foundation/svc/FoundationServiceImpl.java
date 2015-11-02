package com.showcal.foundation.svc;

import com.showcal.foundation.biz.*;
import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.biz.SettingDiseaseManager;
import com.showcal.platform.request.SettingDiseaseAppGetAllListRequest;
import com.showcal.platform.request.SettingDiseaseGetAllListRequest;
import com.showcal.platform.response.SettingDiseaseAppGetAllListResponse;
import com.showcal.platform.response.SettingDiseaseGetAllListResponse;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.TypeTransferUtil;
import com.xiniunet.framework.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.foundation.svc
 *  Description: 基准数据包
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.foundation.svc
 * </pre>
 */
public class FoundationServiceImpl implements FoundationService {
    // 序列号服务
    @Autowired
    private SequenceManager sequenceManager;
    // 存储服务
    @Autowired
    private AttachmentManager attachmentManager;

    // 邮件服务
    @Autowired
    private MailManager mailManager;

    // 消息服务
    @Autowired
    private MessageManager messageManager;
    // 文件管理
    @Autowired
    private FileManager fileManager;
    // 短信发送
    @Autowired
    private SmsManager smsManager;
    // 评论管理
    @Autowired
    private CommentManager commentManager;
    // 特殊情况
    @Autowired
    private SettingDiseaseManager settingDiseaseManager;

    @Override
    public Long getNewId() {
        return sequenceManager.getNewId();
    }

    @Override
    public IdsGetResponse getNewIds(IdsGetRequest req) {
        return sequenceManager.getNewIds(req);
    }

    @Override
    public AttachmentUploadResponse uploadAttachment(AttachmentUploadRequest req, Passport passport) {
        AttachmentUploadResponse response = new AttachmentUploadResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return attachmentManager.uploadAttachment(req, passport);
    }

    @Override
    public AttachmentUploadByFileIdResponse uploadAttachmentByFileId(AttachmentUploadByFileIdRequest req, Passport passport) {
        AttachmentUploadByFileIdResponse response = new AttachmentUploadByFileIdResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return attachmentManager.uploadAttachmentByFileId(req, passport);
    }

    @Override
    public AttachmentUpdateBusinessResponse updateAttachmentBusiness(AttachmentUpdateBusinessRequest request, Passport passport) {
        return attachmentManager.updateBusiness(request, passport);
    }

    @Override
    public AttachmentsCopyByBusinessIdResponse copyAttachmentsByBusinessId(AttachmentCopyByBusinessIdRequest request, Passport passport) {
        return attachmentManager.copyByBusinessId(request, passport);
    }

    @Override
    public AttachmentDeleteResponse deleteAttachment(AttachmentDeleteRequest req, Passport passport) {
        AttachmentDeleteResponse response = new AttachmentDeleteResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }

        // 执行删除附件操作
        return attachmentManager.deleteAttachment(req, passport);
    }

    @Override
    public AttachmentGetByBizInfoResponse getAttachmentsByBizInfo(AttachmentGetByBizInfoRequest req, Passport passport) {
        AttachmentGetByBizInfoResponse response = new AttachmentGetByBizInfoResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }

        // 执行取得附件列表操作
        return attachmentManager.getAttachmentsByBizInfo(req, passport);
    }

    @Override
    public SequenceGetNextResponse getNextSequence(SequenceGetNextRequest req, Passport passport) {
        SequenceGetNextResponse response = new SequenceGetNextResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }

        return sequenceManager.getNextSequence(req, passport);
    }

    @Override
    public SequenceListGetResponse getSequenceList(SequenceListGetRequest req, Passport passport) {
        SequenceListGetResponse response = new SequenceListGetResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        TypeTransferUtil<SequenceGetNextRequest> t = new TypeTransferUtil<>();
        SequenceGetNextRequest sequenceGetNextRequest = t.transfer(req, SequenceGetNextRequest.class);
        List<String> numberList = new ArrayList<>();
        for (int i = 0; i < req.getCount(); i++) {
            SequenceGetNextResponse sequenceGetNextResponse =
                    sequenceManager.getNextSequence(sequenceGetNextRequest, passport);
            numberList.add(sequenceGetNextResponse.getSeqNumber());
        }
        response.setSeqNumberList(numberList);
        return response;
    }

    @Override
    public MailSendResponse sendMail(MailSendRequest req, Passport passport) {
        MailSendResponse response = new MailSendResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return mailManager.sendMail(req, passport);
    }

    @Override
    public MessageCreateResponse createMessage(MessageCreateRequest req, Passport passport) {
        MessageCreateResponse response = new MessageCreateResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return messageManager.insert(req, passport);
    }

    @Override
    public MessageGetUnreadListResponse getUnreadMessageList(MessageGetUnreadListRequest req, Passport passport) {
        MessageGetUnreadListResponse response = new MessageGetUnreadListResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return messageManager.getUnreadList(req, passport);
    }

    @Override
//    @Cache(moduleName = CacheName.MODULE_NAME, modelName = CacheName.MESSAGE)
    public MessageGetReadedListResponse getReadedMessageList(MessageGetReadedListRequest req, Passport passport) {
        MessageGetReadedListResponse response = new MessageGetReadedListResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return messageManager.getReadedList(req, passport);
    }

    @Override
    public MessageGetResponse getMessage(MessageGetRequest req, Passport passport) {
        MessageGetResponse response = new MessageGetResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return messageManager.get(req, passport);
    }

    @Override
    public MessageReadResponse readMessage(MessageReadRequest req, Passport passport) {
        MessageReadResponse response = new MessageReadResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return messageManager.read(req, passport);
    }

    @Override
    public FileUploadResponse uploadFile(FileUploadRequest req, Passport passport) {
        FileUploadResponse response = new FileUploadResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return fileManager.uploadFile(req, passport);
    }

    @Override
    public FileGetResponse getFile(FileGetRequest req) {
        FileGetResponse response = new FileGetResponse();
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return fileManager.getFile(req);
    }

    @Override
    public FilePathGetResponse getFilePath(FilePathGetRequest req, Passport passport) {
        return fileManager.getFilePath(req, passport);
    }

    @Override
    public FilePathListGetResponse getFilePathList(FilePathListGetRequest req, Passport passport) {
        FilePathListGetResponse response = new FilePathListGetResponse();
        // 如果ids列表为空，直接返回
        if (req.getIds() == null || req.getIds().isEmpty()) {
            return response;
        }
        ValidationUtil.validate(req, response);
        if (response.hasError()) {
            return response;
        }
        return fileManager.getFilePathList(req, passport);
    }

    @Override
    public SmsGetResponse getSms(SmsGetRequest request, Passport passport) {
        SmsGetResponse response = new SmsGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = smsManager.get(request, passport);
        return response;
    }

    @Override
    public SmsFindResponse findSms(SmsFindRequest request, Passport passport) {
        SmsFindResponse response = new SmsFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = smsManager.find(request, passport);
        return response;
    }


    @Override
    public SmsDeleteResponse deleteSms(SmsDeleteRequest request, Passport passport) {
        SmsDeleteResponse response = new SmsDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = smsManager.delete(request, passport);
        return response;
    }

    @Override
    public SmsSendResponse sendSms(SmsSendRequest request, Passport passport) {
        SmsSendResponse response = new SmsSendResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        response = smsManager.send(request, passport);
        return response;
    }

    @Override
    public CommentRecordCreateResponse createCommentRecord(CommentRecordCreateRequest request, Passport passport) {
        CommentRecordCreateResponse response = new CommentRecordCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return commentManager.insert(request, passport);
    }

    @Override
    public CommentRecordDeleteResponse deleteCommentRecord(CommentRecordDeleteRequest request, Passport passport) {
        CommentRecordDeleteResponse response = new CommentRecordDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return commentManager.updateDeleteStatus(request, passport);
    }

    @Override
    public CommentRecordListGetResponse getCommentRecordList(CommentRecordListGetRequest request) {
        CommentRecordListGetResponse response = new CommentRecordListGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return commentManager.getByBusinessId(request);
    }

    @Override
    public CommentRecordLikeResponse likeCommentRecord(CommentRecordLikeRequest request, Passport passport) {
        CommentRecordLikeResponse response = new CommentRecordLikeResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return commentManager.likeComment(request, passport);
    }

    @Override
    public CommentRecordCancleLikeResponse cancleLikeCommentRecord(CommentRecordCancleLikeRequest request, Passport passport) {
        CommentRecordCancleLikeResponse response = new CommentRecordCancleLikeResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return commentManager.cancleLikeComment(request, passport);
    }

    @Override
    public CommentRecordGetResponse getCommentRecord(CommentRecordGetRequest request, Passport passport) {
        CommentRecordGetResponse response = new CommentRecordGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return commentManager.getCommentRecordById(request, passport);
    }

    @Override
    public SettingDiseaseGetAllListResponse getSettingDiseaseList(SettingDiseaseGetAllListRequest request, Passport passport) {
        SettingDiseaseGetAllListResponse response = new SettingDiseaseGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingDiseaseManager.getAllList(request, passport);
    }

    @Override
    public SettingDiseaseAppGetAllListResponse getAppSettingDiseaseList(SettingDiseaseAppGetAllListRequest request, Passport passport) {
        SettingDiseaseAppGetAllListResponse response = new SettingDiseaseAppGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return settingDiseaseManager.getAppAllList(request, passport);
    }
}
