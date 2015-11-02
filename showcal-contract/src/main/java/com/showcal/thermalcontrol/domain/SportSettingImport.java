/**
 * @(#)SportSettingImport.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.thermalcontrol.domain;

import com.xiniunet.framework.base.BaseDomain;
import com.xiniunet.framework.util.excel.annotation.Description;
import com.xiniunet.framework.util.excel.annotation.Name;
import com.xiniunet.framework.util.excel.annotation.Type;
import com.xiniunet.framework.util.excel.enumeration.DataType;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:59.
 * @author 顾志雄
 */
public class SportSettingImport extends BaseDomain {


    @Name("方案主键")
    @Type(DataType.LONG)
    @NotNull
    private Long id;

    /**
     * 运动名称
     */
    @Name("运动名称")
    @Type(DataType.STRING)
    @NotNull
    private String name;

    /**
     * 类型
     */
    @Name("类型")
    @Type(DataType.STRING)
    private String type;

    /**
     * 链接地址
     */
    @Name("链接地址")
    @Type(DataType.STRING)
    private String url;

    /**
     * 封面图片
     */
    @Name("封面图片")
    @Type(DataType.LONG)
    private Long cover;

    /**
     * 消耗热量
     */
    @Name("消耗热量")
    @Type(DataType.DECIMAL)
    @NotNull
    private Double burnHeat;

    /**
     * 运动说明内容
     */
    @Name("运动说明内容")
    @Type(DataType.STRING)
    @NotNull
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCover() {
        return this.cover;
    }

    public void setCover(Long cover) {
        this.cover = cover;
    }

    public Double getBurnHeat() {
        return this.burnHeat;
    }

    public void setBurnHeat(Double burnHeat) {
        this.burnHeat = burnHeat;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}