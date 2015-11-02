package net.showcal.api.request.mobile;

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
public class SyncHeatDetailCreateRequest {

    /**
     * 食物ID
     */

    private  Long   foodId;

    /**
     * 食物名称
     */

    private  String   foodName;

    /**
     * 食物单位
     */
    private  String   unit;

    /**
     * 推荐值
     */

    private  Double   recommendValue;

    /**
     * 实际值
     */

    private  Double   actualValue;

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getRecommendValue() {
        return recommendValue;
    }

    public void setRecommendValue(Double recommendValue) {
        this.recommendValue = recommendValue;
    }

    public Double getActualValue() {
        return actualValue;
    }

    public void setActualValue(Double actualValue) {
        this.actualValue = actualValue;
    }
}
