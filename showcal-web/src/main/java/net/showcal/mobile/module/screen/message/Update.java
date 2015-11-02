package net.showcal.mobile.module.screen.message;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.cms.domain.CategoryEnum;
import com.showcal.cms.request.ArticleFindRequest;
import com.showcal.cms.response.ArticleFindResponse;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.domain.SysMessage;
import com.showcal.platform.domain.UserDetail;
import com.showcal.platform.domain.UserTypeEnum;
import com.showcal.platform.request.SysMessageUpdateRequest;
import com.showcal.platform.request.SysUserFindRequest;
import com.showcal.platform.response.SysMessageUpdateResponse;
import com.showcal.platform.response.SysUserFindResponse;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.service.response.ShowCalGetForMyResponse;
import com.xiniunet.framework.constant.PassportTypeEnum;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.platform.helper.PlatformHelper;
import net.showcal.service.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Update {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private PlatformHelper platformHelper;

    public void execute(Context context,@Param("id")Long id) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        SysMessageUpdateRequest request=new SysMessageUpdateRequest();
        request.setId(id);
        request.setIsReaded(true);
        String date="";
        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            date=sdf.format(new Date());
        }catch (Exception e){
            e.printStackTrace();
        }
         request.setReadTime(date);
        SysMessageUpdateResponse response=platformHelper.update(request,passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(response, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
