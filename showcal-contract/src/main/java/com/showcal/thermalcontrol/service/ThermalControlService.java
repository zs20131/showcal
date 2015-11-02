package com.showcal.thermalcontrol.service;

import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.thermalcontrol.service
 *  Description:
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.thermalcontrol.service
 * </pre>
 */
public interface ThermalControlService {
    /**
     * 根据Id获取基础热量设置
     *
     * @param request 获取基础热量设置请求
     * @param passport 用户护照
     * @return 获取基础热量设置应答
     */
    BaseHeatGetResponse getBaseHeat(BaseHeatGetRequest request, Passport passport);

    /**
     * 高级查询基础热量设置
     *
     * @param request 高级查询基础热量设置请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    BaseHeatFindResponse findBaseHeat(BaseHeatFindRequest request, Passport passport);

    SportHeadListImportResponse importList(SportHeadListImportRequest request, Passport passport);
    /**
     * 创建基础热量设置
     *
     * @param request 创建基础热量设置请求
     * @param passport 用户护照
     * @return 创建基础热量设置应答
     */
    BaseHeatCreateResponse createBaseHeat(BaseHeatCreateRequest request, Passport passport);


    /**
     * 更新基础热量设置
     *
     * @param request 更新基础热量设置请求
     * @param passport 用户护照
     * @return 更新基础热量设置应答
     */
    BaseHeatUpdateResponse updateBaseHeat(BaseHeatUpdateRequest request, Passport passport);


    /**
     * 删除基础热量设置
     *
     * @param request 删除基础热量设置请求
     * @param passport 用户护照
     * @return 删除基础热量设置应答
     */
    BaseHeatDeleteResponse deleteBaseHeat(BaseHeatDeleteRequest request, Passport passport);

    /**
     * 根据Id获取BMI食物总重量
     *
     * @param request 获取BMI食物总重量请求
     * @param passport 用户护照
     * @return 获取BMI食物总重量应答
     */
    BmiFoodGetResponse getBmiFood(BmiFoodGetRequest request, Passport passport);


    /**
     * 高级查询BMI食物总重量
     *
     * @param request 高级查询BMI食物总重量请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    BmiFoodFindResponse findBmiFood(BmiFoodFindRequest request, Passport passport);


    /**
     * 创建BMI食物总重量
     *
     * @param request 创建BMI食物总重量请求
     * @param passport 用户护照
     * @return 创建BMI食物总重量应答
     */
    BmiFoodCreateResponse createBmiFood(BmiFoodCreateRequest request, Passport passport);


    /**
     * 更新BMI食物总重量
     *
     * @param request 更新BMI食物总重量请求
     * @param passport 用户护照
     * @return 更新BMI食物总重量应答
     */
    BmiFoodUpdateResponse updateBmiFood(BmiFoodUpdateRequest request, Passport passport);


    /**
     * 删除BMI食物总重量
     *
     * @param request 删除BMI食物总重量请求
     * @param passport 用户护照
     * @return 删除BMI食物总重量应答
     */
    BmiFoodDeleteResponse deleteBmiFood(BmiFoodDeleteRequest request, Passport passport);


    /**
     * 作废BMI食物总重量
     *
     * @param request 作废BMI食物总重量请求
     * @param passport 用户护照
     * @return 作废BMI食物总重量应答
     */
    BmiFoodInactiveResponse inactiveBmiFood(BmiFoodInactiveRequest request, Passport passport);


    /**
     * 激活BMI食物总重量
     *
     * @param request 激活BMI食物总重量请求
     * @param passport 用户护照
     * @return 激活BMI食物总重量应答
     */
    BmiFoodActiveResponse activeBmiFood(BmiFoodActiveRequest request, Passport passport);


    /**
     * 高级查询评价基础
     *
     * @param request 高级查询评价基础请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    EvaluateFindResponse findEvaluate(EvaluateFindRequest request, Passport passport);

    /**
     * 创建评价基础
     *
     * @param request 创建评价基础请求
     * @param passport 用户护照
     * @return 创建评价基础应答
     */
    EvaluateCreateResponse createEvaluate(EvaluateCreateRequest request, Passport passport);


    /**
     * 更新评价基础
     *
     * @param request 更新评价基础请求
     * @param passport 用户护照
     * @return 更新评价基础应答
     */
    EvaluateUpdateResponse updateEvaluate(EvaluateUpdateRequest request, Passport passport);

