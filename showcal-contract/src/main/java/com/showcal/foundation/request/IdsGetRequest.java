package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
public class IdsGetRequest extends BaseRequest {

    @NotNull
    @Max(20000)
    private Integer count;

    public IdsGetRequest() {
    }

    public IdsGetRequest(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
