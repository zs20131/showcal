CREATE TABLE `PL_SYS_USER_PASSWORD` (
    `ID` BIGINT(20)  NOT NULL  COMMENT '主键',
    `LOGIN_PASSWORD` VARCHAR(500)  DEFAULT NULL  COMMENT '登录密码',
    `LOGIN_SALT` VARCHAR(36)  DEFAULT NULL  COMMENT '登录加密盐',
    `TRANSACTION_PASSWORD` VARCHAR(500)  DEFAULT NULL  COMMENT '交易密码',
    `TRANSACTION_SALT` VARCHAR(36)  DEFAULT NULL  COMMENT '交易加密盐',
    `NEED_CHANGE_LOGIN` TINYINT(1)  DEFAULT NULL  COMMENT '是否需要更改密码',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户密码表,考虑安全，纯扩展表';