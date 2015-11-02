package com.showcal.mobile.request;

import com.showcal.mobile.domain.CurveRecord;
import com.xiniunet.framework.base.BaseRequest;

import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.mobile.request
 *  Description:
 * ***************************************************************
 *  9/18 0018  V1.0  xiniu    New Files for com.showcal.mobile.request
 * </pre>
 */
public class UserCurveRecordRequest extends BaseRequest{

   private List<CurveRecord> curveRecords;

    public List<CurveRecord> getCurveRecords() {
        return curveRecords;
    }

    public void setCurveRecords(List<CurveRecord> curveRecords) {
        this.curveRecords = curveRecords;
    }
}
