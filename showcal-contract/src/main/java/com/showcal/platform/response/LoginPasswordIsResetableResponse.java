package com.showcal.platform.response;

import com.showcal.platform.domain.PasswordResetReasonEnum;
import com.xiniunet.framework.base.BaseResponse;

/**
 * Created by DEV001 on 2014/8/14.
 */
public class LoginPasswordIsResetableResponse extends BaseResponse {

    /**
     * 是否需要重置
     */
    private Boolean isResetable;

    /**
     * 重置理由
     */
    private PasswordResetReasonEnum passwordResetReasonEnum;

    public PasswordResetReasonEnum getPasswordResetReasonEnum() {
        return passwordResetReasonEnum;
    }

    public void setPasswordResetReasonEnum(PasswordResetReasonEnum passwordResetReasonEnum) {
        this.passwordResetReasonEnum = passwordResetReasonEnum;
    }

    public Boolean getIsResetable() {

        return isResetable;
    }

    public void setIsResetable(Boolean isResetable) {
        this.isResetable = isResetable;
    }
}
