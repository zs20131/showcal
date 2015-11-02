package net.showcal.api.request.mobile;

import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.SyncSqlIncrementResponse;

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
public class SyncSqlIncrementRequest implements XiniuRequest<SyncSqlIncrementResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();
    private Integer currentVersion;
    private int pageNumber;
    private int pageSize;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Integer currentVersion) {
        this.currentVersion = currentVersion;
    }

    /**
     * 获取API名称
     */
    @Override
    public String getApiMethodName() {
        return "mobile.incrementSql.sysnc";
    }


    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("currentVersion",this.currentVersion);
        txtParams.put("pageNumber",this.pageNumber);
        txtParams.put("pageSize",this.pageSize);
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
        return SyncSqlIncrementResponse.class;
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