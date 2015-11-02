package com.showcal.merchandise.request;

import com.xiniunet.framework.base.BaseUpdateRequest;

import javax.validation.constraints.NotNull;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.cms.request
 *  Description:
 * ***************************************************************
 *  9/16 0016  V1.0  xiniu    New Files for com.showcal.cms.request
 * </pre>
 */
public class ItemChangeOrderRequest extends BaseUpdateRequest{
    @NotNull(message = "待调整顺序的文章Id不能为空，请检查")
    private Long id;
    @NotNull(message = "待调整的权重不能为空")
    private Integer orderSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(Integer orderSort) {
        this.orderSort = orderSort;
    }
}
