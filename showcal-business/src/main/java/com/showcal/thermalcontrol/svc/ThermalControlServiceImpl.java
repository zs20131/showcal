package com.showcal.thermalcontrol.svc;

import com.showcal.thermalcontrol.biz.*;
import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;
import com.showcal.thermalcontrol.service.ThermalControlService;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.thermalcontrol.svc
 *  Description:
 * ***************************************************************
 *  9/15 0015  V1.0  xiniu    New Files for com.showcal.thermalcontrol.svc
 * </pre>
 */
public class ThermalControlServiceImpl implements ThermalControlService{
    //基础热量
    @Autowired
    private BaseHeatManager baseHeatManager;
    //BMI食物总重量
    @Autowired
    private BmiFoodManager bmiFoodManager;
    //评价设置基础
    @Autowired
    private EvaluateManager evaluateManager;
    //食物类别
    @Autowired
    private FoodCategoryManager foodCategoryManager;
    //食物交换份
    @Autowired
    private FoodExchangeManager foodExchangeManager;
    //食物
    @Autowired
    private FoodManager foodManager;
    //打分权重表
    @Autowired
    private GradeWeightManager gradeWeightManager;
    //餐次
    @Autowired
    private MealsManager mealsManager;
    //营养目标
    @Autowired
    private NutritionalGoalManager nutritionalGoalManager;
    // 运动方案
    @Autowired
    private SportHeadManager sportHeadManager;
    // 运动方案明细
    @Autowired
    private SportLineManager sportLineManager;
    // 运动设置
    @Autowired
    private SportSettingManager sportSettingManager;
    // 同步热量明细
    @Autowired
    private SyncHeatDetailManager syncHeatDetailManager;
    // 同步热量
    @Autowired
    private SyncHeatManager syncHeatManager;
    // 同步运动方案
    @Autowired
    private SyncSportManager syncSportManager;
    @Autowired
    private OftenEatManager oftenEatManager;
    @Override
    public BaseHeatGetResponse getBaseHeat(BaseHeatGetRequest request, Passport passport) {
        BaseHeatGetResponse response = new BaseHeatGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return baseHeatManager.get(request, passport);
    }

    @Override
    public BaseHeatFindResponse findBaseHeat(BaseHeatFindRequest request, Passport passport) {
        BaseHeatFindResponse response = new BaseHeatFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return baseHeatManager.find(request, passport);
    }

    @Override
    public BaseHeatCreateResponse createBaseHeat(BaseHeatCreateRequest request, Passport passport) {
        BaseHeatCreateResponse response = new BaseHeatCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return baseHeatManager.create(request, passport);
    }

    @Override
    public BaseHeatUpdateResponse updateBaseHeat(BaseHeatUpdateRequest request, Passport passport) {
        BaseHeatUpdateResponse response = new BaseHeatUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return baseHeatManager.update(request, passport);
    }

    @Override
    public BaseHeatDeleteResponse deleteBaseHeat(BaseHeatDeleteRequest request, Passport passport) {
        BaseHeatDeleteResponse response = new BaseHeatDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return baseHeatManager.delete(request, passport);
    }

    @Override
    public BmiFoodGetResponse getBmiFood(BmiFoodGetRequest request, Passport passport) {
        BmiFoodGetResponse response = new BmiFoodGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return bmiFoodManager.get(request, passport);
    }

    @Override
    public BmiFoodFindResponse findBmiFood(BmiFoodFindRequest request, Passport passport) {
        BmiFoodFindResponse response = new BmiFoodFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return bmiFoodManager.find(request, passport);
    }

    @Override
    public BmiFoodCreateResponse createBmiFood(BmiFoodCreateRequest request, Passport passport) {
        BmiFoodCreateResponse response = new BmiFoodCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return bmiFoodManager.create(request, passport);
    }

    @Override
    public BmiFoodUpdateResponse updateBmiFood(BmiFoodUpdateRequest request, Passport passport) {
        BmiFoodUpdateResponse response = new BmiFoodUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return bmiFoodManager.update(request, passport);
    }

    @Override
    public BmiFoodDeleteResponse deleteBmiFood(BmiFoodDeleteRequest request, Passport passport) {
        BmiFoodDeleteResponse response = new BmiFoodDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return bmiFoodManager.delete(request, passport);
    }

