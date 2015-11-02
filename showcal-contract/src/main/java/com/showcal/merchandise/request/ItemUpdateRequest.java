/**
 * @(#)ItemUpdateRequest.java
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
package com.showcal.merchandise.request;

import com.showcal.merchandise.domain.ItemPicture;
import com.xiniunet.framework.base.BaseUpdateRequest;
import com.xiniunet.framework.constant.RegExpConst;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;


/**
 * Created by 顾志雄 on 2015-09-24 09:54:06.
 * @author 顾志雄
 */
public class ItemUpdateRequest extends BaseUpdateRequest {
    
    /**
     * 主键 
     */
    @NotNull(message = "主键不能为空")
    private  Long   id;
    
    /**
     * 类目ID 
     */
    
    private  Long   classId;
    
    /**
     * 货号（料号） 料号，内部定义的，必须唯一
     */
    
    @Length(min=0, max=50, message = "货号（料号）长度不合法")
    private  String   number;
    
    /**
     * 条形码 
     */
    
    @Length(min=0, max=50, message = "条形码长度不合法")
    private  String   barcode;
    
    /**
     * 名称 
     */
    
    @Length(min=0, max=500, message = "名称长度不合法")
    private  String   name;
    
    /**
     * 拼音 
     */
    @Length(min=0, max=500, message = "拼音长度不合法")
    private  String   pinyin;
    
    /**
     * 拼音缩写 
     */
    @Length(min=0, max=50, message = "拼音缩写长度不合法")
    private  String   py;
    
    /**
     * 类型 
     */
    
    @Length(min=0, max=50, message = "类型长度不合法")
    private  String   type;
    
    /**
     * 基准类型 
     */
    
    @Length(min=0, max=50, message = "基准类型长度不合法")
    private  String   basis;
    
    /**
     * 助记码 
     */
    
    @Length(min=0, max=50, message = "助记码长度不合法")
    private  String   quickCode;
    
    /**
     * 简称 
     */
    
    @Length(min=0, max=50, message = "简称长度不合法")
    private  String   shortName;
    
    /**
     * 开票名称 
     */
    
    @Length(min=0, max=50, message = "开票名称长度不合法")
    private  String   invoicedName;
    
    /**
     * 料号描述 
     */
    
    @Length(min=0, max=4000, message = "料号描述长度不合法")
    private  String   description;
    
    /**
     * 品牌ID 
     */
    
    private  String   brandId;
    
    /**
     * 类别ID 
     */
    
    private  Long   categoryId;
    
    /**
     * 单位 本， 把
     */
    
    @Length(min=0, max=50, message = "单位长度不合法")
    private  String   uom;
    
    /**
     * 规格代码 
     */
    
    @Length(min=0, max=50, message = "规格代码长度不合法")
    private  String   specCode;
    
    /**
     * 规格名称 
     */
    
    @Length(min=0, max=50, message = "规格名称长度不合法")
    private  String   specName;
    
    /**
     * 是否有效 
     */
    
    private  Boolean   isActive;
    
    /**
     * 是否向所有OU开放 
     */
    
    private  Boolean   isAllOuOpened;
    
    /**
     * 是否按OU控制 
     */
    
    private  Boolean   isByOuControl;
    
    /**
     * 关键字 自动处理方便查询
     */
    
    @Length(min=0, max=500, message = "关键字长度不合法")
    private  String   keywords;
    
    /**
     * 商品ID 只有在按规格维护料号时使用
     */
    
    private  Long   commodityId;
    
    /**
     * 图片ID 
     */
    
    private  Long   pictureId;
    
    /**
     * 有效期 天
     */
    
    private  Double   validityTerm;
    
    /**
     * 规格1属性Id 
     */
    
    private  Long   spec1AttributeId;
    
    /**
     * 规格1属性名称 
     */
    
    @Length(min=0, max=50, message = "规格1属性名称长度不合法")
    private  String   spec1AttributeName;
    
    /**
     * 规格1 ID 
     */
    
    private  Long   spec1ValueId;
    
    /**
     * 规格1 
     */
    
    @Length(min=0, max=50, message = "规格1长度不合法")
    private  String   spec1ValueName;
    
    /**
     * 规格2属性Id 
     */
    
    private  Long   spec2AttributeId;
    
    /**
     * 规格2属性名称 
     */
    
    @Length(min=0, max=50, message = "规格2属性名称长度不合法")
    private  String   spec2AttributeName;
    
    /**
     * 规格2 ID 
     */
    
    private  Long   spec2ValueId;
    
    /**
     * 规格2 
     */
    
    @Length(min=0, max=50, message = "规格2长度不合法")
    private  String   spec2ValueName;
    
    /**
     * 规格3属性Id 
     */
    
    private  Long   spec3AttributeId;
    
    /**
     * 规格3属性名称 
     */
    
    @Length(min=0, max=50, message = "规格3属性名称长度不合法")
    private  String   spec3AttributeName;
    
