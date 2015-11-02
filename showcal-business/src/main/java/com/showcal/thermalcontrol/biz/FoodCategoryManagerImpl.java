/**
 * @(#)FoodCategoryManagerImpl.java
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
import com.showcal.thermalcontrol.domain.FoodCategory;
import com.showcal.thermalcontrol.domain.FoodCategoryImport;
import com.showcal.thermalcontrol.po.FoodCategoryPO;
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:57.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolFoodCategoryManager")
public class FoodCategoryManagerImpl extends BaseManagerImpl implements FoodCategoryManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private FoodCategoryMapper foodCategoryMapper;
    @Autowired
    private SyncSqlManager syncSqlManager;

    /**
     * 根据Id获取食物类别
     *
     * @param request  获取食物类别请求
     * @param passport 用户护照
     * @return 获取食物类别应答
     */
    @Override
    @Transactional(readOnly = true)
    public FoodCategoryGetResponse get(FoodCategoryGetRequest request, Passport passport) {
        FoodCategoryPO entity = foodCategoryMapper.getById(request.getId(), passport);
        FoodCategoryGetResponse response = new FoodCategoryGetResponse();
        if (entity != null) {
            FoodCategory foodCategory = this.getMapper().map(entity, FoodCategory.class);
            response.setFoodCategory(foodCategory);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询食物类别
     *
     * @param request  模糊查询食物类别请求
     * @param passport 用户护照
     * @return 模糊查询食物类别应答
     */
    @Override
    @Transactional(readOnly = true)
    public FoodCategorySearchResponse search(FoodCategorySearchRequest request, Passport passport) {
        FoodCategorySearchResponse response = new FoodCategorySearchResponse();
        List<FoodCategory> modelList = new ArrayList<>();
        Long count = foodCategoryMapper.searchCount(request, passport);

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
            List<FoodCategoryPO> entityList = foodCategoryMapper.search(request, passport);

            for (FoodCategoryPO entity : entityList) {
                FoodCategory foodCategory = this.getMapper().map(entity, FoodCategory.class);
                modelList.add(foodCategory);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询食物类别
     *
     * @param request  高级查询食物类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public FoodCategoryFindResponse find(FoodCategoryFindRequest request, Passport passport) {
        FoodCategoryFindResponse response = new FoodCategoryFindResponse();
        List<FoodCategory> modelList = new ArrayList<>();
        Long count = foodCategoryMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<FoodCategoryPO> entityList = foodCategoryMapper.find(request, passport);
            for (FoodCategoryPO entity : entityList) {
                FoodCategory foodCategory = this.getMapper().map(entity, FoodCategory.class);
                modelList.add(foodCategory);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有食物类别列表
     *
     * @param request  获取所有食物类别列表请求
     * @param passport 用户护照
     * @return 获取所有食物类别列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public FoodCategoryGetAllListResponse getAllList(FoodCategoryGetAllListRequest request, Passport passport) {
        FoodCategoryGetAllListResponse response = new FoodCategoryGetAllListResponse();


        List<FoodCategoryPO> entityList = foodCategoryMapper.getAllList(request, passport);


        List<FoodCategory> modelList = new ArrayList<>();
        for (FoodCategoryPO entity : entityList) {
            FoodCategory foodCategory = this.getMapper().map(entity, FoodCategory.class);
            modelList.add(foodCategory);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建食物类别
     *
     * @param request  创建食物类别请求
     * @param passport 用户护照
     * @return 创建食物类别应答
     */
    @Override
    public FoodCategoryCreateResponse create(FoodCategoryCreateRequest request, Passport passport) {
        FoodCategoryPO entity = this.getMapper().map(request, FoodCategoryPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        FoodCategoryCreateResponse response = new FoodCategoryCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == foodCategoryMapper.insert(entity, passport)) {
            response.setId(id);
            String sql = GenerateSql.generateInsertSql("MB_FOOD_CATEGORY", entity);
            SyncSqlCreateRequest createRequest = new SyncSqlCreateRequest();
            createRequest.setTable("MB_FOOD_CATEGORY");
            createRequest.setDbsqlMysql(sql);
            createRequest.setDbsqlSqllite(sql);
            syncSqlManager.create(createRequest, passport);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新食物类别
     *
     * @param request  更新食物类别请求
     * @param passport 用户护照
     * @return 更新食物类别应答
     */
    @Override
    public FoodCategoryUpdateResponse update(FoodCategoryUpdateRequest request, Passport passport) {
        FoodCategoryPO entity = this.getMapper().map(request, FoodCategoryPO.class);

        FoodCategoryUpdateResponse response = new FoodCategoryUpdateResponse();
        Long result = foodCategoryMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        // 做SQL增量
        WhereParameter whereParameter = new WhereParameter();
        whereParameter.setParameter("id", request.getId());
        String sql = GenerateSql.generateUpdateSql("MB_FOOD_CATEGORY", entity, whereParameter);
        SyncSqlCreateRequest createRequest = new SyncSqlCreateRequest();
        createRequest.setTable("MB_FOOD_CATEGORY");
        createRequest.setDbsqlMysql(sql);
        createRequest.setDbsqlSqllite(sql);
        syncSqlManager.create(createRequest, passport);
        response.setResult(result);
        return response;
    }


    /**
     * 删除食物类别
     *
     * @param request  删除食物类别请求
     * @param passport 用户护照
     * @return 删除食物类别应答
     */
    @Override
    public FoodCategoryDeleteResponse delete(FoodCategoryDeleteRequest request, Passport passport) {
        FoodCategoryDeleteResponse response = new FoodCategoryDeleteResponse();
        Long result = foodCategoryMapper.delete(request.getId(), passport);
        String sql = GenerateSql.generateDeleteSql("MB_FOOD_CATEGORY", request);
        SyncSqlCreateRequest createRequest = new SyncSqlCreateRequest();
        createRequest.setTable("MB_FOOD_CATEGORY");
        createRequest.setDbsqlMysql(sql);
        createRequest.setDbsqlSqllite(sql);
        syncSqlManager.create(createRequest, passport);
        response.setResult(result);
        return response;
    }


    /**
     * 导入食物类别
     *
     * @param request  导入食物类别请求
     * @param passport 用户护照
     * @return 导入食物类别应答
     */
    @Override
    public FoodCategoryListImportResponse importList(FoodCategoryListImportRequest request, Passport passport) {
        DataTable<FoodCategoryImport> dataTable = request.getDataTable();

        List<FoodCategoryPO> importList = new ArrayList<>();            //需要创建的对象的集合

        List<Long> result = new LinkedList<>();                    //存储ID的集合
        List<FoodCategoryImport> beanList = request.getList();            //取出导入对象的集合
        FoodCategoryListImportResponse response = new FoodCategoryListImportResponse();//最终的返回结果

    /* 批量获取ID */
        IdsGetRequest idsGetRequest = new IdsGetRequest();
        idsGetRequest.setCount(beanList.size());
        List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

        int index = 0;
        for (FoodCategoryImport importBean : beanList) {
            // 设置
            FoodCategoryPO entity = this.getMapper().map(importBean, FoodCategoryPO.class);


            importList.add(entity);
            result.add(ids.get(index));         //将取到的ID放入返回结果中
            entity.setId(ids.get(index));       //设置ID

            index++;
        }

        if (!dataTable.hasError()) {
            if (importList.size() > 0) {
                foodCategoryMapper.insertBatch(importList, passport);
            }
        } else {
            response.setDataTable(dataTable);
            response.addErrors(dataTable.getErrorList());
        }

        response.setList(result);
        return response;

    }

    /**
     * 验证对象
     *
     * @param foodCategory 食物类别
     * @param passport     用户护照
     */
    private void checkValidate(FoodCategoryPO foodCategory, Passport passport, BaseResponse response) {
        // TODO

    }


}
