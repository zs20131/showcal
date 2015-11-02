/**
 * @(#)ClazzManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
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
import com.showcal.merchandise.dal.ClazzMapper;
import com.showcal.merchandise.po.ClazzPO;
import com.showcal.foundation.service.FoundationService;
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
@Service("MerchandiseClazzManager")
public class ClazzManagerImpl extends BaseManagerImpl implements ClazzManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private ClazzMapper clazzMapper;


    /**
     * 根据Id获取商品类别
     *
     * @param request 获取商品类别请求
     * @param passport 用户护照
     * @return 获取商品类别应答
     */
    @Override
    @Transactional(readOnly = true)
    public ClazzGetResponse get(ClazzGetRequest request, Passport passport) {
        ClazzPO entity = clazzMapper.getById(request.getId(), passport);
        ClazzGetResponse response = new ClazzGetResponse();
        if (entity != null) {
            Clazz clazz = this.getMapper().map(entity, Clazz.class);
            response.setClazz(clazz);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询商品类别
     *
     * @param request 模糊查询商品类别请求
     * @param passport 用户护照
     * @return 模糊查询商品类别应答
     */
    @Override
    @Transactional(readOnly = true)
    public ClazzSearchResponse search(ClazzSearchRequest request, Passport passport) {
        ClazzSearchResponse response = new ClazzSearchResponse();
        List<Clazz> modelList = new ArrayList<>();
        Long count = clazzMapper.searchCount(request, passport);

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
            List<ClazzPO> entityList = clazzMapper.search(request, passport);

            for (ClazzPO entity : entityList) {
                Clazz clazz = this.getMapper().map(entity, Clazz.class);
                modelList.add(clazz);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询商品类别
     *
     * @param request 高级查询商品类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public ClazzFindResponse find(ClazzFindRequest request, Passport passport) {
        ClazzFindResponse response = new ClazzFindResponse();
        List<Clazz> modelList = new ArrayList<>();
        Long count = clazzMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<ClazzPO> entityList = clazzMapper.find(request, passport);
            for (ClazzPO entity : entityList) {
                Clazz clazz = this.getMapper().map(entity, Clazz.class);
                modelList.add(clazz);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有商品类别列表
     *
     * @param request 获取所有商品类别列表请求
     * @param passport 用户护照
     * @return 获取所有商品类别列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public ClazzGetAllListResponse getAllList(ClazzGetAllListRequest request, Passport passport) {
        ClazzGetAllListResponse response = new ClazzGetAllListResponse();


        List<ClazzPO> entityList = clazzMapper.getAllList(request, passport);


        List<Clazz> modelList = new ArrayList<>();
        for (ClazzPO entity : entityList) {
            Clazz clazz = this.getMapper().map(entity, Clazz.class);
            modelList.add(clazz);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建商品类别
     *
     * @param request 创建商品类别请求
     * @param passport 用户护照
     * @return 创建商品类别应答
     */
    @Override
    public ClazzCreateResponse create(ClazzCreateRequest request, Passport passport) {
//        List<Long> ids=new ArrayList<>();
//        ClazzCreateResponse response = new ClazzCreateResponse();
//        ClazzFindRequest findRequest = new ClazzFindRequest();
//        findRequest.setPageSize(0);
//        ClazzFindResponse clazzFindResponse= this.find(findRequest, passport);
//        List<Clazz> newList = clazzFindResponse.getResult();
//
//        List<Long> existIdList = new ArrayList<>();
//        for(Clazz clazz : newList) {
//            existIdList.add(clazz.getId());
//        }
//        if (request.getClazzUpdateRequestList() != null && request.getClazzUpdateRequestList().size() > 0) {
//            // 更新
//            List<Long> updateIdList = new ArrayList<>();
//            // 新添加的数据
//            List<ClazzPO> createList = new ArrayList<>();
//            // 要删除的数据
//            List<Long> deleteIdList = new ArrayList<>();
//
//            for (ClazzUpdateRequest clazzUpdateRequest : request.getClazzUpdateRequestList()) {
//                if (clazzUpdateRequest.getId() != null) {
//                    updateIdList.add(clazzUpdateRequest.getId());
//                    clazzMapper.update(this.getMapper().map(clazzUpdateRequest, ClazzPO.class), passport);
//                } else {
//                    ClazzPO clazzPO = this.getMapper().map(clazzUpdateRequest, ClazzPO.class);
//                    clazzPO.setId(foundationService.getNewId());
//                    createList.add(clazzPO);
//                    ids.add(clazzPO.getId());
//                }
//            }
//
//            for (Long id : existIdList) {
//                if (!updateIdList.contains(id)) {
//                    deleteIdList.add(id);
//                }
//            }
//
//            if (createList.size() > 0) {
//                clazzMapper.insertBatch(createList, passport);
//            }
//            if (deleteIdList.size() > 0) {
//                clazzMapper.deleteBatch(deleteIdList, passport);
//            }
//        } else {
//            clazzMapper.deleteBatch(existIdList, passport);
//        }
//        response.setId(ids);return response;
        ClazzPO entity = this.getMapper().map(request, ClazzPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        ClazzCreateResponse response = new ClazzCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity,passport,response);

        if (1 == clazzMapper.insert(entity, passport)) {
            response.setId(id);
        }
        else
        {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新商品类别
     *
     * @param request 更新商品类别请求
     * @param passport 用户护照
     * @return 更新商品类别应答
     */
    @Override
    public ClazzUpdateResponse update(ClazzUpdateRequest request, Passport passport) {
        ClazzPO entity = this.getMapper().map(request, ClazzPO.class);

        ClazzUpdateResponse response = new ClazzUpdateResponse();
        Long result = clazzMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除商品类别
     *
     * @param request 删除商品类别请求
     * @param passport 用户护照
     * @return 删除商品类别应答
     */
    @Override
    public ClazzDeleteResponse delete(ClazzDeleteRequest request, Passport passport) {
        ClazzDeleteResponse response = new ClazzDeleteResponse();
        Long result = clazzMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 导入商品类别
     *
     * @param request 导入商品类别请求
     * @param passport 用户护照
     * @return 导入商品类别应答
     */
    @Override
    public ClazzListImportResponse importList(ClazzListImportRequest request, Passport passport) {
        DataTable<ClazzImport> dataTable = request.getDataTable();

        List<ClazzPO> importList = new ArrayList<>();            //需要创建的对象的集合

        List<Long> result = new LinkedList<>();                    //存储ID的集合
        List<ClazzImport> beanList = request.getList();            //取出导入对象的集合
        ClazzListImportResponse response = new ClazzListImportResponse();//最终的返回结果

    /* 批量获取ID */
        IdsGetRequest idsGetRequest = new IdsGetRequest();
        idsGetRequest.setCount(beanList.size());
        List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

        int index = 0;
        for (ClazzImport importBean : beanList) {
            // 设置
            ClazzPO entity = this.getMapper().map(importBean, ClazzPO.class);


            importList.add(entity);
            result.add(ids.get(index));         //将取到的ID放入返回结果中
            entity.setId(ids.get(index));       //设置ID

            index++;
        }

        if (!dataTable.hasError()) {
            if (importList.size() > 0) {
                clazzMapper.insertBatch(importList, passport);
            }
        } else {
            // response.setDataTable(dataTable);
            response.addErrors(dataTable.getErrorList());
        }

        response.setList(result);
        return response;

    }

    @Override
    public ClazzCreateListResponse createList(ClazzCreateListRequest request, Passport passport) {
        List<Long> ids=new ArrayList<>();
        ClazzCreateListResponse response=new ClazzCreateListResponse();
        for(ClazzCreateRequest clazzCreateRequest:request.getClazzCreateRequests()){
         ClazzCreateResponse clazzCreateResponse=   this.create(clazzCreateRequest,passport);
        ids.add(clazzCreateResponse.getId());
        }
        response.setId(ids);
        return response;
    }

    /**
     * 验证对象
     * @param clazz 商品类别
     * @param passport 用户护照
     */
    private void checkValidate(ClazzPO clazz, Passport passport, BaseResponse response) {
        // TODO

    }


}
