/*
Navicat MySQL Data Transfer
Date: 2022-03-07 14:54:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `passwd` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  `passwd` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('123', '123');

-- ----------------------------
-- Table structure for saleticket
-- ----------------------------
DROP TABLE IF EXISTS `saleticket`;
CREATE TABLE `saleticket` (
  `project` varchar(255) COLLATE utf8_bin NOT NULL,
  `detail` varchar(255) COLLATE utf8_bin NOT NULL,
  `code` varchar(255) COLLATE utf8_bin NOT NULL,
  `num` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of saleticket
-- ----------------------------
INSERT INTO `saleticket` VALUES ('北京-上海', '10-1 18:00', '13223', '598');
INSERT INTO `saleticket` VALUES ('成都-杭州', '10-8 12:00', '6667', '6775');
INSERT INTO `saleticket` VALUES ('武汉-新加坡', '10-9 8:00', '5555', '565');

-- ----------------------------
-- Table structure for userticket
-- ----------------------------
DROP TABLE IF EXISTS `userticket`;
CREATE TABLE `userticket` (
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `project` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `detail` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of userticket
-- ----------------------------
INSERT INTO `userticket` VALUES ('1', '2', '3', '4');
INSERT INTO `userticket` VALUES ('123', '13223', '北京-上海', '10-1 18:00');
