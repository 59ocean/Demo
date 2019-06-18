/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : hospitaldb

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2019-06-18 17:20:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `upwd` varchar(50) NOT NULL,
  `role` varchar(20) DEFAULT NULL,
  `registerTime` varchar(30) DEFAULT NULL,
  `lastLoginTime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '职员', '2019-06-06 08:03:51', '2019-06-06 08:03:51');
INSERT INTO `tb_user` VALUES ('2', '张三', '96e79218965eb72c92a549dd5a330112', '检修员', '2019-06-06 08:03:51', '2019-06-06 08:03:51');
INSERT INTO `tb_user` VALUES ('3', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', '2019-06-06 08:03:51', '2019-06-06 08:03:51');
INSERT INTO `tb_user` VALUES ('4', 'lisi', 'e10adc3949ba59abbe56e057f20f883e', '职员', '2019-06-06 08:03:51', '2019-06-06 08:03:51');

-- ----------------------------
-- Table structure for tb_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_userinfo`;
CREATE TABLE `tb_userinfo` (
  `uname` varchar(50) NOT NULL,
  `runame` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `telphone` varchar(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `remark` text,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uname`),
  CONSTRAINT `fk1` FOREIGN KEY (`uname`) REFERENCES `tb_user` (`uname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_userinfo
-- ----------------------------
INSERT INTO `tb_userinfo` VALUES ('admin', '管理员', '女', 'admin@163.com', null, null, null, null, null);
INSERT INTO `tb_userinfo` VALUES ('zhangsan', '张三', '男', 'aaa@163.com', null, null, null, null, 'images/1560849504553.jpg');
