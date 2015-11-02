package net.showcal.api.request.mobile;

import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.internal.util.RequestCheckUtils;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.PassportGetResponse;

import java.util.Map;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.api.request.mobile
 *  Description:
 * ***************************************************************
 *  10/13 0013  V1.0  xiniu    New Files for net.showcal.api.request.mobile
 * </pre>
 */
public class PassportGetRequest implements XiniuRequest<PassportGetResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getApiMethodName() {
        return "mobile.passport.get";
    }

    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("id", this.id);
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
    public Class<PassportGetResponse> getResponseClass() {
        return PassportGetResponse.class;
    }

    @Override
    public void check() throws ApiRuleException {
        RequestCheckUtils.checkNotEmpty(this.id, "id");
    }

    @Override
    public Map<String, String> getHeaderMap() {
        return null;
    }

    @Override
    public void putOtherTextParam(String key, String value) {

    }
}
