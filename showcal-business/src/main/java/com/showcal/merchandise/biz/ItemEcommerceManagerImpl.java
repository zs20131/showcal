/**
 * @(#)ItemEcommerceManagerImpl.java
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
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;
import com.showcal.merchandise.domain.*;
import com.showcal.merchandise.dal.ItemEcommerceMapper;
import com.showcal.merchandise.po.ItemEcommercePO;
import com.showcal.foundation.service.FoundationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:07.
 * @author 顾志雄
 */
@Transactional
@Service("MerchandiseItemEcommerceManager")
public class ItemEcommerceManagerImpl extends BaseManagerImpl implements ItemEcommerceManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private ItemEcommerceMapper itemEcommerceMapper;


/**
 * 根据Id获取物料电商属性
 *
 * @param request 获取物料电商属性请求
 * @param passport 用户护照
 * @return 获取物料电商属性应答
 */
@Override
@Transactional(readOnly = true)
public ItemEcommerceGetResponse get(ItemEcommerceGetRequest request, Passport passport)
{
    ItemEcommercePO entity = itemEcommerceMapper.getById(request.getId(), passport);
    ItemEcommerceGetResponse response = new ItemEcommerceGetResponse();
    if (entity != null) {
    ItemEcommerce itemEcommerce = this.getMapper().map(entity, ItemEcommerce.class);
    response.setItemEcommerce(itemEcommerce );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询物料电商属性
 *
 * @param request 模糊查询物料电商属性请求
 * @param passport 用户护照
 * @return 模糊查询物料电商属性应答
 */
@Override
@Transactional(readOnly = true)
public ItemEcommerceSearchResponse search(ItemEcommerceSearchRequest request, Passport passport)
{
    ItemEcommerceSearchResponse response = new ItemEcommerceSearchResponse();
    List<ItemEcommerce> modelList = new ArrayList<>();
    Long count = itemEcommerceMapper.searchCount(request, passport);

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
        List<ItemEcommercePO> entityList = itemEcommerceMapper.search(request, passport);

        for (ItemEcommercePO entity : entityList) {
        ItemEcommerce itemEcommerce = this.getMapper().map(entity, ItemEcommerce.class);
        modelList.add(itemEcommerce);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询物料电商属性
 *
 * @param request 高级查询物料电商属性请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public ItemEcommerceFindResponse find(ItemEcommerceFindRequest request, Passport passport)
{
    ItemEcommerceFindResponse response = new ItemEcommerceFindResponse();
    List<ItemEcommerce> modelList = new ArrayList<>();
    Long count = itemEcommerceMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<ItemEcommercePO> entityList = itemEcommerceMapper.find(request, passport);
        for (ItemEcommercePO entity : entityList) {
            ItemEcommerce itemEcommerce = this.getMapper().map(entity, ItemEcommerce.class);
            modelList.add(itemEcommerce);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有物料电商属性列表
 *
 * @param request 获取所有物料电商属性列表请求
 * @param passport 用户护照
 * @return 获取所有物料电商属性列表应答
 */
@Override
@Transactional(readOnly = true)
public ItemEcommerceGetAllListResponse getAllList(ItemEcommerceGetAllListRequest request, Passport passport)
{
    ItemEcommerceGetAllListResponse response = new ItemEcommerceGetAllListResponse();


    List<ItemEcommercePO> entityList = itemEcommerceMapper.getAllList(request, passport);


    List<ItemEcommerce> modelList = new ArrayList<>();
    for (ItemEcommercePO entity : entityList) {
    ItemEcommerce itemEcommerce = this.getMapper().map(entity, ItemEcommerce.class);
    modelList.add(itemEcommerce);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建物料电商属性
 *
 * @param request 创建物料电商属性请求
 * @param passport 用户护照
 * @return 创建物料电商属性应答
 */
@Override
public ItemEcommerceCreateResponse create(ItemEcommerceCreateRequest request, Passport passport)
{
    ItemEcommercePO entity = this.getMapper().map(request, ItemEcommercePO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    ItemEcommerceCreateResponse response = new ItemEcommerceCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == itemEcommerceMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新物料电商属性
 *
 * @param request 更新物料电商属性请求
 * @param passport 用户护照
 * @return 更新物料电商属性应答
 */
@Override
public ItemEcommerceUpdateResponse update(ItemEcommerceUpdateRequest request, Passport passport)
{
    ItemEcommercePO entity = this.getMapper().map(request, ItemEcommercePO.class);

    ItemEcommerceUpdateResponse response = new ItemEcommerceUpdateResponse();
    Long result=itemEcommerceMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除物料电商属性
 *
 * @param request 删除物料电商属性请求
 * @param passport 用户护照
 * @return 删除物料电商属性应答
 */
@Override
public ItemEcommerceDeleteResponse delete(ItemEcommerceDeleteRequest request, Passport passport)
{
 ItemEcommerceDeleteResponse response = new ItemEcommerceDeleteResponse();
     Long result= itemEcommerceMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




/**
 * 导入物料电商属性
 *
 * @param request 导入物料电商属性请求
 * @param passport 用户护照
 * @return 导入物料电商属性应答
 */
@Override
public ItemEcommerceListImportResponse importList(ItemEcommerceListImportRequest request, Passport passport)
{
    DataTable<ItemEcommerceImport> dataTable = request.getDataTable();

    List<ItemEcommercePO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<ItemEcommerceImport> beanList = request.getList();            //取出导入对象的集合
    ItemEcommerceListImportResponse response = new ItemEcommerceListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (ItemEcommerceImport importBean : beanList) {
        // 设置
        ItemEcommercePO entity = this.getMapper().map(importBean, ItemEcommercePO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            itemEcommerceMapper.insertBatch(importList, passport);
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
     * @param itemEcommerce 物料电商属性
     * @param passport 用户护照
     */
    private void checkValidate(ItemEcommercePO itemEcommerce, Passport passport, BaseResponse response) {
        // TODO

    }


}
