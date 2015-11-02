/**
 * @(#)SettingKeywordManagerImpl.java
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
import com.showcal.platform.dal.SettingKeywordMapper;
import com.showcal.platform.domain.SettingKeyword;
import com.showcal.platform.po.SettingKeywordPO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSettingKeywordManager")
public class SettingKeywordManagerImpl extends BaseManagerImpl implements SettingKeywordManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SettingKeywordMapper settingKeywordMapper;


    /**
     * 根据Id获取关键字
     *
     * @param request  获取关键字请求
     * @param passport 用户护照
     * @return 获取关键字应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingKeywordGetResponse get(SettingKeywordGetRequest request, Passport passport) {
        SettingKeywordPO entity = settingKeywordMapper.getById(request.getId(), passport);
        SettingKeywordGetResponse response = new SettingKeywordGetResponse();
        if (entity != null) {
            SettingKeyword settingKeyword = this.getMapper().map(entity, SettingKeyword.class);
            response.setSettingKeyword(settingKeyword);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }

    /**
     * 高级查询关键字
     *
     * @param request  高级查询关键字请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingKeywordFindResponse find(SettingKeywordFindRequest request, Passport passport) {
        SettingKeywordFindResponse response = new SettingKeywordFindResponse();
        List<SettingKeyword> modelList = new ArrayList<SettingKeyword>();
        Long count = settingKeywordMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SettingKeywordPO> entityList = settingKeywordMapper.find(request, passport);
            for (SettingKeywordPO entity : entityList) {
                SettingKeyword settingKeyword = this.getMapper().map(entity, SettingKeyword.class);
                modelList.add(settingKeyword);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有关键字列表
     *
     * @param request  获取所有关键字列表请求
     * @param passport 用户护照
     * @return 获取所有关键字列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingKeywordGetAllListResponse getAllList(SettingKeywordGetAllListRequest request, Passport passport) {
        SettingKeywordGetAllListResponse response = new SettingKeywordGetAllListResponse();


        List<SettingKeywordPO> entityList = settingKeywordMapper.getAllList(request, passport);


        List<SettingKeyword> modelList = new ArrayList<SettingKeyword>();
        for (SettingKeywordPO entity : entityList) {
            SettingKeyword settingKeyword = this.getMapper().map(entity, SettingKeyword.class);
            modelList.add(settingKeyword);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建关键字
     *
     * @param request  创建关键字请求
     * @param passport 用户护照
     * @return 创建关键字应答
     */
    @Override
    public SettingKeywordCreateResponse create(SettingKeywordCreateRequest request, Passport passport) {
        SettingKeywordPO entity = this.getMapper().map(request, SettingKeywordPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);
        if("".equals(entity.getParentKeyword().trim())){
            entity.setParentKeyword(null);
        }
        SettingKeywordCreateResponse response = new SettingKeywordCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);
        if(response.hasError()){
            return response;
        }
        if (1 == settingKeywordMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新关键字
     *
     * @param request  更新关键字请求
     * @param passport 用户护照
     * @return 更新关键字应答
     */
    @Override
    public SettingKeywordUpdateResponse update(SettingKeywordUpdateRequest request, Passport passport) {
        SettingKeywordPO entity = this.getMapper().map(request, SettingKeywordPO.class);
        if (entity.getParentKeyword() != null){
            if("".equals(entity.getParentKeyword().trim())){
                entity.setParentKeyword(null);
            }
        }
        SettingKeywordUpdateResponse response = new SettingKeywordUpdateResponse();
        checkValidate(entity, passport, response);
        if(response.hasError()){
            return response;
        }
        Long result = settingKeywordMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除关键字
     *
     * @param request  删除关键字请求
     * @param passport 用户护照
     * @return 删除关键字应答
     */
    @Override
    public SettingKeywordDeleteResponse delete(SettingKeywordDeleteRequest request, Passport passport) {
        SettingKeywordDeleteResponse response = new SettingKeywordDeleteResponse();
        SettingKeywordPO settingKeywordPO=settingKeywordMapper.getById(request.getId(),passport);
        Long result = settingKeywordMapper.delete(request.getId(), passport);

        response.setResult(result);
        return response;
    }


    /**
     * 作废关键字
     *
     * @param request  作废关键字请求
     * @param passport 用户护照
     * @return 作废关键字应答
     */
    @Override
    public SettingKeywordInactiveResponse inactive(SettingKeywordInactiveRequest request, Passport passport) {
        SettingKeywordInactiveResponse response = new SettingKeywordInactiveResponse();
        Long result = settingKeywordMapper.inactive(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 激活关键字
     *
     * @param request  激活关键字请求
     * @param passport 用户护照
     * @return 激活关键字应答
     */
    @Override
    public SettingKeywordActiveResponse active(SettingKeywordActiveRequest request, Passport passport) {
        SettingKeywordActiveResponse response = new SettingKeywordActiveResponse();
        Long result = settingKeywordMapper.active(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    /**
     * 获取所有关键字
     * @return
     */
    @Override
    public List<String> getAllKeyword(Passport passport) {
        // 查看缓存是否存在
        SettingKeywordGetAllListRequest request = new SettingKeywordGetAllListRequest();
        List<SettingKeywordPO> entityList = settingKeywordMapper.getAllList(request, passport);
        List<String> keywordlist = new ArrayList<>();
        for(SettingKeywordPO settingKeywordPO:entityList){
            keywordlist.add(settingKeywordPO.getKeyword());
        }
        return keywordlist;
    }

    @Override
    public Long getIdByKeyword(String keyword,Passport passport) {
        SettingKeywordGetAllListRequest request = new SettingKeywordGetAllListRequest();
        List<SettingKeywordPO> entityList = settingKeywordMapper.getAllList(request, passport);
        Map<String,Long> keywordMap = new HashMap<>();
        for(SettingKeywordPO settingKeywordPO:entityList){
            keywordMap.put(settingKeywordPO.getKeyword(),settingKeywordPO.getId());
        }
        return keywordMap.get(keyword);
    }

    /**
     * 验证对象
     *
     * @param settingKeyword 关键字
     * @param passport       用户护照
     */
    private void checkValidate(SettingKeywordPO settingKeyword, Passport passport, BaseResponse response) {
        Long iskey = settingKeywordMapper.existByKeyword(settingKeyword.getId(),settingKeyword.getKeyword(),passport);
        if(iskey>0){
            response.addError(ErrorType.BUSINESS_ERROR,"关键字已存在，请检查");
        }
    }


}
