CREATE TABLE `TC_BASE_HEAT` (
    `ID` BIGINT(20)  NOT NULL  COMMENT '主键',
    `SEX` VARCHAR(50)  DEFAULT NULL  COMMENT '性别',
    `START_AGE` INTEGER(20)  DEFAULT NULL  COMMENT '起始年龄',
    `END_AGE` INTEGER(20)  DEFAULT NULL  COMMENT '结束年龄',
    `START_HEIGHT` INTEGER(20)  DEFAULT NULL  COMMENT '起始身高',
    `END_HEIGHT` INTEGER(20)  DEFAULT NULL  COMMENT '结束身高',
    `DISEASE_ID` BIGINT(20)  DEFAULT NULL  COMMENT '疾病情况',
    `BASE_HEAT` VARCHAR(50)  DEFAULT NULL  COMMENT '基础热量值',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础热量设置';