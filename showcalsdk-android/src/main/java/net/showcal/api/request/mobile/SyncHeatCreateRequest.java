package net.showcal.api.request.mobile;

import com.alibaba.fastjson.JSON;
import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.response.mobile.SyncHeatCreateResponse;

import java.util.List;
import java.util.Map;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.api.request.mobile
 *  Description:
 * ***************************************************************
 *  10/19 0019  V1.0  xiniu    New Files for net.showcal.api.request.mobile
 * </pre>
 */
public class SyncHeatCreateRequest implements XiniuRequest<SyncHeatCreateResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();

    /**
     * 获取API名称
     */
    @Override
    public String getApiMethodName() {
        return "mobile.heat.sync";
    }

    /**
     * 餐次
     */

    private Long mealsId;

    /**
     * 食物热量
     */

    private Double totalHeat;

    /**
     * 蛋白质(克)
     */

    private Double totalProtein;

    /**
     * 脂肪（克）
     */

    private Double totalFat;

    /**
     * 碳水化合物（克）
     */

    private Double totalCarbohydrate;

    /**
     * 膳食纤维（克）
     */

    private Double totalDf;

    /**
     * 实际评分值
     */

    private Double grade;

    /**
     * 是否同步完成
     */

    private Boolean isSynced;
    /**
     * 同步行记录
     */
    private List<SyncHeatDetailCreateRequest> detail;

    public Long getMealsId() {
        return mealsId;
    }

    public void setMealsId(Long mealsId) {
        this.mealsId = mealsId;
    }

    public Double getTotalHeat() {
        return totalHeat;
    }

    public void setTotalHeat(Double totalHeat) {
        this.totalHeat = totalHeat;
    }

    public Double getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(Double totalProtein) {
        this.totalProtein = totalProtein;
    }

    public Double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(Double totalFat) {
        this.totalFat = totalFat;
    }

    public Double getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    public void setTotalCarbohydrate(Double totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    public Double getTotalDf() {
        return totalDf;
    }

    public void setTotalDf(Double totalDf) {
        this.totalDf = totalDf;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Boolean getIsSynced() {
        return isSynced;
    }

    public void setIsSynced(Boolean isSynced) {
        this.isSynced = isSynced;
    }

    public List<SyncHeatDetailCreateRequest> getDetail() {
        return detail;
    }

    public void setDetail(List<SyncHeatDetailCreateRequest> detail) {
        this.detail = detail;
    }

    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
        txtParams.put("mealsId", this.mealsId);
        txtParams.put("totalHeat", this.totalHeat);
        txtParams.put("totalProtein", this.totalProtein);
        txtParams.put("totalFat", this.totalFat);
        txtParams.put("totalCarbohydrate", this.totalCarbohydrate);
        txtParams.put("totalDf", this.totalDf);
        txtParams.put("grade", this.grade);
        txtParams.put("isSynced", this.isSynced);
        txtParams.put("detail", JSON.toJSONString(this.detail));
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
        return SyncHeatCreateResponse.class;
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
