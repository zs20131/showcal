package net.showcal.api.request.mobile;

import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.ShowCalGetResponse;

import java.util.Map;


/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.helper.MobileHelperImpl
 *  Description: mobile Request
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public class ShowcalGetRequest implements XiniuRequest<ShowCalGetResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();

    /**
     * 获取API名称
     */
    @Override
    public String getApiMethodName() {
        return "mobile.showCal.get";
    }

    /**
     *
     */
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("Id", this.Id);
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
        return ShowCalGetResponse.class;
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