CREATE TABLE `TC_SYNC_HEAT_DETAIL` (
    `ID` BIGINT(20)  NOT NULL  COMMENT '主键',
    `SYNC_HEAT_ID` BIGINT(20)  DEFAULT NULL  COMMENT '同步表头ID',
    `FOOD_ID` BIGINT(20)  DEFAULT NULL  COMMENT '食物ID',
    `FOOD_NAME` VARCHAR(50)  DEFAULT NULL  COMMENT '食物名称',
    `UNIT` VARCHAR(50)  DEFAULT NULL  COMMENT '食物单位',
    `RECOMMEND_VALUE` DECIMAL(19,5)  DEFAULT NULL  COMMENT '推荐值',
    `ACTUAL_VALUE` DECIMAL(19,5)  DEFAULT NULL  COMMENT '实际值',
    `ATTRIBUTE1` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位1',
    `ATTRIBUTE2` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位2',
    `ATTRIBUTE3` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位3',
    `ATTRIBUTE4` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位4',
    `ATTRIBUTE5` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位5',
    `ATTRIBUTE6` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位6',
    `ATTRIBUTE7` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位7',
    `ATTRIBUTE8` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位8',
    `ATTRIBUTE9` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位9',
    `ATTRIBUTE10` VARCHAR(500)  DEFAULT NULL  COMMENT '扩展栏位10',
    `ROW_VERSION` BIGINT(20)  DEFAULT NULL  COMMENT '行版本',
    `IS_DELETED` TINYINT(1)  DEFAULT NULL  COMMENT '是否已删除',
    `CREATED_BY` BIGINT(20)  NOT NULL  COMMENT '创建用户',
    `CREATION_TIME` DATETIME  NOT NULL  COMMENT '创建时间',
    `LAST_UPDATED_BY` BIGINT(20)  DEFAULT NULL  COMMENT '最后更新用户',
    `LAST_UPDATE_TIME` DATETIME  DEFAULT NULL  COMMENT '最后更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='热量同步明细表';