    /**
     * 高级查询食物类别
     *
     * @param request 高级查询食物类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    FoodCategoryFindResponse findFoodCategory(FoodCategoryFindRequest request, Passport passport);

    /**
     * 获取所有食物类别列表
     *
     * @param request 获取所有食物类别列表请求
     * @param passport 用户护照
     * @return 获取所有食物类别列表应答
     */
    FoodCategoryGetAllListResponse getFoodCategoryAllList(FoodCategoryGetAllListRequest request, Passport passport);


    /**
     * 创建食物类别
     *
     * @param request 创建食物类别请求
     * @param passport 用户护照
     * @return 创建食物类别应答
     */
    FoodCategoryCreateResponse createFoodCategory(FoodCategoryCreateRequest request, Passport passport);

    SportSettingListImportResponse importList(SportSettingListImportRequest request, Passport passport);
    /**
     * 更新食物类别
     *
     * @param request 更新食物类别请求
     * @param passport 用户护照
     * @return 更新食物类别应答
     */
    FoodCategoryUpdateResponse updateFoodCategory(FoodCategoryUpdateRequest request, Passport passport);


    /**
     * 删除食物类别
     *
     * @param request 删除食物类别请求
     * @param passport 用户护照
     * @return 删除食物类别应答
     */
    FoodCategoryDeleteResponse deleteFoodCategory(FoodCategoryDeleteRequest request, Passport passport);

    /**
     * 高级查询食物交换份
     *
     * @param request 高级查询食物交换份请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    FoodExchangeFindResponse findFoodExchange(FoodExchangeFindRequest request, Passport passport);

    /**
     * 获取所有食物交换份列表
     *
     * @param request 获取所有食物交换份列表请求
     * @param passport 用户护照
     * @return 获取所有食物交换份列表应答
     */
    FoodExchangeGetAllListResponse getFoodExchangeAllList(FoodExchangeGetAllListRequest request, Passport passport);


    /**
     * 创建食物交换份
     *
     * @param request 创建食物交换份请求
     * @param passport 用户护照
     * @return 创建食物交换份应答
     */
    FoodExchangeCreateResponse createFoodExchange(FoodExchangeCreateRequest request, Passport passport);


    /**
     * 更新食物交换份
     *
     * @param request 更新食物交换份请求
     * @param passport 用户护照
     * @return 更新食物交换份应答
     */
    FoodExchangeUpdateResponse updateFoodExchange(FoodExchangeUpdateRequest request, Passport passport);


    /**
     * 删除食物交换份
     *
     * @param request 删除食物交换份请求
     * @param passport 用户护照
     * @return 删除食物交换份应答
     */
    FoodExchangeDeleteResponse deleteFoodExchange(FoodExchangeDeleteRequest request, Passport passport);


    /**
     * 作废食物交换份
     *
     * @param request 作废食物交换份请求
     * @param passport 用户护照
     * @return 作废食物交换份应答
     */
    FoodExchangeInactiveResponse inactiveFoodExchange(FoodExchangeInactiveRequest request, Passport passport);


    /**
     * 激活食物交换份
     *
     * @param request 激活食物交换份请求
     * @param passport 用户护照
     * @return 激活食物交换份应答
     */
    FoodExchangeActiveResponse activeFoodExchange(FoodExchangeActiveRequest request, Passport passport);


    /**
     * 高级查询食物
     *
     * @param request 高级查询食物请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    FoodFindResponse findFood(FoodFindRequest request, Passport passport);

    /**
     * 创建食物
     *
     * @param request 创建食物请求
     * @param passport 用户护照
     * @return 创建食物应答
     */
    FoodCreateResponse createFood(FoodCreateRequest request, Passport passport);


    /**
     * 更新食物
     *
     * @param request 更新食物请求
     * @param passport 用户护照
     * @return 更新食物应答
     */
    FoodUpdateResponse updateFood(FoodUpdateRequest request, Passport passport);

    /**
     * 获取食物
     *
     * @param request 更新食物请求
     * @param passport 用户护照
     * @return 更新食物应答
     */
    FoodGetResponse getFood(FoodGetRequest request, Passport passport);


