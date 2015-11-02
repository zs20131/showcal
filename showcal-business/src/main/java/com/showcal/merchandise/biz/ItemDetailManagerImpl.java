/**
 * @(#)ItemDetailManagerImpl.java
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
package com.showcal.merchandise.biz;

import com.showcal.cms.svc.Message;
import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.foundation.service.FoundationService;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import com.showcal.merchandise.*;
import com.showcal.merchandise.dal.ItemDetailMapper;
import com.showcal.merchandise.domain.*;
import com.showcal.merchandise.po.ItemDetailPO;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by 顾志雄 on 2015-09-24 09:54:06.
 * @author 顾志雄
 */
@Transactional
@Service("MerchandiseItemDetailManager")
public class ItemDetailManagerImpl extends BaseManagerImpl implements ItemDetailManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private ItemDetailMapper itemDetailMapper;


/**
 * 根据Id获取物料详情说明
 *
 * @param request 获取物料详情说明请求
 * @param passport 用户护照
 * @return 获取物料详情说明应答
 */
@Override
@Transactional(readOnly = true)
public ItemDetailGetResponse get(ItemDetailGetRequest request, Passport passport)
{
    ItemDetailPO entity = itemDetailMapper.getById(request.getId(), passport);
    ItemDetailGetResponse response = new ItemDetailGetResponse();
    if (entity != null) {
    ItemDetail itemDetail = this.getMapper().map(entity, ItemDetail.class);
    response.setItemDetail(itemDetail );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询物料详情说明
 *
 * @param request 模糊查询物料详情说明请求
 * @param passport 用户护照
 * @return 模糊查询物料详情说明应答
 */
@Override
@Transactional(readOnly = true)
public ItemDetailSearchResponse search(ItemDetailSearchRequest request, Passport passport)
{
    ItemDetailSearchResponse response = new ItemDetailSearchResponse();
    List<ItemDetail> modelList = new ArrayList<>();
    Long count = itemDetailMapper.searchCount(request, passport);

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
        List<ItemDetailPO> entityList = itemDetailMapper.search(request, passport);

        for (ItemDetailPO entity : entityList) {
        ItemDetail itemDetail = this.getMapper().map(entity, ItemDetail.class);
        modelList.add(itemDetail);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询物料详情说明
 *
 * @param request 高级查询物料详情说明请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public ItemDetailFindResponse find(ItemDetailFindRequest request, Passport passport)
{
    ItemDetailFindResponse response = new ItemDetailFindResponse();
    List<ItemDetail> modelList = new ArrayList<>();
    Long count = itemDetailMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<ItemDetailPO> entityList = itemDetailMapper.find(request, passport);
        for (ItemDetailPO entity : entityList) {
            ItemDetail itemDetail = this.getMapper().map(entity, ItemDetail.class);
            modelList.add(itemDetail);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有物料详情说明列表
 *
 * @param request 获取所有物料详情说明列表请求
 * @param passport 用户护照
 * @return 获取所有物料详情说明列表应答
 */
@Override
@Transactional(readOnly = true)
public ItemDetailGetAllListResponse getAllList(ItemDetailGetAllListRequest request, Passport passport)
{
    ItemDetailGetAllListResponse response = new ItemDetailGetAllListResponse();


    List<ItemDetailPO> entityList = itemDetailMapper.getAllList(request, passport);


    List<ItemDetail> modelList = new ArrayList<>();
    for (ItemDetailPO entity : entityList) {
    ItemDetail itemDetail = this.getMapper().map(entity, ItemDetail.class);
    modelList.add(itemDetail);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建物料详情说明
 *
 * @param request 创建物料详情说明请求
 * @param passport 用户护照
 * @return 创建物料详情说明应答
 */
@Override
public ItemDetailCreateResponse create(ItemDetailCreateRequest request, Passport passport)
{
    ItemDetailPO entity = this.getMapper().map(request, ItemDetailPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    ItemDetailCreateResponse response = new ItemDetailCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == itemDetailMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新物料详情说明
 *
 * @param request 更新物料详情说明请求
 * @param passport 用户护照
 * @return 更新物料详情说明应答
 */
@Override
public ItemDetailUpdateResponse update(ItemDetailUpdateRequest request, Passport passport)
{
    ItemDetailPO entity = this.getMapper().map(request, ItemDetailPO.class);

    ItemDetailUpdateResponse response = new ItemDetailUpdateResponse();
    Long result=itemDetailMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除物料详情说明
 *
 * @param request 删除物料详情说明请求
 * @param passport 用户护照
 * @return 删除物料详情说明应答
 */
@Override
public ItemDetailDeleteResponse delete(ItemDetailDeleteRequest request, Passport passport)
{
 ItemDetailDeleteResponse response = new ItemDetailDeleteResponse();
     Long result= itemDetailMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




/**
 * 导入物料详情说明
 *
 * @param request 导入物料详情说明请求
 * @param passport 用户护照
 * @return 导入物料详情说明应答
 */
@Override
public ItemDetailListImportResponse importList(ItemDetailListImportRequest request, Passport passport)
{
    DataTable<ItemDetailImport> dataTable = request.getDataTable();

    List<ItemDetailPO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<ItemDetailImport> beanList = request.getList();            //取出导入对象的集合
    ItemDetailListImportResponse response = new ItemDetailListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (ItemDetailImport importBean : beanList) {
        // 设置
        ItemDetailPO entity = this.getMapper().map(importBean, ItemDetailPO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            itemDetailMapper.insertBatch(importList, passport);
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
     * @param itemDetail 物料详情说明
     * @param passport 用户护照
     */
    private void checkValidate(ItemDetailPO itemDetail, Passport passport, BaseResponse response) {
        // TODO

    }


}
