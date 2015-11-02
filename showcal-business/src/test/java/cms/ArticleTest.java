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
public class ArticleTest extends BaseTest {


    @Autowired
    private CMSService cmsService;

    @Autowired
    private Passport passport;
 private Long id;

    @Test
    public void testCrud() throws Exception {
        testCrudArticle();
        get();
        testFindArticle();
        delete();
    }

    public void testCrudArticle() throws Exception {
        ArticleCreateRequest request = new ArticleCreateRequest();
        request.setTitle("标题");
        request.setIsOriginal(true);
        request.setAuthorName("作者");
        request.setCoverId(12345L);
        request.setIsCoverInBody(true);
        request.setSummary("摘要");
        request.setOriginalUrl("原文链接");
        request.setCategoryId("分类ID");
        request.setKeywords("关键字");
        request.setCountRead(1234);
        request.setCountLink(1234);
        request.setCountComment(1234);
        request.setIsSubmit(true);
        request.setSubmitUserId(12345L);
        request.setSubmitUserName("提交用户姓名");
        request.setSubmitTime(new Date());
        request.setIsApproved(true);
        request.setApproveUserId(12345L);
        request.setApproveUserName("审批用户姓名");
        request.setApproveTime(new Date());
        request.setApproveResult("审批结果");
        ArticleCreateResponse response = cmsService.createArticle(request, passport);
        System.out.println(String.format(" id=%d", response.getId()));
        id=response.getId();

    }


    public void update() throws Exception {

        ArticleUpdateRequest request = new ArticleUpdateRequest();
        request.setRowVersion(0L);//并发版本控制
        request.setTitle("标题");
        request.setIsOriginal(true);
        request.setAuthorName("作者");
        request.setCoverId(12345L);
        request.setIsCoverInBody(true);
        request.setSummary("摘要");
        request.setOriginalUrl("原文链接");
        request.setCategoryId("分类ID");
        request.setKeywords("关键字");
        request.setCountRead(1234);
        request.setCountLink(1234);
        request.setCountComment(1234);
        request.setIsSubmit(true);
        request.setSubmitUserId(12345L);
        request.setSubmitUserName("提交用户姓名");
        request.setSubmitTime(new Date());
        request.setIsApproved(true);
        request.setApproveUserId(12345L);
        request.setApproveUserName("审批用户姓名");
        request.setApproveTime(new Date());
        request.setApproveResult("审批结果");
        cmsService.updateArticle(request, passport);

    }


    public void get() throws Exception {
        ArticleGetRequest request = new ArticleGetRequest();
        ArticleGetResponse response = cmsService.getArticle(request, passport);
    }


    public void delete() throws Exception {
        ArticleDeleteRequest request = new ArticleDeleteRequest();
        ArticleDeleteResponse response = cmsService.deleteArticle(request, passport);
    }


    public void testFindArticle() {
        ArticleFindRequest request = new ArticleFindRequest();
        ArticleFindResponse response = cmsService.findArticle(request, this.passport);
        request.setPageSize(10);
        request.setPageNumber(1);

        request.setSubmitUserId(12345L);
        request.setSubmitUserName("提交用户姓名");
        request.setApproveUserId(12345L);
        request.setApproveUserName("审批用户姓名");
        assertEquals(0, response.getTotalCount());
    }

}
