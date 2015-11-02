package net.showcal.mobile.module.screen.goods;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.showcal.merchandise.domain.Clazz;
import com.showcal.merchandise.request.ClazzFindRequest;
import com.showcal.merchandise.request.ItemFindRequest;
import com.showcal.merchandise.response.ClazzFindResponse;
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
public class Index {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private MdHelper mdHelper;


    public void execute(Context context, @Param("categoryId") Long categoryId) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
        ClazzFindRequest request = new ClazzFindRequest();
        List<Long> alreadySubmit = new ArrayList<Long>();
        alreadySubmit.add(1L);
        ClazzFindResponse response = mdHelper.findClazz(request, passport);
        List<Clazz> clazzs = new ArrayList<>();
        Clazz clazz = new Clazz();
        clazz.setName("全部");
        clazzs.add(clazz);
        for (Clazz category : response.getResult()) {
            clazzs.add(category);
        }
        response.getResult().add(clazz);
        context.put("clazzs",clazzs);
        ItemFindRequest itemFindRequest = new ItemFindRequest();
        itemFindRequest.setPageSize(10);
        itemFindRequest.setPageNumber(1);
        if (categoryId != null) {
            itemFindRequest.setCategoryId(categoryId);
        }
        itemFindRequest.setAlreadySubmit(alreadySubmit);
        ItemFindResponse itemFindResponse = mdHelper.findItem(itemFindRequest, passport);
        context.put("items", itemFindResponse.getResult());
        context.put("passport", passport);
        context.put("totalCount", itemFindResponse.getTotalCount());
    }
}
