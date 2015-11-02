/**
 * @(#)SyncHeatDetailManagerImpl.java
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
import com.showcal.thermalcontrol.dal.SyncHeatDetailMapper;
import com.showcal.thermalcontrol.po.SyncHeatDetailPO;
import com.showcal.foundation.service.FoundationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolSyncHeatDetailManager")
public class SyncHeatDetailManagerImpl extends BaseManagerImpl implements SyncHeatDetailManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SyncHeatDetailMapper syncHeatDetailMapper;


/**
 * 根据Id获取热量同步明细表
 *
 * @param request 获取热量同步明细表请求
 * @param passport 用户护照
 * @return 获取热量同步明细表应答
 */
@Override
@Transactional(readOnly = true)
public SyncHeatDetailGetResponse get(SyncHeatDetailGetRequest request, Passport passport)
{
    SyncHeatDetailPO entity = syncHeatDetailMapper.getById(request.getId(), passport);
    SyncHeatDetailGetResponse response = new SyncHeatDetailGetResponse();
    if (entity != null) {
    SyncHeatDetail syncHeatDetail = this.getMapper().map(entity, SyncHeatDetail.class);
    response.setSyncHeatDetail(syncHeatDetail );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询热量同步明细表
 *
 * @param request 模糊查询热量同步明细表请求
 * @param passport 用户护照
 * @return 模糊查询热量同步明细表应答
 */
@Override
@Transactional(readOnly = true)
public SyncHeatDetailSearchResponse search(SyncHeatDetailSearchRequest request, Passport passport)
{
    SyncHeatDetailSearchResponse response = new SyncHeatDetailSearchResponse();
    List<SyncHeatDetail> modelList = new ArrayList<>();
    Long count = syncHeatDetailMapper.searchCount(request, passport);

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
        List<SyncHeatDetailPO> entityList = syncHeatDetailMapper.search(request, passport);

        for (SyncHeatDetailPO entity : entityList) {
        SyncHeatDetail syncHeatDetail = this.getMapper().map(entity, SyncHeatDetail.class);
        modelList.add(syncHeatDetail);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询热量同步明细表
 *
 * @param request 高级查询热量同步明细表请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public SyncHeatDetailFindResponse find(SyncHeatDetailFindRequest request, Passport passport)
{
    SyncHeatDetailFindResponse response = new SyncHeatDetailFindResponse();
    List<SyncHeatDetail> modelList = new ArrayList<>();
    Long count = syncHeatDetailMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<SyncHeatDetailPO> entityList = syncHeatDetailMapper.find(request, passport);
        for (SyncHeatDetailPO entity : entityList) {
            SyncHeatDetail syncHeatDetail = this.getMapper().map(entity, SyncHeatDetail.class);
            modelList.add(syncHeatDetail);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有热量同步明细表列表
 *
 * @param request 获取所有热量同步明细表列表请求
 * @param passport 用户护照
 * @return 获取所有热量同步明细表列表应答
 */
@Override
@Transactional(readOnly = true)
public SyncHeatDetailGetAllListResponse getAllList(SyncHeatDetailGetAllListRequest request, Passport passport)
{
    SyncHeatDetailGetAllListResponse response = new SyncHeatDetailGetAllListResponse();


    List<SyncHeatDetailPO> entityList = syncHeatDetailMapper.getAllList(request, passport);


    List<SyncHeatDetail> modelList = new ArrayList<>();
    for (SyncHeatDetailPO entity : entityList) {
    SyncHeatDetail syncHeatDetail = this.getMapper().map(entity, SyncHeatDetail.class);
    modelList.add(syncHeatDetail);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建热量同步明细表
 *
 * @param request 创建热量同步明细表请求
 * @param passport 用户护照
 * @return 创建热量同步明细表应答
 */
@Override
public SyncHeatDetailCreateResponse create(SyncHeatDetailCreateRequest request, Passport passport)
{
    SyncHeatDetailPO entity = this.getMapper().map(request, SyncHeatDetailPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    SyncHeatDetailCreateResponse response = new SyncHeatDetailCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == syncHeatDetailMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新热量同步明细表
 *
 * @param request 更新热量同步明细表请求
 * @param passport 用户护照
 * @return 更新热量同步明细表应答
 */
@Override
public SyncHeatDetailUpdateResponse update(SyncHeatDetailUpdateRequest request, Passport passport)
{
    SyncHeatDetailPO entity = this.getMapper().map(request, SyncHeatDetailPO.class);

    SyncHeatDetailUpdateResponse response = new SyncHeatDetailUpdateResponse();
    Long result=syncHeatDetailMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除热量同步明细表
 *
 * @param request 删除热量同步明细表请求
 * @param passport 用户护照
 * @return 删除热量同步明细表应答
 */
@Override
public SyncHeatDetailDeleteResponse delete(SyncHeatDetailDeleteRequest request, Passport passport)
{
 SyncHeatDetailDeleteResponse response = new SyncHeatDetailDeleteResponse();
     Long result= syncHeatDetailMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




/**
 * 导入热量同步明细表
 *
 * @param request 导入热量同步明细表请求
 * @param passport 用户护照
 * @return 导入热量同步明细表应答
 */
@Override
public SyncHeatDetailListImportResponse importList(SyncHeatDetailListImportRequest request, Passport passport)
{
    DataTable<SyncHeatDetailImport> dataTable = request.getDataTable();

    List<SyncHeatDetailPO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<SyncHeatDetailImport> beanList = request.getList();            //取出导入对象的集合
    SyncHeatDetailListImportResponse response = new SyncHeatDetailListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (SyncHeatDetailImport importBean : beanList) {
        // 设置
        SyncHeatDetailPO entity = this.getMapper().map(importBean, SyncHeatDetailPO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            syncHeatDetailMapper.insertBatch(importList, passport);
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
     * @param syncHeatDetail 热量同步明细表
     * @param passport 用户护照
     */
    private void checkValidate(SyncHeatDetailPO syncHeatDetail, Passport passport, BaseResponse response) {
        // TODO

    }


}
