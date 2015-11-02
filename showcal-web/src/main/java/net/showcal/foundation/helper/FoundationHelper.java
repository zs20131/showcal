package net.showcal.foundation.helper;

import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.foundation.helper.FoundationHelper
 *  Description: foundation Helper 接口
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public interface FoundationHelper {
    /**
     * 取得序列号
     *
     * @param
     * @param
     * @return
     */
    Long getNewId();

    /**
     * 获取一批ID
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    IdsGetResponse getNewIds(IdsGetRequest request, Passport passport);

    /**
     * 上传附件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    AttachmentUploadResponse uploadAttachment(AttachmentUploadRequest request, Passport passport);

    /**
     * 根据已经存在的文件Id上传附件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    AttachmentUploadByFileIdResponse uploadAttachmentByFileId(AttachmentUploadByFileIdRequest request, Passport passport);

    /**
     * 更新一批附件的Business编号
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    AttachmentUpdateBusinessResponse updateAttachmentBusiness(AttachmentUpdateBusinessRequest request, Passport passport);

    /**
     * 通过Business编号复制复件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    AttachmentsCopyByBusinessIdResponse copyAttachmentsByBusinessId(AttachmentCopyByBusinessIdRequest request, Passport passport);

    /**
     * 删除附件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    AttachmentDeleteResponse deleteAttachment(AttachmentDeleteRequest request, Passport passport);

    /**
     * 获取附件列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    AttachmentGetByBizInfoResponse getAttachmentsByBizInfo(AttachmentGetByBizInfoRequest request, Passport passport);

    /**
     * 根据编号取得序列号
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SequenceGetNextResponse getNextSequence(SequenceGetNextRequest request, Passport passport);

    /**
     * 批量获取序列号
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SequenceListGetResponse getSequenceList(SequenceListGetRequest request, Passport passport);

    /**
     * 发送邮件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MailSendResponse sendMail(MailSendRequest request, Passport passport);

    /**
     * 创建消息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MessageCreateResponse createMessage(MessageCreateRequest request, Passport passport);

    /**
     * 获取消息列表(未读)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MessageGetUnreadListResponse getUnreadMessageList(MessageGetUnreadListRequest request, Passport passport);

    /**
     * 获取消息列表(已读)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MessageGetReadedListResponse getReadedMessageList(MessageGetReadedListRequest request, Passport passport);

    /**
     * 获取消息信息
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MessageGetResponse getMessage(MessageGetRequest request, Passport passport);

    /**
     * 设置消息为已读
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MessageReadResponse readMessage(MessageReadRequest request, Passport passport);

    /**
     * 上传logo(头像)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FileUploadResponse uploadFile(FileUploadRequest request, Passport passport);

    /**
     * 获取阿里云上的文件
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FileGetResponse getFile(FileGetRequest request, Passport passport);

    /**
     * 获取文件路径
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FilePathGetResponse getFilePath(FilePathGetRequest request, Passport passport);

    /**
     * 获取文件路径
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FilePathListGetResponse getFilePathList(FilePathListGetRequest request, Passport passport);

    /**
     * 根据Id获取手机短信通知表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SmsGetResponse getSms(SmsGetRequest request, Passport passport);

    /**
     * 高级查询手机短信通知表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SmsFindResponse findSms(SmsFindRequest request, Passport passport);

    /**
     * 删除手机短信通知表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SmsDeleteResponse deleteSms(SmsDeleteRequest request, Passport passport);

    /**
     * 发送短信
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SmsSendResponse sendSms(SmsSendRequest request, Passport passport);

    /**
     * 评论
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    CommentRecordCreateResponse createCommentRecord(CommentRecordCreateRequest request, Passport passport);

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    CommentRecordDeleteResponse deleteCommentRecord(CommentRecordDeleteRequest request, Passport passport);

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    CommentRecordListGetResponse getCommentRecordList(CommentRecordListGetRequest request, Passport passport);

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    CommentRecordLikeResponse likeCommentRecord(CommentRecordLikeRequest request, Passport passport);

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    CommentRecordCancleLikeResponse cancleLikeCommentRecord(CommentRecordCancleLikeRequest request, Passport passport);

    /**
     * @param request
     * @param passport 用户护照
     * @return
     */
    CommentRecordGetResponse getCommentRecord(CommentRecordGetRequest request, Passport passport);


}