    /**
     * 规格3 ID 
     */
    
    private  Long   spec3ValueId;
    
    /**
     * 规格3 
     */
    
    @Length(min=0, max=50, message = "规格3长度不合法")
    private  String   spec3ValueName;
    
    /**
     * 重量 单位(公斤）
     */
    
    private  Double   weight;
    
    /**
     * 体积 单位（立方厘米）
     */
    
    private  Double   volume;
    
    /**
     * 总阅读数 
     */
    
    private  Integer   countRead;
    
    /**
     * 总收藏数 
     */
    
    private  Integer   countConnection;

    /**
     * 是否已提交,
     */
    private  Boolean   isSubmit=false;

    /**
     * 提交用户ID,
     */
    private  Long   submitUserId;

    /**
     * 提交用户姓名,
     */
    private  String   submitUserName;

    /**
     * 提交时间,
     */
    private  Date   submitTime;

    /**
     * 是否已审批,
     */
    private  Boolean   isApproved=false;

    /**
     * 审批用户ID,
     */
    private  Long   approveUserId;

    /**
     * 审批用户姓名,
     */
    private  String   approveUserName;

    /**
     * 审批时间,
     */
    private  Date   approveTime;

    /**
     * 审批结果,
     */
    private  String   approveResult;
    /**
     * url
     */
    private String url;
    /**
     * 排序
     */
    private Integer orderSort;


    /**
     * 图片
     */
    private List<ItemPicture> itemPictureList;
    /**
     * 原价
     */
    private  Double   originalPrice;
    /**
     * 现价
     */
    private  Double   currentPrice;

    /**
     * 描述
     */
    private String context;

    /**
     * 是否收藏
     */
    private Boolean update=false;
    /**
     * 是否包邮
     */
    private  Boolean isFeeFree;

    public Boolean getIsFeeFree() {
        return isFeeFree;
    }

    public void setIsFeeFree(Boolean isFeeFree) {
        this.isFeeFree = isFeeFree;
    }
    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public List<ItemPicture> getItemPictureList() {
        return itemPictureList;
    }