    /**
     * 删除食物
     *
     * @param request 删除食物请求
     * @param passport 用户护照
     * @return 删除食物应答
     */
    FoodDeleteResponse deleteFood(FoodDeleteRequest request, Passport passport);


    /**
     * 作废食物
     *
     * @param request 作废食物请求
     * @param passport 用户护照
     * @return 作废食物应答
     */
    FoodInactiveResponse inactiveFood(FoodInactiveRequest request, Passport passport);


    /**
     * 激活食物
     *
     * @param request 激活食物请求
     * @param passport 用户护照
     * @return 激活食物应答
     */
    FoodActiveResponse activeFood(FoodActiveRequest request, Passport passport);

    /**
     * 上传
     *
     * @param request 上传食物请求
     * @param passport 用户护照
     * @return 上传食物应答
     */
    FoodListImportResponse importFoodList(FoodListImportRequest request, Passport passport);

    /**
     * 根据Id获取打分权重表
     *
     * @param request 获取打分权重表请求
     * @param passport 用户护照
     * @return 获取打分权重表应答
     */
    GradeWeightGetResponse getGradeWeight(GradeWeightGetRequest request, Passport passport);


    /**
     * 模糊查询打分权重表
     *
     * @param request 模糊查询打分权重表请求
     * @param passport 用户护照
     * @return 模糊查询打分权重表应答
     */
    GradeWeightSearchResponse searchGradeWeight(GradeWeightSearchRequest request, Passport passport);

    /**
     * 高级查询打分权重表
     *
     * @param request 高级查询打分权重表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    GradeWeightFindResponse findGradeWeight(GradeWeightFindRequest request, Passport passport);

    /**
     * 获取所有打分权重表列表
     *
     * @param request 获取所有打分权重表列表请求
     * @param passport 用户护照
     * @return 获取所有打分权重表列表应答
     */
    GradeWeightGetAllListResponse getGradeWeightAllList(GradeWeightGetAllListRequest request, Passport passport);


    /**
     * 创建打分权重表
     *
     * @param request 创建打分权重表请求
     * @param passport 用户护照
     * @return 创建打分权重表应答
     */
    GradeWeightCreateResponse createGradeWeight(GradeWeightCreateRequest request, Passport passport);


    /**
     * 更新打分权重表
     *
     * @param request 更新打分权重表请求
     * @param passport 用户护照
     * @return 更新打分权重表应答
     */
    GradeWeightUpdateResponse updateGradeWeight(GradeWeightUpdateRequest request, Passport passport);


    /**
     * 删除打分权重表
     *
     * @param request 删除打分权重表请求
     * @param passport 用户护照
     * @return 删除打分权重表应答
     */
    GradeWeightDeleteResponse deleteGradeWeight(GradeWeightDeleteRequest request, Passport passport);

    /**
     * 根据当前时间获取餐次
     *
     * @param request 获取餐次请求
     * @param passport 用户护照
     * @return 获取餐次应答
     */
    MealsGetResponse getMeals(MealsGetRequest request, Passport passport);

    /**
     * 高级查询餐次
     *
     * @param request 高级查询餐次请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    MealsFindResponse findMeals(MealsFindRequest request, Passport passport);

    /**
     * 创建餐次
     *
     * @param request 创建餐次请求
     * @param passport 用户护照
     * @return 创建餐次应答
     */
    MealsCreateResponse createMeals(MealsCreateRequest request, Passport passport);


    /**
     * 更新餐次
     *
     * @param request 更新餐次请求
     * @param passport 用户护照
     * @return 更新餐次应答
     */
    MealsUpdateResponse updateMeals(MealsUpdateRequest request, Passport passport);


    /**
     * 删除餐次
     *
     * @param request 删除餐次请求
     * @param passport 用户护照
     * @return 删除餐次应答
     */
    MealsDeleteResponse deleteMeals(MealsDeleteRequest request, Passport passport);

    /**
     * 根据Id获取营养目标
     *
     * @param request 获取营养目标请求
     * @param passport 用户护照
     * @return 获取营养目标应答
     */
    NutritionalGoalGetResponse getNutritionalGoal(NutritionalGoalGetRequest request, Passport passport);


    /**
     * 模糊查询营养目标
     *
     * @param request 模糊查询营养目标请求
     * @param passport 用户护照
     * @return 模糊查询营养目标应答
     */
    NutritionalGoalSearchResponse searchNutritionalGoal(NutritionalGoalSearchRequest request, Passport passport);

