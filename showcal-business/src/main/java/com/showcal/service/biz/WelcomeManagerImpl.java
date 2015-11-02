/**
 * @(#)WelcomeManagerImpl.java
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
import com.showcal.service.dal.WelcomeMapper;
import com.showcal.service.domain.Welcome;
import com.showcal.service.domain.WelcomeImport;
import com.showcal.service.po.WelcomePO;
import com.showcal.service.request.*;
import com.showcal.service.response.*;
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
 * Created by 顾志雄 on 2015-09-30 18:20:47.
 * @author 顾志雄
 */
@Transactional
@Service("ServiceWelcomeManager")
public class WelcomeManagerImpl extends BaseManagerImpl implements WelcomeManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private WelcomeMapper welcomeMapper;


/**
 * 根据Id获取欢迎语
 *
 * @param request 获取欢迎语请求
 * @param passport 用户护照
 * @return 获取欢迎语应答
 */
@Override
@Transactional(readOnly = true)
public WelcomeGetResponse get(WelcomeGetRequest request, Passport passport)
{
    WelcomePO entity = welcomeMapper.getById(request.getId(), passport);
    WelcomeGetResponse response = new WelcomeGetResponse();
    if (entity != null) {
    Welcome welcome = this.getMapper().map(entity, Welcome.class);
    response.setWelcome(welcome );
    }
    else {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
    }
    return response;
}


/**
 * 模糊查询欢迎语
 *
 * @param request 模糊查询欢迎语请求
 * @param passport 用户护照
 * @return 模糊查询欢迎语应答
 */
