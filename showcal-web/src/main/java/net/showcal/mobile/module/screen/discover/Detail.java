package net.showcal.mobile.module.screen.discover;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.showcal.cms.domain.Article;
import com.showcal.cms.request.ArticleGetRequest;
import com.showcal.cms.response.ArticleGetResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Detail {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CmsHelper cmsHelper;

    public void execute(Context context, @Param("id") Long id) {
        Passport passport = (Passport) request.getAttribute("passport");
        ArticleGetRequest request = new ArticleGetRequest();
        request.setId(id);
        ArticleGetResponse response = cmsHelper.getArticle(request, passport);
        Article article = response.getArticle();
        context.put("article", article);
        context.put("passport", passport);
    }
}
