package net.showcal.md.module.screen;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.foundation.service.FoundationService;
import com.showcal.merchandise.request.*;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import net.showcal.md.helper.MdHelper;
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
 *  Title: net.showcal.cms.module.screen.Api
 *  Description: cms 的API信息
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

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private MdHelper mdHelper;

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
                case "api.md.item.find":
                    baseResponse = findItem(jsonObject, passport);
                    break;
                case "api.md.item.create":
                    baseResponse = createItem(jsonObject, passport);
                    break;
                case "api.md.item.get":
                    baseResponse = getItem(jsonObject, passport);
                    break;
                case "api.md.item.delete":
                    baseResponse = deleteItem(jsonObject, passport);
                    break;
                case "api.md.item.update":
                    baseResponse = updateItem(jsonObject, passport);
                    break;
                case "api.md.item.approve":
                    baseResponse =approveItem(jsonObject, passport);
                    break;
                case "api.md.item.cancel":
                    baseResponse = cancelItem(jsonObject, passport);
                    break;
                case "api.md.item.collection":
                    baseResponse = clickCollection(jsonObject, passport);
                    break;
                case "api.md.item.sort":
                    baseResponse = changeSort(jsonObject, passport);
                    break;
                case "api.md.clazz.create.list":
                    baseResponse = createList(jsonObject, passport);
                    break;
                case "api.md.clazz.find":
                    baseResponse = findClazz(jsonObject, passport);
                    break;
                case "api.md.clazz.delete":
                    baseResponse = deleteClazz(jsonObject, passport);
                    break;
                case "api.md.clazz.update":
                    baseResponse =updateClazz(jsonObject, passport);
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


    private BaseResponse findItem(JSONObject jsonObject, Passport passport) {
        ItemFindRequest request = JSON.toJavaObject(jsonObject, ItemFindRequest.class);
        return mdHelper.findItem(request, passport);
    }

    private BaseResponse createItem(JSONObject jsonObject, Passport passport) {
        ItemCreateRequest request = JSON.toJavaObject(jsonObject, ItemCreateRequest.class);
        return mdHelper.createItem(request, passport);
    }

    private BaseResponse getItem(JSONObject jsonObject, Passport passport) {
        ItemGetRequest request = JSON.toJavaObject(jsonObject, ItemGetRequest.class);
        return mdHelper.getItem(request, passport);
    }
    private BaseResponse clickCollection(JSONObject jsonObject, Passport passport) {
        ItemCollectionRequest request = JSON.toJavaObject(jsonObject, ItemCollectionRequest.class);
        return mdHelper.clickCollection(request, passport);
    }
    private BaseResponse deleteItem(JSONObject jsonObject, Passport passport) {
        ItemDeleteRequest request = JSON.toJavaObject(jsonObject, ItemDeleteRequest.class);
        return mdHelper.deleteItem(request, passport);
    }
    private BaseResponse updateItem(JSONObject jsonObject, Passport passport) {
        ItemUpdateRequest request = JSON.toJavaObject(jsonObject, ItemUpdateRequest.class);
        return mdHelper.updateItem(request, passport);
    }
    private BaseResponse approveItem(JSONObject jsonObject, Passport passport) {
        ItemApproveRequest request = JSON.toJavaObject(jsonObject, ItemApproveRequest.class);
        return mdHelper.approve(request, passport);
    }
    private BaseResponse cancelItem(JSONObject jsonObject, Passport passport) {
        ItemCancelRequest request = JSON.toJavaObject(jsonObject, ItemCancelRequest.class);
        return mdHelper.cancel(request, passport);
    }
    private BaseResponse createList(JSONObject jsonObject, Passport passport) {
        ClazzCreateListRequest request = JSON.toJavaObject(jsonObject, ClazzCreateListRequest.class);
        return mdHelper.createList(request, passport);
    }

    private BaseResponse findClazz(JSONObject jsonObject, Passport passport) {
        ClazzFindRequest request = JSON.toJavaObject(jsonObject, ClazzFindRequest.class);
        return mdHelper.findClazz(request, passport);
    }
    private BaseResponse deleteClazz(JSONObject jsonObject, Passport passport) {
        ClazzDeleteRequest request = JSON.toJavaObject(jsonObject, ClazzDeleteRequest.class);
        return mdHelper.deleteClazz(request, passport);
    }
    private BaseResponse updateClazz(JSONObject jsonObject, Passport passport) {
        ClazzUpdateRequest request = JSON.toJavaObject(jsonObject, ClazzUpdateRequest.class);
        return mdHelper.updateClazz(request, passport);
    }
    private BaseResponse changeSort(JSONObject jsonObject, Passport passport) {
        ItemChangeOrderRequest request = JSON.toJavaObject(jsonObject, ItemChangeOrderRequest.class);
        return mdHelper.changeOrder(request, passport);
    }

}