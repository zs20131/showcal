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
import com.showcal.platform.request.CommentPostCreateRequest;
import com.showcal.platform.service.PlatformService;
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
public class CommentTest extends BaseTest {


    @Autowired
    private PlatformService platformService;

    @Autowired
    private Passport passport;

    private Long id=656332474867388416L;

    @Test
    public void testCrud() throws Exception {
        testCrudArticle();
    }

    public void testCrudArticle() throws Exception {
        CommentPostCreateRequest request=new CommentPostCreateRequest();
        request.setContent("rrrrrrrr");
        request.setThreadId(id);
        platformService.createCommentPost(request,passport);
    }






}
