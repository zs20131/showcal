package net.showcal.api.internal.parser.json;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api.internal.util.json
 *  Description:
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api.internal.util.json
 * </pre>
 */
public interface JSONErrorListener {
    void start(String text);

    void error(String message, int column);

    void end();
}
