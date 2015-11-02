/**
 * @(#)GradeWeightManagerImpl.java
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
import com.showcal.thermalcontrol.dal.GradeWeightMapper;
import com.showcal.thermalcontrol.po.GradeWeightPO;
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
@Service("ThermalcontrolGradeWeightManager")
public class GradeWeightManagerImpl extends BaseManagerImpl implements GradeWeightManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private GradeWeightMapper gradeWeightMapper;


/**
 * 根据Id获取打分权重表
 *
 * @param request 获取打分权重表请求
 * @param passport 用户护照
 * @return 获取打分权重表应答
 */
@Override
@Transactional(readOnly = true)
public GradeWeightGetResponse get(GradeWeightGetRequest request, Passport passport)
{
    GradeWeightPO entity = gradeWeightMapper.getById(request.getId(), passport);
    GradeWeightGetResponse response = new GradeWeightGetResponse();
    if (entity != null) {
    GradeWeight gradeWeight = this.getMapper().map(entity, GradeWeight.class);
    response.setGradeWeight(gradeWeight );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询打分权重表
 *
 * @param request 模糊查询打分权重表请求
 * @param passport 用户护照
 * @return 模糊查询打分权重表应答
 */
@Override
@Transactional(readOnly = true)
public GradeWeightSearchResponse search(GradeWeightSearchRequest request, Passport passport)
{
    GradeWeightSearchResponse response = new GradeWeightSearchResponse();
    List<GradeWeight> modelList = new ArrayList<>();
    Long count = gradeWeightMapper.searchCount(request, passport);

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
        List<GradeWeightPO> entityList = gradeWeightMapper.search(request, passport);

        for (GradeWeightPO entity : entityList) {
        GradeWeight gradeWeight = this.getMapper().map(entity, GradeWeight.class);
        modelList.add(gradeWeight);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询打分权重表
 *
 * @param request 高级查询打分权重表请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public GradeWeightFindResponse find(GradeWeightFindRequest request, Passport passport)
{
    GradeWeightFindResponse response = new GradeWeightFindResponse();
    List<GradeWeight> modelList = new ArrayList<>();
    Long count = gradeWeightMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<GradeWeightPO> entityList = gradeWeightMapper.find(request, passport);
        for (GradeWeightPO entity : entityList) {
            GradeWeight gradeWeight = this.getMapper().map(entity, GradeWeight.class);
            modelList.add(gradeWeight);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有打分权重表列表
 *
 * @param request 获取所有打分权重表列表请求
 * @param passport 用户护照
 * @return 获取所有打分权重表列表应答
 */
@Override
@Transactional(readOnly = true)
public GradeWeightGetAllListResponse getAllList(GradeWeightGetAllListRequest request, Passport passport)
{
    GradeWeightGetAllListResponse response = new GradeWeightGetAllListResponse();


    List<GradeWeightPO> entityList = gradeWeightMapper.getAllList(request, passport);


    List<GradeWeight> modelList = new ArrayList<>();
    for (GradeWeightPO entity : entityList) {
    GradeWeight gradeWeight = this.getMapper().map(entity, GradeWeight.class);
    modelList.add(gradeWeight);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建打分权重表
 *
 * @param request 创建打分权重表请求
 * @param passport 用户护照
 * @return 创建打分权重表应答
 */
@Override
public GradeWeightCreateResponse create(GradeWeightCreateRequest request, Passport passport)
{
    GradeWeightPO entity = this.getMapper().map(request, GradeWeightPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    GradeWeightCreateResponse response = new GradeWeightCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == gradeWeightMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新打分权重表
 *
 * @param request 更新打分权重表请求
 * @param passport 用户护照
 * @return 更新打分权重表应答
 */
@Override
public GradeWeightUpdateResponse update(GradeWeightUpdateRequest request, Passport passport)
{
    GradeWeightPO entity = this.getMapper().map(request, GradeWeightPO.class);

    GradeWeightUpdateResponse response = new GradeWeightUpdateResponse();
    Long result=gradeWeightMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除打分权重表
 *
 * @param request 删除打分权重表请求
 * @param passport 用户护照
 * @return 删除打分权重表应答
 */
@Override
public GradeWeightDeleteResponse delete(GradeWeightDeleteRequest request, Passport passport)
{
 GradeWeightDeleteResponse response = new GradeWeightDeleteResponse();
     Long result= gradeWeightMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




/**
 * 导入打分权重表
 *
 * @param request 导入打分权重表请求
 * @param passport 用户护照
 * @return 导入打分权重表应答
 */
@Override
public GradeWeightListImportResponse importList(GradeWeightListImportRequest request, Passport passport)
{
    DataTable<GradeWeightImport> dataTable = request.getDataTable();

    List<GradeWeightPO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<GradeWeightImport> beanList = request.getList();            //取出导入对象的集合
    GradeWeightListImportResponse response = new GradeWeightListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (GradeWeightImport importBean : beanList) {
        // 设置
        GradeWeightPO entity = this.getMapper().map(importBean, GradeWeightPO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            gradeWeightMapper.insertBatch(importList, passport);
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
     * @param gradeWeight 打分权重表
     * @param passport 用户护照
     */
    private void checkValidate(GradeWeightPO gradeWeight, Passport passport, BaseResponse response) {
        // TODO

    }


}
