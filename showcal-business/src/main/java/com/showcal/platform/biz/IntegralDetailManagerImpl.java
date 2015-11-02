/**
 * @(#)IntegralDetailManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
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
import com.showcal.platform.dal.IntegralDetailMapper;
import com.showcal.platform.dal.IntegralRuleMapper;
import com.showcal.platform.dal.SysUserExtentMapper;
import com.showcal.platform.domain.IntegralDetail;
import com.showcal.platform.domain.IntegralRule;
import com.showcal.platform.domain.IntegralRuleTypeEnum;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.po.IntegralDetailPO;
import com.showcal.platform.po.IntegralRulePO;
import com.showcal.platform.po.SysUserExtentPO;
import com.showcal.platform.request.*;
import com.showcal.platform.response.IntegralDetailCreateResponse;
import com.showcal.platform.response.IntegralDetailFindResponse;
import com.showcal.platform.response.IntegralDetailGetForMyResponse;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-17 11:07:59.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromIntegralDetailManager")
public class IntegralDetailManagerImpl extends BaseManagerImpl implements IntegralDetailManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private IntegralDetailMapper integralDetailMapper;

    @Autowired
    private IntegralRuleMapper integralRuleMapper;
    @Autowired
    private SysUserExtentMapper sysUserExtentMapper;

    /**
     * 高级查询积分明细
     *
     * @param request  高级查询积分明细请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public IntegralDetailFindResponse find(IntegralDetailFindRequest request, Passport passport) {
        IntegralDetailFindResponse response = new IntegralDetailFindResponse();
        List<IntegralDetail> modelList = new ArrayList<>();
        Long count = integralDetailMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<IntegralDetailPO> entityList = integralDetailMapper.find(request, passport);
            for (IntegralDetailPO entity : entityList) {
                IntegralDetail integralDetail = this.getMapper().map(entity, IntegralDetail.class);
                modelList.add(integralDetail);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }


    /**
     * 创建积分明细
     *
     * @param request  创建积分明细请求
     * @param passport 用户护照
     * @return 创建积分明细应答
     */
    @Override
    public IntegralDetailCreateResponse create(IntegralDetailCreateRequest request, Passport passport) {
        IntegralDetailCreateResponse response = new IntegralDetailCreateResponse();
        Calendar currentDate = this.CurrentDate(new Date());
        int max = 7;
        int min = 1;
        //获取积分规则Id
        IntegralRuleFindRequest integralRuleFindRequest = new IntegralRuleFindRequest();
        integralRuleFindRequest.setType(request.getType());
        List<IntegralRulePO> integralRulePOs = integralRuleMapper.find(integralRuleFindRequest, passport);
        if (integralRulePOs != null && integralRulePOs.size() == 1) {
            IntegralRulePO integralRulePO = integralRulePOs.get(0);
            request.setRuleId(integralRulePO.getId());
            IntegralDetailFindRequest integralDetailFindRequest = new IntegralDetailFindRequest();
            integralDetailFindRequest.setRuleId(integralRulePO.getId());
            integralDetailFindRequest.setUserId(passport.getUserId());
            integralDetailFindRequest.setPageSize(0);
            integralDetailFindRequest.setStartTime(currentDate.getTime());
            integralDetailFindRequest.setEndTime(new Date());
            IntegralDetailFindResponse integralDetailFindResponse = this.find(integralDetailFindRequest, passport);
            Integer sum = 0;
            for (IntegralDetail integralDetail : integralDetailFindResponse.getResult()) {
                if (integralDetail.getValue() != null) {
                    sum += integralDetail.getValue();
                }
            }

            if (request.getType().equals(IntegralRuleTypeEnum.LOGIN.name())) {
                //判断是否已经登录过
                if (integralDetailFindResponse.getResult().size() == 0) {
                    integralDetailFindRequest.setStartTime(null);
                    integralDetailFindRequest.setPageSize(max);
                    integralDetailFindRequest.setEndTime(new Date());
                    IntegralDetailFindResponse iDResponse = this.find(integralDetailFindRequest, passport);
                    if (iDResponse.getResult() != null && iDResponse.getResult().size() > 0) {
                        List<IntegralDetail> integralDetails = iDResponse.getResult();
                        Boolean already = true;
                        for (IntegralDetail integralDetail : integralDetails) {
                            if (integralDetail.getValue().intValue() == max) {
                                already = false;
                                break;
                            }
                        }
                        if (already) {
                            //判断连续登陆几天
                            int totalCount = 0;
                            if (integralDetails.size() > 1) {
                                Boolean isGoOn = false;
                                for (int i = 1; i < integralDetails.size(); i++) {
                                    Calendar currentDate1 = this.CurrentDate(integralDetails.get(i - 1).getIntegralTime());
                                    if (i == 1) {
                                        if ((currentDate.getTimeInMillis() - currentDate1.getTimeInMillis()) / 24 / 60 / 60 / 1000 == 1) {
                                            isGoOn = true;
                                            totalCount += 1;
                                        }
                                    }
                                    if (isGoOn) {
                                        Calendar currentDate2 = this.CurrentDate(integralDetails.get(i).getIntegralTime());
                                        if ((currentDate1.getTimeInMillis() - currentDate2.getTimeInMillis()) / 24 / 60 / 60 / 1000 == 1) {
                                            totalCount += 1;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        totalCount += 1;
                                    }
                                }
                                if (isGoOn) {
                                    request.setValue(totalCount + 1);
                                } else {
                                    request.setValue(min);
                                }
                            } else if (integralDetails.size() == 1) {
                                Calendar currentDate1 = this.CurrentDate(integralDetails.get(0).getIntegralTime());
                                if ((currentDate.getTimeInMillis() - currentDate1.getTimeInMillis()) / 24 / 60 / 60 / 1000 == 1) {
                                    totalCount += 1;
                                }
                                request.setValue(totalCount + 1);
                            }
                        } else {
                            request.setValue(max);
                        }
                    } else {
                        request.setValue(min);
                    }
                } else {
                    return response;
                }
            }
            if (request.getType().equals(IntegralRuleTypeEnum.FORWORD.name())) {
                if (sum >= 20) {
                    return response;
                } else {
                    request.setValue(integralRulePO.getValue());
                }
            }
            if (request.getType().equals(IntegralRuleTypeEnum.QUESTION.name())) {
                if (sum >= 6) {
                    return response;
                } else {
                    request.setValue(integralRulePO.getValue());
                }

            }
            if (request.getType().equals(IntegralRuleTypeEnum.REPLY.name())) {
                if (sum >= 20) {
                    return response;
                } else {
                    request.setValue(integralRulePO.getValue());
                }
            }
            if (request.getType().equals(IntegralRuleTypeEnum.USERTC.name())) {
                if (sum >= 5) {
                    return response;
                } else {
                    request.setValue(integralRulePO.getValue());
                }
            }
            request.setStatus(integralRulePO.getStatus());
            request.setIntegralTime(new Date());
            request.setUserId(passport.getUserId());
            IntegralDetailPO entity = this.getMapper().map(request, IntegralDetailPO.class);
            long id = foundationService.getNewId();
            entity.setId(id);
    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
            checkValidate(entity, passport, response);

            if (1 == integralDetailMapper.insert(entity, passport)) {
                response.setId(id);
                //更新客户扩展表的总积分
                SysUserExtentPO sysUserExtentPO = sysUserExtentMapper.getById(passport.getUserId(), passport);
                if (sysUserExtentPO != null) {
                    if (sysUserExtentPO.getIntegral() == null) {
                        sysUserExtentPO.setIntegral(0);
                    }
                    if(entity.getStatus()==0){
                        if(sysUserExtentPO.getIntegral() - entity.getValue().intValue()<0){
                            sysUserExtentPO.setIntegral(0);
                        }
                        else{
                            sysUserExtentPO.setIntegral(sysUserExtentPO.getIntegral() - entity.getValue().intValue());
                        }
                    }
                    if(entity.getStatus()==1){
                        sysUserExtentPO.setIntegral(sysUserExtentPO.getIntegral() + entity.getValue().intValue());
                    }
                    if (1 != sysUserExtentMapper.update(sysUserExtentPO, passport)) {
                        response.addError(ErrorType.EXPECTATION_NULL, "更新用户扩展表总积分失败");
                        return response;
                    }
                }

            } else {
                response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
            }
            return response;
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, "积分规则出现重复数据,请检查数据");
            return response;
        }
    }

    @Override
    public IntegralDetailGetForMyResponse getMyDetail(IntegralDetailGetForMyRequest request, Passport passport) {
        return null;
    }


    /**
     * 验证对象
     *
     * @param integralDetail 积分明细
     * @param passport       用户护照
     */

    private void checkValidate(IntegralDetailPO integralDetail, Passport passport, BaseResponse response) {
        // TODO

    }

    public Calendar CurrentDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }

}
