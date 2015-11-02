package net.showcal.home.module.screen.api;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.showcal.foundation.request.AttachmentUploadRequest;
import com.showcal.foundation.service.FoundationService;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import net.showcal.tool.Constants;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 附件上传
 */
public class AttachmentUpload {
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private BufferedRequestContext brc;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FoundationService foundationService;

    public void execute(@Param("file") FileItem fileItem,
                        @Param("method") String method,
                        @Param("Ext") String ext,
                        @Param("FileName") String fileName,
                        @Param("businessId") Long businessId,
                        @Param("businessType") String businessType,
                        @Param("businessCategory") String businessCategory) throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        try {
            if (fileItem == null) {
                return;
            }
            // 必须关闭buffering，未完成的页面才会被显示在浏览器上。
            brc.setBuffering(false);

            // 设置content type，但不需要设置charset，框架会设置正确的charset。
            response.setContentType("text/plain");
            Passport passport = (Passport) request.getAttribute("passport");
            InputStreamReader isr = new InputStreamReader(request.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            String line = in.readLine();
            JSONObject jsonObject = JSON.parseObject(line);

            switch (method) {
                case "api.foundation.attachment.upload":
                    AttachmentUploadRequest attachmentUploadRequest = new AttachmentUploadRequest();
                    attachmentUploadRequest.setFileExt(ext);
                    attachmentUploadRequest.setBusinessId(businessId);
                    attachmentUploadRequest.setBusinessType(businessType);
                    attachmentUploadRequest.setBusinessCategory(businessCategory);
                    attachmentUploadRequest.setFileStream(fileItem.get());
                    attachmentUploadRequest.setFileName(fileName);
                    baseResponse = foundationService.uploadAttachment(attachmentUploadRequest, passport);
                    break;
                case "api.md.":

                    break;
                default:
                    baseResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_METHOD);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(ex));
            LogUtil.errorLog(ex);
        } finally {
            String json = JSON.toJSONString(baseResponse);

            PrintWriter out = response.getWriter();
            out.println(json);
        }
    }
}
