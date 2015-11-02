package net.showcal.api.response.mobile;

import net.showcal.api.XiniuResponse;
import net.showcal.api.domain.mobile.ShowCalInfo;

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
public class ShowCalQueryResponse extends XiniuResponse {
    private static final long serialVersionUID = 1L;
    /**
     * 当前页数
     */
    private long totalCount;
    /**
     * 返回对象
     */
    private List<ShowCalInfo> result;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<ShowCalInfo> getResult() {
        return result;
    }

    public void setResult(List<ShowCalInfo> result) {
        this.result = result;
    }
}
