/**
 * @(#)BmiFoodManagerImpl.java
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
import com.showcal.thermalcontrol.dal.BmiFoodMapper;
import com.showcal.thermalcontrol.po.BmiFoodPO;
import com.showcal.foundation.service.FoundationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:56.
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolBmiFoodManager")
public class BmiFoodManagerImpl extends BaseManagerImpl implements BmiFoodManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private BmiFoodMapper bmiFoodMapper;


/**
 * 根据Id获取BMI食物总重量
 *
 * @param request 获取BMI食物总重量请求
 * @param passport 用户护照
 * @return 获取BMI食物总重量应答
 */
@Override
@Transactional(readOnly = true)
public BmiFoodGetResponse get(BmiFoodGetRequest request, Passport passport)
{
    BmiFoodPO entity = bmiFoodMapper.getById(request.getId(), passport);
    BmiFoodGetResponse response = new BmiFoodGetResponse();
    if (entity != null) {
    BmiFood bmiFood = this.getMapper().map(entity, BmiFood.class);
    response.setBmiFood(bmiFood );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询BMI食物总重量
 *
 * @param request 模糊查询BMI食物总重量请求
 * @param passport 用户护照
 * @return 模糊查询BMI食物总重量应答
 */
@Override
@Transactional(readOnly = true)
public BmiFoodSearchResponse search(BmiFoodSearchRequest request, Passport passport)
{
    BmiFoodSearchResponse response = new BmiFoodSearchResponse();
    List<BmiFood> modelList = new ArrayList<>();
    Long count = bmiFoodMapper.searchCount(request, passport);

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
        List<BmiFoodPO> entityList = bmiFoodMapper.search(request, passport);

        for (BmiFoodPO entity : entityList) {
        BmiFood bmiFood = this.getMapper().map(entity, BmiFood.class);
        modelList.add(bmiFood);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询BMI食物总重量
 *
 * @param request 高级查询BMI食物总重量请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public BmiFoodFindResponse find(BmiFoodFindRequest request, Passport passport)
{
    BmiFoodFindResponse response = new BmiFoodFindResponse();
    List<BmiFood> modelList = new ArrayList<>();
    Long count = bmiFoodMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<BmiFoodPO> entityList = bmiFoodMapper.find(request, passport);
        for (BmiFoodPO entity : entityList) {
            BmiFood bmiFood = this.getMapper().map(entity, BmiFood.class);
            modelList.add(bmiFood);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有BMI食物总重量列表
 *
 * @param request 获取所有BMI食物总重量列表请求
 * @param passport 用户护照
 * @return 获取所有BMI食物总重量列表应答
 */
@Override
@Transactional(readOnly = true)
public BmiFoodGetAllListResponse getAllList(BmiFoodGetAllListRequest request, Passport passport)
{
    BmiFoodGetAllListResponse response = new BmiFoodGetAllListResponse();


    List<BmiFoodPO> entityList = bmiFoodMapper.getAllList(request, passport);


    List<BmiFood> modelList = new ArrayList<>();
    for (BmiFoodPO entity : entityList) {
    BmiFood bmiFood = this.getMapper().map(entity, BmiFood.class);
    modelList.add(bmiFood);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建BMI食物总重量
 *
 * @param request 创建BMI食物总重量请求
 * @param passport 用户护照
 * @return 创建BMI食物总重量应答
 */
@Override
public BmiFoodCreateResponse create(BmiFoodCreateRequest request, Passport passport)
{
    BmiFoodPO entity = this.getMapper().map(request, BmiFoodPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    BmiFoodCreateResponse response = new BmiFoodCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == bmiFoodMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新BMI食物总重量
 *
 * @param request 更新BMI食物总重量请求
 * @param passport 用户护照
 * @return 更新BMI食物总重量应答
 */
@Override
public BmiFoodUpdateResponse update(BmiFoodUpdateRequest request, Passport passport)
{
    BmiFoodPO entity = this.getMapper().map(request, BmiFoodPO.class);

    BmiFoodUpdateResponse response = new BmiFoodUpdateResponse();
    Long result=bmiFoodMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除BMI食物总重量
 *
 * @param request 删除BMI食物总重量请求
 * @param passport 用户护照
 * @return 删除BMI食物总重量应答
 */
@Override
public BmiFoodDeleteResponse delete(BmiFoodDeleteRequest request, Passport passport)
{
 BmiFoodDeleteResponse response = new BmiFoodDeleteResponse();
     Long result= bmiFoodMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}


/**
 * 作废BMI食物总重量
 *
 * @param request 作废BMI食物总重量请求
 * @param passport 用户护照
 * @return 作废BMI食物总重量应答
 */
@Override
public BmiFoodInactiveResponse inactive(BmiFoodInactiveRequest request, Passport passport)
{
 BmiFoodInactiveResponse response = new BmiFoodInactiveResponse();
    Long result= bmiFoodMapper.inactive(request.getId(), passport);
    response.setResult(result);
    return response;
}


/**
 * 激活BMI食物总重量
 *
 * @param request 激活BMI食物总重量请求
 * @param passport 用户护照
 * @return 激活BMI食物总重量应答
 */
@Override
public BmiFoodActiveResponse active(BmiFoodActiveRequest request, Passport passport)
{
 BmiFoodActiveResponse response = new BmiFoodActiveResponse();
    Long result= bmiFoodMapper.active(request.getId(), passport);
    response.setResult(result);
    return response;
}



/**
 * 导入BMI食物总重量
 *
 * @param request 导入BMI食物总重量请求
 * @param passport 用户护照
 * @return 导入BMI食物总重量应答
 */
@Override
public BmiFoodListImportResponse importList(BmiFoodListImportRequest request, Passport passport)
{
    DataTable<BmiFoodImport> dataTable = request.getDataTable();

    List<BmiFoodPO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<BmiFoodImport> beanList = request.getList();            //取出导入对象的集合
    BmiFoodListImportResponse response = new BmiFoodListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (BmiFoodImport importBean : beanList) {
        // 设置
        BmiFoodPO entity = this.getMapper().map(importBean, BmiFoodPO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            bmiFoodMapper.insertBatch(importList, passport);
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
     * @param bmiFood BMI食物总重量
     * @param passport 用户护照
     */
    private void checkValidate(BmiFoodPO bmiFood, Passport passport, BaseResponse response) {
        // TODO

    }


}
