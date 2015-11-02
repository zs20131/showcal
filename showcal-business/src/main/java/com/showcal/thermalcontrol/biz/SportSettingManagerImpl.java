/**
 * @(#)SportSettingManagerImpl.java
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
import com.showcal.thermalcontrol.dal.SportSettingMapper;
import com.showcal.thermalcontrol.domain.SportSetting;
import com.showcal.thermalcontrol.domain.SportSettingImport;
import com.showcal.thermalcontrol.po.SportSettingPO;
import com.showcal.thermalcontrol.request.*;
import com.showcal.thermalcontrol.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolSportSettingManager")
public class SportSettingManagerImpl extends BaseManagerImpl implements SportSettingManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SportSettingMapper sportSettingMapper;


    /**
     * 根据Id获取运动主数据
     *
     * @param request  获取运动主数据请求
     * @param passport 用户护照
     * @return 获取运动主数据应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportSettingGetResponse get(SportSettingGetRequest request, Passport passport) {
        SportSettingPO entity = sportSettingMapper.getById(request.getId(), passport);
        SportSettingGetResponse response = new SportSettingGetResponse();
        if (entity != null) {
            SportSetting sportSetting = this.getMapper().map(entity, SportSetting.class);
            response.setSportSetting(sportSetting);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询运动主数据
     *
     * @param request  模糊查询运动主数据请求
     * @param passport 用户护照
     * @return 模糊查询运动主数据应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportSettingSearchResponse search(SportSettingSearchRequest request, Passport passport) {
        SportSettingSearchResponse response = new SportSettingSearchResponse();
        List<SportSetting> modelList = new ArrayList<SportSetting>();
        Long count = sportSettingMapper.searchCount(request, passport);

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
            List<SportSettingPO> entityList = sportSettingMapper.search(request, passport);

            for (SportSettingPO entity : entityList) {
                SportSetting sportSetting = this.getMapper().map(entity, SportSetting.class);
                modelList.add(sportSetting);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询运动主数据
     *
     * @param request  高级查询运动主数据请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportSettingFindResponse find(SportSettingFindRequest request, Passport passport) {
        request.setPageSize(20);
        SportSettingFindResponse response = new SportSettingFindResponse();
        List<SportSetting> modelList = new ArrayList<SportSetting>();
        Long count = sportSettingMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SportSettingPO> entityList = sportSettingMapper.find(request, passport);
            for (SportSettingPO entity : entityList) {
                SportSetting sportSetting = this.getMapper().map(entity, SportSetting.class);
                modelList.add(sportSetting);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有运动主数据列表
     *
     * @param request  获取所有运动主数据列表请求
     * @param passport 用户护照
     * @return 获取所有运动主数据列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportSettingGetAllListResponse getAllList(SportSettingGetAllListRequest request, Passport passport) {
        SportSettingGetAllListResponse response = new SportSettingGetAllListResponse();


        List<SportSettingPO> entityList = sportSettingMapper.getAllList(request, passport);


        List<SportSetting> modelList = new ArrayList<SportSetting>();
        for (SportSettingPO entity : entityList) {
            SportSetting sportSetting = this.getMapper().map(entity, SportSetting.class);
            modelList.add(sportSetting);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建运动主数据
     *
     * @param request  创建运动主数据请求
     * @param passport 用户护照
     * @return 创建运动主数据应答
     */
    @Override
    public SportSettingCreateResponse create(SportSettingCreateRequest request, Passport passport) {
        SportSettingPO entity = this.getMapper().map(request, SportSettingPO.class);

        SportSettingCreateResponse response = new SportSettingCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == sportSettingMapper.insert(entity, passport)) {
            response.setId(request.getId());
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新运动主数据
     *
     * @param request  更新运动主数据请求
     * @param passport 用户护照
     * @return 更新运动主数据应答
     */
    @Override
    public SportSettingUpdateResponse update(SportSettingUpdateRequest request, Passport passport) {
        SportSettingPO entity = this.getMapper().map(request, SportSettingPO.class);

        SportSettingUpdateResponse response = new SportSettingUpdateResponse();
        Long result = sportSettingMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除运动主数据
     *
     * @param request  删除运动主数据请求
     * @param passport 用户护照
     * @return 删除运动主数据应答
     */
    @Override
    public SportSettingDeleteResponse delete(SportSettingDeleteRequest request, Passport passport) {
        SportSettingDeleteResponse response = new SportSettingDeleteResponse();
        Long result = sportSettingMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }
    @Override
    public SportSettingListImportResponse importList(SportSettingListImportRequest request, Passport passport) {
      SportSettingFindRequest sportSettingFindRequest=new SportSettingFindRequest();
        sportSettingFindRequest.setPageSize(0);
        List<SportSettingPO> sportSettingFindResponse=sportSettingMapper.find(sportSettingFindRequest, passport);
        List<SportSettingPO> importList = new ArrayList<>();            //需要创建的对象的集合

        List<Long> result = new LinkedList<>();                    //存储ID的集合
        List<SportSettingImport> beanList = request.getList();            //取出导入对象的集合
        SportSettingListImportResponse response = new SportSettingListImportResponse();//最终的返回结果
         if(beanList!=null){
             for(int i=0;i< beanList.size();i++){
                 for(SportSettingPO sportSettingPO1:sportSettingFindResponse){
                     if(beanList.get(i).getId().intValue()==sportSettingPO1.getId().intValue()){
                         response.addError(ErrorType.BUSINESS_ERROR, "第" + (i+1) + "条数据已经存在");
                         return response;
                     }
                 }
             }
         }
        for (SportSettingImport importBean : beanList) {
            // 设置
            SportSettingPO entity = this.getMapper().map(importBean, SportSettingPO.class);
            importList.add(entity);

        }
        sportSettingMapper.insertBatch(importList,passport);
        response.setList(result);
        return response;

    }
    /**
     * 验证对象
     *
     * @param sportSetting 运动主数据
     * @param passport     用户护照
     */
    private void checkValidate(SportSettingPO sportSetting, Passport passport, BaseResponse response) {
        // TODO

    }


}
