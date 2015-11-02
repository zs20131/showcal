package net.showcal.api.response.mobile;

import net.showcal.api.XiniuResponse;
import net.showcal.api.contract.SortTypeEnum;
import net.showcal.api.domain.mobile.Period;

import java.util.List;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.helper.MobileHelperImpl
 *  Description: mobile Response
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public class PeriodGetResponse extends XiniuResponse {
    private static final long serialVersionUID = 1L;
    /**
     * 生理期时间
     */
    private Period period;
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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

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


}
