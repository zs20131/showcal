CREATE TABLE `PL_SYS_MESSAGE` (
    `ID` BIGINT(20)  NOT NULL  COMMENT '主键',
    `BUSINESS_TYPE` VARCHAR(100)  DEFAULT NULL  COMMENT '业务类型',
    `BUSINESS_ID` BIGINT(20)  DEFAULT NULL  COMMENT '业务ID',
    `BUSINESS_CATEGORY` VARCHAR(50)  DEFAULT NULL  COMMENT '业务类别',
    `RECEIPT_ID` VARCHAR(50)  DEFAULT NULL  COMMENT '收件人用户ID',
    `MESSAGE_TITLE` VARCHAR(50)  DEFAULT NULL  COMMENT '消息标题',
    `MESSAGE_URL` VARCHAR(50)  DEFAULT NULL  COMMENT '消息连接',
    `MESSAGE_CONTENT` VARCHAR(50)  DEFAULT NULL  COMMENT '消息内容',
    `SENDER_ID` BIGINT(20)  DEFAULT NULL  COMMENT '发件人用户ID',
    `MESSAGE_TIME` DATETIME  DEFAULT NULL  COMMENT '消息时间',
    `SEND_TIME` DATETIME  DEFAULT NULL  COMMENT '发送时间',
    `IS_READED` TINYINT(1)  DEFAULT NULL  COMMENT '是否已读',
    `READ_TIME` VARCHAR(50)  DEFAULT NULL  COMMENT '阅读时间',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统消息表';