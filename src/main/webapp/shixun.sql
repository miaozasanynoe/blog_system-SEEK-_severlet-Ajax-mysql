/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : 119.27.167.223:3306
 Source Schema         : shixun

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 07/07/2019 04:20:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '管理员id，主键',
  `passw` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL DEFAULT '123456' COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL,
  `adminRight` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('201701', '123456', NULL, '普通管理员');
INSERT INTO `admin` VALUES ('201702', '000', NULL, '普通管理员');
INSERT INTO `admin` VALUES ('201703', '111', NULL, '普通管理员');
INSERT INTO `admin` VALUES ('201724', '123456', 'ycy', '超级管理员');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL,
  `arcid` bigint(20) NOT NULL AUTO_INCREMENT,
  `arctime` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `arcatatus` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT '公开' COMMENT '文章状态',
  `archtml` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章主体',
  `title` longtext CHARACTER SET utf8 COLLATE utf8_german2_ci NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_german2_ci NULL,
  `imageurl` longtext CHARACTER SET utf8 COLLATE utf8_german2_ci NULL,
  PRIMARY KEY (`arcid`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('123456', 20, '2019-07-05 07:25:35', '0', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/s6BTS8x4IA2Wa7w.js', '哈利波特', 'nvalid or unexpected token ”“”“”“”“\"\"\"\"\"\"\"\"\"\"\"\"第1部《哈利波特与魔法石》Harry Potter and the Sorcerer\'s Stone (', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/dxw3E5xB1xxo43K.jpg');
INSERT INTO `article` VALUES ('123456', 21, '2019-07-05 07:24:50', '0', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/G9ib1IoSCBJEVtx.js', '哈利波特', '1部《哈利波特与魔法石》Harry Potter and the Sorcerer\'s Stone (2001)\n   一岁的哈利波特失去父母后，神秘地出现在姨父姨妈家的门前。哈利在姨父家饱受欺凌，', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/TmXmdnYmLh5Wth2.jpg');
INSERT INTO `article` VALUES ('123456', 22, '2019-07-05 07:24:53', '0', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/jrvYEJPIeoggib1.js', '哈利波特', 'lt;iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/1NmxkGY5fxc\" frameborder=\"0\" ', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/0TMj3CiUwJKCaGN.jpg');
INSERT INTO `article` VALUES ('123456', 23, '2019-07-05 07:24:56', '0', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/003d9NyDBiVHmsu.js', '哈利波特', 'lt;iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/1NmxkGY5fxc\" frameborder=\"0\" ', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/t1SldFJPuZNKPoO.jpg');
INSERT INTO `article` VALUES ('123456', 24, '2019-07-05 07:25:06', '0', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/EEvhmgQO7oqlf0V.js', '哈利波特', '1部《哈利波特与魔法石》Harry Potter and the Sorcerer\'s Stone (2001)\n   一岁的哈利波特失去父母后，神秘地出现在姨父姨妈家的门前。哈利在姨父家饱受欺凌，', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/FbPHRUq4TJbLdD5.jpg');
INSERT INTO `article` VALUES ('123456', 27, '2019-07-05 07:40:28', '0', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/euWPP90PTJincrp.js', '冰与火之歌', '事背景中虚构的世界，分为两片大陆：位于西面的“日落国度”维斯特洛；位于东面的类似亚欧大陆。维斯特洛大陆边境处发现远古传说中早已灭绝的生物开始，危险也渐渐在靠近这里。这片大陆的临冬城主暨北境统领艾德史......', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/xgAM61RB3AYv12d.jpg');
INSERT INTO `article` VALUES ('123456', 53, '2019-07-06 17:42:18', '0', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/4QZPIZBwYwwvt2o.js', '', '爱吃杀杀杀水水水水吖的阿萨吖的阿瑟东......', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/eTCQ5bOwIJiS0Wd.jpg');
INSERT INTO `article` VALUES ('201701020124', 54, '2019-07-06 17:47:08', '0', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/5C0a2peP4FuYCK6.js', '阿斯兰的还哦', '......', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/o86MKJ3KJaaOBIj.jpg');
INSERT INTO `article` VALUES ('缪传鹏', 55, '2019-07-07 02:57:45', '0', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/Nyrevwm03fDQOhU.js', 'wwwwwwwwwwwwwwwwwwwww', 'wdqqqqqqqqqqqqqqqqqqqqq......', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/i2cbgaKAGMHWXah.jpg');

-- ----------------------------
-- Table structure for article_colect
-- ----------------------------
DROP TABLE IF EXISTS `article_colect`;
CREATE TABLE `article_colect`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL,
  `arcid` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL,
  `col_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `uncol_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  INDEX `article_colect_user_id`(`userid`) USING BTREE,
  CONSTRAINT `article_colect_user_id` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article_colect
-- ----------------------------
INSERT INTO `article_colect` VALUES ('123456', '21', '2019-07-06 16:03:33', NULL);
INSERT INTO `article_colect` VALUES ('123456', '21', '2019-07-06 16:14:13', NULL);
INSERT INTO `article_colect` VALUES ('201701020124', '20', '2019-07-06 16:35:17', NULL);
INSERT INTO `article_colect` VALUES ('201701020124', '21', '2019-07-06 18:42:52', NULL);
INSERT INTO `article_colect` VALUES ('201701020124', '22', '2019-07-06 18:44:49', NULL);
INSERT INTO `article_colect` VALUES ('缪传鹏', '24', '2019-07-07 02:56:23', NULL);
INSERT INTO `article_colect` VALUES ('缪传鹏', '22', '2019-07-07 03:01:05', NULL);

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment`  (
  `arcticle_id` bigint(20) NULL DEFAULT NULL COMMENT '被评论文章ID',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL COMMENT '发表信息人ID',
  `reback_arctcle_id` bigint(20) NULL DEFAULT NULL COMMENT '回复评论ID',
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_german2_ci NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `arc_comment_user_id`(`user_id`) USING BTREE,
  INDEX `arc_comment_arcticle_id`(`arcticle_id`) USING BTREE,
  CONSTRAINT `arc_comment_arcticle_id` FOREIGN KEY (`arcticle_id`) REFERENCES `article` (`arcid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `arc_comment_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for lock_user
-- ----------------------------
DROP TABLE IF EXISTS `lock_user`;
CREATE TABLE `lock_user`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL,
  `locktime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `res` longtext CHARACTER SET utf8 COLLATE utf8_german2_ci NULL,
  PRIMARY KEY (`userid`) USING BTREE,
  CONSTRAINT `lock_user_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lock_user
-- ----------------------------
INSERT INTO `lock_user` VALUES ('201701020124', '2019-07-03 23:05:05', NULL);
INSERT INTO `lock_user` VALUES ('201701020135', '2019-07-06 00:00:00', 'xxx');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_text` longtext CHARACTER SET utf8 COLLATE utf8_german2_ci NULL,
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `admin_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('溜', '2019-07-03 23:05:13', '201701');
INSERT INTO `notice` VALUES ('醉了', '2019-07-06 00:00:00', '201702');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '用户id',
  `passw` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '密码',
  `arctitles` int(255) NULL DEFAULT 0 COMMENT '用户发表文章数量',
  `fans` int(255) NOT NULL DEFAULT 0 COMMENT '粉丝数',
  `collects` int(255) NULL DEFAULT 0 COMMENT '收藏数',
  `integral` int(255) NULL DEFAULT 0 COMMENT '积分',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL COMMENT '邮箱',
  `himgUrl` longtext CHARACTER SET utf8 COLLATE utf8_german2_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('111', '1111111111111', 0, 0, 0, 0, '1111111111111@qq.com', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/H6IbFXJU3KMp1jp.jpg');
INSERT INTO `user` VALUES ('123456', '111111111111', 22, 41, 51, 786, '123456@qq.com', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/b9lNfeDCsGIkHbL.jpg');
INSERT INTO `user` VALUES ('201701020108', '123', 33, 46, 108, 1142, '1275948439@qq.com', NULL);
INSERT INTO `user` VALUES ('201701020124', '654321', 99, 100, 99, 1000, '201701020124@qq.com', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/a8081L9MBl3dSeo.jpg');
INSERT INTO `user` VALUES ('201701020135', '123456', 33, 23, 10, 321, '1341312038@qq.com', NULL);
INSERT INTO `user` VALUES ('201701020145', '111', 11, 100, 100, 1200, '2903067812@qq.com', NULL);
INSERT INTO `user` VALUES ('缪传鹏', '1111111111111', 0, 0, 0, 0, '1111111111111@qq.com', 'https://test-1258897694.cos.ap-chengdu.myqcloud.com/GVykvYnfaEMXLb7.jpg');

-- ----------------------------
-- Table structure for user_feedback
-- ----------------------------
DROP TABLE IF EXISTS `user_feedback`;
CREATE TABLE `user_feedback`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL,
  `feedtext` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  CONSTRAINT `user_feedback_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 201903 CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_feedback
-- ----------------------------
INSERT INTO `user_feedback` VALUES ('201701020124', '2019-07-03 22:59:42', '111', 'tql', 201901);
INSERT INTO `user_feedback` VALUES ('201701020135', '2019-07-06 00:00:00', 'xxx', 'xxx', 201902);

-- ----------------------------
-- Table structure for watched
-- ----------------------------
DROP TABLE IF EXISTS `watched`;
CREATE TABLE `watched`  (
  `wa_userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL,
  `wing_userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci NULL DEFAULT NULL,
  `wa_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `unwa_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  INDEX `watched_wa_user_id`(`wa_userid`) USING BTREE,
  INDEX `watched_wing_user_id`(`wing_userid`) USING BTREE,
  CONSTRAINT `watched_wa_user_id` FOREIGN KEY (`wa_userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `watched_wing_user_id` FOREIGN KEY (`wing_userid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_german2_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of watched
-- ----------------------------
INSERT INTO `watched` VALUES ('201701020124', '201701020124', '2019-07-03 23:05:37', '2019-07-03 23:05:39');
INSERT INTO `watched` VALUES ('201701020145', '201701020135', '2019-07-04 15:57:40', '2019-07-04 15:57:40');
INSERT INTO `watched` VALUES ('201701020135', '201701020145', '2019-07-07 00:00:00', '2019-07-09 00:00:00');
INSERT INTO `watched` VALUES ('123456', '123456', NULL, NULL);
INSERT INTO `watched` VALUES ('201701020124', '123456', '2019-07-06 16:35:19', NULL);
INSERT INTO `watched` VALUES ('201701020124', '123456', '2019-07-06 18:42:49', NULL);
INSERT INTO `watched` VALUES ('201701020124', '123456', '2019-07-06 18:44:50', NULL);

-- ----------------------------
-- Triggers structure for table article
-- ----------------------------
DROP TRIGGER IF EXISTS `uptime`;
delimiter ;;
CREATE TRIGGER `uptime` BEFORE INSERT ON `article` FOR EACH ROW SET new.arctime=NOW()
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table article_colect
-- ----------------------------
DROP TRIGGER IF EXISTS `coltime_update`;
delimiter ;;
CREATE TRIGGER `coltime_update` BEFORE INSERT ON `article_colect` FOR EACH ROW SET new.col_time=NOW()
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table watched
-- ----------------------------
DROP TRIGGER IF EXISTS `warime_update`;
delimiter ;;
CREATE TRIGGER `warime_update` BEFORE INSERT ON `watched` FOR EACH ROW SET new.wa_time=NOW()
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
