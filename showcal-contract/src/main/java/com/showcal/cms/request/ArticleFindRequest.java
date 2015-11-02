/**
 * @(#)ArticleFindRequest.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.cms.request;

import com.xiniunet.framework.base.BaseFindRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 *
 * @author 顾志雄
 */
public class ArticleFindRequest extends BaseFindRequest {

    /**
     * 点赞数
     */
    private Integer countStartLink;
    /**
     * 点赞数
     */
    private Integer countEndLink;
    /**
     * 评论数
     */
    private Integer countStartComment;
    /**
     * 评论数
     */
    private Integer countEndComment;
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
     * 题目
     */
    private String title;
    /**
     * 提交用户ID,
     */
    private Long submitUserId;

    /**
     * 提交用户姓名,
     */
    private String submitUserName;

    /**
     * 审批用户ID,
     */
    private Long approveUserId;

    /**
     * 审批用户姓名,
     */
    private String approveUserName;
    /**
     * 根据文章类别查询
     */
    private String categoryId;
    //查询条件
    private List<Long> alreadySubmit = new ArrayList<Long>();

    private String orderSort;

    private String orderRule;


    /**
     * 最热
     */
    private Boolean isHot;
    /**
     * ID列表
     */
    private List<Long> ids;


    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public String getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(String orderSort) {
        this.orderSort = orderSort;
    }

    public String getOrderRule() {
        return orderRule;
    }

    public void setOrderRule(String orderRule) {
        this.orderRule = orderRule;
    }

    public List<Long> getAlreadySubmit() {
        return alreadySubmit;
    }

    public void setAlreadySubmit(List<Long> alreadySubmit) {
        this.alreadySubmit = alreadySubmit;
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

    public Integer getCountStartLink() {
        return countStartLink;
    }

    public void setCountStartLink(Integer countStartLink) {
        this.countStartLink = countStartLink;
    }

    public Integer getCountEndLink() {
        return countEndLink;
    }

    public void setCountEndLink(Integer countEndLink) {
        this.countEndLink = countEndLink;
    }

    public Integer getCountStartComment() {
        return countStartComment;
    }

    public void setCountStartComment(Integer countStartComment) {
        this.countStartComment = countStartComment;
    }

    public Integer getCountEndComment() {
        return countEndComment;
    }

    public void setCountEndComment(Integer countEndComment) {
        this.countEndComment = countEndComment;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSubmitUserId() {
        return this.submitUserId;
    }

    public void setSubmitUserId(Long submitUserId) {
        this.submitUserId = submitUserId;
    }


    public String getSubmitUserName() {
        return this.submitUserName;
    }

    public void setSubmitUserName(String submitUserName) {
        this.submitUserName = submitUserName;
    }


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Long getApproveUserId() {
        return this.approveUserId;
    }

    public void setApproveUserId(Long approveUserId) {
        this.approveUserId = approveUserId;
    }


    public String getApproveUserName() {
        return this.approveUserName;
    }

    public void setApproveUserName(String approveUserName) {
        this.approveUserName = approveUserName;
    }


}
