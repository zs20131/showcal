package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseSearchRequest;

/**
 *
 * Created on 2014/12/16.
 * @author 吕浩
 * @version 1.0.0
 */
public class UserSearchBySourceTypeRequest extends BaseSearchRequest {
    /**
     * 来源类型
     */
    private String[] sourceTypes;

    /**
     * 是否已激活
     */
    private Boolean isActive;

    public String[] getSourceTypes() {
        return sourceTypes;
    }

    public void setSourceTypes(String[] sourceTypes) {
        this.sourceTypes = sourceTypes;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
