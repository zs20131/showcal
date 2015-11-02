package net.showcal.home.module.screen.api;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.foundation.domain.UploadTypeEnum;
import com.showcal.foundation.request.FileUploadRequest;
import com.showcal.foundation.response.FileUploadResponse;
import com.showcal.service.domain.MyRepositoryImport;
import com.showcal.service.domain.RepositoryImport;
import com.showcal.service.request.MyRepositoryListImportRequest;
import com.showcal.service.request.RepositoryListImportRequest;
import com.showcal.service.response.MyRepositoryListImportResponse;
import com.showcal.service.response.RepositoryListImportResponse;
import com.showcal.thermalcontrol.domain.FoodImport;
import com.showcal.thermalcontrol.domain.SportHeadImportShow;
import com.showcal.thermalcontrol.domain.SportLineImport;
import com.showcal.thermalcontrol.domain.SportSettingImport;
import com.showcal.thermalcontrol.po.SportSettingPO;
import com.showcal.thermalcontrol.request.FoodListImportRequest;
import com.showcal.thermalcontrol.request.SportHeadListImportRequest;
import com.showcal.thermalcontrol.request.SportLineListImportRequest;
import com.showcal.thermalcontrol.request.SportSettingListImportRequest;
import com.showcal.thermalcontrol.response.FoodListImportResponse;
import com.showcal.thermalcontrol.response.SportHeadListImportResponse;
import com.showcal.thermalcontrol.response.SportLineListImportResponse;
import com.showcal.thermalcontrol.response.SportSettingListImportResponse;
import com.xiniunet.framework.base.BaseURLResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.auth.LocalData;
import com.xiniunet.framework.util.excel.Excel;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import net.showcal.foundation.helper.FoundationHelper;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.service.helper.ServiceHelper;
import net.showcal.thermalcontrol.helper.ThermalcontrolHelper;
import net.showcal.tool.Constants;
import net.showcal.tool.UploadTool;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by DEV001 on 2014/9/1.
 */
public class FileImport {

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private BufferedRequestContext brc;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ThermalcontrolHelper thermalcontrolHelper;
    @Autowired
    private ServiceHelper serviceHelper;
    @Autowired
    private FoundationHelper foundationHelper;

    // Excel解析失败的时候，报出的消息
    private static final String INVALID_EXCEL = "Excel解析失败，请确认上传文档的正确性";

