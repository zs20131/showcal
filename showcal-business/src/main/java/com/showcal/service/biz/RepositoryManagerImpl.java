/**
 * @(#)RepositoryManagerImpl.java
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
package com.showcal.service.biz;

import com.showcal.cms.svc.Message;
import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.SettingKeywordMapper;
import com.showcal.platform.dal.SettingQuestionTagMapper;
import com.showcal.platform.dal.SettingUserTagMapper;
import com.showcal.platform.domain.SettingKeyword;
import com.showcal.platform.domain.SettingUserTag;
import com.showcal.platform.po.SettingKeywordPO;
import com.showcal.platform.po.SettingQuestionTagPO;
import com.showcal.platform.po.SettingUserTagPO;
import com.showcal.platform.request.SettingDiseaseFindRequest;
import com.showcal.platform.request.SettingKeywordFindRequest;
import com.showcal.platform.request.SettingQuestionTagFindRequest;
import com.showcal.platform.request.SettingUserTagFindRequest;
import com.showcal.service.dal.RepositoryMapper;
import com.showcal.service.domain.MyRepositoryImport;
import com.showcal.service.domain.Repository;
import com.showcal.service.domain.RepositoryImport;
import com.showcal.service.po.RepositoryPO;
import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.showcal.thermalcontrol.domain.FoodImport;
import com.showcal.thermalcontrol.response.FoodListImportResponse;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ServiceRepositoryManager")
public class RepositoryManagerImpl extends BaseManagerImpl implements RepositoryManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private RepositoryMapper repositoryMapper;

    @Autowired
    private SettingQuestionTagMapper settingQuestionTagMapper;

    @Autowired
    private SettingKeywordMapper settingKeywordMapper;

    /**
     * 高级查询知识库
     *
     * @param request  高级查询知识库请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public RepositoryFindResponse find(RepositoryFindRequest request, Passport passport) {
        RepositoryFindResponse response = new RepositoryFindResponse();
        List<Repository> modelList = new ArrayList<>();
        Long count = repositoryMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<RepositoryPO> entityList = repositoryMapper.find(request, passport);
            for (RepositoryPO entity : entityList) {
                Repository repository = this.getMapper().map(entity, Repository.class);
                modelList.add(repository);
            }

        }
        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }


    /**
     * 创建知识库
     *
     * @param request  创建知识库请求
     * @param passport 用户护照
     * @return 创建知识库应答
     */
    @Override
    public RepositoryCreateResponse create(RepositoryCreateRequest request, Passport passport) {
        RepositoryPO entity = this.getMapper().map(request, RepositoryPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);
        if ("SHOWCAL".equals(request.getType())) {
            entity.setSourceUserId(passport.getUserId());
        }

        RepositoryCreateResponse response = new RepositoryCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == repositoryMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新知识库
     *
     * @param request  更新知识库请求
     * @param passport 用户护照
     * @return 更新知识库应答
     */
    @Override
    public RepositoryUpdateResponse update(RepositoryUpdateRequest request, Passport passport) {
        RepositoryPO entity = this.getMapper().map(request, RepositoryPO.class);

        if ("SHOWCAL".equals(request.getType())) {
            entity.setSourceUserId(passport.getUserId());
        }

        RepositoryUpdateResponse response = new RepositoryUpdateResponse();
        Long result = repositoryMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除知识库
     *
     * @param request  删除知识库请求
     * @param passport 用户护照
     * @return 删除知识库应答
     */
    @Override
    public RepositoryDeleteResponse delete(RepositoryDeleteRequest request, Passport passport) {
        RepositoryDeleteResponse response = new RepositoryDeleteResponse();
        Long result = repositoryMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    @Override
    public RepositoryActiveResponse active(RepositoryActiveRequest request, Passport passport) {
        RepositoryActiveResponse response = new RepositoryActiveResponse();
        RepositoryPO entity = repositoryMapper.getById(request.getId(), passport);
        entity.setIsActive(true);
        entity.setActiveDate(new Date());
        Long result = repositoryMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }

    @Override
    public RepositoryInactiveResponse inactive(RepositoryInactiveRequest request, Passport passport) {
        RepositoryInactiveResponse response = new RepositoryInactiveResponse();
        RepositoryPO entity = repositoryMapper.getById(request.getId(), passport);
        entity.setIsActive(false);
        entity.setActiveDate(null);
        Long result = repositoryMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }

    @Override
    public RepositoryToPlatformResponse toPlatform(RepositoryToPlatformRequest request, Passport passport) {
        RepositoryToPlatformResponse response = new RepositoryToPlatformResponse();
        RepositoryPO entity = repositoryMapper.getById(request.getId(), passport);
        entity.setType("PLATFORM");
        Long result = repositoryMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }

    @Override
    public RepositoryToShowcalResponse toShowcal(RepositoryToShowcalRequest request, Passport passport) {
        RepositoryToShowcalResponse response = new RepositoryToShowcalResponse();
        RepositoryPO entity = repositoryMapper.getById(request.getId(), passport);
        entity.setType("SHOWCAL");
        Long result = repositoryMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }

    @Override
    public RepositoryGetForMyResponse getMy(RepositoryGetForMyRequest request, Passport passport) {
        RepositoryGetForMyResponse response = new RepositoryGetForMyResponse();
        List<Repository> modelList = new ArrayList<>();
        Long count = repositoryMapper.findMyCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<RepositoryPO> entityList = repositoryMapper.getMy(request, passport);
            for (RepositoryPO entity : entityList) {
                Repository repository = this.getMapper().map(entity, Repository.class);
                modelList.add(repository);
            }
        }
        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取系统知识库
     * @param request
     * @param passport
     * @return
     */
    @Override
    public RepositorySystemGetResponse getSystemRepository(RepositorySystemGetRequest request, Passport passport) {
        RepositorySystemGetResponse response = new RepositorySystemGetResponse();
        List<Repository> modelList = new ArrayList<>();
        Long count = repositoryMapper.findSystemCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<RepositoryPO> entityList = repositoryMapper.findSystem(request, passport);
            for (RepositoryPO entity : entityList) {
                Repository repository = this.getMapper().map(entity, Repository.class);
                modelList.add(repository);
            }
        }
        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    @Override
    public MyRepositoryTransferResponse transfer(MyRepositoryTransferRequest request, Passport passport) {
        return null;
    }

    @Override
    public RepositoryListImportResponse importList(RepositoryListImportRequest request, Passport passport) {
        DataTable<RepositoryImport> dataTable = request.getDataTable();

        List<RepositoryPO> importList = new ArrayList<>();  // 需要创建的对象集合

        List<Long> result = new LinkedList<>(); // 存储ID的集合
        List<RepositoryImport> beanList = request.getList();   // 取出导入对象的集合
        RepositoryListImportResponse response = new RepositoryListImportResponse(); // 最终的返回结果

        /*批量获取ID*/
        IdsGetRequest idsGetRequest = new IdsGetRequest();
        idsGetRequest.setCount(beanList.size());
        List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

        int index = 0;
        for (RepositoryImport importBean : beanList){
            // 设置
            RepositoryPO entity = this.getMapper().map(importBean, RepositoryPO.class);

            importList.add(entity);
            result.add(ids.get(index)); // 将取到的ID放入返回结果中
            entity.setId(ids.get(index));   //设置ID
            // 设置激活状态
            entity.setIsActive(true);
            entity.setActiveDate(new Date());

            // 设置类型
            entity.setType("PLATFORM");

            // 处理知识库标签
            String tag = entity.getTag().trim();
            SettingQuestionTagFindRequest settingQuestionTagFindRequest = new SettingQuestionTagFindRequest();
            settingQuestionTagFindRequest.setTag(tag);
            List<SettingQuestionTagPO> settingQuestionTagPOs = settingQuestionTagMapper.findByName(settingQuestionTagFindRequest, passport);
            if (settingQuestionTagPOs.size() > 0){
                entity.setTag(settingQuestionTagPOs.get(0).getId().toString());
            }else{
                response.addError(ErrorType.BUSINESS_ERROR,"知识库标签不正确！");
                return response;
            }
            // 处理关键字
            String keyword = entity.getKeyword().trim();
            SettingKeywordFindRequest settingKeywordFindRequest = new SettingKeywordFindRequest();
            settingKeywordFindRequest.setKeyword(keyword);
            List<SettingKeywordPO> settingKeywordPOs = settingKeywordMapper.findByName(settingKeywordFindRequest, passport);
            if (settingKeywordPOs.size() > 0){
                entity.setKeyword(settingKeywordPOs.get(0).getId().toString());
            }else{
                response.addError(ErrorType.BUSINESS_ERROR,"知识库标签不正确！");
                return response;
            }

            index++;
        }

        if (!dataTable.hasError()){
            if (importList.size() > 0){
                repositoryMapper.insertBatch(importList, passport);
            }
        }else {
            response.addErrors(dataTable.getErrorList());
        }

        response.setList(result);
        return response;
    }

    @Override
    public MyRepositoryListImportResponse importMyList(MyRepositoryListImportRequest request, Passport passport) {
        DataTable<MyRepositoryImport> dataTable = request.getDataTable();

        List<RepositoryPO> importList = new ArrayList<>(); // 需要创建的对象集合

        List<Long> result = new LinkedList<>(); // 存储ID的集合
        List<MyRepositoryImport> beanList = request.getList();  // 去除导入对象的集合
        MyRepositoryListImportResponse response = new MyRepositoryListImportResponse(); // 最终的返回结果

        /*批量获取ID*/
        IdsGetRequest idsGetRequest = new IdsGetRequest();
        idsGetRequest.setCount(beanList.size());
        List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

        int index = 0;
        for(MyRepositoryImport importBean : beanList){
            // 设置
            RepositoryPO entity = this.getMapper().map(importBean, RepositoryPO.class);

            importList.add(entity); //
            result.add(ids.get(index)); // 将取到的ID放入返回结果中
            entity.setId(ids.get(index)); // 设置ID
            //设置激活状态
            entity.setIsActive(true);
            entity.setActiveDate(new Date());
            //设置来源
            entity.setSourceUserId(passport.getUserId());
            // 设置类型
            entity.setType("SHOWCAL");

            // 处理知识库标签
            String tag = entity.getTag().trim();
            SettingQuestionTagFindRequest settingQuestionTagFindRequest = new SettingQuestionTagFindRequest();
            settingQuestionTagFindRequest.setTag(tag);
            List<SettingQuestionTagPO> settingQuestionTagPOs = settingQuestionTagMapper.findByName(settingQuestionTagFindRequest, passport);
            if (settingQuestionTagPOs.size() > 0){
                entity.setTag(settingQuestionTagPOs.get(0).getId().toString());
            }else{
                response.addError(ErrorType.BUSINESS_ERROR, "知识库标签不正确！");
                return response;
            }
            // 处理关键字
            String keyword = entity.getKeyword().trim();
            SettingKeywordFindRequest settingKeywordFindRequest = new SettingKeywordFindRequest();
            settingKeywordFindRequest.setKeyword(keyword);
            List<SettingKeywordPO> settingKeywordPOs = settingKeywordMapper.findByName(settingKeywordFindRequest, passport);
            if (settingKeywordPOs.size() > 0){
                entity.setKeyword(settingKeywordPOs.get(0).getId().toString());
            }else{
                response.addError(ErrorType.BUSINESS_ERROR,"知识库标签不正确！");
                return response;
            }


            index++;
        }

        if (!dataTable.hasError()){
            if (importList.size() > 0){
                repositoryMapper.insertBatch(importList, passport);
            }
        }else{
            response.addErrors(dataTable.getErrorList());
        }

        response.setList(result);
        return response;
    }

    /**
     * 验证对象
     *
     * @param repository 知识库
     * @param passport   用户护照
     */
    private void checkValidate(RepositoryPO repository, Passport passport, BaseResponse response) {
        // TODO

    }


}
