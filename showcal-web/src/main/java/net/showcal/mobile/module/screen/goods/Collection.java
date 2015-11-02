package net.showcal.mobile.module.screen.goods;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.cms.request.ArticleCollectionRequest;
import com.showcal.cms.response.ArticleCollectionResponse;
import com.showcal.merchandise.request.ItemCollectionRequest;
import com.showcal.merchandise.response.ItemCollectionResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.md.helper.MdHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Collection {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private MdHelper mdHelper;


    public void execute(Context context,@Param("collection")String collection,@Param("id")Long id) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
       ItemCollectionRequest request=new ItemCollectionRequest();
        request.setIsCollection(Boolean.parseBoolean(collection));
        request.setId(id);
        ItemCollectionResponse response=mdHelper.clickCollection(request, passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(response, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
