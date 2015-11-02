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
public class BufferErrorListener implements JSONErrorListener {
    protected StringBuffer buffer;
    private String input;

    public BufferErrorListener(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public BufferErrorListener() {
        this(new StringBuffer());
    }

    public void start(String input) {
        this.input = input;
        buffer.setLength(0);
    }

    public void error(String type, int col) {
        buffer.append("expected ");
        buffer.append(type);
        buffer.append(" at column ");
        buffer.append(col);
        buffer.append("\n");
        buffer.append(input);
        buffer.append("\n");
        indent(col - 1, buffer);
        buffer.append("^");
    }

    private void indent(int n, StringBuffer ret) {
        for(int i = 0; i < n; ++i) {
            ret.append(' ');
        }
    }

    public void end() {
    }
}
