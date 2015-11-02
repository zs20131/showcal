package com.showcal.foundation.response;

import com.xiniunet.framework.base.BaseResponse;

import java.util.List;

/**
 * Created by 沈振家 on 2014-07-30 16:10:30.
 *
 * @author 沈振家
 */
public class IdsGetResponse extends BaseResponse {

    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
