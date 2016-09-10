/*
SQLyog v10.2 
MySQL - 5.7.12-log : Database - plus
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

USE `plus`;

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `content` varchar(2048) DEFAULT NULL COMMENT '内容',
  `status` int(11) DEFAULT NULL COMMENT '状态（10-待审核，20-已审核）',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_comment` */

/*Table structure for table `t_config` */

DROP TABLE IF EXISTS `t_config`;

CREATE TABLE `t_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '配置项的编码',
  `value` varchar (2048) DEFAULT NULL COMMENT '配置项的值',
  `remark` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '配置项描述',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_config` */

insert  into `t_config`(`id`,`code`,`value`,`remark`,`valid`,`gmt_create`,`gmt_modify`) values (1,'max_wait_pay_minutes','30','付款最长等待时间(分钟)',1,NULL,NULL);
insert  into `t_config`(`id`,`code`,`value`,`remark`,`valid`,`gmt_create`,`gmt_modify`) values (2,'product_max_buy_count','30','单次最大购买数',1,NULL,NULL);
insert  into `t_config`(`id`,`code`,`value`,`remark`,`valid`,`gmt_create`,`gmt_modify`) values (3,'max_no_pay_order_count','5','能存在的最多未付款订单数',1,NULL,NULL);
insert  into `t_config`(`id`,`code`,`value`,`remark`,`valid`,`gmt_create`,`gmt_modify`) values (4,'rmb_doller_rate','6.2','人民币兑美元汇率',1,NULL,NULL);
insert  into `t_config`(`id`,`code`,`value`,`remark`,`valid`,`gmt_create`,`gmt_modify`) values (5,'up_scale_a','1','参与人数系数a（公式：x*a+b）',1,NULL,NULL);
insert  into `t_config`(`id`,`code`,`value`,`remark`,`valid`,`gmt_create`,`gmt_modify`) values (6,'up_scale_b','0','参与人数系数b（公式：x*a+b）',1,NULL,NULL);

/*Table structure for table `t_message` */

DROP TABLE IF EXISTS `t_message`;

