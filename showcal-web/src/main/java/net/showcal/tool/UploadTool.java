package net.showcal.tool;

import com.showcal.foundation.domain.UploadTypeEnum;
import com.showcal.foundation.request.FileUploadRequest;
import com.showcal.foundation.response.FileUploadResponse;
import com.showcal.foundation.service.FoundationService;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.SpringContext;
import com.xiniunet.framework.util.excel.Excel;
import com.xiniunet.framework.util.excel.datatable.DataTable;


import java.io.IOException;

/**
 * Created on 2014/10/8.
 *
 * @author 吕浩
 * @version 0.1.0
 */
public class UploadTool {
    /**
     * 从Spring中取得可以获得用户对象的工具类
     */
    private static final FoundationService foundationService =
            (FoundationService) SpringContext.getApplicationContext().getBean(FoundationService.class);

    /**
     * 将DataTable转为Excel并上传。
     * @param table         要上传的DataTable
     * @param passport      护照信息
     * @return URL或者错误信息
     */
    public static FileUploadResponse uploadDataTable(DataTable table, Passport passport, Boolean flag) {
        FileUploadResponse uploadResponse = new FileUploadResponse();
        try {
            FileUploadRequest uploadRequest = new FileUploadRequest();
            uploadRequest.setFileExt("xlsx");
            uploadRequest.setType(UploadTypeEnum.TMP);
            uploadRequest.setFileStream(new Excel(table, flag).getBytes());

            uploadResponse = foundationService.uploadFile(uploadRequest, passport);
        } catch (IOException e) {
            LogUtil.errorLog(e);
            uploadResponse.addError("", "上传文件出现了小错误。");
        }
        return uploadResponse;
    }
    public static FileUploadResponse uploadExcelImportResult(byte[] bytes, Passport passport, Boolean flag) {
        FileUploadResponse uploadResponse = new FileUploadResponse();
        FileUploadRequest uploadRequest = new FileUploadRequest();
        uploadRequest.setFileExt("xlsx");
        uploadRequest.setType(UploadTypeEnum.TMP);
        uploadRequest.setFileStream(bytes);
        uploadResponse = foundationService.uploadFile(uploadRequest, passport);
        return uploadResponse;
    }
}
