/**
 * @(#)SportHeadManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
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
import com.showcal.thermalcontrol.dal.SportHeadMapper;
import com.showcal.thermalcontrol.dal.SportLineMapper;
import com.showcal.thermalcontrol.domain.SportHead;
import com.showcal.thermalcontrol.domain.SportHeadImportShow;
import com.showcal.thermalcontrol.domain.SportLine;
import com.showcal.thermalcontrol.po.SportHeadPO;
import com.showcal.thermalcontrol.po.SportLinePO;
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
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:58.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ThermalcontrolSportHeadManager")
public class SportHeadManagerImpl extends BaseManagerImpl implements SportHeadManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SportHeadMapper sportHeadMapper;

    @Autowired
    private SportLineManager sportLineManager;


    @Autowired
    private SportSettingManager settingManager;
    @Autowired
    private SportLineMapper sportLineMapper;



    /**
     * 根据Id获取运动方案
     *
     * @param request  获取运动方案请求
     * @param passport 用户护照
     * @return 获取运动方案应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportHeadGetResponse get(SportHeadGetRequest request, Passport passport) {
        SportHeadPO entity = sportHeadMapper.getById(request.getId(), passport);
        SportHeadGetResponse response = new SportHeadGetResponse();
        if (entity != null) {
            SportHead sportHead = this.getMapper().map(entity, SportHead.class);
            response.setSportHead(sportHead);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询运动方案
     *
     * @param request  模糊查询运动方案请求
     * @param passport 用户护照
     * @return 模糊查询运动方案应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportHeadSearchResponse search(SportHeadSearchRequest request, Passport passport) {
        SportHeadSearchResponse response = new SportHeadSearchResponse();
        List<SportHead> modelList = new ArrayList<>();
        Long count = sportHeadMapper.searchCount(request, passport);

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
            List<SportHeadPO> entityList = sportHeadMapper.search(request, passport);

            for (SportHeadPO entity : entityList) {
                SportHead sportHead = this.getMapper().map(entity, SportHead.class);
                modelList.add(sportHead);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询运动方案
     *
     * @param request  高级查询运动方案请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportHeadFindResponse find(SportHeadFindRequest request, Passport passport) {
        SportHeadFindResponse response = new SportHeadFindResponse();
        List<SportHead> modelList = new ArrayList<>();
        Long count = sportHeadMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SportHeadPO> entityList = sportHeadMapper.find(request, passport);
            if (entityList == null || entityList.isEmpty()) {
                response.setTotalCount(0);
                return response;
            }
            for (SportHeadPO entity : entityList) {
                SportHead sportHead = this.getMapper().map(entity, SportHead.class);
                SportLineFindRequest sportLineFindRequest = new SportLineFindRequest();
                sportLineFindRequest.setHeadId(entity.getId());
                SportLineFindResponse sportLineFindResponse = sportLineManager.find(sportLineFindRequest, passport);
                // 查询运动主数据
                List<SportLine> sportLines = new ArrayList<>();
                for (SportLine sportLine : sportLineFindResponse.getResult()) {
                    SportSettingGetRequest sportSettingGetRequest = new SportSettingGetRequest();
                    sportSettingGetRequest.setId(sportLine.getSportSettingId());
                    SportSettingGetResponse sportSettingGetResponse = settingManager.get(sportSettingGetRequest, passport);
                    if (sportSettingGetResponse.getSportSetting() != null) {
                        sportLine.setSportSetting(sportSettingGetResponse.getSportSetting());
                    }
                    sportLines.add(sportLine);
                }
                sportHead.setSportLineList(sportLines);
                modelList.add(sportHead);
            }


        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有运动方案列表
     *
     * @param request  获取所有运动方案列表请求
     * @param passport 用户护照
     * @return 获取所有运动方案列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SportHeadGetAllListResponse getAllList(SportHeadGetAllListRequest request, Passport passport) {
        SportHeadGetAllListResponse response = new SportHeadGetAllListResponse();


        List<SportHeadPO> entityList = sportHeadMapper.getAllList(request, passport);


        List<SportHead> modelList = new ArrayList<>();
        for (SportHeadPO entity : entityList) {
            SportHead sportHead = this.getMapper().map(entity, SportHead.class);
            modelList.add(sportHead);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建运动方案
     *
     * @param request  创建运动方案请求
     * @param passport 用户护照
     * @return 创建运动方案应答
     */
    @Override
    public SportHeadCreateResponse create(SportHeadCreateRequest request, Passport passport) {
        SportHeadPO entity = this.getMapper().map(request, SportHeadPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        SportHeadCreateResponse response = new SportHeadCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == sportHeadMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新运动方案
     *
     * @param request  更新运动方案请求
     * @param passport 用户护照
     * @return 更新运动方案应答
     */
    @Override
    public SportHeadUpdateResponse update(SportHeadUpdateRequest request, Passport passport) {
        SportHeadPO entity = this.getMapper().map(request, SportHeadPO.class);

        SportHeadUpdateResponse response = new SportHeadUpdateResponse();
        Long result = sportHeadMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }

    /**
     * 更新totalTime
     *
     * @param request  更新运动方案请求
     * @param passport 用户护照
     * @return 更新totalTime应答
     */
    @Override
    public SportHeadUpdateTotalTimeResponse updateTotalTime(SportHeadUpdateTotalTimeRequest request, Passport passport) {
        SportHeadPO entity = this.getMapper().map(request, SportHeadPO.class);

        SportHeadUpdateTotalTimeResponse response = new SportHeadUpdateTotalTimeResponse();
        Long result = sportHeadMapper.updateTotalTime(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除运动方案
     *
     * @param request  删除运动方案请求
     * @param passport 用户护照
     * @return 删除运动方案应答
     */
    @Override
    public SportHeadDeleteResponse delete(SportHeadDeleteRequest request, Passport passport) {
        SportHeadDeleteResponse response = new SportHeadDeleteResponse();
        Long result = sportHeadMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 导入运动方案
     *
     * @param request  导入运动方案请求
     * @param passport 用户护照
     * @return 导入运动方案应答
     */
    @Override
    public SportHeadListImportResponse importList(SportHeadListImportRequest request, Passport passport) {
        //查询所有的运动头
        SportHeadFindRequest sportHeadFindRequest=new SportHeadFindRequest();
        sportHeadFindRequest.setPageSize(0);
        SportHeadFindResponse sportHeads=this.find(sportHeadFindRequest,passport);
        List<SportHeadImportShow> beanList = request.getList();            //取出导入对象的集合
        SportHeadListImportResponse response = new SportHeadListImportResponse();//最终的返回结果
        int index=1;
        if(sportHeads.getTotalCount()>0) {
            for (SportHeadImportShow importBean : beanList) {
                if (importBean.getId() != null) {
                    for (int i = 0; i < sportHeads.getTotalCount(); i++) {
                        if (importBean.getId().intValue() == sportHeads.getResult().get(i).getId().intValue()) {
                            response.addError(ErrorType.BUSINESS_ERROR, "第" + index + "条数据运动头ID已经存在");
                            return response;
                        }
                    }
                }
                index++;
            }
        }
//        //查询所有的运动头
//        SportLineFindRequest sportLineFindRequest=new SportLineFindRequest();
//        sportLineFindRequest.setPageSize(0);
//        SportLineFindResponse sportLineFindResponse=sportLineManager.find(sportLineFindRequest, passport);
//         int num=0;
//        if(sportLineFindResponse.getTotalCount()>0) {
//            for (SportHeadImportShow importBean : beanList) {
//                if (importBean.getId() != null) {
//                    for (int i = 0; i < sportLineFindResponse.getTotalCount(); i++) {
//                        if (importBean.getId().intValue() == sportLineFindResponse.getResult().get(i).getId().intValue()) {
//                            response.addError(ErrorType.BUSINESS_ERROR, "第" + (num+1) + "条数据的运动明细Id已经存在");
//                            return response;
//                        }
//                    }
//                }
//                num++;
//            }
//        }
        List<SportHeadPO> sportHeadCreateRequests = new ArrayList<>();
//        List<SportLinePO> sportLineCreateRequests = new ArrayList<>();
        String home="家";
        String gym="户外";
        String outdoor="健身房";
        String low="低";
        String middle="中";
        String heigth="高";
        for (SportHeadImportShow importBean : beanList) {
            SportHeadPO sportHeadCreateRequest = new SportHeadPO();
            SportLinePO sportLineCreateRequest = new SportLinePO();
            //设置SportHead头信息
            if (importBean.getId() != null) {
                sportHeadCreateRequest.setId(importBean.getId());
                sportHeadCreateRequest.setName(importBean.getName());
                if (importBean.getAddress().trim().equals(home.trim())) {
                    sportHeadCreateRequest.setAddress("HOME");
                } else if (importBean.getAddress().trim().equals(gym.trim())) {
                    sportHeadCreateRequest.setAddress("OUTDOORS");
                } else if (importBean.getAddress().trim().equals(outdoor.trim())) {
                    sportHeadCreateRequest.setAddress("GYM");
                } else {
                    sportHeadCreateRequest.setAddress(null);
                }
                if (importBean.getIntensity().trim().equals(low.trim())) {
                    sportHeadCreateRequest.setIntensity("LOW");
                } else if (importBean.getIntensity().trim().equals(heigth.trim())) {
                    sportHeadCreateRequest.setIntensity("HEIGHT");
                } else if (importBean.getIntensity().trim().equals(middle.trim())) {
                    sportHeadCreateRequest.setIntensity("MIDDLE");
                } else {
                    sportHeadCreateRequest.setIntensity(null);                }
                sportHeadCreateRequest.setEndBmi(importBean.getEndBmi());
                sportHeadCreateRequest.setStartBmi(importBean.getStartBmi());
                sportHeadCreateRequest.setIsInjuryJoin(importBean.getIsInjuryJoin());
                sportHeadCreateRequest.setTotalTime(importBean.getTotalTime());
//                //  运动行
//                sportLineCreateRequest.setId(importBean.getLineId());
//                sportLineCreateRequest.setHeadId(importBean.getHeadId());
//                sportLineCreateRequest.setSportSettingId(importBean.getSportSettingId());
//                sportLineCreateRequest.setStep(importBean.getStep());
//                sportLineCreateRequest.setTime(importBean.getTime());
            }
            //else {
//                sportLineCreateRequest.setId(importBean.getLineId());
//                sportLineCreateRequest.setHeadId(importBean.getHeadId());
//                sportLineCreateRequest.setSportSettingId(importBean.getSportSettingId());
//                sportLineCreateRequest.setStep(importBean.getStep());
//                sportLineCreateRequest.setTime(importBean.getTime());
//            }
            if (sportHeadCreateRequest.getId() != null) {
                sportHeadCreateRequests.add(sportHeadCreateRequest);
            }
//            if (sportLineCreateRequest.getHeadId() != null) {
//                sportLineCreateRequests.add(sportLineCreateRequest);
//            }
        }
        sportHeadMapper.insertBatch(sportHeadCreateRequests, passport);
//        sportLineMapper.insertBatch(sportLineCreateRequests, passport);
        return response;

    }

    /**
     * 验证对象
     *
     * @param sportHead 运动方案
     * @param passport  用户护照
     */
    private void checkValidate(SportHeadPO sportHead, Passport passport, BaseResponse response) {
        // TODO

    }


}
