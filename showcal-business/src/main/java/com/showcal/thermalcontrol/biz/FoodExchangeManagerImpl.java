/**
 * @(#)FoodExchangeManagerImpl.java
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
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;
import com.showcal.thermalcontrol.domain.*;
import com.showcal.thermalcontrol.dal.FoodExchangeMapper;
import com.showcal.thermalcontrol.po.FoodExchangePO;
import com.showcal.foundation.service.FoundationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:57.
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolFoodExchangeManager")
public class FoodExchangeManagerImpl extends BaseManagerImpl implements FoodExchangeManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private FoodExchangeMapper foodExchangeMapper;


/**
 * 根据Id获取食物交换份
 *
 * @param request 获取食物交换份请求
 * @param passport 用户护照
 * @return 获取食物交换份应答
 */
@Override
@Transactional(readOnly = true)
public FoodExchangeGetResponse get(FoodExchangeGetRequest request, Passport passport)
{
    FoodExchangePO entity = foodExchangeMapper.getById(request.getId(), passport);
    FoodExchangeGetResponse response = new FoodExchangeGetResponse();
    if (entity != null) {
    FoodExchange foodExchange = this.getMapper().map(entity, FoodExchange.class);
    response.setFoodExchange(foodExchange );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询食物交换份
 *
 * @param request 模糊查询食物交换份请求
 * @param passport 用户护照
 * @return 模糊查询食物交换份应答
 */
@Override
@Transactional(readOnly = true)
public FoodExchangeSearchResponse search(FoodExchangeSearchRequest request, Passport passport)
{
    FoodExchangeSearchResponse response = new FoodExchangeSearchResponse();
    List<FoodExchange> modelList = new ArrayList<>();
    Long count = foodExchangeMapper.searchCount(request, passport);

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
        List<FoodExchangePO> entityList = foodExchangeMapper.search(request, passport);

        for (FoodExchangePO entity : entityList) {
        FoodExchange foodExchange = this.getMapper().map(entity, FoodExchange.class);
        modelList.add(foodExchange);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询食物交换份
 *
 * @param request 高级查询食物交换份请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public FoodExchangeFindResponse find(FoodExchangeFindRequest request, Passport passport)
{
    FoodExchangeFindResponse response = new FoodExchangeFindResponse();
    List<FoodExchange> modelList = new ArrayList<>();
    Long count = foodExchangeMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<FoodExchangePO> entityList = foodExchangeMapper.find(request, passport);
        for (FoodExchangePO entity : entityList) {
            FoodExchange foodExchange = this.getMapper().map(entity, FoodExchange.class);
            modelList.add(foodExchange);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有食物交换份列表
 *
 * @param request 获取所有食物交换份列表请求
 * @param passport 用户护照
 * @return 获取所有食物交换份列表应答
 */
@Override
@Transactional(readOnly = true)
public FoodExchangeGetAllListResponse getAllList(FoodExchangeGetAllListRequest request, Passport passport)
{
    FoodExchangeGetAllListResponse response = new FoodExchangeGetAllListResponse();


    List<FoodExchangePO> entityList = foodExchangeMapper.getAllList(request, passport);


    List<FoodExchange> modelList = new ArrayList<>();
    for (FoodExchangePO entity : entityList) {
    FoodExchange foodExchange = this.getMapper().map(entity, FoodExchange.class);
    modelList.add(foodExchange);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建食物交换份
 *
 * @param request 创建食物交换份请求
 * @param passport 用户护照
 * @return 创建食物交换份应答
 */
@Override
public FoodExchangeCreateResponse create(FoodExchangeCreateRequest request, Passport passport)
{
    FoodExchangePO entity = this.getMapper().map(request, FoodExchangePO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    FoodExchangeCreateResponse response = new FoodExchangeCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == foodExchangeMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新食物交换份
 *
 * @param request 更新食物交换份请求
 * @param passport 用户护照
 * @return 更新食物交换份应答
 */
@Override
public FoodExchangeUpdateResponse update(FoodExchangeUpdateRequest request, Passport passport)
{
    FoodExchangePO entity = this.getMapper().map(request, FoodExchangePO.class);

    FoodExchangeUpdateResponse response = new FoodExchangeUpdateResponse();
    Long result=foodExchangeMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除食物交换份
 *
 * @param request 删除食物交换份请求
 * @param passport 用户护照
 * @return 删除食物交换份应答
 */
@Override
public FoodExchangeDeleteResponse delete(FoodExchangeDeleteRequest request, Passport passport)
{
 FoodExchangeDeleteResponse response = new FoodExchangeDeleteResponse();
     Long result= foodExchangeMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}


/**
 * 作废食物交换份
 *
 * @param request 作废食物交换份请求
 * @param passport 用户护照
 * @return 作废食物交换份应答
 */
@Override
public FoodExchangeInactiveResponse inactive(FoodExchangeInactiveRequest request, Passport passport)
{
 FoodExchangeInactiveResponse response = new FoodExchangeInactiveResponse();
    Long result= foodExchangeMapper.inactive(request.getId(), passport);
    response.setResult(result);
    return response;
}


/**
 * 激活食物交换份
 *
 * @param request 激活食物交换份请求
 * @param passport 用户护照
 * @return 激活食物交换份应答
 */
@Override
public FoodExchangeActiveResponse active(FoodExchangeActiveRequest request, Passport passport)
{
 FoodExchangeActiveResponse response = new FoodExchangeActiveResponse();
    Long result= foodExchangeMapper.active(request.getId(), passport);
    response.setResult(result);
    return response;
}



/**
 * 导入食物交换份
 *
 * @param request 导入食物交换份请求
 * @param passport 用户护照
 * @return 导入食物交换份应答
 */
@Override
public FoodExchangeListImportResponse importList(FoodExchangeListImportRequest request, Passport passport)
{
    DataTable<FoodExchangeImport> dataTable = request.getDataTable();

    List<FoodExchangePO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<FoodExchangeImport> beanList = request.getList();            //取出导入对象的集合
    FoodExchangeListImportResponse response = new FoodExchangeListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (FoodExchangeImport importBean : beanList) {
        // 设置
        FoodExchangePO entity = this.getMapper().map(importBean, FoodExchangePO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            foodExchangeMapper.insertBatch(importList, passport);
        }
    }
    else {
        response.setDataTable(dataTable);
        response.addErrors(dataTable.getErrorList());
    }

    response.setList(result);
    return response;

}

    /**
     * 验证对象
     * @param foodExchange 食物交换份
     * @param passport 用户护照
     */
    private void checkValidate(FoodExchangePO foodExchange, Passport passport, BaseResponse response) {
        // TODO

    }


}
