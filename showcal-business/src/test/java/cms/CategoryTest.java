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

import com.showcal.cms.domain.CategoryEnum;
import com.showcal.cms.request.*;
import com.showcal.cms.response.*;
import com.showcal.cms.service.CMSService;
import com.xiniunet.framework.base.BaseTest;
import com.xiniunet.framework.security.Passport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by 顾志雄 on 2015-09-22 11:16:58.
 *
 * @author 顾志雄
 */
@TransactionConfiguration(defaultRollback = false)
public class CategoryTest extends BaseTest {


    @Autowired
    private CMSService cmsService;

    @Autowired
    private Passport passport;

    @Test
    public void testCrudArticle() throws Exception {
        CategoryCreateRequest  request = new CategoryCreateRequest();
        request.setName(CategoryEnum.ARTICLE.toString());
        request.setIsNeedApprove(true);
        request.setOrderIndex(1);
        request.setParentId(1L);
        CategoryCreateResponse response = cmsService.createCategory(request, passport);
        CategoryCreateRequest  request1 = new CategoryCreateRequest();
        request1.setName(CategoryEnum.INTRODUCTION.name());
        request1.setIsNeedApprove(true);
        request1.setOrderIndex(2);
        request1.setParentId(2L);
        CategoryCreateResponse response1 = cmsService.createCategory(request1, passport);
        CategoryCreateRequest  request2 = new CategoryCreateRequest();
        request2.setName(CategoryEnum.SUCCESS_CASE.name());
        request2.setIsNeedApprove(true);
        request2.setOrderIndex(3);
        request2.setParentId(3L);
        CategoryCreateResponse response2 = cmsService.createCategory(request2, passport);

    }


}
