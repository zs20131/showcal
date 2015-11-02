/**
 * @(#)SysUserExtentManagerImpl.java
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
import com.showcal.platform.dal.SysUserExtentMapper;
import com.showcal.platform.domain.SysUserExtent;
import com.showcal.platform.po.SysUserExtentPO;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.DecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSysUserExtentManager")
public class SysUserExtentManagerImpl extends BaseManagerImpl implements SysUserExtentManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SysUserExtentMapper sysUserExtentMapper;


    /**
     * 根据Id获取用户扩展
     *
     * @param request  获取用户扩展请求
     * @param passport 用户护照
     * @return 获取用户扩展应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserExtentGetResponse get(SysUserExtentGetRequest request, Passport passport) {
        SysUserExtentPO entity = sysUserExtentMapper.getById(request.getId(), passport);
        SysUserExtentGetResponse response = new SysUserExtentGetResponse();
        if (entity != null) {
            SysUserExtent sysUserExtent = this.getMapper().map(entity, SysUserExtent.class);
            response.setSysUserExtent(sysUserExtent);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询用户扩展
     *
     * @param request  模糊查询用户扩展请求
     * @param passport 用户护照
     * @return 模糊查询用户扩展应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserExtentSearchResponse search(SysUserExtentSearchRequest request, Passport passport) {
        SysUserExtentSearchResponse response = new SysUserExtentSearchResponse();
        List<SysUserExtent> modelList = new ArrayList<>();
        Long count = sysUserExtentMapper.searchCount(request, passport);

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
            List<SysUserExtentPO> entityList = sysUserExtentMapper.search(request, passport);

            for (SysUserExtentPO entity : entityList) {
                SysUserExtent sysUserExtent = this.getMapper().map(entity, SysUserExtent.class);
                modelList.add(sysUserExtent);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }


    /**
     * 创建用户扩展
     *
     * @param request  创建用户扩展请求
     * @param passport 用户护照
     * @return 创建用户扩展应答
     */
    @Override
    public SysUserExtentCreateResponse create(SysUserExtentCreateRequest request, Passport passport) {
        SysUserExtentPO entity = this.getMapper().map(request, SysUserExtentPO.class);
        SysUserExtentCreateResponse response = new SysUserExtentCreateResponse();
        /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);
        if (response.hasError()) {
            return response;
        }
        if (1 == sysUserExtentMapper.insert(entity, passport)) {
            response.setId(entity.getId());
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新用户扩展
     *
     * @param request  更新用户扩展请求
     * @param passport 用户护照
     * @return 更新用户扩展应答
     */
    @Override
    public SysUserExtentUpdateResponse update(SysUserExtentUpdateRequest request, Passport passport) {
        SysUserExtentPO entity = this.getMapper().map(request, SysUserExtentPO.class);
        SysUserExtentUpdateResponse response = new SysUserExtentUpdateResponse();
        checkValidate(entity, passport, response);
        if (response.hasError()) {
            return response;
        }
        Long result = sysUserExtentMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除用户扩展
     *
     * @param request  删除用户扩展请求
     * @param passport 用户护照
     * @return 删除用户扩展应答
     */
    @Override
    public SysUserExtentDeleteResponse delete(SysUserExtentDeleteRequest request, Passport passport) {
        SysUserExtentDeleteResponse response = new SysUserExtentDeleteResponse();
        Long result = sysUserExtentMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    @Override
    public SysUserExtentGetByIdsResponse getUserExtentByIds(SysUserExtentGetByIdsRequest request, Passport passport) {
        SysUserExtentGetByIdsResponse response = new SysUserExtentGetByIdsResponse();
        if(request.getIds()==null||request.getIds().isEmpty()){
            return response;
        }
        List<SysUserExtentPO> sysUserExtentPOs = sysUserExtentMapper.getListByIds(request.getIds(),passport);
        List<SysUserExtent> sysUserExtents = new ArrayList<>();
        if(sysUserExtentPOs==null||sysUserExtentPOs.isEmpty()){
            return response;
        }
        for(SysUserExtentPO sysUserExtentPO:sysUserExtentPOs){
            SysUserExtent userExtent = this.getMapper().map(sysUserExtentPO,SysUserExtent.class);
            sysUserExtents.add(userExtent);
        }
        response.setResult(sysUserExtents);
        response.setTotalCount(sysUserExtents.size());
        return response;
    }


    /**
     * 验证对象
     *
     * @param sysUserExtent 用户扩展
     * @param passport      用户护照
     */
    private void checkValidate(SysUserExtentPO sysUserExtent, Passport passport, BaseResponse response) {
        // 计算BMI值
        if (sysUserExtent.getHeight() != null && sysUserExtent.getHeight() > 0 && sysUserExtent.getWeight() != null && sysUserExtent.getWeight() > 0) {
            Double weight = sysUserExtent.getWeight();
            Integer height = sysUserExtent.getHeight();
            sysUserExtent.setBmi(DecimalUtil.round(weight/(height*height),2));
        }
    }
}
