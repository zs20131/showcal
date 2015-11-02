/**
 * @(#)ItemFindRequest.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.merchandise.request;

import com.xiniunet.framework.base.BaseFindRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 * @author 顾志雄
 */
public class ItemFindRequest extends BaseFindRequest {


    /**
     * 收藏数
     */
    private Integer countStartCollection;
    /**
     * 收藏数
     */
    private Integer countEndCollection;
    /**
     * 发布时间
     */
    private String approveStartTime;
    /**
     * 发布时间
     */
    private String approveEndTime;
    /**
     * 名称
     */
    private String title;

    /**
     * 根据文章类别查询
     */
    private Long categoryId;

    //查询条件
    private List<Long> alreadySubmit = new ArrayList<Long>();


    public Integer getCountStartCollection() {
        return countStartCollection;
    }

    public void setCountStartCollection(Integer countStartCollection) {
        this.countStartCollection = countStartCollection;
    }

    public Integer getCountEndCollection() {
        return countEndCollection;
    }

    public void setCountEndCollection(Integer countEndCollection) {
        this.countEndCollection = countEndCollection;
    }

    public String getApproveStartTime() {
        return approveStartTime;
    }

    public void setApproveStartTime(String approveStartTime) {
        this.approveStartTime = approveStartTime;
    }

    public String getApproveEndTime() {
        return approveEndTime;
    }

    public void setApproveEndTime(String approveEndTime) {
        this.approveEndTime = approveEndTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Long> getAlreadySubmit() {
        return alreadySubmit;
    }

    public void setAlreadySubmit(List<Long> alreadySubmit) {
        this.alreadySubmit = alreadySubmit;
    }
}
