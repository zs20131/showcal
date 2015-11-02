package net.showcal.mobile.module.screen.discover;

import com.alibaba.citrus.turbine.Context;
import com.showcal.cms.domain.Article;
import com.showcal.cms.request.ArticleFindRequest;
import com.showcal.cms.response.ArticleFindResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Index {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private CmsHelper cmsHelper;


    public void execute(Context context) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
    }
}
