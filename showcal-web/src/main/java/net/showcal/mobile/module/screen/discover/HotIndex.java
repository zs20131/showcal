package net.showcal.mobile.module.screen.discover;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.cms.domain.Article;
import com.showcal.cms.request.ArticleFindRequest;
import com.showcal.cms.response.ArticleFindResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class HotIndex {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private CmsHelper cmsHelper;


    public void execute(Context context,@Param("pageNumber")Integer pageNumber) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        ArticleFindRequest request = new ArticleFindRequest();
        List<Long> alreadySubmit = new ArrayList<Long>();
        alreadySubmit.add(1L);
        request.setAlreadySubmit(alreadySubmit);
        request.setIsHot(true);
        if(pageNumber!=null) {
            request.setPageNumber(pageNumber);
        }
        ArticleFindResponse response = cmsHelper.findArticle(request,passport);
        context.put("passport", passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(response, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
