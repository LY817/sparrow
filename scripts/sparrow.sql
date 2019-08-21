/*
Navicat MySQL Data Transfer

Source Server         : divedeep0
Source Server Version : 50717
Source Host           : 192.168.56.101:3306
Source Database       : sparrow

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-08-21 22:25:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` varchar(64) NOT NULL,
  `pay_serial_id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL,
  `product_id` varchar(64) NOT NULL,
  `number` int(11) NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` varchar(64) NOT NULL,
  `product_name` varchar(64) NOT NULL,
  `price` double NOT NULL,
  `inventory` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(64) NOT NULL,
  `user_name` varchar(64) NOT NULL,
  `password` varchar(32) NOT NULL,
  `credit_score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