    /**
     * 高级查询营养目标
     *
     * @param request 高级查询营养目标请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    NutritionalGoalFindResponse findNutritionalGoal(NutritionalGoalFindRequest request, Passport passport);

    /**
     * 创建营养目标
     *
     * @param request 创建营养目标请求
     * @param passport 用户护照
     * @return 创建营养目标应答
     */
    NutritionalGoalCreateResponse createNutritionalGoal(NutritionalGoalCreateRequest request, Passport passport);


    /**
     * 更新营养目标
     *
     * @param request 更新营养目标请求
     * @param passport 用户护照
     * @return 更新营养目标应答
     */
    NutritionalGoalUpdateResponse updateNutritionalGoal(NutritionalGoalUpdateRequest request, Passport passport);


    /**
     * 删除营养目标
     *
     * @param request 删除营养目标请求
     * @param passport 用户护照
     * @return 删除营养目标应答
     */
    NutritionalGoalDeleteResponse deleteNutritionalGoal(NutritionalGoalDeleteRequest request, Passport passport);


    /**
     * 作废营养目标
     *
     * @param request 作废营养目标请求
     * @param passport 用户护照
     * @return 作废营养目标应答
     */
    NutritionalGoalInactiveResponse inactiveNutritionalGoal(NutritionalGoalInactiveRequest request, Passport passport);


    /**
     * 激活营养目标
     *
     * @param request 激活营养目标请求
     * @param passport 用户护照
     * @return 激活营养目标应答
     */
    NutritionalGoalActiveResponse activeNutritionalGoal(NutritionalGoalActiveRequest request, Passport passport);

    /**
     * 根据Id获取运动方案
     *
     * @param request 获取运动方案请求
     * @param passport 用户护照
     * @return 获取运动方案应答
     */
    SportHeadGetResponse getSportHead(SportHeadGetRequest request, Passport passport);


    /**
     * 高级查询运动方案
     *
     * @param request 高级查询运动方案请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SportHeadFindResponse findSportHead(SportHeadFindRequest request, Passport passport);

    /**
     * 创建运动方案
     *
     * @param request 创建运动方案请求
     * @param passport 用户护照
     * @return 创建运动方案应答
     */
    SportHeadCreateResponse createSportHead(SportHeadCreateRequest request, Passport passport);


    /**
     * 更新运动方案
     *
     * @param request 更新运动方案请求
     * @param passport 用户护照
     * @return 更新运动方案应答
     */
    SportHeadUpdateResponse updateSportHead(SportHeadUpdateRequest request, Passport passport);

    /**
     * 更新运动方案totalTime
     *
     * @param request 更新运动方案请求
     * @param passport 用户护照
     * @return 更新运动方案totalTime应答
     */
    SportHeadUpdateTotalTimeResponse updateSportHeadTotalTime(SportHeadUpdateTotalTimeRequest request, Passport passport);


    /**
     * 删除运动方案
     *
     * @param request 删除运动方案请求
     * @param passport 用户护照
     * @return 删除运动方案应答
     */
    SportHeadDeleteResponse deleteSportHead(SportHeadDeleteRequest request, Passport passport);


    /**
     * 获取所有运动方案明细列表
     *
     * @param request 获取所有运动方案明细列表请求
     * @param passport 用户护照
     * @return 获取所有运动方案明细列表应答
     */
    SportLineGetAllListResponse getSportLineAllList(SportLineGetAllListRequest request, Passport passport);


    /**
     * 创建运动方案明细
     *
     * @param request 创建运动方案明细请求
     * @param passport 用户护照
     * @return 创建运动方案明细应答
     */
    SportLineCreateResponse createSportLine(SportLineCreateRequest request, Passport passport);


    /**
     * 更新运动方案明细
     *
     * @param request 更新运动方案明细请求
     * @param passport 用户护照
     * @return 更新运动方案明细应答
     */
    SportLineUpdateResponse updateSportLine(SportLineUpdateRequest request, Passport passport);


    /**
     * 删除运动方案明细
     *
     * @param request 删除运动方案明细请求
     * @param passport 用户护照
     * @return 删除运动方案明细应答
     */
    SportLineDeleteResponse deleteSportLine(SportLineDeleteRequest request, Passport passport);

