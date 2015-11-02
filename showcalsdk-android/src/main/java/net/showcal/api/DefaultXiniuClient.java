package net.showcal.api;

import net.showcal.api.internal.parser.json.ObjectJsonParser;
import net.showcal.api.internal.parser.xml.ObjectXmlParser;
import net.showcal.api.internal.util.*;

import java.io.IOException;
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
public class DefaultXiniuClient implements XiniuClient {
    private static final String APP_KEY = "app_key";
    private static final String FORMAT = "format";
    private static final String METHOD = "method";
    private static final String TIMESTAMP = "timestamp";
    private static final String VERSION = "v";
    private static final String SIGN = "sign";
    private static final String SIGN_METHOD = "sign_method";
    //    private static final String PARTNER_ID = "partner_id";
    private static final String SESSION = "session";
    private static final String SIMPLIFY = "simplify";

    private String serverUrl;
    private String appKey;
    private String appSecret;
    private String format = Constants.FORMAT_JSON;
    private String signMethod = Constants.SIGN_METHOD_MD5;

    private int connectTimeout = 3000;//3秒
    private int readTimeout = 15000;//15秒
    private boolean needCheckRequest = true; // 是否在客户端校验请求
    private boolean needEnableParser = true; // 是否对响应结果进行解释
    private boolean useSimplifyJson = false; // 是否采用精简化的JSON返回

    public DefaultXiniuClient(String serverUrl, String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.serverUrl = serverUrl;
    }

    public DefaultXiniuClient(String serverUrl, String appKey, String appSecret, String format) {
        this(serverUrl, appKey, appSecret);
        this.format = format;
    }

