/**
 * @(#)ArticleTest.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package cms;

import com.showcal.cms.request.*;
import com.showcal.cms.response.ArticleCreateResponse;
import com.showcal.cms.response.ArticleDeleteResponse;
import com.showcal.cms.response.ArticleFindResponse;
import com.showcal.cms.response.ArticleGetResponse;
import com.showcal.cms.service.CMSService;
import com.showcal.foundation.service.FoundationService;
import com.showcal.merchandise.domain.Clazz;
import com.showcal.merchandise.request.ClazzCreateRequest;
import com.showcal.merchandise.request.ClazzUpdateRequest;
import com.showcal.merchandise.response.ClazzCreateResponse;
import com.showcal.merchandise.service.MerchandiseService;
import com.xiniunet.framework.base.BaseTest;
import com.xiniunet.framework.security.Passport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by 顾志雄 on 2015-09-22 11:16:58.
 *
 * @author 顾志雄
 */
@TransactionConfiguration(defaultRollback = false)
public class ClazzTest extends BaseTest {


    @Autowired
    private MerchandiseService merchandiseService;

    @Autowired
    private Passport passport;
    @Autowired
    private FoundationService foundationService;

    @Test
    public void testCrud() throws Exception {
        testCrudArticle();

    }

    public void testCrudArticle() throws Exception {
//        ClazzCreateRequest request = new ClazzCreateRequest();
//        List<ClazzUpdateRequest> clazzUpdateRequests=new ArrayList<>();
//        ClazzUpdateRequest clazzUpdateRequest=new ClazzUpdateRequest();
//        clazzUpdateRequest.setId(foundationService.getNewId());
//        clazzUpdateRequest.setCode("qxl");
//        clazzUpdateRequest.setName("器械类");
//        clazzUpdateRequest.setOrderIndex(1);
//        clazzUpdateRequest.setDescription("器械类");
//        clazzUpdateRequests.add(clazzUpdateRequest);
//        ClazzUpdateRequest clazzUpdateRequest1=new ClazzUpdateRequest();
//        clazzUpdateRequest1.setId(foundationService.getNewId());
//        clazzUpdateRequest1.setCode("ysl");
//        clazzUpdateRequest1.setName("饮食类");
//        clazzUpdateRequest1.setOrderIndex(2);
//        clazzUpdateRequest1.setDescription("饮食类");
//        clazzUpdateRequests.add(clazzUpdateRequest1);
//        ClazzUpdateRequest clazzUpdateRequest2=new ClazzUpdateRequest();
//        clazzUpdateRequest2.setId(foundationService.getNewId());
//        clazzUpdateRequest2.setCode("fsl");
//        clazzUpdateRequest2.setName("服饰类");
//        clazzUpdateRequest2.setOrderIndex(3);
//        clazzUpdateRequest2.setDescription("服饰类");
//        clazzUpdateRequests.add(clazzUpdateRequest2);
//        request.setClazzUpdateRequestList(clazzUpdateRequests);
//        ClazzCreateResponse response = merchandiseService.createClazz(request, passport);

    }




}
