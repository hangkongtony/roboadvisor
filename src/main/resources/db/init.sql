create database roboadvisor;

use roboadvisor;


DROP TABLE IF EXISTS `index`;
CREATE TABLE `index`
(
    `id`           bigint(20)                NOT NULL AUTO_INCREMENT,
    `ts_code`      varchar(20)    DEFAULT '' NOT NULL,
    `name`         varchar(100)   DEFAULT '' NOT NULL,
    `full_name`    varchar(200)   DEFAULT '' NULL,
    `market`       varchar(10)    DEFAULT '' NULL,
    `publisher`    varchar(100)   DEFAULT '' NULL,
    `index_type`   varchar(100)   DEFAULT '' NULL,
    `category`     varchar(100)   DEFAULT '' NULL,
    `base_date`    char(8)        DEFAULT '' NULL,
    `base_point`   decimal(10, 2) DEFAULT 0  NULL,
    `list_date`    char(8)        DEFAULT '' NULL,
    `weight_rule`  varchar(100)   DEFAULT '' NULL,
    `desc`         text                      NULL,
    `exp_date`     char(8)        DEFAULT '' NULL,
    `gmt_created`  datetime                  NOT NULL,
    `gmt_modified` datetime                  NOT NULL,
    `version`      int(11)        DEFAULT 1  NOT NULL,
    PRIMARY KEY `pk_id` (`id`),
    UNIQUE KEY `UX_TS_CODE` (`ts_code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '指数基本信息表';
