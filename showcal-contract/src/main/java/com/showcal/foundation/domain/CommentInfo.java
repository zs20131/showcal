package com.showcal.foundation.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DEV004 on 2014/10/30.
 */
public class CommentInfo implements Serializable{
    private Long userId;

    private Long id;

    private Long businessId;

    private String content;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date postTime;

    private Long parentId;

    private  Boolean   isAnonymous;

    private Long likeCount;

    private Boolean userIslike;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Boolean getUserIslike() {
        return userIslike;
    }

    public void setUserIslike(Boolean userIslike) {
        this.userIslike = userIslike;
    }
}
