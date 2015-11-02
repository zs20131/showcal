package net.showcal.home.module.screen.api;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.showcal.foundation.domain.UploadTypeEnum;
import com.showcal.foundation.request.FileUploadRequest;
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
import java.io.PrintWriter;

/**
 * 文件上传
 */
public class FileUpload {

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private BufferedRequestContext brc;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FoundationService foundationService;

    public void execute(@Param("File") FileItem fileItem,
                        @Param("Type") UploadTypeEnum type) throws Exception {
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
            if(passport==null){
                passport = new Passport();
                passport.setUserId(100001L);
            } else{
                if(passport.getUserId()==null){
                    passport.setUserId(100001L);
                }
            }
            FileUploadRequest req = new FileUploadRequest();
            req.setFileStream(fileItem.get());
            req.setFileName(fileItem.getName());
            req.setFileExt(fileItem.getContentType());
            req.setType(type);
            baseResponse = foundationService.uploadFile(req, passport);
        } catch (Exception e) {
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(e));
        }finally {
            String json = JSON.toJSONString(baseResponse);
            PrintWriter out = response.getWriter();
            out.println(json);
        }

    }
}
