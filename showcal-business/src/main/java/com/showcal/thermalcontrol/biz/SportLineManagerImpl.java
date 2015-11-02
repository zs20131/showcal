/**
 * @(#)SportLineManagerImpl.java
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
import com.showcal.thermalcontrol.dal.SportLineMapper;
import com.showcal.thermalcontrol.dal.SportSettingMapper;
import com.showcal.thermalcontrol.domain.SportLine;
import com.showcal.thermalcontrol.domain.SportLineImport;
import com.showcal.thermalcontrol.domain.SportSetting;
import com.showcal.thermalcontrol.domain.SportSettingImport;
import com.showcal.thermalcontrol.po.SportLinePO;
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

import java.util.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolSportLineManager")
public class SportLineManagerImpl extends BaseManagerImpl implements SportLineManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SportSettingMapper sportSettingMapper;

    @Autowired
    private SportLineMapper sportLineMapper;

    /**
     * 根据Id获取运动方案明细
     *
     * @param request 获取运动方案明细请求
     * @param passport 用户护照
     * @return 获取运动方案明细应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportLineGetResponse get(SportLineGetRequest request, Passport passport)
    {
        SportLinePO entity = sportLineMapper.getById(request.getId(), passport);
        SportLineGetResponse response = new SportLineGetResponse();
        if (entity != null) {
            SportLine sportLine = this.getMapper().map(entity, SportLine.class);
            response.setSportLine(sportLine );
        }
        else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询运动方案明细
     *
     * @param request 模糊查询运动方案明细请求
     * @param passport 用户护照
     * @return 模糊查询运动方案明细应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportLineSearchResponse search(SportLineSearchRequest request, Passport passport)
    {
        SportLineSearchResponse response = new SportLineSearchResponse();
        List<SportLine> modelList = new ArrayList<>();
        Long count = sportLineMapper.searchCount(request, passport);

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
            List<SportLinePO> entityList = sportLineMapper.search(request, passport);

            for (SportLinePO entity : entityList) {
                SportLine sportLine = this.getMapper().map(entity, SportLine.class);
                modelList.add(sportLine);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询运动方案明细
     *
     * @param request 高级查询运动方案明细请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportLineFindResponse find(SportLineFindRequest request, Passport passport)
    {
        SportLineFindResponse response = new SportLineFindResponse();
        List<SportLine> modelList = new ArrayList<>();
        Long count = sportLineMapper.findCount(request, passport);
        if (count >0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SportLinePO> entityList = sportLineMapper.find(request, passport);
            for (SportLinePO entity : entityList) {
                SportLine sportLine = this.getMapper().map(entity, SportLine.class);
                modelList.add(sportLine);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有运动方案明细列表
     *
     * @param request 获取所有运动方案明细列表请求
     * @param passport 用户护照
     * @return 获取所有运动方案明细列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportLineGetAllListResponse getAllList(SportLineGetAllListRequest request, Passport passport)
    {
        SportLineGetAllListResponse response = new SportLineGetAllListResponse();
        List<SportLinePO> entityList = sportLineMapper.getAllList(request, passport);
        if(entityList==null||entityList.isEmpty()){
            response.setTotalCount(0);
            return response;
        }
        List<SportLine> sportLines = new ArrayList<SportLine>();
        Set<Long> settingids = new HashSet<>();
        for (SportLinePO entity : entityList) {
            settingids.add(entity.getSportSettingId());
            SportLine sportLine = this.getMapper().map(entity, SportLine.class);
            sportLines.add(sportLine);
        }
        SportSettingFindRequest settingFindRequest = new SportSettingFindRequest();
        settingFindRequest.setIds(new ArrayList<Long>(settingids));
        List<SportSettingPO> settingEntityList = sportSettingMapper.find(settingFindRequest,passport);
        Map<Long,SportSetting> settingMap = new HashMap<Long,SportSetting>();
        if(settingEntityList!=null&&!settingEntityList.isEmpty()){
            for(SportSettingPO sportSettingPO:settingEntityList){
                settingMap.put(sportSettingPO.getId(), this.getMapper().map(sportSettingPO, SportSetting.class));
            }
        }
        for(SportLine sportLine:sportLines){
            if(settingMap.get(sportLine.getSportSettingId())!=null){
                sportLine.setSportSetting(settingMap.get(sportLine.getSportSettingId()));
            }
        }
        response.setResult(sportLines);
        response.setTotalCount(sportLines.size());
        return response;
    }


    /**
     * 创建运动方案明细
     *
     * @param request 创建运动方案明细请求
     * @param passport 用户护照
     * @return 创建运动方案明细应答
     */
    @Override
    public SportLineCreateResponse create(SportLineCreateRequest request, Passport passport)
    {
        SportLinePO entity = this.getMapper().map(request, SportLinePO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        SportLineCreateResponse response = new SportLineCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == sportLineMapper.insert(entity, passport)) {
            response.setId(id);
        }
        else
        {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新运动方案明细
     *
     * @param request 更新运动方案明细请求
     * @param passport 用户护照
     * @return 更新运动方案明细应答
     */
    @Override
    public SportLineUpdateResponse update(SportLineUpdateRequest request, Passport passport)
    {
        SportLinePO entity = this.getMapper().map(request, SportLinePO.class);

        SportLineUpdateResponse response = new SportLineUpdateResponse();
        Long result=sportLineMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除运动方案明细
     *
     * @param request 删除运动方案明细请求
     * @param passport 用户护照
     * @return 删除运动方案明细应答
     */
    @Override
    public SportLineDeleteResponse delete(SportLineDeleteRequest request, Passport passport)
    {
        SportLineDeleteResponse response = new SportLineDeleteResponse();
        Long result= sportLineMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }
    @Override
    public SportLineListImportResponse importList(SportLineListImportRequest request, Passport passport) {
        SportLineFindRequest sportLineFindRequest=new SportLineFindRequest();
        sportLineFindRequest.setPageSize(0);
        List<SportLinePO> sportLineFindResponse=sportLineMapper.find(sportLineFindRequest, passport);
        List<SportLinePO> importList = new ArrayList<>();            //需要创建的对象的集合

        List<Long> result = new LinkedList<>();                    //存储ID的集合
        List<SportLineImport> beanList = request.getList();            //取出导入对象的集合
        SportLineListImportResponse response = new SportLineListImportResponse();//最终的返回结果
        if(beanList!=null){
            for(int i=0;i< beanList.size();i++){
                for(SportLinePO sportLinePO1:sportLineFindResponse){
                    if(beanList.get(i).getHeadId().intValue()==sportLinePO1.getId().intValue()){
                        response.addError(ErrorType.BUSINESS_ERROR, "第" + (i+1) + "条数据已经存在");
                        return response;
                    }
                }
            }
        }
        for (SportLineImport importBean : beanList) {
            // 设置
            SportLinePO entity = this.getMapper().map(importBean, SportLinePO.class);
            entity.setId(importBean.getLineId());
            importList.add(entity);

        }
        sportLineMapper.insertBatch(importList,passport);
        response.setList(result);
        return response;

    }
    /**
     * 验证对象
     * @param sportLine 运动方案明细
     * @param passport 用户护照
     */
    private void checkValidate(SportLinePO sportLine, Passport passport, BaseResponse response) {
        // TODO

    }


}
