package net.showcal.mobile.module.screen.discover;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.cms.domain.ApproveResultEnum;
import com.showcal.cms.domain.Article;
import com.showcal.cms.domain.CategoryEnum;
import com.showcal.cms.request.ArticleCreateRequest;
import com.showcal.cms.request.ArticleFindRequest;
import com.showcal.cms.response.ArticleCreateResponse;
import com.showcal.cms.response.ArticleFindResponse;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.auth.LocalData;
import net.showcal.cms.helper.CmsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Create {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private CmsHelper cmsHelper;


    public void execute(Context context,@Param("content")String content,@Param("title")String title,@Param("pid")String pid) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        ArticleCreateRequest request=new ArticleCreateRequest();
        request.setContent(content);
        request.setApproveResult(ApproveResultEnum.AGREE.name());
        request.setTitle(title);
        if(pid!=null&&!"".equals(pid)){
            request.setCoverId(Long.valueOf(pid));
        }
        request.setIsMobile(true);
        request.setCategoryId(CategoryEnum.ARTICLE.name());
        ArticleCreateResponse response=cmsHelper.createArticle(request,passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(response, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
