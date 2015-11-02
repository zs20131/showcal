package com.showcal.foundation.service;

import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.showcal.platform.request.SettingDiseaseAppGetAllListRequest;
import com.showcal.platform.request.SettingDiseaseGetAllListRequest;
import com.showcal.platform.response.SettingDiseaseAppGetAllListResponse;
import com.showcal.platform.response.SettingDiseaseGetAllListResponse;
import com.xiniunet.framework.security.Passport;

/**
 * Created by DEV001 on 2014/7/30.
 */
public interface FoundationService {
    /**
     * 取得序列号
     *
     * @return 序列号
     */
    Long getNewId();

    /**
     * 获取一批ID
     *
     * @param req
     * @return
     */
    IdsGetResponse getNewIds(IdsGetRequest req);

    /**
     * 上传附件
     *
     * @param req      上传附件请求
     * @param passport 用户护照
     * @return 上传附件应答
     */
    AttachmentUploadResponse uploadAttachment(AttachmentUploadRequest req, Passport passport);

    /**
     * 根据已经存在的文件Id上传附件
     *
     * @param req      上传附件请求
     * @param passport 用户护照
     * @return 上传附件应答
     */
    AttachmentUploadByFileIdResponse uploadAttachmentByFileId(AttachmentUploadByFileIdRequest req, Passport passport);

    /**
     * 更新一批附件的Business编号
     *
     * @param request
     * @param passport
     * @return
     */
    AttachmentUpdateBusinessResponse updateAttachmentBusiness(AttachmentUpdateBusinessRequest request, Passport passport);

    /**
     * 通过Business编号复制复件
     *
     * @param request  复制请求
     * @param passport 护照信息
     * @return 复制结果
     * @author 吕浩
     * @since 2.1.0
     */
    AttachmentsCopyByBusinessIdResponse copyAttachmentsByBusinessId(AttachmentCopyByBusinessIdRequest request, Passport passport);

    /**
     * 删除附件
     *
     * @param req      删除附件请求
     * @param passport 用户护照
     * @return 删除附件应答
     */
    AttachmentDeleteResponse deleteAttachment(AttachmentDeleteRequest req, Passport passport);

    /**
     * 获取附件列表
     *
     * @param req      获取附件列表请求
     * @param passport 用户护照
     * @return 附件列表应答
     */
    AttachmentGetByBizInfoResponse getAttachmentsByBizInfo(AttachmentGetByBizInfoRequest req, Passport passport);

    /**
     * 根据编号取得序列号
     *
     * @param req      获取序列号请求
     * @param passport 用户护照
     * @return 获取序列号应答
     */
    SequenceGetNextResponse getNextSequence(SequenceGetNextRequest req, Passport passport);

    /**
     * 批量获取序列号
     *
     * @param req      批量获取序列号请求
     * @param passport 用户护照
     * @return 批量获取序列号应答
     */
    SequenceListGetResponse getSequenceList(SequenceListGetRequest req, Passport passport);

    /**
     * 发送邮件
     *
     * @param req      发送邮件请求
     * @param passport 用户护照
     * @return 发送邮件应答
     */
    MailSendResponse sendMail(MailSendRequest req, Passport passport);

    /**
     * 创建消息
     *
     * @param req      创建消息请求
     * @param passport 用户护照
     * @return 创建消息应答
     */
    MessageCreateResponse createMessage(MessageCreateRequest req, Passport passport);

    /**
     * 获取消息列表(未读)
     *
     * @param req      获取消息列表请求
     * @param passport 用户护照
     * @return 消息列表应答
     */
    MessageGetUnreadListResponse getUnreadMessageList(MessageGetUnreadListRequest req, Passport passport);

    /**
     * 获取消息列表(已读)
     *
     * @param req      获取消息列表请求
     * @param passport 用户护照
     * @return 消息列表应答
     */
    MessageGetReadedListResponse getReadedMessageList(MessageGetReadedListRequest req, Passport passport);

    /**
     * 获取消息信息
     *
     * @param req      获取消息内容请求
     * @param passport 用户护照
     * @return 消息信息应答
     */
    MessageGetResponse getMessage(MessageGetRequest req, Passport passport);

    /**
     * 设置消息为已读
     *
     * @param req      设置消息已读请求
     * @param passport 用户护照
     */
    MessageReadResponse readMessage(MessageReadRequest req, Passport passport);

    /**
     * 上传logo(头像)
     *
     * @param req      上传请求
     * @param passport 用户护照
     */
    FileUploadResponse uploadFile(FileUploadRequest req, Passport passport);

    /**
     * 获取阿里云上的文件
     *
     * @param req 获取阿里云上的文件请求
     * @return 文件流应答
     */
    FileGetResponse getFile(FileGetRequest req);


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
     * 根据Id获取手机短信通知表
     *
     * @param request  获取手机短信通知表请求
     * @param passport 用户护照
     * @return 获取手机短信通知表应答
     */
    SmsGetResponse getSms(SmsGetRequest request, Passport passport);

    /**
     * 高级查询手机短信通知表
     *
     * @param request  高级查询手机短信通知表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SmsFindResponse findSms(SmsFindRequest request, Passport passport);


    /**
     * 删除手机短信通知表
     *
     * @param request  删除手机短信通知表请求
     * @param passport 用户护照
     * @return 删除手机短信通知表应答
     */
    SmsDeleteResponse deleteSms(SmsDeleteRequest request, Passport passport);

    /**
     * 发送短信
     *
     * @param request  发送短信请求
     * @param passport 用户护照
     * @return 发送短信应答
     */
    SmsSendResponse sendSms(SmsSendRequest request, Passport passport);

    /**
     * 评论
     * @param request
     * @param passport
     * @return
     */
    CommentRecordCreateResponse createCommentRecord(CommentRecordCreateRequest request, Passport passport);

    CommentRecordDeleteResponse deleteCommentRecord(CommentRecordDeleteRequest request, Passport passport);

    CommentRecordListGetResponse getCommentRecordList(CommentRecordListGetRequest request);

    CommentRecordLikeResponse likeCommentRecord(CommentRecordLikeRequest request, Passport passport);

    CommentRecordCancleLikeResponse cancleLikeCommentRecord(CommentRecordCancleLikeRequest request, Passport passport);

    CommentRecordGetResponse getCommentRecord(CommentRecordGetRequest request, Passport passport);

    /**
     *  获取所有特殊情况
     *
     * @param request
     * @param passport
     * @return
     */
    SettingDiseaseGetAllListResponse getSettingDiseaseList(SettingDiseaseGetAllListRequest request, Passport passport);

    /**
     *  获取所有app端特殊情况
     *
     * @param request
     * @param passport
     * @return
     */
    SettingDiseaseAppGetAllListResponse getAppSettingDiseaseList(SettingDiseaseAppGetAllListRequest request, Passport passport);
}