    @Override
    public BmiFoodInactiveResponse inactiveBmiFood(BmiFoodInactiveRequest request, Passport passport) {
        BmiFoodInactiveResponse response = new BmiFoodInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return bmiFoodManager.inactive(request, passport);
    }

    @Override
    public BmiFoodActiveResponse activeBmiFood(BmiFoodActiveRequest request, Passport passport) {
        BmiFoodActiveResponse response = new BmiFoodActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return bmiFoodManager.active(request, passport);
    }

    @Override
    public EvaluateFindResponse findEvaluate(EvaluateFindRequest request, Passport passport) {
        EvaluateFindResponse response = new EvaluateFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return evaluateManager.find(request, passport);
    }

    @Override
    public SportHeadListImportResponse importList(SportHeadListImportRequest request, Passport passport) {
        SportHeadListImportResponse response = new SportHeadListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportHeadManager.importList(request, passport);
    }

    @Override
    public EvaluateCreateResponse createEvaluate(EvaluateCreateRequest request, Passport passport) {
        EvaluateCreateResponse response = new EvaluateCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return evaluateManager.create(request, passport);
    }

    @Override
    public EvaluateUpdateResponse updateEvaluate(EvaluateUpdateRequest request, Passport passport) {
        EvaluateUpdateResponse response = new EvaluateUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return evaluateManager.update(request, passport);
    }

    @Override
    public FoodCategoryFindResponse findFoodCategory(FoodCategoryFindRequest request, Passport passport) {
        FoodCategoryFindResponse response = new FoodCategoryFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodCategoryManager.find(request, passport);
    }

    @Override
    public FoodCategoryGetAllListResponse getFoodCategoryAllList(FoodCategoryGetAllListRequest request, Passport passport) {
        FoodCategoryGetAllListResponse response = new FoodCategoryGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodCategoryManager.getAllList(request, passport);
    }

    @Override
    public FoodCategoryCreateResponse createFoodCategory(FoodCategoryCreateRequest request, Passport passport) {
        FoodCategoryCreateResponse response = new FoodCategoryCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodCategoryManager.create(request, passport);
    }

    @Override
    public FoodCategoryUpdateResponse updateFoodCategory(FoodCategoryUpdateRequest request, Passport passport) {
        FoodCategoryUpdateResponse response = new FoodCategoryUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodCategoryManager.update(request, passport);
    }

    @Override
    public FoodCategoryDeleteResponse deleteFoodCategory(FoodCategoryDeleteRequest request, Passport passport) {
        FoodCategoryDeleteResponse response = new FoodCategoryDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodCategoryManager.delete(request, passport);
    }

    @Override
    public FoodExchangeFindResponse findFoodExchange(FoodExchangeFindRequest request, Passport passport) {
        FoodExchangeFindResponse response = new FoodExchangeFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodExchangeManager.find(request, passport);
    }

    @Override
    public FoodExchangeGetAllListResponse getFoodExchangeAllList(FoodExchangeGetAllListRequest request, Passport passport) {
        FoodExchangeGetAllListResponse response = new FoodExchangeGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodExchangeManager.getAllList(request, passport);
    }

    @Override
    public FoodExchangeCreateResponse createFoodExchange(FoodExchangeCreateRequest request, Passport passport) {
        FoodExchangeCreateResponse response = new FoodExchangeCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodExchangeManager.create(request, passport);
    }

    @Override
    public FoodExchangeUpdateResponse updateFoodExchange(FoodExchangeUpdateRequest request, Passport passport) {
        FoodExchangeUpdateResponse response = new FoodExchangeUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodExchangeManager.update(request, passport);
    }

    @Override
    public FoodExchangeDeleteResponse deleteFoodExchange(FoodExchangeDeleteRequest request, Passport passport) {
        FoodExchangeDeleteResponse response = new FoodExchangeDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodExchangeManager.delete(request, passport);
    }

    @Override
    public SportSettingListImportResponse importList(SportSettingListImportRequest request, Passport passport) {
        SportSettingListImportResponse response = new SportSettingListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportSettingManager.importList(request, passport);
    }