    @SuppressWarnings("unchecked")
    public void execute(@Param("file") FileItem fileItem, @Param("method") String method, @Param("json") String json, @Param("headId") Long headId) throws Exception {
        BaseURLResponse baseResponse = new BaseURLResponse();
        if (fileItem == null) {
            return;
        }
        try {
            // 必须关闭buffering，未完成的页面才会被显示在浏览器上。
            brc.setBuffering(false);

            // 设置content type，但不需要设置charset，框架会设置正确的charset。
            response.setContentType("text/plain");

            Passport passport = (Passport) request.getAttribute("passport");

            FileUploadRequest fileUploadRequest = new FileUploadRequest();
            fileUploadRequest.setType(UploadTypeEnum.TMP);
            fileUploadRequest.setFileExt("xlsx");
            FileUploadResponse fileUploadResponse;

            JSONObject jsonObject = JSON.parseObject(json);


            switch (method) {
                case "api.thermalcontrol.sport.setting.import":
                    baseResponse = apiSportSettingImport(fileItem.get(), passport);
                    break;
                case "api.thermalcontrol.sport.line.import":
                    baseResponse = apiSportLineImport(fileItem.get(), passport);
                    break;

                // 上传食物列表
                case "api.thermalcontrol.food.import":

                {
                    DataTable<FoodImport> dataTable;
                    try {
                        dataTable = new DataTable(fileItem.get(), FoodImport.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                        baseResponse.addError(ErrorType.INVALID_PARAMETER, e.getMessage());
                        break;
                    }
                    if (!dataTable.hasError()) {
                        List<FoodImport> list = dataTable.transferList(FoodImport.class);
                        FoodListImportRequest foodListImportRequest = new FoodListImportRequest();
                        foodListImportRequest.setDataTable(dataTable);
                        foodListImportRequest.setList(list);
                        if (list.isEmpty()) {
                            baseResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_DATA);
                            break;
                        } else {

                            FoodListImportResponse employeeImportResponse = thermalcontrolHelper.importFoodList(foodListImportRequest, passport);
                            if (employeeImportResponse.getDataTable() != null) {
                                // dataTable = employeeImportResponse.getDataTable();
                            }
                        }
                    }
                    if (dataTable.hasError()) {
                        fileUploadRequest.setFileStream(new Excel(dataTable, true).getBytes());
                        fileUploadResponse = foundationHelper.uploadFile(fileUploadRequest, passport);
//                        baseResponse.setUrl(fileUploadResponse.getUrl());
                        baseResponse.addErrors(dataTable.getErrorList());
                    }
                    break;
                }

                // 上传知识库
                case "api.service.repository.import": {
                    DataTable<RepositoryImport> dataTable;
                    try {
                        dataTable = new DataTable(fileItem.get(), RepositoryImport.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                        baseResponse.addError(ErrorType.INVALID_PARAMETER, e.getMessage());
                        break;
                    }
                    if (!dataTable.hasError()) {
                        List<RepositoryImport> list = dataTable.transferList(RepositoryImport.class);
                        RepositoryListImportRequest repositoryListImportRequest = new RepositoryListImportRequest();
                        repositoryListImportRequest.setDataTable(dataTable);
                        repositoryListImportRequest.setList(list);
                        if (list.isEmpty()) {
                            baseResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_DATA);
                            break;
                        } else {
                            RepositoryListImportResponse repositoryListImportResponse = serviceHelper.importRepositoryList(repositoryListImportRequest, passport);
                            if (repositoryListImportResponse.hasError()) {
                                baseResponse.addErrors(repositoryListImportResponse.getErrors());
                            }
                        }
                    }
                    break;
                }
                case "api.sport.head.import": {
                    baseResponse = apiSportHeadImport(fileItem.get(), passport);
                    break;
                }
                // 上传我的知识库
                case "api.service.my.repository.import": {
                    DataTable<MyRepositoryImport> dataTable;
                    try {
                        dataTable = new DataTable(fileItem.get(), MyRepositoryImport.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                        baseResponse.addError(ErrorType.INVALID_PARAMETER, e.getMessage());
                        break;
                    }
                    if (!dataTable.hasError()) {
                        List<MyRepositoryImport> list = dataTable.transferList(MyRepositoryImport.class);
                        MyRepositoryListImportRequest myRepositoryListImportRequest = new MyRepositoryListImportRequest();
                        myRepositoryListImportRequest.setDataTable(dataTable);
                        myRepositoryListImportRequest.setList(list);
                        if (list.isEmpty()) {
                            baseResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_DATA);
                            break;
                        } else {
                            MyRepositoryListImportResponse myRepositoryListImportResponse = serviceHelper.importMyRepositoryList(myRepositoryListImportRequest, passport);
                            if (myRepositoryListImportResponse.hasError()) {
                                baseResponse.addErrors(myRepositoryListImportResponse.getErrors());
                            }
                        }
                    }
                    break;
                }
            }
        } catch (Exception ex) {
            LogUtil.errorLog(ex);
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(ex));
        } finally {
            json = JSON.toJSONString(baseResponse, SerializerFeature.DisableCircularReferenceDetect);
            PrintWriter out = response.getWriter();
            out.println(json);
        }
    }

    private BaseURLResponse apiSportHeadImport(byte[] bytes, Passport passport) throws Exception {
        BaseURLResponse baseURLResponse = new BaseURLResponse();
        DataTable<SportHeadImportShow> dataTable;
        try {
            dataTable = new DataTable<>(bytes, SportHeadImportShow.class);
        } catch (Exception e) {
            baseURLResponse.addError(ErrorType.INVALID_PARAMETER, e.getMessage());
            return baseURLResponse;
        }

        if (!dataTable.hasError()) {
            List<SportHeadImportShow> list = dataTable.transferList(SportHeadImportShow.class);
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getId()!=null) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if ( list.get(j).getId() != null) {
                            if (list.get(i).getId().intValue() == list.get(j).getId().intValue()) {
                                baseURLResponse.addError(ErrorType.INVALID_PARAMETER, "第" + (i + 1) + "条数据" + "和第" + (j + 1) + "条运动方案主键相同");
                                return baseURLResponse;
                            }
                        }
                    }
                }
                else{
                    baseURLResponse.addError(ErrorType.INVALID_PARAMETER, "第" + (i + 1) + "条数据条主键不能为空");
                    return baseURLResponse;
                }
            }
            SportHeadListImportRequest excelRequest = new SportHeadListImportRequest();
            excelRequest.setDataTable(dataTable);
            excelRequest.setList(list);
            if (list.isEmpty()) {
                baseURLResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_DATA);
                return baseURLResponse;
            } else {
                SportHeadListImportResponse excelResponse = thermalcontrolHelper.importList(excelRequest, passport);
                baseURLResponse.addErrors(excelResponse.getErrors());
                if (excelResponse.getDataTable() != null) {
//                        dataTable = excelResponse.getDataTable();
                }
            }
        } else {
            baseURLResponse.addErrors(dataTable.getErrorList());
        }
        if (baseURLResponse.hasError()) {
            baseURLResponse.setUrl(UploadTool.uploadDataTable(dataTable, passport, true).getUrl());
        }

