package net.showcal.api.request.mobile;

import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.PeriodGetResponse;

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
public class PeriodGetRequest implements XiniuRequest<PeriodGetResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();

    /**
     * 获取API名称
     */
    @Override
    public String getApiMethodName() {
        return "mobile.period.get";
    }

    /**
     * 当前月份
     */
    private String periodMonth;

    public String getPeriodMonth() {
        return periodMonth;
    }

    public void setPeriodMonth(String periodMonth) {
        this.periodMonth = periodMonth;
    }

    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("periodMonth", this.periodMonth);
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
        return PeriodGetResponse.class;
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