    /**
     * 根据Id获取运动主数据
     *
     * @param request 获取运动主数据请求
     * @param passport 用户护照
     * @return 获取运动主数据应答
     */
    SportSettingGetResponse getSportSetting(SportSettingGetRequest request, Passport passport);


    /**
     * 模糊查询运动主数据
     *
     * @param request 模糊查询运动主数据请求
     * @param passport 用户护照
     * @return 模糊查询运动主数据应答
     */
    SportSettingSearchResponse searchSportSetting(SportSettingSearchRequest request, Passport passport);

    /**
     * 高级查询运动主数据
     *
     * @param request 高级查询运动主数据请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SportSettingFindResponse findSportSetting(SportSettingFindRequest request, Passport passport);

    /**
     * 获取所有运动主数据列表
     *
     * @param request 获取所有运动主数据列表请求
     * @param passport 用户护照
     * @return 获取所有运动主数据列表应答
     */
    SportSettingGetAllListResponse getSportSettingAllList(SportSettingGetAllListRequest request, Passport passport);


    /**
     * 创建运动主数据
     *
     * @param request 创建运动主数据请求
     * @param passport 用户护照
     * @return 创建运动主数据应答
     */
    SportSettingCreateResponse createSportSetting(SportSettingCreateRequest request, Passport passport);


    /**
     * 更新运动主数据
     *
     * @param request 更新运动主数据请求
     * @param passport 用户护照
     * @return 更新运动主数据应答
     */
    SportSettingUpdateResponse updateSportSetting(SportSettingUpdateRequest request, Passport passport);


    /**
     * 删除运动主数据
     *
     * @param request 删除运动主数据请求
     * @param passport 用户护照
     * @return 删除运动主数据应答
     */
    SportSettingDeleteResponse deleteSportSetting(SportSettingDeleteRequest request, Passport passport);

    /**
     * 根据Id获取热量同步明细表
     *
     * @param request 获取热量同步明细表请求
     * @param passport 用户护照
     * @return 获取热量同步明细表应答
     */
    SyncHeatDetailGetResponse getSyncHeatDetail(SyncHeatDetailGetRequest request, Passport passport);


    /**
     * 模糊查询热量同步明细表
     *
     * @param request 模糊查询热量同步明细表请求
     * @param passport 用户护照
     * @return 模糊查询热量同步明细表应答
     */
    SyncHeatDetailSearchResponse searchSyncHeatDetail(SyncHeatDetailSearchRequest request, Passport passport);

    /**
     * 高级查询热量同步明细表
     *
     * @param request 高级查询热量同步明细表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SyncHeatDetailFindResponse findSyncHeatDetail(SyncHeatDetailFindRequest request, Passport passport);

    /**
     * 获取所有热量同步明细表列表
     *
     * @param request 获取所有热量同步明细表列表请求
     * @param passport 用户护照
     * @return 获取所有热量同步明细表列表应答
     */
    SyncHeatDetailGetAllListResponse getSyncHeatDetailAllList(SyncHeatDetailGetAllListRequest request, Passport passport);


    /**
     * 创建热量同步明细表
     *
     * @param request 创建热量同步明细表请求
     * @param passport 用户护照
     * @return 创建热量同步明细表应答
     */
    SyncHeatDetailCreateResponse createSyncHeatDetail(SyncHeatDetailCreateRequest request, Passport passport);


    /**
     * 更新热量同步明细表
     *
     * @param request 更新热量同步明细表请求
     * @param passport 用户护照
     * @return 更新热量同步明细表应答
     */
    SyncHeatDetailUpdateResponse updateSyncHeatDetail(SyncHeatDetailUpdateRequest request, Passport passport);


    /**
     * 删除热量同步明细表
     *
     * @param request 删除热量同步明细表请求
     * @param passport 用户护照
     * @return 删除热量同步明细表应答
     */
    SyncHeatDetailDeleteResponse deleteSyncHeatDetail(SyncHeatDetailDeleteRequest request, Passport passport);

    /**
     * 根据Id获取热量同步表
     *
     * @param request 获取热量同步表请求
     * @param passport 用户护照
     * @return 获取热量同步表应答
     */
    SyncHeatGetResponse getSyncHeat(SyncHeatGetRequest request, Passport passport);


