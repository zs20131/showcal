package com.showcal.platform.domain;

import com.xiniunet.framework.base.BaseDomain;

/**
 * Created by 范智凝 on 2014-10-24 13:00:30.
 *
 * @author 范智凝
 */
public class VerifyCode extends BaseDomain {

    /**
     * 验证码（字符串）
     */
    private String virifyCode;

    /**
     * 验证码（图片）
     */
    private byte[] img;

    /**
     * 唯一编码
     */
    private Long UID;

    public String getVirifyCode() {
        return virifyCode;
    }

    public void setVirifyCode(String virifyCode) {
        this.virifyCode = virifyCode;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }
}
