package net.showcal.api.request.mobile;

import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.domain.mobile.SexEnum;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.UserInfoRecordResponse;

import java.util.Date;
import java.util.Map;


/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.helper.MobileHelperImpl
 *  Description: mobile Request
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public class UserInfoRecordRequest implements XiniuRequest<UserInfoRecordResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 性别
     */
    private SexEnum sex;
    /**
     * 身高（厘米）
     */

    private Integer height;

    /**
     * 出生年月
     */

    private Date birthday;


    /**
     * 体重
     */

    private Double weight;

    /**
     * 腰围
     */

    private Double waistLine;

    /**
     * 臀围
     */

    private Double hipline;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWaistLine() {
        return waistLine;
    }

    public void setWaistLine(Double waistLine) {
        this.waistLine = waistLine;
    }

    public Double getHipline() {
        return hipline;
    }

    public void setHipline(Double hipline) {
        this.hipline = hipline;
    }

    /**
     * 获取API名称
     */
    @Override
    public String getApiMethodName() {
        return "mobile.userInfo.record";
    }


    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("userId", this.userId);
        txtParams.put("sex", this.sex);
        txtParams.put("height", this.height);
        txtParams.put("birthday", this.birthday);
        txtParams.put("weight", this.weight);
        txtParams.put("waistLine", this.waistLine);
        txtParams.put("hipline", this.hipline);
        if (this.udfParams != null) {
            txtParams.putAll(this.udfParams);
        }
        return txtParams;
    }

    @Override
    public Long getTimestamp() {
        return null;
    }

    @Override
    public void setTimestamp(Long timestamp) {

    }

    @Override
    public Class getResponseClass() {
        return UserInfoRecordResponse.class;
    }

    @Override
    public void check() throws ApiRuleException {
    }

    @Override
    public Map<String, String> getHeaderMap() {
        return null;
    }

    @Override
    public void putOtherTextParam(String key, String value) {
        this.udfParams.put(key, value);
    }
}