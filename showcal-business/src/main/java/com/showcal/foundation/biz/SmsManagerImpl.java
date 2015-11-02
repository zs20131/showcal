/**
 * @(#)SmsManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.foundation.biz;


import com.showcal.cms.svc.Message;
import com.showcal.foundation.request.*;
import com.showcal.foundation.response.*;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.SysSmsMapper;
import com.showcal.platform.domain.SysSms;
import com.showcal.platform.po.SysSmsPO;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.Error;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.EncryptUtil;
import com.xiniunet.framework.util.HttpUtil;
import com.xiniunet.framework.util.SettingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLEncoder;
import java.util.*;

/**
 * Created by 沈振家 on 2015-05-19 19:38:52.
 *
 * @author 沈振家
 */
@Transactional
@Service("FoundationSmsManager")
public class SmsManagerImpl extends BaseManagerImpl implements SmsManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private SysSmsMapper smsMapper;


    /**
     * 根据Id获取手机短信通知表
     *
     * @param request  获取手机短信通知表请求
     * @param passport 用户护照
     * @return 获取手机短信通知表应答
     */
    @Override
    @Transactional(readOnly = true)
    public SmsGetResponse get(SmsGetRequest request, Passport passport) {
        SysSmsPO entity = smsMapper.getById(request.getId(), passport);
        SmsGetResponse response = new SmsGetResponse();
        if (entity != null) {
            SysSms sms = this.getMapper().map(entity, SysSms.class);
            response.setSysSms(sms);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 高级查询手机短信通知表
     *
     * @param request  高级查询手机短信通知表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public SmsFindResponse find(SmsFindRequest request, Passport passport) {
        SmsFindResponse response = new SmsFindResponse();
        List<SysSms> modelList = new ArrayList<>();
        Long count = smsMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<SysSmsPO> entityList = smsMapper.find(request, passport);
            for (SysSmsPO entity : entityList) {
                SysSms sms = this.getMapper().map(entity, SysSms.class);
                modelList.add(sms);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }


    /**
     * 创建手机短信通知表
     *
     * @param request  创建手机短信通知表请求
     * @param passport 用户护照
     * @return 创建手机短信通知表应答
     */
    @Override
    public SmsCreateResponse create(SmsCreateRequest request, Passport passport) {
        SysSmsPO entity = this.getMapper().map(request, SysSmsPO.class);
        long id = 0l;
        if (request.getId() != null) {
            id = request.getId();
        } else {
            id = foundationService.getNewId();
        }

        entity.setId(id);
        SmsCreateResponse response = new SmsCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == smsMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }

    /**
     * 删除手机短信通知表
     *
     * @param request  删除手机短信通知表请求
     * @param passport 用户护照
     * @return 删除手机短信通知表应答
     */
    @Override
    public SmsDeleteResponse delete(SmsDeleteRequest request, Passport passport) {
        SmsDeleteResponse response = new SmsDeleteResponse();
        Long result = smsMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    /**
     * 发送短信
     *
     * @param request  发送短信请求
     * @param passport 用户护照
     * @return 发送短信应答
     */
    @Override
    public SmsSendResponse send(SmsSendRequest request, Passport passport) {
        SmsSendResponse response = new SmsSendResponse();
        long id = foundationService.getNewId();
        String smsApiUrl = "http://api.sms.cn/mt/";
        try {
            Map<String, String> smsParams = new HashMap<>();
            String uid = SettingUtil.getProperty("setting.properties", "sms.api.uid");
            String pwd = SettingUtil.getProperty("setting.properties", "sms.api.pwd");
            smsParams.put("uid", uid);
            smsParams.put("pwd", EncryptUtil.MD5(pwd + uid));
            smsParams.put("mobile", request.getMobilePhone());
            smsParams.put("content", URLEncoder.encode(request.getMessageText(), "GBK"));

            for (int i = 0; i < 3; i++) {
                String status = callSmsApi(smsApiUrl, smsParams);
                if (status.equals("stat=100")) {
                    SmsCreateRequest smsCreateRequest = this.getMapper().map(request, SmsCreateRequest.class);
                    smsCreateRequest.setId(id);
                    smsCreateRequest.setSenderUserId(passport.getUserId());
                    smsCreateRequest.setSendTime(new Date());
                    smsCreateRequest.setMessageTime(new Date());
                    SmsCreateResponse smsCreateResponse = create(smsCreateRequest, passport);
                    if (smsCreateResponse.hasError()) {
                        response.addErrors(smsCreateResponse.getErrors());
                        return response;
                    }

                    break;
                }
            }
        } catch (Exception ex) {
//            LogUtil.writeLog(new com.xiniunet.framework.log.Log("error", "", "", ex.getMessage(), passport, ex));
            response.addError(new Error(ErrorType.SYSTEM_ERROR, ex.getMessage()));
        }

        response.setId(id);
        return response;
    }

    private String callSmsApi(String url, Map<String, String> params) throws Exception {
        String responseString = HttpUtil.get(url, params);

        String[] resultList = responseString.split("&");
        String status = resultList[1];
        return status;
    }

    /**
     * 验证对象
     *
     * @param sms      手机短信通知表
     * @param passport 用户护照
     */
    private void checkValidate(SysSmsPO sms, Passport passport, BaseResponse response) {
        // TODO

    }


}
