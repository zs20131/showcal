package net.showcal.home.module.screen;

import com.alibaba.citrus.turbine.Navigator;
import com.xiniunet.framework.security.Passport;
import net.showcal.tool.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.single.base.module.screen
 *  Description:页面退出
 * ***************************************************************
 *  8/4 0004  V1.0  xiniu    New Files for com.xiniunet.single.base.module.screen
 * </pre>
 */
public class loginout {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    public void execute(Navigator nav) throws Exception{
        //删除cookie信息
        clearCookie();
        //作废passport信息
//        baseService.
        // 注销，返回首页
        nav.redirectTo("LoginLink");
    }
    public void clearCookie(){
        Cookie cookies[] = request.getCookies();
        if (cookies != null)
        {
            for (int i = 0; i < cookies.length; i++)
            {
                if (cookies[i].getName().equals(Constants.SESSION_NAME))
                {
                    Cookie cookie = new Cookie(Constants.SESSION_NAME,"LOGOUT");//这边得用"",不能用null
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }
}
