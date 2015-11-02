package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 *
 * Created on 2014/10/30.
 * @since 1.0.0
 */
public class CommentRecordCreateRequest extends BaseRequest {

    /**
     * 业务类型
     */
    @NotNull
    private String businessType;

    /**
     * 业务ID
     */
    @NotNull
    private Long businessId;

    /**
     * 是否匿名
     */
    @NotNull
    private Boolean anonymous;

    /**
     * 用户ID
     */
    @NotNull
    private Long userId;

    /**
     * 评价内容
     */
    @NotNull
    private String content;

    /**
     * 父评论ID
     */
    private Long parentId;


    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
