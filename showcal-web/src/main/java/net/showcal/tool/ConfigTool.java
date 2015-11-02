package net.showcal.tool;

import com.alibaba.citrus.service.pull.ToolFactory;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.single.tool
 *  Description:
 * ***************************************************************
 *  8/4 0004  V1.0  xiniu    New Files for com.xiniunet.single.tool
 * </pre>
 */
public class ConfigTool implements ToolFactory {
    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Object createTool() throws Exception {
        return new SystemConfigObject();
    }
}
