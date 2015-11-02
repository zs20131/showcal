/**
 * @(#)ArticleCreateRequest.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
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

import com.xiniunet.framework.base.BaseRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-22 11:16:58.
 * @author 顾志雄
 */
public class ArticleCreateRequest extends BaseRequest {

    /**
     * 标题 
     */

    @Length(min = 1, max = 1000, message = "标题长度不合法")
    private String title;

    /**
     * 是否原创 
     */

    private Boolean isOriginal;

    /**
     * 作者 
     */

    @Length(min = 0, max = 50, message = "作者长度不合法")
    private String authorName;

    /**
     * 封面图片ID 
     */

    private Long coverId;

    /**
     * 是否封面显示在正文中 
     */

    private Boolean isCoverInBody;
    /**
     * 权重
     */
    private Integer weight=1;

    /**
     * 摘要 
     */

    @Length(min = 1, max = 1000, message = "摘要长度不合法")
    private String summary;

    /**
     * 原文链接 
     */

    @Length(min = 0, max = 50, message = "原文链接长度不合法")
    private String originalUrl;

    /**
     * 分类ID 
     */

    @Length(min = 0, max = 50, message = "分类ID长度不合法")
    private String categoryId;

    /**
     * 关键字 
     */

    @Length(min = 0, max = 50, message = "关键字长度不合法")
    private String keywords;

    /**
     * 已读合计 
     */

    private Integer countRead=0;

    /**
     * 点赞合计 
     */

    private Integer countLink=0;

    /**
     * 评论合计 
     */

    private Integer countComment=0;

    /**
     * 是否已提交 
     */
    @NotNull(message = "是否已提交不能为空")
    private Boolean isSubmit=false;

    /**
     * 提交用户ID 
     */

    private Long submitUserId;

    /**
     * 提交用户姓名 
     */

    @Length(min = 0, max = 50, message = "提交用户姓名长度不合法")
    private String submitUserName;

    /**
     * 提交时间 
     */

    private Date submitTime;

    /**
     * 是否已审批 
     */

    private Boolean isApproved;

    /**
     * 审批用户ID 
     */

    private Long approveUserId;

    /**
     * 审批用户姓名 
     */

    @Length(min = 0, max = 50, message = "审批用户姓名长度不合法")
    private String approveUserName;

    /**
     * 审批时间 
     */

    private Date approveTime;

    /**
     * 审批结果 
     */

    @Length(min = 0, max = 50, message = "审批结果长度不合法")
    private String approveResult;
    /**
     * 是否是手机
     */
    private Boolean isMobile=false;

    private String content;

    public Boolean getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(Boolean isMobile) {
        this.isMobile = isMobile;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsOriginal() {
        return this.isOriginal;
    }

    public void setIsOriginal(Boolean isOriginal) {
        this.isOriginal = isOriginal;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getCoverId() {
        return this.coverId;
    }

    public void setCoverId(Long coverId) {
        this.coverId = coverId;
    }

    public Boolean getIsCoverInBody() {
        return this.isCoverInBody;
    }

    public void setIsCoverInBody(Boolean isCoverInBody) {
        this.isCoverInBody = isCoverInBody;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getCountRead() {
        return this.countRead;
    }

    public void setCountRead(Integer countRead) {
        this.countRead = countRead;
    }

    public Integer getCountLink() {
        return this.countLink;
    }

    public void setCountLink(Integer countLink) {
        this.countLink = countLink;
    }

    public Integer getCountComment() {
        return this.countComment;
    }

    public void setCountComment(Integer countComment) {
        this.countComment = countComment;
    }

    public Boolean getIsSubmit() {
        return this.isSubmit;
    }

    public void setIsSubmit(Boolean isSubmit) {
        this.isSubmit = isSubmit;
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

    public Date getSubmitTime() {
        return this.submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Boolean getIsApproved() {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
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

    public Date getApproveTime() {
        return this.approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public String getApproveResult() {
        return this.approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }


}
