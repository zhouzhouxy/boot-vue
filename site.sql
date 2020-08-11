/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : hnguigu

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-08-11 09:25:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `site`
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sort_site` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ahead` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of site
-- ----------------------------