    @Override
    public FoodExchangeInactiveResponse inactiveFoodExchange(FoodExchangeInactiveRequest request, Passport passport) {
        FoodExchangeInactiveResponse response = new FoodExchangeInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodExchangeManager.inactive(request, passport);
    }

    @Override
    public FoodExchangeActiveResponse activeFoodExchange(FoodExchangeActiveRequest request, Passport passport) {
        FoodExchangeActiveResponse response = new FoodExchangeActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodExchangeManager.active(request, passport);
    }

    @Override
    public FoodFindResponse findFood(FoodFindRequest request, Passport passport) {
        FoodFindResponse response = new FoodFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodManager.find(request, passport);
    }

    @Override
    public SportLineListImportResponse importList(SportLineListImportRequest request, Passport passport) {
        SportLineListImportResponse response = new SportLineListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportLineManager.importList(request, passport);
    }

    @Override
    public FoodCreateResponse createFood(FoodCreateRequest request, Passport passport) {
        FoodCreateResponse response = new FoodCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodManager.create(request, passport);
    }

    @Override
    public FoodUpdateResponse updateFood(FoodUpdateRequest request, Passport passport) {
        FoodUpdateResponse response = new FoodUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodManager.update(request, passport);
    }

    @Override
    public FoodGetResponse getFood(FoodGetRequest request, Passport passport) {
        FoodGetResponse response = new FoodGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodManager.get(request, passport);
    }

    @Override
    public FoodDeleteResponse deleteFood(FoodDeleteRequest request, Passport passport) {
        FoodDeleteResponse response = new FoodDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodManager.delete(request, passport);
    }

    @Override
    public FoodInactiveResponse inactiveFood(FoodInactiveRequest request, Passport passport) {
        FoodInactiveResponse response = new FoodInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodManager.inactive(request, passport);
    }

    @Override
    public FoodActiveResponse activeFood(FoodActiveRequest request, Passport passport) {
        FoodActiveResponse response = new FoodActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodManager.active(request, passport);
    }

    @Override
    public FoodListImportResponse importFoodList(FoodListImportRequest request, Passport passport) {
        FoodListImportResponse response = new FoodListImportResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return foodManager.importList(request, passport);
    }

    @Override
    public GradeWeightGetResponse getGradeWeight(GradeWeightGetRequest request, Passport passport) {
        GradeWeightGetResponse response = new GradeWeightGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return gradeWeightManager.get(request, passport);
    }

    @Override
    public GradeWeightSearchResponse searchGradeWeight(GradeWeightSearchRequest request, Passport passport) {
        GradeWeightSearchResponse response = new GradeWeightSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return gradeWeightManager.search(request, passport);
    }

    @Override
    public GradeWeightFindResponse findGradeWeight(GradeWeightFindRequest request, Passport passport) {
        GradeWeightFindResponse response = new GradeWeightFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return gradeWeightManager.find(request, passport);
    }

    @Override
    public GradeWeightGetAllListResponse getGradeWeightAllList(GradeWeightGetAllListRequest request, Passport passport) {
        GradeWeightGetAllListResponse response = new GradeWeightGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return gradeWeightManager.getAllList(request, passport);
    }

    @Override
    public GradeWeightCreateResponse createGradeWeight(GradeWeightCreateRequest request, Passport passport) {
        GradeWeightCreateResponse response = new GradeWeightCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return gradeWeightManager.create(request, passport);
    }

    @Override
    public GradeWeightUpdateResponse updateGradeWeight(GradeWeightUpdateRequest request, Passport passport) {
        GradeWeightUpdateResponse response = new GradeWeightUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return gradeWeightManager.update(request, passport);
    }

    @Override
    public GradeWeightDeleteResponse deleteGradeWeight(GradeWeightDeleteRequest request, Passport passport) {
        GradeWeightDeleteResponse response = new GradeWeightDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return gradeWeightManager.delete(request, passport);
    }

    @Override
    public MealsGetResponse getMeals(MealsGetRequest request, Passport passport) {
        MealsGetResponse response = new MealsGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return mealsManager.get(request, passport);
    }

    @Override
    public MealsFindResponse findMeals(MealsFindRequest request, Passport passport) {
        MealsFindResponse response = new MealsFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return mealsManager.find(request, passport);
    }

