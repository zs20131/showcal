/**
 * @(#)SysSmsManagerImpl.java
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
import com.showcal.foundation.request.SmsCreateRequest;
import com.showcal.foundation.request.SmsDeleteRequest;
import com.showcal.foundation.request.SmsFindRequest;
import com.showcal.foundation.request.SmsGetRequest;
import com.showcal.foundation.response.SmsCreateResponse;
import com.showcal.foundation.response.SmsDeleteResponse;
import com.showcal.foundation.response.SmsFindResponse;
import com.showcal.foundation.response.SmsGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.SysSmsMapper;
import com.showcal.platform.domain.SysSms;
import com.showcal.platform.po.SysSmsPO;
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
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSysSmsManager")
public class SysSmsManagerImpl extends BaseManagerImpl implements SysSmsManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SysSmsMapper sysSmsMapper;


/**
 * 根据Id获取短信通知表
 *
 * @param request 获取短信通知表请求
 * @param passport 用户护照
 * @return 获取短信通知表应答
 */
@Override
@Transactional(readOnly = true)
public SmsGetResponse get(SmsGetRequest request, Passport passport)
{
    SysSmsPO entity = sysSmsMapper.getById(request.getId(), passport);
    SmsGetResponse response = new SmsGetResponse();
    if (entity != null) {
    SysSms sysSms = this.getMapper().map(entity, SysSms.class);
    response.setSysSms(sysSms);
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}




/**
 * 高级查询短信通知表
 *
 * @param request 高级查询短信通知表请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public SmsFindResponse find(SmsFindRequest request, Passport passport)
{
    SmsFindResponse response = new SmsFindResponse();
    List<SysSms> modelList = new ArrayList<>();
    Long count = sysSmsMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<SysSmsPO> entityList = sysSmsMapper.find(request, passport);
        for (SysSmsPO entity : entityList) {
            SysSms sysSms = this.getMapper().map(entity, SysSms.class);
            modelList.add(sysSms);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}



/**
 * 创建短信通知表
 *
 * @param request 创建短信通知表请求
 * @param passport 用户护照
 * @return 创建短信通知表应答
 */
@Override
public SmsCreateResponse create(SmsCreateRequest request, Passport passport)
{
    SysSmsPO entity = this.getMapper().map(request, SysSmsPO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    SmsCreateResponse response = new SmsCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == sysSmsMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}



/**
 * 删除短信通知表
 *
 * @param request 删除短信通知表请求
 * @param passport 用户护照
 * @return 删除短信通知表应答
 */
@Override
public SmsDeleteResponse delete(SmsDeleteRequest request, Passport passport)
{
 SmsDeleteResponse response = new SmsDeleteResponse();
     Long result= sysSmsMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}




    /**
     * 验证对象
     * @param sysSms 短信通知表
     * @param passport 用户护照
     */
    private void checkValidate(SysSmsPO sysSms, Passport passport, BaseResponse response) {
        // TODO

    }


}
