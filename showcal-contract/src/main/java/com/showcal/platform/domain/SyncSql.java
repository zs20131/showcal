/**
 * @(#)SyncSql.java 
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
package com.showcal.platform.domain;

import com.xiniunet.framework.base.BaseDomain;

/**
 * Created by 顾志雄 on 2015-09-17 11:08:01.
 * @author 顾志雄
 */
public class SyncSql extends  BaseDomain {

    
//    /**
//     * 主键
//     */
//    private  Long   id;
//
    /**
     * 版本号 每次加1
     */
    private  Integer   version;
//
//    /**
//     * MYSQL数据库执行语句
//     */
//    private  String   dbsqlMysql;
    
    /**
     * SQLLite数据库执行语句 
     */
    private  String   dbsqlSqllite;
    
//    /**
//     * 所涉及的表
//     */
//    private  String   table;
    

    
//    public Long getId() {
//    return this.id;
//    }
//
//    public void setId(Long  id) {
//    this.id = id;
//    }
//
    public Integer getVersion() {
    return this.version;
    }

    public void setVersion(Integer  version) {
    this.version = version;
    }
//
//    public String getDbsqlMysql() {
//    return this.dbsqlMysql;
//    }
//
//    public void setDbsqlMysql(String  dbsqlMysql) {
//    this.dbsqlMysql = dbsqlMysql;
//    }
    
    public String getDbsqlSqllite() {
    return this.dbsqlSqllite;
    }

    public void setDbsqlSqllite(String  dbsqlSqllite) {
    this.dbsqlSqllite = dbsqlSqllite;
    }
    
//    public String getTable() {
//    return this.table;
//    }
//
//    public void setTable(String  table) {
//    this.table = table;
//    }
    
}