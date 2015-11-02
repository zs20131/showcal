/**
 * @(#)ItemEcommercePO.java  
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
package com.showcal.merchandise.po;

import com.xiniunet.framework.base.BasePO;
import java.util.Date;
/**
 * Created by 顾志雄 on 2015-09-24 09:54:07.
 * @author 顾志雄
 */
public class ItemEcommercePO extends  BasePO {


/**
 * 主键,
 */
private  Long   id;

/**
 * 原价,
 */
private  Double   originalPrice;

/**
 * 现价,
 */
private  Double   currentPrice;

/**
 * 起购数量,
 */
private  Double   buyQuantity;

/**
 * 是否需要物流运输,
 */
private  Boolean   needFreight;

/**
 * 是否包邮,
 */
private  Boolean   isFeeFree;

/**
 * 是否统一运费,
 */
private  Boolean   isUnifiedFee;

/**
 * 统一运费,
 */
private  Double   unifiedFee;

/**
 * 是否运费模板计算,
 */
private  Boolean   isFeeTemplate;

/**
 * 运费模板ID,
 */
private  Long   feeTemplateId;

/**
 * 是否显示库存,
 */
private  Boolean   isShowInventory;

/**
 * 每人限购数量,
 */
private  Double   limitQuantity;

/**
 * 是否启用会员等级折扣,
 */
private  Boolean   enableMemberDiscount;



public Long getId() {
return this.id;
}

public void setId(Long  id) {
this.id = id;
}

public Double getOriginalPrice() {
return this.originalPrice;
}

public void setOriginalPrice(Double  originalPrice) {
this.originalPrice = originalPrice;
}

public Double getCurrentPrice() {
return this.currentPrice;
}

public void setCurrentPrice(Double  currentPrice) {
this.currentPrice = currentPrice;
}

public Double getBuyQuantity() {
return this.buyQuantity;
}

public void setBuyQuantity(Double  buyQuantity) {
this.buyQuantity = buyQuantity;
}

public Boolean getNeedFreight() {
return this.needFreight;
}

public void setNeedFreight(Boolean  needFreight) {
this.needFreight = needFreight;
}

public Boolean getIsFeeFree() {
return this.isFeeFree;
}

public void setIsFeeFree(Boolean  isFeeFree) {
this.isFeeFree = isFeeFree;
}

public Boolean getIsUnifiedFee() {
return this.isUnifiedFee;
}

public void setIsUnifiedFee(Boolean  isUnifiedFee) {
this.isUnifiedFee = isUnifiedFee;
}

public Double getUnifiedFee() {
return this.unifiedFee;
}

public void setUnifiedFee(Double  unifiedFee) {
this.unifiedFee = unifiedFee;
}

public Boolean getIsFeeTemplate() {
return this.isFeeTemplate;
}

public void setIsFeeTemplate(Boolean  isFeeTemplate) {
this.isFeeTemplate = isFeeTemplate;
}

public Long getFeeTemplateId() {
return this.feeTemplateId;
}

public void setFeeTemplateId(Long  feeTemplateId) {
this.feeTemplateId = feeTemplateId;
}

public Boolean getIsShowInventory() {
return this.isShowInventory;
}

public void setIsShowInventory(Boolean  isShowInventory) {
this.isShowInventory = isShowInventory;
}

public Double getLimitQuantity() {
return this.limitQuantity;
}

public void setLimitQuantity(Double  limitQuantity) {
this.limitQuantity = limitQuantity;
}

public Boolean getEnableMemberDiscount() {
return this.enableMemberDiscount;
}

public void setEnableMemberDiscount(Boolean  enableMemberDiscount) {
this.enableMemberDiscount = enableMemberDiscount;
}

}