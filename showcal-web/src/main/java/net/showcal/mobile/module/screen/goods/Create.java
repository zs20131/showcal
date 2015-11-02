package net.showcal.mobile.module.screen.goods;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.cms.domain.Article;
import com.showcal.cms.domain.Category;
import com.showcal.cms.request.ArticleFindRequest;
import com.showcal.cms.request.CategoryFindRequest;
import com.showcal.cms.response.ArticleFindResponse;
import com.showcal.cms.response.CategoryFindResponse;
import com.showcal.merchandise.request.ClazzFindRequest;
import com.showcal.merchandise.request.ItemFindRequest;
import com.showcal.merchandise.response.ClazzFindResponse;
import com.showcal.merchandise.response.ItemFindResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.md.helper.MdHelper;
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
public class Create {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private MdHelper mdHelper;


    public void execute(Context context,@Param("categoryId")Long categoryId,@Param("pageNum")Integer pageNum) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        ItemFindRequest itemFindRequest=new ItemFindRequest();
        if(categoryId!=null){
            itemFindRequest.setCategoryId(categoryId);
        }
        itemFindRequest.setPageSize(10);
        if(pageNum!=null) {
            itemFindRequest.setPageNumber(pageNum);
        }
        List<Long> alreadySubmit = new ArrayList<Long>();
        alreadySubmit.add(1L);
        itemFindRequest.setAlreadySubmit(alreadySubmit);
        ItemFindResponse itemFindResponse=mdHelper.findItem(itemFindRequest,passport);
        try {
            PrintWriter out = this.response.getWriter();
            String json = JSON.toJSONString(itemFindResponse, SerializerFeature.DisableCircularReferenceDetect);
            out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
