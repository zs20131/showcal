package net.showcal.cms.module.screen;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.cms.request.*;
import com.showcal.foundation.service.FoundationService;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
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
    private CmsHelper cmsHelper;

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
                case "api.cms.category.find":
                    baseResponse = findCategory(jsonObject, passport);
                    break;
                case "api.cms.category.create":
                    baseResponse = createCategory(jsonObject, passport);
                    break;
                case "api.cms.category.update":
                    baseResponse = updateCategory(jsonObject, passport);
                    break;
                case "api.cms.category.delete":
                    baseResponse = deleteCategory(jsonObject, passport);
                    break;
                case "api.cms.article.get":
                    baseResponse = getArticle(jsonObject, passport);
                    break;
                case "api.cms.article.find":
                    baseResponse = findArticle(jsonObject, passport);
                    break;
                case "api.cms.articlealllistbyuser.get":
                    baseResponse = getArticleAllListByUser(jsonObject, passport);
                    break;
                case "api.cms.articlealllist.get":
                    baseResponse = getArticleAllList(jsonObject, passport);
                    break;
                case "api.cms.article.approve":
                    baseResponse = approveArticle(jsonObject, passport);
                    break;
                case "api.cms.article.cancel":
                    baseResponse = cancelArticle(jsonObject, passport);
                    break;
                case "api.cms.articleorder.change":
                    baseResponse = changeArticleOrder(jsonObject, passport);
                    break;
                case "api.cms.article.create":
                    baseResponse = createArticle(jsonObject, passport);
                    break;
                case "api.cms.article.update":
                    baseResponse = updateArticle(jsonObject, passport);
                    break;
                case "api.cms.article.delete":
                    baseResponse = deleteArticle(jsonObject, passport);
                    break;
                case "api.cms.article.success":
                    baseResponse = successArticle(jsonObject, passport);
                    break;
                case "api.cms.article.order":
                    baseResponse = changeOrder(jsonObject, passport);
                    break;
                case "api.cms.article.unsuccess":
                    baseResponse = unsuccessArticle(jsonObject, passport);
                    break;
                case "api.cms.articlestatistics.collect":
                    baseResponse = collectArticleStatistics(jsonObject, passport);
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
     * 高级查询文章类别
     */
    private BaseResponse findCategory(JSONObject jsonObject, Passport passport) {
        CategoryFindRequest request = JSON.toJavaObject(jsonObject, CategoryFindRequest.class);
        return cmsHelper.findCategory(request, passport);
    }

    /**
     * 创建文章类别
     */
    private BaseResponse createCategory(JSONObject jsonObject, Passport passport) {
        CategoryCreateRequest request = JSON.toJavaObject(jsonObject, CategoryCreateRequest.class);
        return cmsHelper.createCategory(request, passport);
    }

    /**
     * 更新文章类别
     */
    private BaseResponse updateCategory(JSONObject jsonObject, Passport passport) {
        CategoryUpdateRequest request = JSON.toJavaObject(jsonObject, CategoryUpdateRequest.class);
        return cmsHelper.updateCategory(request, passport);
    }

    /**
     * 删除文章类别(有文章不可以删除)
     */
    private BaseResponse deleteCategory(JSONObject jsonObject, Passport passport) {
        CategoryDeleteRequest request = JSON.toJavaObject(jsonObject, CategoryDeleteRequest.class);
        return cmsHelper.deleteCategory(request, passport);
    }

    /**
     * 根据Id获取文章
     */
    private BaseResponse getArticle(JSONObject jsonObject, Passport passport) {
        ArticleGetRequest request = JSON.toJavaObject(jsonObject, ArticleGetRequest.class);
        return cmsHelper.getArticle(request, passport);
    }

    /**
     * 高级查询文章
     */
    private BaseResponse findArticle(JSONObject jsonObject, Passport passport) {
        ArticleFindRequest request = JSON.toJavaObject(jsonObject, ArticleFindRequest.class);
        return cmsHelper.findArticle(request, passport);
    }

    /**
     * 获取某个发表人/类别的所有文章信息
     */
    private BaseResponse getArticleAllListByUser(JSONObject jsonObject, Passport passport) {
        ArticleGetAllListByUserRequest request = JSON.toJavaObject(jsonObject, ArticleGetAllListByUserRequest.class);
        return cmsHelper.getArticleAllListByUser(request, passport);
    }

    /**
     * 发现，所有已发表的文章
     */
    private BaseResponse getArticleAllList(JSONObject jsonObject, Passport passport) {
        ArticleGetAllListRequest request = JSON.toJavaObject(jsonObject, ArticleGetAllListRequest.class);
        return cmsHelper.getArticleAllList(request, passport);
    }

    /**
     * 审核文章
     */
    private BaseResponse approveArticle(JSONObject jsonObject, Passport passport) {
        ArticleApproveRequest request = JSON.toJavaObject(jsonObject, ArticleApproveRequest.class);
        return cmsHelper.aproveArticle(request, passport);
    }

    /**
     * 取消文章发布
     */
    private BaseResponse cancelArticle(JSONObject jsonObject, Passport passport) {
        ArticleCancelRequest request = JSON.toJavaObject(jsonObject, ArticleCancelRequest.class);
        return cmsHelper.cancelArticle(request, passport);
    }

    /**
     * 改变文章排序
     */
    private BaseResponse changeArticleOrder(JSONObject jsonObject, Passport passport) {
        ArticleChangeOrderRequest request = JSON.toJavaObject(jsonObject, ArticleChangeOrderRequest.class);
        return cmsHelper.changeArticleOrder(request, passport);
    }

    /**
     * 创建文章
     */
    private BaseResponse createArticle(JSONObject jsonObject, Passport passport) {
        ArticleCreateRequest request = JSON.toJavaObject(jsonObject, ArticleCreateRequest.class);
        return cmsHelper.createArticle(request, passport);
    }

    /**
     * 更新文章
     */
    private BaseResponse updateArticle(JSONObject jsonObject, Passport passport) {
        ArticleUpdateRequest request = JSON.toJavaObject(jsonObject, ArticleUpdateRequest.class);
        return cmsHelper.updateArticle(request, passport);
    }

    /**
     * 删除文章
     */
    private BaseResponse deleteArticle(JSONObject jsonObject, Passport passport) {
        ArticleDeleteRequest request = JSON.toJavaObject(jsonObject, ArticleDeleteRequest.class);
        return cmsHelper.deleteArticle(request, passport);
    }

    /**
     * 文章统计收集
     */
    private BaseResponse collectArticleStatistics(JSONObject jsonObject, Passport passport) {
        ArticleStatisticsCollectRequest request = JSON.toJavaObject(jsonObject, ArticleStatisticsCollectRequest.class);
        return cmsHelper.collectArticleStatistics(request, passport);
    }
    /**
     * 升级成功案列
     */
    private BaseResponse successArticle(JSONObject jsonObject, Passport passport) {
        ArticleSuccessUpdateRequest request = JSON.toJavaObject(jsonObject, ArticleSuccessUpdateRequest.class);
        return cmsHelper.successArticle(request, passport);
    }
    /**
     * 撤销成功
     */
    private BaseResponse unsuccessArticle(JSONObject jsonObject, Passport passport) {
        ArticleUnsuccessUpdateRequest request = JSON.toJavaObject(jsonObject, ArticleUnsuccessUpdateRequest.class);
        return cmsHelper.unsuccessArticle(request, passport);
    }
    /**
     * 撤销成功
     */
    private BaseResponse changeOrder(JSONObject jsonObject, Passport passport) {
        ArticleChangeOrderRequest request = JSON.toJavaObject(jsonObject, ArticleChangeOrderRequest.class);
        return cmsHelper.changeArticleOrder(request, passport);
    }
}