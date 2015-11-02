package net.showcal.mobile.module.screen.goods;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.merchandise.request.ItemCollectionRequest;
import com.showcal.merchandise.request.ItemFindRequest;
import com.showcal.merchandise.response.ItemCollectionResponse;
import com.showcal.merchandise.response.ItemFindResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.md.helper.MdHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Search {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private MdHelper mdHelper;


    public void execute(Context context,@Param("title")String title) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        ItemFindRequest request=new ItemFindRequest();
        request.setTitle(title);
        request.setPageSize(10);
        request.setPageNumber(1);
        List<Long> alreadySubmit = new ArrayList<Long>();
        alreadySubmit.add(1L);
        request.setAlreadySubmit(alreadySubmit);
        ItemFindResponse response=mdHelper.findItem(request, passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(response, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
