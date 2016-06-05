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
CREATE DATABASE /*!32312 IF NOT EXISTS*/`plus` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `plus`;

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `content` int(11) DEFAULT NULL COMMENT '内容',
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
  `value` int(11) DEFAULT NULL COMMENT '配置项的值',
  `remark` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '配置项描述',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_config` */

insert  into `t_config`(`id`,`code`,`value`,`remark`,`valid`,`gmt_create`,`gmt_modify`) values (1,'product_max_buy_count',30,'单次最大购买数',NULL,NULL,NULL);

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
  `type` int(11) DEFAULT NULL COMMENT '类型（10-机票，20-门票）',
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
  `sale_count` int(11) DEFAULT NULL COMMENT '销量',
  `icon` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '6个icon的图片id',
  `order_alter_agreement_id` int(11) DEFAULT NULL COMMENT '改退须知id',
  `comment_count` int(11) DEFAULT NULL COMMENT '评论数',
  `long_lat` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '位置经纬度',
  `long_lat_address` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '位置描述',
  `long_lat_address_en` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '位置描述(英文)',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付类型（1-直接支付，2-不直接支付（生成的是待确认订单））',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
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
  `allow_stop` int(11) DEFAULT NULL COMMENT '充许经停（0:,1:,2:）',
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
  `content` int(11) DEFAULT NULL COMMENT '内容',
  `content_reply` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT '回复消息内容',
  `process_state` int(11) DEFAULT NULL COMMENT '处理状态（1:未回复,2:已回复）',
  `valid` int(11) DEFAULT NULL COMMENT '逻辑删除（1:有效数据,-1:已删除）',
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



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
