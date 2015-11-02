package net.showcal.mobile.module.screen.message;

import com.alibaba.citrus.turbine.Context;
import com.showcal.cms.svc.Message;
import com.showcal.platform.domain.MessageTypeEnum;
import com.showcal.platform.domain.SysMessage;
import com.showcal.platform.request.SysMessageFindRequest;
import com.showcal.platform.response.SysMessageFindResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.cms.helper.CmsHelper;
import net.showcal.platform.helper.PlatformHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Index {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PlatformHelper platformHelper;


    public void execute(Context context) throws Exception {

        List<SysMessage> sysMessageList = new ArrayList<>();

        List<String> types = new ArrayList<>();
        types.add(MessageTypeEnum.SYSTEM.name());
        Passport passport = (Passport) request.getAttribute("passport");
        context.put("passport",passport);
        if (passport.getUserId() != null) {
            SysMessageFindRequest request = new SysMessageFindRequest();
            request.setUserId(passport.getUserId());
            request.setPageSize(0);
            request.setType(types);
            request.setIsRead(false);
            SysMessageFindResponse response = platformHelper.find(request, passport);
            if (response.getResult().size() > 0) {
                context.put("sendMessage", response.getResult().get(0));
            } else {
                List<SysMessage> sysMessages = new ArrayList<>();
                request.setIsRead(true);
                SysMessageFindResponse sysMessageFindResponse = platformHelper.find(request, passport);
                if (sysMessageFindResponse.getResult().size() == 0) {
                    context.put("sendMessage", "暂无系统消息");
                    context.put("num", 0);
                } else {
                    for (SysMessage sysMessage : sysMessageFindResponse.getResult()) {
                        Date readTime = null;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try {
                            readTime = sdf.parse(sysMessage.getReadTime());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if ((new Date().getTime() - readTime.getTime()) / 24 / 60 / 60 / 1000 <= 7) {
                            sysMessages.add(sysMessage);
                        }
                    }
                    if (sysMessages.size() == 0) {
                        context.put("sendMessage", sysMessages.get(0));
                    } else {
                        context.put("sendMessage", sysMessageFindResponse.getResult().get(0));
                    }
                }
            }
            types.clear();
            types.add(MessageTypeEnum.ARTICLE.name());
            types.add(MessageTypeEnum.COMMENT.name());
            types.add(MessageTypeEnum.SERVICE.name());
            request.setIsRead(false);
            SysMessageFindResponse response1 = platformHelper.find(request, passport);
            for (SysMessage sysMessage : response1.getResult()) {
                sysMessageList.add(sysMessage);
            }
            request.setIsRead(true);
            SysMessageFindResponse response2 = platformHelper.find(request, passport);
            for (SysMessage sysMessage : response2.getResult()) {
                Date readTime = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    readTime = sdf.parse(sysMessage.getReadTime());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if ((new Date().getTime() - readTime.getTime()) / 24 / 60 / 60 / 1000 <= 7) {
                    sysMessageList.add(sysMessage);
                }
            }
            context.put("sysMessageList", sysMessageList);
        }
        else{
            context.put("sendMessage", "你还未登录");
            context.put("num", 0);
        }

    }
}