//        ImportParams importParams = new ImportParams();
//        DataExcel dataExcel = new DataExcel();
//        ExcelImportResult result = dataExcel.importExcel(new ByteArrayInputStream(bytes), SportHeadImportShow.class, importParams);
//        if(result.isVerfiyFail()){
//          // 如果验证错误-- 下载错误信息给前台
//            baseURLResponse.addError(ErrorType.BUSINESS_ERROR,"导入失败,请下载错误检查结果");
//            baseURLResponse.setUrl(UploadTool.uploadExcelImportResult(result.getBytes(),passport,true).getUrl());
//            return baseURLResponse;
//        }else {
//            // 发送后台再次校验
//            OrderHeadListImportRequest importRequest = new OrderHeadListImportRequest();
//            importRequest.setList(result.getList());
//            OrderHeadListImportResponse orderHeadListImportResponse = ecommerceHelper.importOrderHeadList(importRequest, passport);
//            if (orderHeadListImportResponse.hasError()) {
//               //  result.setVerifyResult(orderHeadListImportResponse.getDataVerifyResultMap());
//                baseURLResponse.addError(ErrorType.BUSINESS_ERROR, "导入失败,请下载错误检查结果");
//               baseURLResponse.setUrl(UploadTool.uploadExcelImportResult(result.getBytes(), passport, true).getUrl());
//                return baseURLResponse;
//            }
//        }
        return baseURLResponse;
    }

    private BaseURLResponse apiSportSettingImport(byte[] bytes, Passport passport) throws Exception {
        BaseURLResponse baseURLResponse = new BaseURLResponse();
        DataTable<SportSettingImport> dataTable;
        try {
            dataTable = new DataTable<>(bytes, SportSettingImport.class);
        } catch (Exception e) {
            baseURLResponse.addError(ErrorType.INVALID_PARAMETER, e.getMessage());
            return baseURLResponse;
        }

        if (!dataTable.hasError()) {
            List<SportSettingImport> list = dataTable.transferList(SportSettingImport.class);
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getId()!=null) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (  list.get(j).getId() != null) {
                            if (list.get(i).getId().intValue() == list.get(j).getId().intValue()) {
                                baseURLResponse.addError(ErrorType.INVALID_PARAMETER, "第" + (i + 1) + "条数据" + "和第" + (j + 1) + "条主键相同");
                                return baseURLResponse;
                            }
                        }
                    }
                }
                else{
                    baseURLResponse.addError(ErrorType.INVALID_PARAMETER, "第" + (i + 1) + "条数据条主键不能为空");
                    return baseURLResponse;
                }
            }
            SportSettingListImportRequest excelRequest = new SportSettingListImportRequest();
            excelRequest.setDataTable(dataTable);
            excelRequest.setList(list);
            if (list.isEmpty()) {
                baseURLResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_DATA);
                return baseURLResponse;
            } else {
                SportSettingListImportResponse excelResponse = thermalcontrolHelper.importList(excelRequest, passport);
                baseURLResponse.addErrors(excelResponse.getErrors());
                if (excelResponse.getDataTable() != null) {
//                        dataTable = excelResponse.getDataTable();
                }
            }
        } else {
            baseURLResponse.addErrors(dataTable.getErrorList());
        }
        if (baseURLResponse.hasError()) {
            baseURLResponse.setUrl(UploadTool.uploadDataTable(dataTable, passport, true).getUrl());
        }

