package com.showcal.foundation.response;

import com.xiniunet.framework.base.BaseResponse;

import java.util.List;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class SequenceListGetResponse extends BaseResponse {

    /**
     * 序列号
     */
    private List<String> seqNumberList;

    public List<String> getSeqNumberList() {
        return seqNumberList;
    }

    public void setSeqNumberList(List<String> seqNumberList) {
        this.seqNumberList = seqNumberList;
    }
}
