/**
 * @(#)ItemPictureManagerImpl.java
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
import com.showcal.foundation.biz.FileManager;
import com.showcal.foundation.biz.SequenceManager;
import com.showcal.foundation.domain.UploadTypeEnum;
import com.showcal.foundation.request.FileUploadRequest;
import com.showcal.foundation.response.FileUploadResponse;
import com.showcal.merchandise.dal.ItemPictureMapper;
import com.showcal.merchandise.po.ItemPicturePO;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;
import com.showcal.merchandise.domain.*;
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
@Service("MerchandiseItemPictureManager")
public class ItemPictureManagerImpl extends BaseManagerImpl implements ItemPictureManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private ItemPictureMapper itemPictureMapper;
    @Autowired
    private SequenceManager sequenceManager;
    @Autowired
    private FileManager fileManager;

/**
 * 根据Id获取物料图片表
 *
 * @param request 获取物料图片表请求
 * @param passport 用户护照
 * @return 获取物料图片表应答
 */
@Override
@Transactional(readOnly = true)
public ItemPictureGetResponse get(ItemPictureGetRequest request, Passport passport)
{
    ItemPicturePO entity = itemPictureMapper.getById(request.getId(), passport);
    ItemPictureGetResponse response = new ItemPictureGetResponse();
    if (entity != null) {
    ItemPicture itemPicture = this.getMapper().map(entity, ItemPicture.class);
    response.setItemPicture(itemPicture );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询物料图片表
 *
 * @param request 模糊查询物料图片表请求
 * @param passport 用户护照
 * @return 模糊查询物料图片表应答
 */
@Override
@Transactional(readOnly = true)
public ItemPictureSearchResponse search(ItemPictureSearchRequest request, Passport passport)
{
    ItemPictureSearchResponse response = new ItemPictureSearchResponse();
    List<ItemPicture> modelList = new ArrayList<>();
    Long count = itemPictureMapper.searchCount(request, passport);

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
        List<ItemPicturePO> entityList = itemPictureMapper.search(request, passport);

        for (ItemPicturePO entity : entityList) {
        ItemPicture itemPicture = this.getMapper().map(entity, ItemPicture.class);
        modelList.add(itemPicture);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询物料图片表
 *
 * @param request 高级查询物料图片表请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public ItemPictureFindResponse find(ItemPictureFindRequest request, Passport passport)
{
    ItemPictureFindResponse response = new ItemPictureFindResponse();
    List<ItemPicture> modelList = new ArrayList<>();
    Long count = itemPictureMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<ItemPicturePO> entityList = itemPictureMapper.find(request, passport);
        for (ItemPicturePO entity : entityList) {
            ItemPicture itemPicture = this.getMapper().map(entity, ItemPicture.class);
            modelList.add(itemPicture);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有物料图片表列表
 *
 * @param request 获取所有物料图片表列表请求
 * @param passport 用户护照
 * @return 获取所有物料图片表列表应答
 */
@Override
@Transactional(readOnly = true)
public ItemPictureGetAllListResponse getAllList(ItemPictureGetAllListRequest request, Passport passport)
{
    ItemPictureGetAllListResponse response = new ItemPictureGetAllListResponse();


    List<ItemPicturePO> entityList = itemPictureMapper.getAllList(request, passport);


    List<ItemPicture> modelList = new ArrayList<>();
    for (ItemPicturePO entity : entityList) {
    ItemPicture itemPicture = this.getMapper().map(entity, ItemPicture.class);
    modelList.add(itemPicture);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建物料图片表
 *
 * @param request 创建物料图片表请求
 * @param passport 用户护照
 * @return 创建物料图片表应答
 */
@Override
public ItemPictureCreateResponse create(ItemPictureCreateRequest request, Passport passport)
{
    ItemPicturePO entity = this.getMapper().map(request, ItemPicturePO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    ItemPictureCreateResponse response = new ItemPictureCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity, passport, response);

    if (1 == itemPictureMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新物料图片表
 *
 * @param request 更新物料图片表请求
 * @param passport 用户护照
 * @return 更新物料图片表应答
 */
@Override
public ItemPictureUpdateResponse update(ItemPictureUpdateRequest request, Passport passport)
{
    ItemPicturePO entity = this.getMapper().map(request, ItemPicturePO.class);

    ItemPictureUpdateResponse response = new ItemPictureUpdateResponse();
    Long result=itemPictureMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除物料图片表
 *
 * @param request 删除物料图片表请求
 * @param passport 用户护照
 * @return 删除物料图片表应答
 */
@Override
public ItemPictureDeleteResponse delete(ItemPictureDeleteRequest request, Passport passport)
{
 ItemPictureDeleteResponse response = new ItemPictureDeleteResponse();
     Long result= itemPictureMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




/**
 * 导入物料图片表
 *
 * @param request 导入物料图片表请求
 * @param passport 用户护照
 * @return 导入物料图片表应答
 */
@Override
public ItemPictureListImportResponse importList(ItemPictureListImportRequest request, Passport passport)
{
    DataTable<ItemPictureImport> dataTable = request.getDataTable();

    List<ItemPicturePO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<ItemPictureImport> beanList = request.getList();            //取出导入对象的集合
    ItemPictureListImportResponse response = new ItemPictureListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (ItemPictureImport importBean : beanList) {
        // 设置
        ItemPicturePO entity = this.getMapper().map(importBean, ItemPicturePO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            itemPictureMapper.insertBatch(importList, passport);
        }
    }
    else {
        //response.setDataTable(dataTable);
        response.addErrors(dataTable.getErrorList());
    }

    response.setList(result);
    return response;

}

    @Override
    public ItemPictureUploadResponse uploadAttachment(ItemPictureUploadRequest req, Passport passport) {
        ItemPicturePO itemPicturePO = new ItemPicturePO();
        ItemPictureUploadResponse response = new ItemPictureUploadResponse();
        ItemPicture itemPicture = new ItemPicture();
        // 获取附件表主键编号
        Long itemPictureId = sequenceManager.getNewId();

        // 获取并设定主键
        itemPicturePO.setId(itemPictureId);

        // 设定业务主键
        itemPicturePO.setItemId(req.getBusinessId());

        if (req.getFileStream() != null) {
            FileUploadRequest fileUploadRequest = new FileUploadRequest();
            fileUploadRequest.setFileStream(req.getFileStream());
            fileUploadRequest.setFileExt(req.getFileExt());
            fileUploadRequest.setFileName(req.getFileName());
            fileUploadRequest.setType(UploadTypeEnum.ATTACHMENT);

            FileUploadResponse fileUploadResponse = fileManager.uploadFile(fileUploadRequest, passport);

            if (fileUploadResponse.hasError()) {
                response.addErrors(fileUploadResponse.getErrors());
                return response;
            }
            itemPicturePO.setPictureId(fileUploadResponse.getId());
            itemPictureMapper.insert(itemPicturePO, passport);
            itemPicture.setFilePath(fileUploadResponse.getUrl());
        } else {
            itemPictureMapper.insert(itemPicturePO, passport);
        }
        itemPicture.setDisplayName(req.getFileName() + "." + req.getFileExt());
        itemPicture.setId(itemPictureId);
        response.setItemPicture(itemPicture);
        return response;
    }
    /**
     * 验证对象
     * @param itemPicture 物料图片表
     * @param passport 用户护照
     */
    private void checkValidate(ItemPicturePO itemPicture, Passport passport, BaseResponse response) {
        // TODO

    }


}
