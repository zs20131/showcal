package net.showcal.api.request.mobile;

import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.domain.mobile.OpenTypeEnum;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.AuthLoginResponse;
import net.showcal.api.response.mobile.LoginResponse;

import java.util.Map;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.api.request.mobile
 *  Description:
 * ***************************************************************
 *  10/17 0017  V1.0  xiniu    New Files for net.showcal.api.request.mobile
 * </pre>
 */
public class AuthLoginRequest implements XiniuRequest<AuthLoginResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();

    /**
     * 获取API名称
     */
    @Override
    public String getApiMethodName() {
        return "mobile.user.authlogin";
    }

    private String openId;
    private String userName;

    private OpenTypeEnum openType;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OpenTypeEnum getType() {
        return openType;
    }

    public void setType(OpenTypeEnum type) {
        this.openType = type;
    }

    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("openId", this.openId);
        txtParams.put("userName", this.userName);
        txtParams.put("openType", this.openType.toString());
        if (this.udfParams != null) {
            txtParams.putAll(this.udfParams);
        }
        return txtParams;
    }

    @Override
    public Long getTimestamp() {
        return null;
    }

    @Override
    public void setTimestamp(Long timestamp) {

    }

    @Override
    public Class getResponseClass() {
        return AuthLoginResponse.class;
    }

    @Override
    public void check() throws ApiRuleException {
    }

    @Override
    public Map<String, String> getHeaderMap() {
        return null;
    }

    @Override
    public void putOtherTextParam(String key, String value) {
        this.udfParams.put(key, value);
    }
}
