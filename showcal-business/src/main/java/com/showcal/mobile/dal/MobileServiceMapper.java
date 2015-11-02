/**
 * @(#)ArticleBodyMapper.java  
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
package com.showcal.mobile.dal;

import com.showcal.mobile.domain.ShowCalInfo;
import com.showcal.mobile.request.ShowCalQueryRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:53.
 *
 * @author 顾志雄
 */
@MyBatisRepository("MobileServiceMapper")
public interface MobileServiceMapper {
    /**
     * 查询瘦咖列表
     *
     * @param request
     * @param passport
     * @return
     */
    List<ShowCalInfo> getShowCalList(@Param("request") ShowCalQueryRequest request, @Param("passport") Passport passport);

    /**
     * 查询瘦咖列表详情
     *
     * @param request
     * @param passport
     * @return
     */
    Long getShowCalListCount(@Param("request") ShowCalQueryRequest request, @Param("passport") Passport passport);

    /**
     * 查询瘦咖详细信息
     *
     * @param id
     * @param passport
     * @return
     */
    ShowCalInfo getShowCalInfo(@Param("id") Long id, @Param("passport") Passport passport);

    /**
     * 选择瘦咖
     *
     * @param showCalId
     * @param passport
     * @return
     */
    Long selectShowCal(@Param("showCalId") Long showCalId, @Param("passport") Passport passport);

    /**
     * 取消我的瘦咖选择
     *
     * @param id
     * @param passport
     * @return
     */
    Long unselectShowCal(@Param("userId") Long id, @Param("passport") Passport passport);


}