//        ImportParams importParams = new ImportParams();
//        DataExcel dataExcel = new DataExcel();
//        ExcelImportResult result = dataExcel.importExcel(new ByteArrayInputStream(bytes), SportHeadImportShow.class, importParams);
//        if(result.isVerfiyFail()){
//          // 如果验证错误-- 下载错误信息给前台
//            baseURLResponse.addError(ErrorType.BUSINESS_ERROR,"导入失败,请下载错误检查结果");
//            baseURLResponse.setUrl(UploadTool.uploadExcelImportResult(result.getBytes(),passport,true).getUrl());
//            return baseURLResponse;
//        }else {
//            // 发送后台再次校验
//            OrderHeadListImportRequest importRequest = new OrderHeadListImportRequest();
//            importRequest.setList(result.getList());
//            OrderHeadListImportResponse orderHeadListImportResponse = ecommerceHelper.importOrderHeadList(importRequest, passport);
//            if (orderHeadListImportResponse.hasError()) {
//               //  result.setVerifyResult(orderHeadListImportResponse.getDataVerifyResultMap());
//                baseURLResponse.addError(ErrorType.BUSINESS_ERROR, "导入失败,请下载错误检查结果");
//               baseURLResponse.setUrl(UploadTool.uploadExcelImportResult(result.getBytes(), passport, true).getUrl());
//                return baseURLResponse;
//            }
//        }
        return baseURLResponse;
    }

    private BaseURLResponse apiSportLineImport(byte[] bytes, Passport passport) throws Exception {
        BaseURLResponse baseURLResponse = new BaseURLResponse();
        DataTable<SportLineImport> dataTable;
        try {
            dataTable = new DataTable<>(bytes, SportLineImport.class);
        } catch (Exception e) {
            baseURLResponse.addError(ErrorType.INVALID_PARAMETER, e.getMessage());
            return baseURLResponse;
        }

        if (!dataTable.hasError()) {
            List<SportLineImport> list = dataTable.transferList(SportLineImport.class);
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getLineId()!=null) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(j).getLineId() != null) {
                            if (list.get(i).getLineId().intValue() == list.get(j).getLineId().intValue()) {
                                baseURLResponse.addError(ErrorType.INVALID_PARAMETER, "第" + (i + 1) + "条数据" + "和第" + (j + 1) + "条主键相同");
                                return baseURLResponse;
                            }
                        }
                    }
                }
                else{
                    baseURLResponse.addError(ErrorType.INVALID_PARAMETER, "第" + (i + 1) + "条数据条主键不能为空");
                    return baseURLResponse;
                }
            }
            SportLineListImportRequest excelRequest = new SportLineListImportRequest();
            excelRequest.setDataTable(dataTable);
            excelRequest.setList(list);
            if (list.isEmpty()) {
                baseURLResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_DATA);
                return baseURLResponse;
            } else {
                SportLineListImportResponse excelResponse = thermalcontrolHelper.importList(excelRequest, passport);
                baseURLResponse.addErrors(excelResponse.getErrors());
                if (excelResponse.getDataTable() != null) {
//                        dataTable = excelResponse.getDataTable();
                }
            }
        } else {
            baseURLResponse.addErrors(dataTable.getErrorList());
        }
        if (baseURLResponse.hasError()) {
            baseURLResponse.setUrl(UploadTool.uploadDataTable(dataTable, passport, true).getUrl());
        }

//        ImportParams importParams = new ImportParams();
//        DataExcel dataExcel = new DataExcel();
//        ExcelImportResult result = dataExcel.importExcel(new ByteArrayInputStream(bytes), SportHeadImportShow.class, importParams);
//        if(result.isVerfiyFail()){
//          // 如果验证错误-- 下载错误信息给前台
//            baseURLResponse.addError(ErrorType.BUSINESS_ERROR,"导入失败,请下载错误检查结果");
//            baseURLResponse.setUrl(UploadTool.uploadExcelImportResult(result.getBytes(),passport,true).getUrl());
//            return baseURLResponse;
//        }else {
//            // 发送后台再次校验
//            OrderHeadListImportRequest importRequest = new OrderHeadListImportRequest();
//            importRequest.setList(result.getList());
//            OrderHeadListImportResponse orderHeadListImportResponse = ecommerceHelper.importOrderHeadList(importRequest, passport);
//            if (orderHeadListImportResponse.hasError()) {
//               //  result.setVerifyResult(orderHeadListImportResponse.getDataVerifyResultMap());
//                baseURLResponse.addError(ErrorType.BUSINESS_ERROR, "导入失败,请下载错误检查结果");
//               baseURLResponse.setUrl(UploadTool.uploadExcelImportResult(result.getBytes(), passport, true).getUrl());
//                return baseURLResponse;
//            }
//        }
        return baseURLResponse;
    }
}