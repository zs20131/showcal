/**
 * @(#)OftenEatManagerImpl.java
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
package com.showcal.thermalcontrol.biz;

import com.showcal.cms.svc.Message;
import com.showcal.foundation.service.FoundationService;
import com.showcal.thermalcontrol.dal.OftenEatMapper;
import com.showcal.thermalcontrol.po.OftenEatPO;
import com.showcal.thermalcontrol.request.OftenEatCreateRequest;
import com.showcal.thermalcontrol.request.OftenEatDeleteRequest;
import com.showcal.thermalcontrol.request.OftenEatUpdateRequest;
import com.showcal.thermalcontrol.response.OftenEatCreateResponse;
import com.showcal.thermalcontrol.response.OftenEatDeleteResponse;
import com.showcal.thermalcontrol.response.OftenEatUpdateResponse;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 顾志雄 on 2015-09-23 13:32:27.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolOftenEatManager")
public class OftenEatManagerImpl extends BaseManagerImpl implements OftenEatManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private OftenEatMapper oftenEatMapper;


    /**
     * 创建常吃数据表
     *
     * @param request  创建常吃数据表请求
     * @param passport 用户护照
     * @return 创建常吃数据表应答
     */
    @Override
    public OftenEatCreateResponse create(OftenEatCreateRequest request, Passport passport) {
        OftenEatPO entity = this.getMapper().map(request, OftenEatPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        OftenEatCreateResponse response = new OftenEatCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == oftenEatMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新常吃数据表
     *
     * @param request  更新常吃数据表请求
     * @param passport 用户护照
     * @return 更新常吃数据表应答
     */
    @Override
    public OftenEatUpdateResponse update(OftenEatUpdateRequest request, Passport passport) {
        OftenEatPO entity = this.getMapper().map(request, OftenEatPO.class);

        OftenEatUpdateResponse response = new OftenEatUpdateResponse();
        Long result = oftenEatMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除常吃数据表
     *
     * @param request  删除常吃数据表请求
     * @param passport 用户护照
     * @return 删除常吃数据表应答
     */
    @Override
    public OftenEatDeleteResponse delete(OftenEatDeleteRequest request, Passport passport) {
        OftenEatDeleteResponse response = new OftenEatDeleteResponse();
        Long result = oftenEatMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 验证对象
     *
     * @param oftenEat 常吃数据表
     * @param passport 用户护照
     */
    private void checkValidate(OftenEatPO oftenEat, Passport passport, BaseResponse response) {
        // TODO

    }


}