    public void setItemPictureList(List<ItemPicture> itemPictureList) {
        this.itemPictureList = itemPictureList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(Integer orderSort) {
        this.orderSort = orderSort;
    }

    public Boolean getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(Boolean isSubmit) {
        this.isSubmit = isSubmit;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public String getApproveUserName() {
        return approveUserName;
    }

    public void setApproveUserName(String approveUserName) {
        this.approveUserName = approveUserName;
    }

    public Long getApproveUserId() {
        return approveUserId;
    }

    public void setApproveUserId(Long approveUserId) {
        this.approveUserId = approveUserId;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitUserName() {
        return submitUserName;
    }

    public void setSubmitUserName(String submitUserName) {
        this.submitUserName = submitUserName;
    }

    public Long getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(Long submitUserId) {
        this.submitUserId = submitUserId;
    }

    public Long getId() {
    return this.id;
    }

    public void setId(Long  id) {
    this.id = id;
    }
    
    public Long getClassId() {
    return this.classId;
    }

    public void setClassId(Long  classId) {
    this.classId = classId;
    }
    
    public String getNumber() {
    return this.number;
    }

    public void setNumber(String  number) {
    this.number = number;
    }
    
    public String getBarcode() {
    return this.barcode;
    }

    public void setBarcode(String  barcode) {
    this.barcode = barcode;
    }
    
    public String getName() {
    return this.name;
    }

    public void setName(String  name) {
    this.name = name;
    }
    
    public String getPinyin() {
    return this.pinyin;
    }

    public void setPinyin(String  pinyin) {
    this.pinyin = pinyin;
    }
    
    public String getPy() {
    return this.py;
    }

    public void setPy(String  py) {
    this.py = py;
    }
    
    public String getType() {
    return this.type;
    }

    public void setType(String  type) {
    this.type = type;
    }
    
    public String getBasis() {
    return this.basis;
    }

    public void setBasis(String  basis) {
    this.basis = basis;
    }
    
    public String getQuickCode() {
    return this.quickCode;
    }

    public void setQuickCode(String  quickCode) {
    this.quickCode = quickCode;
    }
    
    public String getShortName() {
    return this.shortName;
    }

    public void setShortName(String  shortName) {
    this.shortName = shortName;
    }
    
    public String getInvoicedName() {
    return this.invoicedName;
    }

    public void setInvoicedName(String  invoicedName) {
    this.invoicedName = invoicedName;
    }
    
    public String getDescription() {
    return this.description;
    }

    public void setDescription(String  description) {
    this.description = description;
    }
    
    public String getBrandId() {
    return this.brandId;
    }

    public void setBrandId(String  brandId) {
    this.brandId = brandId;
    }
    
    public Long getCategoryId() {
    return this.categoryId;
    }

    public void setCategoryId(Long  categoryId) {
    this.categoryId = categoryId;
    }
    
    public String getUom() {
    return this.uom;
    }

    public void setUom(String  uom) {
    this.uom = uom;
    }
    
    public String getSpecCode() {
    return this.specCode;
    }

    public void setSpecCode(String  specCode) {
    this.specCode = specCode;
    }
    
    public String getSpecName() {
    return this.specName;
    }

    public void setSpecName(String  specName) {
    this.specName = specName;
    }
    
    public Boolean getIsActive() {
    return this.isActive;
    }

    public void setIsActive(Boolean  isActive) {
    this.isActive = isActive;
    }
    
    public Boolean getIsAllOuOpened() {
    return this.isAllOuOpened;
    }

    public void setIsAllOuOpened(Boolean  isAllOuOpened) {
    this.isAllOuOpened = isAllOuOpened;
    }
    
    public Boolean getIsByOuControl() {
    return this.isByOuControl;
    }

    public void setIsByOuControl(Boolean  isByOuControl) {
    this.isByOuControl = isByOuControl;
    }
    
    public String getKeywords() {
    return this.keywords;
    }

    public void setKeywords(String  keywords) {
    this.keywords = keywords;
    }
    
    public Long getCommodityId() {
    return this.commodityId;
    }

    public void setCommodityId(Long  commodityId) {
    this.commodityId = commodityId;
    }
    
    public Long getPictureId() {
    return this.pictureId;
    }

    public void setPictureId(Long  pictureId) {
    this.pictureId = pictureId;
    }
    
    public Double getValidityTerm() {
    return this.validityTerm;
    }

    public void setValidityTerm(Double  validityTerm) {
    this.validityTerm = validityTerm;
    }
    
    public Long getSpec1AttributeId() {
    return this.spec1AttributeId;
    }

    public void setSpec1AttributeId(Long  spec1AttributeId) {
    this.spec1AttributeId = spec1AttributeId;
    }
    
    public String getSpec1AttributeName() {
    return this.spec1AttributeName;
    }

    public void setSpec1AttributeName(String  spec1AttributeName) {
    this.spec1AttributeName = spec1AttributeName;
    }
    
    public Long getSpec1ValueId() {
    return this.spec1ValueId;
    }

    public void setSpec1ValueId(Long  spec1ValueId) {
    this.spec1ValueId = spec1ValueId;
    }
    
    public String getSpec1ValueName() {
    return this.spec1ValueName;
    }

    public void setSpec1ValueName(String  spec1ValueName) {
    this.spec1ValueName = spec1ValueName;
    }
    
    public Long getSpec2AttributeId() {
    return this.spec2AttributeId;
    }

    public void setSpec2AttributeId(Long  spec2AttributeId) {
    this.spec2AttributeId = spec2AttributeId;
    }
    
    public String getSpec2AttributeName() {
    return this.spec2AttributeName;
    }

    public void setSpec2AttributeName(String  spec2AttributeName) {
    this.spec2AttributeName = spec2AttributeName;
    }
    
    public Long getSpec2ValueId() {
    return this.spec2ValueId;
    }

    public void setSpec2ValueId(Long  spec2ValueId) {
    this.spec2ValueId = spec2ValueId;
    }
    
    public String getSpec2ValueName() {
    return this.spec2ValueName;
    }

    public void setSpec2ValueName(String  spec2ValueName) {
    this.spec2ValueName = spec2ValueName;
    }
    
    public Long getSpec3AttributeId() {
    return this.spec3AttributeId;
    }

    public void setSpec3AttributeId(Long  spec3AttributeId) {
    this.spec3AttributeId = spec3AttributeId;
    }
    
    public String getSpec3AttributeName() {
    return this.spec3AttributeName;
    }

    public void setSpec3AttributeName(String  spec3AttributeName) {
    this.spec3AttributeName = spec3AttributeName;
    }
    
    public Long getSpec3ValueId() {
    return this.spec3ValueId;
    }

    public void setSpec3ValueId(Long  spec3ValueId) {
    this.spec3ValueId = spec3ValueId;
    }
    
    public String getSpec3ValueName() {
    return this.spec3ValueName;
    }

    public void setSpec3ValueName(String  spec3ValueName) {
    this.spec3ValueName = spec3ValueName;
    }
    
    public Double getWeight() {
    return this.weight;
    }

    public void setWeight(Double  weight) {
    this.weight = weight;
    }
    
    public Double getVolume() {
    return this.volume;
    }

    public void setVolume(Double  volume) {
    this.volume = volume;
    }
    
    public Integer getCountRead() {
    return this.countRead;
    }

    public void setCountRead(Integer  countRead) {
    this.countRead = countRead;
    }
    
    public Integer getCountConnection() {
    return this.countConnection;
    }

    public void setCountConnection(Integer  countConnection) {
    this.countConnection = countConnection;
    }
    

}
