package net.showcal.platform.module.screen;

import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.single.yunland.module.screen
 *  Description:
 * ***************************************************************
 *  8/4 0004  V1.0  xiniu    New Files for com.xiniunet.single.yunland.module.screen
 * </pre>
 */
public class Default {
    @Autowired
    private HttpServletRequest request;
    public void execute(Context context) throws Exception{
        context.put("passport",request.getAttribute("passport"));
    }
}
