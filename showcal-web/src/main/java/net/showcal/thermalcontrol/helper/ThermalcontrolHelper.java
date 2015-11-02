package net.showcal.thermalcontrol.helper;

import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;
import com.xiniunet.framework.security.Passport;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.thermalcontrol.helper.ThermalcontrolHelper
 *  Description: thermalcontrol Helper 接口
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public interface ThermalcontrolHelper {
    /**
     * 根据Id获取基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BaseHeatGetResponse getBaseHeat(BaseHeatGetRequest request, Passport passport);

    /**
     * 高级查询基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BaseHeatFindResponse findBaseHeat(BaseHeatFindRequest request, Passport passport);

    /**
     * 创建基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BaseHeatCreateResponse createBaseHeat(BaseHeatCreateRequest request, Passport passport);

    /**
     * 更新基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BaseHeatUpdateResponse updateBaseHeat(BaseHeatUpdateRequest request, Passport passport);

    /**
     * 删除基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BaseHeatDeleteResponse deleteBaseHeat(BaseHeatDeleteRequest request, Passport passport);

    /**
     * 根据Id获取BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BmiFoodGetResponse getBmiFood(BmiFoodGetRequest request, Passport passport);

    /**
     * 高级查询BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BmiFoodFindResponse findBmiFood(BmiFoodFindRequest request, Passport passport);

    /**
     * 创建BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BmiFoodCreateResponse createBmiFood(BmiFoodCreateRequest request, Passport passport);

    /**
     * 更新BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BmiFoodUpdateResponse updateBmiFood(BmiFoodUpdateRequest request, Passport passport);

    /**
     * 删除BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BmiFoodDeleteResponse deleteBmiFood(BmiFoodDeleteRequest request, Passport passport);

    /**
     * 作废BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BmiFoodInactiveResponse inactiveBmiFood(BmiFoodInactiveRequest request, Passport passport);

    /**
     * 激活BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    BmiFoodActiveResponse activeBmiFood(BmiFoodActiveRequest request, Passport passport);

    /**
     * 高级查询评价基础
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    EvaluateFindResponse findEvaluate(EvaluateFindRequest request, Passport passport);

    /**
     * 创建评价基础
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    EvaluateCreateResponse createEvaluate(EvaluateCreateRequest request, Passport passport);

    /**
     * 更新评价基础
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    EvaluateUpdateResponse updateEvaluate(EvaluateUpdateRequest request, Passport passport);

    /**
     * 高级查询食物类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodCategoryFindResponse findFoodCategory(FoodCategoryFindRequest request, Passport passport);

    /**
     * 获取所有食物类别列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodCategoryGetAllListResponse getFoodCategoryAllList(FoodCategoryGetAllListRequest request, Passport passport);

    /**
     * 创建食物类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodCategoryCreateResponse createFoodCategory(FoodCategoryCreateRequest request, Passport passport);

    /**
     * 更新食物类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodCategoryUpdateResponse updateFoodCategory(FoodCategoryUpdateRequest request, Passport passport);

    /**
     * 删除食物类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodCategoryDeleteResponse deleteFoodCategory(FoodCategoryDeleteRequest request, Passport passport);

    /**
     * 高级查询食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodExchangeFindResponse findFoodExchange(FoodExchangeFindRequest request, Passport passport);

    /**
     * 获取所有食物交换份列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodExchangeGetAllListResponse getFoodExchangeAllList(FoodExchangeGetAllListRequest request, Passport passport);

    /**
     * 创建食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodExchangeCreateResponse createFoodExchange(FoodExchangeCreateRequest request, Passport passport);

    /**
     * 更新食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodExchangeUpdateResponse updateFoodExchange(FoodExchangeUpdateRequest request, Passport passport);

    /**
     * 删除食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodExchangeDeleteResponse deleteFoodExchange(FoodExchangeDeleteRequest request, Passport passport);

    /**
     * 作废食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodExchangeInactiveResponse inactiveFoodExchange(FoodExchangeInactiveRequest request, Passport passport);

    /**
     * 激活食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodExchangeActiveResponse activeFoodExchange(FoodExchangeActiveRequest request, Passport passport);

    /**
     * 高级查询食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodFindResponse findFood(FoodFindRequest request, Passport passport);

    /**
     * 创建食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodCreateResponse createFood(FoodCreateRequest request, Passport passport);

    /**
     * 更新食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodUpdateResponse updateFood(FoodUpdateRequest request, Passport passport);

    /**
     * 获取食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodGetResponse getFood(FoodGetRequest request, Passport passport);

    /**
     * 删除食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodDeleteResponse deleteFood(FoodDeleteRequest request, Passport passport);

    /**
     * 作废食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodInactiveResponse inactiveFood(FoodInactiveRequest request, Passport passport);

    /**
     * 激活食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodActiveResponse activeFood(FoodActiveRequest request, Passport passport);

    /**
     *  上传食物列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    FoodListImportResponse importFoodList(FoodListImportRequest request, Passport passport);

    /**
     * 根据Id获取打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    GradeWeightGetResponse getGradeWeight(GradeWeightGetRequest request, Passport passport);

    /**
     * 模糊查询打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    GradeWeightSearchResponse searchGradeWeight(GradeWeightSearchRequest request, Passport passport);

    /**
     * 高级查询打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    GradeWeightFindResponse findGradeWeight(GradeWeightFindRequest request, Passport passport);

    /**
     * 获取所有打分权重表列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    GradeWeightGetAllListResponse getGradeWeightAllList(GradeWeightGetAllListRequest request, Passport passport);

    /**
     * 创建打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    GradeWeightCreateResponse createGradeWeight(GradeWeightCreateRequest request, Passport passport);

    /**
     * 更新打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    GradeWeightUpdateResponse updateGradeWeight(GradeWeightUpdateRequest request, Passport passport);

    /**
     * 删除打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    GradeWeightDeleteResponse deleteGradeWeight(GradeWeightDeleteRequest request, Passport passport);

    /**
     * 根据当前时间获取餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MealsGetResponse getMeals(MealsGetRequest request, Passport passport);

    /**
     * 高级查询餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MealsFindResponse findMeals(MealsFindRequest request, Passport passport);

    /**
     * 创建餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MealsCreateResponse createMeals(MealsCreateRequest request, Passport passport);

    /**
     * 更新餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MealsUpdateResponse updateMeals(MealsUpdateRequest request, Passport passport);

    /**
     * 删除餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    MealsDeleteResponse deleteMeals(MealsDeleteRequest request, Passport passport);

    /**
     * 根据Id获取营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    NutritionalGoalGetResponse getNutritionalGoal(NutritionalGoalGetRequest request, Passport passport);

    /**
     * 模糊查询营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    NutritionalGoalSearchResponse searchNutritionalGoal(NutritionalGoalSearchRequest request, Passport passport);

    /**
     * 高级查询营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    NutritionalGoalFindResponse findNutritionalGoal(NutritionalGoalFindRequest request, Passport passport);

    /**
     * 创建营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    NutritionalGoalCreateResponse createNutritionalGoal(NutritionalGoalCreateRequest request, Passport passport);

    /**
     * 更新营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    NutritionalGoalUpdateResponse updateNutritionalGoal(NutritionalGoalUpdateRequest request, Passport passport);

    /**
     * 删除营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    NutritionalGoalDeleteResponse deleteNutritionalGoal(NutritionalGoalDeleteRequest request, Passport passport);

    /**
     * 作废营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    NutritionalGoalInactiveResponse inactiveNutritionalGoal(NutritionalGoalInactiveRequest request, Passport passport);

    /**
     * 激活营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    NutritionalGoalActiveResponse activeNutritionalGoal(NutritionalGoalActiveRequest request, Passport passport);

    /**
     * 根据Id获取运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportHeadGetResponse getSportHead(SportHeadGetRequest request, Passport passport);

    /**
     * 高级查询运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportHeadFindResponse findSportHead(SportHeadFindRequest request, Passport passport);




    /**
     * 创建运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportHeadCreateResponse createSportHead(SportHeadCreateRequest request, Passport passport);

    /**
     * 更新运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportHeadUpdateResponse updateSportHead(SportHeadUpdateRequest request, Passport passport);

    /**
     * 更新运动方案totalTime
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportHeadUpdateTotalTimeResponse updateSportHeadTotalTime(SportHeadUpdateTotalTimeRequest request, Passport passport);

    /**
     * 删除运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportHeadDeleteResponse deleteSportHead(SportHeadDeleteRequest request, Passport passport);

    /**
     * 获取所有运动方案明细列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportLineGetAllListResponse getSportLineAllList(SportLineGetAllListRequest request, Passport passport);

    /**
     * 创建运动方案明细
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportLineCreateResponse createSportLine(SportLineCreateRequest request, Passport passport);

    /**
     * 更新运动方案明细
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportLineUpdateResponse updateSportLine(SportLineUpdateRequest request, Passport passport);

    /**
     * 删除运动方案明细
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportLineDeleteResponse deleteSportLine(SportLineDeleteRequest request, Passport passport);

    /**
     * 根据Id获取运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportSettingGetResponse getSportSetting(SportSettingGetRequest request, Passport passport);

    /**
     * 模糊查询运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportSettingSearchResponse searchSportSetting(SportSettingSearchRequest request, Passport passport);

    /**
     * 高级查询运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportSettingFindResponse findSportSetting(SportSettingFindRequest request, Passport passport);

    /**
     * 获取所有运动主数据列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportSettingGetAllListResponse getSportSettingAllList(SportSettingGetAllListRequest request, Passport passport);

    /**
     * 创建运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportSettingCreateResponse createSportSetting(SportSettingCreateRequest request, Passport passport);

    /**
     * 更新运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportSettingUpdateResponse updateSportSetting(SportSettingUpdateRequest request, Passport passport);

    /**
     * 删除运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SportSettingDeleteResponse deleteSportSetting(SportSettingDeleteRequest request, Passport passport);

    /**
     * 根据Id获取热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatDetailGetResponse getSyncHeatDetail(SyncHeatDetailGetRequest request, Passport passport);

    /**
     * 模糊查询热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatDetailSearchResponse searchSyncHeatDetail(SyncHeatDetailSearchRequest request, Passport passport);

    /**
     * 高级查询热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatDetailFindResponse findSyncHeatDetail(SyncHeatDetailFindRequest request, Passport passport);

    /**
     * 获取所有热量同步明细表列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatDetailGetAllListResponse getSyncHeatDetailAllList(SyncHeatDetailGetAllListRequest request, Passport passport);

    /**
     * 创建热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatDetailCreateResponse createSyncHeatDetail(SyncHeatDetailCreateRequest request, Passport passport);

    /**
     * 更新热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatDetailUpdateResponse updateSyncHeatDetail(SyncHeatDetailUpdateRequest request, Passport passport);

    /**
     * 删除热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatDetailDeleteResponse deleteSyncHeatDetail(SyncHeatDetailDeleteRequest request, Passport passport);

    /**
     * 根据Id获取热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatGetResponse getSyncHeat(SyncHeatGetRequest request, Passport passport);

    /**
     * 模糊查询热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatSearchResponse searchSyncHeat(SyncHeatSearchRequest request, Passport passport);

    /**
     * 高级查询热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatFindResponse findSyncHeat(SyncHeatFindRequest request, Passport passport);

    /**
     * 获取所有热量同步表列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatGetAllListResponse getSyncHeatAllList(SyncHeatGetAllListRequest request, Passport passport);

    /**
     * 创建热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatCreateResponse createSyncHeat(SyncHeatCreateRequest request, Passport passport);

    /**
     * 更新热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatUpdateResponse updateSyncHeat(SyncHeatUpdateRequest request, Passport passport);

    /**
     * 删除热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncHeatDeleteResponse deleteSyncHeat(SyncHeatDeleteRequest request, Passport passport);

    /**
     * 根据Id获取运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncSportGetResponse getSyncSport(SyncSportGetRequest request, Passport passport);

    /**
     * 模糊查询运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncSportSearchResponse searchSyncSport(SyncSportSearchRequest request, Passport passport);

    /**
     * 高级查询运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncSportFindResponse findSyncSport(SyncSportFindRequest request, Passport passport);

    /**
     * 获取所有运动同步表)列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncSportGetAllListResponse getSyncSportAllList(SyncSportGetAllListRequest request, Passport passport);

    /**
     * 创建运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncSportCreateResponse createSyncSport(SyncSportCreateRequest request, Passport passport);

    /**
     * 更新运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncSportUpdateResponse updateSyncSport(SyncSportUpdateRequest request, Passport passport);

    /**
     * 删除运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    SyncSportDeleteResponse deleteSyncSport(SyncSportDeleteRequest request, Passport passport);

    SportSettingListImportResponse importList(SportSettingListImportRequest request, Passport passport);

     SportHeadListImportResponse importList(SportHeadListImportRequest request, Passport passport);
    SportLineListImportResponse importList(SportLineListImportRequest request, Passport passport);
}