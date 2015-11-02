package net.showcal.mobile.module.screen.discover;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.cms.domain.ApproveResultEnum;
import com.showcal.cms.domain.CategoryEnum;
import com.showcal.cms.request.ArticleCreateRequest;
import com.showcal.cms.response.ArticleCreateResponse;
import com.showcal.platform.domain.CommentPost;
import com.showcal.platform.request.CommentPostCreateRequest;
import com.showcal.platform.response.CommentPostCreateResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.platform.helper.PlatformHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015/9/23.
 */
public class CreateComment {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private PlatformHelper platformHelper;


    public void execute(Context context,@Param("content")String content,@Param("threadId")Long threadId) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        CommentPostCreateRequest request=new CommentPostCreateRequest();
        request.setContent(content);
        request.setThreadId(threadId);
        CommentPostCreateResponse response=platformHelper.createCommentPost(request,passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(response, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
