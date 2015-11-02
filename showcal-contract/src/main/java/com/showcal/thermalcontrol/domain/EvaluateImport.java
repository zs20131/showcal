/**
 * @(#)EvaluateImport.java
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
package com.showcal.thermalcontrol.domain;

import com.xiniunet.framework.base.BaseDomain;
import java.util.Date;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:56.
 * @author 顾志雄
 */
public class EvaluateImport extends  BaseDomain {


/**
 * 类型 
 */
private  String   type;

/**
 * 开始值 
 */
private  Double   startGrade;

/**
 * 结束值 
 */
private  Double   endGrade;

/**
 * 优先级 
 */
private  Integer   priority;

/**
 * 评语标题 
 */
private  String   title;

/**
 * 评价内容 
 */
private  String   content;



public String getType() {
return this.type;
}

public void setType(String  type) {
this.type = type;
}

public Double getStartGrade() {
return this.startGrade;
}

public void setStartGrade(Double  startGrade) {
this.startGrade = startGrade;
}

public Double getEndGrade() {
return this.endGrade;
}

public void setEndGrade(Double  endGrade) {
this.endGrade = endGrade;
}

public Integer getPriority() {
return this.priority;
}

public void setPriority(Integer  priority) {
this.priority = priority;
}

public String getTitle() {
return this.title;
}

public void setTitle(String  title) {
this.title = title;
}

public String getContent() {
return this.content;
}

public void setContent(String  content) {
this.content = content;
}

}