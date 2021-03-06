/**
 * @(#)Article.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.cms.domain;

import com.showcal.platform.domain.CommentPost;
import com.xiniunet.framework.base.BaseDomain;

import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-22 11:16:58.
 *
 * @author 顾志雄
 */
public class Article extends BaseDomain {


    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 是否原创
     */
    private Boolean isOriginal;

    /**
     * 作者
     */
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
     * 摘要
     */
    private String summary;

    /**
     * 原文链接
     */
    private String originalUrl;

    /**
     * 分类ID
     */
    private String categoryId;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 已读合计
     */
    private Integer countRead;

    /**
     * 点赞合计
     */
    private Integer countLink;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 评论合计
     */
    private Integer countComment;

    /**
     * 是否已提交
     */
    private Boolean isSubmit;

    /**
     * 提交用户ID
     */
    private Long submitUserId;

    /**
     * 提交用户姓名
     */
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
    private String approveUserName;

    /**
     * 审批时间
     */
    private Date approveTime;

    /**
     * 审批结果
     */
    private String approveResult;

    /**
     * 是否升级成功
     */
    private Boolean isSuccess;

    /**
     * 收藏总数,
     */
    private Integer countConnection;
    /**
     * 内容
     */
    private String content;

    /**
     *
     */
    private String avatarurl;
    //是否点赞
    private Boolean isPraise = false;
    //是否收藏
    private Boolean isCollection = false;
    //文章评论
    private List<CommentPost> commentPost;
    //是否投诉
    private Boolean isComplaint = false;

    /**
     * 发表用户的头像
     */
    private String useravatarurl;
    /**
     * html
     */
    private String html;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getUseravatarurl() {
        return useravatarurl;
    }

    public void setUseravatarurl(String useravatarurl) {
        this.useravatarurl = useravatarurl;
    }

    public Boolean getIsComplaint() {
        return isComplaint;
    }

    public void setIsComplaint(Boolean isComplaint) {
        this.isComplaint = isComplaint;
    }

    public List<CommentPost> getCommentPost() {
        return commentPost;
    }

    public void setCommentPost(List<CommentPost> commentPost) {
        this.commentPost = commentPost;
    }

    public Boolean getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(Boolean isPraise) {
        this.isPraise = isPraise;
    }

    public Boolean getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(Boolean isCollection) {
        this.isCollection = isCollection;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public Integer getCountConnection() {
        return countConnection;
    }

    public void setCountConnection(Integer countConnection) {
        this.countConnection = countConnection;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return this.countLink == null ? 0 : this.countLink;
    }

    public void setCountLink(Integer countLink) {
        this.countLink = countLink;
    }

    public Integer getCountComment() {
        return this.countComment == null ? 0 : this.countComment;
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