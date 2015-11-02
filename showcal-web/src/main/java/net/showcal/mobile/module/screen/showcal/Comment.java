package net.showcal.mobile.module.screen.showcal;

import com.alibaba.citrus.turbine.Context;
import com.xiniunet.framework.exception.Error;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.platform.domain.CommentPost;
import com.showcal.platform.request.CommentPostCreateRequest;
import com.showcal.platform.request.CommentPostFindRequest;
import com.showcal.platform.response.CommentPostCreateResponse;
import com.showcal.platform.response.CommentPostFindResponse;
import com.showcal.service.request.ServiceUserCreateRequest;
import com.showcal.service.response.ServiceUserCreateResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.service.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen.showcal
 *  Description:瘦咖主页
 * ***************************************************************
 *  9/24 0024  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.showcal
 * </pre>
 */
public class Comment {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private ServiceHelper serviceHelper;
    @Autowired
    private PlatformHelper platformHelper;
    public void execute(Context context, @Param("serviceId") Long serviceId,@Param("businessType")String businessType,@Param("content")String content,@Param("grade")double grade) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        CommentPostCreateRequest commentPostCreateRequest=new CommentPostCreateRequest();
        commentPostCreateRequest.setThreadId(serviceId);
        commentPostCreateRequest.setContent(content);
        commentPostCreateRequest.setBusinessType(businessType);
        commentPostCreateRequest.setGrade(grade);
        CommentPostCreateResponse commentPostCreateResponse= platformHelper.createCommentPost(commentPostCreateRequest, passport);
        //获取此瘦咖下的评论
        CommentPostFindRequest commentPostFindRequest = new CommentPostFindRequest();
        commentPostFindRequest.setThreadId(serviceId );
        commentPostFindRequest.setPageSize(0);
        CommentPostFindResponse commentPostFindResponse = platformHelper.find(commentPostFindRequest, passport);
        for(CommentPost commentPost:commentPostFindResponse.getResult()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             commentPost.setPostDate(sdf.format(commentPost.getPostTime()));

        }
       for(Error error:commentPostCreateResponse.getErrors()){
           commentPostFindResponse.addError(error);
       }
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(commentPostFindResponse, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
