package net.showcal.foundation.helper;

import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.showcal.foundation.service.FoundationService;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.foundation.helper.FoundationHelperImpl
 *  Description: foundation Helper 实现类
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
@Component
public class FoundationHelperImpl implements FoundationHelper {
    @Autowired
    private FoundationService foundationService;

    /**
     * 取得序列号
     *
     * @return
     */
    @Override
    public Long getNewId() {
        return foundationService.getNewId();
    }

    /**
     * 获取一批ID
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public IdsGetResponse getNewIds(IdsGetRequest request, Passport passport) {
        return foundationService.getNewIds(request);
    }

    /**
     * 上传附件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public AttachmentUploadResponse uploadAttachment(AttachmentUploadRequest request, Passport passport) {
        return foundationService.uploadAttachment(request, passport);
    }

    /**
     * 根据已经存在的文件Id上传附件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public AttachmentUploadByFileIdResponse uploadAttachmentByFileId(AttachmentUploadByFileIdRequest request, Passport passport) {
        return foundationService.uploadAttachmentByFileId(request, passport);
    }

    /**
     * 更新一批附件的Business编号
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public AttachmentUpdateBusinessResponse updateAttachmentBusiness(AttachmentUpdateBusinessRequest request, Passport passport) {
        return foundationService.updateAttachmentBusiness(request, passport);
    }

    /**
     * 通过Business编号复制复件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public AttachmentsCopyByBusinessIdResponse copyAttachmentsByBusinessId(AttachmentCopyByBusinessIdRequest request, Passport passport) {
        return foundationService.copyAttachmentsByBusinessId(request, passport);
    }

    /**
     * 删除附件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public AttachmentDeleteResponse deleteAttachment(AttachmentDeleteRequest request, Passport passport) {
        return foundationService.deleteAttachment(request, passport);
    }

    /**
     * 获取附件列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public AttachmentGetByBizInfoResponse getAttachmentsByBizInfo(AttachmentGetByBizInfoRequest request, Passport passport) {
        return foundationService.getAttachmentsByBizInfo(request, passport);
    }

    /**
     * 根据编号取得序列号
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SequenceGetNextResponse getNextSequence(SequenceGetNextRequest request, Passport passport) {
        return foundationService.getNextSequence(request, passport);
    }

    /**
     * 批量获取序列号
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SequenceListGetResponse getSequenceList(SequenceListGetRequest request, Passport passport) {
        return foundationService.getSequenceList(request, passport);
    }

    /**
     * 发送邮件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MailSendResponse sendMail(MailSendRequest request, Passport passport) {
        return foundationService.sendMail(request, passport);
    }

    /**
     * 创建消息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MessageCreateResponse createMessage(MessageCreateRequest request, Passport passport) {
        return foundationService.createMessage(request, passport);
    }

    /**
     * 获取消息列表(未读)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MessageGetUnreadListResponse getUnreadMessageList(MessageGetUnreadListRequest request, Passport passport) {
        return foundationService.getUnreadMessageList(request, passport);
    }

    /**
     * 获取消息列表(已读)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MessageGetReadedListResponse getReadedMessageList(MessageGetReadedListRequest request, Passport passport) {
        return foundationService.getReadedMessageList(request, passport);
    }

    /**
     * 获取消息信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MessageGetResponse getMessage(MessageGetRequest request, Passport passport) {
        return foundationService.getMessage(request, passport);
    }

    /**
     * 设置消息为已读
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MessageReadResponse readMessage(MessageReadRequest request, Passport passport) {
        return foundationService.readMessage(request, passport);
    }

    /**
     * 上传logo(头像)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FileUploadResponse uploadFile(FileUploadRequest request, Passport passport) {
        return foundationService.uploadFile(request, passport);
    }

    /**
     * 获取阿里云上的文件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FileGetResponse getFile(FileGetRequest request, Passport passport) {
        return foundationService.getFile(request);
    }

    /**
     * 获取文件路径
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FilePathGetResponse getFilePath(FilePathGetRequest request, Passport passport) {
        return foundationService.getFilePath(request, passport);
    }

    /**
     * 获取文件路径
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FilePathListGetResponse getFilePathList(FilePathListGetRequest request, Passport passport) {
        return foundationService.getFilePathList(request, passport);
    }

    /**
     * 根据Id获取手机短信通知表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SmsGetResponse getSms(SmsGetRequest request, Passport passport) {
        return foundationService.getSms(request, passport);
    }

    /**
     * 高级查询手机短信通知表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SmsFindResponse findSms(SmsFindRequest request, Passport passport) {
        return foundationService.findSms(request, passport);
    }

    /**
     * 删除手机短信通知表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SmsDeleteResponse deleteSms(SmsDeleteRequest request, Passport passport) {
        return foundationService.deleteSms(request, passport);
    }

    /**
     * 发送短信
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SmsSendResponse sendSms(SmsSendRequest request, Passport passport) {
        return foundationService.sendSms(request, passport);
    }

    /**
     * 评论
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CommentRecordCreateResponse createCommentRecord(CommentRecordCreateRequest request, Passport passport) {
        return foundationService.createCommentRecord(request, passport);
    }

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CommentRecordDeleteResponse deleteCommentRecord(CommentRecordDeleteRequest request, Passport passport) {
        return foundationService.deleteCommentRecord(request, passport);
    }

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CommentRecordListGetResponse getCommentRecordList(CommentRecordListGetRequest request, Passport passport) {
        return foundationService.getCommentRecordList(request);
    }

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CommentRecordLikeResponse likeCommentRecord(CommentRecordLikeRequest request, Passport passport) {
        return foundationService.likeCommentRecord(request, passport);
    }

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CommentRecordCancleLikeResponse cancleLikeCommentRecord(CommentRecordCancleLikeRequest request, Passport passport) {
        return foundationService.cancleLikeCommentRecord(request, passport);
    }

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public CommentRecordGetResponse getCommentRecord(CommentRecordGetRequest request, Passport passport) {
        return foundationService.getCommentRecord(request, passport);
    }
}