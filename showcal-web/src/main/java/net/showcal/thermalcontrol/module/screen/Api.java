package net.showcal.thermalcontrol.module.screen;

import com.alibaba.citrus.service.requestcontext.buffered.BufferedRequestContext;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.showcal.foundation.domain.UploadTypeEnum;
import com.showcal.foundation.request.FileUploadRequest;
import com.showcal.foundation.response.FileUploadResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.thermalcontrol.domain.*;
import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.FoodListImportResponse;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.log.LogUtil;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.Excel;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import net.showcal.foundation.helper.FoundationHelper;
import net.showcal.thermalcontrol.helper.ThermalcontrolHelper;
import net.showcal.tool.Constants;
import net.showcal.tool.UploadTool;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

/**
 * <p/>
 * <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.thermalcontrol.module.screen.Api
 *  Description: thermalcontrol 的API信息
 *  @since
 *  @author 顾志雄
 * ***************************************************************
 * </pre>
 */
public class Api {
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private BufferedRequestContext brc;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private FoundationHelper foundationHelper;

    @Autowired
    private ThermalcontrolHelper thermalcontrolHelper;

    public void execute(@Param("method") String method) throws Exception {
        BaseResponse baseResponse = new BaseResponse();
        try {
            // 必须关闭buffering，未完成的页面才会被显示在浏览器上。
            brc.setBuffering(false);
            // 设置content type，但不需要设置charset，框架会设置正确的charset。
            response.setContentType("text/plain");
            method = method.toLowerCase();
            Passport passport = (Passport) request.getAttribute("passport");
            InputStreamReader isr = new InputStreamReader(request.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            String line = in.readLine();
            JSONObject jsonObject = new JSONObject();

            if(line!=null&&!"".equals(line)){
                jsonObject = JSON.parseObject(line);
            }
            switch (method) {
                // 根据Id获取基础热量设置
                case "api.thermalcontrol.baseheat.get":
                    baseResponse = getBaseHeat(jsonObject, passport);
                    break;
                // 高级查询基础热量设置
                case "api.thermalcontrol.baseheat.find":
                    baseResponse = findBaseHeat(jsonObject, passport);
                    break;
                // 创建基础热量设置
                case "api.thermalcontrol.baseheat.create":
                    baseResponse = createBaseHeat(jsonObject, passport);
                    break;
                // 更新基础热量设置
                case "api.thermalcontrol.baseheat.update":
                    baseResponse = updateBaseHeat(jsonObject, passport);
                    break;
                // 删除基础热量设置
                case "api.thermalcontrol.baseheat.delete":
                    baseResponse = deleteBaseHeat(jsonObject, passport);
                    break;
                // 根据Id获取BMI食物总重量
                case "api.thermalcontrol.bmifood.get":
                    baseResponse = getBmiFood(jsonObject, passport);
                    break;
                // 高级查询BMI食物总重量
                case "api.thermalcontrol.bmifood.find":
                    baseResponse = findBmiFood(jsonObject, passport);
                    break;
                // 创建BMI食物总重量
                case "api.thermalcontrol.bmifood.create":
                    baseResponse = createBmiFood(jsonObject, passport);
                    break;
                // 更新BMI食物总重量
                case "api.thermalcontrol.bmifood.update":
                    baseResponse = updateBmiFood(jsonObject, passport);
                    break;
                // 删除BMI食物总重量
                case "api.thermalcontrol.bmifood.delete":
                    baseResponse = deleteBmiFood(jsonObject, passport);
                    break;
                // 作废BMI食物总重量
                case "api.thermalcontrol.bmifood.inactive":
                    baseResponse = inactiveBmiFood(jsonObject, passport);
                    break;
                // 激活BMI食物总重量
                case "api.thermalcontrol.bmifood.active":
                    baseResponse = activeBmiFood(jsonObject, passport);
                    break;
                // 高级查询评价基础
                case "api.thermalcontrol.evaluate.find":
                    baseResponse = findEvaluate(jsonObject, passport);
                    break;
                // 创建评价基础
                case "api.thermalcontrol.evaluate.create":
                    baseResponse = createEvaluate(jsonObject, passport);
                    break;
                // 更新评价基础
                case "api.thermalcontrol.evaluate.update":
                    baseResponse = updateEvaluate(jsonObject, passport);
                    break;
                // 高级查询食物类别
                case "api.thermalcontrol.foodcategory.find":
                    baseResponse = findFoodCategory(jsonObject, passport);
                    break;
                // 获取所有食物类别列表
                case "api.thermalcontrol.foodcategoryalllist.get":
                    baseResponse = getFoodCategoryAllList(jsonObject, passport);
                    break;
                // 创建食物类别
                case "api.thermalcontrol.foodcategory.create":
                    baseResponse = createFoodCategory(jsonObject, passport);
                    break;
                // 更新食物类别
                case "api.thermalcontrol.foodcategory.update":
                    baseResponse = updateFoodCategory(jsonObject, passport);
                    break;
                // 删除食物类别
                case "api.thermalcontrol.foodcategory.delete":
                    baseResponse = deleteFoodCategory(jsonObject, passport);
                    break;
                // 高级查询食物交换份
                case "api.thermalcontrol.foodexchange.find":
                    baseResponse = findFoodExchange(jsonObject, passport);
                    break;
                // 获取所有食物交换份列表
                case "api.thermalcontrol.foodexchangealllist.get":
                    baseResponse = getFoodExchangeAllList(jsonObject, passport);
                    break;
                // 创建食物交换份
                case "api.thermalcontrol.foodexchange.create":
                    baseResponse = createFoodExchange(jsonObject, passport);
                    break;
                // 更新食物交换份
                case "api.thermalcontrol.foodexchange.update":
                    baseResponse = updateFoodExchange(jsonObject, passport);
                    break;
                // 删除食物交换份
                case "api.thermalcontrol.foodexchange.delete":
                    baseResponse = deleteFoodExchange(jsonObject, passport);
                    break;
                // 作废食物交换份
                case "api.thermalcontrol.foodexchange.inactive":
                    baseResponse = inactiveFoodExchange(jsonObject, passport);
                    break;
                // 激活食物交换份
                case "api.thermalcontrol.foodexchange.active":
                    baseResponse = activeFoodExchange(jsonObject, passport);
                    break;
                // 高级查询食物
                case "api.thermalcontrol.food.find":
                    baseResponse = findFood(jsonObject, passport);
                    break;
                // 创建食物
                case "api.thermalcontrol.food.create":
                    baseResponse = createFood(jsonObject, passport);
                    break;
                // 更新食物
                case "api.thermalcontrol.food.update":
                    baseResponse = updateFood(jsonObject, passport);
                    break;
                // 根据ID获取食物
                case "api.thermalcontrol.food.get":
                    baseResponse = getFood(jsonObject, passport);
                    break;
                // 删除食物
                case "api.thermalcontrol.food.delete":
                    baseResponse = deleteFood(jsonObject, passport);
                    break;
                // 作废食物
                case "api.thermalcontrol.food.inactive":
                    baseResponse = inactiveFood(jsonObject, passport);
                    break;
                // 激活食物
                case "api.thermalcontrol.food.active":
                    baseResponse = activeFood(jsonObject, passport);
                    break;
                // 下载模版
                case "api.thermalcontrol.food.output.template":
                    baseResponse = outputFoodTemplate(passport);
                    break;

                // 根据Id获取打分权重表
                case "api.thermalcontrol.gradeweight.get":
                    baseResponse = getGradeWeight(jsonObject, passport);
                    break;
                // 模糊查询打分权重表
                case "api.thermalcontrol.gradeweight.search":
                    baseResponse = searchGradeWeight(jsonObject, passport);
                    break;
                // 高级查询打分权重表
                case "api.thermalcontrol.gradeweight.find":
                    baseResponse = findGradeWeight(jsonObject, passport);
                    break;
                // 获取所有打分权重表列表
                case "api.thermalcontrol.gradeweightalllist.get":
                    baseResponse = getGradeWeightAllList(jsonObject, passport);
                    break;
                // 创建打分权重表
                case "api.thermalcontrol.gradeweight.create":
                    baseResponse = createGradeWeight(jsonObject, passport);
                    break;
                // 更新打分权重表
                case "api.thermalcontrol.gradeweight.update":
                    baseResponse = updateGradeWeight(jsonObject, passport);
                    break;
                // 删除打分权重表
                case "api.thermalcontrol.gradeweight.delete":
                    baseResponse = deleteGradeWeight(jsonObject, passport);
                    break;
                // 根据当前时间获取餐次
                case "api.thermalcontrol.meals.get":
                    baseResponse = getMeals(jsonObject, passport);
                    break;
                // 高级查询餐次
                case "api.thermalcontrol.meals.find":
                    baseResponse = findMeals(jsonObject, passport);
                    break;
                // 创建餐次
                case "api.thermalcontrol.meals.create":
                    baseResponse = createMeals(jsonObject, passport);
                    break;
                // 更新餐次
                case "api.thermalcontrol.meals.update":
                    baseResponse = updateMeals(jsonObject, passport);
                    break;
                // 删除餐次
                case "api.thermalcontrol.meals.delete":
                    baseResponse = deleteMeals(jsonObject, passport);
                    break;
                // 根据Id获取营养目标
                case "api.thermalcontrol.nutritionalgoal.get":
                    baseResponse = getNutritionalGoal(jsonObject, passport);
                    break;
                // 模糊查询营养目标
                case "api.thermalcontrol.nutritionalgoal.search":
                    baseResponse = searchNutritionalGoal(jsonObject, passport);
                    break;
                // 高级查询营养目标
                case "api.thermalcontrol.nutritionalgoal.find":
                    baseResponse = findNutritionalGoal(jsonObject, passport);
                    break;
                // 创建营养目标
                case "api.thermalcontrol.nutritionalgoal.create":
                    baseResponse = createNutritionalGoal(jsonObject, passport);
                    break;
                // 更新营养目标
                case "api.thermalcontrol.nutritionalgoal.update":
                    baseResponse = updateNutritionalGoal(jsonObject, passport);
                    break;
                // 删除营养目标
                case "api.thermalcontrol.nutritionalgoal.delete":
                    baseResponse = deleteNutritionalGoal(jsonObject, passport);
                    break;
                // 作废营养目标
                case "api.thermalcontrol.nutritionalgoal.inactive":
                    baseResponse = inactiveNutritionalGoal(jsonObject, passport);
                    break;
                // 激活营养目标
                case "api.thermalcontrol.nutritionalgoal.active":
                    baseResponse = activeNutritionalGoal(jsonObject, passport);
                    break;
                // 根据Id获取运动方案
                case "api.thermalcontrol.sporthead.get":
                    baseResponse = getSportHead(jsonObject, passport);
                    break;
                // 高级查询运动方案
                case "api.thermalcontrol.sporthead.find":
                    baseResponse = findSportHead(jsonObject, passport);
                    break;
                // 创建运动方案
                case "api.thermalcontrol.sporthead.create":
                    baseResponse = createSportHead(jsonObject, passport);
                    break;
                // 更新运动方案
                case "api.thermalcontrol.sporthead.update":
                    baseResponse = updateSportHead(jsonObject, passport);
                    break;
                // 更新运动方案时间
                case "api.thermalcontrol.sporthead.updateTotalTime":
                    baseResponse = updateSportHeadTotalTime(jsonObject, passport);
                    break;
                // 删除运动方案
                case "api.thermalcontrol.sporthead.delete":
                    baseResponse = deleteSportHead(jsonObject, passport);
                    break;
                // 获取所有运动方案明细列表
                case "api.thermalcontrol.sportlinealllist.get":
                    baseResponse = getSportLineAllList(jsonObject, passport);
                    break;
                // 创建运动方案明细
                case "api.thermalcontrol.sportline.create":
                    baseResponse = createSportLine(jsonObject, passport);
                    break;
                // 更新运动方案明细
                case "api.thermalcontrol.sportline.update":
                    baseResponse = updateSportLine(jsonObject, passport);
                    break;
                // 删除运动方案明细
                case "api.thermalcontrol.sportline.delete":
                    baseResponse = deleteSportLine(jsonObject, passport);
                    break;
                // 根据Id获取运动主数据
                case "api.thermalcontrol.sportsetting.get":
                    baseResponse = getSportSetting(jsonObject, passport);
                    break;
                // 模糊查询运动主数据
                case "api.thermalcontrol.sportsetting.search":
                    baseResponse = searchSportSetting(jsonObject, passport);
                    break;
                // 高级查询运动主数据
                case "api.thermalcontrol.sportsetting.find":
                    baseResponse = findSportSetting(jsonObject, passport);
                    break;
                // 获取所有运动主数据列表
                case "api.thermalcontrol.sportsettingalllist.get":
                    baseResponse = getSportSettingAllList(jsonObject, passport);
                    break;
                // 创建运动主数据
                case "api.thermalcontrol.sportsetting.create":
                    baseResponse = createSportSetting(jsonObject, passport);
                    break;
                // 更新运动主数据
                case "api.thermalcontrol.sportsetting.update":
                    baseResponse = updateSportSetting(jsonObject, passport);
                    break;
                // 删除运动主数据
                case "api.thermalcontrol.sportsetting.delete":
                    baseResponse = deleteSportSetting(jsonObject, passport);
                    break;
                // 根据Id获取热量同步明细表
                case "api.thermalcontrol.syncheatdetail.get":
                    baseResponse = getSyncHeatDetail(jsonObject, passport);
                    break;
                // 模糊查询热量同步明细表
                case "api.thermalcontrol.syncheatdetail.search":
                    baseResponse = searchSyncHeatDetail(jsonObject, passport);
                    break;
                // 高级查询热量同步明细表
                case "api.thermalcontrol.syncheatdetail.find":
                    baseResponse = findSyncHeatDetail(jsonObject, passport);
                    break;
                // 获取所有热量同步明细表列表
                case "api.thermalcontrol.syncheatdetailalllist.get":
                    baseResponse = getSyncHeatDetailAllList(jsonObject, passport);
                    break;
                // 创建热量同步明细表
                case "api.thermalcontrol.syncheatdetail.create":
                    baseResponse = createSyncHeatDetail(jsonObject, passport);
                    break;
                // 更新热量同步明细表
                case "api.thermalcontrol.syncheatdetail.update":
                    baseResponse = updateSyncHeatDetail(jsonObject, passport);
                    break;
                // 删除热量同步明细表
                case "api.thermalcontrol.syncheatdetail.delete":
                    baseResponse = deleteSyncHeatDetail(jsonObject, passport);
                    break;
                // 根据Id获取热量同步表
                case "api.thermalcontrol.syncheat.get":
                    baseResponse = getSyncHeat(jsonObject, passport);
                    break;
                // 模糊查询热量同步表
                case "api.thermalcontrol.syncheat.search":
                    baseResponse = searchSyncHeat(jsonObject, passport);
                    break;
                // 高级查询热量同步表
                case "api.thermalcontrol.syncheat.find":
                    baseResponse = findSyncHeat(jsonObject, passport);
                    break;
                // 获取所有热量同步表列表
                case "api.thermalcontrol.syncheatalllist.get":
                    baseResponse = getSyncHeatAllList(jsonObject, passport);
                    break;
                // 创建热量同步表
                case "api.thermalcontrol.syncheat.create":
                    baseResponse = createSyncHeat(jsonObject, passport);
                    break;

                case "api.thermalcontrol.sport.head.template":
                    baseResponse = apiSportHeadTemplate(passport);
                    break;
                case "api.thermalcontrol.sport.line.template":
                    baseResponse = apiSportLineTemplate(passport);
                    break;
                case "api.thermalcontrol.sport.setting.template":
                    baseResponse = apiSportingTemplate(passport);
                    break;

                // 更新热量同步表
                case "api.thermalcontrol.syncheat.update":
                    baseResponse = updateSyncHeat(jsonObject, passport);
                    break;
                // 删除热量同步表
                case "api.thermalcontrol.syncheat.delete":
                    baseResponse = deleteSyncHeat(jsonObject, passport);
                    break;
                // 根据Id获取运动同步表
                case "api.thermalcontrol.syncsport.get":
                    baseResponse = getSyncSport(jsonObject, passport);
                    break;
                // 模糊查询运动同步表
                case "api.thermalcontrol.syncsport.search":
                    baseResponse = searchSyncSport(jsonObject, passport);
                    break;
                // 高级查询运动同步表
                case "api.thermalcontrol.syncsport.find":
                    baseResponse = findSyncSport(jsonObject, passport);
                    break;
                // 获取所有运动同步表列表
                case "api.thermalcontrol.syncsportalllist.get":
                    baseResponse = getSyncSportAllList(jsonObject, passport);
                    break;
                // 创建运动同步表
                case "api.thermalcontrol.syncsport.create":
                    baseResponse = createSyncSport(jsonObject, passport);
                    break;
                // 更新运动同步表
                case "api.thermalcontrol.syncsport.update":
                    baseResponse = updateSyncSport(jsonObject, passport);
                    break;
                // 删除运动同步表
                case "api.thermalcontrol.syncsport.delete":
                    baseResponse = deleteSyncSport(jsonObject, passport);
                    break;
                default:
                    baseResponse.addError(ErrorType.INVALID_PARAMETER, Constants.NOT_EXIST_METHOD);
                    break;
            }
        } catch (Exception ex) {
            baseResponse.addError(ErrorType.SYSTEM_ERROR, Constants.ERROR_MESSAGE_500);
            baseResponse.addError(ErrorType.STACK_DUMP, LogUtil.dumpException(ex));
            LogUtil.errorLog(ex);
        } finally {
            String jsonTenant = JSON.toJSONString(baseResponse);
            PrintWriter out = response.getWriter();
            out.println(jsonTenant);
        }
    }

    /**
     * 根据Id获取基础热量设置
     */
    private BaseResponse getBaseHeat(JSONObject jsonObject, Passport passport) {
        BaseHeatGetRequest request = JSON.toJavaObject(jsonObject, BaseHeatGetRequest.class);
        return thermalcontrolHelper.getBaseHeat(request, passport);
    }

    /**
     * 高级查询基础热量设置
     */
    private BaseResponse findBaseHeat(JSONObject jsonObject, Passport passport) {
        BaseHeatFindRequest request = JSON.toJavaObject(jsonObject, BaseHeatFindRequest.class);
        return thermalcontrolHelper.findBaseHeat(request, passport);
    }

    /**
     * 创建基础热量设置
     */
    private BaseResponse createBaseHeat(JSONObject jsonObject, Passport passport) {
        BaseHeatCreateRequest request = JSON.toJavaObject(jsonObject, BaseHeatCreateRequest.class);
        return thermalcontrolHelper.createBaseHeat(request, passport);
    }

    /**
     * 更新基础热量设置
     */
    private BaseResponse updateBaseHeat(JSONObject jsonObject, Passport passport) {
        BaseHeatUpdateRequest request = JSON.toJavaObject(jsonObject, BaseHeatUpdateRequest.class);
        return thermalcontrolHelper.updateBaseHeat(request, passport);
    }

    /**
     * 删除基础热量设置
     */
    private BaseResponse deleteBaseHeat(JSONObject jsonObject, Passport passport) {
        BaseHeatDeleteRequest request = JSON.toJavaObject(jsonObject, BaseHeatDeleteRequest.class);
        return thermalcontrolHelper.deleteBaseHeat(request, passport);
    }

    /**
     * 根据Id获取BMI食物总重量
     */
    private BaseResponse getBmiFood(JSONObject jsonObject, Passport passport) {
        BmiFoodGetRequest request = JSON.toJavaObject(jsonObject, BmiFoodGetRequest.class);
        return thermalcontrolHelper.getBmiFood(request, passport);
    }

    /**
     * 高级查询BMI食物总重量
     */
    private BaseResponse findBmiFood(JSONObject jsonObject, Passport passport) {
        BmiFoodFindRequest request = JSON.toJavaObject(jsonObject, BmiFoodFindRequest.class);
        return thermalcontrolHelper.findBmiFood(request, passport);
    }

    /**
     * 创建BMI食物总重量
     */
    private BaseResponse createBmiFood(JSONObject jsonObject, Passport passport) {
        BmiFoodCreateRequest request = JSON.toJavaObject(jsonObject, BmiFoodCreateRequest.class);
        return thermalcontrolHelper.createBmiFood(request, passport);
    }
    private BaseResponse apiSportHeadTemplate(Passport passport) {
        DataTable table = new DataTable<>(SportHeadImportShow.class);
        return UploadTool.uploadDataTable(table, passport, false);
    }
    private BaseResponse apiSportLineTemplate(Passport passport) {
        DataTable table = new DataTable<>(SportLineImport.class);
        return UploadTool.uploadDataTable(table, passport, false);
    }

    private BaseResponse apiSportingTemplate(Passport passport) {
        DataTable table = new DataTable<>(SportSettingImport.class);
        return UploadTool.uploadDataTable(table, passport, false);
    }

    /**
     * 更新BMI食物总重量
     */
    private BaseResponse updateBmiFood(JSONObject jsonObject, Passport passport) {
        BmiFoodUpdateRequest request = JSON.toJavaObject(jsonObject, BmiFoodUpdateRequest.class);
        return thermalcontrolHelper.updateBmiFood(request, passport);
    }

    /**
     * 删除BMI食物总重量
     */
    private BaseResponse deleteBmiFood(JSONObject jsonObject, Passport passport) {
        BmiFoodDeleteRequest request = JSON.toJavaObject(jsonObject, BmiFoodDeleteRequest.class);
        return thermalcontrolHelper.deleteBmiFood(request, passport);
    }

    /**
     * 作废BMI食物总重量
     */
    private BaseResponse inactiveBmiFood(JSONObject jsonObject, Passport passport) {
        BmiFoodInactiveRequest request = JSON.toJavaObject(jsonObject, BmiFoodInactiveRequest.class);
        return thermalcontrolHelper.inactiveBmiFood(request, passport);
    }

    /**
     * 激活BMI食物总重量
     */
    private BaseResponse activeBmiFood(JSONObject jsonObject, Passport passport) {
        BmiFoodActiveRequest request = JSON.toJavaObject(jsonObject, BmiFoodActiveRequest.class);
        return thermalcontrolHelper.activeBmiFood(request, passport);
    }

    /**
     * 高级查询评价基础
     */
    private BaseResponse findEvaluate(JSONObject jsonObject, Passport passport) {
        EvaluateFindRequest request = JSON.toJavaObject(jsonObject, EvaluateFindRequest.class);
        return thermalcontrolHelper.findEvaluate(request, passport);
    }

    /**
     * 创建评价基础
     */
    private BaseResponse createEvaluate(JSONObject jsonObject, Passport passport) {
        EvaluateCreateRequest request = JSON.toJavaObject(jsonObject, EvaluateCreateRequest.class);
        return thermalcontrolHelper.createEvaluate(request, passport);
    }

    /**
     * 更新评价基础
     */
    private BaseResponse updateEvaluate(JSONObject jsonObject, Passport passport) {
        EvaluateUpdateRequest request = JSON.toJavaObject(jsonObject, EvaluateUpdateRequest.class);
        return thermalcontrolHelper.updateEvaluate(request, passport);
    }

    /**
     * 高级查询食物类别
     */
    private BaseResponse findFoodCategory(JSONObject jsonObject, Passport passport) {
        FoodCategoryFindRequest request = JSON.toJavaObject(jsonObject, FoodCategoryFindRequest.class);
        return thermalcontrolHelper.findFoodCategory(request, passport);
    }

    /**
     * 获取所有食物类别列表
     */
    private BaseResponse getFoodCategoryAllList(JSONObject jsonObject, Passport passport) {
        FoodCategoryGetAllListRequest request = JSON.toJavaObject(jsonObject, FoodCategoryGetAllListRequest.class);
        return thermalcontrolHelper.getFoodCategoryAllList(request, passport);
    }

    /**
     * 创建食物类别
     */
    private BaseResponse createFoodCategory(JSONObject jsonObject, Passport passport) {
        FoodCategoryCreateRequest request = JSON.toJavaObject(jsonObject, FoodCategoryCreateRequest.class);
        return thermalcontrolHelper.createFoodCategory(request, passport);
    }

    /**
     * 更新食物类别
     */
    private BaseResponse updateFoodCategory(JSONObject jsonObject, Passport passport) {
        FoodCategoryUpdateRequest request = JSON.toJavaObject(jsonObject, FoodCategoryUpdateRequest.class);
        return thermalcontrolHelper.updateFoodCategory(request, passport);
    }

    /**
     * 删除食物类别
     */
    private BaseResponse deleteFoodCategory(JSONObject jsonObject, Passport passport) {
        FoodCategoryDeleteRequest request = JSON.toJavaObject(jsonObject, FoodCategoryDeleteRequest.class);
        return thermalcontrolHelper.deleteFoodCategory(request, passport);
    }

    /**
     * 高级查询食物交换份
     */
    private BaseResponse findFoodExchange(JSONObject jsonObject, Passport passport) {
        FoodExchangeFindRequest request = JSON.toJavaObject(jsonObject, FoodExchangeFindRequest.class);
        return thermalcontrolHelper.findFoodExchange(request, passport);
    }

    /**
     * 获取所有食物交换份列表
     */
    private BaseResponse getFoodExchangeAllList(JSONObject jsonObject, Passport passport) {
        FoodExchangeGetAllListRequest request = JSON.toJavaObject(jsonObject, FoodExchangeGetAllListRequest.class);
        return thermalcontrolHelper.getFoodExchangeAllList(request, passport);
    }

    /**
     * 创建食物交换份
     */
    private BaseResponse createFoodExchange(JSONObject jsonObject, Passport passport) {
        FoodExchangeCreateRequest request = JSON.toJavaObject(jsonObject, FoodExchangeCreateRequest.class);
        return thermalcontrolHelper.createFoodExchange(request, passport);
    }

    /**
     * 更新食物交换份
     */
    private BaseResponse updateFoodExchange(JSONObject jsonObject, Passport passport) {
        FoodExchangeUpdateRequest request = JSON.toJavaObject(jsonObject, FoodExchangeUpdateRequest.class);
        return thermalcontrolHelper.updateFoodExchange(request, passport);
    }

    /**
     * 删除食物交换份
     */
    private BaseResponse deleteFoodExchange(JSONObject jsonObject, Passport passport) {
        FoodExchangeDeleteRequest request = JSON.toJavaObject(jsonObject, FoodExchangeDeleteRequest.class);
        return thermalcontrolHelper.deleteFoodExchange(request, passport);
    }

    /**
     * 作废食物交换份
     */
    private BaseResponse inactiveFoodExchange(JSONObject jsonObject, Passport passport) {
        FoodExchangeInactiveRequest request = JSON.toJavaObject(jsonObject, FoodExchangeInactiveRequest.class);
        return thermalcontrolHelper.inactiveFoodExchange(request, passport);
    }

    /**
     * 激活食物交换份
     */
    private BaseResponse activeFoodExchange(JSONObject jsonObject, Passport passport) {
        FoodExchangeActiveRequest request = JSON.toJavaObject(jsonObject, FoodExchangeActiveRequest.class);
        return thermalcontrolHelper.activeFoodExchange(request, passport);
    }

    /**
     * 高级查询食物
     */
    private BaseResponse    findFood(JSONObject jsonObject, Passport passport) {
        FoodFindRequest request = JSON.toJavaObject(jsonObject, FoodFindRequest.class);
        return thermalcontrolHelper.findFood(request, passport);
    }

    /**
     * 创建食物
     */
    private BaseResponse createFood(JSONObject jsonObject, Passport passport) {
        FoodCreateRequest request = JSON.toJavaObject(jsonObject, FoodCreateRequest.class);
        return thermalcontrolHelper.createFood(request, passport);
    }

    /**
     * 更新食物
     */
    private BaseResponse updateFood(JSONObject jsonObject, Passport passport) {
        FoodUpdateRequest request = JSON.toJavaObject(jsonObject, FoodUpdateRequest.class);
        return thermalcontrolHelper.updateFood(request, passport);
    }

    /**
     * 获取食物
     */
    private BaseResponse getFood(JSONObject jsonObject, Passport passport) {
        FoodGetRequest request = JSON.toJavaObject(jsonObject, FoodGetRequest.class);
        return thermalcontrolHelper.getFood(request, passport);
    }

    /**
     * 删除食物
     */
    private BaseResponse deleteFood(JSONObject jsonObject, Passport passport) {
        FoodDeleteRequest request = JSON.toJavaObject(jsonObject, FoodDeleteRequest.class);
        return thermalcontrolHelper.deleteFood(request, passport);
    }

    /**
     * 作废食物
     */
    private BaseResponse inactiveFood(JSONObject jsonObject, Passport passport) {
        FoodInactiveRequest request = JSON.toJavaObject(jsonObject, FoodInactiveRequest.class);
        return thermalcontrolHelper.inactiveFood(request, passport);
    }

    /**
     * 激活食物
     */
    private BaseResponse activeFood(JSONObject jsonObject, Passport passport) {
        FoodActiveRequest request = JSON.toJavaObject(jsonObject, FoodActiveRequest.class);
        return thermalcontrolHelper.activeFood(request, passport);
    }

    /**
     *  下载模版
     *
     * @param passport
     * @return
     */
    private FileUploadResponse outputFoodTemplate(Passport passport) throws IOException {
        FileUploadResponse uploadResponse = new FileUploadResponse();
        DataTable<FoodImport> table = new DataTable<>(FoodImport.class);
        byte[] bytes = new Excel(table).getBytes();
        FileUploadRequest uploadRequest = new FileUploadRequest();
        uploadRequest.setFileStream(bytes);
        uploadRequest.setFileExt("xlsx");
        uploadRequest.setType(UploadTypeEnum.TMP);
        uploadResponse = foundationService.uploadFile(uploadRequest, passport);
        return uploadResponse;
    }

    /**
     * 根据Id获取打分权重表
     */
    private BaseResponse getGradeWeight(JSONObject jsonObject, Passport passport) {
        GradeWeightGetRequest request = JSON.toJavaObject(jsonObject, GradeWeightGetRequest.class);
        return thermalcontrolHelper.getGradeWeight(request, passport);
    }

    /**
     * 模糊查询打分权重表
     */
    private BaseResponse searchGradeWeight(JSONObject jsonObject, Passport passport) {
        GradeWeightSearchRequest request = JSON.toJavaObject(jsonObject, GradeWeightSearchRequest.class);
        return thermalcontrolHelper.searchGradeWeight(request, passport);
    }

    /**
     * 高级查询打分权重表
     */
    private BaseResponse findGradeWeight(JSONObject jsonObject, Passport passport) {
        GradeWeightFindRequest request = JSON.toJavaObject(jsonObject, GradeWeightFindRequest.class);
        return thermalcontrolHelper.findGradeWeight(request, passport);
    }

    /**
     * 获取所有打分权重表列表
     */
    private BaseResponse getGradeWeightAllList(JSONObject jsonObject, Passport passport) {
        GradeWeightGetAllListRequest request = JSON.toJavaObject(jsonObject, GradeWeightGetAllListRequest.class);
        return thermalcontrolHelper.getGradeWeightAllList(request, passport);
    }

    /**
     * 创建打分权重表
     */
    private BaseResponse createGradeWeight(JSONObject jsonObject, Passport passport) {
        GradeWeightCreateRequest request = JSON.toJavaObject(jsonObject, GradeWeightCreateRequest.class);
        return thermalcontrolHelper.createGradeWeight(request, passport);
    }

    /**
     * 更新打分权重表
     */
    private BaseResponse updateGradeWeight(JSONObject jsonObject, Passport passport) {
        GradeWeightUpdateRequest request = JSON.toJavaObject(jsonObject, GradeWeightUpdateRequest.class);
        return thermalcontrolHelper.updateGradeWeight(request, passport);
    }

    /**
     * 删除打分权重表
     */
    private BaseResponse deleteGradeWeight(JSONObject jsonObject, Passport passport) {
        GradeWeightDeleteRequest request = JSON.toJavaObject(jsonObject, GradeWeightDeleteRequest.class);
        return thermalcontrolHelper.deleteGradeWeight(request, passport);
    }

    /**
     * 根据当前时间获取餐次
     */
    private BaseResponse getMeals(JSONObject jsonObject, Passport passport) {
        MealsGetRequest request = JSON.toJavaObject(jsonObject, MealsGetRequest.class);
        return thermalcontrolHelper.getMeals(request, passport);
    }

    /**
     * 高级查询餐次
     */
    private BaseResponse findMeals(JSONObject jsonObject, Passport passport) {
        MealsFindRequest request = JSON.toJavaObject(jsonObject, MealsFindRequest.class);
        return thermalcontrolHelper.findMeals(request, passport);
    }

    /**
     * 创建餐次
     */
    private BaseResponse createMeals(JSONObject jsonObject, Passport passport) {
        MealsCreateRequest request = JSON.toJavaObject(jsonObject, MealsCreateRequest.class);
        return thermalcontrolHelper.createMeals(request, passport);
    }

    /**
     * 更新餐次
     */
    private BaseResponse updateMeals(JSONObject jsonObject, Passport passport) {
        MealsUpdateRequest request = JSON.toJavaObject(jsonObject, MealsUpdateRequest.class);
        return thermalcontrolHelper.updateMeals(request, passport);
    }

    /**
     * 删除餐次
     */
    private BaseResponse deleteMeals(JSONObject jsonObject, Passport passport) {
        MealsDeleteRequest request = JSON.toJavaObject(jsonObject, MealsDeleteRequest.class);
        return thermalcontrolHelper.deleteMeals(request, passport);
    }

    /**
     * 根据Id获取营养目标
     */
    private BaseResponse getNutritionalGoal(JSONObject jsonObject, Passport passport) {
        NutritionalGoalGetRequest request = JSON.toJavaObject(jsonObject, NutritionalGoalGetRequest.class);
        return thermalcontrolHelper.getNutritionalGoal(request, passport);
    }

    /**
     * 模糊查询营养目标
     */
    private BaseResponse searchNutritionalGoal(JSONObject jsonObject, Passport passport) {
        NutritionalGoalSearchRequest request = JSON.toJavaObject(jsonObject, NutritionalGoalSearchRequest.class);
        return thermalcontrolHelper.searchNutritionalGoal(request, passport);
    }

    /**
     * 高级查询营养目标
     */
    private BaseResponse findNutritionalGoal(JSONObject jsonObject, Passport passport) {
        NutritionalGoalFindRequest request = JSON.toJavaObject(jsonObject, NutritionalGoalFindRequest.class);
        return thermalcontrolHelper.findNutritionalGoal(request, passport);
    }

    /**
     * 创建营养目标
     */
    private BaseResponse createNutritionalGoal(JSONObject jsonObject, Passport passport) {
        NutritionalGoalCreateRequest request = JSON.toJavaObject(jsonObject, NutritionalGoalCreateRequest.class);
        return thermalcontrolHelper.createNutritionalGoal(request, passport);
    }

    /**
     * 更新营养目标
     */
    private BaseResponse updateNutritionalGoal(JSONObject jsonObject, Passport passport) {
        NutritionalGoalUpdateRequest request = JSON.toJavaObject(jsonObject, NutritionalGoalUpdateRequest.class);
        return thermalcontrolHelper.updateNutritionalGoal(request, passport);
    }

    /**
     * 删除营养目标
     */
    private BaseResponse deleteNutritionalGoal(JSONObject jsonObject, Passport passport) {
        NutritionalGoalDeleteRequest request = JSON.toJavaObject(jsonObject, NutritionalGoalDeleteRequest.class);
        return thermalcontrolHelper.deleteNutritionalGoal(request, passport);
    }

    /**
     * 作废营养目标
     */
    private BaseResponse inactiveNutritionalGoal(JSONObject jsonObject, Passport passport) {
        NutritionalGoalInactiveRequest request = JSON.toJavaObject(jsonObject, NutritionalGoalInactiveRequest.class);
        return thermalcontrolHelper.inactiveNutritionalGoal(request, passport);
    }

    /**
     * 激活营养目标
     */
    private BaseResponse activeNutritionalGoal(JSONObject jsonObject, Passport passport) {
        NutritionalGoalActiveRequest request = JSON.toJavaObject(jsonObject, NutritionalGoalActiveRequest.class);
        return thermalcontrolHelper.activeNutritionalGoal(request, passport);
    }

    /**
     * 根据Id获取运动方案
     */
    private BaseResponse getSportHead(JSONObject jsonObject, Passport passport) {
        SportHeadGetRequest request = JSON.toJavaObject(jsonObject, SportHeadGetRequest.class);
        return thermalcontrolHelper.getSportHead(request, passport);
    }

    /**
     * 高级查询运动方案
     */
    private BaseResponse findSportHead(JSONObject jsonObject, Passport passport) {
        SportHeadFindRequest request = JSON.toJavaObject(jsonObject, SportHeadFindRequest.class);
        return thermalcontrolHelper.findSportHead(request, passport);
    }

    /**
     * 创建运动方案
     */
    private BaseResponse createSportHead(JSONObject jsonObject, Passport passport) {
        SportHeadCreateRequest request = JSON.toJavaObject(jsonObject, SportHeadCreateRequest.class);
        return thermalcontrolHelper.createSportHead(request, passport);
    }

    /**
     * 更新运动方案
     */
    private BaseResponse updateSportHead(JSONObject jsonObject, Passport passport) {
        SportHeadUpdateRequest request = JSON.toJavaObject(jsonObject, SportHeadUpdateRequest.class);
        return thermalcontrolHelper.updateSportHead(request, passport);
    }
    /**
     * 更新运动方案
     */
    private BaseResponse updateSportHeadTotalTime(JSONObject jsonObject, Passport passport) {
        SportHeadUpdateTotalTimeRequest request = JSON.toJavaObject(jsonObject, SportHeadUpdateTotalTimeRequest.class);
        return thermalcontrolHelper.updateSportHeadTotalTime(request, passport);
    }

    /**
     * 删除运动方案
     */
    private BaseResponse deleteSportHead(JSONObject jsonObject, Passport passport) {
        SportHeadDeleteRequest request = JSON.toJavaObject(jsonObject, SportHeadDeleteRequest.class);
        return thermalcontrolHelper.deleteSportHead(request, passport);
    }

    /**
     * 获取所有运动方案明细列表
     */
    private BaseResponse getSportLineAllList(JSONObject jsonObject, Passport passport) {
        SportLineGetAllListRequest request = JSON.toJavaObject(jsonObject, SportLineGetAllListRequest.class);
        return thermalcontrolHelper.getSportLineAllList(request, passport);
    }

    /**
     * 创建运动方案明细
     */
    private BaseResponse createSportLine(JSONObject jsonObject, Passport passport) {
        SportLineCreateRequest request = JSON.toJavaObject(jsonObject, SportLineCreateRequest.class);
        return thermalcontrolHelper.createSportLine(request, passport);
    }

    /**
     * 更新运动方案明细
     */
    private BaseResponse updateSportLine(JSONObject jsonObject, Passport passport) {
        SportLineUpdateRequest request = JSON.toJavaObject(jsonObject, SportLineUpdateRequest.class);
        return thermalcontrolHelper.updateSportLine(request, passport);
    }

    /**
     * 删除运动方案明细
     */
    private BaseResponse deleteSportLine(JSONObject jsonObject, Passport passport) {
        SportLineDeleteRequest request = JSON.toJavaObject(jsonObject, SportLineDeleteRequest.class);
        return thermalcontrolHelper.deleteSportLine(request, passport);
    }

    /**
     * 根据Id获取运动主数据
     */
    private BaseResponse getSportSetting(JSONObject jsonObject, Passport passport) {
        SportSettingGetRequest request = JSON.toJavaObject(jsonObject, SportSettingGetRequest.class);
        return thermalcontrolHelper.getSportSetting(request, passport);
    }

    /**
     * 模糊查询运动主数据
     */
    private BaseResponse searchSportSetting(JSONObject jsonObject, Passport passport) {
        SportSettingSearchRequest request = JSON.toJavaObject(jsonObject, SportSettingSearchRequest.class);
        return thermalcontrolHelper.searchSportSetting(request, passport);
    }

    /**
     * 高级查询运动主数据
     */
    private BaseResponse findSportSetting(JSONObject jsonObject, Passport passport) {
        SportSettingFindRequest request = JSON.toJavaObject(jsonObject, SportSettingFindRequest.class);
        return thermalcontrolHelper.findSportSetting(request, passport);
    }

    /**
     * 获取所有运动主数据列表
     */
    private BaseResponse getSportSettingAllList(JSONObject jsonObject, Passport passport) {
        SportSettingFindRequest request = JSON.toJavaObject(jsonObject, SportSettingFindRequest.class);
        return thermalcontrolHelper.findSportSetting(request, passport);
    }

    /**
     * 创建运动主数据
     */
    private BaseResponse createSportSetting(JSONObject jsonObject, Passport passport) {
        SportSettingCreateRequest request = JSON.toJavaObject(jsonObject, SportSettingCreateRequest.class);
        return thermalcontrolHelper.createSportSetting(request, passport);
    }

    /**
     * 更新运动主数据
     */
    private BaseResponse updateSportSetting(JSONObject jsonObject, Passport passport) {
        SportSettingUpdateRequest request = JSON.toJavaObject(jsonObject, SportSettingUpdateRequest.class);
        return thermalcontrolHelper.updateSportSetting(request, passport);
    }

    /**
     * 删除运动主数据
     */
    private BaseResponse deleteSportSetting(JSONObject jsonObject, Passport passport) {
        SportSettingDeleteRequest request = JSON.toJavaObject(jsonObject, SportSettingDeleteRequest.class);
        return thermalcontrolHelper.deleteSportSetting(request, passport);
    }

    /**
     * 根据Id获取热量同步明细表
     */
    private BaseResponse getSyncHeatDetail(JSONObject jsonObject, Passport passport) {
        SyncHeatDetailGetRequest request = JSON.toJavaObject(jsonObject, SyncHeatDetailGetRequest.class);
        return thermalcontrolHelper.getSyncHeatDetail(request, passport);
    }

    /**
     * 模糊查询热量同步明细表
     */
    private BaseResponse searchSyncHeatDetail(JSONObject jsonObject, Passport passport) {
        SyncHeatDetailSearchRequest request = JSON.toJavaObject(jsonObject, SyncHeatDetailSearchRequest.class);
        return thermalcontrolHelper.searchSyncHeatDetail(request, passport);
    }

    /**
     * 高级查询热量同步明细表
     */
    private BaseResponse findSyncHeatDetail(JSONObject jsonObject, Passport passport) {
        SyncHeatDetailFindRequest request = JSON.toJavaObject(jsonObject, SyncHeatDetailFindRequest.class);
        return thermalcontrolHelper.findSyncHeatDetail(request, passport);
    }

    /**
     * 获取所有热量同步明细表列表
     */
    private BaseResponse getSyncHeatDetailAllList(JSONObject jsonObject, Passport passport) {
        SyncHeatDetailGetAllListRequest request = JSON.toJavaObject(jsonObject, SyncHeatDetailGetAllListRequest.class);
        return thermalcontrolHelper.getSyncHeatDetailAllList(request, passport);
    }

    /**
     * 创建热量同步明细表
     */
    private BaseResponse createSyncHeatDetail(JSONObject jsonObject, Passport passport) {
        SyncHeatDetailCreateRequest request = JSON.toJavaObject(jsonObject, SyncHeatDetailCreateRequest.class);
        return thermalcontrolHelper.createSyncHeatDetail(request, passport);
    }

    /**
     * 更新热量同步明细表
     */
    private BaseResponse updateSyncHeatDetail(JSONObject jsonObject, Passport passport) {
        SyncHeatDetailUpdateRequest request = JSON.toJavaObject(jsonObject, SyncHeatDetailUpdateRequest.class);
        return thermalcontrolHelper.updateSyncHeatDetail(request, passport);
    }

    /**
     * 删除热量同步明细表
     */
    private BaseResponse deleteSyncHeatDetail(JSONObject jsonObject, Passport passport) {
        SyncHeatDetailDeleteRequest request = JSON.toJavaObject(jsonObject, SyncHeatDetailDeleteRequest.class);
        return thermalcontrolHelper.deleteSyncHeatDetail(request, passport);
    }

    /**
     * 根据Id获取热量同步表
     */
    private BaseResponse getSyncHeat(JSONObject jsonObject, Passport passport) {
        SyncHeatGetRequest request = JSON.toJavaObject(jsonObject, SyncHeatGetRequest.class);
        return thermalcontrolHelper.getSyncHeat(request, passport);
    }

    /**
     * 模糊查询热量同步表
     */
    private BaseResponse searchSyncHeat(JSONObject jsonObject, Passport passport) {
        SyncHeatSearchRequest request = JSON.toJavaObject(jsonObject, SyncHeatSearchRequest.class);
        return thermalcontrolHelper.searchSyncHeat(request, passport);
    }

    /**
     * 高级查询热量同步表
     */
    private BaseResponse findSyncHeat(JSONObject jsonObject, Passport passport) {
        SyncHeatFindRequest request = JSON.toJavaObject(jsonObject, SyncHeatFindRequest.class);
        return thermalcontrolHelper.findSyncHeat(request, passport);
    }

    /**
     * 获取所有热量同步表列表
     */
    private BaseResponse getSyncHeatAllList(JSONObject jsonObject, Passport passport) {
        SyncHeatGetAllListRequest request = JSON.toJavaObject(jsonObject, SyncHeatGetAllListRequest.class);
        return thermalcontrolHelper.getSyncHeatAllList(request, passport);
    }

    /**
     * 创建热量同步表
     */
    private BaseResponse createSyncHeat(JSONObject jsonObject, Passport passport) {
        SyncHeatCreateRequest request = JSON.toJavaObject(jsonObject, SyncHeatCreateRequest.class);
        return thermalcontrolHelper.createSyncHeat(request, passport);
    }

    /**
     * 更新热量同步表
     */
    private BaseResponse updateSyncHeat(JSONObject jsonObject, Passport passport) {
        SyncHeatUpdateRequest request = JSON.toJavaObject(jsonObject, SyncHeatUpdateRequest.class);
        return thermalcontrolHelper.updateSyncHeat(request, passport);
    }

    /**
     * 删除热量同步表
     */
    private BaseResponse deleteSyncHeat(JSONObject jsonObject, Passport passport) {
        SyncHeatDeleteRequest request = JSON.toJavaObject(jsonObject, SyncHeatDeleteRequest.class);
        return thermalcontrolHelper.deleteSyncHeat(request, passport);
    }

    /**
     * 根据Id获取运动同步表)
     */
    private BaseResponse getSyncSport(JSONObject jsonObject, Passport passport) {
        SyncSportGetRequest request = JSON.toJavaObject(jsonObject, SyncSportGetRequest.class);
        return thermalcontrolHelper.getSyncSport(request, passport);
    }

    /**
     * 模糊查询运动同步表)
     */
    private BaseResponse searchSyncSport(JSONObject jsonObject, Passport passport) {
        SyncSportSearchRequest request = JSON.toJavaObject(jsonObject, SyncSportSearchRequest.class);
        return thermalcontrolHelper.searchSyncSport(request, passport);
    }

    /**
     * 高级查询运动同步表)
     */
    private BaseResponse findSyncSport(JSONObject jsonObject, Passport passport) {
        SyncSportFindRequest request = JSON.toJavaObject(jsonObject, SyncSportFindRequest.class);
        return thermalcontrolHelper.findSyncSport(request, passport);
    }

    /**
     * 获取所有运动同步表)列表
     */
    private BaseResponse getSyncSportAllList(JSONObject jsonObject, Passport passport) {
        SyncSportGetAllListRequest request = JSON.toJavaObject(jsonObject, SyncSportGetAllListRequest.class);
        return thermalcontrolHelper.getSyncSportAllList(request, passport);
    }

    /**
     * 创建运动同步表)
     */
    private BaseResponse createSyncSport(JSONObject jsonObject, Passport passport) {
        SyncSportCreateRequest request = JSON.toJavaObject(jsonObject, SyncSportCreateRequest.class);
        return thermalcontrolHelper.createSyncSport(request, passport);
    }

    /**
     * 更新运动同步表)
     */
    private BaseResponse updateSyncSport(JSONObject jsonObject, Passport passport) {
        SyncSportUpdateRequest request = JSON.toJavaObject(jsonObject, SyncSportUpdateRequest.class);
        return thermalcontrolHelper.updateSyncSport(request, passport);
    }

    /**
     * 删除运动同步表)
     */
    private BaseResponse deleteSyncSport(JSONObject jsonObject, Passport passport) {
        SyncSportDeleteRequest request = JSON.toJavaObject(jsonObject, SyncSportDeleteRequest.class);
        return thermalcontrolHelper.deleteSyncSport(request, passport);
    }

}