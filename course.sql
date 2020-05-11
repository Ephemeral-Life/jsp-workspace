/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : course

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 11/05/2020 11:21:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `password` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `type` int(1) NOT NULL DEFAULT 3,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 25 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES (1, 'root', 'root', 1);
INSERT INTO `login` VALUES (2, 'admin', 'admin', 2);
INSERT INTO `login` VALUES (3, 'wzy', 'wzy', 3);

-- ----------------------------
-- Table structure for stuc
-- ----------------------------
DROP TABLE IF EXISTS `stuc`;
CREATE TABLE `stuc`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `cNo` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `cName` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `cTeac` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `cDep` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `isOnline` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `cPf` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `cMethod` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 96 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stuc
-- ----------------------------
INSERT INTO `stuc` VALUES (1, 'zy1801', 'B/S框架', '刘磊', '信息学院', '否', '超星', '直播');
INSERT INTO `stuc` VALUES (2, 'zy1802', '软件工程', '刘磊', '信息学院', '是', '超星', '直播');
INSERT INTO `stuc` VALUES (3, 'zy1810', '专业英语', '王聘', '信息学院', '是', '雨课堂', '直播');
INSERT INTO `stuc` VALUES (4, 'zy1804', 'JAVA', '张义嘉', '信息学院', '是', '智慧树', '直播');
INSERT INTO `stuc` VALUES (5, 'zy1818', '计算机网络', '李明', '信息学院', '是', '智慧树', '直播');
INSERT INTO `stuc` VALUES (6, 'zy1806', '数据结构', '郭鑫', '信息学院', '是', '超星', '直播');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `pwd` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `status` varchar(10) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `qq` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `registtime` timestamp(0) NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
