/**
 * @(#)SysUserCurveManagerImpl.java
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
import com.showcal.platform.dal.SysUserCurveMapper;
import com.showcal.platform.domain.SysUserCurve;
import com.showcal.platform.po.SysUserCurvePO;
import com.showcal.platform.request.*;
import com.showcal.platform.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:52.
 *
 * @author 顾志雄
 */
@Transactional
@Service("PlatfromSysUserCurveManager")
public class SysUserCurveManagerImpl extends BaseManagerImpl implements SysUserCurveManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SysUserCurveMapper sysUserCurveMapper;

    DecimalFormat df2 = new DecimalFormat("###0.0");
    /**
     * 根据Id获取用户身体变化曲线
     *
     * @param request  获取用户身体变化曲线请求
     * @param passport 用户护照
     * @return 获取用户身体变化曲线应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserCurveGetResponse get(SysUserCurveGetRequest request, Passport passport) {
        SysUserCurvePO entity = sysUserCurveMapper.getById(request.getId(), passport);
        SysUserCurveGetResponse response = new SysUserCurveGetResponse();
        if (entity != null) {
            SysUserCurve sysUserCurve = this.getMapper().map(entity, SysUserCurve.class);
            response.setSysUserCurve(sysUserCurve);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询用户身体变化曲线
     *
     * @param request  模糊查询用户身体变化曲线请求
     * @param passport 用户护照
     * @return 模糊查询用户身体变化曲线应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserCurveSearchResponse search(SysUserCurveSearchRequest request, Passport passport) {
        SysUserCurveSearchResponse response = new SysUserCurveSearchResponse();
        List<SysUserCurve> modelList = new ArrayList<>();
        Long count = sysUserCurveMapper.searchCount(request, passport);

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
            List<SysUserCurvePO> entityList = sysUserCurveMapper.search(request, passport);

            for (SysUserCurvePO entity : entityList) {
                SysUserCurve sysUserCurve = this.getMapper().map(entity, SysUserCurve.class);
                modelList.add(sysUserCurve);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询用户身体变化曲线
     *
     * @param request  高级查询用户身体变化曲线请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserCurveFindResponse find(SysUserCurveFindRequest request, Passport passport) {
        SysUserCurveFindResponse response = new SysUserCurveFindResponse();
        List<SysUserCurve> modelList = new ArrayList<>();
        Long count = sysUserCurveMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<SysUserCurvePO> entityList = sysUserCurveMapper.find(request, passport);
            for (SysUserCurvePO entity : entityList) {
                SysUserCurve sysUserCurve = this.getMapper().map(entity, SysUserCurve.class);
                modelList.add(sysUserCurve);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有用户身体变化曲线列表
     *
     * @param request  获取所有用户身体变化曲线列表请求
     * @param passport 用户护照
     * @return 获取所有用户身体变化曲线列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserCurveGetAllListByUserResponse getAllList(SysUserCurveGetAllListByUserRequest request, Passport passport) {
        SysUserCurveGetAllListByUserResponse response = new SysUserCurveGetAllListByUserResponse();


        List<SysUserCurvePO> entityList = sysUserCurveMapper.getAllList(request, passport);


        List<SysUserCurve> modelList = new ArrayList<>();
        for (SysUserCurvePO entity : entityList) {
            SysUserCurve sysUserCurve = this.getMapper().map(entity, SysUserCurve.class);
            modelList.add(sysUserCurve);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建用户身体变化曲线
     *
     * @param request  创建用户身体变化曲线请求
     * @param passport 用户护照
     * @return 创建用户身体变化曲线应答
     */
    @Override
    public SysUserCurveCreateResponse create(SysUserCurveCreateRequest request, Passport passport) {
        SysUserCurvePO entity = this.getMapper().map(request, SysUserCurvePO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        SysUserCurveCreateResponse response = new SysUserCurveCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);
        // 根据 用户ID、记录类型、记录日期检验重复性
        if(sysUserCurveMapper.existRecord(entity) != null){
            Long recordId = sysUserCurveMapper.existRecord(entity);
            SysUserCurvePO sysUserCurvePO = sysUserCurveMapper.getById(recordId, passport);
            sysUserCurvePO.setValue(request.getValue());
            Long result = sysUserCurveMapper.update(sysUserCurvePO, passport);
            if (result != 1) {
                response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
                return response;
            }
        }else{
            if (1 == sysUserCurveMapper.insert(entity, passport)) {
                response.setId(id);
            } else {
                response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
            }
        }
        return response;
    }


    /**
     * 更新用户身体变化曲线
     *
     * @param request  更新用户身体变化曲线请求
     * @param passport 用户护照
     * @return 更新用户身体变化曲线应答
     */
    @Override
    public SysUserCurveUpdateResponse update(SysUserCurveUpdateRequest request, Passport passport) {
        SysUserCurvePO entity = this.getMapper().map(request, SysUserCurvePO.class);

        SysUserCurveUpdateResponse response = new SysUserCurveUpdateResponse();
        Long result = sysUserCurveMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除用户身体变化曲线
     *
     * @param request  删除用户身体变化曲线请求
     * @param passport 用户护照
     * @return 删除用户身体变化曲线应答
     */
    @Override
    public SysUserCurveDeleteResponse delete(SysUserCurveDeleteRequest request, Passport passport) {
        SysUserCurveDeleteResponse response = new SysUserCurveDeleteResponse();
        Long result = sysUserCurveMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    @Override
    public SysUserCurveGetAllListByUserResponse getAllListByUser(SysUserCurveGetAllListByUserRequest request, Passport passport) {
        SysUserCurveGetAllListByUserResponse response = new SysUserCurveGetAllListByUserResponse();


        List<SysUserCurvePO> entityList = sysUserCurveMapper.getAllList(request, passport);


        List<SysUserCurve> modelList = new ArrayList<>();
        for (SysUserCurvePO entity : entityList) {
            SysUserCurve sysUserCurve = this.getMapper().map(entity, SysUserCurve.class);
            modelList.add(sysUserCurve);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }

    @Override
    public SysUserCurveDeleteByConditionResponse deleteByCondition(SysUserCurveDeleteByConditionRequest request, Passport passport){
        SysUserCurveDeleteByConditionResponse response = new SysUserCurveDeleteByConditionResponse();
        Long result = sysUserCurveMapper.deleteByCondition(request, passport);
        response.setResult(result);
        return response;
    }

    /**
     * 验证对象
     *
     * @param sysUserCurve 用户身体变化曲线
     * @param passport     用户护照
     */
    private void checkValidate(SysUserCurvePO sysUserCurve, Passport passport, BaseResponse response) {
        // TODO

    }

    @Override
    public SysUserCurveGetYearListByUserResponse getYearListByUser(SysUserCurveGetYearListByUserRequest request, Passport passport) {
        SysUserCurveGetYearListByUserResponse response = new SysUserCurveGetYearListByUserResponse();
        List<SysUserCurve> entityList = sysUserCurveMapper.getYearList(request, passport);
        Map<String,Double> weightMap = new HashMap<>();
        for(SysUserCurve sysUserCurve : entityList){
            Double weightDub = sysUserCurve.getAvgWeight();
            if(weightDub!=null){
                weightDub = Double.valueOf(df2.format(weightDub));
                weightMap.put(sysUserCurve.getMonth(), weightDub);
            }

        }
        Date startDate = request.getStartDate();
        Date endDate = request.getEndDate();
        Date nowDate = new Date();
        String startDateStr = "";
        String endDateStr = "";
        String nowDateStr = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        startDateStr = simpleDateFormat.format(startDate);
        endDateStr = simpleDateFormat.format(endDate);
        nowDateStr = simpleDateFormat.format(nowDate);
        // 获取两个日期之间的所有月份
        ArrayList<String> months = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        try{
            min.setTime(sdf.parse(startDateStr));
            min.set(min.get(Calendar.YEAR),min.get(Calendar.MONTH),1);
            max.setTime(sdf.parse(endDateStr));
            max.set(max.get(Calendar.YEAR),max.get(Calendar.MONTH),2);
        }catch (Exception e){
            e.printStackTrace();
            response.addError(ErrorType.EXPECTATION_NULL,"日期转化出错");
        }
        Calendar curr = min;
        while (curr.before(max)){
            months.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        // 处理空档
        List<SysUserCurve> newList = new ArrayList<>();
        Double weightDub = null;
        for(String month : months){
            SysUserCurve sysUserCurve = new SysUserCurve();
            sysUserCurve.setMonth(month);
            if (month.equals(nowDateStr.substring(0, 7))){
                sysUserCurve.setAvgWeight(weightMap.get(month));
                weightDub = null;
            }else{
                if (weightMap.containsKey(month)){
                    weightDub = weightMap.get(month);
                    sysUserCurve.setAvgWeight(weightDub);
                }
            }
            newList.add(sysUserCurve);
        }
        response.setResult(newList);
        response.setTotalCount(newList.size());
        return response;
    }

    @Override
    public SysUserCurveGetMonthListByUserResponse getMonthListByUser(SysUserCurveGetMonthListByUserRequest request, Passport passport) {
        SysUserCurveGetMonthListByUserResponse response = new SysUserCurveGetMonthListByUserResponse();
        List<SysUserCurve> entityList = sysUserCurveMapper.getMonthList(request, passport);
        Map<String, Double> weightMap = new HashMap<>();
        for (SysUserCurve sysUserCurve : entityList){
            weightMap.put(sysUserCurve.getDay(), sysUserCurve.getValue());
        }
        Date startDate = request.getStartDate();
        Date endDate = request.getEndDate();
        Date nowDate = new Date();
        String startDateStr = "";
        String endDateStr = "";
        String nowDateStr = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        startDateStr = simpleDateFormat.format(startDate);
        endDateStr = simpleDateFormat.format(endDate);
        nowDateStr = simpleDateFormat.format(nowDate);
        Calendar calendar = Calendar.getInstance();
        int nowDay = calendar.get(Calendar.DATE);
        // 计算两个日期之间的所有日期
        ArrayList<String> days = new ArrayList<>();
        Calendar startDay = Calendar.getInstance();
        Calendar endDay = Calendar.getInstance();
        try{
            startDay.setTime(simpleDateFormat.parse(startDateStr));
            endDay.setTime(simpleDateFormat.parse(endDateStr));
        }catch (Exception e){
            e.printStackTrace();
            response.addError(ErrorType.EXPECTATION_NULL,"日期转化出错");
        }
        Calendar curr = startDay;
        days.add(simpleDateFormat.format(curr.getTime()));
        while (true){
            // 日期加一
            curr.add(Calendar.DATE, 1);
            days.add(simpleDateFormat.format(curr.getTime()));
            if (curr.compareTo(endDay) == 0){
                break;
            }
        }
        // 处理空档
        List<SysUserCurve> newList = new ArrayList<>();
        Double weightDub = null;
        for (String day : days){
            SysUserCurve sysUserCurve = new SysUserCurve();
            sysUserCurve.setDay(day);
            if (weightMap.containsKey(day)){
                sysUserCurve.setValue(weightMap.get(day));
                weightDub = weightMap.get(day);
            }else{
                sysUserCurve.setValue(weightDub);
            }
            newList.add(sysUserCurve);
        }
        // 使用newList计算平均值1-5 6-10 11-15 16-20 21-25===》5，10，15，20，25
        int count = 0; // 计数
        List<SysUserCurve> avgList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            List<SysUserCurve> periodList = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                periodList.add(newList.get(count));
                count ++;
            }
            // 计算平均值
            Double weight = 0.0;
            Double avgWeight = null;
            int divisor = 0; // 除数
            for (SysUserCurve sysUserCurve : periodList){
                if (weight != null && sysUserCurve.getValue() != null){
                    BigDecimal b1 = new BigDecimal(weight.toString());
                    BigDecimal b2 = new BigDecimal(sysUserCurve.getValue().toString());
                    weight = new Double(b1.add(b2).doubleValue());
                    divisor ++;
                }
            }
            if (weight != null){
                if (divisor > 0){
                    avgWeight = weight / divisor;
                    avgWeight = Double.valueOf(df2.format(avgWeight));
                }
                if (weight == 0){
                    weight = null;
                }
                SysUserCurve avgSysUserCurve = new SysUserCurve();
                if (count < 10){
                    avgSysUserCurve.setDay(startDateStr.substring(0, 7) + "-0" + String.valueOf(count));
                }else{
                    avgSysUserCurve.setDay(startDateStr.substring(0, 7) + "-" + String.valueOf(count));
                }
                if (nowDateStr.substring(0,7).equals(startDateStr.substring(0,7))){ // 判断是否当月
                    if (nowDay < count){ // 如果当月，并且当前的日期小于记录标识
                        avgSysUserCurve.setValue(null);
                    }else {
                        avgSysUserCurve.setValue(avgWeight);
                    }
                }else{
                    avgSysUserCurve.setValue(avgWeight);
                }
                avgList.add(avgSysUserCurve);
            }
        }
        response.setResult(avgList);
        response.setTotalCount(avgList.size());
        return response;
    }

    @Override
    public SysUserCurveGetWeekListByUserResponse getWeekListByUser(SysUserCurveGetWeekListByUserRequest request, Passport passport) {
        SysUserCurveGetWeekListByUserResponse response = new SysUserCurveGetWeekListByUserResponse();
        List<SysUserCurve> entityList = sysUserCurveMapper.getWeekList(request, passport);
        Map<String, Double> weightMap = new HashMap<>();
        for(SysUserCurve sysUserCurve : entityList){
            weightMap.put(sysUserCurve.getDay(), sysUserCurve.getValue());
        }
        Date startDate = request.getStartDate();
        Date endDate = request.getEndDate();
        Date nowDate = new Date();
        String startDateStr = "";
        String endDateStr = "";
        String nowDateStr = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        startDateStr = simpleDateFormat.format(startDate);
        endDateStr = simpleDateFormat.format(endDate);
        nowDateStr = simpleDateFormat.format(nowDate);
        // 计算两个日期之间的所有日期
        ArrayList<String> days = new ArrayList<>();
        Calendar startDay = Calendar.getInstance();
        Calendar endDay = Calendar.getInstance();
        try {
            startDay.setTime(simpleDateFormat.parse(startDateStr));
            endDay.setTime(simpleDateFormat.parse(endDateStr));
        }catch (Exception e){
            e.printStackTrace();
            response.addError(ErrorType.EXPECTATION_NULL,"日期转化出错");
        }
        Calendar curr = startDay;
        days.add(simpleDateFormat.format(curr.getTime())); // 第一天
        while (true){
            // 日期加一
            curr.add(Calendar.DATE, 1);
            days.add(simpleDateFormat.format(curr.getTime()));
            if (curr.compareTo(endDay) == 0){
                break;
            }
        }
        // 处理空档
        List<SysUserCurve> newList = new ArrayList<>();
        Double weightDub = null;
        for (String day : days){
            SysUserCurve sysUserCurve = new SysUserCurve();
            sysUserCurve.setDay(day);
            if (day.equals(nowDateStr)){
                sysUserCurve.setValue(weightMap.get(day));
                weightDub = null;
            }else{
                if (weightMap.containsKey(day)){
                    weightDub = weightMap.get(day);
                    if (weightDub != null){
                        weightDub = Double.valueOf(df2.format(weightDub));
                    }
                    sysUserCurve.setValue(weightDub);
                }else{
                    sysUserCurve.setValue(weightDub);
                }
            }
            newList.add(sysUserCurve);
        }
        response.setResult(newList);
        response.setTotalCount(newList.size());
        return response;
    }
}
