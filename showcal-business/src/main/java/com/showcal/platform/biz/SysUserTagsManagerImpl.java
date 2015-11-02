/**
 * @(#)SysUserTagsManagerImpl.java
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
import com.showcal.platform.dal.SysUserTagsMapper;
import com.showcal.platform.domain.SysUserTags;
import com.showcal.platform.po.SysUserTagsPO;
import com.showcal.platform.request.SysUserTagsCreateRequest;
import com.showcal.platform.request.SysUserTagsDeleteRequest;
import com.showcal.platform.request.SysUserTagsGetAllListRequest;
import com.showcal.platform.response.SysUserTagsCreateResponse;
import com.showcal.platform.response.SysUserTagsDeleteResponse;
import com.showcal.platform.response.SysUserTagsGetAllListResponse;
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
 * Created by 顾志雄 on 2015-09-26 18:56:46.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSysUserTagsManager")
public class SysUserTagsManagerImpl extends BaseManagerImpl implements SysUserTagsManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SysUserTagsMapper sysUserTagsMapper;


    /**
     * 获取所有用户标签(贴标签)列表
     *
     * @param request  获取所有用户标签(贴标签)列表请求
     * @param passport 用户护照
     * @return 获取所有用户标签(贴标签)列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserTagsGetAllListResponse getAllList(SysUserTagsGetAllListRequest request, Passport passport) {
        SysUserTagsGetAllListResponse response = new SysUserTagsGetAllListResponse();


        List<SysUserTagsPO> entityList = sysUserTagsMapper.getAllList(request, passport);


        List<SysUserTags> modelList = new ArrayList<>();
        for (SysUserTagsPO entity : entityList) {
            SysUserTags sysUserTags = this.getMapper().map(entity, SysUserTags.class);
            modelList.add(sysUserTags);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建用户标签(贴标签)
     *
     * @param request  创建用户标签(贴标签)请求
     * @param passport 用户护照
     * @return 创建用户标签(贴标签)应答
     */
    @Override
    public SysUserTagsCreateResponse create(SysUserTagsCreateRequest request, Passport passport) {
        SysUserTagsPO entity = this.getMapper().map(request, SysUserTagsPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        SysUserTagsCreateResponse response = new SysUserTagsCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == sysUserTagsMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 删除用户标签(贴标签)
     *
     * @param request  删除用户标签(贴标签)请求
     * @param passport 用户护照
     * @return 删除用户标签(贴标签)应答
     */
    @Override
    public SysUserTagsDeleteResponse delete(SysUserTagsDeleteRequest request, Passport passport) {
        SysUserTagsDeleteResponse response = new SysUserTagsDeleteResponse();
        Long result = sysUserTagsMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 验证对象
     *
     * @param sysUserTags 用户标签(贴标签)
     * @param passport    用户护照
     */
    private void checkValidate(SysUserTagsPO sysUserTags, Passport passport, BaseResponse response) {
        // TODO

    }


}
