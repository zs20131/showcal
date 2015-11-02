package com.showcal.test.service;

import com.alibaba.fastjson.JSON;
import com.showcal.service.domain.MessageTypeEnum;
import com.showcal.service.request.QuestionCreateRequest;
import com.showcal.service.response.QuestionCreateResponse;
import com.showcal.service.service.ShowcalService;
import com.xiniunet.framework.base.BaseTest;
import com.xiniunet.framework.security.Passport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: 消息测试
 *  Description:
 * ***************************************************************
 *  9/30 0030  V1.0  xiniu    New Files for cms
 * </pre>
 */
@TransactionConfiguration(defaultRollback = false)
public class MessageTest extends BaseTest {
    @Autowired
    private ShowcalService showcalService;

    @Test
    public void testSendQuestion(){
        Passport passport = new Passport();
        passport.setUserId(648848943144636416L);
        passport.setUserName("测试李");
        QuestionCreateRequest createRequest = new QuestionCreateRequest();
        createRequest.setShowCalId(648671138192691200L);
        createRequest.setType(MessageTypeEnum.TEXT);
        createRequest.setContent("测试的哇，小哥哥，我的腿有点疼的哇，想跑步减肥的呀");
        createRequest.setTag(646282739125194752L);
        QuestionCreateResponse response = showcalService.sendQuestion(createRequest, passport);
        System.out.println(JSON.toJSONString(response));
    }
}
