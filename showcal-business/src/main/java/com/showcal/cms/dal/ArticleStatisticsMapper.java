/**
 * @(#)ArticleStatisticsMapper.java  
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
package com.showcal.cms.dal;

import com.showcal.cms.po.ArticleStatisticsPO;
import com.showcal.cms.request.ArticleStatisticsCollectRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
@MyBatisRepository("CmsArticleStatisticsMapper")
public interface ArticleStatisticsMapper extends ArticleStatisticsMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") ArticleStatisticsPO request, @Param("passport") Passport passport);

    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<ArticleStatisticsPO> find(@Param("request") ArticleStatisticsCollectRequest request, @Param("passport") Passport passport);

}
