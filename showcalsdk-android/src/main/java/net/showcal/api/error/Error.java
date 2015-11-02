package net.showcal.api.error;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.api.error
 *  Description:
 * ***************************************************************
 *  5/9 0009  V1.0  xiniu    New Files for com.xiniunet.api.error
 * </pre>
 */
public class Error {
    private String code;
    private ErrorType type;
    private String message;

    public Error() {
    }

    public Error(ErrorType type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
