/**
 * @(#)SyncHeatManagerImpl.java
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
import com.showcal.platform.biz.IntegralDetailManager;
import com.showcal.platform.domain.IntegralRuleTypeEnum;
import com.showcal.platform.request.IntegralDetailCreateRequest;
import com.showcal.thermalcontrol.dal.SyncHeatDetailMapper;
import com.showcal.thermalcontrol.dal.SyncHeatMapper;
import com.showcal.thermalcontrol.domain.SyncHeat;
import com.showcal.thermalcontrol.domain.SyncHeatImport;
import com.showcal.thermalcontrol.po.SyncHeatDetailPO;
import com.showcal.thermalcontrol.po.SyncHeatPO;
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
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolSyncHeatManager")
public class SyncHeatManagerImpl extends BaseManagerImpl implements SyncHeatManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SyncHeatMapper syncHeatMapper;
    @Autowired
    private SyncHeatDetailMapper syncHeatDetailMapper;

    @Autowired
    private IntegralDetailManager integralDetailManager;


    /**
     * 根据Id获取热量同步表
     *
     * @param request  获取热量同步表请求
     * @param passport 用户护照
     * @return 获取热量同步表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SyncHeatGetResponse get(SyncHeatGetRequest request, Passport passport) {
        SyncHeatPO entity = syncHeatMapper.getById(request.getId(), passport);
        SyncHeatGetResponse response = new SyncHeatGetResponse();
        if (entity != null) {
            SyncHeat syncHeat = this.getMapper().map(entity, SyncHeat.class);
            response.setSyncHeat(syncHeat);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询热量同步表
     *
     * @param request  模糊查询热量同步表请求
     * @param passport 用户护照
     * @return 模糊查询热量同步表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SyncHeatSearchResponse search(SyncHeatSearchRequest request, Passport passport) {
        SyncHeatSearchResponse response = new SyncHeatSearchResponse();
        List<SyncHeat> modelList = new ArrayList<SyncHeat>();
        Long count = syncHeatMapper.searchCount(request, passport);

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
            List<SyncHeatPO> entityList = syncHeatMapper.search(request, passport);

            for (SyncHeatPO entity : entityList) {
                SyncHeat syncHeat = this.getMapper().map(entity, SyncHeat.class);
                modelList.add(syncHeat);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询热量同步表
     *
     * @param request  高级查询热量同步表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SyncHeatFindResponse find(SyncHeatFindRequest request, Passport passport) {
        SyncHeatFindResponse response = new SyncHeatFindResponse();
        List<SyncHeat> modelList = new ArrayList<SyncHeat>();
        Long count = syncHeatMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SyncHeatPO> entityList = syncHeatMapper.find(request, passport);
            for (SyncHeatPO entity : entityList) {
                SyncHeat syncHeat = this.getMapper().map(entity, SyncHeat.class);
                modelList.add(syncHeat);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有热量同步表列表
     *
     * @param request  获取所有热量同步表列表请求
     * @param passport 用户护照
     * @return 获取所有热量同步表列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SyncHeatGetAllListResponse getAllList(SyncHeatGetAllListRequest request, Passport passport) {
        SyncHeatGetAllListResponse response = new SyncHeatGetAllListResponse();


        List<SyncHeatPO> entityList = syncHeatMapper.getAllList(request, passport);


        List<SyncHeat> modelList = new ArrayList<SyncHeat>();
        for (SyncHeatPO entity : entityList) {
            SyncHeat syncHeat = this.getMapper().map(entity, SyncHeat.class);
            modelList.add(syncHeat);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建热量同步表
     *
     * @param request  创建热量同步表请求
     * @param passport 用户护照
     * @return 创建热量同步表应答
     */
    @Override
    public SyncHeatCreateResponse create(SyncHeatCreateRequest request, Passport passport) {
        SyncHeatPO entity = this.getMapper().map(request, SyncHeatPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        SyncHeatCreateResponse response = new SyncHeatCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == syncHeatMapper.insert(entity, passport)) {
            response.setId(id);
            // 批量创建行
            if (request.getDetail() != null && !request.getDetail().isEmpty()) {
                List<SyncHeatDetailPO> syncHeatDetailPOs = new ArrayList<>();
                for (SyncHeatDetailCreateRequest detailCreateRequest : request.getDetail()) {
                    SyncHeatDetailPO detailPO = this.getMapper().map(detailCreateRequest, SyncHeatDetailPO.class);
                    detailPO.setSyncHeatId(id);
                    detailPO.setId(foundationService.getNewId());
                    syncHeatDetailPOs.add(detailPO);
                }
                syncHeatDetailMapper.insertBatch(syncHeatDetailPOs, passport);
                //评论增加积分
                IntegralDetailCreateRequest integralDetailCreateRequest=new IntegralDetailCreateRequest();
                integralDetailCreateRequest.setType(IntegralRuleTypeEnum.USERTC.name());
                integralDetailManager.create(integralDetailCreateRequest, passport);
            }
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新热量同步表
     *
     * @param request  更新热量同步表请求
     * @param passport 用户护照
     * @return 更新热量同步表应答
     */
    @Override
    public SyncHeatUpdateResponse update(SyncHeatUpdateRequest request, Passport passport) {
        SyncHeatPO entity = this.getMapper().map(request, SyncHeatPO.class);

        SyncHeatUpdateResponse response = new SyncHeatUpdateResponse();
        Long result = syncHeatMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除热量同步表
     *
     * @param request  删除热量同步表请求
     * @param passport 用户护照
     * @return 删除热量同步表应答
     */
    @Override
    public SyncHeatDeleteResponse delete(SyncHeatDeleteRequest request, Passport passport) {
        SyncHeatDeleteResponse response = new SyncHeatDeleteResponse();
        Long result = syncHeatMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 导入热量同步表
     *
     * @param request  导入热量同步表请求
     * @param passport 用户护照
     * @return 导入热量同步表应答
     */
    @Override
    public SyncHeatListImportResponse importList(SyncHeatListImportRequest request, Passport passport) {
        DataTable<SyncHeatImport> dataTable = request.getDataTable();

        List<SyncHeatPO> importList = new ArrayList<SyncHeatPO>();            //需要创建的对象的集合

        List<Long> result = new LinkedList<Long>();                    //存储ID的集合
        List<SyncHeatImport> beanList = request.getList();            //取出导入对象的集合
        SyncHeatListImportResponse response = new SyncHeatListImportResponse();//最终的返回结果

    /* 批量获取ID */
        IdsGetRequest idsGetRequest = new IdsGetRequest();
        idsGetRequest.setCount(beanList.size());
        List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

        int index = 0;
        for (SyncHeatImport importBean : beanList) {
            // 设置
            SyncHeatPO entity = this.getMapper().map(importBean, SyncHeatPO.class);


            importList.add(entity);
            result.add(ids.get(index));         //将取到的ID放入返回结果中
            entity.setId(ids.get(index));       //设置ID

            index++;
        }

        if (!dataTable.hasError()) {
            if (importList.size() > 0) {
                syncHeatMapper.insertBatch(importList, passport);
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
     * @param syncHeat 热量同步表
     * @param passport 用户护照
     */
    private void checkValidate(SyncHeatPO syncHeat, Passport passport, BaseResponse response) {
        // TODO

    }


}
