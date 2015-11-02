/**
 * @(#)SettingDiseaseManagerImpl.java
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
import com.showcal.platform.dal.SettingDiseaseMapper;
import com.showcal.platform.domain.SettingDisease;
import com.showcal.platform.po.SettingDiseasePO;
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
 * Created by 顾志雄 on 2015-09-15 13:46:50.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSettingDiseaseManager")
public class SettingDiseaseManagerImpl extends BaseManagerImpl implements SettingDiseaseManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SettingDiseaseMapper settingDiseaseMapper;


    /**
     * 根据Id获取疾病特殊情况
     *
     * @param request  获取疾病特殊情况请求
     * @param passport 用户护照
     * @return 获取疾病特殊情况应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingDiseaseGetResponse get(SettingDiseaseGetRequest request, Passport passport) {
        SettingDiseasePO entity = settingDiseaseMapper.getById(request.getId(), passport);
        SettingDiseaseGetResponse response = new SettingDiseaseGetResponse();
        if (entity != null) {
            SettingDisease settingDisease = this.getMapper().map(entity, SettingDisease.class);
            response.setSettingDisease(settingDisease);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 高级查询疾病特殊情况
     *
     * @param request  高级查询疾病特殊情况请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingDiseaseFindResponse find(SettingDiseaseFindRequest request, Passport passport) {
        SettingDiseaseFindResponse response = new SettingDiseaseFindResponse();
        List<SettingDisease> modelList = new ArrayList<>();
        Long count = settingDiseaseMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SettingDiseasePO> entityList = settingDiseaseMapper.find(request, passport);
            for (SettingDiseasePO entity : entityList) {
                SettingDisease settingDisease = this.getMapper().map(entity, SettingDisease.class);
                modelList.add(settingDisease);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有疾病特殊情况列表
     *
     * @param request  获取所有疾病特殊情况列表请求
     * @param passport 用户护照
     * @return 获取所有疾病特殊情况列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingDiseaseGetAllListResponse getAllList(SettingDiseaseGetAllListRequest request, Passport passport) {
        SettingDiseaseGetAllListResponse response = new SettingDiseaseGetAllListResponse();


        List<SettingDiseasePO> entityList = settingDiseaseMapper.getAllList(request, passport);


        List<SettingDisease> modelList = new ArrayList<>();
        for (SettingDiseasePO entity : entityList) {
            SettingDisease settingDisease = this.getMapper().map(entity, SettingDisease.class);
            modelList.add(settingDisease);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }

    /**
     *  查询App所有疾病特殊情况列表
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public SettingDiseaseAppGetAllListResponse getAppAllList(SettingDiseaseAppGetAllListRequest request, Passport passport) {
        SettingDiseaseAppGetAllListResponse response = new SettingDiseaseAppGetAllListResponse();

        List<SettingDiseasePO> entityList = settingDiseaseMapper.getAppAllList(request, passport);

        List<SettingDisease> modelList = new ArrayList<>();
        for (SettingDiseasePO entity : entityList) {
            SettingDisease settingDisease = this.getMapper().map(entity, SettingDisease.class);
            modelList.add(settingDisease);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }

    /**
     * 创建疾病特殊情况
     *
     * @param request  创建疾病特殊情况请求
     * @param passport 用户护照
     * @return 创建疾病特殊情况应答
     */
    @Override
    public SettingDiseaseCreateResponse create(SettingDiseaseCreateRequest request, Passport passport) {
        SettingDiseasePO entity = this.getMapper().map(request, SettingDiseasePO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        SettingDiseaseCreateResponse response = new SettingDiseaseCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == settingDiseaseMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新疾病特殊情况
     *
     * @param request  更新疾病特殊情况请求
     * @param passport 用户护照
     * @return 更新疾病特殊情况应答
     */
    @Override
    public SettingDiseaseUpdateResponse update(SettingDiseaseUpdateRequest request, Passport passport) {
        SettingDiseasePO entity = this.getMapper().map(request, SettingDiseasePO.class);

        SettingDiseaseUpdateResponse response = new SettingDiseaseUpdateResponse();
        Long result = settingDiseaseMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除疾病特殊情况
     *
     * @param request  删除疾病特殊情况请求
     * @param passport 用户护照
     * @return 删除疾病特殊情况应答
     */
    @Override
    public SettingDiseaseDeleteResponse delete(SettingDiseaseDeleteRequest request, Passport passport) {
        SettingDiseaseDeleteResponse response = new SettingDiseaseDeleteResponse();
        Long result = settingDiseaseMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 作废疾病特殊情况
     *
     * @param request  作废疾病特殊情况请求
     * @param passport 用户护照
     * @return 作废疾病特殊情况应答
     */
    @Override
    public SettingDiseaseInactiveResponse inactive(SettingDiseaseInactiveRequest request, Passport passport) {
        SettingDiseaseInactiveResponse response = new SettingDiseaseInactiveResponse();
        Long result = settingDiseaseMapper.inactive(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 激活疾病特殊情况
     *
     * @param request  激活疾病特殊情况请求
     * @param passport 用户护照
     * @return 激活疾病特殊情况应答
     */
    @Override
    public SettingDiseaseActiveResponse active(SettingDiseaseActiveRequest request, Passport passport) {
        SettingDiseaseActiveResponse response = new SettingDiseaseActiveResponse();
        Long result = settingDiseaseMapper.active(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    /**
     * 验证对象
     *
     * @param settingDisease 疾病特殊情况
     * @param passport       用户护照
     */
    private void checkValidate(SettingDiseasePO settingDisease, Passport passport, BaseResponse response) {
        // TODO

    }


}