    @Override
    public MealsCreateResponse createMeals(MealsCreateRequest request, Passport passport) {
        MealsCreateResponse response = new MealsCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return mealsManager.create(request, passport);
    }

    @Override
    public MealsUpdateResponse updateMeals(MealsUpdateRequest request, Passport passport) {
        MealsUpdateResponse response = new MealsUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return mealsManager.update(request, passport);
    }

    @Override
    public MealsDeleteResponse deleteMeals(MealsDeleteRequest request, Passport passport) {
        MealsDeleteResponse response = new MealsDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return mealsManager.delete(request, passport);
    }

    @Override
    public NutritionalGoalGetResponse getNutritionalGoal(NutritionalGoalGetRequest request, Passport passport) {
        NutritionalGoalGetResponse response = new NutritionalGoalGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return nutritionalGoalManager.get(request, passport);
    }

    @Override
    public NutritionalGoalSearchResponse searchNutritionalGoal(NutritionalGoalSearchRequest request, Passport passport) {
        NutritionalGoalSearchResponse response = new NutritionalGoalSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return nutritionalGoalManager.search(request, passport);
    }

    @Override
    public NutritionalGoalFindResponse findNutritionalGoal(NutritionalGoalFindRequest request, Passport passport) {
        NutritionalGoalFindResponse response = new NutritionalGoalFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return nutritionalGoalManager.find(request, passport);
    }

    @Override
    public NutritionalGoalCreateResponse createNutritionalGoal(NutritionalGoalCreateRequest request, Passport passport) {
        NutritionalGoalCreateResponse response = new NutritionalGoalCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return nutritionalGoalManager.create(request, passport);
    }

    @Override
    public NutritionalGoalUpdateResponse updateNutritionalGoal(NutritionalGoalUpdateRequest request, Passport passport) {
        NutritionalGoalUpdateResponse response = new NutritionalGoalUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return nutritionalGoalManager.update(request, passport);
    }

    @Override
    public NutritionalGoalDeleteResponse deleteNutritionalGoal(NutritionalGoalDeleteRequest request, Passport passport) {
        NutritionalGoalDeleteResponse response = new NutritionalGoalDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return nutritionalGoalManager.delete(request, passport);
    }

    @Override
    public NutritionalGoalInactiveResponse inactiveNutritionalGoal(NutritionalGoalInactiveRequest request, Passport passport) {
        NutritionalGoalInactiveResponse response = new NutritionalGoalInactiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return nutritionalGoalManager.inactive(request, passport);
    }

    @Override
    public NutritionalGoalActiveResponse activeNutritionalGoal(NutritionalGoalActiveRequest request, Passport passport) {
        NutritionalGoalActiveResponse response = new NutritionalGoalActiveResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return nutritionalGoalManager.active(request, passport);
    }

    @Override
    public SportHeadGetResponse getSportHead(SportHeadGetRequest request, Passport passport) {
        SportHeadGetResponse response = new SportHeadGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportHeadManager.get(request, passport);
    }

    @Override
    public SportHeadFindResponse findSportHead(SportHeadFindRequest request, Passport passport) {
        SportHeadFindResponse response = new SportHeadFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportHeadManager.find(request, passport);
    }

    @Override
    public SportHeadCreateResponse createSportHead(SportHeadCreateRequest request, Passport passport) {
        SportHeadCreateResponse response = new SportHeadCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportHeadManager.create(request, passport);
    }

    @Override
    public SportHeadUpdateResponse updateSportHead(SportHeadUpdateRequest request, Passport passport) {
        SportHeadUpdateResponse response = new SportHeadUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportHeadManager.update(request, passport);
    }

    @Override
    public SportHeadUpdateTotalTimeResponse updateSportHeadTotalTime(SportHeadUpdateTotalTimeRequest request, Passport passport) {
        SportHeadUpdateTotalTimeResponse response = new SportHeadUpdateTotalTimeResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportHeadManager.updateTotalTime(request, passport);
    }

    @Override
    public SportHeadDeleteResponse deleteSportHead(SportHeadDeleteRequest request, Passport passport) {
        SportHeadDeleteResponse response = new SportHeadDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportHeadManager.delete(request, passport);
    }

