package net.showcal.home.module.screen.api;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.showcal.foundation.service.FoundationService;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import net.showcal.tool.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by edward on 8/13/14.
 */
public class Foundation {

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private BufferedRequestContext brc;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FoundationService foundationService;


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
                case "api.foundation.messages.get":
                    baseResponse = apiFoundationMessageGet(passport);
                    break;
                case "api.foundation.readedmessage.get":
                    baseResponse = apiFoundationReadedMessageGet(passport);
                    break;
                case "api.foundation.message.read":
                    baseResponse = apiFoundationMessageRead(jsonObject, passport);
                    break;
                case "api.foundation.message.get":
                    baseResponse = apiFoundationMessageGet(jsonObject, passport);
                    break;
                case "api.foundation.attachment.getlist.bybizinfo":
                    baseResponse = apiFoundationAttachmentGetListByBizInfo(jsonObject, passport);
                    break;
                case "api.foundation.attachment.delete":
                    baseResponse = apiFoundationAttachmentDelete(jsonObject, passport);
                    break;
                case "api.foundation.ids.get":
                    baseResponse = apiFoundationIdsGet(jsonObject);
                    break;
                case "api.foundation.id.get":
                    baseResponse = apiFoundationIdGet();
                    break;
                case "api.foundation.attachment.uploadbyfileid":
                    baseResponse = apiFoundationAttachmentUploadByFileId(jsonObject, passport);
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


    private BaseResponse apiFoundationAttachmentUploadByFileId(JSONObject jsonObject, Passport passport) {
        AttachmentUploadByFileIdRequest attachmentUploadByFileIdRequest = JSON.toJavaObject(jsonObject, AttachmentUploadByFileIdRequest.class);
        return foundationService.uploadAttachmentByFileId(attachmentUploadByFileIdRequest, passport);
    }



    private MessageGetUnreadListResponse apiFoundationMessageGet(Passport passport) {
        MessageGetUnreadListRequest messageGetUnreadListRequest = new MessageGetUnreadListRequest();
        return foundationService.getUnreadMessageList(messageGetUnreadListRequest, passport);
    }

    private MessageGetReadedListResponse apiFoundationReadedMessageGet(Passport passport) {
        MessageGetReadedListRequest messageGetUnreadListRequest = new MessageGetReadedListRequest();
        return foundationService.getReadedMessageList(messageGetUnreadListRequest, passport);
    }

    private MessageReadResponse apiFoundationMessageRead(JSONObject jsonObject, Passport passport) {
        MessageReadRequest messageReadRequest = JSON.toJavaObject(jsonObject, MessageReadRequest.class);
        return foundationService.readMessage(messageReadRequest, passport);
    }

    private MessageGetResponse apiFoundationMessageGet(JSONObject jsonObject, Passport passport) {
        MessageGetRequest messageGetRequest = JSON.toJavaObject(jsonObject, MessageGetRequest.class);
        return foundationService.getMessage(messageGetRequest, passport);
    }



    private AttachmentGetByBizInfoResponse apiFoundationAttachmentGetListByBizInfo(JSONObject jsonObject, Passport passport) {
        AttachmentGetByBizInfoRequest attachmentGetByBizInfoRequest = JSON.toJavaObject(jsonObject, AttachmentGetByBizInfoRequest.class);
        return foundationService.getAttachmentsByBizInfo(attachmentGetByBizInfoRequest, passport);
    }

    private AttachmentDeleteResponse apiFoundationAttachmentDelete(JSONObject jsonObject, Passport passport) {
        AttachmentDeleteRequest attachmentDeleteRequest = JSON.toJavaObject(jsonObject, AttachmentDeleteRequest.class);
        return foundationService.deleteAttachment(attachmentDeleteRequest, passport);
    }


    private IdsGetResponse apiFoundationIdsGet(JSONObject jsonObject){
        IdsGetRequest idsGetRequest = JSON.toJavaObject(jsonObject,IdsGetRequest.class);
        if(idsGetRequest==null){
            idsGetRequest = new IdsGetRequest();
        }
        if(idsGetRequest.getCount()==null){
            idsGetRequest.setCount(1);
        }
        return foundationService.getNewIds(idsGetRequest);
    }

    private IdGetResponse apiFoundationIdGet(){
        IdGetResponse idGetResponse = new IdGetResponse();
        idGetResponse.setId(foundationService.getNewId());
        return idGetResponse;
    }

}
