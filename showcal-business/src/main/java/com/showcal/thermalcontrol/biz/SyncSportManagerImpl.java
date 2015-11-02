/**
 * @(#)SyncSportManagerImpl.java
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
import com.showcal.platform.biz.IntegralDetailManager;
import com.showcal.platform.domain.IntegralRuleTypeEnum;
import com.showcal.platform.request.IntegralDetailCreateRequest;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;
import com.showcal.thermalcontrol.domain.*;
import com.showcal.thermalcontrol.dal.SyncSportMapper;
import com.showcal.thermalcontrol.po.SyncSportPO;
import com.showcal.foundation.service.FoundationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:47:00.
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolSyncSportManager")
public class SyncSportManagerImpl extends BaseManagerImpl implements SyncSportManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SyncSportMapper syncSportMapper;
    @Autowired
    private IntegralDetailManager integralDetailManager;


/**
 * 根据Id获取运动同步表)
 *
 * @param request 获取运动同步表)请求
 * @param passport 用户护照
 * @return 获取运动同步表)应答
 */
@Override
@Transactional(readOnly = true)
public SyncSportGetResponse get(SyncSportGetRequest request, Passport passport)
{
    SyncSportPO entity = syncSportMapper.getById(request.getId(), passport);
    SyncSportGetResponse response = new SyncSportGetResponse();
    if (entity != null) {
    SyncSport syncSport = this.getMapper().map(entity, SyncSport.class);
    response.setSyncSport(syncSport );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询运动同步表)
 *
 * @param request 模糊查询运动同步表)请求
 * @param passport 用户护照
 * @return 模糊查询运动同步表)应答
 */
@Override
@Transactional(readOnly = true)
public SyncSportSearchResponse search(SyncSportSearchRequest request, Passport passport)
{
    SyncSportSearchResponse response = new SyncSportSearchResponse();
    List<SyncSport> modelList = new ArrayList<SyncSport>();
    Long count = syncSportMapper.searchCount(request, passport);

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
        List<SyncSportPO> entityList = syncSportMapper.search(request, passport);

        for (SyncSportPO entity : entityList) {
        SyncSport syncSport = this.getMapper().map(entity, SyncSport.class);
        modelList.add(syncSport);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询运动同步表)
 *
 * @param request 高级查询运动同步表)请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public SyncSportFindResponse find(SyncSportFindRequest request, Passport passport)
{
    SyncSportFindResponse response = new SyncSportFindResponse();
    List<SyncSport> modelList = new ArrayList<SyncSport>();
    Long count = syncSportMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<SyncSportPO> entityList = syncSportMapper.find(request, passport);
        for (SyncSportPO entity : entityList) {
            SyncSport syncSport = this.getMapper().map(entity, SyncSport.class);
            modelList.add(syncSport);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有运动同步表)列表
 *
 * @param request 获取所有运动同步表)列表请求
 * @param passport 用户护照
 * @return 获取所有运动同步表)列表应答
 */
@Override
@Transactional(readOnly = true)
public SyncSportGetAllListResponse getAllList(SyncSportGetAllListRequest request, Passport passport)
{
    SyncSportGetAllListResponse response = new SyncSportGetAllListResponse();


    List<SyncSportPO> entityList = syncSportMapper.getAllList(request, passport);


    List<SyncSport> modelList = new ArrayList<SyncSport>();
    for (SyncSportPO entity : entityList) {
    SyncSport syncSport = this.getMapper().map(entity, SyncSport.class);
    modelList.add(syncSport);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建运动同步表)
 *
 * @param request 创建运动同步表)请求
 * @param passport 用户护照
 * @return 创建运动同步表)应答
 */
@Override
public SyncSportCreateResponse create(SyncSportCreateRequest request, Passport passport)
{
    SyncSportPO entity = this.getMapper().map(request, SyncSportPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    SyncSportCreateResponse response = new SyncSportCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == syncSportMapper.insert(entity, passport)) {
        response.setId(id);
        //评论增加积分
        IntegralDetailCreateRequest integralDetailCreateRequest=new IntegralDetailCreateRequest();
        integralDetailCreateRequest.setType(IntegralRuleTypeEnum.USERTC.name());
        integralDetailManager.create(integralDetailCreateRequest, passport);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新运动同步表)
 *
 * @param request 更新运动同步表)请求
 * @param passport 用户护照
 * @return 更新运动同步表)应答
 */
@Override
public SyncSportUpdateResponse update(SyncSportUpdateRequest request, Passport passport)
{
    SyncSportPO entity = this.getMapper().map(request, SyncSportPO.class);

    SyncSportUpdateResponse response = new SyncSportUpdateResponse();
    Long result=syncSportMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除运动同步表)
 *
 * @param request 删除运动同步表)请求
 * @param passport 用户护照
 * @return 删除运动同步表)应答
 */
@Override
public SyncSportDeleteResponse delete(SyncSportDeleteRequest request, Passport passport)
{
 SyncSportDeleteResponse response = new SyncSportDeleteResponse();
     Long result= syncSportMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




/**
 * 导入运动同步表)
 *
 * @param request 导入运动同步表)请求
 * @param passport 用户护照
 * @return 导入运动同步表)应答
 */
@Override
public SyncSportListImportResponse importList(SyncSportListImportRequest request, Passport passport)
{
    DataTable<SyncSportImport> dataTable = request.getDataTable();

    List<SyncSportPO> importList = new ArrayList<SyncSportPO>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<Long>();                    //存储ID的集合
    List<SyncSportImport> beanList = request.getList();            //取出导入对象的集合
    SyncSportListImportResponse response = new SyncSportListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (SyncSportImport importBean : beanList) {
        // 设置
        SyncSportPO entity = this.getMapper().map(importBean, SyncSportPO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            syncSportMapper.insertBatch(importList, passport);
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
     * @param syncSport 运动同步表)
     * @param passport 用户护照
     */
    private void checkValidate(SyncSportPO syncSport, Passport passport, BaseResponse response) {
        // TODO

    }


}
