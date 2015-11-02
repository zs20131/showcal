/**
 * @(#)SettingQuestionTagManagerImpl.java
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
import com.showcal.platform.dal.SettingQuestionTagMapper;
import com.showcal.platform.domain.SettingQuestionTag;
import com.showcal.platform.po.SettingQuestionTagPO;
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
 * Created by 顾志雄 on 2015-09-15 13:46:51.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSettingQuestionTagManager")
public class SettingQuestionTagManagerImpl extends BaseManagerImpl implements SettingQuestionTagManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SettingQuestionTagMapper settingQuestionTagMapper;


    /**
     * 根据Id获取问题标签
     *
     * @param request  获取问题标签请求
     * @param passport 用户护照
     * @return 获取问题标签应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingQuestionTagGetResponse get(SettingQuestionTagGetRequest request, Passport passport) {
        SettingQuestionTagPO entity = settingQuestionTagMapper.getById(request.getId(), passport);
        SettingQuestionTagGetResponse response = new SettingQuestionTagGetResponse();
        if (entity != null) {
            SettingQuestionTag settingQuestionTag = this.getMapper().map(entity, SettingQuestionTag.class);
            response.setSettingQuestionTag(settingQuestionTag);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 高级查询问题标签
     *
     * @param request  高级查询问题标签请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingQuestionTagFindResponse find(SettingQuestionTagFindRequest request, Passport passport) {
        SettingQuestionTagFindResponse response = new SettingQuestionTagFindResponse();
        List<SettingQuestionTag> modelList = new ArrayList<SettingQuestionTag>();
        Long count = settingQuestionTagMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SettingQuestionTagPO> entityList = settingQuestionTagMapper.find(request, passport);
            for (SettingQuestionTagPO entity : entityList) {
                SettingQuestionTag settingQuestionTag = this.getMapper().map(entity, SettingQuestionTag.class);
                modelList.add(settingQuestionTag);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有问题标签列表
     *
     * @param request  获取所有问题标签列表请求
     * @param passport 用户护照
     * @return 获取所有问题标签列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingQuestionTagGetAllListResponse getAllList(SettingQuestionTagGetAllListRequest request, Passport passport) {
        SettingQuestionTagGetAllListResponse response = new SettingQuestionTagGetAllListResponse();


        List<SettingQuestionTagPO> entityList = settingQuestionTagMapper.getAllList(request, passport);


        List<SettingQuestionTag> modelList = new ArrayList<SettingQuestionTag>();
        for (SettingQuestionTagPO entity : entityList) {
            SettingQuestionTag settingQuestionTag = this.getMapper().map(entity, SettingQuestionTag.class);
            modelList.add(settingQuestionTag);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建问题标签
     *
     * @param request  创建问题标签请求
     * @param passport 用户护照
     * @return 创建问题标签应答
     */
    @Override
    public SettingQuestionTagCreateResponse create(SettingQuestionTagCreateRequest request, Passport passport) {
        SettingQuestionTagPO entity = this.getMapper().map(request, SettingQuestionTagPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        SettingQuestionTagCreateResponse response = new SettingQuestionTagCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == settingQuestionTagMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新问题标签
     *
     * @param request  更新问题标签请求
     * @param passport 用户护照
     * @return 更新问题标签应答
     */
    @Override
    public SettingQuestionTagUpdateResponse update(SettingQuestionTagUpdateRequest request, Passport passport) {
        SettingQuestionTagPO entity = this.getMapper().map(request, SettingQuestionTagPO.class);

        SettingQuestionTagUpdateResponse response = new SettingQuestionTagUpdateResponse();
        Long result = settingQuestionTagMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除问题标签
     *
     * @param request  删除问题标签请求
     * @param passport 用户护照
     * @return 删除问题标签应答
     */
    @Override
    public SettingQuestionTagDeleteResponse delete(SettingQuestionTagDeleteRequest request, Passport passport) {
        SettingQuestionTagDeleteResponse response = new SettingQuestionTagDeleteResponse();
        Long result = settingQuestionTagMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 作废问题标签
     *
     * @param request  作废问题标签请求
     * @param passport 用户护照
     * @return 作废问题标签应答
     */
    @Override
    public SettingQuestionTagInactiveResponse inactive(SettingQuestionTagInactiveRequest request, Passport passport) {
        SettingQuestionTagInactiveResponse response = new SettingQuestionTagInactiveResponse();
        Long result = settingQuestionTagMapper.inactive(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 激活问题标签
     *
     * @param request  激活问题标签请求
     * @param passport 用户护照
     * @return 激活问题标签应答
     */
    @Override
    public SettingQuestionTagActiveResponse active(SettingQuestionTagActiveRequest request, Passport passport) {
        SettingQuestionTagActiveResponse response = new SettingQuestionTagActiveResponse();
        Long result = settingQuestionTagMapper.active(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    /**
     * 验证对象
     *
     * @param settingQuestionTag 问题标签
     * @param passport           用户护照
     */
    private void checkValidate(SettingQuestionTagPO settingQuestionTag, Passport passport, BaseResponse response) {
        // TODO

    }


}
