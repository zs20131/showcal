package net.showcal.api;

/**
 * ***************************************************************
 * <p>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api
 *  Description:API前置检查异常
 * ***************************************************************
 *  11/20 0020  V1.0  xiniunet    New Files for com.xiniunet.api
 * </pre>
 */
public class ApiRuleException extends ApiException {
    private static final long serialVersionUID = -7787145910600194272L;

    public ApiRuleException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }
}
