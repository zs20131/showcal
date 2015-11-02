/**
 * @(#)MealsManagerImpl.java
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
import com.showcal.thermalcontrol.dal.MealsMapper;
import com.showcal.thermalcontrol.domain.Meals;
import com.showcal.thermalcontrol.domain.MealsImport;
import com.showcal.thermalcontrol.po.MealsPO;
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
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolMealsManager")
public class MealsManagerImpl extends BaseManagerImpl implements MealsManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private MealsMapper mealsMapper;


    /**
     * 根据Id获取餐次
     *
     * @param request  获取餐次请求
     * @param passport 用户护照
     * @return 获取餐次应答
     */
    @Override
    @Transactional(readOnly = true)
    public MealsGetResponse get(MealsGetRequest request, Passport passport) {
//    MealsPO entity = mealsMapper.getById(request.getId(), passport);
        MealsGetResponse response = new MealsGetResponse();
//    if (entity != null) {
//    Meals meals = this.getMapper().map(entity, Meals.class);
//    response.setMeals(meals );
//    }
//    else {
//        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
//    }
        return response;
    }


    /**
     * 模糊查询餐次
     *
     * @param request  模糊查询餐次请求
     * @param passport 用户护照
     * @return 模糊查询餐次应答
     */
    @Override
    @Transactional(readOnly = true)
    public MealsSearchResponse search(MealsSearchRequest request, Passport passport) {
        MealsSearchResponse response = new MealsSearchResponse();
        List<Meals> modelList = new ArrayList<Meals>();
        Long count = mealsMapper.searchCount(request, passport);

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
            List<MealsPO> entityList = mealsMapper.search(request, passport);

            for (MealsPO entity : entityList) {
                Meals meals = this.getMapper().map(entity, Meals.class);
                modelList.add(meals);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询餐次
     *
     * @param request  高级查询餐次请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public MealsFindResponse find(MealsFindRequest request, Passport passport) {
        MealsFindResponse response = new MealsFindResponse();
        List<Meals> modelList = new ArrayList<Meals>();
        Long count = mealsMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<MealsPO> entityList = mealsMapper.find(request, passport);
            for (MealsPO entity : entityList) {
                Meals meals = this.getMapper().map(entity, Meals.class);
                modelList.add(meals);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有餐次列表
     *
     * @param request  获取所有餐次列表请求
     * @param passport 用户护照
     * @return 获取所有餐次列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public MealsGetAllListResponse getAllList(MealsGetAllListRequest request, Passport passport) {
        MealsGetAllListResponse response = new MealsGetAllListResponse();


        List<MealsPO> entityList = mealsMapper.getAllList(request, passport);


        List<Meals> modelList = new ArrayList<Meals>();
        for (MealsPO entity : entityList) {
            Meals meals = this.getMapper().map(entity, Meals.class);
            modelList.add(meals);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建餐次
     *
     * @param request  创建餐次请求
     * @param passport 用户护照
     * @return 创建餐次应答
     */
    @Override
    public MealsCreateResponse create(MealsCreateRequest request, Passport passport) {
        MealsPO entity = this.getMapper().map(request, MealsPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        MealsCreateResponse response = new MealsCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == mealsMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新餐次
     *
     * @param request  更新餐次请求
     * @param passport 用户护照
     * @return 更新餐次应答
     */
    @Override
    public MealsUpdateResponse update(MealsUpdateRequest request, Passport passport) {
        MealsPO entity = this.getMapper().map(request, MealsPO.class);

        MealsUpdateResponse response = new MealsUpdateResponse();
        Long result = mealsMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除餐次
     *
     * @param request  删除餐次请求
     * @param passport 用户护照
     * @return 删除餐次应答
     */
    @Override
    public MealsDeleteResponse delete(MealsDeleteRequest request, Passport passport) {
        MealsDeleteResponse response = new MealsDeleteResponse();
        Long result = mealsMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 导入餐次
     *
     * @param request  导入餐次请求
     * @param passport 用户护照
     * @return 导入餐次应答
     */
    @Override
    public MealsListImportResponse importList(MealsListImportRequest request, Passport passport) {
        DataTable<MealsImport> dataTable = request.getDataTable();

        List<MealsPO> importList = new ArrayList<MealsPO>();            //需要创建的对象的集合

        List<Long> result = new LinkedList<Long>();                    //存储ID的集合
        List<MealsImport> beanList = request.getList();            //取出导入对象的集合
        MealsListImportResponse response = new MealsListImportResponse();//最终的返回结果

    /* 批量获取ID */
        IdsGetRequest idsGetRequest = new IdsGetRequest();
        idsGetRequest.setCount(beanList.size());
        List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

        int index = 0;
        for (MealsImport importBean : beanList) {
            // 设置
            MealsPO entity = this.getMapper().map(importBean, MealsPO.class);


            importList.add(entity);
            result.add(ids.get(index));         //将取到的ID放入返回结果中
            entity.setId(ids.get(index));       //设置ID

            index++;
        }

        if (!dataTable.hasError()) {
            if (importList.size() > 0) {
                mealsMapper.insertBatch(importList, passport);
            }
        } else {
            //response.setDataTable(dataTable);
            response.addErrors(dataTable.getErrorList());
        }

        response.setList(result);
        return response;

    }

    /**
     * 验证对象
     *
     * @param meals    餐次
     * @param passport 用户护照
     */
    private void checkValidate(MealsPO meals, Passport passport, BaseResponse response) {
        // TODO

    }


}
