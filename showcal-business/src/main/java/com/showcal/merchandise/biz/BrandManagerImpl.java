/**
 * @(#)BrandManagerImpl.java
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
import com.showcal.merchandise.dal.BrandMapper;
import com.showcal.merchandise.domain.Brand;
import com.showcal.merchandise.domain.BrandImport;
import com.showcal.merchandise.po.BrandPO;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;
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
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 * @author 顾志雄
 */
@Transactional
@Service("MerchandiseBrandManager")
public class BrandManagerImpl extends BaseManagerImpl implements BrandManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private BrandMapper brandMapper;


/**
 * 根据Id获取物料品牌表
 *
 * @param request 获取物料品牌表请求
 * @param passport 用户护照
 * @return 获取物料品牌表应答
 */
@Override
@Transactional(readOnly = true)
public BrandGetResponse get(BrandGetRequest request, Passport passport)
{
    BrandPO entity = brandMapper.getById(request.getId(), passport);
    BrandGetResponse response = new BrandGetResponse();
    if (entity != null) {
    Brand brand = this.getMapper().map(entity, Brand.class);
    response.setBrand(brand );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询物料品牌表
 *
 * @param request 模糊查询物料品牌表请求
 * @param passport 用户护照
 * @return 模糊查询物料品牌表应答
 */
@Override
@Transactional(readOnly = true)
public BrandSearchResponse search(BrandSearchRequest request, Passport passport)
{
    BrandSearchResponse response = new BrandSearchResponse();
    List<Brand> modelList = new ArrayList<>();
    Long count = brandMapper.searchCount(request, passport);

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
        List<BrandPO> entityList = brandMapper.search(request, passport);

        for (BrandPO entity : entityList) {
        Brand brand = this.getMapper().map(entity, Brand.class);
        modelList.add(brand);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询物料品牌表
 *
 * @param request 高级查询物料品牌表请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public BrandFindResponse find(BrandFindRequest request, Passport passport)
{
    BrandFindResponse response = new BrandFindResponse();
    List<Brand> modelList = new ArrayList<>();
    Long count = brandMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<BrandPO> entityList = brandMapper.find(request, passport);
        for (BrandPO entity : entityList) {
            Brand brand = this.getMapper().map(entity, Brand.class);
            modelList.add(brand);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有物料品牌表列表
 *
 * @param request 获取所有物料品牌表列表请求
 * @param passport 用户护照
 * @return 获取所有物料品牌表列表应答
 */
@Override
@Transactional(readOnly = true)
public BrandGetAllListResponse getAllList(BrandGetAllListRequest request, Passport passport)
{
    BrandGetAllListResponse response = new BrandGetAllListResponse();


    List<BrandPO> entityList = brandMapper.getAllList(request, passport);


    List<Brand> modelList = new ArrayList<>();
    for (BrandPO entity : entityList) {
    Brand brand = this.getMapper().map(entity, Brand.class);
    modelList.add(brand);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建物料品牌表
 *
 * @param request 创建物料品牌表请求
 * @param passport 用户护照
 * @return 创建物料品牌表应答
 */
@Override
public BrandCreateResponse create(BrandCreateRequest request, Passport passport)
{
    BrandPO entity = this.getMapper().map(request, BrandPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    BrandCreateResponse response = new BrandCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == brandMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新物料品牌表
 *
 * @param request 更新物料品牌表请求
 * @param passport 用户护照
 * @return 更新物料品牌表应答
 */
@Override
public BrandUpdateResponse update(BrandUpdateRequest request, Passport passport)
{
    BrandPO entity = this.getMapper().map(request, BrandPO.class);

    BrandUpdateResponse response = new BrandUpdateResponse();
    Long result=brandMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除物料品牌表
 *
 * @param request 删除物料品牌表请求
 * @param passport 用户护照
 * @return 删除物料品牌表应答
 */
@Override
public BrandDeleteResponse delete(BrandDeleteRequest request, Passport passport)
{
 BrandDeleteResponse response = new BrandDeleteResponse();
     Long result= brandMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




/**
 * 导入物料品牌表
 *
 * @param request 导入物料品牌表请求
 * @param passport 用户护照
 * @return 导入物料品牌表应答
 */
@Override
public BrandListImportResponse importList(BrandListImportRequest request, Passport passport)
{
    DataTable<BrandImport> dataTable = request.getDataTable();

    List<BrandPO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<BrandImport> beanList = request.getList();            //取出导入对象的集合
    BrandListImportResponse response = new BrandListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (BrandImport importBean : beanList) {
        // 设置
        BrandPO entity = this.getMapper().map(importBean, BrandPO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            brandMapper.insertBatch(importList, passport);
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
     * @param brand 物料品牌表
     * @param passport 用户护照
     */
    private void checkValidate(BrandPO brand, Passport passport, BaseResponse response) {
        // TODO

    }


}