    public DefaultXiniuClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout) {
        this(serverUrl, appKey, appSecret, format);
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    public DefaultXiniuClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout, String signMethod) {
        this(serverUrl, appKey, appSecret, format, connectTimeout, readTimeout);
        this.signMethod = signMethod;
    }

    public <T extends XiniuResponse> T execute(XiniuRequest<T> request) throws ApiException {
        return execute(request, null);
    }

    public <T extends XiniuResponse> T execute(XiniuRequest<T> request, String session) throws ApiException {
        XiniuParser<T> parser = null;
        if (this.needEnableParser) {
            if (Constants.FORMAT_XML.equals(this.format)) {
                parser = new ObjectXmlParser<T>(request.getResponseClass());
            } else {
                parser = new ObjectJsonParser<T>(request.getResponseClass(), this.useSimplifyJson);
            }
        }
        return _execute(request, parser, session);
    }

    private <T extends XiniuResponse> T _execute(XiniuRequest<T> request, XiniuParser<T> parser, String session) throws ApiException {
        if (this.needCheckRequest) {
            try {
                request.check();
            } catch (ApiRuleException e) {
                T localResponse = null;
                try {
                    localResponse = request.getResponseClass().newInstance();
                } catch (Exception xe) {
                    throw new ApiException(xe);
                }
                localResponse.setErrorCode(e.getErrCode());
                localResponse.setMsg(e.getErrMsg());
                return localResponse;
            }
        }

        RequestParameters context = doPost(request, session);

        T tRsp = null;
        if (this.needEnableParser) {
            try {
                tRsp = parser.parse(context.getResponseBody());
                tRsp.setBody(context.getResponseBody());
            } catch (RuntimeException e) {
                ApiLogger.logBizError(context.getResponseBody());
                throw e;
            }
        } else {
            try {
                tRsp = request.getResponseClass().newInstance();
                tRsp.setBody(context.getResponseBody());
            } catch (Exception e) {
            }
        }

        tRsp.setParams(context.getApplicationParams());
        if (!tRsp.isSuccess()) {
            ApiLogger.logErrorScene(context, tRsp, appSecret);
        }
        return tRsp;
    }


    public <T extends XiniuResponse> RequestParameters doPost(XiniuRequest<T> request, String session) throws ApiException {
        RequestParameters requestParameters = new RequestParameters();
        XiniuHashMap appParams = new XiniuHashMap(request.getTextParams());
        requestParameters.setApplicationParams(appParams);

        // 添加协议级请求参数
        XiniuHashMap protocalMustParams = new XiniuHashMap();
        protocalMustParams.put(METHOD, request.getApiMethodName());
        protocalMustParams.put(VERSION, "1.0");
        protocalMustParams.put(APP_KEY, appKey);
        Long timestamp = request.getTimestamp();// 允许用户设置时间戳
        if (timestamp == null) {
            timestamp = System.currentTimeMillis();
        }

        protocalMustParams.put(TIMESTAMP, timestamp);// 因为沙箱目前只支持时间字符串，所以暂时用Date格式
        requestParameters.setProtocalMustParams(protocalMustParams);

        XiniuHashMap protocalOptParams = new XiniuHashMap();
        protocalOptParams.put(FORMAT, format);
        protocalOptParams.put(SIGN_METHOD, signMethod);
        protocalOptParams.put(SESSION, session);
//        protocalOptParams.put(PARTNER_ID, Constants.SDK_VERSION);
        if (this.useSimplifyJson) {
            protocalOptParams.put(SIMPLIFY, Boolean.TRUE.toString());
        }
        requestParameters.setProtocalOptParams(protocalOptParams);

        // 添加签名参数
        try {
            if (Constants.SIGN_METHOD_MD5.equals(signMethod)) {
                protocalMustParams.put(SIGN, ApiUtils.signTopRequestNew(requestParameters, appSecret, false));
            } else if (Constants.SIGN_METHOD_SHA1.equals(signMethod)) {
                protocalMustParams.put(SIGN, ApiUtils.signTopRequestNew(requestParameters, appSecret, true));
            } else {
                protocalMustParams.put(SIGN, ApiUtils.signTopRequest(requestParameters, appSecret));
            }
        } catch (IOException e) {
            throw new ApiException(e);
        }

        StringBuffer reqUrl = new StringBuffer(serverUrl);
        try {
            String sysMustQuery = WebUtils.buildQuery(requestParameters.getProtocalMustParams(), Constants.CHARSET_UTF8);
            String sysOptQuery = WebUtils.buildQuery(requestParameters.getProtocalOptParams(), Constants.CHARSET_UTF8);

            if (reqUrl.indexOf("?") != -1) {
                reqUrl.append("&");
            } else {
                reqUrl.append("?");
            }
            reqUrl.append(sysMustQuery);
            if (sysOptQuery != null & sysOptQuery.length() > 0) {
                reqUrl.append("&").append(sysOptQuery);
            }
            requestParameters.setRequestUrl(reqUrl.toString());
        } catch (IOException e) {
            throw new ApiException(e);
        }

        String rsp = null;
        try {
            // 是否需要上传文件
            if (request instanceof XiniuUploadRequest) {
                XiniuUploadRequest<T> uRequest = (XiniuUploadRequest<T>) request;
                Map<String, FileItem> fileParams = ApiUtils.cleanupMap(uRequest.getFileParams());
                rsp = WebUtils.doPost(reqUrl.toString(), appParams, fileParams, Constants.CHARSET_UTF8, connectTimeout, readTimeout, request.getHeaderMap());
            } else {
                rsp = WebUtils.doPost(reqUrl.toString(), appParams, Constants.CHARSET_UTF8, connectTimeout, readTimeout, request.getHeaderMap());
            }
            requestParameters.setResponseBody(rsp);
        } catch (IOException e) {
            throw new ApiException(e);
        }
        return requestParameters;
    }

    /**
     * 是否在客户端校验请求参数。
     */
    public void setNeedCheckRequest(boolean needCheckRequest) {
        this.needCheckRequest = needCheckRequest;
    }

    /**
     * 是否把响应字符串解释为对象。
     */
    public void setNeedEnableParser(boolean needEnableParser) {
        this.needEnableParser = needEnableParser;
    }

    /**
     * 是否采用标准化的JSON格式返回。
     */
    public void setUseSimplifyJson(boolean useSimplifyJson) {
        this.useSimplifyJson = useSimplifyJson;
    }

    /**
     * 是否记录API请求错误日志。
     */
    public void setNeedEnableLogger(boolean needEnableLogger) {
        ApiLogger.setNeedEnableLogger(needEnableLogger);
    }

    /**
     * 是否忽略HTTPS证书校验。
     */
    public void setIgnoreSSLCheck(boolean ignore) {
        WebUtils.setIgnoreSSLCheck(ignore);
    }

    /**
     * 设置客户端与TOP网关的最大长连接数量。
     */
    public void setMaxKeepAliveConnections(int amount) {
        System.setProperty("http.maxConnections", String.valueOf(amount));
    }
}
