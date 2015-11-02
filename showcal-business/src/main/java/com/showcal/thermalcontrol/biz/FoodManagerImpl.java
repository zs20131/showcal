/**
 * @(#)FoodManagerImpl.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.thermalcontrol.biz;

import com.showcal.cms.svc.Message;
import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.foundation.service.FoundationService;
import com.showcal.framework.sql.GenerateSql;
import com.showcal.framework.sql.WhereParameter;
import com.showcal.platform.biz.SyncSqlManager;
import com.showcal.platform.request.SyncSqlCreateRequest;
import com.showcal.thermalcontrol.dal.FoodCategoryMapper;
import com.showcal.thermalcontrol.dal.FoodMapper;
import com.showcal.thermalcontrol.domain.Food;
import com.showcal.thermalcontrol.domain.FoodImport;
import com.showcal.thermalcontrol.po.FoodCategoryPO;
import com.showcal.thermalcontrol.po.FoodPO;
import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:57.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolFoodManager")
public class FoodManagerImpl extends BaseManagerImpl implements FoodManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private FoodCategoryMapper foodCategoryMapper;
    @Autowired
    private SyncSqlManager syncSqlManager;

    /**
     * 根据Id获取食物
     *
     * @param request  获取食物请求
     * @param passport 用户护照
     * @return 获取食物应答
     */
    @Override
    @Transactional(readOnly = true)
    public FoodGetResponse get(FoodGetRequest request, Passport passport) {
        FoodPO entity = foodMapper.getById(request.getId(), passport);
        FoodGetResponse response = new FoodGetResponse();
        if (entity != null) {
            Food food = this.getMapper().map(entity, Food.class);
            response.setFood(food);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询食物
     *
     * @param request  模糊查询食物请求
     * @param passport 用户护照
     * @return 模糊查询食物应答
     */
    @Override
    @Transactional(readOnly = true)
    public FoodSearchResponse search(FoodSearchRequest request, Passport passport) {
        FoodSearchResponse response = new FoodSearchResponse();
        List<Food> modelList = new ArrayList<>();
        Long count = foodMapper.searchCount(request, passport);

        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }

            //通过关键字查询出用户集合
            List<FoodPO> entityList = foodMapper.search(request, passport);

            for (FoodPO entity : entityList) {
                Food food = this.getMapper().map(entity, Food.class);
                modelList.add(food);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询食物
     *
     * @param request  高级查询食物请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public FoodFindResponse find(FoodFindRequest request, Passport passport) {
        FoodFindResponse response = new FoodFindResponse();
        List<Food> modelList = new ArrayList<>();
        Long count = foodMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }

            /*Map<Long, String> foodCategoryMap = new HashMap<>();
            FoodCategoryGetAllListRequest foodCategoryGetAllListRequest = new FoodCategoryGetAllListRequest();
            List<FoodCategoryPO> foodCategoryPOList = foodCategoryMapper.getAllList(foodCategoryGetAllListRequest, passport);
            for (FoodCategoryPO foodCategoryPO : foodCategoryPOList) {
                foodCategoryMap.put(foodCategoryPO.getId(), foodCategoryPO.getName().toString());
            }*/

            List<FoodPO> entityList = foodMapper.find(request, passport);
            for (FoodPO entity : entityList) {
                Food food = this.getMapper().map(entity, Food.class);
                /*if (foodCategoryMap.containsKey(food.getFoodCategoryId())) {    // 小类
                    food.setFoodCategoryIdStr(foodCategoryMap.get(food.getFoodCategoryId()));
                }
                if (foodCategoryMap.containsKey(food.getFoodLargeCategory())) { // 大类
                    food.setFoodLargeCategoryStr(foodCategoryMap.get(food.getFoodLargeCategory()));
                }*/
                modelList.add(food);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有食物列表
     *
     * @param request  获取所有食物列表请求
     * @param passport 用户护照
     * @return 获取所有食物列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public FoodGetAllListResponse getAllList(FoodGetAllListRequest request, Passport passport) {
        FoodGetAllListResponse response = new FoodGetAllListResponse();


        List<FoodPO> entityList = foodMapper.getAllList(request, passport);


        List<Food> modelList = new ArrayList<>();
        for (FoodPO entity : entityList) {
            Food food = this.getMapper().map(entity, Food.class);
            modelList.add(food);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建食物
     *
     * @param request  创建食物请求
     * @param passport 用户护照
     * @return 创建食物应答
     */
    @Override
    public FoodCreateResponse create(FoodCreateRequest request, Passport passport) {
        FoodPO entity = this.getMapper().map(request, FoodPO.class);
        FoodCreateResponse response = new FoodCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == foodMapper.insert(entity, passport)) {
            // 获取执行SQL
            String sql = GenerateSql.generateInsertSql("MB_FOOD", entity);
            SyncSqlCreateRequest createRequest = new SyncSqlCreateRequest();
            createRequest.setTable("MB_FOOD");
            createRequest.setDbsqlMysql(sql);
            createRequest.setDbsqlSqllite(sql);
            syncSqlManager.create(createRequest,passport);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新食物
     *
     * @param request  更新食物请求
     * @param passport 用户护照
     * @return 更新食物应答
     */
    @Override
    public FoodUpdateResponse update(FoodUpdateRequest request, Passport passport) {
        FoodPO entity = this.getMapper().map(request, FoodPO.class);

        FoodUpdateResponse response = new FoodUpdateResponse();
        Long result = foodMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        // 做SQL增量
        WhereParameter whereParameter = new WhereParameter();
        whereParameter.setParameter("id",request.getId());
        String sql = GenerateSql.generateUpdateSql("MB_FOOD",entity,whereParameter);
        SyncSqlCreateRequest createRequest = new SyncSqlCreateRequest();
        createRequest.setTable("MB_FOOD");
        createRequest.setDbsqlMysql(sql);
        createRequest.setDbsqlSqllite(sql);
        syncSqlManager.create(createRequest,passport);
        response.setResult(result);
        return response;
    }


    /**
     * 删除食物
     *
     * @param request  删除食物请求
     * @param passport 用户护照
     * @return 删除食物应答
     */
    @Override
    public FoodDeleteResponse delete(FoodDeleteRequest request, Passport passport) {
        FoodDeleteResponse response = new FoodDeleteResponse();
        Long result = foodMapper.delete(request.getId(), passport);
        String sql = GenerateSql.generateDeleteSql("MB_FOOD",request);
        SyncSqlCreateRequest createRequest = new SyncSqlCreateRequest();
        createRequest.setTable("MB_FOOD");
        createRequest.setDbsqlMysql(sql);
        createRequest.setDbsqlSqllite(sql);
        syncSqlManager.create(createRequest,passport);
        response.setResult(result);
        return response;
    }


    /**
     * 作废食物
     *
     * @param request  作废食物请求
     * @param passport 用户护照
     * @return 作废食物应答
     */
    @Override
    public FoodInactiveResponse inactive(FoodInactiveRequest request, Passport passport) {
        FoodInactiveResponse response = new FoodInactiveResponse();
        FoodPO entity = this.getMapper().map(request, FoodPO.class);
        entity.setIsActive(false);
        WhereParameter whereParameter = new WhereParameter();
        whereParameter.setParameter("id",request.getId());
        String sql = GenerateSql.generateUpdateSql("MB_FOOD",entity,whereParameter);
        SyncSqlCreateRequest createRequest = new SyncSqlCreateRequest();
        createRequest.setTable("MB_FOOD");
        createRequest.setDbsqlMysql(sql);
        createRequest.setDbsqlSqllite(sql);
        syncSqlManager.create(createRequest,passport);
        Long result = foodMapper.inactive(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 激活食物
     *
     * @param request  激活食物请求
     * @param passport 用户护照
     * @return 激活食物应答
     */
    @Override
    public FoodActiveResponse active(FoodActiveRequest request, Passport passport) {
        FoodActiveResponse response = new FoodActiveResponse();
        FoodPO entity = this.getMapper().map(request, FoodPO.class);
        entity.setIsActive(true);
        WhereParameter whereParameter = new WhereParameter();
        whereParameter.setParameter("id",request.getId());
        String sql = GenerateSql.generateUpdateSql("MB_FOOD",entity,whereParameter);
        SyncSqlCreateRequest createRequest = new SyncSqlCreateRequest();
        createRequest.setTable("MB_FOOD");
        createRequest.setDbsqlMysql(sql);
        createRequest.setDbsqlSqllite(sql);
        syncSqlManager.create(createRequest,passport);
        Long result = foodMapper.active(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 导入食物
     *
     * @param request  导入食物请求
     * @param passport 用户护照
     * @return 导入食物应答
     */
    @Override
    public FoodListImportResponse importList(FoodListImportRequest request, Passport passport) {
        DataTable<FoodImport> dataTable = request.getDataTable();

        List<FoodPO> importList = new ArrayList<>();            //需要创建的对象的集合

        List<Long> result = new LinkedList<>();                    //存储ID的集合
        List<FoodImport> beanList = request.getList();            //取出导入对象的集合
        FoodListImportResponse response = new FoodListImportResponse();//最终的返回结果

    /* 批量获取ID */
        IdsGetRequest idsGetRequest = new IdsGetRequest();
        idsGetRequest.setCount(beanList.size());
        List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

        int index = 0;
        for (FoodImport importBean : beanList) {
            // 设置
            FoodPO entity = this.getMapper().map(importBean, FoodPO.class);


            importList.add(entity);
            result.add(ids.get(index));         //将取到的ID放入返回结果中
            entity.setId(ids.get(index));       //设置ID
            // 设置激活状态
            entity.setIsActive(true);
            entity.setActiveDate(new Date());
            entity.setActiveUser(passport.getUserId().toString());

            index++;
        }

        if (!dataTable.hasError()) {
            if (importList.size() > 0) {
                foodMapper.insertBatch(importList, passport);
                for(FoodPO foodPO:importList){
                    // 获取执行SQL
                    String sql = GenerateSql.generateInsertSql("MB_FOOD", foodPO);
                    SyncSqlCreateRequest createRequest = new SyncSqlCreateRequest();
                    createRequest.setTable("MB_FOOD");
                    createRequest.setDbsqlMysql(sql);
                    createRequest.setDbsqlSqllite(sql);
                    syncSqlManager.create(createRequest,passport);
                }
            }
        } else {
//            response.setDataTable(dataTable);
            response.addErrors(dataTable.getErrorList());
        }

        response.setList(result);
        return response;

    }

    /**
     * 验证对象
     *
     * @param food     食物
     * @param passport 用户护照
     */
    private void checkValidate(FoodPO food, Passport passport, BaseResponse response) {
        // TODO

    }


}
