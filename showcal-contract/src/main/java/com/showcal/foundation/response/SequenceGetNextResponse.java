package com.showcal.foundation.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV001 on 2014/8/12.
 */
public class SequenceGetNextResponse extends BaseResponse {

    /**
     * 序列号
     */
    private String seqNumber;

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }
}
