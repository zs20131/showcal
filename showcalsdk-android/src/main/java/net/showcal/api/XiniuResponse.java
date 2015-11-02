package net.showcal.api;

import com.alibaba.fastjson.annotation.JSONField;
import net.showcal.api.error.ErrorType;
import net.showcal.api.error.SubError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api
 *  Description:
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api
 * </pre>
 */
public class XiniuResponse implements Serializable {
    private static final long serialVersionUID = 5014379068811962022L;
    @JSONField(name = "code")
    private String errorCode;

    @JSONField(name = "message")
    private String msg;
    private String solution;

    private List<net.showcal.api.error.Error> errors = new ArrayList<>();
    private List<SubError> subErrors;

    private String body;
    private Map<String, String> params;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public boolean isSuccess() {
        return this.errorCode != null && !"".equals(this.errorCode);
    }

    public List<SubError> getsubErrors() {
        return subErrors;
    }

    public void setsubErrors(List<SubError> subErrors) {
        this.subErrors = subErrors;
    }

    public List<net.showcal.api.error.Error> getErrors() {
        if (errors.isEmpty() && this.errorCode != null && !"".equals(this.errorCode.trim())) {
            net.showcal.api.error.Error error = new net.showcal.api.error.Error(ErrorType.SYSTEM_ERROR, this.msg);
            this.errors.add(error);
        }
        return errors;
    }

    public void addErrors(List<net.showcal.api.error.Error> errors) {
        this.errors = errors;
    }

    public void addError(String code, String message) {
        net.showcal.api.error.Error error = new net.showcal.api.error.Error();
        error.setCode(code);
        error.setMessage(message);
        this.addError(error);
    }

    public void addError(ErrorType type, String message) {
        net.showcal.api.error.Error error = new net.showcal.api.error.Error();
        error.setType(type);
        error.setMessage(message);
        this.addError(error);
    }

    public void addError(net.showcal.api.error.Error error) {
        this.errors.add(error);
    }

    public boolean hasError() {
        return this.errorCode != null && !"".equals(this.errorCode.trim()) || (errors != null) && !errors.isEmpty();
    }
}