CREATE TABLE `t_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `message_type` int(11) DEFAULT NULL COMMENT '消息类型（1:行程,2:询价,3:提醒,4:促销）',
  `content` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '消息类容',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_message` */

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `product_spec_id` bigint(20) DEFAULT NULL COMMENT '产品规格id',
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `price_each` int(11) DEFAULT NULL COMMENT '单价',
  `price_total` int(11) DEFAULT NULL COMMENT '总价',
  `status` int(11) DEFAULT NULL COMMENT '状态（10-待确认，20-待付款，30-待评价，40-已评价，50-已取消）',
  `boarding_ids` VARCHAR(512) COMMENT '登机人id，逗号分隔',
  `comment` VARCHAR(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '备注，操作日志',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_order` */

/*Table structure for table `t_order_alter_agreement` */

DROP TABLE IF EXISTS `t_order_alter_agreement`;

CREATE TABLE `t_order_alter_agreement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '改退须知内容',
  `content_en` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '改退须知内容(英文)',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_order_alter_agreement` */

/*Table structure for table `t_pic_lib` */

DROP TABLE IF EXISTS `t_pic_lib`;

CREATE TABLE `t_pic_lib` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pic_url` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '图片url',
  `remark` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '图片说明',
  `remark_en` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '图片说明(英文)',
  `type` int(11) DEFAULT NULL COMMENT '类型（1：首页头部，2首页底部）',
  `name` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '图片名',
  `name_en` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '图片名(英文)',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_pic_lib` */

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(128) DEFAULT NULL COMMENT '产品编码',
  `type` int(11) DEFAULT NULL COMMENT '类型（10-机票BB,11-机票LY,20-门票SE,21-门票SP）',
  `name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '产品名称',
  `name_en` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '产品名称(英文)',
  `file_url` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '素材文件url',
  `description_simple` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '产品简介',
  `description_simple_en` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '产品简介(英文)',
  `description_detail` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '产品详细描述',
  `description_detail_en` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '产品详细描述(英文)',
  `price_original` int(11) DEFAULT NULL COMMENT '原价',
  `price_current` int(11) DEFAULT NULL COMMENT '现价',
  `address_start` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '出发地点',
  `address_start_en` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '出发地点(英文)',
  `address_end` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '目的地',
  `address_end_en` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '目的地(英文)',
  `city_start` int(11) DEFAULT NULL COMMENT '出发城市id',
  `city_end` int(11) DEFAULT NULL COMMENT '目的城市id',
  `airport_start` int(11) DEFAULT NULL COMMENT '出发机场id',
  `airport_end` int(11) DEFAULT NULL COMMENT '目的机场id',
  `sale_count` int(11) DEFAULT NULL COMMENT '销量',
  `icon` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '6个icon的图片id',
  `order_alter_agreement_id` int(11) DEFAULT NULL COMMENT '改退须知id',
  `comment_count` int(11) DEFAULT NULL COMMENT '评论数',
  `long_lat` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '位置经纬度',
  `long_lat_address` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '位置描述',
  `long_lat_address_en` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '位置描述(英文)',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付类型（1-直接支付，2-不直接支付（生成的是待确认订单））',
  `mileage` int(11) DEFAULT NULL COMMENT '里程数(单位km)',
  `fly_time` int(11) DEFAULT NULL COMMENT '飞行时长(单位分钟)',
  `is_show_home` int(11) DEFAULT NULL COMMENT '是否在首页展示',
  `is_special_price` int(11) DEFAULT NULL COMMENT '是否特价(惊喜产品)',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  `plane_id` bigint(20) DEFAULT NULL COMMENT '飞机id',
  `pindao_pic` varchar(128)  DEFAULT NULL COMMENT '频道图片 684*304 1张',
  `fengmian_pic` varchar(128)  DEFAULT NULL COMMENT '封面图片750*1334  1张',
  `lunbo_pic` varchar(128)  DEFAULT NULL COMMENT '轮播图片750*550 8张',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_product` */

/*Table structure for table `t_product_spec` */

DROP TABLE IF EXISTS `t_product_spec`;

CREATE TABLE `t_product_spec` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `merchant_id` bigint(20) DEFAULT NULL COMMENT '商家id',
  `start_date` datetime DEFAULT NULL COMMENT '开始日期',
  `name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `name_en` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '名称(英文)',
  `description_simple` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '简介',
  `description_simple_en` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '简介(英文)',
  `price_original` int(11) DEFAULT NULL COMMENT '原价',
  `price_current` int(11) DEFAULT NULL COMMENT '现价',
  `count_max` int(11) DEFAULT NULL COMMENT '库存数',
  `count_sale` int(11) DEFAULT NULL COMMENT '已卖数量',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_product_spec` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号（app注册）',
  `email` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱（app注册）',
  `password_hash` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '加密后的密码',
  `password_salt` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT 'salt',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类别（1:app注册,2:微信登录）',
  `wx_unique_code` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '微信登录唯一编码',
  `wx_gender` int(11) DEFAULT NULL COMMENT '性别（微信登录获取）',
  `wx_region` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '地区（微信登录获取）',
  `point` int(11) DEFAULT NULL COMMENT '积分',
  `mileage` int(11) DEFAULT NULL COMMENT '里程数(单位km)',
  `fly_time` int(11) DEFAULT NULL COMMENT '飞行时长(单位分钟)',
  `fly_count` int(11) DEFAULT NULL COMMENT '成行次数(即订机票的次数)',
  `nickname` VARCHAR(64) DEFAULT NULL COMMENT '昵称',
   `gender` int(11) DEFAULT NULL COMMENT '性别（1:男,2:女）',
   `habit` int(11) DEFAULT NULL COMMENT '（1出差；2度假；3直飞；4家庭）',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_user` */

/*Table structure for table `t_user_setting` */

DROP TABLE IF EXISTS `t_user_setting`;

CREATE TABLE `t_user_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `language_type` int(11) DEFAULT NULL COMMENT '语言（1:中文,2:英文）',
  `timezone` int(11) DEFAULT NULL COMMENT '时间区（1~24）',
  `currency` int(11) DEFAULT NULL COMMENT '货币（1:CNY,2:USD,3:BGP,4:EUR,5:HKD）',
  `travel_date_type` int(11) DEFAULT NULL COMMENT '出行日期类型（1:灵活,2:固定）',
  `allow_stop` int(11) DEFAULT NULL COMMENT '充许经停（1：经停，2：直飞）',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_user_setting` */

/*Table structure for table `t_wish` */

DROP TABLE IF EXISTS `t_wish`;

CREATE TABLE `t_wish` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `travel_date` datetime DEFAULT NULL COMMENT '出行日期',
  `people_number` int(11) DEFAULT NULL COMMENT '人数',
  `budget` int(11) DEFAULT NULL COMMENT '预算(单位:分)',
  `content` varchar(4000) DEFAULT NULL COMMENT '内容',
  `content_reply` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '回复消息内容',
  `process_state` int(11) DEFAULT NULL COMMENT '处理状态（1:未回复,2:已回复）',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `comment` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '备注，操作日志',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_wish` */

/*Table structure for table `t_user_boarding` */

DROP TABLE IF EXISTS `t_user_boarding`;

CREATE TABLE `t_user_boarding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `full_name` varchar(64) DEFAULT NULL COMMENT '全名',
  `first_name` varchar(32) DEFAULT NULL COMMENT '姓',
  `last_name` varchar(32) DEFAULT NULL COMMENT '名',
  `nationality` varchar(32) DEFAULT NULL COMMENT '国籍',
  `credential_type` int(11) DEFAULT NULL COMMENT '证件类型',
  `credential_number` varchar(32) DEFAULT NULL COMMENT '证件号码',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(512) DEFAULT NULL COMMENT '地址',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_user_boarding` */

/*Table structure for table `t_country` */

DROP TABLE IF EXISTS `t_country`;

CREATE TABLE `t_country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_country` */


/*Table structure for table `t_city` */

DROP TABLE IF EXISTS `t_city`;

CREATE TABLE `t_city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `country_id` int(11) DEFAULT NULL COMMENT '国家id',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_city` */

/*Table structure for table `t_airport` */

DROP TABLE IF EXISTS `t_airport`;

CREATE TABLE `t_airport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `city_id` int(11) DEFAULT NULL COMMENT '国家id',
  `country_id` int(11) DEFAULT NULL COMMENT '国家id',
  `code` varchar(16) DEFAULT NULL COMMENT '机场编号',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_airport` */


DROP TABLE IF EXISTS `t_plane`;

CREATE TABLE `t_plane` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plane_id` int(11) DEFAULT NULL COMMENT '飞行器id',
  `model` varchar(64) DEFAULT NULL COMMENT '模型',
  `passengers` int(11) DEFAULT NULL COMMENT '载客数',
  `manufacturer` varchar(128) DEFAULT NULL COMMENT '制造商',
  `merchant_id` int(11) DEFAULT NULL COMMENT '商家id',
  `delivery_time` datetime DEFAULT NULL COMMENT '交付时间',
  `outside_url`varchar(1024) DEFAULT NULL COMMENT '外部图片url',
  `inside_url`varchar(1024) DEFAULT NULL COMMENT '内部图片url',
  `seat_url`varchar(1024) DEFAULT NULL COMMENT '座位图片url',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `t_merchant`;

CREATE TABLE `t_merchant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL COMMENT '商家名称',
  `contact` varchar(64) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `email` varchar(512) DEFAULT NULL COMMENT '邮箱',
  `contact2` varchar(64) DEFAULT NULL COMMENT '备用联系人',
  `phone2` varchar(32) DEFAULT NULL COMMENT '备用联系人手机号',
  `email2` varchar(512) DEFAULT NULL COMMENT '备用联系人邮箱',
  `aqc`varchar(512) DEFAULT NULL COMMENT '飞行合格证',
  `aqc_url`varchar(512) DEFAULT NULL COMMENT '飞行合格证图片url',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;




DROP TABLE IF EXISTS `t_transaction`;
CREATE TABLE `t_transaction` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `TRADE_NO` VARCHAR(32) DEFAULT NULL COMMENT '系统内部交易编号',
  `TRANS_STATUS` INT(11) DEFAULT NULL COMMENT '交易状态：10-初始，20-成功，30-失败',
  `TRANS_TYPE` INT(11) DEFAULT NULL COMMENT '交易类型',
  `TRANS_AMOUNT` INT(11) DEFAULT NULL COMMENT '总金额（分）',
  `USER_ID` VARCHAR(32) DEFAULT NULL COMMENT '用户id',
  `USER_NAME` VARCHAR(128) DEFAULT NULL,
  `IP` VARCHAR(64) DEFAULT NULL,
  `SOURCE_CHANNEL` VARCHAR(32) DEFAULT NULL COMMENT '来源：WEB,ANDROID,IOS',
  `PARTNER_ORDER_NO` VARCHAR(64) DEFAULT NULL COMMENT '第三方订单号',
  `PARTNER_TYPE` VARCHAR(64) DEFAULT NULL COMMENT '第三方平台类型：1-支付宝，2-微信支付，3-ApplePay',
  `valid` INT(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` DATETIME DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` DATETIME DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1282 DEFAULT CHARSET=utf8 COMMENT='交易记录主表';


DROP TABLE IF EXISTS `t_transaction_detail`;

CREATE TABLE `t_transaction_detail` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `transaction_id` BIGINT(20) DEFAULT NULL,
  `AMOUNT` INT(11) DEFAULT NULL COMMENT '金额（分）',
  `PAY_METHOD` VARCHAR(16) DEFAULT NULL COMMENT '支付方式',
  `remark` VARCHAR(500) DEFAULT NULL COMMENT '备注',
   `valid` INT(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` DATETIME DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` DATETIME DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1337 DEFAULT CHARSET=utf8 COMMENT='交易记录明细';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
