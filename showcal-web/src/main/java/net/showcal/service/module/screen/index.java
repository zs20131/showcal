package net.showcal.service.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.service.module.screen
 *  Description:
 * ***************************************************************
 *  10/15 0015  V1.0  xiniu    New Files for net.showcal.service.module.screen
 * </pre>
 */
public class index {
    public void execute(Context context, Navigator nav) throws Exception {
        nav.forwardTo("dashboard/index");
    }
}