    @Override
    public SportLineGetAllListResponse getSportLineAllList(SportLineGetAllListRequest request, Passport passport) {
        SportLineGetAllListResponse response = new SportLineGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportLineManager.getAllList(request, passport);
    }

    @Override
    public SportLineCreateResponse createSportLine(SportLineCreateRequest request, Passport passport) {
        SportLineCreateResponse response = new SportLineCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportLineManager.create(request, passport);
    }

    @Override
    public SportLineUpdateResponse updateSportLine(SportLineUpdateRequest request, Passport passport) {
        SportLineUpdateResponse response = new SportLineUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportLineManager.update(request, passport);
    }

    @Override
    public SportLineDeleteResponse deleteSportLine(SportLineDeleteRequest request, Passport passport) {
        SportLineDeleteResponse response = new SportLineDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportLineManager.delete(request, passport);
    }

    @Override
    public SportSettingGetResponse getSportSetting(SportSettingGetRequest request, Passport passport) {
        SportSettingGetResponse response = new SportSettingGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportSettingManager.get(request, passport);
    }

    @Override
    public SportSettingSearchResponse searchSportSetting(SportSettingSearchRequest request, Passport passport) {
        SportSettingSearchResponse response = new SportSettingSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportSettingManager.search(request, passport);
    }

    @Override
    public SportSettingFindResponse findSportSetting(SportSettingFindRequest request, Passport passport) {
        SportSettingFindResponse response = new SportSettingFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportSettingManager.find(request, passport);
    }

    @Override
    public SportSettingGetAllListResponse getSportSettingAllList(SportSettingGetAllListRequest request, Passport passport) {
        SportSettingGetAllListResponse response = new SportSettingGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportSettingManager.getAllList(request, passport);
    }

    @Override
    public SportSettingCreateResponse createSportSetting(SportSettingCreateRequest request, Passport passport) {
        SportSettingCreateResponse response = new SportSettingCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
            return sportSettingManager.create(request, passport);
    }

    @Override
    public SportSettingUpdateResponse updateSportSetting(SportSettingUpdateRequest request, Passport passport) {
        SportSettingUpdateResponse response = new SportSettingUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportSettingManager.update(request, passport);
    }

    @Override
    public SportSettingDeleteResponse deleteSportSetting(SportSettingDeleteRequest request, Passport passport) {
        SportSettingDeleteResponse response = new SportSettingDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return sportSettingManager.delete(request, passport);
    }

    @Override
    public SyncHeatDetailGetResponse getSyncHeatDetail(SyncHeatDetailGetRequest request, Passport passport) {
        SyncHeatDetailGetResponse response = new SyncHeatDetailGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatDetailManager.get(request, passport);
    }

    @Override
    public SyncHeatDetailSearchResponse searchSyncHeatDetail(SyncHeatDetailSearchRequest request, Passport passport) {
        SyncHeatDetailSearchResponse response = new SyncHeatDetailSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatDetailManager.search(request, passport);
    }

    @Override
    public SyncHeatDetailFindResponse findSyncHeatDetail(SyncHeatDetailFindRequest request, Passport passport) {
        SyncHeatDetailFindResponse response = new SyncHeatDetailFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatDetailManager.find(request, passport);
    }

    @Override
    public SyncHeatDetailGetAllListResponse getSyncHeatDetailAllList(SyncHeatDetailGetAllListRequest request, Passport passport) {
        SyncHeatDetailGetAllListResponse response = new SyncHeatDetailGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatDetailManager.getAllList(request, passport);
    }

    @Override
    public SyncHeatDetailCreateResponse createSyncHeatDetail(SyncHeatDetailCreateRequest request, Passport passport) {
        SyncHeatDetailCreateResponse response = new SyncHeatDetailCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatDetailManager.create(request, passport);
    }

    @Override
    public SyncHeatDetailUpdateResponse updateSyncHeatDetail(SyncHeatDetailUpdateRequest request, Passport passport) {
        SyncHeatDetailUpdateResponse response = new SyncHeatDetailUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatDetailManager.update(request, passport);
    }

    @Override
    public SyncHeatDetailDeleteResponse deleteSyncHeatDetail(SyncHeatDetailDeleteRequest request, Passport passport) {
        SyncHeatDetailDeleteResponse response = new SyncHeatDetailDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatDetailManager.delete(request, passport);
    }

