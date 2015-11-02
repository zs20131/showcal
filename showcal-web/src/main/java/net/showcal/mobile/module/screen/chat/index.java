package net.showcal.mobile.module.screen.chat;

import com.alibaba.citrus.turbine.Context;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.mobile.domain.ShowCalInfo;
import com.showcal.service.domain.ServiceMessage;
import com.showcal.service.domain.SexEnum;
import com.showcal.service.domain.Welcome;
import com.showcal.service.request.MessageHistoryGetRequest;
import com.showcal.service.request.ShowCalGetForMyRequest;
import com.showcal.service.request.WelcomeGetForMyRequest;
import com.showcal.service.response.MessageHistoryGetResponse;
import com.showcal.service.response.ShowCalGetForMyResponse;
import com.showcal.service.response.WelComeGetForMyResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.service.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen.chat
 *  Description:
 * ***************************************************************
 *  10/8 0008  V1.0  xiniu    New Files for net.showcal.mobile.module.screen.chat
 * </pre>
 */
public class index {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private ServiceHelper serviceHelper;
    @Autowired
    private FoundationService foundationService;
    public void execute(Context context) throws Exception {
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport", passport);
        // 获取我的瘦咖信息
        ShowCalGetForMyRequest showCalGetForMyRequest = new ShowCalGetForMyRequest();
        ShowCalGetForMyResponse showCalGetForMyResponse = serviceHelper.getMyShowCal(showCalGetForMyRequest, passport);
        if (showCalGetForMyResponse.getShowCalInfo()!= null) {
            if (showCalGetForMyResponse.getShowCalInfo().getId() != null) {
                ShowCalInfo showCalInfo = showCalGetForMyResponse.getShowCalInfo();
                if (showCalInfo.getAvatarId() != null && showCalInfo.getAvatarId().intValue() != 0) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(showCalInfo.getAvatarId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    showCalInfo.setAvatarurl(filePathGetResponse.getUrl());
                } else {
                    if (showCalInfo.getSex() != null) {
                        if (showCalInfo.getSex().equals(SexEnum.FEMALE)) {
                            showCalInfo.setAvatarurl("../images/girl.png");
                        } else if (showCalInfo.getSex().equals(SexEnum.MALE)) {
                            showCalInfo.setAvatarurl("../images/boy.png");
                        }
                    } else {
                        showCalInfo.setAvatarurl("../images/girl.png");
                    }
                }
                context.put("myShowCal", showCalInfo);
                // 获取我与瘦咖的聊天记录
                MessageHistoryGetRequest historyGetRequest = new MessageHistoryGetRequest();
                historyGetRequest.setShowcalId(showCalInfo.getId());
                MessageHistoryGetResponse historyGetResponse = serviceHelper.getMyHistoryMessage(historyGetRequest, passport);
                List<ServiceMessage> historyMessage = historyGetResponse.getResult();
                if (historyMessage == null || historyMessage.isEmpty()) {
                    //加载欢迎语
                    WelcomeGetForMyRequest welcomeGetForMyRequest = new WelcomeGetForMyRequest();
                    welcomeGetForMyRequest.setShowCalId(showCalInfo.getId());
                    WelComeGetForMyResponse welComeGetForMyResponse = serviceHelper.getMyShowCalWelCome(welcomeGetForMyRequest, passport);
                    Welcome welcome = welComeGetForMyResponse.getWelcome();
                    if (welcome != null) {
                        context.put("welcome", welcome.getCometent());
                    } else {
                        context.put("welcome", "欢迎您来到瘦咖");
                    }

                }
                context.put("historyMessages", historyMessage);
                context.put("totalCount", historyGetResponse.getTotalCount());
            }
            else {
                ShowCalInfo showCalInfo = new ShowCalInfo();
                showCalInfo.setNickName("暂无瘦咖");
                context.put("index",1);
                context.put("myShowCal", showCalInfo);
            }
        }
       else {
            ShowCalInfo showCalInfo = new ShowCalInfo();
            showCalInfo.setNickName("暂无瘦咖");
            context.put("index",1);
            context.put("myShowCal", showCalInfo);
        }
    }
}
