/**
 * @(#)RepositoryFindRequest.java
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
package com.showcal.service.request;

import com.xiniunet.framework.base.BaseFindRequest;

import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-16 16:08:34.
 *
 * @author 顾志雄
 */
public class RepositoryFindRequest extends BaseFindRequest {

    /**
     * 知识库类型,
     */
    private String type;
    /**
     * 知识库标签,
     */
    private String tag;

    /**
     * 知识库关键字,
     */
    private String keyword;

    /**
     * 知识库内容,
     */
    private String content;

    /**
     * 知识库问题,
     */
    private String question;

    /**
     * 是否有效,
     */
    private Boolean isActive;
    /**
     * 来源ID 来源ID(瘦咖转让)
     */
    private Long sourceId;

    /**
     * 来源用户ID
     */
    private Long sourceUserId;

    /**
     * 关键字IDS
     */
    private List<Long> keywords;

    /**
     * 标签IDS
     */
    private List<Long> tageIds;

    private String state;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Long> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Long> keywords) {
        this.keywords = keywords;
    }

    public List<Long> getTageIds() {
        return tageIds;
    }

    public void setTageIds(List<Long> tageIds) {
        this.tageIds = tageIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(Long sourceUserId) {
        this.sourceUserId = sourceUserId;
    }


}
