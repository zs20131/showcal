package net.showcal.mobile.module.screen.discover;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.cms.request.ArticlePraiseRequest;
import com.showcal.cms.response.ArticlePraiseResponse;
import com.showcal.service.domain.ComplaintEnum;
import com.showcal.service.domain.Complatint;
import com.showcal.service.request.ComplatintCreateRequest;
import com.showcal.service.response.ComplatintCreateResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.service.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Complaint {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private ServiceHelper serviceHelper;


    public void execute(Context context, @Param("context1") String context1, @Param("id") Long id) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        ComplatintCreateRequest request = new ComplatintCreateRequest();
        request.setSourceType(ComplaintEnum.ARITLCE.name());
        request.setContent(context1);
        request.setSourceId(id);
        request.setIsProcessed(false);
        ComplatintCreateResponse response = serviceHelper.createComplatint(request, passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(response, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