@Override
@Transactional(readOnly = true)
public WelcomeSearchResponse search(WelcomeSearchRequest request, Passport passport)
{
    WelcomeSearchResponse response = new WelcomeSearchResponse();
    List<Welcome> modelList = new ArrayList<>();
    Long count = welcomeMapper.searchCount(request, passport);

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
        List<WelcomePO> entityList = welcomeMapper.search(request, passport);

        for (WelcomePO entity : entityList) {
        Welcome welcome = this.getMapper().map(entity, Welcome.class);
        modelList.add(welcome);
        }
    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 高级查询欢迎语
 *
 * @param request 高级查询欢迎语请求
 * @param passport 用户护照
 * @return 高级查询应答
 */
@Override
@Transactional(readOnly = true)
public WelcomeFindResponse find(WelcomeFindRequest request, Passport passport)
{
    WelcomeFindResponse response = new WelcomeFindResponse();
    List<Welcome> modelList = new ArrayList<>();
    Long count = welcomeMapper.findCount(request, passport);
    if (count >0) {
        // 处理分页参数
        if (request.getPageSize() > 0) {
            //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
            int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
            if (request.getPageNumber() > lastPageNumber) {
                request.setPageNumber(lastPageNumber);
            }
        }


        List<WelcomePO> entityList = welcomeMapper.find(request, passport);
        for (WelcomePO entity : entityList) {
            Welcome welcome = this.getMapper().map(entity, Welcome.class);
            modelList.add(welcome);
        }

    }

    response.setTotalCount(count);
    response.setResult(modelList);
    return response;
}

/**
 * 获取所有欢迎语列表
 *
 * @param request 获取所有欢迎语列表请求
 * @param passport 用户护照
 * @return 获取所有欢迎语列表应答
 */
@Override
@Transactional(readOnly = true)
public WelcomeGetAllListResponse getAllList(WelcomeGetAllListRequest request, Passport passport)
{
    WelcomeGetAllListResponse response = new WelcomeGetAllListResponse();


    List<WelcomePO> entityList = welcomeMapper.getAllList(request, passport);


    List<Welcome> modelList = new ArrayList<>();
    for (WelcomePO entity : entityList) {
    Welcome welcome = this.getMapper().map(entity, Welcome.class);
    modelList.add(welcome);
    }

    response.setResult(modelList);

    response.setTotalCount(modelList.size());
    return response;
}

    /**
     *  获取我的瘦咖欢迎语
     * @param request 获取所有欢迎语列表请求
     * @param passport 用户护照
     * @return
     */
    @Override
    public WelComeGetForMyResponse getMyShowCalWelcome(WelcomeGetForMyRequest request, Passport passport) {
        WelComeGetForMyResponse response = new WelComeGetForMyResponse();
        List<WelcomePO> welcomePOList = welcomeMapper.getMyShowCalWelcome(request, passport);
        if(welcomePOList.size() > 0){
            WelcomePO welcomePO = welcomePOList.get(0);
            Welcome welcome = this.getMapper().map(welcomePO, Welcome.class);

            response.setWelcome(welcome);
        }

        return response;
    }

    /**
 * 创建欢迎语
 *
 * @param request 创建欢迎语请求
 * @param passport 用户护照
 * @return 创建欢迎语应答
 */
@Override
public WelcomeCreateResponse create(WelcomeCreateRequest request, Passport passport)
{
    WelcomePO entity = this.getMapper().map(request, WelcomePO.class);
    long id = foundationService.getNewId();
    entity.setId(id);

    // 初始为未激活状态
    entity.setIsActive(false);

    WelcomeCreateResponse response = new WelcomeCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
    checkValidate(entity,passport,response);

    if (1 == welcomeMapper.insert(entity, passport)) {
        response.setId(id);
    }
    else
    {
        response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
    }
    return response;
}


/**
 * 更新欢迎语
 *
 * @param request 更新欢迎语请求
 * @param passport 用户护照
 * @return 更新欢迎语应答
 */
@Override
public WelcomeUpdateResponse update(WelcomeUpdateRequest request, Passport passport)
{
    WelcomePO entity = this.getMapper().map(request, WelcomePO.class);

    WelcomeUpdateResponse response = new WelcomeUpdateResponse();
    Long result=welcomeMapper.update(entity, passport);
    if (result != 1) {
        response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
        return response;
    }
    response.setResult(result);
    return response;
}


/**
 * 删除欢迎语
 *
 * @param request 删除欢迎语请求
 * @param passport 用户护照
 * @return 删除欢迎语应答
 */
@Override
public WelcomeDeleteResponse delete(WelcomeDeleteRequest request, Passport passport)
{
 WelcomeDeleteResponse response = new WelcomeDeleteResponse();
     Long result= welcomeMapper.delete(request.getId(), passport);
     response.setResult(result);
    return response;
}


/**
 * 作废欢迎语
 *
 * @param request 作废欢迎语请求
 * @param passport 用户护照
 * @return 作废欢迎语应答
 */
@Override
public WelcomeInactiveResponse inactive(WelcomeInactiveRequest request, Passport passport)
{
 WelcomeInactiveResponse response = new WelcomeInactiveResponse();
    Long result= welcomeMapper.inactive(request.getId(), passport);
    response.setResult(result);
    return response;
}


/**
 * 激活欢迎语
 *
 * @param request 激活欢迎语请求
 * @param passport 用户护照
 * @return 激活欢迎语应答
 */
@Override
public WelcomeActiveResponse active(WelcomeActiveRequest request, Passport passport)
{
 WelcomeActiveResponse response = new WelcomeActiveResponse();
    // 先把其他默认的取消
    WelcomeFindRequest welcomeFindRequest = new WelcomeFindRequest();
    List<WelcomePO> entityList = welcomeMapper.find(welcomeFindRequest, passport);
    for (WelcomePO welcomePO : entityList){
        welcomeMapper.inactive(welcomePO.getId(), passport);
    }
    Long result= welcomeMapper.active(request.getId(), passport);
    response.setResult(result);
    return response;
}



/**
 * 导入欢迎语
 *
 * @param request 导入欢迎语请求
 * @param passport 用户护照
 * @return 导入欢迎语应答
 */
@Override
public WelcomeListImportResponse importList(WelcomeListImportRequest request, Passport passport)
{
    DataTable<WelcomeImport> dataTable = request.getDataTable();

    List<WelcomePO> importList = new ArrayList<>();            //需要创建的对象的集合

    List<Long> result = new LinkedList<>();                    //存储ID的集合
    List<WelcomeImport> beanList = request.getList();            //取出导入对象的集合
    WelcomeListImportResponse response = new WelcomeListImportResponse();//最终的返回结果

    /* 批量获取ID */
    IdsGetRequest idsGetRequest = new IdsGetRequest();
    idsGetRequest.setCount(beanList.size());
    List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

    int index = 0;
    for (WelcomeImport importBean : beanList) {
        // 设置
        WelcomePO entity = this.getMapper().map(importBean, WelcomePO.class);


        importList.add(entity);
        result.add(ids.get(index));         //将取到的ID放入返回结果中
        entity.setId(ids.get(index));       //设置ID

        index++;
    }

    if (!dataTable.hasError()) {
        if (importList.size() > 0) {
            welcomeMapper.insertBatch(importList, passport);
        }
    }
    else {
        response.setDataTable(dataTable);
        response.addErrors(dataTable.getErrorList());
    }

    response.setList(result);
    return response;

}

    /**
     * 验证对象
     * @param welcome 欢迎语
     * @param passport 用户护照
     */
    private void checkValidate(WelcomePO welcome, Passport passport, BaseResponse response) {
        // TODO

    }


}
