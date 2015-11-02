/**
 * @(#)SyncSqlManagerImpl.java
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
import com.showcal.platform.dal.SyncSqlMapper;
import com.showcal.platform.domain.SyncSql;
import com.showcal.platform.po.SyncSqlPO;
import com.showcal.platform.request.MaxSqlVersionGetRequest;
import com.showcal.platform.request.SyncSqlCreateRequest;
import com.showcal.platform.request.SyncSqlIncrementRequest;
import com.showcal.platform.response.MaxSqlVersionGetResponse;
import com.showcal.platform.response.SyncSqlCreateResponse;
import com.showcal.platform.response.SyncSqlIncrementResponse;
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
 * Created by 顾志雄 on 2015-09-17 11:08:01.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSyncSqlManager")
public class SyncSqlManagerImpl extends BaseManagerImpl implements SyncSqlManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SyncSqlMapper syncSqlMapper;


    /**
     * 创建数据表同步
     *
     * @param request  创建数据表同步请求
     * @param passport 用户护照
     * @return 创建数据表同步应答
     */
    @Override
    public SyncSqlCreateResponse create(SyncSqlCreateRequest request, Passport passport) {
        SyncSqlPO entity = this.getMapper().map(request, SyncSqlPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);
        entity.setVersion(syncSqlMapper.getMaxVersion()+1);
        SyncSqlCreateResponse response = new SyncSqlCreateResponse();
    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == syncSqlMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }

    /**
     * 获取SQL文件同步接口
     * @param request
     * @param passport
     * @return
     */
    @Override
    public SyncSqlIncrementResponse syncIncrement(SyncSqlIncrementRequest request, Passport passport) {
        //
        SyncSqlIncrementResponse response = new SyncSqlIncrementResponse();
        List<SyncSql> modelList = new ArrayList<>();
        Long count = syncSqlMapper.syncIncrementCount(request, passport);
        if (count >0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<SyncSqlPO> entityList = syncSqlMapper.syncIncrement(request, passport);
            for (SyncSqlPO entity : entityList) {
                SyncSql syncSql = this.getMapper().map(entity, SyncSql.class);
                modelList.add(syncSql);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    public MaxSqlVersionGetResponse getMaxSqlVersion(MaxSqlVersionGetRequest request,Passport passport){
        MaxSqlVersionGetResponse response = new MaxSqlVersionGetResponse();
        long maxversion = syncSqlMapper.getMaxVersion();
        response.setMaxVersion(maxversion);
        return response;
    }

    /**
     * 验证对象
     *
     * @param syncSql  数据表同步
     * @param passport 用户护照
     */
    private void checkValidate(SyncSqlPO syncSql, Passport passport, BaseResponse response) {
        // TODO

    }


}
