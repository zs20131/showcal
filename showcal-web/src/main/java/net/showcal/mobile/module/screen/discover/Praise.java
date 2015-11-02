package net.showcal.mobile.module.screen.discover;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.cms.domain.Article;
import com.showcal.cms.request.ArticleFindRequest;
import com.showcal.cms.request.ArticlePraiseRequest;
import com.showcal.cms.response.ArticleFindResponse;
import com.showcal.cms.response.ArticlePraiseResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Praise {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private CmsHelper cmsHelper;


    public void execute(Context context,@Param("id")Long id) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        ArticlePraiseRequest request=new ArticlePraiseRequest();
        request.setId(id);
        ArticlePraiseResponse response=cmsHelper.clickPraise(request, passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(response, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
