package com.showcal.service.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.service.domain
 *  Description:
 * ***************************************************************
 *  10/10 0010  V1.0  xiniu    New Files for com.showcal.service.domain
 * </pre>
 */
public class UnAnswerQuestion {
    /**
     * 问题ID
     */
    private Long id;
    /**
     * 关键字ID
     */
    private Long keywordId;
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 标签ID
     */
    private Long tagId;
    /**
     * 标签
     */
    private String tag;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 身高
     */
    private Double height;
    /**
     * 体重
     */
    private Double weight;
    /**
     * 年龄
     */
    private Integer age;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 提问人Id
     */
    private Long questionUserId;
    /**
     * 问题消息
     */
    private List<ServiceMessage> serviceMessages;


    public Long getQuestionUserId() {
        return questionUserId;
    }

    public void setQuestionUserId(Long questionUserId) {
        this.questionUserId = questionUserId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ServiceMessage> getServiceMessages() {
        return serviceMessages;
    }

    public void setServiceMessages(List<ServiceMessage> serviceMessages) {
        this.serviceMessages = serviceMessages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Long keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
