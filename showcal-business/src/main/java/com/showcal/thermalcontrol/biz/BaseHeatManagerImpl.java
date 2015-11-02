/**
 * @(#)BaseHeatManagerImpl.java
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
import com.showcal.thermalcontrol.dal.BaseHeatMapper;
import com.showcal.thermalcontrol.domain.BaseHeat;
import com.showcal.thermalcontrol.domain.BaseHeatImport;
import com.showcal.thermalcontrol.po.BaseHeatPO;
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
 * Created by 顾志雄 on 2015-09-15 13:46:56.
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolBaseHeatManager")
public class BaseHeatManagerImpl extends BaseManagerImpl implements BaseHeatManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private BaseHeatMapper baseHeatMapper;


/**
 * 根据Id获取基础热量设置
 *
 * @param request 获取基础热量设置请求
 * @param passport 用户护照
 * @return 获取基础热量设置应答
 */
@Override
@Transactional(readOnly = true)
public BaseHeatGetResponse get(BaseHeatGetRequest request, Passport passport)
{
    BaseHeatPO entity = baseHeatMapper.getById(request.getId(), passport);
    BaseHeatGetResponse response = new BaseHeatGetResponse();
    if (entity != null) {
    BaseHeat baseHeat = this.getMapper().map(entity, BaseHeat.class);
    response.setBaseHeat(baseHeat );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询基础热量设置
 *
 * @param request 模糊查询基础热量设置请求
 * @param passport 用户护照
 * @return 模糊查询基础热量设置应答
 */
@Override
@Transactional(readOnly = true)
public BaseHeatSearchResponse search(BaseHeatSearchRequest request, Passport passport)
{
    BaseHeatSearchResponse response = new BaseHeatSearchResponse();
    List<BaseHeat> modelList = new ArrayList<BaseHeat>();
    Long count = baseHeatMapper.searchCount(request, passport);

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
        List<BaseHeatPO> entityList = baseHeatMapper.search(request, passport);

        for (BaseHeatPO entity : entityList) {
        BaseHeat baseHeat = this.getMapper().map(entity, BaseHeat.class);
        modelList.add(baseHeat);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询基础热量设置
 *
 * @param request 高级查询基础热量设置请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public BaseHeatFindResponse find(BaseHeatFindRequest request, Passport passport)
{
    BaseHeatFindResponse response = new BaseHeatFindResponse();
    List<BaseHeat> modelList = new ArrayList<BaseHeat>();
    Long count = baseHeatMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<BaseHeatPO> entityList = baseHeatMapper.find(request, passport);
        for (BaseHeatPO entity : entityList) {
            BaseHeat baseHeat = this.getMapper().map(entity, BaseHeat.class);
            modelList.add(baseHeat);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有基础热量设置列表
 *
 * @param request 获取所有基础热量设置列表请求
 * @param passport 用户护照
 * @return 获取所有基础热量设置列表应答
 */
@Override
@Transactional(readOnly = true)
public BaseHeatGetAllListResponse getAllList(BaseHeatGetAllListRequest request, Passport passport)
{
    BaseHeatGetAllListResponse response = new BaseHeatGetAllListResponse();


    List<BaseHeatPO> entityList = baseHeatMapper.getAllList(request, passport);


    List<BaseHeat> modelList = new ArrayList<BaseHeat>();
    for (BaseHeatPO entity : entityList) {
    BaseHeat baseHeat = this.getMapper().map(entity, BaseHeat.class);
    modelList.add(baseHeat);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建基础热量设置
 *
 * @param request 创建基础热量设置请求
 * @param passport 用户护照
 * @return 创建基础热量设置应答
 */
@Override
public BaseHeatCreateResponse create(BaseHeatCreateRequest request, Passport passport)
{
    BaseHeatPO entity = this.getMapper().map(request, BaseHeatPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    BaseHeatCreateResponse response = new BaseHeatCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == baseHeatMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新基础热量设置
 *
 * @param request 更新基础热量设置请求
 * @param passport 用户护照
 * @return 更新基础热量设置应答
 */
@Override
public BaseHeatUpdateResponse update(BaseHeatUpdateRequest request, Passport passport)
{
    BaseHeatPO entity = this.getMapper().map(request, BaseHeatPO.class);

    BaseHeatUpdateResponse response = new BaseHeatUpdateResponse();
    Long result=baseHeatMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除基础热量设置
 *
 * @param request 删除基础热量设置请求
 * @param passport 用户护照
 * @return 删除基础热量设置应答
 */
@Override
public BaseHeatDeleteResponse delete(BaseHeatDeleteRequest request, Passport passport)
{
 BaseHeatDeleteResponse response = new BaseHeatDeleteResponse();
     Long result= baseHeatMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




/**
 * 导入基础热量设置
 *
 * @param request 导入基础热量设置请求
 * @param passport 用户护照
 * @return 导入基础热量设置应答
 */
@Override
public BaseHeatListImportResponse importList(BaseHeatListImportRequest request, Passport passport)
{
    DataTable<BaseHeatImport> dataTable = request.getDataTable();

    List<BaseHeatPO> importList = new ArrayList<BaseHeatPO>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<Long>();                    //存储ID的集合
    List<BaseHeatImport> beanList = request.getList();            //取出导入对象的集合
    BaseHeatListImportResponse response = new BaseHeatListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (BaseHeatImport importBean : beanList) {
        // 设置
        BaseHeatPO entity = this.getMapper().map(importBean, BaseHeatPO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            baseHeatMapper.insertBatch(importList, passport);
        }
    }
    else {
       // response.setDataTable(dataTable);
        response.addErrors(dataTable.getErrorList());
    }

    response.setList(result);
    return response;

}

    /**
     * 验证对象
     * @param baseHeat 基础热量设置
     * @param passport 用户护照
     */
    private void checkValidate(BaseHeatPO baseHeat, Passport passport, BaseResponse response) {
        // TODO

    }


}
