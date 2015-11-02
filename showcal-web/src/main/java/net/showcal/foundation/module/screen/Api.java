package net.showcal.foundation.module.screen;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.foundation.request.*;
import com.showcal.foundation.service.FoundationService;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import net.showcal.foundation.helper.FoundationHelper;
import net.showcal.tool.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.foundation.module.screen.Api
 *  Description: foundation 的API信息
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public class Api {
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private BufferedRequestContext brc;

    @Autowired
    private HttpServletRequest request;

//    @Autowired
//    private FoundationService foundationService;

    @Autowired
    private FoundationHelper foundationHelper;

    public void execute(@Param("method") String method) throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        try {
            // 必须关闭buffering，未完成的页面才会被显示在浏览器上。
            brc.setBuffering(false);
            // 设置content type，但不需要设置charset，框架会设置正确的charset。
            response.setContentType("text/plain");
            method = method.toLowerCase();
            Passport passport = (Passport) request.getAttribute("passport");
            InputStreamReader isr = new InputStreamReader(request.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            String line = in.readLine();
            JSONObject jsonObject = JSON.parseObject(line);

            switch (method) {
                case "api.foundation.newids.get":
                    baseResponse = getNewIds(jsonObject, passport);
                    break;
                case "api.foundation.attachment.upload":
                    baseResponse = uploadAttachment(jsonObject, passport);
                    break;
                case "api.foundation.attachmentbyfileid.upload":
                    baseResponse = uploadAttachmentByFileId(jsonObject, passport);
                    break;
                case "api.foundation.attachmentbusiness.update":
                    baseResponse = updateAttachmentBusiness(jsonObject, passport);
                    break;
                case "api.foundation.attachmentsbybusinessid.copy":
                    baseResponse = copyAttachmentsByBusinessId(jsonObject, passport);
                    break;
                case "api.foundation.attachment.delete":
                    baseResponse = deleteAttachment(jsonObject, passport);
                    break;
                case "api.foundation.attachmentsbybizinfo.get":
                    baseResponse = getAttachmentsByBizInfo(jsonObject, passport);
                    break;
                case "api.foundation.nextsequence.get":
                    baseResponse = getNextSequence(jsonObject, passport);
                    break;
                case "api.foundation.sequencelist.get":
                    baseResponse = getSequenceList(jsonObject, passport);
                    break;
                case "api.foundation.mail.send":
                    baseResponse = sendMail(jsonObject, passport);
                    break;
                case "api.foundation.message.create":
                    baseResponse = createMessage(jsonObject, passport);
                    break;
                case "api.foundation.unreadmessagelist.get":
                    baseResponse = getUnreadMessageList(jsonObject, passport);
                    break;
                case "api.foundation.readedmessagelist.get":
                    baseResponse = getReadedMessageList(jsonObject, passport);
                    break;
                case "api.foundation.message.get":
                    baseResponse = getMessage(jsonObject, passport);
                    break;
                case "api.foundation.message.read":
                    baseResponse = readMessage(jsonObject, passport);
                    break;
                case "api.foundation.file.upload":
                    baseResponse = uploadFile(jsonObject, passport);
                    break;
                case "api.foundation.file.get":
                    baseResponse = getFile(jsonObject, passport);
                    break;
                case "api.foundation.filepath.get":
                    baseResponse = getFilePath(jsonObject, passport);
                    break;
                case "api.foundation.filepathlist.get":
                    baseResponse = getFilePathList(jsonObject, passport);
                    break;
                case "api.foundation.sms.get":
                    baseResponse = getSms(jsonObject, passport);
                    break;
                case "api.foundation.sms.find":
                    baseResponse = findSms(jsonObject, passport);
                    break;
                case "api.foundation.sms.delete":
                    baseResponse = deleteSms(jsonObject, passport);
                    break;
                case "api.foundation.sms.send":
                    baseResponse = sendSms(jsonObject, passport);
                    break;
                case "api.foundation.commentrecord.create":
                    baseResponse = createCommentRecord(jsonObject, passport);
                    break;
                case "api.foundation.commentrecord.delete":
                    baseResponse = deleteCommentRecord(jsonObject, passport);
                    break;
                case "api.foundation.commentrecordlist.get":
                    baseResponse = getCommentRecordList(jsonObject, passport);
                    break;
                case "api.foundation.commentrecord.like":
                    baseResponse = likeCommentRecord(jsonObject, passport);
                    break;
                case "api.foundation.likecommentrecord.cancle":
                    baseResponse = cancleLikeCommentRecord(jsonObject, passport);
                    break;
                case "api.foundation.commentrecord.get":
                    baseResponse = getCommentRecord(jsonObject, passport);
                    break;
                default:
                    baseResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_METHOD);
                    break;
            }
        } catch (Exception ex) {
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(ex));
            LogUtil.errorLog(ex);
        } finally {
            String jsonTenant = JSON.toJSONString(baseResponse);
            PrintWriter out = response.getWriter();
            out.println(jsonTenant);
        }
    }


    /**
     * 获取一批ID
     */
    private BaseResponse getNewIds(JSONObject jsonObject, Passport passport) {
        IdsGetRequest request = JSON.toJavaObject(jsonObject, IdsGetRequest.class);
        return foundationHelper.getNewIds(request, passport);
    }

    /**
     * 上传附件
     */
    private BaseResponse uploadAttachment(JSONObject jsonObject, Passport passport) {
        AttachmentUploadRequest request = JSON.toJavaObject(jsonObject, AttachmentUploadRequest.class);
        return foundationHelper.uploadAttachment(request, passport);
    }

    /**
     * 根据已经存在的文件Id上传附件
     */
    private BaseResponse uploadAttachmentByFileId(JSONObject jsonObject, Passport passport) {
        AttachmentUploadByFileIdRequest request = JSON.toJavaObject(jsonObject, AttachmentUploadByFileIdRequest.class);
        return foundationHelper.uploadAttachmentByFileId(request, passport);
    }

    /**
     * 更新一批附件的Business编号
     */
    private BaseResponse updateAttachmentBusiness(JSONObject jsonObject, Passport passport) {
        AttachmentUpdateBusinessRequest request = JSON.toJavaObject(jsonObject, AttachmentUpdateBusinessRequest.class);
        return foundationHelper.updateAttachmentBusiness(request, passport);
    }

    /**
     * 通过Business编号复制复件
     */
    private BaseResponse copyAttachmentsByBusinessId(JSONObject jsonObject, Passport passport) {
        AttachmentCopyByBusinessIdRequest request = JSON.toJavaObject(jsonObject, AttachmentCopyByBusinessIdRequest.class);
        return foundationHelper.copyAttachmentsByBusinessId(request, passport);
    }

    /**
     * 删除附件
     */
    private BaseResponse deleteAttachment(JSONObject jsonObject, Passport passport) {
        AttachmentDeleteRequest request = JSON.toJavaObject(jsonObject, AttachmentDeleteRequest.class);
        return foundationHelper.deleteAttachment(request, passport);
    }

    /**
     * 获取附件列表
     */
    private BaseResponse getAttachmentsByBizInfo(JSONObject jsonObject, Passport passport) {
        AttachmentGetByBizInfoRequest request = JSON.toJavaObject(jsonObject, AttachmentGetByBizInfoRequest.class);
        return foundationHelper.getAttachmentsByBizInfo(request, passport);
    }

    /**
     * 根据编号取得序列号
     */
    private BaseResponse getNextSequence(JSONObject jsonObject, Passport passport) {
        SequenceGetNextRequest request = JSON.toJavaObject(jsonObject, SequenceGetNextRequest.class);
        return foundationHelper.getNextSequence(request, passport);
    }

    /**
     * 批量获取序列号
     */
    private BaseResponse getSequenceList(JSONObject jsonObject, Passport passport) {
        SequenceListGetRequest request = JSON.toJavaObject(jsonObject, SequenceListGetRequest.class);
        return foundationHelper.getSequenceList(request, passport);
    }

    /**
     * 发送邮件
     */
    private BaseResponse sendMail(JSONObject jsonObject, Passport passport) {
        MailSendRequest request = JSON.toJavaObject(jsonObject, MailSendRequest.class);
        return foundationHelper.sendMail(request, passport);
    }

    /**
     * 创建消息
     */
    private BaseResponse createMessage(JSONObject jsonObject, Passport passport) {
        MessageCreateRequest request = JSON.toJavaObject(jsonObject, MessageCreateRequest.class);
        return foundationHelper.createMessage(request, passport);
    }

    /**
     * 获取消息列表(未读)
     */
    private BaseResponse getUnreadMessageList(JSONObject jsonObject, Passport passport) {
        MessageGetUnreadListRequest request = JSON.toJavaObject(jsonObject, MessageGetUnreadListRequest.class);
        return foundationHelper.getUnreadMessageList(request, passport);
    }

    /**
     * 获取消息列表(已读)
     */
    private BaseResponse getReadedMessageList(JSONObject jsonObject, Passport passport) {
        MessageGetReadedListRequest request = JSON.toJavaObject(jsonObject, MessageGetReadedListRequest.class);
        return foundationHelper.getReadedMessageList(request, passport);
    }

    /**
     * 获取消息信息
     */
    private BaseResponse getMessage(JSONObject jsonObject, Passport passport) {
        MessageGetRequest request = JSON.toJavaObject(jsonObject, MessageGetRequest.class);
        return foundationHelper.getMessage(request, passport);
    }

    /**
     * 设置消息为已读
     */
    private BaseResponse readMessage(JSONObject jsonObject, Passport passport) {
        MessageReadRequest request = JSON.toJavaObject(jsonObject, MessageReadRequest.class);
        return foundationHelper.readMessage(request, passport);
    }

    /**
     * 上传logo(头像)
     */
    private BaseResponse uploadFile(JSONObject jsonObject, Passport passport) {
        FileUploadRequest request = JSON.toJavaObject(jsonObject, FileUploadRequest.class);
        return foundationHelper.uploadFile(request, passport);
    }

    /**
     * 获取阿里云上的文件
     */
    private BaseResponse getFile(JSONObject jsonObject, Passport passport) {
        FileGetRequest request = JSON.toJavaObject(jsonObject, FileGetRequest.class);
        return foundationHelper.getFile(request, passport);
    }

    /**
     * 获取文件路径
     */
    private BaseResponse getFilePath(JSONObject jsonObject, Passport passport) {
        FilePathGetRequest request = JSON.toJavaObject(jsonObject, FilePathGetRequest.class);
        return foundationHelper.getFilePath(request, passport);
    }

    /**
     * 获取文件路径
     */
    private BaseResponse getFilePathList(JSONObject jsonObject, Passport passport) {
        FilePathListGetRequest request = JSON.toJavaObject(jsonObject, FilePathListGetRequest.class);
        return foundationHelper.getFilePathList(request, passport);
    }

    /**
     * 根据Id获取手机短信通知表
     */
    private BaseResponse getSms(JSONObject jsonObject, Passport passport) {
        SmsGetRequest request = JSON.toJavaObject(jsonObject, SmsGetRequest.class);
        return foundationHelper.getSms(request, passport);
    }

    /**
     * 高级查询手机短信通知表
     */
    private BaseResponse findSms(JSONObject jsonObject, Passport passport) {
        SmsFindRequest request = JSON.toJavaObject(jsonObject, SmsFindRequest.class);
        return foundationHelper.findSms(request, passport);
    }

    /**
     * 删除手机短信通知表
     */
    private BaseResponse deleteSms(JSONObject jsonObject, Passport passport) {
        SmsDeleteRequest request = JSON.toJavaObject(jsonObject, SmsDeleteRequest.class);
        return foundationHelper.deleteSms(request, passport);
    }

    /**
     * 发送短信
     */
    private BaseResponse sendSms(JSONObject jsonObject, Passport passport) {
        SmsSendRequest request = JSON.toJavaObject(jsonObject, SmsSendRequest.class);
        return foundationHelper.sendSms(request, passport);
    }

    /**
     * 评论
     */
    private BaseResponse createCommentRecord(JSONObject jsonObject, Passport passport) {
        CommentRecordCreateRequest request = JSON.toJavaObject(jsonObject, CommentRecordCreateRequest.class);
        return foundationHelper.createCommentRecord(request, passport);
    }

    /**
     *
     */
    private BaseResponse deleteCommentRecord(JSONObject jsonObject, Passport passport) {
        CommentRecordDeleteRequest request = JSON.toJavaObject(jsonObject, CommentRecordDeleteRequest.class);
        return foundationHelper.deleteCommentRecord(request, passport);
    }

    /**
     *
     */
    private BaseResponse getCommentRecordList(JSONObject jsonObject, Passport passport) {
        CommentRecordListGetRequest request = JSON.toJavaObject(jsonObject, CommentRecordListGetRequest.class);
        return foundationHelper.getCommentRecordList(request, passport);
    }

    /**
     *
     */
    private BaseResponse likeCommentRecord(JSONObject jsonObject, Passport passport) {
        CommentRecordLikeRequest request = JSON.toJavaObject(jsonObject, CommentRecordLikeRequest.class);
        return foundationHelper.likeCommentRecord(request, passport);
    }

    /**
     *
     */
    private BaseResponse cancleLikeCommentRecord(JSONObject jsonObject, Passport passport) {
        CommentRecordCancleLikeRequest request = JSON.toJavaObject(jsonObject, CommentRecordCancleLikeRequest.class);
        return foundationHelper.cancleLikeCommentRecord(request, passport);
    }

    /**
     *
     */
    private BaseResponse getCommentRecord(JSONObject jsonObject, Passport passport) {
        CommentRecordGetRequest request = JSON.toJavaObject(jsonObject, CommentRecordGetRequest.class);
        return foundationHelper.getCommentRecord(request, passport);
    }

}