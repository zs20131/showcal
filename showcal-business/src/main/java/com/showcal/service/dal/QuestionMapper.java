/**
 * @(#)QuestionMapper.java  
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

import com.showcal.service.domain.ServiceMessage;
import com.showcal.service.domain.TotalKeyWordTag;
import com.showcal.service.domain.TotalQuestionTag;
import com.showcal.service.domain.UnAnswerQuestion;
import com.showcal.service.po.QuestionPO;
import com.showcal.service.request.QuestionFindRequest;
import com.showcal.service.request.QuestionGetAllListRequest;
import com.showcal.service.request.QuestionSearchRequest;
import com.showcal.service.request.QuestionWillAnswerForMyRequest;
import com.xiniunet.framework.annotation.MyBatisRepository;
import com.xiniunet.framework.security.Passport;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 *
 * @author 顾志雄
 */
@MyBatisRepository("ServiceQuestionMapper")
public interface QuestionMapper extends QuestionMapperAuto {

    /**
     * 更新实体对象
     *
     * @param request 请求对象
     * @return 受影响的记录条数
     */
    long update(@Param("request") QuestionPO request, @Param("passport") Passport passport);

    /**
     * 获取所有对象列表
     *
     * @param passport 用户护照
     * @return 实体对象集合
     */
    List<QuestionPO> getAllList(@Param("request") QuestionGetAllListRequest request, @Param("passport") Passport passport);


    /**
     * 模糊搜索对象列表
     *
     * @param request  请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<QuestionPO> search(@Param("request") QuestionSearchRequest request, @Param("passport") Passport passport);

    /**
     * 模糊搜索对象列表总数
     *
     * @param request  请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long searchCount(@Param("request") QuestionSearchRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询对象列表
     *
     * @param request  请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<QuestionPO> find(@Param("request") QuestionFindRequest request, @Param("passport") Passport passport);

    /**
     * 高级查询对象列表
     *
     * @param request  请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合
     */
    List<Map<Long, String>> findHistory(@Param("request") QuestionFindRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询对象列表总数
     *
     * @param request  请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findCount(@Param("request") QuestionFindRequest request, @Param("passport") Passport passport);


    /**
     * 高级查询对象列表总数
     *
     * @param request  请求对象
     * @param passport 用户护照
     * @return 实体对象列表集合总数
     */
    long findHistoryCount(@Param("request") QuestionFindRequest request, @Param("passport") Passport passport);

    /**
     * 查找我提问的未回答问题
     *
     * @param passport
     * @return
     */
    QuestionPO getMyUnAnswerQuestion(@Param("showcalId")Long showcalId,@Param("passport") Passport passport);

    /**
     * 获取我所有未回答的标签问题
     *
     * @param request
     * @param passport
     * @return
     */
    List<TotalQuestionTag> getWillAnswerByTagCount(@Param("request") QuestionWillAnswerForMyRequest request, @Param("passport") Passport passport);

    /**
     * 获取所有未回答的关键字
     *
     * @param request
     * @param passport
     * @return
     */
    List<TotalKeyWordTag> getWillAnswerByKeywordCount(@Param("request") QuestionWillAnswerForMyRequest request, @Param("passport") Passport passport);

    /**
     * 新用户问题
     *
     * @param request
     * @param passport
     * @return
     */
    Integer getNewUserQuestion(@Param("request") QuestionWillAnswerForMyRequest request, @Param("passport") Passport passport);

    /**
     * 查询所有未回答的问题
     *
     * @param request
     * @param passport
     * @return
     */
    List<UnAnswerQuestion> findUnAnswerQuestion(@Param("request") QuestionWillAnswerForMyRequest request, @Param("passport") Passport passport);

    /**
     * @param request
     * @param passport
     * @return
     */
    Long findUnAnswerQuestionCount(@Param("request") QuestionWillAnswerForMyRequest request, @Param("passport") Passport passport);

    /**
     * 批量关闭问题
     *
     * @param questionIds
     * @param passport
     * @return
     */
    Long closeBatch(@Param("ids") List<Long> questionIds, @Param("passport") Passport passport);

    /**
     * 获取其他问题总条数
     * @param request
     * @param passport
     * @return
     */
    Integer getOtherQuestionCount(@Param("request") QuestionWillAnswerForMyRequest request,@Param("passport") Passport passport);

}
