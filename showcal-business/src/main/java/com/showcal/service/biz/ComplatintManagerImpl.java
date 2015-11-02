/**
 * @(#)ComplatintManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.service.biz;

import com.showcal.cms.dal.ArticleMapper;
import com.showcal.cms.po.ArticlePO;
import com.showcal.cms.svc.Message;
import com.showcal.foundation.service.FoundationService;
import com.showcal.platform.dal.SysUserMapper;
import com.showcal.platform.po.SysUserPO;
import com.showcal.service.dal.ComplatintMapper;
import com.showcal.service.domain.ComplaintEnum;
import com.showcal.service.domain.Complatint;
import com.showcal.service.po.ComplatintPO;
import com.showcal.service.request.*;
import com.showcal.service.response.*;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 *
 * @author 顾志雄
 */
@Transactional
@Service("ServiceComplatintManager")
public class ComplatintManagerImpl extends BaseManagerImpl implements ComplatintManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private ComplatintMapper complatintMapper;

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private SysUserMapper sysUserMapper;


    /**
     * 根据Id获取用户投诉
     *
     * @param request  获取用户投诉请求
     * @param passport 用户护照
     * @return 获取用户投诉应答
     */
    @Override
    @Transactional(readOnly = true)
    public ComplatintGetResponse get(ComplatintGetRequest request, Passport passport) {
        ComplatintPO entity = complatintMapper.getById(request.getId(), passport);
        ComplatintGetResponse response = new ComplatintGetResponse();
        if (entity != null) {
            Complatint complatint = this.getMapper().map(entity, Complatint.class);
            response.setComplatint(complatint);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询用户投诉
     *
     * @param request  模糊查询用户投诉请求
     * @param passport 用户护照
     * @return 模糊查询用户投诉应答
     */
    @Override
    @Transactional(readOnly = true)
    public ComplatintSearchResponse search(ComplatintSearchRequest request, Passport passport) {
        ComplatintSearchResponse response = new ComplatintSearchResponse();
        List<Complatint> modelList = new ArrayList<>();
        Long count = complatintMapper.searchCount(request, passport);

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
            List<ComplatintPO> entityList = complatintMapper.search(request, passport);

            for (ComplatintPO entity : entityList) {
                Complatint complatint = this.getMapper().map(entity, Complatint.class);
                modelList.add(complatint);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询用户投诉
     *
     * @param request  高级查询用户投诉请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public ComplatintFindResponse find(ComplatintFindRequest request, Passport passport) {
        ComplatintFindResponse response = new ComplatintFindResponse();
        List<Complatint> modelList = new ArrayList<>();
        Long count = complatintMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }
            List<ComplatintPO> entityList = complatintMapper.find(request, passport);
            for (ComplatintPO entity : entityList) {
                Complatint complatint = this.getMapper().map(entity, Complatint.class);
                if(request.getIsList()) {
                    if (complatint.getSourceId() != null && complatint.getSourceType().equals(ComplaintEnum.ARITLCE.name())) {
                        ArticlePO articlePO = articleMapper.getById(complatint.getSourceId(), passport);
                        if (articlePO!= null) {
                            SysUserPO sysUser= sysUserMapper.getById(articlePO.getSubmitUserId(), passport);
                            if(sysUser!=null) {
                                complatint.setSendArticleName(sysUser.getNickName());
                            }
                            complatint.setTitle(articlePO.getTitle());
                        }
                    }
                    SysUserPO sysUserPO = sysUserMapper.getById(complatint.getCreatedBy(), passport);
                    if (sysUserPO != null) {
                        complatint.setCreatedByName(sysUserPO.getNickName());
                        if (sysUserPO.getIsActive() != null) {
                            if (!sysUserPO.getIsActive()) {
                                complatint.setIsSocked(true);
                            }
                        }
                        if (sysUserPO.getIsBanned() != null) {
                            if (sysUserPO.getIsBanned()) {
                                complatint.setIsProhibit(true);
                            }
                        }
                    }
                }

                modelList.add(complatint);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有用户投诉列表
     *
     * @param request  获取所有用户投诉列表请求
     * @param passport 用户护照
     * @return 获取所有用户投诉列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public ComplatintGetAllListResponse getAllList(ComplatintGetAllListRequest request, Passport passport) {
        ComplatintGetAllListResponse response = new ComplatintGetAllListResponse();


        List<ComplatintPO> entityList = complatintMapper.getAllList(request, passport);


        List<Complatint> modelList = new ArrayList<>();
        for (ComplatintPO entity : entityList) {
            Complatint complatint = this.getMapper().map(entity, Complatint.class);
            modelList.add(complatint);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建用户投诉
     *
     * @param request  创建用户投诉请求
     * @param passport 用户护照
     * @return 创建用户投诉应答
     */
    @Override
    public ComplatintCreateResponse create(ComplatintCreateRequest request, Passport passport) {
        ComplatintPO entity = this.getMapper().map(request, ComplatintPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        ComplatintCreateResponse response = new ComplatintCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == complatintMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新用户投诉
     *
     * @param request  更新用户投诉请求
     * @param passport 用户护照
     * @return 更新用户投诉应答
     */
    @Override
    public ComplatintUpdateResponse update(ComplatintUpdateRequest request, Passport passport) {
        ComplatintPO entity = this.getMapper().map(request, ComplatintPO.class);
        ComplatintUpdateResponse response = new ComplatintUpdateResponse();
        entity.setProcessTime(new Date());
        entity.setProcessUserId(passport.getUserId());
        entity.setProcessUserName(passport.getUserName());
        entity.setIsProcessed(true);

        SysUserPO sysUserPO= sysUserMapper.getById(request.getCreatedBy(), passport);
        if (request.getProhibit()) {
            sysUserPO.setIsBanned(true);
            sysUserPO.setBannedTime(request.getProhibitTime());
            sysUserPO.setBannedReason(request.getReason());
            sysUserMapper.update(sysUserPO,passport);
        }
        if (request.getClearProhibit()) {
            sysUserPO.setIsBanned(false);
            sysUserPO.setBannedTime(null);
            sysUserPO.setBannedReason(null);
            sysUserMapper.update(sysUserPO,passport);
        }
        if (request.getClearSocked()) {
            sysUserPO.setIsActive(true);
            sysUserPO.setActiveDate(null);
            sysUserMapper.update(sysUserPO,passport);
        }
        if (request.getSocked()) {
            sysUserPO.setIsActive(false);
            sysUserPO.setActiveDate(new Date());
            sysUserMapper.update(sysUserPO,passport);
        }
        Long result = complatintMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除用户投诉
     *
     * @param request  删除用户投诉请求
     * @param passport 用户护照
     * @return 删除用户投诉应答
     */
    @Override
    public ComplatintDeleteResponse delete(ComplatintDeleteRequest request, Passport passport) {
        ComplatintDeleteResponse response=new ComplatintDeleteResponse();
        if(request.getId()!=null){
        ComplatintFindRequest complatintFindRequest=new ComplatintFindRequest();
        complatintFindRequest.setSourceId(request.getId());
        List<ComplatintPO> complatintPOs=complatintMapper.find(complatintFindRequest,passport);
        for(ComplatintPO complatint:complatintPOs){
            complatintMapper.delete(complatint.getId(), passport);
        }
        articleMapper.delete(request.getId(),passport);
        }
        return response;
    }

    /**
     * 验证对象
     *
     * @param complatint 用户投诉
     * @param passport   用户护照
     */
    private void checkValidate(ComplatintPO complatint, Passport passport, BaseResponse response) {
        // TODO

    }


}
