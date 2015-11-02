/**
 * @(#)CategoryManagerImpl.java
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
package com.showcal.cms.biz;

import com.showcal.cms.dal.CategoryMapper;
import com.showcal.cms.domain.Category;
import com.showcal.cms.po.CategoryPO;
import com.showcal.cms.request.*;
import com.showcal.cms.response.*;
import com.showcal.cms.svc.Message;
import com.showcal.foundation.service.FoundationService;
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
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 *
 * @author 顾志雄
 */
@Transactional
@Service("CmsCategoryManager")
public class CategoryManagerImpl extends BaseManagerImpl implements CategoryManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 根据Id获取文章类别
     *
     * @param request  获取文章类别请求
     * @param passport 用户护照
     * @return 获取文章类别应答
     */
    @Override
    @Transactional(readOnly = true)
    public CategoryGetResponse get(CategoryGetRequest request, Passport passport) {
        CategoryPO entity = categoryMapper.getById(request.getId(), passport);
        CategoryGetResponse response = new CategoryGetResponse();
        if (entity != null) {
            Category category = this.getMapper().map(entity, Category.class);
            response.setCategory(category);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询文章类别
     *
     * @param request  模糊查询文章类别请求
     * @param passport 用户护照
     * @return 模糊查询文章类别应答
     */
    @Override
    @Transactional(readOnly = true)
    public CategorySearchResponse search(CategorySearchRequest request, Passport passport) {
        CategorySearchResponse response = new CategorySearchResponse();
        List<Category> modelList = new ArrayList<>();
        Long count = categoryMapper.searchCount(request, passport);

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
            List<CategoryPO> entityList = categoryMapper.search(request, passport);

            for (CategoryPO entity : entityList) {
                Category category = this.getMapper().map(entity, Category.class);
                modelList.add(category);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询文章类别
     *
     * @param request  高级查询文章类别请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    @Transactional(readOnly = true)
    public CategoryFindResponse find(CategoryFindRequest request, Passport passport) {
        CategoryFindResponse response = new CategoryFindResponse();
        List<Category> modelList = new ArrayList<>();
        Long count = categoryMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<CategoryPO> entityList = categoryMapper.find(request, passport);
            for (CategoryPO entity : entityList) {
                Category category = this.getMapper().map(entity, Category.class);
                modelList.add(category);
            }

        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有文章类别列表
     *
     * @param request  获取所有文章类别列表请求
     * @param passport 用户护照
     * @return 获取所有文章类别列表应答
     */
    @Override
    @Transactional(readOnly = true)
    public CategoryGetAllListResponse getAllList(CategoryGetAllListRequest request, Passport passport) {
        CategoryGetAllListResponse response = new CategoryGetAllListResponse();


        List<CategoryPO> entityList = categoryMapper.getAllList(request, passport);


        List<Category> modelList = new ArrayList<>();
        for (CategoryPO entity : entityList) {
            Category category = this.getMapper().map(entity, Category.class);
            modelList.add(category);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建文章类别
     *
     * @param request  创建文章类别请求
     * @param passport 用户护照
     * @return 创建文章类别应答
     */
    @Override
    public CategoryCreateResponse create(CategoryCreateRequest request, Passport passport) {
        CategoryPO entity = this.getMapper().map(request, CategoryPO.class);
        long id = foundationService.getNewId();
        entity.setId(id);

        CategoryCreateResponse response = new CategoryCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == categoryMapper.insert(entity, passport)) {
            response.setId(id);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新文章类别
     *
     * @param request  更新文章类别请求
     * @param passport 用户护照
     * @return 更新文章类别应答
     */
    @Override
    public CategoryUpdateResponse update(CategoryUpdateRequest request, Passport passport) {
        CategoryPO entity = this.getMapper().map(request, CategoryPO.class);

        CategoryUpdateResponse response = new CategoryUpdateResponse();
        Long result = categoryMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除文章类别
     *
     * @param request  删除文章类别请求
     * @param passport 用户护照
     * @return 删除文章类别应答
     */
    @Override
    public CategoryDeleteResponse delete(CategoryDeleteRequest request, Passport passport) {
        CategoryDeleteResponse response = new CategoryDeleteResponse();
        Long result = categoryMapper.delete(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    /**
     * 验证对象
     *
     * @param category 文章类别
     * @param passport 用户护照
     */
    private void checkValidate(CategoryPO category, Passport passport, BaseResponse response) {
        // TODO

    }


}
