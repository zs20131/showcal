/**
 * @(#)ItemPictureMapper.java  
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
import com.showcal.merchandise.po.ItemPicturePO;
import com.showcal.merchandise.request.*;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:07.
 * @author 顾志雄
 */
@MyBatisRepository("MerchandiseItemPictureMapper")
public interface ItemPictureMapper extends ItemPictureMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request")ItemPicturePO request , @Param("passport")Passport passport);

    /**
     * 获取所有对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<ItemPicturePO> getAllList(@Param("request")ItemPictureGetAllListRequest request,@Param("passport")Passport passport);



    /**
     * 模糊搜索对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<ItemPicturePO> search(@Param("request")ItemPictureSearchRequest request, @Param("passport")Passport passport);

    /**
     * 模糊搜索对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long searchCount(@Param("request")ItemPictureSearchRequest request,@Param("passport")Passport passport);


    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<ItemPicturePO> find(@Param("request")ItemPictureFindRequest request, @Param("passport")Passport passport);

    /**
     * 高级查询对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request")ItemPictureFindRequest request,@Param("passport")Passport passport);

    



}
