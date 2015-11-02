package net.showcal.api.request.mobile;

import com.alibaba.fastjson.JSON;
import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.UserCurveRecordResponse;

import java.util.List;
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
public class UserCurveRecordRequest implements XiniuRequest<UserCurveRecordResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();

    /**
     * 获取API名称
     */
    @Override
    public String getApiMethodName() {
        return "mobile.userCurve.record";
    }

    /**
     *
     */
    private List curveRecords;

    public List getCurveRecords() {
        return curveRecords;
    }

    public void setCurveRecords(List curveRecords) {
        this.curveRecords = curveRecords;
    }

    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("curveRecords", JSON.toJSONString(this.curveRecords));
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
        return UserCurveRecordResponse.class;
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