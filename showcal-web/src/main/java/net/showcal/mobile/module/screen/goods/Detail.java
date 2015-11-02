package net.showcal.mobile.module.screen.goods;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.showcal.cms.request.ArticleGetRequest;
import com.showcal.cms.response.ArticleGetResponse;
import com.showcal.foundation.request.AttachmentGetByBizInfoRequest;
import com.showcal.foundation.response.AttachmentGetByBizInfoResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.merchandise.request.ItemGetRequest;
import com.showcal.merchandise.response.ItemGetResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.md.helper.MdHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Detail {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private MdHelper mdHelper;
    @Autowired
    private FoundationService foundationService;

    public void execute(Context context, @Param("id") Long id) {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        ItemGetRequest request = new ItemGetRequest();
        request.setId(id);
        ItemGetResponse response = mdHelper.getItem(request, passport);
        AttachmentGetByBizInfoRequest attachmentGetByBizInfoRequest =new AttachmentGetByBizInfoRequest()  ;
        attachmentGetByBizInfoRequest.setBusinessId(id);
        AttachmentGetByBizInfoResponse attachmentGetByBizInfoResponse= foundationService.getAttachmentsByBizInfo(attachmentGetByBizInfoRequest, passport);;
        context.put("attachmentList",attachmentGetByBizInfoResponse.getAttachmentList());
        context.put("item", response.getItem());
        context.put("isCollection",response.getIsCollection());
        context.put("commonPostList",response.getCommentPostList());
    }
}