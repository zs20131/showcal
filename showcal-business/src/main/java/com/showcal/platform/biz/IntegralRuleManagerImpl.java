/**
 * @(#)IntegralRuleManagerImpl.java
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
import com.showcal.platform.dal.IntegralRuleMapper;
import com.showcal.platform.domain.IntegralRule;
import com.showcal.platform.po.IntegralRulePO;
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
 * Created by 顾志雄 on 2015-09-17 11:08:00.
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromIntegralRuleManager")
public class IntegralRuleManagerImpl extends BaseManagerImpl implements IntegralRuleManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private IntegralRuleMapper integralRuleMapper;


/**
 * 根据Id获取积分规则
 *
 * @param request 获取积分规则请求
 * @param passport 用户护照
 * @return 获取积分规则应答
 */
@Override
@Transactional(readOnly = true)
public IntegralRuleGetResponse get(IntegralRuleGetRequest request, Passport passport)
{
    IntegralRulePO entity = integralRuleMapper.getById(request.getId(), passport);
    IntegralRuleGetResponse response = new IntegralRuleGetResponse();
    if (entity != null) {
    IntegralRule integralRule = this.getMapper().map(entity, IntegralRule.class);
    response.setIntegralRule(integralRule );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 获取所有积分规则列表
 *
 * @param request 获取所有积分规则列表请求
 * @param passport 用户护照
 * @return 获取所有积分规则列表应答
 */
@Override
@Transactional(readOnly = true)
public IntegralRuleGetAllListResponse getAllList(IntegralRuleGetAllListRequest request, Passport passport)
{
    IntegralRuleGetAllListResponse response = new IntegralRuleGetAllListResponse();


    List<IntegralRulePO> entityList = integralRuleMapper.getAllList(request, passport);


    List<IntegralRule> modelList = new ArrayList<>();
    for (IntegralRulePO entity : entityList) {
    IntegralRule integralRule = this.getMapper().map(entity, IntegralRule.class);
    modelList.add(integralRule);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}


/**
 * 创建积分规则
 *
 * @param request 创建积分规则请求
 * @param passport 用户护照
 * @return 创建积分规则应答
 */
@Override
public IntegralRuleCreateResponse create(IntegralRuleCreateRequest request, Passport passport)
{
    IntegralRulePO entity = this.getMapper().map(request, IntegralRulePO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    IntegralRuleCreateResponse response = new IntegralRuleCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == integralRuleMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新积分规则
 *
 * @param request 更新积分规则请求
 * @param passport 用户护照
 * @return 更新积分规则应答
 */
@Override
public IntegralRuleUpdateResponse update(IntegralRuleUpdateRequest request, Passport passport)
{
    IntegralRulePO entity = this.getMapper().map(request, IntegralRulePO.class);

    IntegralRuleUpdateResponse response = new IntegralRuleUpdateResponse();
    Long result=integralRuleMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除积分规则
 *
 * @param request 删除积分规则请求
 * @param passport 用户护照
 * @return 删除积分规则应答
 */
@Override
public IntegralRuleDeleteResponse delete(IntegralRuleDeleteRequest request, Passport passport)
{
 IntegralRuleDeleteResponse response = new IntegralRuleDeleteResponse();
     Long result= integralRuleMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}

    /**
     * 高级查询积分规则
     *
     * @param request 高级查询积分规则请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public IntegralRuleFindResponse find(IntegralRuleFindRequest request, Passport passport)
    {
        IntegralRuleFindResponse response = new IntegralRuleFindResponse();
        List<IntegralRule> modelList = new ArrayList<>();
        Long count = integralRuleMapper.findCount(request, passport);
        if (count >0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<IntegralRulePO> entityList = integralRuleMapper.find(request, passport);
            for (IntegralRulePO entity : entityList) {
                IntegralRule integralRule = this.getMapper().map(entity, IntegralRule.class);
                modelList.add(integralRule);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }




    /**
     * 验证对象
     * @param integralRule 积分规则
     * @param passport 用户护照
     */
    private void checkValidate(IntegralRulePO integralRule, Passport passport, BaseResponse response) {
        // TODO

    }


}
