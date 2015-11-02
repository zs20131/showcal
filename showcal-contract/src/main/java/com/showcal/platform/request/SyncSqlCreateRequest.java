/**
 * @(#)SyncSqlCreateRequest.java
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
package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by 顾志雄 on 2015-09-17 11:08:01.
 * @author 顾志雄
 */
public class SyncSqlCreateRequest extends BaseRequest {

    /**
     * MYSQL数据库执行语句 
     */
    @NotBlank(message = "MYSQL数据库执行语句不能为空")
    @Length(min=1, max=500, message = "MYSQL数据库执行语句长度不合法")
    private  String   dbsqlMysql;
    
    /**
     * SQLLite数据库执行语句 
     */
    @NotBlank(message = "SQLLite数据库执行语句不能为空")
    @Length(min=1, max=500, message = "SQLLite数据库执行语句长度不合法")
    private  String   dbsqlSqllite;
    
    /**
     * 所涉及的表 
     */
    
    @Length(min=0, max=50, message = "所涉及的表长度不合法")
    private  String   table;
    
    public String getDbsqlMysql() {
    return this.dbsqlMysql;
    }

    public void setDbsqlMysql(String  dbsqlMysql) {
    this.dbsqlMysql = dbsqlMysql;
    }
    
    public String getDbsqlSqllite() {
    return this.dbsqlSqllite;
    }

    public void setDbsqlSqllite(String  dbsqlSqllite) {
    this.dbsqlSqllite = dbsqlSqllite;
    }
    
    public String getTable() {
    return this.table;
    }

    public void setTable(String  table) {
    this.table = table;
    }
    

}
