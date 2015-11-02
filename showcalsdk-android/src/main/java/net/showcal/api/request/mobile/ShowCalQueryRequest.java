package net.showcal.api.request.mobile;

import com.alibaba.fastjson.JSON;
import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.contract.SortTypeEnum;
import net.showcal.api.internal.util.RequestCheckUtils;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.ShowCalQueryResponse;

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
public class ShowCalQueryRequest implements XiniuRequest<ShowCalQueryResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();

    /**
     * 获取API名称
     */
    @Override
    public String getApiMethodName() {
        return "mobile.showCal.query";
    }

    /**
     * 当前页数
     */
    private int pageNumber;
    /**
     * 分页大小
     */
    private int pageSize;
    /**
     * 排序列
     */
    private List sortKey;
    /**
     * 排序方式
     */
    private SortTypeEnum sortType;

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

    public List getSortKey() {
        return sortKey;
    }

    public void setSortKey(List sortKey) {
        this.sortKey = sortKey;
    }

    public SortTypeEnum getSortType() {
        return sortType;
    }

    public void setSortType(SortTypeEnum sortType) {
        this.sortType = sortType;
    }

    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("pageNumber", this.pageNumber);
        txtParams.put("pageSize", this.pageSize);
        txtParams.put("sortKey", JSON.toJSONString(this.sortKey));
        txtParams.put("sortType", this.sortType);
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
        return ShowCalQueryResponse.class;
    }

    @Override
    public void check() throws ApiRuleException {
        RequestCheckUtils.checkNotEmpty(pageNumber, "pageNumber");

        RequestCheckUtils.checkNotEmpty(pageSize, "pageSize");

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