    @Override
    public SyncHeatGetResponse getSyncHeat(SyncHeatGetRequest request, Passport passport) {
        SyncHeatGetResponse response = new SyncHeatGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatManager.get(request, passport);
    }

    @Override
    public SyncHeatSearchResponse searchSyncHeat(SyncHeatSearchRequest request, Passport passport) {
        SyncHeatSearchResponse response = new SyncHeatSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatManager.search(request, passport);
    }

    @Override
    public SyncHeatFindResponse findSyncHeat(SyncHeatFindRequest request, Passport passport) {
        SyncHeatFindResponse response = new SyncHeatFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatManager.find(request, passport);
    }

    @Override
    public SyncHeatGetAllListResponse getSyncHeatAllList(SyncHeatGetAllListRequest request, Passport passport) {
        SyncHeatGetAllListResponse response = new SyncHeatGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatManager.getAllList(request, passport);
    }

    @Override
    public SyncHeatCreateResponse createSyncHeat(SyncHeatCreateRequest request, Passport passport) {
        SyncHeatCreateResponse response = new SyncHeatCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatManager.create(request, passport);
    }

    @Override
    public SyncHeatUpdateResponse updateSyncHeat(SyncHeatUpdateRequest request, Passport passport) {
        SyncHeatUpdateResponse response = new SyncHeatUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatManager.update(request, passport);
    }

    @Override
    public SyncHeatDeleteResponse deleteSyncHeat(SyncHeatDeleteRequest request, Passport passport) {
        SyncHeatDeleteResponse response = new SyncHeatDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncHeatManager.delete(request, passport);
    }

    @Override
    public SyncSportGetResponse getSyncSport(SyncSportGetRequest request, Passport passport) {
        SyncSportGetResponse response = new SyncSportGetResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSportManager.get(request, passport);
    }

    @Override
    public SyncSportSearchResponse searchSyncSport(SyncSportSearchRequest request, Passport passport) {
        SyncSportSearchResponse response = new SyncSportSearchResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSportManager.search(request, passport);
    }

    @Override
    public SyncSportFindResponse findSyncSport(SyncSportFindRequest request, Passport passport) {
        SyncSportFindResponse response = new SyncSportFindResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSportManager.find(request, passport);
    }

    @Override
    public SyncSportGetAllListResponse getSyncSportAllList(SyncSportGetAllListRequest request, Passport passport) {
        SyncSportGetAllListResponse response = new SyncSportGetAllListResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSportManager.getAllList(request, passport);
    }

    @Override
    public SyncSportCreateResponse createSyncSport(SyncSportCreateRequest request, Passport passport) {
        SyncSportCreateResponse response = new SyncSportCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSportManager.create(request, passport);
    }

    @Override
    public SyncSportUpdateResponse updateSyncSport(SyncSportUpdateRequest request, Passport passport) {
        SyncSportUpdateResponse response = new SyncSportUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSportManager.update(request, passport);
    }

    @Override
    public SyncSportDeleteResponse deleteSyncSport(SyncSportDeleteRequest request, Passport passport) {
        SyncSportDeleteResponse response = new SyncSportDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return syncSportManager.delete(request, passport);
    }

    /**
     * 创建常吃的数据
     * @param request 创建常吃数据表请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public OftenEatCreateResponse createOftenEat(OftenEatCreateRequest request, Passport passport) {
        OftenEatCreateResponse response = new OftenEatCreateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return oftenEatManager.create(request, passport);
    }

    /**
     * 修改常吃数据
     * @param request 更新常吃数据表请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public OftenEatUpdateResponse updateOftenEat(OftenEatUpdateRequest request, Passport passport) {
        OftenEatUpdateResponse response = new OftenEatUpdateResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return oftenEatManager.update(request, passport);
    }

    /**
     * 删除我常吃的数据
     * @param request 删除常吃数据表请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public OftenEatDeleteResponse deleteOftenEat(OftenEatDeleteRequest request, Passport passport) {
        OftenEatDeleteResponse response = new OftenEatDeleteResponse();
        ValidationUtil.validate(request, response);
        if (response.hasError()) {
            return response;
        }
        return oftenEatManager.delete(request, passport);
    }
}
