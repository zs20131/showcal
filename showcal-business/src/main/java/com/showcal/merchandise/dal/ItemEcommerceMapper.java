/**
 * @(#)ItemEcommerceMapper.java  
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
package com.showcal.merchandise.dal;

import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;
import com.showcal.merchandise.po.ItemEcommercePO;
import com.showcal.merchandise.request.*;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:07.
 * @author 顾志雄
 */
@MyBatisRepository("MerchandiseItemEcommerceMapper")
public interface ItemEcommerceMapper extends ItemEcommerceMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request")ItemEcommercePO request , @Param("passport")Passport passport);

    /**
     * 获取所有对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<ItemEcommercePO> getAllList(@Param("request")ItemEcommerceGetAllListRequest request,@Param("passport")Passport passport);



    /**
     * 模糊搜索对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<ItemEcommercePO> search(@Param("request")ItemEcommerceSearchRequest request, @Param("passport")Passport passport);

    /**
     * 模糊搜索对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long searchCount(@Param("request")ItemEcommerceSearchRequest request,@Param("passport")Passport passport);


    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<ItemEcommercePO> find(@Param("request")ItemEcommerceFindRequest request, @Param("passport")Passport passport);

    /**
     * 高级查询对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request")ItemEcommerceFindRequest request,@Param("passport")Passport passport);

    



}
