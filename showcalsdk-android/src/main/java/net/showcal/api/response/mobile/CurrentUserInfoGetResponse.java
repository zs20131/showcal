package net.showcal.api.response.mobile;

import net.showcal.api.XiniuResponse;
import net.showcal.api.domain.mobile.*;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.helper.MobileHelperImpl
 *  Description: mobile Response
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public class CurrentUserInfoGetResponse extends XiniuResponse {
    private static final long serialVersionUID = 1L;
    /**
     * 同步给手机端的用户详细信息
     */
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


}
