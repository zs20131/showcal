package net.showcal.thermalcontrol.helper;

import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;
import com.showcal.thermalcontrol.service.ThermalControlService;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.thermalcontrol.helper.ThermalcontrolHelperImpl
 *  Description: thermalcontrol Helper 实现类
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
@Component
public class ThermalcontrolHelperImpl implements ThermalcontrolHelper {
    @Autowired
    private ThermalControlService thermalControlService;

    /**
     * 根据Id获取基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BaseHeatGetResponse getBaseHeat(BaseHeatGetRequest request, Passport passport) {
        return thermalControlService.getBaseHeat(request, passport);
    }

    /**
     * 高级查询基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BaseHeatFindResponse findBaseHeat(BaseHeatFindRequest request, Passport passport) {
        return thermalControlService.findBaseHeat(request, passport);
    }

    /**
     * 创建基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BaseHeatCreateResponse createBaseHeat(BaseHeatCreateRequest request, Passport passport) {
        return thermalControlService.createBaseHeat(request, passport);
    }

    /**
     * 更新基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BaseHeatUpdateResponse updateBaseHeat(BaseHeatUpdateRequest request, Passport passport) {
        return thermalControlService.updateBaseHeat(request, passport);
    }

    /**
     * 删除基础热量设置
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BaseHeatDeleteResponse deleteBaseHeat(BaseHeatDeleteRequest request, Passport passport) {
        return thermalControlService.deleteBaseHeat(request, passport);
    }

    /**
     * 根据Id获取BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BmiFoodGetResponse getBmiFood(BmiFoodGetRequest request, Passport passport) {
        return thermalControlService.getBmiFood(request, passport);
    }

    /**
     * 高级查询BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BmiFoodFindResponse findBmiFood(BmiFoodFindRequest request, Passport passport) {
        return thermalControlService.findBmiFood(request, passport);
    }

    /**
     * 创建BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BmiFoodCreateResponse createBmiFood(BmiFoodCreateRequest request, Passport passport) {
        return thermalControlService.createBmiFood(request, passport);
    }

    /**
     * 更新BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BmiFoodUpdateResponse updateBmiFood(BmiFoodUpdateRequest request, Passport passport) {
        return thermalControlService.updateBmiFood(request, passport);
    }

    /**
     * 删除BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BmiFoodDeleteResponse deleteBmiFood(BmiFoodDeleteRequest request, Passport passport) {
        return thermalControlService.deleteBmiFood(request, passport);
    }

    /**
     * 作废BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BmiFoodInactiveResponse inactiveBmiFood(BmiFoodInactiveRequest request, Passport passport) {
        return thermalControlService.inactiveBmiFood(request, passport);
    }

    /**
     * 激活BMI食物总重量
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public BmiFoodActiveResponse activeBmiFood(BmiFoodActiveRequest request, Passport passport) {
        return thermalControlService.activeBmiFood(request, passport);
    }

    /**
     * 高级查询评价基础
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public EvaluateFindResponse findEvaluate(EvaluateFindRequest request, Passport passport) {
        return thermalControlService.findEvaluate(request, passport);
    }

    /**
     * 创建评价基础
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public EvaluateCreateResponse createEvaluate(EvaluateCreateRequest request, Passport passport) {
        return thermalControlService.createEvaluate(request, passport);
    }

    /**
     * 更新评价基础
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public EvaluateUpdateResponse updateEvaluate(EvaluateUpdateRequest request, Passport passport) {
        return thermalControlService.updateEvaluate(request, passport);
    }

    /**
     * 高级查询食物类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodCategoryFindResponse findFoodCategory(FoodCategoryFindRequest request, Passport passport) {
        return thermalControlService.findFoodCategory(request, passport);
    }

    /**
     * 获取所有食物类别列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodCategoryGetAllListResponse getFoodCategoryAllList(FoodCategoryGetAllListRequest request, Passport passport) {
        return thermalControlService.getFoodCategoryAllList(request, passport);
    }

    /**
     * 创建食物类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodCategoryCreateResponse createFoodCategory(FoodCategoryCreateRequest request, Passport passport) {
        return thermalControlService.createFoodCategory(request, passport);
    }

    /**
     * 更新食物类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodCategoryUpdateResponse updateFoodCategory(FoodCategoryUpdateRequest request, Passport passport) {
        return thermalControlService.updateFoodCategory(request, passport);
    }

    /**
     * 删除食物类别
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodCategoryDeleteResponse deleteFoodCategory(FoodCategoryDeleteRequest request, Passport passport) {
        return thermalControlService.deleteFoodCategory(request, passport);
    }

    /**
     * 高级查询食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodExchangeFindResponse findFoodExchange(FoodExchangeFindRequest request, Passport passport) {
        return thermalControlService.findFoodExchange(request, passport);
    }

    /**
     * 获取所有食物交换份列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodExchangeGetAllListResponse getFoodExchangeAllList(FoodExchangeGetAllListRequest request, Passport passport) {
        return thermalControlService.getFoodExchangeAllList(request, passport);
    }

    /**
     * 创建食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodExchangeCreateResponse createFoodExchange(FoodExchangeCreateRequest request, Passport passport) {
        return thermalControlService.createFoodExchange(request, passport);
    }

    /**
     * 更新食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodExchangeUpdateResponse updateFoodExchange(FoodExchangeUpdateRequest request, Passport passport) {
        return thermalControlService.updateFoodExchange(request, passport);
    }

    /**
     * 删除食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodExchangeDeleteResponse deleteFoodExchange(FoodExchangeDeleteRequest request, Passport passport) {
        return thermalControlService.deleteFoodExchange(request, passport);
    }

    /**
     * 作废食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodExchangeInactiveResponse inactiveFoodExchange(FoodExchangeInactiveRequest request, Passport passport) {
        return thermalControlService.inactiveFoodExchange(request, passport);
    }

    /**
     * 激活食物交换份
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodExchangeActiveResponse activeFoodExchange(FoodExchangeActiveRequest request, Passport passport) {
        return thermalControlService.activeFoodExchange(request, passport);
    }

    /**
     * 高级查询食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodFindResponse findFood(FoodFindRequest request, Passport passport) {
        return thermalControlService.findFood(request, passport);
    }

    /**
     * 创建食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodCreateResponse createFood(FoodCreateRequest request, Passport passport) {
        request.setActiveUser(passport.getUserId().toString());
        request.setActiveDate(new Date());
        return thermalControlService.createFood(request, passport);
    }

    /**
     * 更新食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodUpdateResponse updateFood(FoodUpdateRequest request, Passport passport) {
        return thermalControlService.updateFood(request, passport);
    }

    @Override
    public FoodGetResponse getFood(FoodGetRequest request, Passport passport) {
        return thermalControlService.getFood(request, passport);
    }

    /**
     * 删除食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodDeleteResponse deleteFood(FoodDeleteRequest request, Passport passport) {
        return thermalControlService.deleteFood(request, passport);
    }

    /**
     * 作废食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodInactiveResponse inactiveFood(FoodInactiveRequest request, Passport passport) {
        return thermalControlService.inactiveFood(request, passport);
    }

    /**
     * 激活食物
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodActiveResponse activeFood(FoodActiveRequest request, Passport passport) {
        return thermalControlService.activeFood(request, passport);
    }

    /**
     *  上传食物列表
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public FoodListImportResponse importFoodList(FoodListImportRequest request, Passport passport) {
        return thermalControlService.importFoodList(request, passport);
    }

    /**
     * 根据Id获取打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public GradeWeightGetResponse getGradeWeight(GradeWeightGetRequest request, Passport passport) {
        return thermalControlService.getGradeWeight(request, passport);
    }

    @Override
    public SportHeadListImportResponse importList(SportHeadListImportRequest request, Passport passport) {
        return thermalControlService.importList(request,passport);
    }

    /**
     * 模糊查询打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public GradeWeightSearchResponse searchGradeWeight(GradeWeightSearchRequest request, Passport passport) {
        return thermalControlService.searchGradeWeight(request, passport);
    }

    /**
     * 高级查询打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public GradeWeightFindResponse findGradeWeight(GradeWeightFindRequest request, Passport passport) {
        return thermalControlService.findGradeWeight(request, passport);
    }

    /**
     * 获取所有打分权重表列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public GradeWeightGetAllListResponse getGradeWeightAllList(GradeWeightGetAllListRequest request, Passport passport) {
        return thermalControlService.getGradeWeightAllList(request, passport);
    }

    /**
     * 创建打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public GradeWeightCreateResponse createGradeWeight(GradeWeightCreateRequest request, Passport passport) {
        return thermalControlService.createGradeWeight(request, passport);
    }

    /**
     * 更新打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public GradeWeightUpdateResponse updateGradeWeight(GradeWeightUpdateRequest request, Passport passport) {
        return thermalControlService.updateGradeWeight(request, passport);
    }

    /**
     * 删除打分权重表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public GradeWeightDeleteResponse deleteGradeWeight(GradeWeightDeleteRequest request, Passport passport) {
        return thermalControlService.deleteGradeWeight(request, passport);
    }

    @Override
    public SportLineListImportResponse importList(SportLineListImportRequest request, Passport passport) {
        return thermalControlService.importList(request, passport);
    }

    /**
     * 根据当前时间获取餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MealsGetResponse getMeals(MealsGetRequest request, Passport passport) {
        return thermalControlService.getMeals(request, passport);
    }

    /**
     * 高级查询餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MealsFindResponse findMeals(MealsFindRequest request, Passport passport) {
        return thermalControlService.findMeals(request, passport);
    }

    /**
     * 创建餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MealsCreateResponse createMeals(MealsCreateRequest request, Passport passport) {
        return thermalControlService.createMeals(request, passport);
    }

    /**
     * 更新餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MealsUpdateResponse updateMeals(MealsUpdateRequest request, Passport passport) {
        return thermalControlService.updateMeals(request, passport);
    }

    /**
     * 删除餐次
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public MealsDeleteResponse deleteMeals(MealsDeleteRequest request, Passport passport) {
        return thermalControlService.deleteMeals(request, passport);
    }

    /**
     * 根据Id获取营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public NutritionalGoalGetResponse getNutritionalGoal(NutritionalGoalGetRequest request, Passport passport) {
        return thermalControlService.getNutritionalGoal(request, passport);
    }

    /**
     * 模糊查询营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public NutritionalGoalSearchResponse searchNutritionalGoal(NutritionalGoalSearchRequest request, Passport passport) {
        return thermalControlService.searchNutritionalGoal(request, passport);
    }

    /**
     * 高级查询营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public NutritionalGoalFindResponse findNutritionalGoal(NutritionalGoalFindRequest request, Passport passport) {
        return thermalControlService.findNutritionalGoal(request, passport);
    }

    /**
     * 创建营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public NutritionalGoalCreateResponse createNutritionalGoal(NutritionalGoalCreateRequest request, Passport passport) {
        return thermalControlService.createNutritionalGoal(request, passport);
    }

    /**
     * 更新营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public NutritionalGoalUpdateResponse updateNutritionalGoal(NutritionalGoalUpdateRequest request, Passport passport) {
        return thermalControlService.updateNutritionalGoal(request, passport);
    }

    /**
     * 删除营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public NutritionalGoalDeleteResponse deleteNutritionalGoal(NutritionalGoalDeleteRequest request, Passport passport) {
        return thermalControlService.deleteNutritionalGoal(request, passport);
    }

    /**
     * 作废营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public NutritionalGoalInactiveResponse inactiveNutritionalGoal(NutritionalGoalInactiveRequest request, Passport passport) {
        return thermalControlService.inactiveNutritionalGoal(request, passport);
    }

    /**
     * 激活营养目标
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public NutritionalGoalActiveResponse activeNutritionalGoal(NutritionalGoalActiveRequest request, Passport passport) {
        return thermalControlService.activeNutritionalGoal(request, passport);
    }

    /**
     * 根据Id获取运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportHeadGetResponse getSportHead(SportHeadGetRequest request, Passport passport) {
        return thermalControlService.getSportHead(request, passport);
    }

    /**
     * 高级查询运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportHeadFindResponse findSportHead(SportHeadFindRequest request, Passport passport) {
        return thermalControlService.findSportHead(request, passport);
    }

    /**
     * 创建运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportHeadCreateResponse createSportHead(SportHeadCreateRequest request, Passport passport) {
        return thermalControlService.createSportHead(request, passport);
    }

    /**
     * 更新运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportHeadUpdateResponse updateSportHead(SportHeadUpdateRequest request, Passport passport) {
        return thermalControlService.updateSportHead(request, passport);
    }

    @Override
    public SportHeadUpdateTotalTimeResponse updateSportHeadTotalTime(SportHeadUpdateTotalTimeRequest request, Passport passport) {
        return thermalControlService.updateSportHeadTotalTime(request, passport);
    }

    /**
     * 删除运动方案
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportHeadDeleteResponse deleteSportHead(SportHeadDeleteRequest request, Passport passport) {
        return thermalControlService.deleteSportHead(request, passport);
    }

    /**
     * 获取所有运动方案明细列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportLineGetAllListResponse getSportLineAllList(SportLineGetAllListRequest request, Passport passport) {
        return thermalControlService.getSportLineAllList(request, passport);
    }

    /**
     * 创建运动方案明细
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportLineCreateResponse createSportLine(SportLineCreateRequest request, Passport passport) {
        return thermalControlService.createSportLine(request, passport);
    }

    /**
     * 更新运动方案明细
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportLineUpdateResponse updateSportLine(SportLineUpdateRequest request, Passport passport) {
        return thermalControlService.updateSportLine(request, passport);
    }

    /**
     * 删除运动方案明细
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportLineDeleteResponse deleteSportLine(SportLineDeleteRequest request, Passport passport) {
        return thermalControlService.deleteSportLine(request, passport);
    }

    /**
     * 根据Id获取运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportSettingGetResponse getSportSetting(SportSettingGetRequest request, Passport passport) {
        return thermalControlService.getSportSetting(request, passport);
    }

    /**
     * 模糊查询运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportSettingSearchResponse searchSportSetting(SportSettingSearchRequest request, Passport passport) {
        return thermalControlService.searchSportSetting(request, passport);
    }

    @Override
    public SportSettingListImportResponse importList(SportSettingListImportRequest request, Passport passport) {
        return thermalControlService.importList(request, passport);
    }

    /**
     * 高级查询运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportSettingFindResponse findSportSetting(SportSettingFindRequest request, Passport passport) {
        return thermalControlService.findSportSetting(request, passport);
    }

    /**
     * 获取所有运动主数据列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportSettingGetAllListResponse getSportSettingAllList(SportSettingGetAllListRequest request, Passport passport) {
        return thermalControlService.getSportSettingAllList(request, passport);
    }

    /**
     * 创建运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportSettingCreateResponse createSportSetting(SportSettingCreateRequest request, Passport passport) {
        return thermalControlService.createSportSetting(request, passport);
    }

    /**
     * 更新运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportSettingUpdateResponse updateSportSetting(SportSettingUpdateRequest request, Passport passport) {
        return thermalControlService.updateSportSetting(request, passport);
    }

    /**
     * 删除运动主数据
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SportSettingDeleteResponse deleteSportSetting(SportSettingDeleteRequest request, Passport passport) {
        return thermalControlService.deleteSportSetting(request, passport);
    }

    /**
     * 根据Id获取热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatDetailGetResponse getSyncHeatDetail(SyncHeatDetailGetRequest request, Passport passport) {
        return thermalControlService.getSyncHeatDetail(request, passport);
    }

    /**
     * 模糊查询热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatDetailSearchResponse searchSyncHeatDetail(SyncHeatDetailSearchRequest request, Passport passport) {
        return thermalControlService.searchSyncHeatDetail(request, passport);
    }

    /**
     * 高级查询热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatDetailFindResponse findSyncHeatDetail(SyncHeatDetailFindRequest request, Passport passport) {
        return thermalControlService.findSyncHeatDetail(request, passport);
    }

    /**
     * 获取所有热量同步明细表列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatDetailGetAllListResponse getSyncHeatDetailAllList(SyncHeatDetailGetAllListRequest request, Passport passport) {
        return thermalControlService.getSyncHeatDetailAllList(request, passport);
    }

    /**
     * 创建热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatDetailCreateResponse createSyncHeatDetail(SyncHeatDetailCreateRequest request, Passport passport) {
        return thermalControlService.createSyncHeatDetail(request, passport);
    }

    /**
     * 更新热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatDetailUpdateResponse updateSyncHeatDetail(SyncHeatDetailUpdateRequest request, Passport passport) {
        return thermalControlService.updateSyncHeatDetail(request, passport);
    }

    /**
     * 删除热量同步明细表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatDetailDeleteResponse deleteSyncHeatDetail(SyncHeatDetailDeleteRequest request, Passport passport) {
        return thermalControlService.deleteSyncHeatDetail(request, passport);
    }

    /**
     * 根据Id获取热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatGetResponse getSyncHeat(SyncHeatGetRequest request, Passport passport) {
        return thermalControlService.getSyncHeat(request, passport);
    }

    /**
     * 模糊查询热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatSearchResponse searchSyncHeat(SyncHeatSearchRequest request, Passport passport) {
        return thermalControlService.searchSyncHeat(request, passport);
    }

    /**
     * 高级查询热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatFindResponse findSyncHeat(SyncHeatFindRequest request, Passport passport) {
        return thermalControlService.findSyncHeat(request, passport);
    }

    /**
     * 获取所有热量同步表列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatGetAllListResponse getSyncHeatAllList(SyncHeatGetAllListRequest request, Passport passport) {
        return thermalControlService.getSyncHeatAllList(request, passport);
    }

    /**
     * 创建热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatCreateResponse createSyncHeat(SyncHeatCreateRequest request, Passport passport) {
        return thermalControlService.createSyncHeat(request, passport);
    }

    /**
     * 更新热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatUpdateResponse updateSyncHeat(SyncHeatUpdateRequest request, Passport passport) {
        return thermalControlService.updateSyncHeat(request, passport);
    }

    /**
     * 删除热量同步表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncHeatDeleteResponse deleteSyncHeat(SyncHeatDeleteRequest request, Passport passport) {
        return thermalControlService.deleteSyncHeat(request, passport);
    }

    /**
     * 根据Id获取运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncSportGetResponse getSyncSport(SyncSportGetRequest request, Passport passport) {
        return thermalControlService.getSyncSport(request, passport);
    }

    /**
     * 模糊查询运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncSportSearchResponse searchSyncSport(SyncSportSearchRequest request, Passport passport) {
        return thermalControlService.searchSyncSport(request, passport);
    }

    /**
     * 高级查询运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncSportFindResponse findSyncSport(SyncSportFindRequest request, Passport passport) {
        return thermalControlService.findSyncSport(request, passport);
    }

    /**
     * 获取所有运动同步表)列表
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncSportGetAllListResponse getSyncSportAllList(SyncSportGetAllListRequest request, Passport passport) {
        return thermalControlService.getSyncSportAllList(request, passport);
    }

    /**
     * 创建运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncSportCreateResponse createSyncSport(SyncSportCreateRequest request, Passport passport) {
        return thermalControlService.createSyncSport(request, passport);
    }

    /**
     * 更新运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncSportUpdateResponse updateSyncSport(SyncSportUpdateRequest request, Passport passport) {
        return thermalControlService.updateSyncSport(request, passport);
    }

    /**
     * 删除运动同步表)
     *
     * @param request
     * @param passport 用户护照
     * @return
     */
    @Override
    public SyncSportDeleteResponse deleteSyncSport(SyncSportDeleteRequest request, Passport passport) {
        return thermalControlService.deleteSyncSport(request, passport);
    }
}