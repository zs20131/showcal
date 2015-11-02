package net.showcal.mobile.module.screen.message;

import com.alibaba.citrus.turbine.Context;
import com.showcal.platform.domain.MessageTypeEnum;
import com.showcal.platform.domain.SysMessage;
import com.showcal.platform.request.SysMessageFindRequest;
import com.showcal.platform.response.SysMessageFindResponse;
import com.xiniunet.framework.security.Passport;
import net.showcal.platform.helper.PlatformHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class Listmessage {
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
        SysMessageFindRequest request = new SysMessageFindRequest();
        request.setUserId(passport.getUserId());
        request.setPageSize(0);
        request.setType(types);
        request.setIsRead(false);
        SysMessageFindResponse response1 = platformHelper.find(request, passport);
        for (SysMessage sysMessage : response1.getResult()) {
            sysMessageList.add(sysMessage);
        }
        request.setIsRead(true);
        SysMessageFindResponse response2 = platformHelper.find(request, passport);
        for (SysMessage sysMessage : response2.getResult()) {
            Date readTime=null;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                readTime=sdf.parse(sysMessage.getReadTime());
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println((new Date().getTime() - readTime.getTime()) / 24 / 60 / 60 / 1000);
            if((new Date().getTime()-readTime.getTime())/24/60/60/1000 <=7) {
                sysMessageList.add(sysMessage);
            }
        }
        context.put("sysMessageList",sysMessageList);
    }
}
