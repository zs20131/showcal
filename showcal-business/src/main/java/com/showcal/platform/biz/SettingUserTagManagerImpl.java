/**
 * @(#)SettingUserTagManagerImpl.java
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
import com.showcal.platform.dal.SettingUserTagMapper;
import com.showcal.platform.domain.SettingUserTag;
import com.showcal.platform.po.SettingUserTagPO;
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
@Service("PlatfromSettingUserTagManager")
public class SettingUserTagManagerImpl extends BaseManagerImpl implements SettingUserTagManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SettingUserTagMapper settingUserTagMapper;


    /**
     * 根据Id获取用户标签
     *
     * @param request  获取用户标签请求
     * @param passport 用户护照
     * @return 获取用户标签应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingUserTagGetResponse get(SettingUserTagGetRequest request, Passport passport) {
        SettingUserTagPO entity = settingUserTagMapper.getById(request.getId(), passport);
        SettingUserTagGetResponse response = new SettingUserTagGetResponse();
        if (entity != null) {
            SettingUserTag settingUserTag = this.getMapper().map(entity, SettingUserTag.class);
            response.setSettingUserTag(settingUserTag);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 高级查询用户标签
     *
     * @param request  高级查询用户标签请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingUserTagFindResponse find(SettingUserTagFindRequest request, Passport passport) {
        SettingUserTagFindResponse response = new SettingUserTagFindResponse();
        List<SettingUserTag> modelList = new ArrayList<SettingUserTag>();
        Long count = settingUserTagMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SettingUserTagPO> entityList = settingUserTagMapper.find(request, passport);
            for (SettingUserTagPO entity : entityList) {
                SettingUserTag settingUserTag = this.getMapper().map(entity, SettingUserTag.class);
                modelList.add(settingUserTag);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有用户标签列表
     *
     * @param request  获取所有用户标签列表请求
     * @param passport 用户护照
     * @return 获取所有用户标签列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SettingUserTagGetAllListResponse getAllList(SettingUserTagGetAllListRequest request, Passport passport) {
        SettingUserTagGetAllListResponse response = new SettingUserTagGetAllListResponse();


        List<SettingUserTagPO> entityList = settingUserTagMapper.getAllList(request, passport);


        List<SettingUserTag> modelList = new ArrayList<SettingUserTag>();
        for (SettingUserTagPO entity : entityList) {
            SettingUserTag settingUserTag = this.getMapper().map(entity, SettingUserTag.class);
            modelList.add(settingUserTag);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建用户标签
     *
     * @param request  创建用户标签请求
     * @param passport 用户护照
     * @return 创建用户标签应答
     */
    @Override
    public SettingUserTagCreateResponse create(SettingUserTagCreateRequest request, Passport passport) {
        SettingUserTagPO entity = this.getMapper().map(request, SettingUserTagPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        SettingUserTagCreateResponse response = new SettingUserTagCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == settingUserTagMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新用户标签
     *
     * @param request  更新用户标签请求
     * @param passport 用户护照
     * @return 更新用户标签应答
     */
    @Override
    public SettingUserTagUpdateResponse update(SettingUserTagUpdateRequest request, Passport passport) {
        SettingUserTagPO entity = this.getMapper().map(request, SettingUserTagPO.class);

        SettingUserTagUpdateResponse response = new SettingUserTagUpdateResponse();
        Long result = settingUserTagMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除用户标签
     *
     * @param request  删除用户标签请求
     * @param passport 用户护照
     * @return 删除用户标签应答
     */
    @Override
    public SettingUserTagDeleteResponse delete(SettingUserTagDeleteRequest request, Passport passport) {
        SettingUserTagDeleteResponse response = new SettingUserTagDeleteResponse();
        Long result = settingUserTagMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 作废用户标签
     *
     * @param request  作废用户标签请求
     * @param passport 用户护照
     * @return 作废用户标签应答
     */
    @Override
    public SettingUserTagInactiveResponse inactive(SettingUserTagInactiveRequest request, Passport passport) {
        SettingUserTagInactiveResponse response = new SettingUserTagInactiveResponse();
        Long result = settingUserTagMapper.inactive(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 激活用户标签
     *
     * @param request  激活用户标签请求
     * @param passport 用户护照
     * @return 激活用户标签应答
     */
    @Override
    public SettingUserTagActiveResponse active(SettingUserTagActiveRequest request, Passport passport) {
        SettingUserTagActiveResponse response = new SettingUserTagActiveResponse();
        Long result = settingUserTagMapper.active(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    /**
     * 验证对象
     *
     * @param settingUserTag 用户标签
     * @param passport       用户护照
     */
    private void checkValidate(SettingUserTagPO settingUserTag, Passport passport, BaseResponse response) {
        // TODO

    }


}
