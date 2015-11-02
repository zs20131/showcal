/**
 * @(#)AnswerMapper.java  
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
package com.showcal.service.dal;

import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;
import com.showcal.service.po.AnswerPO;
import com.showcal.service.request.*;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:54.
 * @author 顾志雄
 */
@MyBatisRepository("ServiceAnswerMapper")
public interface AnswerMapper extends AnswerMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") AnswerPO request, @Param("passport") Passport passport);

    /**
     * 获取所有对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<AnswerPO> getAllList(@Param("request") AnswerGetAllListRequest request, @Param("passport") Passport passport);



    /**
     * 模糊搜索对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<AnswerPO> search(@Param("request") AnswerSearchRequest request, @Param("passport") Passport passport);

    /**
     * 模糊搜索对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long searchCount(@Param("request") AnswerSearchRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询对象列表
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<AnswerPO> find(@Param("request") AnswerFindRequest request, @Param("passport") Passport passport);

    /**
     * 高级查询对象列表总数
     *
     * @param request 请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request") AnswerFindRequest request, @Param("passport") Passport passport);

    /**
     * 根据问题IDS 查询对应的答案信息
     * @param questionIds
     * @param passport
     * @return
     */
    List<AnswerPO> getAnswersByQuestionIds(@Param("ids")List<Long> questionIds, @Param("passport") Passport passport);

    /**
     * 批量关闭问题对应的答案信息
     * @param closeAnswerIds
     * @param passport
     */
    long closeBatch(@Param("ids") List<Long> closeAnswerIds,@Param("passport") Passport passport);
}