    /**
     * 模糊查询热量同步表
     *
     * @param request 模糊查询热量同步表请求
     * @param passport 用户护照
     * @return 模糊查询热量同步表应答
     */
    SyncHeatSearchResponse searchSyncHeat(SyncHeatSearchRequest request, Passport passport);

    /**
     * 高级查询热量同步表
     *
     * @param request 高级查询热量同步表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SyncHeatFindResponse findSyncHeat(SyncHeatFindRequest request, Passport passport);

    /**
     * 获取所有热量同步表列表
     *
     * @param request 获取所有热量同步表列表请求
     * @param passport 用户护照
     * @return 获取所有热量同步表列表应答
     */
    SyncHeatGetAllListResponse getSyncHeatAllList(SyncHeatGetAllListRequest request, Passport passport);


    /**
     * 创建热量同步表
     *
     * @param request 创建热量同步表请求
     * @param passport 用户护照
     * @return 创建热量同步表应答
     */
    SyncHeatCreateResponse createSyncHeat(SyncHeatCreateRequest request, Passport passport);


    /**
     * 更新热量同步表
     *
     * @param request 更新热量同步表请求
     * @param passport 用户护照
     * @return 更新热量同步表应答
     */
    SyncHeatUpdateResponse updateSyncHeat(SyncHeatUpdateRequest request, Passport passport);


    /**
     * 删除热量同步表
     *
     * @param request 删除热量同步表请求
     * @param passport 用户护照
     * @return 删除热量同步表应答
     */
    SyncHeatDeleteResponse deleteSyncHeat(SyncHeatDeleteRequest request, Passport passport);
    /**
     * 根据Id获取运动同步表)
     *
     * @param request 获取运动同步表)请求
     * @param passport 用户护照
     * @return 获取运动同步表)应答
     */
    SyncSportGetResponse getSyncSport(SyncSportGetRequest request, Passport passport);


    /**
     * 模糊查询运动同步表)
     *
     * @param request 模糊查询运动同步表)请求
     * @param passport 用户护照
     * @return 模糊查询运动同步表)应答
     */
    SyncSportSearchResponse searchSyncSport(SyncSportSearchRequest request, Passport passport);

    /**
     * 高级查询运动同步表)
     *
     * @param request 高级查询运动同步表)请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    SyncSportFindResponse findSyncSport(SyncSportFindRequest request, Passport passport);

    /**
     * 获取所有运动同步表)列表
     *
     * @param request 获取所有运动同步表)列表请求
     * @param passport 用户护照
     * @return 获取所有运动同步表)列表应答
     */
    SyncSportGetAllListResponse getSyncSportAllList(SyncSportGetAllListRequest request, Passport passport);


    /**
     * 创建运动同步表)
     *
     * @param request 创建运动同步表)请求
     * @param passport 用户护照
     * @return 创建运动同步表)应答
     */
    SyncSportCreateResponse createSyncSport(SyncSportCreateRequest request, Passport passport);


    /**
     * 更新运动同步表)
     *
     * @param request 更新运动同步表)请求
     * @param passport 用户护照
     * @return 更新运动同步表)应答
     */
    SyncSportUpdateResponse updateSyncSport(SyncSportUpdateRequest request, Passport passport);


    /**
     * 删除运动同步表)
     *
     * @param request 删除运动同步表)请求
     * @param passport 用户护照
     * @return 删除运动同步表)应答
     */
    SyncSportDeleteResponse deleteSyncSport(SyncSportDeleteRequest request, Passport passport);



    /**
     * 创建常吃数据表
     *
     * @param request 创建常吃数据表请求
     * @param passport 用户护照
     * @return 创建常吃数据表应答
     */
    OftenEatCreateResponse createOftenEat(OftenEatCreateRequest request, Passport passport);


    /**
     * 更新常吃数据表
     *
     * @param request 更新常吃数据表请求
     * @param passport 用户护照
     * @return 更新常吃数据表应答
     */
    OftenEatUpdateResponse updateOftenEat(OftenEatUpdateRequest request, Passport passport);


    /**
     * 删除常吃数据表
     *
     * @param request 删除常吃数据表请求
     * @param passport 用户护照
     * @return 删除常吃数据表应答
     */
    OftenEatDeleteResponse deleteOftenEat(OftenEatDeleteRequest request, Passport passport);

    SportLineListImportResponse importList(SportLineListImportRequest request, Passport passport);

}
