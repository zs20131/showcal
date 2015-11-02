/**
 * @(#)EvaluateManagerImpl.java
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
import com.showcal.thermalcontrol.dal.EvaluateMapper;
import com.showcal.thermalcontrol.po.EvaluatePO;
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
@Service("ThermalcontrolEvaluateManager")
public class EvaluateManagerImpl extends BaseManagerImpl implements EvaluateManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private EvaluateMapper evaluateMapper;


/**
 * 根据Id获取评价基础
 *
 * @param request 获取评价基础请求
 * @param passport 用户护照
 * @return 获取评价基础应答
 */
@Override
@Transactional(readOnly = true)
public EvaluateGetResponse get(EvaluateGetRequest request, Passport passport)
{
    EvaluatePO entity = evaluateMapper.getById(request.getId(), passport);
    EvaluateGetResponse response = new EvaluateGetResponse();
    if (entity != null) {
    Evaluate evaluate = this.getMapper().map(entity, Evaluate.class);
    response.setEvaluate(evaluate );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询评价基础
 *
 * @param request 模糊查询评价基础请求
 * @param passport 用户护照
 * @return 模糊查询评价基础应答
 */
@Override
@Transactional(readOnly = true)
public EvaluateSearchResponse search(EvaluateSearchRequest request, Passport passport)
{
    EvaluateSearchResponse response = new EvaluateSearchResponse();
    List<Evaluate> modelList = new ArrayList<>();
    Long count = evaluateMapper.searchCount(request, passport);

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
        List<EvaluatePO> entityList = evaluateMapper.search(request, passport);

        for (EvaluatePO entity : entityList) {
        Evaluate evaluate = this.getMapper().map(entity, Evaluate.class);
        modelList.add(evaluate);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询评价基础
 *
 * @param request 高级查询评价基础请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public EvaluateFindResponse     find(EvaluateFindRequest request, Passport passport)
{
    EvaluateFindResponse response = new EvaluateFindResponse();
    List<Evaluate> modelList = new ArrayList<>();
    Long count = evaluateMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<EvaluatePO> entityList = evaluateMapper.find(request, passport);
        for (EvaluatePO entity : entityList) {
            Evaluate evaluate = this.getMapper().map(entity, Evaluate.class);
            modelList.add(evaluate);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有评价基础列表
 *
 * @param request 获取所有评价基础列表请求
 * @param passport 用户护照
 * @return 获取所有评价基础列表应答
 */
@Override
@Transactional(readOnly = true)
public EvaluateGetAllListResponse getAllList(EvaluateGetAllListRequest request, Passport passport)
{
    EvaluateGetAllListResponse response = new EvaluateGetAllListResponse();


    List<EvaluatePO> entityList = evaluateMapper.getAllList(request, passport);


    List<Evaluate> modelList = new ArrayList<>();
    for (EvaluatePO entity : entityList) {
    Evaluate evaluate = this.getMapper().map(entity, Evaluate.class);
    modelList.add(evaluate);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建评价基础
 *
 * @param request 创建评价基础请求
 * @param passport 用户护照
 * @return 创建评价基础应答
 */
@Override
public EvaluateCreateResponse create(EvaluateCreateRequest request, Passport passport)
{
    EvaluatePO entity = this.getMapper().map(request, EvaluatePO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    EvaluateCreateResponse response = new EvaluateCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == evaluateMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新评价基础
 *
 * @param request 更新评价基础请求
 * @param passport 用户护照
 * @return 更新评价基础应答
 */
@Override
public EvaluateUpdateResponse update(EvaluateUpdateRequest request, Passport passport)
{
    EvaluatePO entity = this.getMapper().map(request, EvaluatePO.class);

    EvaluateUpdateResponse response = new EvaluateUpdateResponse();
    Long result=evaluateMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除评价基础
 *
 * @param request 删除评价基础请求
 * @param passport 用户护照
 * @return 删除评价基础应答
 */
@Override
public EvaluateDeleteResponse delete(EvaluateDeleteRequest request, Passport passport)
{
 EvaluateDeleteResponse response = new EvaluateDeleteResponse();
     Long result= evaluateMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




/**
 * 导入评价基础
 *
 * @param request 导入评价基础请求
 * @param passport 用户护照
 * @return 导入评价基础应答
 */
@Override
public EvaluateListImportResponse importList(EvaluateListImportRequest request, Passport passport)
{
    DataTable<EvaluateImport> dataTable = request.getDataTable();

    List<EvaluatePO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<EvaluateImport> beanList = request.getList();            //取出导入对象的集合
    EvaluateListImportResponse response = new EvaluateListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (EvaluateImport importBean : beanList) {
        // 设置
        EvaluatePO entity = this.getMapper().map(importBean, EvaluatePO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            evaluateMapper.insertBatch(importList, passport);
        }
    }
    else {
      //  response.setDataTable(dataTable);
        response.addErrors(dataTable.getErrorList());
    }

    response.setList(result);
    return response;

}

    /**
     * 验证对象
     * @param evaluate 评价基础
     * @param passport 用户护照
     */
    private void checkValidate(EvaluatePO evaluate, Passport passport, BaseResponse response) {
        // TODO

    }


}
