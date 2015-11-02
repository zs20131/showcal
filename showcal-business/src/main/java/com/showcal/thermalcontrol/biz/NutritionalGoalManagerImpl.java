/**
 * @(#)NutritionalGoalManagerImpl.java
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
import com.showcal.thermalcontrol.dal.NutritionalGoalMapper;
import com.showcal.thermalcontrol.po.NutritionalGoalPO;
import com.showcal.foundation.service.FoundationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolNutritionalGoalManager")
public class NutritionalGoalManagerImpl extends BaseManagerImpl implements NutritionalGoalManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private NutritionalGoalMapper nutritionalGoalMapper;


/**
 * 根据Id获取营养目标
 *
 * @param request 获取营养目标请求
 * @param passport 用户护照
 * @return 获取营养目标应答
 */
@Override
@Transactional(readOnly = true)
public NutritionalGoalGetResponse get(NutritionalGoalGetRequest request, Passport passport)
{
    NutritionalGoalPO entity = nutritionalGoalMapper.getById(request.getId(), passport);
    NutritionalGoalGetResponse response = new NutritionalGoalGetResponse();
    if (entity != null) {
    NutritionalGoal nutritionalGoal = this.getMapper().map(entity, NutritionalGoal.class);
    response.setNutritionalGoal(nutritionalGoal );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询营养目标
 *
 * @param request 模糊查询营养目标请求
 * @param passport 用户护照
 * @return 模糊查询营养目标应答
 */
@Override
@Transactional(readOnly = true)
public NutritionalGoalSearchResponse search(NutritionalGoalSearchRequest request, Passport passport)
{
    NutritionalGoalSearchResponse response = new NutritionalGoalSearchResponse();
    List<NutritionalGoal> modelList = new ArrayList<>();
    Long count = nutritionalGoalMapper.searchCount(request, passport);

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
        List<NutritionalGoalPO> entityList = nutritionalGoalMapper.search(request, passport);

        for (NutritionalGoalPO entity : entityList) {
        NutritionalGoal nutritionalGoal = this.getMapper().map(entity, NutritionalGoal.class);
        modelList.add(nutritionalGoal);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询营养目标
 *
 * @param request 高级查询营养目标请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public NutritionalGoalFindResponse find(NutritionalGoalFindRequest request, Passport passport)
{
    NutritionalGoalFindResponse response = new NutritionalGoalFindResponse();
    List<NutritionalGoal> modelList = new ArrayList<>();
    Long count = nutritionalGoalMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<NutritionalGoalPO> entityList = nutritionalGoalMapper.find(request, passport);
        for (NutritionalGoalPO entity : entityList) {
            NutritionalGoal nutritionalGoal = this.getMapper().map(entity, NutritionalGoal.class);
            modelList.add(nutritionalGoal);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有营养目标列表
 *
 * @param request 获取所有营养目标列表请求
 * @param passport 用户护照
 * @return 获取所有营养目标列表应答
 */
@Override
@Transactional(readOnly = true)
public NutritionalGoalGetAllListResponse getAllList(NutritionalGoalGetAllListRequest request, Passport passport)
{
    NutritionalGoalGetAllListResponse response = new NutritionalGoalGetAllListResponse();


    List<NutritionalGoalPO> entityList = nutritionalGoalMapper.getAllList(request, passport);


    List<NutritionalGoal> modelList = new ArrayList<>();
    for (NutritionalGoalPO entity : entityList) {
    NutritionalGoal nutritionalGoal = this.getMapper().map(entity, NutritionalGoal.class);
    modelList.add(nutritionalGoal);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建营养目标
 *
 * @param request 创建营养目标请求
 * @param passport 用户护照
 * @return 创建营养目标应答
 */
@Override
public NutritionalGoalCreateResponse create(NutritionalGoalCreateRequest request, Passport passport)
{
    NutritionalGoalPO entity = this.getMapper().map(request, NutritionalGoalPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    NutritionalGoalCreateResponse response = new NutritionalGoalCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == nutritionalGoalMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新营养目标
 *
 * @param request 更新营养目标请求
 * @param passport 用户护照
 * @return 更新营养目标应答
 */
@Override
public NutritionalGoalUpdateResponse update(NutritionalGoalUpdateRequest request, Passport passport)
{
    NutritionalGoalPO entity = this.getMapper().map(request, NutritionalGoalPO.class);

    NutritionalGoalUpdateResponse response = new NutritionalGoalUpdateResponse();
    Long result=nutritionalGoalMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除营养目标
 *
 * @param request 删除营养目标请求
 * @param passport 用户护照
 * @return 删除营养目标应答
 */
@Override
public NutritionalGoalDeleteResponse delete(NutritionalGoalDeleteRequest request, Passport passport)
{
 NutritionalGoalDeleteResponse response = new NutritionalGoalDeleteResponse();
     Long result= nutritionalGoalMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}


/**
 * 作废营养目标
 *
 * @param request 作废营养目标请求
 * @param passport 用户护照
 * @return 作废营养目标应答
 */
@Override
public NutritionalGoalInactiveResponse inactive(NutritionalGoalInactiveRequest request, Passport passport)
{
 NutritionalGoalInactiveResponse response = new NutritionalGoalInactiveResponse();
    Long result= nutritionalGoalMapper.inactive(request.getId(), passport);
    response.setResult(result);
    return response;
}


/**
 * 激活营养目标
 *
 * @param request 激活营养目标请求
 * @param passport 用户护照
 * @return 激活营养目标应答
 */
@Override
public NutritionalGoalActiveResponse active(NutritionalGoalActiveRequest request, Passport passport)
{
 NutritionalGoalActiveResponse response = new NutritionalGoalActiveResponse();
    Long result= nutritionalGoalMapper.active(request.getId(), passport);
    response.setResult(result);
    return response;
}



/**
 * 导入营养目标
 *
 * @param request 导入营养目标请求
 * @param passport 用户护照
 * @return 导入营养目标应答
 */
@Override
public NutritionalGoalListImportResponse importList(NutritionalGoalListImportRequest request, Passport passport)
{
    DataTable<NutritionalGoalImport> dataTable = request.getDataTable();

    List<NutritionalGoalPO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<NutritionalGoalImport> beanList = request.getList();            //取出导入对象的集合
    NutritionalGoalListImportResponse response = new NutritionalGoalListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (NutritionalGoalImport importBean : beanList) {
        // 设置
        NutritionalGoalPO entity = this.getMapper().map(importBean, NutritionalGoalPO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            nutritionalGoalMapper.insertBatch(importList, passport);
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
     * @param nutritionalGoal 营养目标
     * @param passport 用户护照
     */
    private void checkValidate(NutritionalGoalPO nutritionalGoal, Passport passport, BaseResponse response) {
        // TODO

    }


}
