/**
 * @(#)CollectionManagerImpl.java
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
package com.showcal.platform.biz;

import com.showcal.cms.svc.Message;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.CollectionMapper;
import com.showcal.platform.domain.Collection;
import com.showcal.platform.po.CollectionPO;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-23 10:27:25.
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromCollectionManager")
public class CollectionManagerImpl extends BaseManagerImpl implements CollectionManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private CollectionMapper collectionMapper;


/**
 * 根据Id获取
 *
 * @param request 获取请求
 * @param passport 用户护照
 * @return 获取应答
 */
@Override
@Transactional(readOnly = true)
public CollectionGetResponse get(CollectionGetRequest request, Passport passport)
{
    CollectionPO entity = collectionMapper.getById(request.getId(), passport);
    CollectionGetResponse response = new CollectionGetResponse();
    if (entity != null) {
    Collection collection = this.getMapper().map(entity, Collection.class);
    response.setCollection(collection );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询
 *
 * @param request 模糊查询请求
 * @param passport 用户护照
 * @return 模糊查询应答
 */
@Override
@Transactional(readOnly = true)
public CollectionSearchResponse search(CollectionSearchRequest request, Passport passport)
{
    CollectionSearchResponse response = new CollectionSearchResponse();
    List<Collection> modelList = new ArrayList<>();
    Long count = collectionMapper.searchCount(request, passport);

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
        List<CollectionPO> entityList = collectionMapper.search(request, passport);

        for (CollectionPO entity : entityList) {
        Collection collection = this.getMapper().map(entity, Collection.class);
        modelList.add(collection);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询
 *
 * @param request 高级查询请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public CollectionFindResponse find(CollectionFindRequest request, Passport passport)
{
    CollectionFindResponse response = new CollectionFindResponse();
    List<Collection> modelList = new ArrayList<>();
    Long count = collectionMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<CollectionPO> entityList = collectionMapper.find(request, passport);
        for (CollectionPO entity : entityList) {
            Collection collection = this.getMapper().map(entity, Collection.class);
            modelList.add(collection);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}


/**
 * 创建
 *
 * @param request 创建请求
 * @param passport 用户护照
 * @return 创建应答
 */
@Override
public CollectionCreateResponse create(CollectionCreateRequest request, Passport passport)
{
    CollectionPO entity = this.getMapper().map(request, CollectionPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    CollectionCreateResponse response = new CollectionCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity, passport, response);

    if (1 == collectionMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新
 *
 * @param request 更新请求
 * @param passport 用户护照
 * @return 更新应答
 */
@Override
public CollectionUpdateResponse update(CollectionUpdateRequest request, Passport passport)
{
    CollectionPO entity = this.getMapper().map(request, CollectionPO.class);

    CollectionUpdateResponse response = new CollectionUpdateResponse();
    Long result=collectionMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除
 *
 * @param request 删除请求
 * @param passport 用户护照
 * @return 删除应答
 */
@Override
public CollectionDeleteResponse delete(CollectionDeleteRequest request, Passport passport)
{
 CollectionDeleteResponse response = new CollectionDeleteResponse();
     Long result= collectionMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}






    /**
     * 验证对象
     * @param collection 
     * @param passport 用户护照
     */
    private void checkValidate(CollectionPO collection, Passport passport, BaseResponse response) {
        // TODO

    }


}
