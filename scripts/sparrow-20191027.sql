/*
Navicat MySQL Data Transfer

Source Server         : sparrow-mysql
Source Server Version : 50645
Source Host           : localhost:3306
Source Database       : sparrow

Target Server Type    : MYSQL
Target Server Version : 50645
File Encoding         : 65001

Date: 2019-10-27 22:59:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `coupon_id` bigint(50) NOT NULL,
  `coupon_price` decimal(10,2) DEFAULT NULL,
  `user_id` bigint(50) DEFAULT NULL,
  `order_id` bigint(50) DEFAULT NULL,
  `coupon_sts` int(1) DEFAULT NULL,
  `used_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` bigint(50) NOT NULL,
  `pay_serial_id` varchar(64) DEFAULT NULL,
  `user_id` bigint(50) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `order_sts` int(1) DEFAULT NULL COMMENT '0 未确定 1 已确定 2已取消 3无效 4退款',
  `pay_sts` int(1) DEFAULT NULL COMMENT '0 未支付 1 支付中 2 已支付',
  `shipping_sts` int(1) DEFAULT NULL COMMENT ' 0 未发货 1 已发货 2 已退货',
  `address` varchar(255) DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `product_id` bigint(50) DEFAULT NULL,
  `product_number` int(11) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL,
  `product_amount` decimal(10,2) DEFAULT NULL,
  `shipping_fee` decimal(10,2) DEFAULT NULL,
  `order_amount` decimal(10,2) DEFAULT NULL,
  `coupon_id` bigint(50) DEFAULT NULL COMMENT '优惠券id',
  `coupon_paid` decimal(10,2) DEFAULT NULL COMMENT '优惠券抵扣金额',
  `money_paid` decimal(10,2) DEFAULT NULL,
  `pay_amount` decimal(10,2) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `confirm_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pay_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_product_log
-- ----------------------------
DROP TABLE IF EXISTS `order_product_log`;
CREATE TABLE `order_product_log` (
  `product_id` bigint(50) NOT NULL,
  `order_id` bigint(50) NOT NULL,
  `number` int(11) DEFAULT NULL,
  `log_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `order_product_index` (`product_id`,`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for order_user_balance_log
-- ----------------------------
DROP TABLE IF EXISTS `order_user_balance_log`;
CREATE TABLE `order_user_balance_log` (
  `user_id` bigint(50) NOT NULL,
  `order_id` bigint(50) NOT NULL,
  `operate_type` int(1) DEFAULT NULL COMMENT '1 订单付款 2 订单退款',
  `amount` decimal(10,2) DEFAULT NULL,
  `log_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for pay_log
-- ----------------------------
DROP TABLE IF EXISTS `pay_log`;
CREATE TABLE `pay_log` (
  `pay_id` bigint(50) NOT NULL,
  `order_id` bigint(50) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `pay_sts` int(1) DEFAULT NULL COMMENT '0 未支付 1 已支付',
  `pay_serial_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` bigint(50) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `add_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(50) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `reg_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
