/*
Navicat MySQL Data Transfer

Source Server         : divedeep0
Source Server Version : 50717
Source Host           : 192.168.56.101:3306
Source Database       : sparrow

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-23 20:52:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gateway_api_route
-- ----------------------------
DROP TABLE IF EXISTS `gateway_api_route`;
CREATE TABLE `gateway_api_route` (
  `id` bigint(50) NOT NULL,
  `service_name` varchar(255) DEFAULT NULL COMMENT '微服务名称',
  `service_id` bigint(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `retryable` tinyint(1) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `strip_prefix` int(11) DEFAULT NULL,
  `api_name` varchar(255) DEFAULT NULL,
  `sts_time` datetime DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
