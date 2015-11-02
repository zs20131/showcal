package net.showcal.tool;

import com.alibaba.citrus.service.pull.ToolFactory;

/**
 * Created by DEV005 on 2015/7/21.
 */
public class StringUtilTool implements ToolFactory {
    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Object createTool() throws Exception {
        return new StringUtil();
    }
}
